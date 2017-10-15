/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.controller;

import br.com.gt.dao.FuncionarioDAO;
import br.com.gt.model.Funcionario;
import br.com.gt.model.Usuario;
import br.com.gt.view.acesso.login.LoginView;
import br.com.gt.view.principal.PrincipalFuncionarioView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class PrincipalFuncionarioController implements ActionListener{

    private PrincipalFuncionarioView telaPrincipal;
    Connection connection;
    Funcionario funcionario;
    FuncionarioDAO funcionarioDAO;
    LoginView telaLogin;
    
    public PrincipalFuncionarioController(Connection con, Usuario u, LoginView tela) {
        this.connection = con;
        this.telaLogin = tela;
        this.funcionarioDAO = new FuncionarioDAO(this.connection);
        this.funcionario = new Funcionario();
        this.funcionario.setUsuario(u);
        this.funcionario = funcionarioDAO.buscar(funcionario);
        telaPrincipal = new PrincipalFuncionarioView();
        adicionaEventos();
        this.telaPrincipal.getInfoUsuarioLabel().setText("Logado como "+this.funcionario.getNome().substring(0, this.funcionario.getNome().lastIndexOf(" ")));
        telaPrincipal.setVisible(true);
    }
    
    private void adicionaEventos(){
        this.telaPrincipal.getSairBtn().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.telaPrincipal.getSairBtn())){
            if (JOptionPane.showConfirmDialog(null, "Realmente deseja sair?", null, JOptionPane.YES_NO_OPTION) 
                    == JOptionPane.YES_OPTION){
                this.telaPrincipal.dispose();
                this.telaLogin.setVisible(true);
            }
        }
    }
    
}
