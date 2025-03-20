package doaltoBienvenido.TresEnRaya;

import java.util.Scanner;

public class Coordenada {

    private int fila;
    private int columna;

    public Coordenada() {

    }

    public Coordenada(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }

    public int fila() {
        return fila;
    }

    public int columna() {
        return columna;
    }

    public void fila(int fila) {
        this.fila = fila;
    }

    public void columna(int columna) {
        this.columna = columna;
    }

    public String toString() {
        return fila + " , " + columna;
    }

    public boolean esValida() {
        return fila >= 0 && fila < 3 && columna >= 0 && columna < 3;
    }

    public void pedir() {
        Scanner scanner = new Scanner(System.in);

        boolean esCordenadaValida = false;

        do {
            System.out.println("Escriba una fila desde (0-2): ");
            fila = scanner.nextInt();

            System.out.println("Escriba una columna desde (0-2): ");
            columna = scanner.nextInt();
        } while (!esCordenadaValida);

        if (esValida()) {
            esCordenadaValida = true;
        } else {
            System.out.println("Cordenada Invalida");
        }
        
        scanner.close();
    }

}
