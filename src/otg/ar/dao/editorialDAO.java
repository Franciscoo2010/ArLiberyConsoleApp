package otg.ar.dao;

import java.util.List;
import org.ar.model.editorial;

public interface editorialDAO {

    boolean insertar(editorial editorial);

    List<editorial> listar();

    editorial buscar(long nit);

    boolean actualizar(editorial editorial);

    boolean eliminar(long nit);
}
