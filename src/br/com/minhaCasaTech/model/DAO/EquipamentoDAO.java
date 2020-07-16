package br.com.minhaCasaTech.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.minhaCasaTech.model.VO.EquipamentoVO;
import br.com.minhaCasaTech.model.VO.LocalVO;
import br.com.minhaCasaTech.model.VO.PessoaVO;
import br.com.minhaCasaTech.model.VO.ResponsavelVO;

public class EquipamentoDAO extends BaseDAO<EquipamentoVO> implements EquipamentoInterDAO {
	
	public  void cadastrar(EquipamentoVO equipamento) {
		
		String sql = "insert into equipamento (nome,peso,preco,quantidade,numero_de_serie,id_local,id_responsavel) values (?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pst = getCon().prepareStatement(sql);
			pst.setString(1,equipamento.getNome());
			pst.setDouble(2, equipamento.getPeso());
			pst.setDouble(3, equipamento.getPreco());
			pst.setInt(4, equipamento.getQuantidade());
			pst.setInt(5, equipamento.getNumeroDeSerie());
			pst.setLong(6, equipamento.getLocal().getId());
			//pst.setLong(6, equipamento.getResponsavel().getId());
			pst.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public EquipamentoVO  editar(EquipamentoVO eqpOrigem) {
		
		
		return eqpOrigem;
	}
	
	public void deletar(EquipamentoVO equipamento) {
		
		String sql = "delete from equipamento where id = ?";
		
		try {
			PreparedStatement pst = getCon().prepareStatement(sql);
			pst.setLong(1, equipamento.getId());
			pst.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public EquipamentoVO buscar(EquipamentoVO e) {
		return e;
	}
	
	/*public EquipamentoVO[] listar() {
		EquipamentoVO[] eqp = null;
		return eqp;
	}*/
	
	public List<EquipamentoVO> listar(){
		
		String sql = "select * from equipamento";
		Statement st;
		ResultSet rs;
		List<EquipamentoVO> equipamentoList = new ArrayList<EquipamentoVO>();
		
		try {
			st = getCon().createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
			EquipamentoVO eqp = new EquipamentoVO();	
			eqp.setId(rs.getLong("id"));
			eqp.setNome(rs.getString("nome"));
			eqp.setPeso(rs.getDouble("peso"));
			eqp.setPreco(rs.getDouble("preco"));
			eqp.setQuantidade(rs.getInt("quantidade"));
			eqp.setNumeroDeSerie(rs.getInt("numero_de_serie"));
			
			equipamentoList.add(eqp);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return equipamentoList;
	}
	public EquipamentoVO buscarPorNome(String nome) {
		
		String sql = "select * from equipamento where nome = ?";
		String sql2 = "select * from local where id = ?";
		String sql3 = "select * from responsavel where id = ?";
		PreparedStatement pst;
		ResultSet rs = null;
		EquipamentoVO eqp = new EquipamentoVO();
		try {
			pst = getCon().prepareStatement(sql);
			pst.setString(1, nome);
			rs = pst.executeQuery();
			eqp.setId(rs.getLong("id"));
			eqp.setNome(rs.getString("nome"));
			eqp.setPeso(rs.getDouble("peso"));
			eqp.setPreco(rs.getDouble("preco"));
			eqp.setQuantidade(rs.getInt("quantidade"));
			eqp.setNumeroDeSerie(rs.getInt("numero_de_serie"));
			
			//aloca memoria
			LocalVO l = new LocalVO();
			//conecta com a local
			LocalDAO ldao = new LocalDAO();
			//l recebe um local do medotodo  buscarId(),esse procura no banco o local reerido, ja q  no banco, a tabela equipamento recebe apenas o id do local
			l = ldao.buscarId(rs.getLong("id_local"));
			eqp.setLocal(l);
			
			//mesma coisa s� q com responsavel
			/*
			ResponsavelVO r = new ResponsavelVO();
			ResponsavelDAO rdao = new ResponsavelDAO();
			r = rdao.buscarId(rs.getLong("id_responsavel"));	
			eqp.setResponsavel(r);
			*/
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return eqp;
	}
	
	public EquipamentoVO buscarPorNS(int ns) {
		
		
		String sql = "select * from equipamento where nome = ?";
		PreparedStatement pst;
		ResultSet rs = null;
		EquipamentoVO eqp = new EquipamentoVO();
		try {
			pst = getCon().prepareStatement(sql);
			pst.setInt(1, ns);
			rs = pst.executeQuery();
			eqp.setId(rs.getLong("id"));
			eqp.setNome(rs.getString("nome"));
			eqp.setPeso(rs.getDouble("peso"));
			eqp.setPreco(rs.getDouble("preco"));
			eqp.setQuantidade(rs.getInt("quantidade"));
			eqp.setNumeroDeSerie(rs.getInt("numero_de_serie"));
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return eqp;
	}
	
	public EquipamentoVO buscarPorLocal(LocalVO local) {
	
		
		String sql = "select * from equipamento where id_local = ?";
		PreparedStatement pst;
		ResultSet rs = null;
		EquipamentoVO eqp = new EquipamentoVO();
		try {
			pst = getCon().prepareStatement(sql);
			pst.setLong(1,local.getId());
			rs = pst.executeQuery();
			eqp.setId(rs.getLong("id"));
			eqp.setNome(rs.getString("nome"));
			eqp.setPeso(rs.getDouble("peso"));
			eqp.setPreco(rs.getDouble("preco"));
			eqp.setQuantidade(rs.getInt("quantidade"));
			eqp.setNumeroDeSerie(rs.getInt("numero_de_serie"));
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return eqp;
	}
	
	public ResponsavelVO adicionnarResponsavel(ResponsavelVO responsael) {
		ResponsavelVO rep =null;
		return rep;
	}
	
	public LocalVO adicionarLocal(LocalVO local) {
		LocalVO lo = null;
		return lo;
	}
}
