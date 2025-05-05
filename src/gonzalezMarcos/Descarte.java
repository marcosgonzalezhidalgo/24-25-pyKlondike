package gonzalezMarcos;

class Descarte {
    private Carta[] cartas;
    private int ultima;

    public Descarte(int capacidad) {
        cartas = new Carta[capacidad];
        ultima = 0;
    }

    public void moverA(Columna columna) {
        if (ultima > 0) columna.poner(cartas[--ultima]);
    }

    public void moverA(Palo palo) {
        if (ultima > 0) palo.poner(cartas[--ultima]);
    }

    public void voltear(Baraja baraja) {
        if (!baraja.vacia()) {
            Carta carta = baraja.sacar();
            carta.voltear();
            cartas[ultima++] = carta;
        }
    }

    public void mostrar() {
        if (ultima == 0) {
            System.out.println("(vacío)");
        } else {
            for (int i = 0; i < ultima; i++) {
                cartas[i].mostrar();
            }
            System.out.println();
        }
    }
}

