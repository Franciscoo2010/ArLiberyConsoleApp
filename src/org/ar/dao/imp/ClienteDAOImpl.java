package org.ar.dao.imp;

import java.util.ArrayList;
import org.ar.model.Clientes;
import otg.ar.dao.ClienteDAO;
import org.ar.util.Conexion;
import java.sql.CallableStatement;
import java.sql.ResultSet;

import java.util.List;
import java.sql.Connection;
import java.sql.SQLException;

public class ClienteDAOImpl implements ClienteDAO {

    @Override
    public boolean insertar(Clientes cliente) {
        return false;
    }

    @Override
    public List<Clientes> listarTodos() {

        List<Clientes> clientes = new ArrayList<>();

        String consulta = "{call sp_listarClientes()}";

        try (
                Connection conexion = Conexion.getInstancia().conectar(); CallableStatement consultaCall = conexion.prepareCall(consulta); ResultSet tablaResultado = consultaCall.executeQuery()) {

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
    public Clientes buscarPorId(long cui) {
        Clientes cliente = new Clientes();

        String consultaSQL = "{call sp_buscarcliente(?)}";

        try (
            Connection conexion = Conexion.getInstancia().conectar();
            CallableStatement consultaCall = conexion.prepareCall(consultaSQL);){
                consultaCall.setLong(1, cui);
                ResultSet tablaResultado = consultaCall.executeQuery();
                if (tablaResultado.next()) {
                    cliente.setCui(tablaResultado.getLong("cui"));
                    cliente.setNombre(tablaResultado.getString("nombre_cliente"));
                    cliente.setApellido(tablaResultado.getString("apellido_cliente"));
                    cliente.setCorreoElectronico(tablaResultado.getString("correo_electronico"));
                } else {
                    //System.out.println("No existe el cliente con el ID indicado");
                    return null;

                }
            

        } catch (SQLException e) {
            System.err.println("Error al buscar cliente: " + e.getMessage());
        }
        return cliente;
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
