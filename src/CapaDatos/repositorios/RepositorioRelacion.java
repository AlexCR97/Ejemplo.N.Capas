package CapaDatos.repositorios;

public class RepositorioRelacion<Entidad> extends Repositorio {

    protected String sqlBajaEspecifica;
    protected String sqlSeleccionarTodosId;

    public RepositorioRelacion() {
        super();
    }

}
