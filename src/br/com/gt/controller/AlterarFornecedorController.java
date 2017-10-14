/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.controller;

import br.com.gt.dao.FornecedorDAO;
import br.com.gt.model.Endereco;
import br.com.gt.model.Fornecedor;
import br.com.gt.view.fornecedor.AlterarFornecedorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Luciano Júnior
 */
public class AlterarFornecedorController implements ActionListener{
    Connection connection;
    AlterarFornecedorView telaAlterar;
    Fornecedor fornecedor;
    ArrayList<Fornecedor> fornecedores;
    int index;
    
    public AlterarFornecedorController(Connection con, Fornecedor f){
        this.connection = con;
        this.fornecedor = f;
        this.telaAlterar = new AlterarFornecedorView(null, true);
        adicionaEventos();
        preencheCampos();
        this.telaAlterar.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(this.telaAlterar.getCancelarBtn())){
            this.telaAlterar.dispose();
        }
        
        if(evento.getSource().equals(this.telaAlterar.getSalvarBtn())){
            Fornecedor forn = new Fornecedor();
            
            forn.setId(this.fornecedor.getId());
            forn.setNome(this.telaAlterar.getNomeTxt().getText());
            forn.setCnpj(this.telaAlterar.getCnpjTxt().getText());
            forn.setEmail(this.telaAlterar.getEmailTxt().getText());
            forn.setTelefone(this.telaAlterar.getTelefoneTxt().getText());
            
            
            Endereco end = new Endereco();
            
            end.setEstado(this.telaAlterar.getEstadoComboBox().getSelectedItem().toString());
            end.setBairro(this.telaAlterar.getBairroTxt().getText());
            end.setCep(this.telaAlterar.getCepTxt().getText());
            end.setCidade(this.telaAlterar.getCidadeTxt().getText());
            end.setRua(this.telaAlterar.getRuaTxt().getText());
            end.setNumero(this.telaAlterar.getNumeroTxt().getText());
            end.setId(this.fornecedor.getEndereco().getId());
            
            forn.setEndereco(end);
            
            FornecedorDAO fornDAO = new FornecedorDAO(this.connection);
            
            fornDAO.alterar(forn);
            
            this.telaAlterar.setVisible(false);
            this.telaAlterar.dispose();
        }
    }

    private void adicionaEventos() {
        this.telaAlterar.getSalvarBtn().addActionListener(this);
        this.telaAlterar.getCancelarBtn().addActionListener(this);
    }

    private void preencheCampos() {
        this.telaAlterar.getNomeTxt().setText(this.fornecedor.getNome());
        this.telaAlterar.getCnpjTxt().setText(this.fornecedor.getCnpj());
        this.telaAlterar.getEmailTxt().setText(this.fornecedor.getEmail());
        this.telaAlterar.getTelefoneTxt().setText(this.fornecedor.getTelefone());
        this.telaAlterar.getEstadoComboBox().setSelectedItem(this.fornecedor.getEndereco().getEstado());
        this.telaAlterar.getCepTxt().setText(this.fornecedor.getEndereco().getCep());
        this.telaAlterar.getCidadeTxt().setText(this.fornecedor.getEndereco().getCidade());
        this.telaAlterar.getBairroTxt().setText(this.fornecedor.getEndereco().getBairro());
        this.telaAlterar.getRuaTxt().setText(this.fornecedor.getEndereco().getRua());
        this.telaAlterar.getNumeroTxt().setText(this.fornecedor.getEndereco().getNumero());
    }
    
}
