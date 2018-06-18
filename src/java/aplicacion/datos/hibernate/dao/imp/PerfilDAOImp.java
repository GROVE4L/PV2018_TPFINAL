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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(perfil);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void delete(Perfil perfil) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean buscarPerfil(Perfil perfil) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.              
        boolean encontrado = false;
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Criteria crit = s.createCriteria(Perfil.class);        
        crit.add(Restrictions.like("perDni", perfil.getPerDni())); //1) como esta en clase 2)con que comparar
        if(!crit.list().isEmpty())
            encontrado = true;
        return encontrado; 
    }

    @Override
    public Perfil obtenerPerfil(int codigoPerfilBuscado) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Perfil pEncontrado = null;
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        Criteria crit = s.createCriteria(Perfil.class);        
        crit.add(Restrictions.like("perUsuario", codigoPerfilBuscado)); //1) como esta en clase 2)con que comparar
        if(!crit.list().isEmpty())
            pEncontrado = (Perfil)crit.list().get(0);
        return pEncontrado;
    }


}
