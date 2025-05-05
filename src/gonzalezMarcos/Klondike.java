package gonzalezMarcos;

class Klondike {
    private Baraja baraja;
    private Descarte descarte;
    private Palo[] palos;
    private Columna[] columnas;

    public Klondike() {
        this.baraja = new Baraja();
        this.descarte = new Descarte(24);
        this.palos = new Palo[4];
        this.columnas = new Columna[7];

        for (int i = 0; i < 4; i++) palos[i] = new Palo();
        for (int i = 0; i < 7; i++) columnas[i] = new Columna(20);

        distribuirCartas();
    }

    private void distribuirCartas() {
        baraja.barajar();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j <= i; j++) {
                Carta carta = baraja.sacar();
                columnas[i].poner(carta);
                if (j == i) carta.voltear();
            }
        }
    }

    public void voltearCarta() {
        descarte.voltear(baraja);
    }

    public void moverDescarteAPalo() {
        for (Palo palo : palos) {
            descarte.moverA(palo);
        }
    }

    public void moverDescarteAColumna() {
        for (Columna columna : columnas) {
            descarte.moverA(columna);
        }
    }

    public void moverPaloAColumna() {
        for (Palo palo : palos) {
            for (Columna columna : columnas) {
                palo.moverA(columna);
            }
        }
    }

    public void moverColumnaAPalo() {
        for (Columna columna : columnas) {
            for (Palo palo : palos) {
                columna.moverA(palo);
            }
        }
    }

    public void moverColumnaAColumna() {
        for (int i = 0; i < columnas.length; i++) {
            for (int j = 0; j < columnas.length; j++) {
                if (i != j) columnas[i].moverA(columnas[j]);
            }
        }
    }

    public void voltearCartaColumna() {
        for (Columna columna : columnas) {
            columna.voltearUltima();
        }
    }

    public void mostrarEstado() {
        System.out.print("\nBARAJA: ");
        System.out.println(baraja.vacia() ? "[]" : "[? ?]");

        System.out.print("Descarte: ");
        descarte.mostrar();

        for (int i = 0; i < 4; i++) {
            System.out.print((i + 1) + "º Palo: ");
            if (palos[i].vacio()) {
                System.out.println("No hay cartas en el palo");
            } else {
                palos[i].mostrar();
            }
        }

        for (int i = 0; i < 7; i++) {
            System.out.print("Columna [" + (i + 1) + "]: ");
            columnas[i].mostrar();
        }
    }

    public boolean juegoTerminado() {
        for (Palo palo : palos) {
            if (palo.vacio() || palo.cima().getNumero() != 13) return false;
        }
        return true;
    }
}