package doaltoBienvenido.manejoPolinomio;

public class Polinomio {
    private int[] coeficientes;

    public Polinomio(int gradoMaximo) {
        coeficientes = new int[gradoMaximo + 1];
    }

    public void agregarTerminos(int coeficiente, int exponente) {
        if (exponente >= 0 && exponente < coeficientes.length) {
            coeficientes[exponente] += coeficiente;
        }
    }

    public void mostrarPolinomio() {
        boolean primerTermino = true;
        int coeficiente2;
    
        for (int i = coeficientes.length - 1; i >= 0; i--) {
            coeficiente2 = coeficientes[i];
    
            if (coeficiente2 != 0) {
                int valorAbsoluto = Math.abs(coeficiente2);
    
                if (primerTermino) {
                    if (coeficiente2 < 0) {
                        System.out.print("-");
                    }
                } else {
                    System.out.print(coeficiente2 < 0 ? " - " : " + ");
                }
    
                if (i == 0) {
                    System.out.print(valorAbsoluto);
                } else if (i == 1) {
                    System.out.print((valorAbsoluto == 1 ? "" : valorAbsoluto) + "x");
                } else {
                    System.out.print((valorAbsoluto == 1 ? "" : valorAbsoluto) + "x^" + i);
                }
    
                primerTermino = false;
            }
        }
    
        if (primerTermino) {
            System.out.print(0);
        }
    
        System.out.println();
    }
}
