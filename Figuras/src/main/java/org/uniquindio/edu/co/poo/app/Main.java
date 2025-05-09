package org.uniquindio.edu.co.poo.app;
import org.uniquindio.edu.co.poo.model.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
        public static void main(String[] args) {
            List<Figura> figuras = new ArrayList<>();

            figuras.add(new Circulo(3));
            figuras.add(new Cuadrado(4));
            figuras.add(new TrianguloEquilatero(5));

            for (Figura figura : figuras) {
                System.out.println("Figura: " + figura.getClass().getSimpleName());
                System.out.println("Área: " + figura.calcularArea());
                System.out.println("Perímetro: " + figura.calcularPerimetro());
                System.out.println("-------------------------");
            }
        }
    }


