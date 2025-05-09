package org.uniquindio.edu.co.poo.model;

public class Persona {
    private String nombre;
    private String id;
    private String cargo;

    public Persona(String nombre,String id,String cargo){
        this.nombre=nombre;
        this.id=id;
        this.cargo=cargo;
    }
    public String getNombre() {return nombre;}
    public String getId() {return id;}
    public String getCargo() {return cargo;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setId(String id) {this.id = id;}
    public void setCargo(String cargo) {this.cargo = cargo;}

}
