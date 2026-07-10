
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

    List<Clientes> clientes = new ArrayList<>();

    String consulta = "{call sp_listarClientes()}";

    try (
        Connection conexion = Conexion.getInstancia().conectar();
        CallableStatement consultaCall = conexion.prepareCall(consulta);
        ResultSet tablaResultado = consultaCall.executeQuery()
    ) {

        while (tablaResultado.next()) {

            clientes.add(new Clientes(
                tablaResultado.getLong("cui"),
                tablaResultado.getString("nombre_cliente"),
                tablaResultado.getString("apellido_cliente"),
                tablaResultado.getString("correo_electronico")
            ));
        }

    } catch (Exception e) {
        System.out.println("Error al listar clientes: " + e.getMessage());
    }

    return clientes;   // <-- aquí está la corrección
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
