/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.controller;

import br.com.gt.model.PessoaFisica;
import br.com.gt.view.cliente.MostrarClienteView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

/**
 *
 * @author lucas
 */
public class MostrarClienteController implements ActionListener{
    Connection connection;
    MostrarClienteView telaMostrar;
    PessoaFisica cliente;
    
    public MostrarClienteController(Connection connection, PessoaFisica c) {
        this.connection = connection;
        this.cliente = new PessoaFisica();
        this.telaMostrar = new MostrarClienteView(null,true);
        adicionaEventos();
        preencheCampos(c);
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

    private void preencheCampos(PessoaFisica c) {
        this.cliente.setId(c.getId());
        this.telaMostrar.getNomeTxt().setText(c.getNome());
        this.telaMostrar.getRgTxt().setText(c.getRg());
        this.telaMostrar.getCpfTxt().setText(c.getCpf());
        this.telaMostrar.getEmailTxt().setText(c.getEmail());
        this.telaMostrar.getTelefoneTxt().setText(c.getTelefone());
        
        if(c.getSexo().equalsIgnoreCase("Masculino")){
            this.telaMostrar.getMasculinoRadio().setSelected(true);
        }else{
            if(c.getSexo().equalsIgnoreCase("Feminino")){
                this.telaMostrar.getFemininoRadio().setSelected(true);
            }
        }
        
        this.telaMostrar.getEstadoTxt().setText(c.getEndereco().getEstado());
        this.telaMostrar.getCepTxt().setText(c.getEndereco().getCep());
        this.telaMostrar.getCidadeTxt().setText(c.getEndereco().getCidade());
        this.telaMostrar.getBairroTxt().setText(c.getEndereco().getBairro());
        this.telaMostrar.getRuaTxt().setText(c.getEndereco().getRua());
        this.telaMostrar.getNumeroTxt().setText(c.getEndereco().getNumero());
    }
    
}
