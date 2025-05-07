package org.uniquindio.edu.co.poo.app;

import org.uniquindio.edu.co.poo.model.Estudiante;
import org.uniquindio.edu.co.poo.model.Universidad;

import javax.swing.*;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Universidad universidad = new Universidad("Universidad del Quindío", "Armenia");

        int opcion;

        do {
            String menu = """
                    --- Sistema de Gestión de Estudiantes ---
                    1. Agregar estudiante
                    2. Mostrar estudiantes
                    3. Buscar estudiante por ID
                    0. Salir
                    """;

            String input = JOptionPane.showInputDialog(null, menu, "Menú Principal", JOptionPane.PLAIN_MESSAGE);

            if (input == null) {
                break; // El usuario cerró la ventana
            }

            try {
                opcion = Integer.parseInt(input);

                switch (opcion) {
                    case 1 -> {
                        String nombre = JOptionPane.showInputDialog("Nombre:");
                        String apellido = JOptionPane.showInputDialog("Apellido:");
                        String id = JOptionPane.showInputDialog("Identificación:");
                        String correo = JOptionPane.showInputDialog("Correo:");
                        String telefono = JOptionPane.showInputDialog("Teléfono:");
                        String edadStr = JOptionPane.showInputDialog("Edad:");
                        double edad = Double.parseDouble(edadStr);

                        Estudiante nuevo = new Estudiante(nombre, id, apellido, correo, telefono, edad);
                        universidad.agregarEstudiante(nuevo);
                        JOptionPane.showMessageDialog(null, "¡Estudiante registrado exitosamente!");
                    }
                    case 2 -> {
                        StringBuilder lista = new StringBuilder();
                        if (universidad.getListaEstudiantes().isEmpty()) {
                            lista.append("No hay estudiantes registrados.");
                        } else {
                            for (Estudiante est : universidad.getListaEstudiantes()) {
                                lista.append(est).append("\n\n");
                            }
                        }
                        JOptionPane.showMessageDialog(null, lista.toString(), "Lista de Estudiantes", JOptionPane.INFORMATION_MESSAGE);
                    }
                    case 3 -> {
                        String idBuscar = JOptionPane.showInputDialog("Ingrese la identificación del estudiante:");
                        Optional<Estudiante> estudiante = universidad.buscarEstudiante(idBuscar);
                        if (estudiante.isPresent()) {
                            JOptionPane.showMessageDialog(null, estudiante.get().toString(), "Estudiante encontrado", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontró un estudiante con ese ID.");
                        }
                    }
                    case 0 -> JOptionPane.showMessageDialog(null, "¡Hasta luego!");
                    default -> JOptionPane.showMessageDialog(null, "Opción inválida.");
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor ingrese un número válido.");
                opcion = -1;
            } catch (RuntimeException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                opcion = -1;
            }

        } while (true);
    }
}
