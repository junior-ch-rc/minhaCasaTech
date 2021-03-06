package br.com.minhaCasaTech.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.minhaCasaTech.model.BO.ClienteBO;
import br.com.minhaCasaTech.model.VO.ClienteVO;
import br.com.minhaCasaTech.view.Telas;
import exception.InsertException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditarClienteController implements Initializable {
	@FXML
    private TextField cpf_cliente_txf;

    @FXML
    private Button cancel_cli_btm;

    @FXML
    private TextField nome_cliente_txf;

    @FXML
    private Button editar_cli_btm;

    @FXML
    private TextField endereco_cliente_txf;
    private static EditarClienteController meuController;
    private ClienteVO c = new ClienteVO();
    
    public void initialize(URL url, ResourceBundle rb) {
    	iniciarCampos();
    	meuController = this;
    }
    
    public static EditarClienteController getMeuController() {
		return meuController;
	}
    
	public static void setMeuController(EditarClienteController meuController) {
		EditarClienteController.meuController = meuController;
	}
	
	public ClienteVO getC() {
		return c;
	}
	
	public void setC(ClienteVO c) {
		this.c = c;
	}
	
	public void iniciarCampos() {
    	nome_cliente_txf.setText(c.getNome());
    	cpf_cliente_txf.setText(c.getCpf());
    	endereco_cliente_txf.setText(c.getEndereco());
    }
	
	@FXML
	private void editarCliente() {
		c.setNome(nome_cliente_txf.getText());
		c.setCpf(cpf_cliente_txf.getText());
		c.setEndereco(endereco_cliente_txf.getText());
		
		ClienteBO cbo = new ClienteBO();		
		try {
			cbo.editar(c);
			try {
				Telas.telaGerenciarCliente();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (InsertException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	private void cancelarOperacao(){
	    Stage stage = (Stage) cancel_cli_btm.getScene().getWindow(); //Obtendo a janela atual
	    stage.close(); //Fechando o Stage
	   
	}
}
