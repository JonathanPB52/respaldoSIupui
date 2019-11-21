/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entidades.Reciclaje;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Jonhy
 */
@Stateless
public class ReciclajeFacade extends AbstractFacade<Reciclaje> {

    @PersistenceContext(unitName = "SIupuiPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ReciclajeFacade() {
        super(Reciclaje.class);
    }
    
}