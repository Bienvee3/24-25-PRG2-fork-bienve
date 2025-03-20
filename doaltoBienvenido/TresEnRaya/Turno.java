package doaltoBienvenido.TresEnRaya;

public class Turno {

    private int turnoActual;

    public Turno(){
        turnoActual = 0;
    }

    public void cambiar() {
        turnoActual =+1 % 2;
    }
    
    public int leToca() {
        return turnoActual;
    }

    public int noLeToca() {
        return (turnoActual + 1) % 2;
    }

}
