package gonzalezMarcos;

import java.util.*;

public class Klondike {

    private Baraja baraja;
    private Descarte descarte;
    private Palo[] palos;
    private Columna[] columnas;
    private boolean juegoTerminado;

    public Klondike() {
        this.baraja = new Baraja();
        this.descarte = new Descarte(24); // Capacidad del descarte
        this.palos = new Palo[4]; // Cuatro palos
        this.columnas = new Columna[7]; // Siete columnas en el solitario Klondike
        this.juegoTerminado = false;

        // Inicializamos los palos
        for (int i = 0; i < 4; i++) {
            palos[i] = new Palo();
        }

        // Inicializamos las columnas
        for (int i = 0; i < 7; i++) {
            columnas[i] = new Columna(7);
        }

        // Distribuimos las cartas en las columnas y la baraja
        distribuirCartas();
    }

    // Método para distribuir las cartas a las columnas y la baraja
    private void distribuirCartas() {
        // Barajamos y distribuimos cartas en las columnas
        baraja.barajar();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j <= i; j++) {
                Carta carta = baraja.sacar();
                columnas[i].poner(carta);
                if (j == i) {
                    carta.voltear(); // Volteamos la última carta de cada columna
                }
            }
        }
    }

    // Método para mover una carta de una columna a otra
    public void moverCarta() {
        Scanner scanner = new Scanner(System.in);

        // Mostrar columnas y elegir de dónde mover
        System.out.println("Elija una columna de origen (1-7): ");
        int origen = scanner.nextInt() - 1;

        // Mostrar columnas y elegir a dónde mover
        System.out.println("Elija una columna de destino (1-7): ");
        int destino = scanner.nextInt() - 1;

        // Mover la carta de la columna origen a la columna destino
        columnas[origen].moverA(columnas[destino]);
    }

    // Método para voltear una carta del mazo a la pila de descarte
    public void voltearCarta() {
        descarte.voltear(baraja);
    }

    // Mostrar estado del juego (columnas y palos)
    public void mostrarEstado() {
        System.out.println("Estado del juego:");

        // Mostrar columnas
        for (int i = 0; i < 7; i++) {
            System.out.print("Columna " + (i + 1) + ": ");
            columnas[i].mostrar();
        }

        // Mostrar descarte
        System.out.print("Descarte: ");
        descarte.mostrar();

        // Mostrar palos
        for (int i = 0; i < 4; i++) {
            System.out.print("Palo " + (i + 1) + ": ");
            palos[i].mostrar();
        }
    }

    // Verificar si el juego ha terminado (si todos los palos están completos)
    public boolean juegoTerminado() {
        for (Palo palo : palos) {
            if (palo.vacio() || palo.cima().getNumero() != 12) {
                return false;
            }
        }
        return true;
    }
}
