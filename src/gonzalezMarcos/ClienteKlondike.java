package gonzalezMarcos;

import java.util.Scanner;

public class ClienteKlondike {
    public static void main(String[] args) {
        Klondike klondike = new Klondike();
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);

        while (!klondike.juegoTerminado()) {
            menu.imprimeOpciones();
            klondike.mostrarEstado();

            System.out.print("\nElige una opción  [1-9]: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> klondike.voltearCarta();
                case 2 -> klondike.moverDescarteAPalo();
                case 3 -> klondike.moverDescarteAColumna();
                case 4 -> klondike.moverPaloAColumna();
                case 5 -> klondike.moverColumnaAPalo();
                case 6 -> klondike.moverColumnaAColumna();
                case 7 -> klondike.voltearCartaColumna();
                case 8 -> klondike.voltearCarta();
                case 9 -> {
                    System.out.println("Gracias por jugar!");
                    return;
                }
                default -> System.out.println("Opción inválida.");
            }
            scanner.close();
        }
        System.out.println("¡Felicidades! Has completado el solitario.");
    }
}