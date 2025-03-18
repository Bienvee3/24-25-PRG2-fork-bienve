package doaltoBienvenido.TresEnRaya;

public class TresEnRaya {
    Tablero tablero = new Tablero();
    Turno turno = new Turno();

    public void jugar() {
        do{
            tablero.mostrar();
            if (!tablero.estaCompleto(jugadores[turno.leToca()])) {
                jugadores[turno.leToca()].ponerFicha(tablero);
            } else {
                jugadores[turno.leToca()].moverFicha(tablero);
            }
            turno.cambiar();
        } while (!tablero.hayTresEnRaya());
        jugadores[turno.noLeToca()].celebrar();
    }

}
