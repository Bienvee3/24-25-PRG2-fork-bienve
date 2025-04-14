package doaltoBienvenido.manejoPolinomio;

class Launcher {
    public static void main(String[] args) {
        Polinomio polinomio = new Polinomio(5);
        polinomio.agregarTerminos(-2, 2);
        polinomio.agregarTerminos(-10, 1);
        polinomio.agregarTerminos(-5, 0);
        polinomio.mostrarPolinomio();
    }  
}
