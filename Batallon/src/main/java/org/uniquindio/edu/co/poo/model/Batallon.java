package org.uniquindio.edu.co.poo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.uniquindio.edu.co.poo.model.Mision;


public class Batallon {
    private String numeroBatallon;
    private List<Vehiculo> listaVehiculos;
    private List<Mision> listaMisiones;
    private List<Soldado> listaSoldados;

    public Batallon(String numeroBatallon) {
        this.numeroBatallon = numeroBatallon;
        this.listaVehiculos = new ArrayList<>();
        this.listaMisiones = new ArrayList<>();
        this.listaSoldados = new ArrayList<>();
    }

    public void registrarSoldado(Soldado soldado1) {
        Optional<Soldado>optionalSoldado=buscarSoldado(soldado1.id());
        if (optionalSoldado.isPresent()) {
            throw new RuntimeException("El soldado ya existe");
        }
        listaSoldados.add(soldado1);
    }
    public Optional<Soldado> buscarSoldado(String id) {
        return listaSoldados.stream().filter(s->s.id().equals(id)).findFirst();
    }

    public ArrayList<Vehiculo> filtrarVehiculosMedicos() {
        ArrayList<Vehiculo> resultado = new ArrayList<>();
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo instanceof VehiculoApoyo vehiculoApoyo && vehiculoApoyo.getTipoDeFuncion() == 3) {
                resultado.add(vehiculoApoyo);
            }
        }
        return resultado;
    }

    public String agregarRecorrido(String id, int kilometrajeRecorrido) {
        Optional<Vehiculo> vehiculoEncontrado = buscarVehiculo(id);
        if (vehiculoEncontrado.isPresent()) {
            Vehiculo vehiculo = vehiculoEncontrado.get();
            vehiculo.setKilometraje(vehiculo.getKilometraje() + kilometrajeRecorrido);
            return "Kilometraje actualizado correctamente";
        }
        return "El vehículo no existe en la lista";
    }

    public ArrayList<Vehiculo> obtenerVehiculosEstadoDisponible() {
        ArrayList<Vehiculo> resultado = new ArrayList<>();
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getEstadoOperativo() == 1) {
                resultado.add(vehiculo);
            }
        }
        return resultado;
    }

    public ArrayList<Vehiculo> obtenerVehiculosSegunBlindaje(String blindajeBuscado) {
        ArrayList<Vehiculo> resultado = new ArrayList<>();
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo instanceof VehiculoBlindado vehiculoBlindado) {
                int nivelBlindaje = vehiculoBlindado.getNivelBlindaje();
                switch (blindajeBuscado.toLowerCase()) {
                    case "alto":
                        if (nivelBlindaje > 75) resultado.add(vehiculo);
                        break;
                    case "medio":
                        if (nivelBlindaje >= 45 && nivelBlindaje <= 55) resultado.add(vehiculo);
                        break;
                    case "bajo":
                        if (nivelBlindaje < 45) resultado.add(vehiculo);
                        break;
                }
            }
        }
        return resultado;
    }

    private Optional<Vehiculo> buscarVehiculo(String id) {
        return listaVehiculos.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst();
    }
    Optional<Vehiculo> buscarVehiculo2(String id) {
        return listaVehiculos.stream()
                .filter(v -> v.getId().equals(id))
                .findFirst();
    }


    public String registrarVehiculo(int tipoVehiculo, int extra, String id, String modelo, int anioFabricacion, int kilometraje, int estadoOperativo, int misionesCompletadas) {
        if (buscarVehiculo(id).isPresent()) {
            return "Vehículo ya existe en la lista de vehículos";
        }

        Vehiculo nuevoVehiculo;
        switch (tipoVehiculo) {
            case 1:
                nuevoVehiculo = new TransporteTropas(extra, id, modelo, anioFabricacion, kilometraje, estadoOperativo, misionesCompletadas);
                break;
            case 2:
                nuevoVehiculo = new VehiculoBlindado(extra, id, modelo, anioFabricacion, kilometraje, estadoOperativo, misionesCompletadas);
                break;
            case 3:
                nuevoVehiculo = new VehiculoApoyo(extra, id, modelo, anioFabricacion, kilometraje, estadoOperativo, misionesCompletadas);
                break;
            default:
                return "Tipo de Vehículo no existe";
        }

        listaVehiculos.add(nuevoVehiculo);
        return "Vehículo registrado correctamente";
    }

    public String editarVehiculo(String id, int tipoVehiculo, int extra, String modelo, int anioFabricacion, int kilometraje, int estadoOperativo, int misionesCompletadas) {
        Optional<Vehiculo> vehiculoEditarOpt = buscarVehiculo(id);
        if (vehiculoEditarOpt.isEmpty()) {
            return "Vehículo no existe";
        }

        Vehiculo vehiculoEditar = vehiculoEditarOpt.get();

        switch (tipoVehiculo) {
            case 1:
                if (vehiculoEditar instanceof TransporteTropas) {
                    ((TransporteTropas) vehiculoEditar).setCapacidadSoldadosTransportados(extra);
                }
                break;
            case 2:
                if (vehiculoEditar instanceof VehiculoBlindado) {
                    ((VehiculoBlindado) vehiculoEditar).setNivelBlindaje(extra);
                }
                break;
            case 3:
                if (vehiculoEditar instanceof VehiculoApoyo) {
                    ((VehiculoApoyo) vehiculoEditar).setTipoDeFuncion(extra);
                }
                break;
            default:
                return "Ese Tipo de Vehículo no existe";
        }

        vehiculoEditar.setModelo(modelo);
        vehiculoEditar.setAnioFabricacion(anioFabricacion);
        vehiculoEditar.setKilometraje(kilometraje);
        vehiculoEditar.setEstadoOperativo(estadoOperativo);
        vehiculoEditar.setMisionesCompletadas(misionesCompletadas);

        return "Vehículo editado correctamente";
    }

    public String mostrarVehiculoPorID(String id) {
        Optional<Vehiculo> vehiculoOpt = buscarVehiculo(id);
        return vehiculoOpt.map(Vehiculo::toString).orElse("Vehículo no encontrado");
    }

    public String mostrarListaVehiculos() {
        StringBuilder mensaje = new StringBuilder();
        for (Vehiculo vehiculo : listaVehiculos) {
            mensaje.append(vehiculo.toString()).append("\n");
        }
        return mensaje.toString();
    }

    public String actualizarNumeroMisiones(String id, int numeroMisionesActualizada) {
        Optional<Vehiculo> vehiculoActualizarMisiones = buscarVehiculo(id);
        if (vehiculoActualizarMisiones.isPresent()) {
            vehiculoActualizarMisiones.get().setMisionesCompletadas(numeroMisionesActualizada);
            return "Número de misiones actualizado correctamente";
        }
        return "Id del vehículo no encontrado";
    }

    public String actualizarEstadoOperativo(String id, int estadoOperativo) {
        Optional<Vehiculo> vehiculoActualizarEstadoOperativo = buscarVehiculo(id);
        if (vehiculoActualizarEstadoOperativo.isPresent()) {
            vehiculoActualizarEstadoOperativo.get().setEstadoOperativo(estadoOperativo);
            return "Estado Operativo actualizado correctamente";
        }
        return "Este ID de Vehículo no existe";
    }

    public String eliminarVehiculo(String id) {
        Optional<Vehiculo> vehiculoEliminarOpt = buscarVehiculo(id);
        if (vehiculoEliminarOpt.isPresent()) {
            listaVehiculos.remove(vehiculoEliminarOpt.get());
            return "Vehículo eliminado correctamente";
        }
        return "Vehículo no existe para eliminar";
    }

    public String obtenerVehiculosMas50Misiones() {
        ArrayList<Vehiculo> vehiculosMas50Misiones = new ArrayList<>();
        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getMisionesCompletadas() > 50) {
                vehiculosMas50Misiones.add(vehiculo);
            }
        }
        return vehiculosMas50Misiones.toString();
    }

    public String registrarMision(String id, String fechaMision, String ubicacionMision, int personalAsignado, int vehiculosUtilizados) {
        Mision nuevaMision = new Mision(id, fechaMision, ubicacionMision, personalAsignado, vehiculosUtilizados);
        listaMisiones.add(nuevaMision);
        return "Registro de la misión exitoso";
    }


    public String mostrarListaMisiones() {
        StringBuilder mensaje = new StringBuilder();
        for (Mision mision : listaMisiones) {
            mensaje.append(mision.toString()).append("\n");
        }
        return mensaje.toString();
    }

    public String getNumeroBatallon() {
        return numeroBatallon;
    }

    public void setNumeroBatallon(String numeroBatallon) {
        this.numeroBatallon = numeroBatallon;
    }

    public List<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(List<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public List<Mision> getListaMisiones() {
        return listaMisiones;
    }

    public void setListaMisiones(List<Mision> listaMisiones) {
        this.listaMisiones = listaMisiones;
    }
}
