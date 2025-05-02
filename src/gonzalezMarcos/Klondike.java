package gonzalezMarcos;

import java.io.Console;

public class Klondike {

    private Baraja baraja;
    private Palo[] palos;
    private Descarte descarte;
    private Columna[] columnas;

    private final int NUMERO_PALOS = 4;
    private final int NUMERO_COLUMNAS = 7;

    public Klondike() {
        baraja = new Baraja();
        descarte = new Descarte();
        palos = new Palo[NUMERO_PALOS];
        for (int palo = 0; palo < NUMERO_PALOS; palo++) {
            palos[palo] = new Palo();
        }
        columnas = new Columna[NUMERO_COLUMNAS];
        for (int columna = 0; columna < NUMERO_COLUMNAS; columna++) {
            columnas[columna] = new Columna(columna + 1, baraja);
        }
    }

    public void jugar() {
        boolean estaJugando = true;
        while (estaJugando) {
            Menu menu = new Menu();
            menu.imprimeOpciones();
            mostrarTapete();
            int opcionUsuario = menu.getOpcion();
            if (opcionUsuario == 1) {
                baraja.moverA(descarte);
            } else if (opcionUsuario == 2) {
                descarte.moverA(escogerPalo("A"));
            } else if (opcionUsuario == 3) {
                Columna unaColumna = escogerColumna("A");
                descarte.moverA(unaColumna);
            } else if (opcionUsuario == 4) {
                Palo unPalo = escogerPalo("De");
                Columna unaColumna = escogerColumna("A");
                unPalo.moverA(unaColumna);
            } else if (opcionUsuario == 5) {
                Columna unaColumna = escogerColumna("De");
                Palo unPalo = escogerPalo("A");
                unaColumna.moverA(unPalo);
            } else if (opcionUsuario == 6) {
                Columna unaColumna = escogerColumna("De");
                Columna otraColumna = escogerColumna("A");
                unaColumna.moverA(otraColumna);
            } else if (opcionUsuario == 7) {
                Columna unaColumna = escogerColumna("De");
                unaColumna.voltear();
            } else if (opcionUsuario == 8) {
                descarte.voltear(baraja);
            } else if (opcionUsuario == 9) {
                estaJugando = false;
            }

        }
    }

    private Columna escogerColumna(String prefijo) {
        int indiceColumna = escogerOpcion(prefijo, NUMERO_COLUMNAS, "que columna?");
        return columnas[indiceColumna - 1];
    }

    private Palo escogerPalo(String prefijo) {
        int indicePalo = escogerOpcion(prefijo, NUMERO_PALOS, "que palo?");
        return palos[indicePalo - 1];
    }

    private int escogerOpcion(String prefijo, int max, String mensaje) {
        Console console = new Console();
        console.readInt(prefijo + mensaje + "[1-" + max + "] ");

    }

    private void mostrarTapete() {
        Console console = new Console();
        baraja.mostrar();
        descarte.mostrar();
        for (int palo = 0; palo < NUMERO_PALOS; palo++) {
            console.writeln("Palo " + palo);
            palos[palo].mostrar();
        }
        for (int columna = 0; columna < NUMERO_COLUMNAS; columna++) {
            console.writeln("Columna " + columna);
            columnas[columna].mostrar();
        }
    }

    private void imprimirOpciones() {
        console.writeln("OPCIONES>");
        console.writeln("1. Mover de Baraja a Descarte");
        console.writeln("2. Mover de Descarte a Palo");
        console.writeln("3. Mover de Descarte a Columna");
        console.writeln("4. Mover de Palo a Columna");
        console.writeln("5. Mover de Columna a Palo");
        console.writeln("6. Mover de Columna a Columna");
        console.writeln("7. Voltear carta de Columna");
        console.writeln("8. Voltear Descarte en Baraja");
        console.writeln("9. Salir");
    }

}