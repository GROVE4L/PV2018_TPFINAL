package aplicacion.datos.hibernate.dao.imp;

import aplicacion.datos.hibernate.configuracion.HibernateUtil;
import aplicacion.datos.hibernate.dao.IReservaDAO;
import aplicacion.modelo.dominio.Perfil;
import aplicacion.modelo.dominio.Reserva;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Rojas, Guido G.
 */
public class ReservaDAOImp implements IReservaDAO {
    /**
     * agregado reserva
     * @param re 
     */
    @Override
    public void add(Reserva re) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.save(re);
        s.getTransaction().commit();
        s.close();
    }
    /**
     * actualiza reserva
     * @param re 
     */
    @Override
    public void update(Reserva re) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.update(re);
        s.getTransaction().commit();
        s.close();
    }
    /**
     * borrado reserva
     * @param re 
     */
    @Override
    public void delete(Reserva re) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Session s = HibernateUtil.getSessionFactory().openSession();
        s.beginTransaction();
        s.delete(re);
        s.getTransaction().commit();
        s.close();
    }
    /**
     * lista reserva
     * devuelve reservas
     * @return 
     */
    @Override
    public List<Reserva> devolverReservas() {
        List<Reserva> listaAux=new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().openSession();        
        Criteria crit = s.createCriteria(Reserva.class);
        listaAux = crit.list();
        s.close();
        return listaAux;
    }
    /**
     * obtiene ultima reserva
     * @return 
     */
    @Override
    public Reserva obtenerUltimaReserva() {
        Reserva objAux = new Reserva();
        Session s = HibernateUtil.getSessionFactory().openSession();        
        Criteria crit = s.createCriteria(Reserva.class);
        objAux= (Reserva) crit.list().get(crit.list().size()-1);
        s.close();
        return objAux;
    }

    @Override
    public Date obtenerFechaReserva(int Codigobuscar) {
        Date strAux;
        Session s = HibernateUtil.getSessionFactory().openSession();        
        Criteria crit = s.createCriteria(Reserva.class);
        crit.add(Restrictions.like("revCodigo", Codigobuscar)); //1) como esta en clase 2)con que comparar        
        if(crit.list().isEmpty())
            strAux= null;
        else 
            strAux= ((Reserva) crit.list().get(0)).getRevFechaTurno();
        s.close();
        return strAux;
    }
    
    @Override
    public int obtenerCodigoPerfil(int Codigobuscar) {
        int strAux;
        Session s = HibernateUtil.getSessionFactory().openSession();        
        Criteria crit = s.createCriteria(Reserva.class);
        crit.add(Restrictions.like("revCodigo", Codigobuscar)); //1) como esta en clase 2)con que comparar        
        if(crit.list().isEmpty())
            strAux= 0;
        else 
            strAux= ((Reserva) crit.list().get(0)).getRevPerfil();
        s.close();
        return strAux;
    }
    
            
}
