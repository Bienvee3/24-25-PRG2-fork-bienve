package doaltoBienvenido.manejoPolinomio;



class Launcher {
    public static void main(String[] args) {
        Polinomio polinomio = new Polinomio(5);

        polinomio.ingresarPolinomio();
        polinomio.ingresarPolinomio();
        System.out.println("La suma es: ");
        polinomio.sumar();
    }  
}
