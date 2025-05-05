package gonzalezMarcos;

public class Baraja {

    private Carta[] cartas;
    private int indiceActual;
    private static final int TOTAL_CARTAS = 52;

    public Baraja() {
        cartas = new Carta[TOTAL_CARTAS];  // Creamos un arreglo con 52 elementos
        inicializarBaraja();
        indiceActual = 0;  // El índice inicial está en la primera carta (no barajada)
    }

    // Inicializar la baraja con las cartas
    private void inicializarBaraja() {
        int contador = 0;
        for (int palo = 0; palo < 4; palo++) {
            for (int numero = 1; numero <= 13; numero++) {
                cartas[contador] = new Carta(palo, numero);
                contador++;
            }
        }
    }

    // Barajar las cartas sin usar Random
    public void barajar() {
        for (int i = TOTAL_CARTAS - 1; i > 0; i--) {
            // Usamos el tiempo actual en milisegundos para generar un índice "aleatorio"
            int j = (int)(System.currentTimeMillis() % (i + 1));  // Tiempo en milisegundos modificado para obtener un índice en el rango [0, i]
            // Intercambiar las cartas
            Carta temp = cartas[i];
            cartas[i] = cartas[j];
            cartas[j] = temp;
        }
        indiceActual = 0;  // Reiniciamos el índice al barajar
    }

    // Sacar una carta de la baraja
    public Carta sacar() {
        if (indiceActual < TOTAL_CARTAS) {
            return cartas[indiceActual++];  // Devuelve la carta y aumenta el índice
        } else {
            return null;  // No hay más cartas para sacar
        }
    }

    // Verificar si la baraja está vacía
    public boolean vacia() {
        return indiceActual >= TOTAL_CARTAS;
    }

    // Mostrar las cartas de la baraja (para depuración)
    public void mostrar() {
        for (int i = 0; i < TOTAL_CARTAS; i++) {
            cartas[i].mostrar();
        }
    }
}
