package br.com.gt.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.com.gt.dao.FornecedorDAO;
import br.com.gt.dao.FuncionarioDAO;
import br.com.gt.model.Fornecedor;
import br.com.gt.model.Funcionario;
import br.com.gt.view.principal.PrincipalGerenteView;
import br.com.gt.view.principal.util.FornecedorTableModel;
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
    private FuncionarioDAO funcionarioDao;
    private ArrayList<Fornecedor> fornecedores;
    private FornecedorDAO fornecedorDao;
    Connection connection;
    
    public PrincipalGerenteController(Connection con) {
        this.connection = con;
        telaPrincipal = new PrincipalGerenteView();
        adicionaEventos();
        
        this.funcionarioDao = new FuncionarioDAO(this.connection);
        atualizaTableModel(null);
        
        this.fornecedorDao = new FornecedorDAO(this.connection);
        atualizaTableFornecedor(null);
        
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
            atualizaTableModel(null);
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getAlterarFuncionarioBtn())){
            AlterarFuncionarioController alterarController = new AlterarFuncionarioController(this.connection, this.funcionarios.get(this.telaPrincipal.getFuncionarioTable().getSelectedRow()));
            atualizaTableModel(null);
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getExcluirFuncionarioBtn())){
            int index = this.telaPrincipal.getFuncionarioTable().getSelectedRow();
            if (JOptionPane.showConfirmDialog(null, "Deseja excluir o registro do funcionário "+
                    this.funcionarios.get(index).getNome()+"?", null, JOptionPane.YES_NO_OPTION) 
                    == JOptionPane.YES_OPTION){
                this.funcionarioDao.excluir(this.funcionarios.get(index));
                this.funcionarios.remove(index);
                atualizaTableModel(null);
            }
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getFuncionarios_BuscaBtn()) ||
           evento.getSource().equals(this.telaPrincipal.getFuncionarios_funcionarioTxt())){
            String nomeFuncionario = this.telaPrincipal.getFuncionarios_funcionarioTxt().getText();
            if(nomeFuncionario.length() == 0){
                atualizaTableModel(null);
            }else{
                this.funcionarios = funcionarioDao.pesquisar(nomeFuncionario);
                atualizaTableModel(this.funcionarios);
            }
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getNovoFornecedorBtn())){
            Fornecedor fornecedor = new Fornecedor();
            CadastrarFornecedorController cadastrarController = new CadastrarFornecedorController(this.connection,fornecedor);
            this.fornecedores.add(fornecedor);
            atualizaTableFornecedor(null);
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getAlterarFornecedorBtn())){
            AlterarFornecedorController alterarController = new AlterarFornecedorController(this.connection, this.fornecedores.get(this.telaPrincipal.getFornecedorTable().getSelectedRow()));
            atualizaTableFornecedor(null);
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getExcluirFornecedorBtn())){
            int index = this.telaPrincipal.getFornecedorTable().getSelectedRow();
            if (JOptionPane.showConfirmDialog(null, "Deseja excluir o registro do fornecedor "+
                    this.fornecedores.get(index).getNome()+"?", null, JOptionPane.YES_NO_OPTION) 
                    == JOptionPane.YES_OPTION){
                this.fornecedorDao.excluir(this.fornecedores.get(index));
                this.fornecedores.remove(index);
                atualizaTableFornecedor(null);
            }
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getFornecedorBuscaBtn()) ||
           evento.getSource().equals(this.telaPrincipal.getFornecedorTxt())){
            String nomeFornecedor = this.telaPrincipal.getFornecedorTxt().getText();
            if(nomeFornecedor.length() == 0){
                atualizaTableFornecedor(null);
            }else{
                this.fornecedores = fornecedorDao.pesquisar(nomeFornecedor);
                atualizaTableFornecedor(this.fornecedores);
            }
        }
    }
    
    private void adicionaEventos(){
        this.telaPrincipal.getSairBtn().addActionListener(this);
        this.telaPrincipal.getFuncionarios_novoBtn().addActionListener(this);
        this.telaPrincipal.getAlterarFuncionarioBtn().addActionListener(this);
        this.telaPrincipal.getExcluirFuncionarioBtn().addActionListener(this);
        this.telaPrincipal.getFuncionarios_BuscaBtn().addActionListener(this);
        this.telaPrincipal.getFuncionarios_funcionarioTxt().addActionListener(this);
        
        this.telaPrincipal.getNovoFornecedorBtn().addActionListener(this);
        this.telaPrincipal.getAlterarFornecedorBtn().addActionListener(this);
        this.telaPrincipal.getExcluirFornecedorBtn().addActionListener(this);
        this.telaPrincipal.getFornecedorBuscaBtn().addActionListener(this);
        this.telaPrincipal.getFornecedorTxt().addActionListener(this);
    }

    private void atualizaTableModel(ArrayList<Funcionario> funcionarios) {
        if(funcionarios == null){
            this.funcionarios = funcionarioDao.listar();
            FuncionarioTableModel funcionarioModel = new FuncionarioTableModel(this.funcionarios);
            this.telaPrincipal.getFuncionarioTable().setModel(funcionarioModel);
        }else{
            FuncionarioTableModel funcionarioModel = new FuncionarioTableModel(funcionarios);
            this.telaPrincipal.getFuncionarioTable().setModel(funcionarioModel);
        }
    }

    private void atualizaTableFornecedor(ArrayList<Fornecedor> fornecedores) {
        if(fornecedores == null){
            this.fornecedores = fornecedorDao.listar();
            FornecedorTableModel fornecedorModel = new FornecedorTableModel(this.fornecedores);
            this.telaPrincipal.getFornecedorTable().setModel(fornecedorModel);
        }else{
            FornecedorTableModel fornecedorModel = new FornecedorTableModel(fornecedores);
            this.telaPrincipal.getFornecedorTable().setModel(fornecedorModel);
        }
    }
} 