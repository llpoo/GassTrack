/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.controller;

import br.com.gt.dao.FuncionarioDAO;
import br.com.gt.model.Funcionario;
import br.com.gt.view.acesso.AlterarUsuarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class AlterarUsuarioController implements ActionListener{

    Connection connection;
    Funcionario funcionario;
    AlterarUsuarioView telaAlterar;
    ArrayList<Funcionario> funcionarios;
    int index;
    
    public AlterarUsuarioController(Connection con, Funcionario f, ArrayList<Funcionario> backUpFuncionarios, int i) {
        this.connection = con;
        this.funcionario = f;
        this.funcionarios = backUpFuncionarios;
        index = i;
        this.telaAlterar = new AlterarUsuarioView(null, true);
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
            this.funcionario.getUsuario().setUsuario(this.telaAlterar.getUsuarioTxt().getText());
            this.funcionario.getUsuario().setSenha(this.telaAlterar.getSenhaTxt().getText());
            this.funcionario.getUsuario().setIsGerente(false);
            
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO(this.connection);
            
            funcionarioDAO.alterar(this.funcionario);
            
            this.funcionarios.set(index, this.funcionario);
            
            this.telaAlterar.dispose();
        }
    }

    private void adicionaEventos() {
        this.telaAlterar.getSalvarBtn().addActionListener(this);
        this.telaAlterar.getCancelarBtn().addActionListener(this);
    }

    private void preencheCampos() {
        this.telaAlterar.getUsuarioTxt().setText(this.funcionario.getUsuario().getUsuario());
        this.telaAlterar.getSenhaTxt().setText(this.funcionario.getUsuario().getSenha());
    }
    
}
