package CapaNegocios.validaciones;

public abstract class Validacion<Entidad> {

    private Entidad e;

    public Validacion(Entidad e) {
        this.e = e;
    }

    public abstract boolean validar();

}
