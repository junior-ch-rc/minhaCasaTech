package br.com.minhaCasaTech.model.VO;

import java.util.Calendar;
import java.util.TimeZone;

public class TransacaoVO {

	private Long id;
	private double valorTotal;
	private double pesoTotal;
	private int totalEquip;
	private Calendar data;
	private EquipamentoVO equipamentos[];
	
	public TransacaoVO(double valorTotal, double pesoTotal, int totalEquip) {
		this.setValorTotal(valorTotal);
		this.setPesoTotal(pesoTotal);
		this.setTotalEquip(totalEquip);
	}
	
	// Sets
	
	public void setValorTotal(double valorTotal) {
		if (valorTotal >= 0)
			this.valorTotal = valorTotal;
		else
			System.out.println("Valor Inválido");
	}
	
	public void setPesoTotal(double pesoTotal) {
		if (valorTotal >= 0)
			this.pesoTotal = pesoTotal;
		else
			System.out.println("Valor Inválido");
	}
	
	public void setTotalEquip(int totalEquip) {
		if (totalEquip >= 0)
			this.totalEquip = totalEquip;
		else
			System.out.println("Valor Inválido");
	}
	
	public void setData(Calendar data) {
		TimeZone zone = TimeZone.getTimeZone("GMT-3:00");
		this.data = Calendar.getInstance(zone);
	}
	
	public void addEquipamento(EquipamentoVO eqp) {
		if (eqp != null)
			// ADICIONAR
			;
		else
			System.out.println("Equipamento Inválido");
	}
	
	public void removeEquipamento(EquipamentoVO eqp) {
		if (eqp != null)
			// REMOVER
			;
		else
			System.out.println("Equipamento Inválido");
	}
	
	// Gets
	
	public double getValorTotal() {
		return valorTotal;
	}
	
	public double getPesoTotal() {
		return pesoTotal;
	}
	
	public int getTotalEquip() {
		return totalEquip;
	}
	
	public Calendar getData() {
		return data;
	}
	
	public String toString() {
		String str =
		"Valor Total: "+valorTotal+"\n"+
		"Peso Total: "+pesoTotal+"\n"+
		"Data: "+data.toString()+"\n"+
		"Equipamentos: \n";
		
		for (int i=0; i<equipamentos.length;i++) {
			str += equipamentos[i].toString();
		}
		
		return str;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
