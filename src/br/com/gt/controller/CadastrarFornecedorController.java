/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.controller;

import br.com.gt.model.Endereco;
import br.com.gt.model.Fornecedor;
import br.com.gt.view.fornecedor.CadastrarFornecedorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

/**
 *
 * @author Luciano Júnior
 */
public class CadastrarFornecedorController implements ActionListener{
    Connection connection;
    CadastrarFornecedorView telaCadastro;
    Fornecedor fornecedor;
    
    public CadastrarFornecedorController(Connection con, Fornecedor f) {
        this.connection = con;
        telaCadastro = new CadastrarFornecedorView(null, true);
        fornecedor = f;
        adicionaEventos();
        telaCadastro.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(this.telaCadastro.getCancelarBtn())){
            this.telaCadastro.dispose();
        }
        
        if(evento.getSource().equals(this.telaCadastro.getSalvarBtn())){
            this.fornecedor.setCnpj(this.telaCadastro.getCnpjTxt().getText());
            this.fornecedor.setEmail(this.telaCadastro.getEmailTxt().getText());
            this.fornecedor.setNome(this.telaCadastro.getNomeTxt().getText());
            this.fornecedor.setTelefone(this.telaCadastro.getTelefoneTxt().getText());
            
            Endereco endereco = new Endereco();
            
            endereco.setBairro(this.telaCadastro.getBairroTxt().getText());
            endereco.setCep(this.telaCadastro.getCepTxt().getText());
            endereco.setCidade(this.telaCadastro.getCidadeTxt().getText());
            endereco.setEstado(this.telaCadastro.getEstadoComboBox().getSelectedItem().toString());
            endereco.setNumero(this.telaCadastro.getNumeroTxt().getText());
            endereco.setRua(this.telaCadastro.getRuaTxt().getText());
            
            this.fornecedor.setEndereco(endereco);
            
            this.telaCadastro.setVisible(false);
            this.telaCadastro.dispose();
        }
    }

    private void adicionaEventos() {
        this.telaCadastro.getSalvarBtn().addActionListener(this);
        this.telaCadastro.getCancelarBtn().addActionListener(this);
    }
    
}
