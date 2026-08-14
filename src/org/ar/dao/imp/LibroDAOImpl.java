package org.ar.dao.imp;

import java.util.ArrayList;
import org.ar.model.Libro;
import otg.ar.dao.LibroDAO;

import org.ar.util.Conexion;
import java.util.List;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LibroDAOImpl implements LibroDAO {

    @Override
    public List<Libro> listarTodos() {
        List<Libro> libros = new ArrayList<>();
        String consulta = "{call sp_listarlibros()}";
        
        try (Connection conexion = Conexion.getInstancia().conectar(); CallableStatement consultaCall = conexion.prepareCall(consulta); ResultSet tablaResultado = consultaCall.executeQuery();) {
            while (tablaResultado.next()) {
                Date fecha = tablaResultado.getDate("fecha_publicacion");
                libros.add(new Libro(
                        tablaResultado.getString("isbn"),
                        tablaResultado.getString("titulo"),
                        fecha != null ? fecha.toLocalDate() : null,
                        tablaResultado.getBigDecimal("precio"),
                        (Integer) tablaResultado.getObject("id_categoria"),
                        tablaResultado.getString("nit_editorial")
                ));
            }
        } catch (SQLException e) {
            System.err.print("Error al listar Libros: " + e.getMessage());
        }

        return libros;
    }

    @Override
    public boolean crear(Libro libro) {
        String consulta = "{call sp_insertarlibro(?, ?, ?, ?, ?, ?)}";
        try (Connection conexion = Conexion.getInstancia().conectar();
             CallableStatement consultaCall = conexion.prepareCall(consulta)) {
            consultaCall.setString(1, libro.getIsbn());
            consultaCall.setString(2, libro.getTitulo());
            consultaCall.setDate(3, libro.getFechaPublicacion() != null ? Date.valueOf(libro.getFechaPublicacion()) : null);
            consultaCall.setBigDecimal(4, libro.getPrecio());
            consultaCall.setObject(5, libro.getIdCategoria());
            consultaCall.setString(6, libro.getNitEditorial());
            return consultaCall.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.print("Error al crear Libro: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Libro buscarPorId(String isbn) {
        //objeto
        Libro libro = new Libro();

        //consulta
        String consultaSQL = "{call sp_buscarlibro(?)}";
        //mapeamos el ResultSet al Objeto(Libro) segun sus atributos y la fila devulta
        try (Connection conexion = Conexion.getInstancia().conectar(); CallableStatement consultaCall = conexion.prepareCall(consultaSQL);) {
            consultaCall.setString(1, isbn);
            ResultSet tablaResultado = consultaCall.executeQuery();
            if (tablaResultado.next()) {
                Date fecha = tablaResultado.getDate("fecha_publicacion");
                libro.setIsbn(tablaResultado.getString("isbn"));
                libro.setTitulo(tablaResultado.getString("titulo"));
                libro.setFechaPublicacion(fecha != null ? fecha.toLocalDate() : null);
                libro.setPrecio(tablaResultado.getBigDecimal("precio"));
                libro.setIdCategoria((Integer) tablaResultado.getObject("id_categoria"));
                libro.setNitEditorial(tablaResultado.getString("nit_editorial"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            System.err.print("Error al buscar Libro: " + e.getMessage());
        }
        //retornamos el objeto
        return libro;
    }

    @Override
    public boolean actualizar(Libro libro) {
        return false;
    }

    @Override
    public boolean eliminar(String isbn) {
        return false;
    }

}
