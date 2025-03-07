package entregas.doaltoBienvenido.reto003;

class Calculadora {

    private double[] numeros;
    private int posicionActual;
    private boolean error;
    private String mensajeError;
    static final private int CAPACIDAD_POR_DEFECTO = 10;

    public Calculadora() {
        this(CAPACIDAD_POR_DEFECTO);
    }

    public Calculadora(int capacidad) {
        numeros = new double[capacidad];
        posicionActual = 0;
        error = false;
        mensajeError = "";
    }

    public Calculadora(double valorInicial) {
        this(CAPACIDAD_POR_DEFECTO);
        ingresarNumero(valorInicial);
    }

    public Calculadora(double[] valoresIniciales) {
        this(valoresIniciales.length);
        for (int i = 0; i < valoresIniciales.length; i++) {
            ingresarNumero(valoresIniciales[i]);
        }
    }

    public void ingresarNumero(double valor) {
        if (posicionActual < numeros.length) {
            numeros[posicionActual] = valor;
            posicionActual++;
        } else {
            error = true;
            mensajeError = "MEMORIA LLENA!!!";
        }

    }

    public String mostrar() {
        if (error) {
            return mensajeError;
        } else if (posicionActual > 0) {
            return "" + numeros[posicionActual - 1];
        } else {
            return "-----";
        }
    }

    public String mostrarTodo() {
        String resultado = "";
        for (int i = 0; i < posicionActual; i++) {
            resultado = resultado + numeros[i] + "\n";
        }
        return error ? mensajeError : resultado;

    }

    public void limpiar() {
        numeros = new double[numeros.length];
        posicionActual = 0;
        error = !error;
        mensajeError = "";
    }

    public void sumar() {
        if (verficarOperandos(2)) {
            double[] operandos = extraerOperadores(2);
            ingresarNumero(operandos[0] + operandos[1]);
        }
    }

    public void restar() {
        invertir();
        sumar();
    }

    public void dividir() {
        if (verficarOperandos(2)) {
            double[] operandos = extraerOperadores(2);
            if (operandos[0] != 0) {
                ingresarNumero(operandos[1] / operandos[0]);
            } else {
                error = true;
                mensajeError = "No se puede dividir por 0";
            }
        }
    }

    public void multiplicar() {
        if (verficarOperandos(2)) {
            double[] operandos = extraerOperadores(2);
            for (int i = 0; i < operandos[0] - 1; i++) {
                ingresarNumero(operandos[i]);
            }
            calcularSumatoria();
        }
    }

    public void calcularSumatoria() {
        int numeroOperandos = posicionActual;
        for (int i = 0; i < numeroOperandos - 1; i++) {
            sumar();
        }
    }

    public double[] extraerOperadores(int numeroOperandos) {
        double[] operandos = new double[numeroOperandos];
        for (int i = 0; i < numeroOperandos; i++) {
            posicionActual = posicionActual - 1;
            operandos[1] = numeros[posicionActual];
        }
        return operandos;
    }

    public boolean verficarOperandos(int numeroOperandos) {
        if (posicionActual >= numeroOperandos) {
            return true;
        } else {
            error = true;
            mensajeError = "Faltan operandos!";
            return false;
        }
    }

    public void invertir() {
        if (verficarOperandos(1)) {
            double[] operando = extraerOperadores(1);
            ingresarNumero((operando[0] - (operando[0] + operando[0])));
        }
    }

    public void calcurarMedia() {
        int numeroDeOperandos = posicionActual;
        calcularSumatoria();
        ingresarNumero(numeroDeOperandos);
        dividir();
    }

    public void calcularPorcentaje() {
        final int PORCENTAJE = 100;
        if (verficarOperandos(2)) {
            double[] operandos = extraerOperadores(2);
            ingresarNumero((operandos[1] / PORCENTAJE) * operandos[0]);
        }
    }

    public void calcularFactorial() {
        if (verficarOperandos(1)) {
            double[] operando = extraerOperadores(1);
            int factorial = 1;
            for (int i = 1; i <= operando[0]; i++) {
                factorial *= i;
            }
            ingresarNumero(factorial);
        }
    }

    public void calcularMaximo() {
        double valorMaximo = numeros[0];
        for (int i = 1; i < posicionActual; i++) {
            if (numeros[i] > valorMaximo) {
                valorMaximo = numeros[i];
            }
        }
        limpiar();
        ingresarNumero(valorMaximo);
    }

    public void calcularMinimo() {
        double valorMinimo = numeros[0];
        for (int i = 1; i < posicionActual; i++) {
            if (numeros[i] < valorMinimo) {
                valorMinimo = numeros[i];
            }
        }
        limpiar();
        ingresarNumero(valorMinimo);
    }

    public void sumar(double valor) {
        ingresarNumero(valor);
        sumar();
    }

    public void restar(double valor) {
        ingresarNumero(valor);
        restar();
    }

    public void multiplicar(double valor) {
        ingresarNumero(valor);
        multiplicar();
    }

    public void dividir(double valor) {
        ingresarNumero(valor);
        dividir();
    }

    public void calcularPorcentaje(double valor) {
        ingresarNumero(valor);
        calcularPorcentaje();
    }

    public void intercambiar() {
        if (verficarOperandos(2)) {
            double[] operandos = extraerOperadores(2);
            ingresarNumero(operandos[1]);
            ingresarNumero(operandos[0]);
        }
    }

    public void duplicarNumero() {
        if (verficarOperandos(1)) {
            double[] operandos = extraerOperadores(1);
            ingresarNumero(operandos[0]);
            ingresarNumero(operandos[0]);
        }
    }

    public void calcularRaizCuadrada() {
        if (verficarOperandos(1)) {
            double[] operandos = extraerOperadores(1);
            if (operandos[0] >= 0) {
                ingresarNumero(Math.sqrt(operandos[0]));
            } else {
                error = true;
                mensajeError = "No se puede hacer raiz cuadrade de numeros negativos";
            }
        }
    }

    public void calcularPotencia() {
        if (verficarOperandos(2)) {
            double[] operandos = extraerOperadores(2);
            ingresarNumero(Math.pow(operandos[0], operandos[1]));
        }
    }

    public void calcularPotencia(double exponente) {
        ingresarNumero(exponente);
        calcularPotencia();
    }
}
