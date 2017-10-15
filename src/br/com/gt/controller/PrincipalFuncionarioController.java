/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.controller;

import br.com.gt.dao.FuncionarioDAO;
import br.com.gt.model.Funcionario;
import br.com.gt.model.Usuario;
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
    
    public PrincipalFuncionarioController(Connection con, Usuario u) {
        this.connection = con;
        this.funcionarioDAO = new FuncionarioDAO(this.connection);
        this.funcionario = new Funcionario();
        this.funcionario.setUsuario(u);
        this.funcionario = funcionarioDAO.buscar(funcionario);
        telaPrincipal = new PrincipalFuncionarioView();
        adicionaEventos();
        telaPrincipal.setVisible(true);
        JOptionPane.showMessageDialog(null, this.funcionario.getNome());
    }
    
    private void adicionaEventos(){
        this.telaPrincipal.getSairBtn().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.telaPrincipal.getSairBtn())){
            this.telaPrincipal.dispose();
        }
    }
    
}
