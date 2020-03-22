package it.jac.javadb.dao;

import java.util.List;

import it.jac.javadb.entity.Documento;

public interface CustomDocumentoRepository {

	public List<Documento> findOnlyValid();

	boolean testConnection();
}
