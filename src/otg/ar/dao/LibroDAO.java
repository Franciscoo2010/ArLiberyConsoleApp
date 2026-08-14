
package otg.ar.dao;

import java.util.List;
import org.ar.model.Libro;

public interface LibroDAO {
    boolean crear(Libro libro);
    List<Libro> listarTodos();
    Libro buscarPorId(String isbn);
    boolean actualizar(Libro libro);
    boolean eliminar(String isbn);

}
