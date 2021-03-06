package br.com.minhaCasaTech.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.minhaCasaTech.model.VO.CompraVO;
import br.com.minhaCasaTech.model.VO.VendaVO;

public class CompraDAO<VO extends CompraVO> extends TransacaoDAO<CompraVO> {
	public void cadastrar(VO transacao) {
		super.cadastrar(transacao);
		String sql = "insert into compra (id_transacao) values (?)";
		PreparedStatement ptst;
		try {
			ptst = getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			ptst.setLong(1, transacao.getId_transacao());
			
			int affectedRows = ptst.executeUpdate();
			
			if (affectedRows == 0)
				throw new SQLException("A venda falhou");
			
			ResultSet generatedKeys = ptst.getGeneratedKeys();
			
			if(generatedKeys.next()) {
				transacao.setId_compra(generatedKeys.getLong(1));
			}else
				throw new SQLException("A venda falhou");
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	public ResultSet buscarPorId(VO transacao) {
		String sql = "select * from compra, transacao, transacao_equipamentos where compra.id_transacao=? and transacao.id=? and transacao_equipamentos.id_transacao=?";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = getCon().prepareStatement(sql);
			ptst.setLong(1, transacao.getId_transacao());
			ptst.setLong(2, transacao.getId_transacao());
			ptst.setLong(3, transacao.getId_transacao());
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet buscarPorId(Long id) {
		String sql = "select * from compra where id=?";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = getCon().prepareStatement(sql);
			ptst.setLong(1, id);
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet listar() {
		String sql = "select * from transacao, compra where transacao.tipo = 1";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = getCon().prepareStatement(sql);
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
