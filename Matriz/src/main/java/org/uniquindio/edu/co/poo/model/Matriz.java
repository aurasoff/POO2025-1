package org.uniquindio.edu.co.poo.model;

public class Matriz {
    private int filas;
    private int columnas;
    private int[][] matriz;
    public Matriz(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        matriz = new int[filas][columnas];
    }
    public int [][] girarMatrizDerecha(int[][] matriz) {
        int matrizEditada[][] = new int[columnas][filas];
        int indiceFila = 0;
        for (int i = 0; i < columnas; i++) {
            int indiceColumna = 0;
            for (int j = filas - 1; j >= 0; j--) {
                matrizEditada[indiceFila][indiceColumna] = matriz[j][i];
                indiceColumna++;
            }
            indiceFila++;
        }
        return matrizEditada;
    }
    public int[][] getMatriz() {
        return matriz;
    }
}