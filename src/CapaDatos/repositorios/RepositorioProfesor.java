package CapaDatos.repositorios;

import CapaDatos.contratos.IContrato;
import CapaEntidades.Profesor;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

public class RepositorioProfesor extends Repositorio implements IContrato<Profesor> {

    public RepositorioProfesor() {
        this.sqlAlta = "insert into Profesores values (?, ?, ?, ?, ?)";
        this.sqlBaja = "delete from Profesores where Id = ?";
        this.sqlCambio = "update Profesores set " +
                "Matricula = ?, " +
                "Nombre = ?, " +
                "ApellidoPaterno = ?, " +
                "ApellidoMaterno = ?, " +
                "Salario = ? " +
                "where Id = ?";
        this.sqlSeleccionarId = "select * from Profesores where Id = ?";
        this.sqlSeleccionarTodo = "select * from Profesores";
    }

    @Override
    public boolean alta(Profesor e) {
        parametros = new ArrayList<>();
        parametros.add(e.getMatricula());
        parametros.add(e.getNombre());
        parametros.add(e.getApellidoPaterno());
        parametros.add(e.getApellidoMaterno());
        parametros.add(e.getSalario());
        return ejecutarConsulta(sqlAlta);
    }

    @Override
    public boolean baja(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);
        return ejecutarConsulta(sqlBaja);
    }

    @Override
    public boolean cambio(Object id, Profesor e) {
        parametros = new ArrayList<>();
        parametros.add(e.getMatricula());
        parametros.add(e.getNombre());
        parametros.add(e.getApellidoPaterno());
        parametros.add(e.getApellidoMaterno());
        parametros.add(e.getSalario());
        parametros.add(id);
        return ejecutarConsulta(sqlCambio);
    }

    @Override
    public Profesor seleccionarId(Object id) {
        parametros = new ArrayList<>();
        parametros.add(id);

        resultado = ejecutarLectura(sqlSeleccionarId);

        try {
            resultado.next();

            int Id = resultado.getInt("Id");
            String Matricula = resultado.getString("Matricula");
            String Nombre = resultado.getString("Nombre");
            String ApellidoPaterno = resultado.getString("ApellidoPaterno");
            String ApellidoMaterno = resultado.getString("ApellidoMaterno");
            BigDecimal Salario = resultado.getBigDecimal("Salario");

            return new Profesor(Id, Matricula, Nombre, ApellidoPaterno, ApellidoMaterno, Salario);
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            try { if (resultado != null) resultado.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (sentencia != null) sentencia.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (bd.getConexion() != null) bd.getConexion().close(); } catch (SQLException e) { e.printStackTrace(); }
        }
    }

    @Override
    public ArrayList<Profesor> seleccionarTodo() {
        parametros = new ArrayList<>();

        resultado = ejecutarLectura(sqlSeleccionarTodo);
        ArrayList<Profesor> profesores = new ArrayList<>();

        try {
            while (resultado.next()) {
                int Id = resultado.getInt("Id");
                String Matricula = resultado.getString("Matricula");
                String Nombre = resultado.getString("Nombre");
                String ApellidoPaterno = resultado.getString("ApellidoPaterno");
                String ApellidoMaterno = resultado.getString("ApellidoMaterno");
                BigDecimal Salario = resultado.getBigDecimal("Salario");
                profesores.add(new Profesor(Id, Matricula, Nombre, ApellidoPaterno, ApellidoMaterno, Salario));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        finally {
            try { if (resultado != null) resultado.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (sentencia != null) sentencia.close(); } catch (SQLException e) { e.printStackTrace(); }
            try { if (bd.getConexion() != null) bd.getConexion().close(); } catch (SQLException e) { e.printStackTrace(); }
        }
        return profesores;
    }

}
