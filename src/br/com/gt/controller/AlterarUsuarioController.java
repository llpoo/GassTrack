/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.controller;

import br.com.gt.dao.FuncionarioDAO;
import br.com.gt.dao.UsuarioDAO;
import br.com.gt.model.Funcionario;
import br.com.gt.model.Usuario;
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
    Usuario usuario;
    boolean isGerente;
    AlterarUsuarioView telaAlterar;

    public AlterarUsuarioController(Connection connection, Usuario usuario) {
        this.connection = connection;
        this.usuario = usuario;
        this.isGerente = true;
        this.telaAlterar = new AlterarUsuarioView(null,true);
        adicionaEventos();
        preencheCampos();
        this.telaAlterar.setVisible(true);
    }
    
    public AlterarUsuarioController(Connection con, Funcionario f) {
        this.connection = con;
        this.funcionario = f;
        isGerente = false;
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
            if(this.isGerente == false){
                this.funcionario.getUsuario().setUsuario(this.telaAlterar.getUsuarioTxt().getText());
                this.funcionario.getUsuario().setSenha(this.telaAlterar.getSenhaTxt().getText());
                this.funcionario.getUsuario().setIsGerente(false);

                FuncionarioDAO funcionarioDAO = new FuncionarioDAO(this.connection);

                funcionarioDAO.alterar(this.funcionario);

                if(funcionarioDAO.alterar(this.funcionario) == true){
                    this.telaAlterar.dispose();
                }
            }else{
                this.usuario.setUsuario(this.telaAlterar.getUsuarioTxt().getText());
                this.usuario.setSenha(this.telaAlterar.getSenhaTxt().getText());
                this.usuario.setIsGerente(true);
                UsuarioDAO usuarioDAO = new UsuarioDAO(this.connection);
                usuarioDAO.alterar(this.usuario);
                
                if(usuarioDAO.alterar(this.usuario) == true){
                    this.telaAlterar.dispose();
                }
            }
        }
    }

    private void adicionaEventos() {
        this.telaAlterar.getSalvarBtn().addActionListener(this);
        this.telaAlterar.getCancelarBtn().addActionListener(this);
    }

    private void preencheCampos() {
        if(this.isGerente == false){
            this.telaAlterar.getUsuarioTxt().setText(this.funcionario.getUsuario().getUsuario());
            this.telaAlterar.getSenhaTxt().setText(this.funcionario.getUsuario().getSenha());
        }else{
            this.telaAlterar.getUsuarioTxt().setText(this.usuario.getUsuario());
            this.telaAlterar.getSenhaTxt().setText(this.usuario.getSenha());
        }        
    }
    
}
