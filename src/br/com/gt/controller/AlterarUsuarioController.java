/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.controller;

import br.com.gt.dao.EnderecoDAO;
import br.com.gt.dao.FuncionarioDAO;
import br.com.gt.dao.UsuarioDAO;
import br.com.gt.model.Funcionario;
import br.com.gt.model.Usuario;
import br.com.gt.view.acesso.AlterarUsuarioView;
import br.com.gt.view.funcionario.AlterarFuncionarioView;
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
    AlterarFuncionarioView telaVolta;

    public AlterarUsuarioView getTelaAlterar() {
        return telaAlterar;
    }

    public AlterarUsuarioController(Connection connection, Usuario usuario) {
        this.connection = connection;
        this.usuario = usuario;
        this.isGerente = true;
        this.telaAlterar = new AlterarUsuarioView(null,true);
        adicionaEventos();
        preencheCampos();
        this.telaAlterar.setVisible(true);
    }
    
    public AlterarUsuarioController(Connection con, Funcionario f, AlterarFuncionarioView telaVolta) {
        this.connection = con;
        this.funcionario = f;
        this.telaVolta = telaVolta;
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
                Usuario usuario = new Usuario();
                if(this.usuario != null){
                    usuario.setId(this.usuario.getId());
                }else{
                    usuario.setId(0);
                }
                usuario.setUsuario(this.telaAlterar.getUsuarioTxt().getText());
                usuario.setSenha(this.telaAlterar.getSenhaTxt().getText());
                usuario.setIsGerente(false);
                this.funcionario.setUsuario(usuario);

                FuncionarioDAO funcionarioDAO = new FuncionarioDAO(this.connection);

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
                    EnderecoDAO eDao = new EnderecoDAO(this.connection);
                if(eDao.existeEmFuncionario(this.funcionario.getEndereco()) == false){
                    eDao.excluir((this.funcionario.getEndereco()));
                }
                this.telaAlterar.dispose();
                    this.telaAlterar.dispose();
                }
            }
        }
        
        if(evento.getSource().equals(this.telaAlterar.getVoltarBtn())){
            this.telaAlterar.setVisible(false);
            this.telaVolta.setVisible(true);
        }
    }

    private void adicionaEventos() {
        this.telaAlterar.getSalvarBtn().addActionListener(this);
        this.telaAlterar.getCancelarBtn().addActionListener(this);
        this.telaAlterar.getVoltarBtn().addActionListener(this);
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
