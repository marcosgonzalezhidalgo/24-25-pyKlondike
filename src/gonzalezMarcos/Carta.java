package gonzalezMarcos;

public class Carta {
    private int palo; 
    private int numero; 
    private boolean volteada;

    public Carta(int palo, int numero) {
        if (palo >= 0 && palo <= 3) {
            this.palo = palo;
        } else {
            this.palo = -1; 
        }

        if (numero >= 0 && numero <= 12) {
            this.numero = numero;
        } else {
            this.numero = -1; 
        }

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
            if (numero >= 0 && numero <= 12 && palo >= 0 && palo <= 3) {
                String[] palos = {"♥️", "♦️", "♣️", "♠️"};
                String[] numeros = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
                System.out.print(numeros[numero] + " " + palos[palo] + " ");
            } else {
                System.out.print("[? ?] ");  
            }
        } else {
            System.out.print("[? ?] "); 
        }
    }
}
