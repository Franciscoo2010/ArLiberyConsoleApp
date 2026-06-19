package otg.ar.dao;

import org.ar.model.Autores;
import java.util.List;


public interface AutorDAO {
    //firmas de metodos
    
    boolean insertar (Autores autor);
    List<Autores> listar ();
    Autores buscar(long cui);
    boolean actualizar(Autores autor);
    boolean eliminar(long cui);
}
