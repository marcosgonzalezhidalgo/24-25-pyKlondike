package gonzalezMarcos;

import java.util.Scanner;

public class ClienteKlondike {
    public static void main(String[] args) {
        Klondike klondike = new Klondike();
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Bienvenido al Solitario Klondike!");
        klondike.mostrarEstado();

        while (!klondike.juegoTerminado()) {
            System.out.println("Seleccione una acción:");
            System.out.println("1. Mover carta");
            System.out.println("2. Voltear una carta del mazo");
            System.out.println("3. Ver estado del juego");
            System.out.println("4. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    klondike.moverCarta();
                case 2:
                    klondike.voltearCarta();
                case 3:
                    klondike.mostrarEstado();
                case 4:
                    System.out.println("Gracias por jugar!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
