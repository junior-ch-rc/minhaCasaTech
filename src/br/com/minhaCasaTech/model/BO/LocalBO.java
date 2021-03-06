package br.com.minhaCasaTech.model.BO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



import br.com.minhaCasaTech.model.DAO.LocalDAO;
import br.com.minhaCasaTech.model.VO.LocalVO;
public class LocalBO implements BaseInterBO<LocalVO>{

	public void cadastrar(LocalVO local) {
		LocalDAO dao = new LocalDAO();
		try{
			dao.cadastrar(local);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void editar(LocalVO local) {
		LocalDAO dao = new LocalDAO();
		try{
			 dao.editar(local);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		//return local;
	}
	public LocalVO buscarPorId(Long id) {
		LocalDAO ldao = new LocalDAO();
		LocalVO local = new LocalVO();
		ResultSet rs = ldao.buscarPorId(id);
		try {
			rs.next();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
		local.setCasa(rs.getString("casa"));
		System.out.println(local.getCasa());
		local.setCompartimento(rs.getString("compartimento"));
		local.setId(rs.getLong("id"));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return local;
	}
	public LocalVO buscarPorId(LocalVO local) {
		LocalDAO dao = new LocalDAO();
		ResultSet rs = dao.buscarPorId(local);
		try {
		local.setCasa(rs.getString("casa"));
		local.setCompartimento(rs.getString("compartimento"));
		local.setId(rs.getLong("id"));
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return local;
	}
	
	public List<LocalVO> listar() {
		LocalDAO dao = new LocalDAO();
		ResultSet rs = dao.listar();
		List<LocalVO> locais = new ArrayList<LocalVO>();
		
		try {
			while(rs.next()) {
				LocalVO local = new LocalVO();
				local.setId(rs.getLong("id"));
				local.setCasa(rs.getString("casa"));
				local.setCompartimento((rs.getString("compartimento")));
				locais.add(local);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return locais;
	}
	
	public void deletar(LocalVO local)throws SQLException{
		LocalDAO dao = new LocalDAO();
	//	try{
		dao.deletar(local);
		System.out.println("Deletado");
		//}catch(Exception e) {
		//	e.printStackTrace();
		//}
		
	}
}
