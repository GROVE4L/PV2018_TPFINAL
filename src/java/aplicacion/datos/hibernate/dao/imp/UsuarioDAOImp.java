package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.dao.IUsuarioDAO;
import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.modelo.dominio.Usuario;
import java.util.ArrayList;
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
        Usuario u = null;        
        Session s = HibernateUtil.getSessionFactory().openSession();        
        Criteria crit = s.createCriteria(Usuario.class);
        crit.add(Restrictions.like("usuNombreUsuario", usuario.getUsuNombreUsuario())); //1) como esta en clase 2)con que comparar
        crit.add(Restrictions.like("usuPassword", usuario.getUsuPassword()));
        if(!crit.list().isEmpty()) {
            u = (Usuario) crit.list().get(0);
        }
        s.close();
        return u;
    }

    @Override
    public void add(Usuario usuario) {        
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();        
        s.save(usuario);
        s.getTransaction().commit();
        s.close();       
    }

    @Override
    public void update(Usuario usuario) {        
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(usuario);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void delete(Usuario usuario) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(usuario);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public List<Usuario> devolverUsuarios() {
        List<Usuario> listaAux = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();        
        Criteria crit = s.createCriteria(Usuario.class);
        crit.add(Restrictions.like("usuEstado", true)); 
        listaAux= crit.list();        
        s.close();
        return listaAux;
    }    

    @Override
    public boolean buscarUsuario(Usuario usuario) {        
        boolean encontrado = false;
        Session s = HibernateUtil.getSessionFactory().openSession();        
        Criteria crit = s.createCriteria(Usuario.class);
        crit.add(Restrictions.like("usuNombreUsuario", usuario.getUsuNombreUsuario())); //1) como esta en clase 2)con que comparar
        if(!crit.list().isEmpty())
            encontrado = true;
        s.close();
        return encontrado;        
    }

    @Override
    public int obtenerCodigoUsuario(Usuario usuario) {        
        int encontrado = -1;
        Session s = HibernateUtil.getSessionFactory().openSession();        
        Criteria crit = s.createCriteria(Usuario.class);
        crit.add(Restrictions.like("usuNombreUsuario", usuario.getUsuNombreUsuario())); //1) como esta en clase 2)con que comparar
        if(!crit.list().isEmpty())
            encontrado = ((Usuario) crit.list().get(0)).getUsuCodigo();
        s.close();
        return encontrado;
    }

    @Override
    public Usuario obtenerUsuario(int codigoBuscado) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Usuario encontrado = null;
        Session s = HibernateUtil.getSessionFactory().openSession();        
        Criteria crit = s.createCriteria(Usuario.class);
        crit.add(Restrictions.like("usuCodigo", codigoBuscado)); //1) como esta en clase 2)con que comparar
        if(!crit.list().isEmpty())
            encontrado = ((Usuario) crit.list().get(0));
        s.close();
        return encontrado;
    }
}
