package org.ar.dao.imp;

import java.util.ArrayList;
import org.ar.model.Categoria;
import otg.ar.dao.CategoriDAO;
import org.ar.util.Conexion;
import java.sql.CallableStatement;
import java.sql.ResultSet;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;

public class CategoriaDAOImpl implements CategoriDAO {

    @Override
    public boolean insertar(Categoria categoria) {

        String consulta = "{call sp_insertarcategoria(?)}";

        try (
                Connection conexion = Conexion.getInstancia().conectar(); CallableStatement consultaCall = conexion.prepareCall(consulta)) {

            consultaCall.setString(1, categoria.getNombre());
            consultaCall.execute();

            return true;

        } catch (SQLException e) {
            System.out.println("Error al insertar categoria: " + e.getMessage());
        }

        return false;
    }

    @Override
    public List<Categoria> listarTodos() {

        List<Categoria> categorias = new ArrayList<>();

        String consulta = "{call sp_listarcategorias()}";

        try (
                Connection conexion = Conexion.getInstancia().conectar(); CallableStatement consultaCall = conexion.prepareCall(consulta); ResultSet tablaResultado = consultaCall.executeQuery()) {

            while (tablaResultado.next()) {

                Categoria categoria = new Categoria();

                categoria.setId(tablaResultado.getInt("id_categoria"));
                categoria.setNombre(tablaResultado.getString("nombre_categoria"));

                categorias.add(categoria);
            }

        } catch (Exception e) {
            System.out.println("Error al listar categorias: " + e.getMessage());
        }

        return categorias;
    }

    public Categoria buscar(int id) {

        Categoria categoria = new Categoria();

        String consultaSQL = "{call sp_buscarcategoria(?)}";

        try (
                Connection conexion = Conexion.getInstancia().conectar(); CallableStatement consultaCall = conexion.prepareCall(consultaSQL);) {

            consultaCall.setInt(1, id);

            ResultSet tablaResultado = consultaCall.executeQuery();

            if (tablaResultado.next()) {

                categoria.setId(tablaResultado.getInt("id_categoria"));
                categoria.setNombre(tablaResultado.getString("nombre_categoria"));

            } else {
                return null;
            }

        } catch (SQLException e) {
            System.err.println("Error al buscar categoria: " + e.getMessage());
        }

        return categoria;
    }

    @Override
    public boolean actualizar(Categoria categoria) {

        String consulta = "{call sp_actualizarcategoria(?, ?)}";

        try (
                Connection conexion = Conexion.getInstancia().conectar(); CallableStatement consultaCall = conexion.prepareCall(consulta)) {

            consultaCall.setInt(1, categoria.getId());
            consultaCall.setString(2, categoria.getNombre());
            consultaCall.execute();

            return true;

        } catch (SQLException e) {
            System.out.println("Error al actualizar categoria: " + e.getMessage());
        }

        return false;
    }

    @Override
    public boolean eliminar(int id) {

        String consulta = "{call sp_eliminarcategoria(?)}";

        try (
                Connection conexion = Conexion.getInstancia().conectar(); CallableStatement consultaCall = conexion.prepareCall(consulta)) {

            consultaCall.setInt(1, id);
            consultaCall.execute();

            return true;

        } catch (SQLException e) {
            System.out.println("Error al eliminar categoria: " + e.getMessage());
        }

        return false;
    }

    @Override
    public Categoria buscarPorId(int id) {
        return buscar(id);
    }

}
