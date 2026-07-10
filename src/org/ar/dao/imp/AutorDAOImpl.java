package org.ar.dao.imp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import otg.ar.dao.AutorDAO;
import org.ar.model.Autor;
import org.ar.util.Conexion;

public class AutorDAOImpl implements AutorDAO {

    @Override
    public boolean insertar(Autor autor) {
        return false;       
    }

    @Override
    public List<Autor> listarTodos() {

        List<Autor> autores = new ArrayList<>();

        String consulta = "{call sp_listarautores()}";

        try (
            Connection conexion = Conexion.getInstancia().conectar();
            CallableStatement cs = conexion.prepareCall(consulta);
            ResultSet rs = cs.executeQuery()
        ) {

            while (rs.next()) {

                Autor autor = new Autor();

autor.setId_autor(rs.getInt("id_autor"));
autor.setNombre_autor(rs.getString("nombre_autor"));
autor.setApellido_autor(rs.getString("apellido_autor"));
autor.setNacionalidad(rs.getString("nacionalidad"));
autor.setBiografia(rs.getString("biografia"));

                autores.add(autor);
            }

        } catch (Exception e) {
            System.err.println("Error al listar autores: " + e.getMessage());
        }

        return autores;
    }

    @Override
    public Autor buscar(int idAutor) {
        return null;
    }

    @Override
    public boolean actualizar(Autor autor) {
        return false;
    }

    @Override
    public boolean eliminar(int idAutor) {
        return false;
    }
}