package br.com.minhaCasaTech.model.DAO;

import br.com.minhaCasaTech.model.VO.LocalVO;

public interface LocalInterDAO {
public void cadastrar(LocalVO local);
	
	public LocalVO editar(LocalVO local);
	
	public LocalVO buscar(LocalVO local);
	
	public LocalVO[] listar();
	
	public void deletar(LocalVO local);
}
