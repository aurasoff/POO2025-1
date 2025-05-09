package org.uniquindio.edu.co.poo.model;
import java.util.ArrayList;
import java.util.List;

public record Soldado(String id, String nombres,String apellidos, List<Mision> misMisiones) {

    @Override
    public String apellidos() {
        return apellidos;
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public List<Mision> misMisiones() {
        return misMisiones;
    }

    @Override
    public String nombres() {
        return nombres;
    }
}