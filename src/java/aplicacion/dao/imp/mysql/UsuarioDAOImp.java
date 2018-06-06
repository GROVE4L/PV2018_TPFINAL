package aplicacion.dao.imp.mysql;

import aplicacion.dao.IUsuarioDAO;
import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.modelo.dominio.Usuario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
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
        s.beginTransaction();
        Criteria crit = s.createCriteria(Usuario.class);
        crit.add(Restrictions.like("usuNombreUsuario", usuario.getUsuNombreUsuario())); //1) como esta en clase 2)con que comparar
        crit.add(Restrictions.like("usuPassword", usuario.getUsuPassword()));
        if(!crit.list().isEmpty()) {
            u = (Usuario) crit.list().get(0);
        }
        return u;
    }

    @Override
    public void add(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Usuario usuario) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Usuario> devolverUsuarios() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        List<Usuario> usuarios = null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Criteria crit = s.createCriteria(Usuario.class);
        crit.add(Restrictions.like("usuEstado", false)); 
        usuarios = (List<Usuario>) crit.list();
        return usuarios;        
    }
    
}
