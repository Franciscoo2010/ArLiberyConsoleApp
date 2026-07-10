package otg.ar.dao;

import java.util.List;
import org.ar.model.Autor;

public interface AutorDAO {

    boolean insertar(Autor autor);

    List<Autor> listarTodos();

    Autor buscar(int idAutor);

    boolean actualizar(Autor autor);

    boolean eliminar(int idAutor);
}