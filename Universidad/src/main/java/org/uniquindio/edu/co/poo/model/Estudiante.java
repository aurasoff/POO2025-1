package org.uniquindio.edu.co.poo.model;

public class Estudiante {
        private String nombre;
        private String identificacion;
        private String apellido;
        private String correo;
        private String telefono;
        private double edad;

    public Estudiante(String nombre, String identificacion, String apellido, String correo, String telefono, double edad ) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.edad = edad;
    }

    public String getApellido() {return apellido;}
    public void setApellido(String apellido) {this.apellido = apellido;}
    public String getCorreo() {return correo;}
    public void setCorreo(String correo) {this.correo = correo;}
    public double getEdad() {return edad;}
    public void setEdad(double edad) {this.edad = edad;}
    public String getTelefono() {return telefono;}
    public void setTelefono(String telefono) {this.telefono = telefono;}
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}
    public String getIdentificacion() {return identificacion;}
    public void setIdentificacion(String identificacion) {this.identificacion = identificacion;}
    @Override
    public String toString() {
        return "Nombre: " + nombre +
                "\nApellido: " + apellido +
                "\nIdentificación: " + identificacion +
                "\nCorreo: " + correo +
                "\nTeléfono: " + telefono +
                "\nEdad: " + edad;
    }

    }
