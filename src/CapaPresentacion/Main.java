package CapaPresentacion;

import CapaEntidades.Profesor;
import CapaNegocios.escritores.EscritorProfesor;
import CapaNegocios.lectores.LectorProfesor;
import CapaNegocios.validaciones.ValidacionProfesor;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        /*private int id;
        private String matricula;
        private String nombre;
        private String apellidoPaterno;
        private String apellidoMaterno;
        private BigDecimal salario;
        */
        Profesor p = new Profesor(
                "asdasd",
                "Angel",
                "tal",
                "tal2",
                new BigDecimal(20000)
        );

        ValidacionProfesor validacion = new ValidacionProfesor(p);

        boolean validado = validacion.validar();
        if (!validado)
            return;

        EscritorProfesor escritor = new EscritorProfesor(EscritorProfesor.OPERACION_ALTA, p);
        validado = escritor.ejecutarCambios();

        if (!validado)
            return;

        LectorProfesor lector = new LectorProfesor();
        ArrayList<Profesor> profesores = lector.getEntidades();

        for (Profesor i : profesores)
            System.out.println(i);
    }

}
