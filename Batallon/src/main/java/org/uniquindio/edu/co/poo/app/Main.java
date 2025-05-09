package org.uniquindio.edu.co.poo.app;

import org.uniquindio.edu.co.poo.model.Batallon;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Bienvenido al gestor de Batallón");
        String numeroBatallon = JOptionPane.showInputDialog("Ingrese el número del batallón: ");
        Batallon batallon1 = new Batallon(numeroBatallon);

        boolean salir = false;
        while (!salir) {
            String opcion = JOptionPane.showInputDialog(null,
                    "Seleccione una opción:\n" +
                            "1. Agregar Vehiculo\n" +
                            "2. Editar Vehiculo\n" +
                            "3. Mostrar Vehiculo por ID\n" +
                            "4. Mostrar lista de Vehiculos\n" +
                            "5. Actualizar número de misiones\n" +
                            "6. Actualizar estado del Vehículo\n" +
                            "7. Eliminar Vehiculo\n" +
                            "8. Mostrar Vehiculos con más de 50 misiones\n" +
                            "9. Registrar Misión\n" +
                            "10. Mostrar Misiones\n" +
                            "11. Salir", "Menú", JOptionPane.QUESTION_MESSAGE);

            if (opcion == null || opcion.equals("11")) {
                salir = true;
                continue;
            }

            switch (opcion) {
                case "1":
                    agregarVehiculo(batallon1);
                    break;

                case "2":
                    editarVehiculo(batallon1);
                    break;

                case "3":
                    mostrarVehiculoPorID(batallon1);
                    break;

                case "4":
                    mostrarListaVehiculos(batallon1);
                    break;

                case "5":
                    actualizarNumeroMisiones(batallon1);
                    break;

                case "6":
                    actualizarEstadoOperativo(batallon1);
                    break;

                case "7":
                    eliminarVehiculo(batallon1);
                    break;

                case "8":
                    mostrarVehiculosMas50Misiones(batallon1);
                    break;

                case "9":
                    registrarMision(batallon1);
                    break;

                case "10":
                    mostrarListaMisiones(batallon1);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Esta opción no está disponible.");
            }
        }
    }

    private static void agregarVehiculo(Batallon batallon) {
        int tipoDeVehiculo = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el tipo de vehiculo:\n(1) Transporte de Tropas\n(2) Vehiculo Blindado\n(3) Vehiculo de Apoyo"));
        String id = JOptionPane.showInputDialog("Ingrese la ID única del vehiculo");
        String modelo = JOptionPane.showInputDialog("Ingrese el modelo del vehiculo");
        int anioFabricacion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el año de fabricación del vehiculo"));
        int kilometraje = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el kilometraje del vehiculo"));
        int estadoOperativo = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el estado operativo del vehiculo:\n(1) Disponible\n(2) En Misión\n(3) En Mantenimiento"));
        int misionesCompletadas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de misiones completadas del vehiculo"));

        switch (tipoDeVehiculo) {
            case 1:
                int capacidadSoldados = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la capacidad de Soldados que tiene el vehiculo"));
                String mensaje1 = batallon.registrarVehiculo(tipoDeVehiculo, capacidadSoldados, id, modelo, anioFabricacion, kilometraje, estadoOperativo, misionesCompletadas);
                JOptionPane.showMessageDialog(null, mensaje1);
                break;
            case 2:
                int nivelBlindaje = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nivel de Blindaje del vehículo"));
                String mensaje2 = batallon.registrarVehiculo(tipoDeVehiculo, nivelBlindaje, id, modelo, anioFabricacion, kilometraje, estadoOperativo, misionesCompletadas);
                JOptionPane.showMessageDialog(null, mensaje2);
                break;
            case 3:
                int tipoFuncion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el tipo de función del vehículo:\n(1) LOGISTICA\n(2) COMUNICACIONES\n(3) MEDICO"));
                String mensaje3 = batallon.registrarVehiculo(tipoDeVehiculo, tipoFuncion, id, modelo, anioFabricacion, kilometraje, estadoOperativo, misionesCompletadas);
                JOptionPane.showMessageDialog(null, mensaje3);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Esta opción no está disponible.");
        }
    }

    private static void editarVehiculo(Batallon batallon) {
        String idEditada = JOptionPane.showInputDialog("Ingrese la ID única del vehiculo");
        int tipoDeVehiculoEditar = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el nuevo tipo de vehiculo:\n(1) Transporte de Tropas\n(2) Vehiculo Blindado\n(3) Vehiculo de Apoyo"));

        switch (tipoDeVehiculoEditar) {
            case 1:
                int nuevaCapacidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva capacidad de Soldados que tiene el vehiculo"));
                String modeloEditado1 = JOptionPane.showInputDialog("Ingrese el nuevo modelo del vehiculo");
                int anioFabricacionEditado1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo año de fabricación del vehiculo"));
                int kilometrajeEditado1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo kilometraje del vehiculo"));
                int estadoOperativoEditado1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo estado operativo del vehiculo:\n(1) Disponible\n(2) En Misión\n(3) En Mantenimiento"));
                int misionesCompletadasEditadas1 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad de misiones completadas del vehiculo"));
                String mensaje1 = batallon.editarVehiculo(idEditada, tipoDeVehiculoEditar, nuevaCapacidad, modeloEditado1, anioFabricacionEditado1, kilometrajeEditado1, estadoOperativoEditado1, misionesCompletadasEditadas1);
                JOptionPane.showMessageDialog(null, mensaje1);
                break;
            case 2:
                int nuevoNivelBlindaje = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo nivel de Blindaje del vehículo"));
                String modeloEditado2 = JOptionPane.showInputDialog("Ingrese el nuevo modelo del vehiculo");
                int anioFabricacionEditado2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo año de fabricación del vehiculo"));
                int kilometrajeEditado2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo kilometraje del vehiculo"));
                int estadoOperativoEditado2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo estado operativo del vehiculo:\n(1) Disponible\n(2) En Misión\n(3) En Mantenimiento"));
                int misionesCompletadasEditadas2 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad de misiones completadas del vehiculo"));
                String mensaje2 = batallon.editarVehiculo(idEditada, tipoDeVehiculoEditar, nuevoNivelBlindaje, modeloEditado2, anioFabricacionEditado2, kilometrajeEditado2, estadoOperativoEditado2, misionesCompletadasEditadas2);
                JOptionPane.showMessageDialog(null, mensaje2);
                break;
            case 3:
                int nuevoTipoFuncion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo tipo de función del vehículo:\n(1) LOGISTICA\n(2) COMUNICACIONES\n(3) MEDICO"));
                String modeloEditado3 = JOptionPane.showInputDialog("Ingrese el nuevo modelo del vehiculo");
                int anioFabricacionEditado3 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo año de fabricación del vehiculo"));
                int kilometrajeEditado3 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo kilometraje del vehiculo"));
                int estadoOperativoEditado3 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo estado operativo del vehiculo:\n(1) Disponible\n(2) En Misión\n(3) En Mantenimiento"));
                int misionesCompletadasEditadas3 = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad de misiones completadas del vehiculo"));
                String mensaje3 = batallon.editarVehiculo(idEditada, tipoDeVehiculoEditar, nuevoTipoFuncion, modeloEditado3, anioFabricacionEditado3, kilometrajeEditado3, estadoOperativoEditado3, misionesCompletadasEditadas3);
                JOptionPane.showMessageDialog(null, mensaje3);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Esta opción no está disponible.");
        }
    }

    private static void mostrarVehiculoPorID(Batallon batallon) {
        String idBuscar = JOptionPane.showInputDialog("Ingrese la ID única del vehiculo");
        String mensaje = batallon.mostrarVehiculoPorID(idBuscar);
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static void mostrarListaVehiculos(Batallon batallon) {
        String mensaje = batallon.mostrarListaVehiculos();
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static void actualizarNumeroMisiones(Batallon batallon) {
        String idBuscar = JOptionPane.showInputDialog("Ingrese la ID única del vehiculo");
        int misionesCompletadasActualizadas = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad de misiones completadas del vehiculo"));
        String mensaje = batallon.actualizarNumeroMisiones(idBuscar, misionesCompletadasActualizadas);
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static void actualizarEstadoOperativo(Batallon batallon) {
        String idCambiaEstado = JOptionPane.showInputDialog("Ingrese la ID del vehiculo para editar estado");
        int estadoActualizado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo estado operativo del vehiculo:\n(1) Disponible\n(2) En Misión\n(3) En Mantenimiento"));
        String mensaje = batallon.actualizarEstadoOperativo(idCambiaEstado, estadoActualizado);
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static void eliminarVehiculo(Batallon batallon) {
        String idParaEliminar = JOptionPane.showInputDialog("Ingrese la ID del vehiculo para eliminar");
        String mensaje = batallon.eliminarVehiculo(idParaEliminar);
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static void mostrarVehiculosMas50Misiones(Batallon batallon) {
        String mensaje = batallon.obtenerVehiculosMas50Misiones();
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static void registrarMision(Batallon batallon) {
        String idMision = JOptionPane.showInputDialog("Ingrese la ID de la mision");
        String fechaMision = JOptionPane.showInputDialog("Ingrese la fecha de la mision");
        String ubicacionMision = JOptionPane.showInputDialog("Ingrese la ubicación de la mision");
        int personalAsignado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de personal asignado"));
        int vehiculosUtilizados = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de vehiculos utilizados"));
        String mensaje = batallon.registrarMision(idMision, fechaMision, ubicacionMision, personalAsignado, vehiculosUtilizados);
        JOptionPane.showMessageDialog(null, mensaje);
    }

    private static void mostrarListaMisiones(Batallon batallon) {
        String mensaje = batallon.mostrarListaMisiones();
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
