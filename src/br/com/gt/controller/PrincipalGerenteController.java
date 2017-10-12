package br.com.gt.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.com.gt.dao.FuncionarioDAO;
import br.com.gt.model.Funcionario;
import br.com.gt.view.principal.PrincipalGerenteView;
import br.com.gt.view.principal.util.FuncionarioTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class PrincipalGerenteController implements ActionListener{

    private PrincipalGerenteView telaPrincipal;
    private ArrayList<Funcionario> funcionarios;
    FuncionarioTableModel funcionarioModel;
    private FuncionarioDAO funcionarioDao;
    Connection connection;
    
    public PrincipalGerenteController(Connection con) {
        this.connection = con;
        telaPrincipal = new PrincipalGerenteView();
        adicionaEventos();
        listarFuncionarios();
        telaPrincipal.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(this.telaPrincipal.getSairBtn())){
            this.telaPrincipal.dispose();
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getVendedores_novoBtn())){
            Funcionario funcionario = new Funcionario();
            CadastrarVendedorController cadastrarController = new CadastrarVendedorController(this.connection,funcionario);
            this.funcionarios.add(funcionario);
            listarFuncionarios();
        }
    }
    
    private void adicionaEventos(){
        this.telaPrincipal.getSairBtn().addActionListener(this);
        this.telaPrincipal.getVendedores_novoBtn().addActionListener(this);
    }

    private void listarFuncionarios() {
        this.funcionarioDao = new FuncionarioDAO(this.connection);
        this.funcionarios = new ArrayList<>();
        this.funcionarios = funcionarioDao.listar();
        
        funcionarioModel = new FuncionarioTableModel(this.funcionarios);
        
        this.telaPrincipal.getFuncionarioTable().setModel(funcionarioModel);
    }
} 