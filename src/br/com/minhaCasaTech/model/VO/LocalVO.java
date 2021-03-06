package br.com.minhaCasaTech.model.VO;

public class LocalVO {
	
	private long id;
	private String casa;
	private String compartimento;
	
	
	public LocalVO() {
		
	}
	public LocalVO(String casa, String compartimento){
		this.setCasa(casa);
		this.setCompartimento(compartimento);
	}
	
	//Set
	public void setId(long id) {
		this.id = id;
	}
	
	public void setCasa(String casa) {
		if(casa ==null)
			System.out.println("Valor nulo!");
		else
			if(casa.equals(""))
				System.out.println("Nada escrito");
			else
				this.casa = casa;
	}
	
	public void setCompartimento(String compartimento) {
		if(compartimento==null)
			System.out.println("Valor nulo");
		else
			if(compartimento.equals(""))
				System.out.println("Nada escrito");
			else
				this.compartimento = compartimento;
	}
	
	//Get
	public long getId() {
		return id;
	}
	
	public String getCasa() {
		return casa;
	}
	
	public String getCompartimento() {
		return compartimento;
	}
	
	public String toString() {
		return compartimento == null ? "Casa: "+casa :
		"Casa: "+casa+"\n"+
		"Compartimento: "+compartimento+"\n";
	}
}