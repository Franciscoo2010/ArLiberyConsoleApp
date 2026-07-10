package org.ar.dao.imp;

import java.util.ArrayList;
import org.ar.model.Categoria;
import otg.ar.dao.CategoriDAO;

import org.ar.util.Conexion;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.List;
import java.sql.Connection;

public class CategoriaDAOImpl implements CategoriDAO {

    @Override
    public List<Categoria> listarTodos() {

        List<Categoria> categorias = new ArrayList<>();

        String consulta = "{call sp_listarclientes()}";

        try (
            Connection conexion = Conexion.getInstancia().conectar();
            CallableStatement consultaCall = conexion.prepareCall(consulta);
            ResultSet tablaResultado = consultaCall.executeQuery()
        ) {

            while (tablaResultado.next()) {

                categorias.add(new Categoria(
                    tablaResultado.getLong("cui"),
                    tablaResultado.getString("nombre_cliente"),
                    tablaResultado.getString("apellido_cliente"),
                    tablaResultado.getString("correo_electronico")
                ));

            }

        } catch (Exception e) {
            System.err.println("Error al listar Clientes: " + e.getMessage());
        }

        return categorias;
    }


    @Override
    public Categoria buscar(long cui) {
        return null;
    }


    @Override
    public Categoria buscarPorId(int id) {
        return buscar(id);
    }


    @Override
    public boolean actualizar(Categoria categoria) {
        return false;
    }


    @Override
    public boolean eliminar(long cui) {
        return false;
    }


    @Override
    public boolean insertar(Categoria categoria) {
        return false;
    }

}