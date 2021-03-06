package br.com.minhaCasaTech.model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface BaseInterDAO<VO> {
	
	public void cadastrar(VO entity) throws SQLException;
	
	public void editar(VO entity) throws SQLException;
	
	public ResultSet buscarPorId(VO entity) throws SQLException;
	
	public ResultSet buscarPorId(Long id) throws SQLException;
	
	//public ResultSet buscar() throws SQLException;
	
	public ResultSet listar() throws SQLException;
	
	public void deletar(VO entity) throws SQLException;
}
