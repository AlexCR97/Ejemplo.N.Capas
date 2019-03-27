package CapaNegocios.lectores;

import CapaDatos.repositorios.RepositorioProfesor;
import CapaEntidades.Profesor;

import java.util.ArrayList;

public class LectorProfesor extends Lector<Profesor> {

    private RepositorioProfesor repositorio = new RepositorioProfesor();

    @Override
    public Profesor getEntidadId(Object id) {
        return repositorio.seleccionarId(id);
    }

    @Override
    public ArrayList<Profesor> getEntidades() {
        return repositorio.seleccionarTodo();
    }

}
