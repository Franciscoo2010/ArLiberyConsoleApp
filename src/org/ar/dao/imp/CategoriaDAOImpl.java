

package org.ar.dao.imp;
 
import java.util.ArrayList;
import org.ar.model.Categoria;
import otg.ar.dao.CategoriDAO;
 
import org.ar.util.Conexion;
import java.sql.CallableStatement;
import java.sql.ResultSet;

import java.util.List;
import java.sql.Connection;

public class CategoriaDAOImpl implements CategoriDAO{

    public List<Categoria> listar() {
        //crear una lista
        List<Categoria> categoria = new ArrayList<>(); //null
        //crear nuestra consulta
        String consulta = "{call sp_listarclientes()}";
        //mapear el resultado de la consulta a objeto y lo agregamos a la lista
         //try with recources / intentar con recursos -> cierra el recurso al completar el intento
            try(
                    Connection conexion = Conexion.getInstancia().conector();
                    CallableStatement consultaCall = conexion.prepareCall(consulta);
                    ResultSet tablaResultado = consultaCall.executeQuery()){
                while (tablaResultado.next()){
                    Categoria.add(new Categoria(
                            tablaResultado.getLong("cui"),
                            tablaResultado.getString("nombre_cliente"),
                            tablaResultado.getString("apellido_cliente"),
                            tablaResultado.getString("correo_electronico")
                    ));
                }
            } catch (Exception e){
                System.err.print("Error al listar Clientes" + e.getMessage());
                
            }
        return null;
    }

    @Override
    public Categoria buscar(long cui) {
        return null;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Categoria> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
