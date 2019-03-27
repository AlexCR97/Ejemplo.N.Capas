package CapaNegocios.validaciones;

import CapaEntidades.Profesor;

public class ValidacionProfesor extends Validacion<Profesor> {

    public ValidacionProfesor(Profesor e) {
        super(e);
    }

    @Override
    public boolean validar() {
        return validarId() && validarMatricula() && validarNombre() && validarApellidoPaterno() && validarApellidoMaterno() && validarSalario();
    }

    public boolean validarId() {
        return true;
    }

    public boolean validarMatricula() {
        return true;
    }

    public boolean validarNombre() {
        return true;
    }

    public boolean validarApellidoPaterno() {
        return true;
    }

    public boolean validarApellidoMaterno() {
        return true;
    }

    public boolean validarSalario() {
        return true;
    }

}
