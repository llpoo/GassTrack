/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.controller;

import br.com.gt.model.Endereco;
import br.com.gt.model.Funcionario;
import br.com.gt.view.funcionario.CadastrarFuncionarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

/**
 *
 * @author lucas
 */
public class CadastrarVendedorController implements ActionListener{

    Connection connection;
    CadastrarFuncionarioView telaCadastro;
    Funcionario funcionario;
    
    public CadastrarVendedorController(Connection con, Funcionario f) {
        this.connection = con;
        telaCadastro = new CadastrarFuncionarioView(null, true);
        funcionario = f;
        adicionaEventos();
        telaCadastro.setVisible(true);
    }
    
    private void adicionaEventos(){
        this.telaCadastro.getProximoBtn().addActionListener(this);
        this.telaCadastro.getCancelarBtn().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(this.telaCadastro.getCancelarBtn())){
            this.telaCadastro.dispose();
        }
        
        if(evento.getSource().equals(this.telaCadastro.getProximoBtn())){
            this.funcionario.setCpf(this.telaCadastro.getCpfTxt().getText());
            this.funcionario.setEmail(this.telaCadastro.getEmailTxt().getText());
            this.funcionario.setNome(this.telaCadastro.getNomeTxt().getText());
            this.funcionario.setRg(this.telaCadastro.getRgTxt().getText());
            this.funcionario.setTelefone(this.telaCadastro.getTelefoneTxt().getText());
            
            Endereco endereco = new Endereco();
            
            endereco.setBairro(this.telaCadastro.getBairroTxt().getText());
            endereco.setCep(this.telaCadastro.getCepTxt().getText());
            endereco.setCidade(this.telaCadastro.getCidadeTxt().getText());
            endereco.setEstado(this.telaCadastro.getEstadoComboBox().getSelectedItem().toString());
            endereco.setNumero(this.telaCadastro.getNumeroTxt().getText());
            endereco.setRua(this.telaCadastro.getRuaTxt().getText());
            
            if(this.telaCadastro.getRadioMasculino().isSelected()){
                this.funcionario.setSexo("Masculino");
            }
            
            if(this.telaCadastro.getRadioFeminino().isSelected()){
                this.funcionario.setSexo("Feminino");
            }
            
            this.funcionario.setDataAdmissao(this.telaCadastro.getDataAdmissaoCalendar().getDate());
            
            this.funcionario.setEndereco(endereco);
            
            this.telaCadastro.setVisible(false);
            CadastrarUsuarioController cadastrarUsuarioController = new CadastrarUsuarioController(this.connection,this.funcionario);
            this.telaCadastro.dispose();
        }
    }
    
}
