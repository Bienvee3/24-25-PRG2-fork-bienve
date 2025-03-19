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
        return this.hayTresEnRaya('x') || this.hayTresEnRaya('o');
    }

    private boolean hayTresEnRaya(char color) {
        int[] filas = new int[3];
        int[] columnas = new int[3];
        int diagonalPrincipal = 0;
        int diagonalSecundaria = 0;
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if (color == casillas[i][j]) {
                    filas[i]++;
                    columnas[j]++;
                    diagonalPrincipal = diagonalPrincipal + ((i == j) ? 1 : 0);
                    diagonalSecundaria = diagonalSecundaria + ((i + j == 2) ? 1 : 0);

                    if (filas[i] == 3 || columnas[j] == 3 || diagonalPrincipal == 3 || diagonalSecundaria == 3) {
                        return true;
                    }

                }
            }
        }
        return false;
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

    public boolean estaOcupado(Coordenada coordenada) {
        
    }

    public void ponerFicha(Coordenada coordenada, char color) {
        
    }

    public void sacarFicha(Coordenada coordenada) {
        
    }

    public boolean estaVacio(Coordenada coordenada) {
        
    }

}
