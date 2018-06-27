package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.dao.IPerfilDAO;
import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.modelo.dominio.Perfil;
import java.util.ArrayList;
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
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();        
        s.save(perfil);
        s.getTransaction().commit();
        s.close(); 
    }

    @Override
    public void update(Perfil perfil) {        
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(perfil);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public void delete(Perfil perfil) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(perfil);
        s.getTransaction().commit();
        s.close();
    }

    @Override
    public boolean buscarPerfil(Perfil perfil) {        
        boolean encontrado = false;
        Session s = HibernateUtil.getSessionFactory().openSession();        
        Criteria crit = s.createCriteria(Perfil.class);        
        crit.add(Restrictions.like("perDni", perfil.getPerDni())); //1) como esta en clase 2)con que comparar
        if(!crit.list().isEmpty())
            encontrado = true;
        s.close();
        return encontrado;
    }

    @Override
    public Perfil obtenerPerfil(int codigoPerfilBuscado) {        
        Perfil pEncontrado = null;
        Session s = HibernateUtil.getSessionFactory().openSession();        
        Criteria crit = s.createCriteria(Perfil.class);        
        crit.add(Restrictions.like("perUsuario", codigoPerfilBuscado)); //1) como esta en clase 2)con que comparar        
        if(!crit.list().isEmpty())
            pEncontrado = (Perfil)crit.list().get(0);
        s.close();
        return pEncontrado;
    }
    
    @Override
    public Perfil obtenerPerfilDirecto(int codigoPerfilBuscado) {        
        Perfil pEncontrado = null;
        Session s = HibernateUtil.getSessionFactory().openSession();        
        Criteria crit = s.createCriteria(Perfil.class);        
        crit.add(Restrictions.like("perCodigo", codigoPerfilBuscado)); //1) como esta en clase 2)con que comparar        
        if(!crit.list().isEmpty())
            pEncontrado = (Perfil)crit.list().get(0);
        s.close();
        return pEncontrado;
    }

    @Override
    public List<Perfil> listarPerfiles() {        
        List<Perfil> listaAux = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();        
        Criteria crit = s.createCriteria(Perfil.class);        
        listaAux= crit.list();
        s.close();
        return listaAux;
    }

}
