
package org.ar.dao.imp;

import java.util.ArrayList;
import org.ar.model.Clientes;
import otg.ar.dao.ClienteDAO;
import org.ar.util.Conexion;
import java.sql.CallableStatement;
import java.sql.ResultSet;

import java.util.List;
import java.sql.Connection;

public class ClienteDAOImpl implements ClienteDAO{

    @Override
    public boolean insertar(Clientes cliente) {
        return false;
    }

    @Override
    public List<Clientes> listarTodos() {
        //crear una lista
        List<Clientes> clientes = new ArrayList<>(); //null
        //crear nuestra consulta
        String consulta = "{call sp_listarclientes()}";
        //mapear el resultado de la consulta a objeto y lo agregamos a la lista
         //try with recources / intentar con recursos -> cierra el recurso al completar el intento
            try(
                    Connection conexion = Conexion.getInstancia().conectar();
                    CallableStatement consultaCall = conexion.prepareCall(consulta);
                    ResultSet tablaResultado = consultaCall.executeQuery()){
                while (tablaResultado.next()){
                    clientes.add(new Clientes(
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
    public Clientes buscar(long cui) {
        return null;
    }

    @Override
    public boolean actualizar(Clientes cliente) {
        return false;
    }

    @Override
    public boolean eliminar(long cui) {
        return false;
    }

    
   
    
    
}
