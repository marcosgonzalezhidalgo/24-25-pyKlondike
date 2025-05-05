package gonzalezMarcos;

class Columna {
    private Carta[] cartas;
    private int ultima;

    public Columna(int capacidad) {
        cartas = new Carta[capacidad];
        ultima = 0;
    }

    public void poner(Carta carta) {
        cartas[ultima++] = carta;
    }

    public void moverA(Columna otra) {
        if (ultima > 0) {
            otra.poner(cartas[--ultima]);
        }
    }

    public void moverA(Palo palo) {
        if (ultima > 0) {
            palo.poner(cartas[--ultima]);
        }
    }

    public void voltearUltima() {
        if (ultima > 0 && !cartas[ultima - 1].isVolteada()) {
            cartas[ultima - 1].voltear();
        }
    }

    public void mostrar() {
        for (int i = 0; i < ultima; i++) {
            cartas[i].mostrar();
        }
        if (ultima == 0) System.out.print("(vacía)");
        System.out.println();
    }

    public boolean vacia() {
        return ultima == 0;
    }
}
