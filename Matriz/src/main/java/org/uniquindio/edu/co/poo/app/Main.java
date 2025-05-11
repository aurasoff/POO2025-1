package org.uniquindio.edu.co.poo.app;
import org.uniquindio.edu.co.poo.model.Matriz;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int filas = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero de  filas: "));
        int columnas = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero de columnas: "));
        Matriz matrizAux = new Matriz(filas, columnas);
        int matrizUsuario[][] = matrizAux.getMatriz();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matrizUsuario[i][j] = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese el valor de la cordenada "+i+" "+j+" De la matriz: "));
            }
        }
        JOptionPane.showMessageDialog(null, "Matriz normal\n"+imprimirMatriz(matrizUsuario, filas, columnas));
        int matrizGirada[][] = matrizAux.girarMatrizDerecha(matrizUsuario);
        JOptionPane.showMessageDialog(null, "Matriz girada\n"+imprimirMatriz(matrizGirada, columnas, filas));

    }
    public static String imprimirMatriz(int[][] m, int fila, int columna) {
        String resultado = "";
        for(int i = 0; i < fila; i++) {
            for(int j = 0; j < columna; j++) {
                resultado += m[i][j]+"  ";
            }
            resultado += "\n";
        }
        return resultado;
    }
}
