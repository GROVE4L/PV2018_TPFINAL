package aplicacion.dao.imp.mysql;

import aplicacion.dao.IUsuarioDAO;
import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.modelo.dominio.Usuario;
import java.util.ArrayList;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rojas, Guido G.
 */
public class UsuarioDAOImp implements IUsuarioDAO {

    @Override
    public Usuario login(Usuario usuario) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Usuario u = null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        Criteria crit = s.createCriteria(Usuario.class);
        crit.add(Restrictions.like("usuario", usuario.getUsuario()));
        crit.add(Restrictions.like("contrasena", usuario.getContrasena()));
        if(!crit.list().isEmpty()) {
            u = (Usuario) crit.list().get(0);
        }
        return u;
    }
    
}
