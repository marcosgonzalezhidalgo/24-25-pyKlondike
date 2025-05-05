package gonzalezMarcos;

public class Descarte {

    private Carta[] cartas;
    private int ultima;

    public Descarte(int capacidad) {
        cartas = new Carta[capacidad];
        ultima = 0;
    }

    public void moverA(Columna unaColumna) {
        if (ultima > 0) {
            Carta carta = cartas[ultima - 1];
            ultima--;
            unaColumna.poner(carta);
        } else {
            System.out.println("El descarte está vacío.");
        }
    }

    public void moverA(Palo palo) {
        if (ultima > 0) {
            Carta carta = cartas[ultima - 1];
            ultima--;
            palo.poner(carta);
        } else {
            System.out.println("El descarte está vacío.");
        }
    }

    public void voltear(Baraja baraja) {
        if (!baraja.vacia()) {
            Carta carta = baraja.sacar();
            carta.voltear();
            cartas[ultima] = carta;
            ultima++;
        } else {
            System.out.println("La baraja está vacía, no se puede voltear.");
        }
    }

    public void mostrar() {
        if (ultima == 0) {
            System.out.println("El descarte está vacío.");
        } else {
            System.out.println("Cartas en el descarte:");
            for (int i = 0; i < ultima; i++) {
                cartas[i].mostrar();
            }
        }
    }
}
