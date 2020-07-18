package br.com.minhaCasaTech.model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.minhaCasaTech.model.DAO.TransacaoDAO;
import br.com.minhaCasaTech.model.VO.TransacaoVO;
import exception.InsertException;
import exception.NotFoundException;

public class TransacaoBO implements BaseInterBO<TransacaoVO>{
	
	static private TransacaoDAO<TransacaoVO> dao0 = new TransacaoDAO<TransacaoVO>();

	@Override
	public void cadastrar(TransacaoVO vo) throws InsertException {
		// TODO Auto-generated method stub
	}

	@Override
	public TransacaoVO buscarPorId(Long id) throws NotFoundException {
		try {
			if (id < 0)
				throw new NotFoundException();
			else {
				ResultSet rs = dao0.buscarPorId(id);
				TransacaoVO generic = new TransacaoVO();
				while(rs.next()) {
					Calendar data = Calendar.getInstance();
					generic.setId_transacao(rs.getLong("id"));
					generic.setValorTotal(rs.getDouble("valor_total"));
					generic.setPesoTotal(rs.getDouble("peso_total"));
					generic.setTotalEquip(rs.getInt("total_equip"));
					data.setTime(rs.getDate("data"));
					generic.setData(data);
					generic.setTipo(rs.getInt("tipo"));
				}
				return generic;
			}
		} catch (SQLException e){
			throw new NotFoundException();
		}
		
	}

	@Override
	public TransacaoVO buscarPorId(TransacaoVO vo) throws NotFoundException {
		// TODO Auto-generated method stub
		try {
			ResultSet rs = dao0.buscarPorId(vo);
			TransacaoVO generic = new TransacaoVO();
			
			while(rs.next()) {
				Calendar data = Calendar.getInstance();
				generic.setId_transacao(rs.getLong("id"));
				generic.setValorTotal(rs.getDouble("valor_total"));
				generic.setPesoTotal(rs.getDouble("peso_total"));
				generic.setTotalEquip(rs.getInt("total_equip"));
				data.setTime(rs.getDate("data"));
				generic.setData(data);
				generic.setTipo(rs.getInt("tipo"));
			}
			
			return generic;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new NotFoundException();
		}
	}

	@Override
	public List<TransacaoVO> listar() throws NotFoundException{
		// TODO Auto-generated method stub		
		try {
			ResultSet rs = dao0.listar();
			ArrayList<TransacaoVO> transacoes = new ArrayList<TransacaoVO>();
			TransacaoVO generic = new TransacaoVO();
			
			while (rs.next()) {
				Calendar data = Calendar.getInstance();
				generic.setId_transacao(rs.getLong("id"));
				generic.setValorTotal(rs.getDouble("valor_total"));
				generic.setPesoTotal(rs.getDouble("peso_total"));
				generic.setTotalEquip(rs.getInt("total_equip"));
				data.setTime(rs.getDate("data"));
				generic.setData(data);
				generic.setTipo(rs.getInt("tipo"));
				transacoes.add(generic);
			}
			
			return transacoes;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new NotFoundException();
		}
	}

	@Override
	public void editar(TransacaoVO vo) throws InsertException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(TransacaoVO vo) throws InsertException {
		// TODO Auto-generated method stub
		
	}	
	
}
