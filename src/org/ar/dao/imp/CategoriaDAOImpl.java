

package org.ar.dao.imp;
 
import java.util.ArrayList;
import org.ar.model.Categoria;
import otg.ar.dao.CategoriDAO;
 
import java.util.List;
import java.sql.CallableStatement;
import org.ar.util.Conexion;
import 
 
public class CategoriaDAOImpl implements CategoriDAO{

    @Override
    public boolean insertar(Categoria categoria) {
        return false;
    }

    @Override
    public List<Categoria> listarTodos() {
        // crear nuestra consulta
        List<Categoria> categoria = new ArrayList <>();
        //crear nuestra consulta
        String consulta = "{call sp_listarcategorias}";
        //mapaer el resultado de la consulta a objeto y lo agregamos a la lista
        // intentar con recursos -> ciera el recurso al completar el intento
        // recurso: Conexion, al final cierra
        try(
        Connection conexion = Conexion.getInstancia().conectar();
        CallableStatement consultaCall = conexion.pepareCall(consulta);
                ResultSet tablaResultado  = consultaCall.executeQuery();  
                ) {
            System.out.println("");
} 
        catch (Exception e) {
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
}
