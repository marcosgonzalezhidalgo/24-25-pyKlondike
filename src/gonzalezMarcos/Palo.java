package gonzalezMarcos;

public class Palo {

    private Carta[] cartas;
    private int ultima;

    public Palo() {
        cartas = new Carta[13]; // Un palo tiene hasta 13 cartas
        ultima = 0;
    }

    public void poner(Carta carta) {
        if (ultima < 13) {
            if (ultima == 0 && carta.getNumero() == 1) { // As
                cartas[ultima] = carta;
                ultima++;
            } else if (ultima > 0 && cartas[ultima - 1].getNumero() == carta.getNumero() - 1) {
                cartas[ultima] = carta;
                ultima++;
            } else {
                System.out.println("La carta no sigue la secuencia en el palo.");
            }
        } else {
            System.out.println("El palo ya está lleno.");
        }
    }

    public void mostrar() {
        System.out.println("Cartas en el palo:");
        for (int i = 0; i < ultima; i++) {
            cartas[i].mostrar();
        }
    }

    public boolean vacio() {
        return ultima == 0;
    }

    public Carta cima() {
        if (ultima > 0) {
            return cartas[ultima - 1];
        } else {
            return null;
        }
    }

    public void moverA(Columna columna) {
        if (ultima > 0) {
            Carta carta = cartas[ultima - 1];
            ultima--;
            columna.poner(carta);
        } else {
            System.out.println("El palo está vacío.");
        }
    }
}
