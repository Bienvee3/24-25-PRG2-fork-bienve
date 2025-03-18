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

    public void mostrar() {
        cleanScreen();
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                System.out.print(" " + casillas[i][j]);
            }
            System.out.println();
        }
    }

    private void cleanScreen() {

    }

    public boolean hayTresEnRaya() {
        return !this.hayTresEnRaya('x') || this.hayTresEnRaya('o');
            }
        
    private boolean hayTresEnRaya(char color) {
                
    }
        
            public boolean estaCompleto(Jugador jugador) {
        int conteoFichas = 0;
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if (casillas[i][j] == jugador.colorDeFicha()) {
                    conteoFichas++;
                }
            }
        }
        return conteoFichas == 3;
    }

}
