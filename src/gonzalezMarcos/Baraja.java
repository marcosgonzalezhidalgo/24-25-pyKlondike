package gonzalezMarcos;

class Baraja {
    private Carta[] cartas;
    private int indiceActual;
    private static final int TOTAL_CARTAS = 52;

    public Baraja() {
        cartas = new Carta[TOTAL_CARTAS];
        inicializarBaraja();
        indiceActual = 0;
    }

    private void inicializarBaraja() {
        int contador = 0;
        for (int palo = 0; palo < 4; palo++) {
            for (int numero = 1; numero <= 13; numero++) {
                cartas[contador++] = new Carta(palo, numero);
            }
        }
    }

    public void barajar() {
        for (int i = TOTAL_CARTAS - 1; i > 0; i--) {
            int j = (int)(System.nanoTime() % (i + 1));
            Carta temp = cartas[i];
            cartas[i] = cartas[j];
            cartas[j] = temp;
        }
        indiceActual = 0;
    }

    public Carta sacar() {
        return indiceActual < TOTAL_CARTAS ? cartas[indiceActual++] : null;
    }

    public boolean vacia() {
        return indiceActual >= TOTAL_CARTAS;
    }
}
