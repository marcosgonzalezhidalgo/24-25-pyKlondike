package gonzalezMarcos;

public class Columna {
    private Carta[] cartas;
    private int ultima;

    public Columna(int capacidad) {
        cartas = new Carta[capacidad];
        ultima = 0;
    }

    public void poner(Carta carta) {
        if (ultima < cartas.length) {
            cartas[ultima] = carta;
            ultima++;
        } else {
            System.out.println("La columna está llena.");
        }
    }

    public void moverA(Columna otraColumna) {
        if (ultima > 0) {
            Carta carta = cartas[ultima - 1];
            ultima--;
            otraColumna.poner(carta);
        } else {
            System.out.println("La columna está vacía.");
        }
    }

    public void mostrar() {
        System.out.println("Columna:");
        if (ultima == 0) {
            System.out.println("La columna está vacía.");
        } else {
            for (int i = 0; i < ultima; i++) {
                cartas[i].mostrar();
            }
        }
    }

    public boolean vacia() {
        return ultima == 0;
    }
}
