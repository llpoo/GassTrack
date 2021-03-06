/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.controller;

import br.com.gt.dao.FuncionarioDAO;
import br.com.gt.model.Funcionario;
import br.com.gt.model.Usuario;
import br.com.gt.view.acesso.CadastrarUsuarioView;
import br.com.gt.view.funcionario.CadastrarFuncionarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class CadastrarUsuarioController implements ActionListener{

    Connection connection;
    CadastrarUsuarioView telaCadastro;
    Funcionario funcionario;
    CadastrarFuncionarioView telaVolta;

    public CadastrarUsuarioView getTelaCadastro() {
        return telaCadastro;
    }
    
    public CadastrarUsuarioController(Connection con, Funcionario fun, CadastrarFuncionarioView telaVolta) {
        this.connection = con;
        this.telaVolta = telaVolta;
        if(this.telaCadastro == null){
            this.telaCadastro = new CadastrarUsuarioView(null,true);
        }
        this.funcionario = fun;
        adicionaEventos();
        this.telaCadastro.setVisible(true);
    }
    
    public void adicionaEventos(){
        this.telaCadastro.getSalvarBtn().addActionListener(this);
        this.telaCadastro.getCancelarBtn().addActionListener(this);
        this.telaCadastro.getVoltarBtn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(this.telaCadastro.getVoltarBtn())){
            this.telaCadastro.setVisible(false);
            this.telaVolta.setVisible(true);
        }
        
        if(evento.getSource().equals(this.telaCadastro.getCancelarBtn())){
            this.telaCadastro.dispose();
        }
        
        if(evento.getSource().equals(this.telaCadastro.getSalvarBtn())){
            Usuario usuario = new Usuario();
            
            usuario.setUsuario(this.telaCadastro.getUsuarioTxt().getText());
            usuario.setSenha(this.telaCadastro.getSenhaTxt().getText());
            usuario.setIsGerente(false);
            
            this.funcionario.setUsuario(usuario);
            
            FuncionarioDAO fDao = new FuncionarioDAO(this.connection);
            
            if(fDao.inserir(this.funcionario) == true){
                this.telaCadastro.dispose();
            }
        }
    }
}
