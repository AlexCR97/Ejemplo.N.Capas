package CapaNegocios.escritores;

import CapaDatos.repositorios.RepositorioProfesor;
import CapaEntidades.Profesor;

public class EscritorProfesor extends Escritor<Profesor> {

    private RepositorioProfesor repositorio = new RepositorioProfesor();

    public EscritorProfesor(int operacion, Profesor profesor) {
        super(operacion, profesor);
    }

    public EscritorProfesor(int operacion, Profesor profesor, Profesor profesorCambio) {
        super(operacion, profesor, profesorCambio);
    }

    @Override
    public boolean ejecutarCambios() {
        if (operacion == OPERACION_ALTA)
            return repositorio.alta(entidad);

        if (operacion == OPERACION_BAJA)
            return repositorio.baja(entidad.getId());

        if (operacion == OPERACION_CAMBIO)
            return repositorio.cambio(entidad.getId(), entidadCambio);

        return false;
    }

}
