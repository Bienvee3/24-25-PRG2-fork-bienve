package doaltoBienvenido.Calculadora;

class CalculadoraPOO {

    private double[] numeros;
    private int posicionActual;
    private boolean error;
    private String mensajeError;
    static final private int CAPACIDAD_POR_DEFECTO = 10;

    public CalculadoraPOO(){
        this(CAPACIDAD_POR_DEFECTO);
    }

    public CalculadoraPOO(int capacidad){
        numeros = new double[capacidad];
        posicionActual = 0;
        error = false;
        mensajeError = "";
    }

    public void ingresarNumero(double valor) {
        if (posicionActual<numeros.length) {
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
        } else if(posicionActual > 0) {
            return "" + numeros[posicionActual-1];
        }else{
            return "-----";
        }
    }

    public String mostrarTodo() {
        String resultado = "";
        for(int i=0;i<posicionActual; i++){
            resultado = resultado + numeros[i] + "\n";
        }
        return error?mensajeError:resultado;

    }

    public void limpiar() {
        numeros = new double[numeros.length];
        posicionActual=0;
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

    public void dividir(){
        if (verficarOperandos(2)) {
            double[] operandos = extraerOperadores(2);
            ingresarNumero(operandos[1] / operandos[0]);
        }
    }

    public void multiplicar(){
        if (verficarOperandos(2)) {
            double[] operandos = extraerOperadores(2);
            for(int i=0; i<operandos[0]-1; i++){
                ingresarNumero(operandos[i]);
            }
            calcularSumatoria();
        }
    }

    public void calcularSumatoria(){
        int numeroOperandos = posicionActual;
        for(int i = 0; i < numeroOperandos-1; i++){
            sumar();
        }
    }

    private double[] extraerOperadores(int numeroOperandos){
        double[] operandos = new double[numeroOperandos];
        for(int i = 0; i < numeroOperandos; i++)
        {
            posicionActual = posicionActual - 1;
            operandos[1] = numeros[posicionActual];
        }
        return operandos;
    }

    private boolean verficarOperandos(int numeroOperandos){
        if (posicionActual >= numeroOperandos) {
            return true;
        }else {
            error = true;
            mensajeError = "Faltan operandos!";
            return false;
        }
    }

    public void invertir(){
        if (verficarOperandos(1)) {
            double[] operando = extraerOperadores(1);
            ingresarNumero((operando[0] - (operando[0] + operando[0])));
        }
    }

    public void calcurarMedia(){
        int numeroDeOperandos = posicionActual;
        calcularSumatoria();
        ingresarNumero(numeroDeOperandos);
        dividir();
    }
}
