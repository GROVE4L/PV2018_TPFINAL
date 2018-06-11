package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.dao.IPerfilDAO;
import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.modelo.dominio.Perfil;
import aplicacion.modelo.dominio.Usuario;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rojas, Guido G.
 */
public class PerfilDAOImp implements IPerfilDAO {

    @Override
    public void add(Perfil perfil) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();        
        s.save(perfil);
        s.getTransaction().commit();
        s.close(); 
    }

    @Override
    public void update(Perfil perfil) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Perfil perfil) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Perfil buscarPerfil(Perfil perfil) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
