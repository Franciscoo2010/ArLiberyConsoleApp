package otg.ar.dao;

import java.util.List;
import org.ar.model.Categoria;


public interface CategoriDAO {
// firmas de metodos

    /**
     *
     * @param categoria
     * @return
     */
    
    boolean insertar (Categoria categoria);
    List<Categoria> listarTodos ();
    Categoria buscar(long cui);
    boolean actualizar(Categoria categoria);
    boolean eliminar(long cui);

    public Categoria buscarPorId(int id);
    
}
