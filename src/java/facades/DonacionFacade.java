/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entidades.Donacion;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Jonathan
 */
@Stateless
public class DonacionFacade extends AbstractFacade<Donacion> {

    @PersistenceContext(unitName = "SIupuiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DonacionFacade() {
        super(Donacion.class);
    }
    
    public List<Donacion> listar(){
        Query q = em.createNativeQuery("SELECT Id, tipoDonacion, cantidadDonada FROM donacion ", Donacion.class);
        List<Donacion> lst=q.getResultList();
        return lst;
    }
}
