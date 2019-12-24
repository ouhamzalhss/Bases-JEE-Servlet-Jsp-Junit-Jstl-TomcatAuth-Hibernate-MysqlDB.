package metier;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import metier.entities.Produit;
import util.HibernateUtil;

public class CatalogImpl implements ICatalogDAO{
	

	public void addProduit(Produit p) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			session.save(p);
			
		} catch (Exception e) {
			session.getTransaction().rollback();
		}
		session.getTransaction().commit();
	}

	
	public List<Produit> listProduits() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query q = session.createQuery("SELECT p FROM Produit p");
		List<Produit> listes = q.getResultList();
		session.getTransaction().commit();
		return listes;
	}


	public Produit getProduit(Long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Object obj = session.get(Produit.class, id);
		if(obj==null) throw new RuntimeException("Produit introvable");
		session.getTransaction().commit();
		return (Produit) obj;
	}

	
	public List<Produit> getProduitParMC(String mc) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Query q = session.createQuery("SELECT p FROM Produit p where p.designation like :x ");
		q.setParameter("x","%"+mc+"%");
		List<Produit> listes = q.getResultList();
		session.getTransaction().commit();
		return listes;
	}

	
	public void deleteProduit(Long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Object obj = session.get(Produit.class, id);
		if(obj==null) throw new RuntimeException("Produit introvable");
		session.delete(obj);
		session.getTransaction().commit();
		
	}

	
	public void updateProduit(Produit p) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(p);
		session.getTransaction().commit();
		
	}

}
