package aplicacion.datos.hibernate.dao;

import aplicacion.modelo.dominio.Perfil;

/**
 *
 * @author Rojas, Guido G.
 */
public interface IPerfilDAO {        
    public void add(Perfil perfil);
    public void update(Perfil perfil);
    public void delete(Perfil perfil);
    public boolean buscarPerfil(Perfil perfil);
    public Perfil obtenerPerfil(int codigoPerfilBuscado);
}
