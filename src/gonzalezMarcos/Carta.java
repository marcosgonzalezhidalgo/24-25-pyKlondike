package gonzalezMarcos;

public class Carta {
    private int palo;
    private int numero;
    private boolean volteada;

    public Carta(int palo, int numero) {
        this.palo = palo;
        this.numero = numero;
        this.volteada = false;
    }

    public int getPalo() {
        return palo;
    }

    public int getNumero() {
        return numero;
    }

    public boolean isVolteada() {
        return volteada;
    }

    public void voltear() {
        this.volteada = !this.volteada;
    }

    public void mostrar() {
        if (volteada) {
            String[] palos = {"Corazones", "Diamantes", "Tréboles", "Picas"};
            String[] numeros = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
            System.out.println(numeros[numero] + " de " + palos[palo]);
        } else {
            System.out.println("Carta volteada (no visible)");
        }
    }
}
