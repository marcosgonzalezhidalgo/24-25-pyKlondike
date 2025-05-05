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
        this.descarte = new Descarte(24); 
        this.palos = new Palo[4]; 
        this.columnas = new Columna[7]; 
        this.juegoTerminado = false;

        for (int i = 0; i < 4; i++) {
            palos[i] = new Palo();
        }

        for (int i = 0; i < 7; i++) {
            columnas[i] = new Columna(7);
        }

        distribuirCartas();
    }

    private void distribuirCartas() {
        baraja.barajar();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j <= i; j++) {
                Carta carta = baraja.sacar();
                columnas[i].poner(carta);
                if (j == i) {
                    carta.voltear(); 
                }
            }
        }
    }

    public void moverCarta() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Elija una columna de origen (1-7): ");
        int origen = scanner.nextInt() - 1;

        System.out.println("Elija una columna de destino (1-7): ");
        int destino = scanner.nextInt() - 1;

        columnas[origen].moverA(columnas[destino]);
    }

    public void voltearCarta() {
        descarte.voltear(baraja);
    }

    public void mostrarEstado() {
        System.out.println("Estado del juego:");

        for (int i = 0; i < 7; i++) {
            System.out.print("Columna " + (i + 1) + ": ");
            columnas[i].mostrar();
        }

        System.out.print("Descarte: ");
        descarte.mostrar();

        for (int i = 0; i < 4; i++) {
            System.out.print("Palo " + (i + 1) + ": ");
            palos[i].mostrar();
        }
    }

    public boolean juegoTerminado() {
        for (Palo palo : palos) {
            if (palo.vacio() || palo.cima().getNumero() != 13) {
                return false;
            }
        }
        return true;
    }
}
