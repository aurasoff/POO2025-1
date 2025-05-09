package org.uniquindio.edu.co.poo.model;

public class Circulo extends Figura {
    private double radio;
    public Circulo(double radio) {
        this.radio=radio;
    }

    public double calcularArea() {
        return Math.PI*radio*radio;

    }

    @Override
    public double calcularPerimetro() {
        return 2*Math.PI*radio;
    }
}
