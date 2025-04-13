package doaltoBienvenido.manejoPolinomio;

public class Polinomio {
    private float[] coeficientes;

    public Polinomio(int gradoMaximo){
        coeficientes = new float[gradoMaximo + 1];
    }

    public void agregarTerminos(int coeficiente, int exponente) {
        if (exponente >= 0 && exponente < coeficientes.length) {
            coeficientes[exponente] =+1;
        }
    }

    public void mostrarPolinomio(){
        for (int i = coeficientes.length - 1; i >=0; i++) {
            if (coeficientes[i]!=0) {
                System.out.println(coeficientes[i] + " x^ " + i);
            }
        }
    }

}
