package br.com.gt.controller;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import br.com.gt.dao.ClienteDAO;
import br.com.gt.dao.FornecedorDAO;
import br.com.gt.dao.FuncionarioDAO;
import br.com.gt.dao.ItemDAO;
import br.com.gt.model.Fornecedor;
import br.com.gt.model.Funcionario;
import br.com.gt.model.Item;
import br.com.gt.model.PessoaFisica;
import br.com.gt.model.Usuario;
import br.com.gt.view.acesso.login.LoginView;
import br.com.gt.view.principal.PrincipalGerenteView;
import br.com.gt.view.principal.util.AcessorioTableModel;
import br.com.gt.view.principal.util.ClienteTableModel;
import br.com.gt.view.principal.util.FornecedorTableModel;
import br.com.gt.view.principal.util.FuncionarioTableModel;
import br.com.gt.view.principal.util.MaterialTableModel;
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
    private ClienteDAO clienteDao;
    private ArrayList<PessoaFisica> clientes;
    private ItemDAO itemDao;
    private ArrayList<Item> materiais;
    private ArrayList<Item> acessorios;
    private AquisicaoDAO aquisicaoDao;
   // private ArrayList<Aquisicao> aquisicoes;
    
    Connection connection;
    Usuario usuario;
    LoginView telaLogin;
    
    public PrincipalGerenteController(Connection con, Usuario u,LoginView tela) {
        this.connection = con;
        this.usuario = u;
        this.telaLogin = tela;
        telaPrincipal = new PrincipalGerenteView();
        adicionaEventos();
        
        this.funcionarioDao = new FuncionarioDAO(this.connection);
        atualizaTableFuncionario(null);
        
        this.fornecedorDao = new FornecedorDAO(this.connection);
        atualizaTableFornecedor(null);
        
        this.clienteDao = new ClienteDAO(this.connection);
        atualizaTableCliente(null);
        
        this.itemDao = new ItemDAO(this.connection);
        atualizaTableMaterial(null);
        atualizaTableAcessorio(null);
        
        this.aquisicaoDao= new AquisicaoDAO(this.connection);
        //atualizaTableAquisicao(null);
        
        telaPrincipal.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(this.telaPrincipal.getAlterarAcessoBtn())){
            Usuario backupUsuario = new Usuario();
            backupUsuario.setUsuario(this.usuario.getUsuario());
            backupUsuario.setSenha(this.usuario.getSenha());
            AlterarUsuarioController alterarUsuarioController = new AlterarUsuarioController(this.connection,this.usuario);
            if(backupUsuario.getUsuario().equals(this.usuario.getUsuario()) == false || backupUsuario.getSenha().equals(this.usuario.getSenha()) == false){
                this.telaPrincipal.dispose();
                this.telaLogin.setVisible(true);
            }
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getSairBtn())){
            if (JOptionPane.showConfirmDialog(null, "Realmente deseja sair?", null, JOptionPane.YES_NO_OPTION) 
                    == JOptionPane.YES_OPTION){
                this.telaPrincipal.dispose();
                this.telaLogin.setVisible(true);
            }
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
        
        if(evento.getSource().equals(this.telaPrincipal.getMostrarFornecedorBtn())){
            int index = this.telaPrincipal.getFornecedorTable().getSelectedRow();
            MostrarFornecedorController mostrarFornecedorController = new MostrarFornecedorController(this.connection,this.fornecedores.get(index));
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
        
        if(evento.getSource().equals(this.telaPrincipal.getNovoItemBtn())){
            Item item = new Item();
            CadastrarItemController cadastrarControllerItem = new CadastrarItemController(this.connection,item);
            
            if(item.isIsAcessorio()==false){
                this.materiais.add(item);
                atualizaTableMaterial(null);
            }else{
                this.acessorios.add(item);
                atualizaTableAcessorio(null);
            }
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getAlterarAcessorioBtn())){
            Item item= this.acessorios.get(this.telaPrincipal.getAcessorioTable().getSelectedRow());
            AlterarItemController alterarControllerItem = new AlterarItemController(this.connection, item);
            
            if(item.isIsAcessorio()==false){
                atualizaTableMaterial(null);
            }else{
                atualizaTableAcessorio(null);
            }
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getAlterarMaterialBtn())){
            Item item= this.materiais.get(this.telaPrincipal.getMaterialTable().getSelectedRow());
            boolean backupIsAcessorio = item.isIsAcessorio();
            AlterarItemController alterarControllerItem = new AlterarItemController(this.connection, item);
            
            atualizaTableAcessorio(null);
            atualizaTableMaterial(null);
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getExcluirAcessorioBtn())){
            int index = this.telaPrincipal.getAcessorioTable().getSelectedRow();
            if (JOptionPane.showConfirmDialog(null, "Deseja excluir o registro do acessorio "+
                    this.acessorios.get(index).getNome()+"?", null, JOptionPane.YES_NO_OPTION) 
                    == JOptionPane.YES_OPTION){
                this.itemDao.excluir(this.acessorios.get(index));
                this.acessorios.remove(index);
                atualizaTableAcessorio(null);
            }
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getExcluirMaterialBtn())){
            int index = this.telaPrincipal.getMaterialTable().getSelectedRow();
            if (JOptionPane.showConfirmDialog(null, "Deseja excluir o registro do material "+
                    this.materiais.get(index).getNome()+"?", null, JOptionPane.YES_NO_OPTION) 
                    == JOptionPane.YES_OPTION){
                this.itemDao.excluir(this.materiais.get(index));
                this.materiais.remove(index);
                atualizaTableMaterial(null);
            }
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getPesquisarItemBtn()) ||
           evento.getSource().equals(this.telaPrincipal.getItemTxt())){
            String itemNome = this.telaPrincipal.getItemTxt().getText();
            
            if(itemNome.length() == 0){
                atualizaTableAcessorio(null);
                atualizaTableMaterial(null);
            }else{
                ArrayList<Item> itens = itemDao.pesquisar(itemNome);
                this.acessorios.clear();
                this.materiais.clear();
                
                for(int i=0; i<itens.size(); i++){
                    if(itens.get(i).isIsAcessorio() == true){
                        this.acessorios.add(itens.get(i));
                    }else{
                        if(itens.get(i).isIsAcessorio() == false){
                            this.materiais.add(itens.get(i));
                        }
                    }
                }
                
                atualizaTableAcessorio(this.acessorios);
                atualizaTableMaterial(this.materiais);
            }
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getAcessorio_baixaSelectBox())){
            if(this.telaPrincipal.getAcessorio_baixaSelectBox().isSelected()==true){
                ArrayList<Item> itens = itemDao.listarAcessorioBaixa();
                this.acessorios.clear();
                for(int i=0; i<itens.size(); i++){
                    this.acessorios.add(itens.get(i));
                }
                atualizaTableAcessorio(this.acessorios);
            }else{
                this.acessorios.clear();
                ArrayList<Item> itens = itemDao.listarAcessorio();
                for(int i=0; i<itens.size(); i++){
                    this.acessorios.add(itens.get(i));
                }
                atualizaTableAcessorio(acessorios);
            }
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getMaterial_baixaSelectBox())){
            if(this.telaPrincipal.getMaterial_baixaSelectBox().isSelected()==true){
                ArrayList<Item> itens = itemDao.listarMaterialBaixa();
                this.materiais.clear();
                for(int i=0; i<itens.size(); i++){
                    this.materiais.add(itens.get(i));
                }
                atualizaTableMaterial(this.materiais);
            }else{
                this.materiais.clear();
                ArrayList<Item> itens = itemDao.listarMaterial();
                for(int i=0; i<itens.size(); i++){
                    this.materiais.add(itens.get(i));
                }
                atualizaTableMaterial(materiais);
            }
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getAddAceEstoqueBtn())){
            Item item = this.acessorios.get(this.telaPrincipal.getAcessorioTable().getSelectedRow());
            Aquisicao aquisicao= new Aquisicao();
            CadastrarAquisicaoController cadastrarControllerAquisicao = new CadastrarAquisicaoController(this.connection, aquisicao, item);
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getAddMatEstoqueBtn())){
            Item item = this.materiais.get(this.telaPrincipal.getMaterialTable().getSelectedRow());
            Aquisicao aquisicao= new Aquisicao();
            CadastrarAquisicaoController cadastrarControllerAquisicao = new CadastrarAquisicaoController(this.connection, aquisicao, item);
        } 
        
        if(evento.getSource().equals(this.telaPrincipal.getMostrarAcessorioBtn())){
            int index = this.telaPrincipal.getAcessorioTable().getSelectedRow();
            MostrarItemController mostrarAcessorioController = new MostrarItemController(this.connection,this.acessorios.get(index));
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getMostrarMaterialBtn())){
            int index = this.telaPrincipal.getMaterialTable().getSelectedRow();
            MostrarItemController mostrarMaterialController = new MostrarItemController(this.connection,this.materiais.get(index));
        }
        
    }
    
    
    
    private void adicionaEventos(){
        this.telaPrincipal.getAlterarAcessoBtn().addActionListener(this);
        
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
        this.telaPrincipal.getMostrarFornecedorBtn().addActionListener(this);
        this.telaPrincipal.getFornecedorTxt().addActionListener(this);
        
        this.telaPrincipal.getClientes_novoBtn().addActionListener(this);
        this.telaPrincipal.getAlterarClienteBtn().addActionListener(this);
        this.telaPrincipal.getMostrarClienteBtn().addActionListener(this);
        this.telaPrincipal.getExcluirClienteBtn().addActionListener(this);
        this.telaPrincipal.getClientes_clienteBuscaBtn().addActionListener(this);
        this.telaPrincipal.getClientes_clienteTxt().addActionListener(this);
        
        this.telaPrincipal.getNovoItemBtn().addActionListener(this);
        this.telaPrincipal.getAlterarAcessorioBtn().addActionListener(this);
        this.telaPrincipal.getAlterarMaterialBtn().addActionListener(this);
        this.telaPrincipal.getExcluirAcessorioBtn().addActionListener(this);
        this.telaPrincipal.getExcluirMaterialBtn().addActionListener(this);
        this.telaPrincipal.getPesquisarItemBtn().addActionListener(this);
        this.telaPrincipal.getItemTxt().addActionListener(this);
        this.telaPrincipal.getMaterial_baixaSelectBox().addActionListener(this);
        this.telaPrincipal.getAcessorio_baixaSelectBox().addActionListener(this);
        this.telaPrincipal.getMostrarAcessorioBtn().addActionListener(this);
        this.telaPrincipal.getMostrarMaterialBtn().addActionListener(this);
        this.telaPrincipal.getAddAceEstoqueBtn().addActionListener(this);
        this.telaPrincipal.getAddMatEstoqueBtn().addActionListener(this);
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

    private void atualizaTableMaterial(ArrayList<Item> materiais) {
        if(materiais == null){
            this.materiais = itemDao.listarMaterial();
            MaterialTableModel materialModel = new MaterialTableModel(this.materiais);
            this.telaPrincipal.getMaterialTable().setModel(materialModel);
        }else{
            MaterialTableModel materialModel = new MaterialTableModel(materiais);
            this.telaPrincipal.getMaterialTable().setModel(materialModel);
        }
    }

    private void atualizaTableAcessorio(ArrayList<Item> acessorios) {
        if(acessorios == null){
            this.acessorios = itemDao.listarAcessorio();
            AcessorioTableModel acessorioModel = new AcessorioTableModel(this.acessorios);
            this.telaPrincipal.getAcessorioTable().setModel(acessorioModel);
        }else{
            AcessorioTableModel acessorioModel = new AcessorioTableModel(acessorios);
            this.telaPrincipal.getAcessorioTable().setModel(acessorioModel);
        }
    }
} 
