/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.controller;

import br.com.gt.model.Funcionario;
import br.com.gt.view.funcionario.MostrarFuncionarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

/**
 *
 * @author lucas
 */
public class MostrarFuncionarioController implements ActionListener{
    
    Connection connection;
    MostrarFuncionarioView telaMostrar;
    Funcionario funcionario;

    public MostrarFuncionarioController(Connection con,Funcionario f) {
        this.connection = con;
        this.funcionario = f;
        this.telaMostrar = new MostrarFuncionarioView(null,true);
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
        this.telaMostrar.getNomeTxt().setText(this.funcionario.getNome());
        this.telaMostrar.getRgTxt().setText(this.funcionario.getRg());
        this.telaMostrar.getCpfTxt().setText(this.funcionario.getCpf());
        this.telaMostrar.getEmailTxt().setText(this.funcionario.getEmail());
        this.telaMostrar.getTelefoneTxt().setText(this.funcionario.getTelefone());
        
        if(this.funcionario.getSexo().equalsIgnoreCase("Masculino")){
            this.telaMostrar.getRadioMasculino().setSelected(true);
        }else{
            if(this.funcionario.getSexo().equalsIgnoreCase("Feminino")){
                this.telaMostrar.getRadioFeminino().setSelected(true);
            }
        }
        
        this.telaMostrar.getDataAdmissaoTxt().setText(this.funcionario.getDataAdmissao().toString());
        
        this.telaMostrar.getEstadoComboBox().setSelectedItem(this.funcionario.getEndereco().getEstado());
        this.telaMostrar.getCepTxt().setText(this.funcionario.getEndereco().getCep());
        this.telaMostrar.getCidadeTxt().setText(this.funcionario.getEndereco().getCidade());
        this.telaMostrar.getBairroTxt().setText(this.funcionario.getEndereco().getBairro());
        this.telaMostrar.getRuaTxt().setText(this.funcionario.getEndereco().getRua());
        this.telaMostrar.getNumeroTxt().setText(this.funcionario.getEndereco().getNumero());
    }
    
}
