/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.controller;

import br.com.gt.model.Fornecedor;
import br.com.gt.view.fornecedor.MostrarFornecedorView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

/**
 *
 * @author Luciano Júnior
 */
public class MostrarFornecedorController implements ActionListener{
    Connection connection;
    MostrarFornecedorView telaMostrar;
    Fornecedor fornecedor;
    
    public MostrarFornecedorController(Connection con, Fornecedor f) {
        this.connection = con;
        this.fornecedor = f;
        this.telaMostrar = new MostrarFornecedorView(null,true);
        adicionaEventos();
        preencheCampos();
        this.telaMostrar.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(this.telaMostrar.getOkBtn())){
            this.telaMostrar.dispose();
        }
    }

    private void adicionaEventos() {
        this.telaMostrar.getOkBtn().addActionListener(this);
    }

    private void preencheCampos() {
        this.telaMostrar.getNomeTxt().setText(this.fornecedor.getNome());
        this.telaMostrar.getCnpjTxt().setText(this.fornecedor.getCnpj());
        this.telaMostrar.getEmailTxt().setText(this.fornecedor.getEmail());
        this.telaMostrar.getTelefoneTxt().setText(this.fornecedor.getTelefone());
        this.telaMostrar.getEstadoComboBox1().setSelectedItem(this.fornecedor.getEndereco().getEstado());
        this.telaMostrar.getCepTxt().setText(this.fornecedor.getEndereco().getCep());
        this.telaMostrar.getCidadeTxt().setText(this.fornecedor.getEndereco().getCidade());
        this.telaMostrar.getBairroTxt().setText(this.fornecedor.getEndereco().getBairro());
        this.telaMostrar.getRuaTxt().setText(this.fornecedor.getEndereco().getRua());
        this.telaMostrar.getNumeroTxt().setText(this.fornecedor.getEndereco().getNumero());
    }
    
}
