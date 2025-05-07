package org.uniquindio.edu.co.poo.model;
import java.util.ArrayList;
import java.util.Optional;
import java.util.List;

public class Universidad {
       private String nombre;
       private String ubicacion;
       private List<Estudiante> listaEstudiantes;

       public Universidad(String universidadDelQuindío, String armenia){
              this.nombre = nombre;
              this.ubicacion = ubicacion;
              this.listaEstudiantes = new ArrayList<>();
       }

       public List<Estudiante> getListaEstudiantes() {return listaEstudiantes;}

       public void setListaEstudiantes(List<Estudiante> listaEstudiantes) {this.listaEstudiantes = listaEstudiantes;}

       public void agregarEstudiante (Estudiante estudiante){
              Optional<Estudiante> optionalEstudiante = buscarEstudiante(estudiante.getIdentificacion());
              if(optionalEstudiante.isPresent()){
                     throw  new  RuntimeException("Estudiante ya existe");
              }
              listaEstudiantes.add(estudiante);

       }
       public Optional<Estudiante>buscarEstudiante(String identificacion){
              return listaEstudiantes.stream().filter(e-> e.getIdentificacion().equals(identificacion)).findFirst();
       }

       public void mostrarEstudiantes(){
              if(listaEstudiantes.isEmpty()){
                     System.out.println("Estudiantes no encontrados");
              }else{
                     System.out.println("Estudiantes encontrados");
              }
       }


}
