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

/**
 *
 * @author lucas
 */
public class PrincipalGerenteController implements ActionListener{

    private PrincipalGerenteView telaPrincipal;
    private ArrayList<Funcionario> funcionarios;
    private FuncionarioDAO funcionarioDao;
    Connection connection;
    
    public PrincipalGerenteController(Connection con) {
        this.connection = con;
        telaPrincipal = new PrincipalGerenteView();
        adicionaEventos();
        
        //Lista todos os funcionários
        this.funcionarioDao = new FuncionarioDAO(this.connection);
        this.funcionarios = funcionarioDao.listar();
        
        atualizaTableModel(this.funcionarios);
        //----------->
        
        telaPrincipal.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(this.telaPrincipal.getSairBtn())){
            this.telaPrincipal.dispose();
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getFuncionarios_novoBtn())){
            Funcionario funcionario = new Funcionario();
            CadastrarFuncionarioController cadastrarController = new CadastrarFuncionarioController(this.connection,funcionario);
            this.funcionarios.add(funcionario);
            atualizaTableModel(this.funcionarios);
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getAlterarFuncionarioBtn())){
            int index = this.telaPrincipal.getFuncionarioTable().getSelectedRow();
            AlterarFuncionarioController alterarController = new AlterarFuncionarioController(this.connection, this.funcionarios.get(index), this.funcionarios, index);
            atualizaTableModel(this.funcionarios);
        }
    }
    
    private void adicionaEventos(){
        this.telaPrincipal.getSairBtn().addActionListener(this);
        this.telaPrincipal.getFuncionarios_novoBtn().addActionListener(this);
        this.telaPrincipal.getAlterarFuncionarioBtn().addActionListener(this);
    }

    private void atualizaTableModel(ArrayList<Funcionario> funcionarios) {
        FuncionarioTableModel funcionarioModel = new FuncionarioTableModel(funcionarios);
        this.telaPrincipal.getFuncionarioTable().setModel(funcionarioModel);
    }
} 