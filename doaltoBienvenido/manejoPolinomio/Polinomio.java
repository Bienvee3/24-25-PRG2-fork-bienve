package doaltoBienvenido.manejoPolinomio;

import java.util.Scanner;

public class Polinomio {
    private int[][] polinomios; 
    private int polinomiosIngresados = 0;
    private int gradoMaximo;
    private final int POLINOMIOS_MAXIMOS = 10; 

    public Polinomio(int gradoMaximo) {
        this.gradoMaximo = gradoMaximo;
        polinomios = new int[POLINOMIOS_MAXIMOS][gradoMaximo + 1]; 
    }

    public void ingresarPolinomio() {
        if (polinomiosIngresados >= POLINOMIOS_MAXIMOS) {
            System.out.println("No se pueden ingresar más polinomios. ");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de terminos del polinomio: ");
        int numTerminos = scanner.nextInt();

        for (int i = 0; i < numTerminos; i++) {
            System.out.println("Ingrese coeficiente y exponente del termino " + (i + 1) + ": ");
            int coeficienteTermino = scanner.nextInt();
            int exponenteTermino = scanner.nextInt();

            if (exponenteTermino >= 0 && exponenteTermino <= gradoMaximo) {
                polinomios[polinomiosIngresados][exponenteTermino] += coeficienteTermino;
            } else {
                System.out.println("Exponente fuera de rango (0 a " + gradoMaximo + ")");
            }
        }

        polinomiosIngresados++;
    }

    public void sumar() {
        int[] resultadoSuma = new int[gradoMaximo + 1];

        for (int i = 0; i < polinomiosIngresados; i++) {
            for (int j = 0; j <= gradoMaximo; j++) {
                resultadoSuma[j] += polinomios[i][j];
            }
        }
        mostrarPolinomio(resultadoSuma);
    }

    private void mostrarPolinomio(int[] coeficientes) {
        boolean primerTermino = true;

        for (int i = coeficientes.length - 1; i >= 0; i--) {
            int coeficienteMostrado = coeficientes[i];
            if (coeficienteMostrado != 0) {
                if (!primerTermino) {
                    System.out.print(coeficienteMostrado < 0 ? " - " : " + ");
                } else if (coeficienteMostrado < 0) {
                    System.out.print("-");
                }

                int abs = Math.abs(coeficienteMostrado);
                if (i == 0) {
                    System.out.print(abs);
                } else if (i == 1) {
                    System.out.print((abs == 1 ? "" : abs) + "x");
                } else {
                    System.out.print((abs == 1 ? "" : abs) + "x^" + i);
                }

                primerTermino = false;
            }
        }

        if (primerTermino) {
            System.out.print("0");
        }

        System.out.println();
    }
}
