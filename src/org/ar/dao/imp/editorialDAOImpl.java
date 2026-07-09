package org.ar.dao.imp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import otg.ar.dao.editorialDAO;
import org.ar.model.editorial;
import org.ar.util.Conexion;

public class editorialDAOImpl implements editorialDAO {
    @Override
public List<editorial> listarTodos() {

    List<editorial> editoriales = new ArrayList<>();

    String consulta = "{call sp_listareditoriales()}";

    try (
        Connection conexion = Conexion.getInstancia().conectar();
        CallableStatement cs = conexion.prepareCall(consulta);
        ResultSet rs = cs.executeQuery()
    ) {

        while (rs.next()) {

            editorial edi = new editorial();

            edi.setNit(rs.getString("nit"));
            edi.setNombre_editorial(rs.getString("nombre_editorial"));
            edi.setTelefono_editorial(rs.getString("telefono_editorial"));
            edi.setDireccion_editoria(rs.getString("direccion_editoria"));

            editoriales.add(edi);
        }

    } catch (Exception e) {
        System.err.println("Error al listar editoriales: " + e.getMessage());
    }

    return editoriales;
}
@Override
public boolean insertar(editorial editorial) {
    return false;
}

@Override
public editorial buscar(String nit) {
    return null;
}

@Override
public boolean actualizar(editorial editorial) {
    return false;
}

@Override
public boolean eliminar(String nit) {
    return false;
}
}