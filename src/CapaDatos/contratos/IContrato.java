package CapaDatos.contratos;

import java.util.ArrayList;

public interface IContrato<Entidad> {

    boolean alta(Entidad e);
    boolean baja(Object id);
    boolean cambio(Object id, Entidad e);
    Entidad seleccionarId(Object id);
    ArrayList<Entidad> seleccionarTodo();

}
