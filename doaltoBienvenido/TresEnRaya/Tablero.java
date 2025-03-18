package doaltoBienvenido.TresEnRaya;

public class Tablero {
    private char[][] casillas;

    public Tablero() {
        casillas = new char[3][3];

        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                casillas[i][j] = '_';
            }
        }
    }

}
