package gonzalezMarcos;

class Palo {
    private Carta[] cartas;
    private int ultima;

    public Palo() {
        cartas = new Carta[13];
        ultima = 0;
    }

    public void poner(Carta carta) {
        if ((ultima == 0 && carta.getNumero() == 1) ||
            (ultima > 0 && cartas[ultima - 1].getNumero() == carta.getNumero() - 1)) {
            cartas[ultima++] = carta;
        }
    }

    public void moverA(Columna columna) {
        if (ultima > 0) columna.poner(cartas[--ultima]);
    }

    public void mostrar() {
        if (ultima == 0) {
            System.out.println("(vacío)");
        } else {
            cartas[ultima - 1].mostrar();
            System.out.println();
        }
    }

    public boolean vacio() {
        return ultima == 0;
    }

    public Carta cima() {
        return ultima > 0 ? cartas[ultima - 1] : null;
    }
}

