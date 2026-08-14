
package otg.ar.dao;

import java.util.List;
import org.ar.model.Clientes;

public interface ClienteDAO {
    //firmas de metodos
    //CRUD
    boolean crear(Clientes cliente);
    List<Clientes> listarTodos();
    Clientes buscarPorId(long cui);
    boolean actualizar(Clientes cliente);
    boolean eliminar(long cui);
    
}
