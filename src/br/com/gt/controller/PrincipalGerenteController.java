package br.com.gt.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.com.gt.dao.ClienteDAO;
import br.com.gt.dao.FornecedorDAO;
import br.com.gt.dao.FuncionarioDAO;
import br.com.gt.model.Fornecedor;
import br.com.gt.model.Funcionario;
import br.com.gt.model.PessoaFisica;
import br.com.gt.view.principal.PrincipalGerenteView;
import br.com.gt.view.principal.util.ClienteTableModel;
import br.com.gt.view.principal.util.FornecedorTableModel;
import br.com.gt.view.principal.util.FuncionarioTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
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
    private ClienteDAO clienteDao;
    private ArrayList<PessoaFisica> clientes;
    Connection connection;
    
    public PrincipalGerenteController(Connection con) {
        this.connection = con;
        telaPrincipal = new PrincipalGerenteView();
        adicionaEventos();
        
        this.funcionarioDao = new FuncionarioDAO(this.connection);
        atualizaTableFuncionario(null);
        
        this.fornecedorDao = new FornecedorDAO(this.connection);
        atualizaTableFornecedor(null);
        
        this.clienteDao = new ClienteDAO(this.connection);
        atualizaTableCliente(null);
        
        telaPrincipal.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(this.telaPrincipal.getSairBtn())){
            this.telaPrincipal.dispose();
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getFuncionarios_novoBtn())){
            Funcionario funcionario = new Funcionario();
            CadastrarFuncionarioController cadastrarController = new CadastrarFuncionarioController(this.connection);
            atualizaTableFuncionario(null);
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getAlterarFuncionarioBtn())){
            AlterarFuncionarioController alterarController = new AlterarFuncionarioController(this.connection, this.funcionarios.get(this.telaPrincipal.getFuncionarioTable().getSelectedRow()));
            atualizaTableFuncionario(null);
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getExcluirFuncionarioBtn())){
            int index = this.telaPrincipal.getFuncionarioTable().getSelectedRow();
            if (JOptionPane.showConfirmDialog(null, "Deseja excluir o registro do funcionário "+
                    this.funcionarios.get(index).getNome()+"?", null, JOptionPane.YES_NO_OPTION) 
                    == JOptionPane.YES_OPTION){
                this.funcionarioDao.excluir(this.funcionarios.get(index));
                this.funcionarios.remove(index);
                atualizaTableFuncionario(null);
            }
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getFuncionarios_BuscaBtn()) ||
           evento.getSource().equals(this.telaPrincipal.getFuncionarios_funcionarioTxt())){
            String nomeFuncionario = this.telaPrincipal.getFuncionarios_funcionarioTxt().getText();
            if(nomeFuncionario.length() == 0){
                atualizaTableFuncionario(null);
            }else{
                this.funcionarios = funcionarioDao.pesquisar(nomeFuncionario);
                atualizaTableFuncionario(this.funcionarios);
            }
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getMostrarFuncionarioBtn())){
            int index = this.telaPrincipal.getFuncionarioTable().getSelectedRow();
            MostrarFuncionarioController mostrarFuncionarioController = new MostrarFuncionarioController(this.connection,this.funcionarios.get(index));
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getNovoFornecedorBtn())){
            Fornecedor fornecedor = new Fornecedor();
            CadastrarFornecedorController cadastrarControllerFornecedor = new CadastrarFornecedorController(this.connection,fornecedor);
            this.fornecedores.add(fornecedor);
            atualizaTableFornecedor(null);
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getAlterarFornecedorBtn())){
            AlterarFornecedorController alterarControllerFornecedor = new AlterarFornecedorController(this.connection, this.fornecedores.get(this.telaPrincipal.getFornecedorTable().getSelectedRow()));
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
        
        
        
        if(evento.getSource().equals(this.telaPrincipal.getClientes_novoBtn())){
            CadastrarClienteController cadastrarClienteController = new CadastrarClienteController(this.connection);
            atualizaTableCliente(null);
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getAlterarClienteBtn())){
            int index = this.telaPrincipal.getClienteTable().getSelectedRow();
            AlterarClienteController alterarClienteController = new AlterarClienteController(this.connection, this.clientes.get(index));
            atualizaTableCliente(null);
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getMostrarClienteBtn())){
            int index = this.telaPrincipal.getClienteTable().getSelectedRow();
            MostrarClienteController MostrarClienteController = new MostrarClienteController(this.connection, this.clientes.get(index));
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getExcluirClienteBtn())){
            int index = this.telaPrincipal.getClienteTable().getSelectedRow();
            if (JOptionPane.showConfirmDialog(null, "Deseja excluir o registro do cliente "+
                    this.clientes.get(index).getNome()+"?", null, JOptionPane.YES_NO_OPTION) 
                    == JOptionPane.YES_OPTION){
                this.clienteDao.excluir(this.clientes.get(index));
                this.clientes.remove(index);
                atualizaTableCliente(null);
            }
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getClientes_clienteBuscaBtn()) ||
           evento.getSource().equals(this.telaPrincipal.getClientes_clienteTxt())){
            String nomeCliente = this.telaPrincipal.getClientes_clienteTxt().getText();
            if(nomeCliente.length() == 0){
                atualizaTableCliente(null);
            }else{
                this.clientes = clienteDao.pesquisar(nomeCliente);
                atualizaTableCliente(this.clientes);
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
        this.telaPrincipal.getMostrarFuncionarioBtn().addActionListener(this);
        
        this.telaPrincipal.getNovoFornecedorBtn().addActionListener(this);
        this.telaPrincipal.getAlterarFornecedorBtn().addActionListener(this);
        this.telaPrincipal.getExcluirFornecedorBtn().addActionListener(this);
        this.telaPrincipal.getFornecedorBuscaBtn().addActionListener(this);
        this.telaPrincipal.getFornecedorTxt().addActionListener(this);
        
        this.telaPrincipal.getClientes_novoBtn().addActionListener(this);
        this.telaPrincipal.getAlterarClienteBtn().addActionListener(this);
        this.telaPrincipal.getMostrarClienteBtn().addActionListener(this);
        this.telaPrincipal.getExcluirClienteBtn().addActionListener(this);
        this.telaPrincipal.getClientes_clienteBuscaBtn().addActionListener(this);
        this.telaPrincipal.getClientes_clienteTxt().addActionListener(this);
    }

    private void atualizaTableFuncionario(ArrayList<Funcionario> funcionarios) {
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

    private void atualizaTableCliente(ArrayList<PessoaFisica> clientes) {
        if(clientes == null){
            this.clientes = clienteDao.listar();
            ClienteTableModel clienteModel = new ClienteTableModel(this.clientes);
            this.telaPrincipal.getClienteTable().setModel(clienteModel);
        }else{
            ClienteTableModel clienteModel = new ClienteTableModel(clientes);
            this.telaPrincipal.getClienteTable().setModel(clienteModel);
        }
    }
} 
