package it.jac.javadb.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.jac.javadb.entity.Documento;

@Repository
public interface DocumentoRepository extends CrudRepository<Documento, Integer>, CustomDocumentoRepository {

}
