package it.jac.javadb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import it.jac.javadb.entity.Documento;

public class CustomDocumentoRepositoryImpl implements CustomDocumentoRepository {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public List<Documento> findOnlyValid() {
		
		TypedQuery<Documento> query = em.createQuery("from Documento", Documento.class);
		return query.getResultList();
	}
	
	@Override
	public boolean testConnection() {
		
		return em.isOpen();
	}

}
