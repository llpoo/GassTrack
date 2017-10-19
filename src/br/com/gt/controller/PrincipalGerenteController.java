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
import br.com.gt.dao.AquisicaoDAO;
import br.com.gt.dao.UsuarioDAO;
import br.com.gt.dao.VendaDAO;
import br.com.gt.model.Fornecedor;
import br.com.gt.model.Funcionario;
import br.com.gt.model.Item;
import br.com.gt.model.Aquisicao;
import br.com.gt.model.PessoaFisica;
import br.com.gt.model.Usuario;
import br.com.gt.model.Venda;
import br.com.gt.view.acesso.login.LoginView;
import br.com.gt.view.principal.PrincipalGerenteView;
import br.com.gt.view.principal.util.AcessorioTableModel;
import br.com.gt.view.principal.util.ClienteTableModel;
import br.com.gt.view.principal.util.FornecedorTableModel;
import br.com.gt.view.principal.util.FuncionarioTableModel;
import br.com.gt.view.principal.util.MaterialTableModel;
import br.com.gt.view.principal.util.VendaEmAbertoTableModel;
import br.com.gt.view.principal.util.VendaTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

/**
 *
 * @author lucas
 */
public class PrincipalGerenteController implements ActionListener, MouseListener,CaretListener{

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
    private ArrayList<Venda> vendas;
    private VendaDAO vendaDAO;
    private ArrayList<Funcionario> funcionariosDesativados;
    
    Connection connection;
    Usuario usuario;
    LoginView telaLogin;
    
    public PrincipalGerenteController(Connection con, Usuario u,LoginView tela) {
        this.connection = con;
        this.usuario = u;
        this.telaLogin = tela;
        this.funcionariosDesativados = new ArrayList<>();
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
        
        this.vendaDAO = new VendaDAO(this.connection);
        atualizaTableVenda(null);
        
        this.aquisicaoDao= new AquisicaoDAO(this.connection);
        
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
            int index = this.telaPrincipal.getFuncionarioTable().getSelectedRow();
            if(index >= 0){
                AlterarFuncionarioController alterarController = new AlterarFuncionarioController(this.connection, this.funcionarios.get(index));
                atualizaTableFuncionario(null);
            }else{
                JOptionPane.showMessageDialog(null, "Selecoine um funcionário na tabela");
            }
            
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getExcluirFuncionarioBtn())){
            int index = this.telaPrincipal.getFuncionarioTable().getSelectedRow();
            if(index >= 0){
                if (JOptionPane.showConfirmDialog(null, "Deseja desativar o funcionário "+
                    this.funcionarios.get(index).getNome()+"?", null, JOptionPane.YES_NO_OPTION) 
                    == JOptionPane.YES_OPTION){
                Usuario u = new Usuario();
                u.setId(0);
                
                UsuarioDAO uDao = new UsuarioDAO(this.connection);
                uDao.excluir(this.funcionarios.get(index).getUsuario());
                
                this.funcionarios.get(index).setUsuario(u);
                this.funcionarioDao.alterar(this.funcionarios.get(index));
                atualizaTableFuncionario(null);
                    atualizaTableVenda(null);
            }
            }else{
                JOptionPane.showMessageDialog(null, "Selecoine um funcionário na tabela");
            }
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getNovoFornecedorBtn())){
            Fornecedor fornecedor = new Fornecedor();
            CadastrarFornecedorController cadastrarControllerFornecedor = new CadastrarFornecedorController(this.connection,fornecedor);
            this.fornecedores.add(fornecedor);
            atualizaTableFornecedor(null);
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getAlterarFornecedorBtn())){
            int index = this.telaPrincipal.getFornecedorTable().getSelectedRow();
            if(index >= 0){
                AlterarFornecedorController alterarControllerFornecedor = new AlterarFornecedorController(this.connection, this.fornecedores.get(index));
                atualizaTableFornecedor(null);
            }else{
                JOptionPane.showMessageDialog(null, "Selecione um fornecedor na tabela");
            }
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getExcluirFornecedorBtn())){
            int index = this.telaPrincipal.getFornecedorTable().getSelectedRow();
            if(index >= 0){
                if(this.fornecedorDao.possuiAquisicoes(this.fornecedores.get(index))==true){
                    JOptionPane.showMessageDialog(null, "O fornecedor não pode ser sxcluído, pois possui aquisições em seu nome");
                }else{
                    if (JOptionPane.showConfirmDialog(null, "Deseja excluir o registro do fornecedor "+
                    this.fornecedores.get(index).getNome()+"?", null, JOptionPane.YES_NO_OPTION) 
                    == JOptionPane.YES_OPTION){
                        this.fornecedorDao.excluir(this.fornecedores.get(index));
                        this.fornecedores.remove(index);
                        atualizaTableFornecedor(null);
                    }
                }
                
            }else{
                JOptionPane.showMessageDialog(null, "Selecione um fornecedor na tabela");
            }
        }           
        
        if(evento.getSource().equals(this.telaPrincipal.getClientes_novoBtn())){
            CadastrarClienteController cadastrarClienteController = new CadastrarClienteController(this.connection);
            atualizaTableCliente(null);
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getAlterarClienteBtn())){
            int index = this.telaPrincipal.getClienteTable().getSelectedRow();
            if(index >= 0){
                AlterarClienteController alterarClienteController = new AlterarClienteController(this.connection, this.clientes.get(index));
                atualizaTableCliente(null);
            }else{
                JOptionPane.showMessageDialog(null, "Selecione um cliente na tabela");
            }
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getExcluirClienteBtn())){
            int index = this.telaPrincipal.getClienteTable().getSelectedRow();
            if(index >= 0){
                if(this.clienteDao.possuiCompras(this.clientes.get(index)) == true){
                        JOptionPane.showMessageDialog(null, "Este cliente não pode ser excluído, pois possui compras em seu nome");
                }else{
                    if (JOptionPane.showConfirmDialog(null, "Deseja excluir o registro do cliente "+
                        this.clientes.get(index).getNome()+"?", null, JOptionPane.YES_NO_OPTION) 
                        == JOptionPane.YES_OPTION){
                            this.clienteDao.excluir(this.clientes.get(index));
                            this.clientes.remove(index);
                            atualizaTableCliente(null);
                        }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Selecione um cliente na tabela");
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
            int index = this.telaPrincipal.getAcessorioTable().getSelectedRow();
            if(index >= 0){
                Item item= this.acessorios.get(index);
                AlterarItemController alterarControllerItem = new AlterarItemController(this.connection, item);

                if(item.isIsAcessorio()==false){
                    atualizaTableMaterial(null);
                }else{
                    atualizaTableAcessorio(null);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Selecione um acessório na tabela");
            }
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getAlterarMaterialBtn())){
            int index = this.telaPrincipal.getMaterialTable().getSelectedRow();
            if(index >= 0){
                Item item= this.materiais.get(index);
                boolean backupIsAcessorio = item.isIsAcessorio();
                AlterarItemController alterarControllerItem = new AlterarItemController(this.connection, item);

                atualizaTableAcessorio(null);
                atualizaTableMaterial(null);
            }else{
                JOptionPane.showMessageDialog(null, "Selecione um material na tabela");
            }
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getExcluirAcessorioBtn())){
            int index = this.telaPrincipal.getAcessorioTable().getSelectedRow();
            if(index >= 0){
                if(this.itemDao.foiVendido(this.acessorios.get(index)) == true){
                    JOptionPane.showMessageDialog(null, "Este acessório não pode ser excluído, possui está presente em uma ou mais vendas");
                }else{
                    if (JOptionPane.showConfirmDialog(null, "Deseja excluir o registro do acessorio "+
                    this.acessorios.get(index).getNome()+"?", null, JOptionPane.YES_NO_OPTION) 
                    == JOptionPane.YES_OPTION){
                        this.itemDao.excluir(this.acessorios.get(index));
                        this.acessorios.remove(index);
                        atualizaTableAcessorio(null);
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Selecione um acessório na tabela");
            }
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getExcluirMaterialBtn())){
            int index = this.telaPrincipal.getMaterialTable().getSelectedRow();
            if(index >= 0){
                if(this.itemDao.foiVendido(this.materiais.get(index)) == true){
                    JOptionPane.showMessageDialog(null, "Este material não pode ser excluído, pois está presente em uma ou mais vendas");
                }else{
                    if (JOptionPane.showConfirmDialog(null, "Deseja excluir o registro do material "+
                    this.materiais.get(index).getNome()+"?", null, JOptionPane.YES_NO_OPTION) 
                    == JOptionPane.YES_OPTION){
                        this.itemDao.excluir(this.materiais.get(index));
                        this.materiais.remove(index);
                        atualizaTableMaterial(null);
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Selecione um material na tabela");
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
            int index = this.telaPrincipal.getAcessorioTable().getSelectedRow();
            if(index >= 0){
                Item item = this.acessorios.get(index);
                Aquisicao aquisicao= new Aquisicao();
                CadastrarAquisicaoController cadastrarControllerAquisicao = new CadastrarAquisicaoController(this.connection, aquisicao, item);
                atualizaTableAcessorio(null);
            }else{
                JOptionPane.showMessageDialog(null, "Selecione um acessório na tabela");
            }
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getAddMatEstoqueBtn())){
            int index = this.telaPrincipal.getMaterialTable().getSelectedRow();
            if(index >= 0){
                Item item = this.materiais.get(index);
                Aquisicao aquisicao= new Aquisicao();
                CadastrarAquisicaoController cadastrarControllerAquisicao = new CadastrarAquisicaoController(this.connection, aquisicao, item);
                atualizaTableMaterial(null);
            }else{
                JOptionPane.showMessageDialog(null, "Selecione um material na tabela");
            }
            
        } 
        
        if(evento.getSource().equals(this.telaPrincipal.getVendas_LimparBtn())){
            this.telaPrincipal.getVendas_DataTxt().setDate(null);
            this.telaPrincipal.getVendas_clienteTxt().setText(null);
            this.telaPrincipal.getVendas_funcionarioTxt().setText(null);
            atualizaTableVenda(null);
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getVendas_FiltrarPorDataBtn())){
            if(this.telaPrincipal.getVendas_DataTxt().getDate() != null){
                atualizaTableVenda(vendaDAO.pesquisarByData(this.telaPrincipal.getVendas_DataTxt().getDate()));
            }else{
                JOptionPane.showMessageDialog(null, "Selecione uma data");
            }
        }
        
        
        if(evento.getSource().equals(this.telaPrincipal.getApenasDesativadosCheckBox())){
            if(this.telaPrincipal.getApenasDesativadosCheckBox().isSelected() == true){
                this.telaPrincipal.getFuncionarios_funcionarioTxt().setText(null);
                for(int i = 0; i<this.funcionarios.size(); i++){
                    if(this.funcionarios.get(i).getUsuario().getId() == 0){
                        this.funcionariosDesativados.add(this.funcionarios.get(i));
                    }
                }

                atualizaTableFuncionario(this.funcionariosDesativados);
            }else{
                this.funcionariosDesativados.clear();
                atualizaTableFuncionario(null);
            }
        }
    }
    
    
    
    private void adicionaEventos(){
        this.telaPrincipal.getAlterarAcessoBtn().addActionListener(this);
        this.telaPrincipal.getFuncionarioTable().addMouseListener(this);
        
        this.telaPrincipal.getSairBtn().addActionListener(this);
        this.telaPrincipal.getFuncionarios_novoBtn().addActionListener(this);
        this.telaPrincipal.getAlterarFuncionarioBtn().addActionListener(this);
        this.telaPrincipal.getExcluirFuncionarioBtn().addActionListener(this);
        this.telaPrincipal.getFuncionarios_funcionarioTxt().addCaretListener(this);
        
        this.telaPrincipal.getNovoFornecedorBtn().addActionListener(this);
        this.telaPrincipal.getAlterarFornecedorBtn().addActionListener(this);
        this.telaPrincipal.getExcluirFornecedorBtn().addActionListener(this);
        this.telaPrincipal.getFornecedorTxt().addCaretListener(this);
        
        this.telaPrincipal.getClientes_novoBtn().addActionListener(this);
        this.telaPrincipal.getAlterarClienteBtn().addActionListener(this);
        this.telaPrincipal.getExcluirClienteBtn().addActionListener(this);
        this.telaPrincipal.getClientes_clienteTxt().addCaretListener(this);
        
        this.telaPrincipal.getNovoItemBtn().addActionListener(this);
        this.telaPrincipal.getAlterarAcessorioBtn().addActionListener(this);
        this.telaPrincipal.getAlterarMaterialBtn().addActionListener(this);
        this.telaPrincipal.getExcluirAcessorioBtn().addActionListener(this);
        this.telaPrincipal.getExcluirMaterialBtn().addActionListener(this);
        this.telaPrincipal.getItemTxt().addCaretListener(this);
        this.telaPrincipal.getMaterial_baixaSelectBox().addActionListener(this);
        this.telaPrincipal.getAcessorio_baixaSelectBox().addActionListener(this);
        this.telaPrincipal.getAddAceEstoqueBtn().addActionListener(this);
        this.telaPrincipal.getAddMatEstoqueBtn().addActionListener(this);
        this.telaPrincipal.getVendas_clienteTxt().addActionListener(this);
        this.telaPrincipal.getVendas_funcionarioTxt().addActionListener(this);
        this.telaPrincipal.getVendas_FiltrarPorDataBtn().addActionListener(this);
        
        this.telaPrincipal.getFornecedorTable().addMouseListener(this);
        this.telaPrincipal.getClienteTable().addMouseListener(this);
        this.telaPrincipal.getMaterialTable().addMouseListener(this);
        this.telaPrincipal.getAcessorioTable().addMouseListener(this);
        
        this.telaPrincipal.getVendas_clienteTxt().addCaretListener(this);
        this.telaPrincipal.getVendas_funcionarioTxt().addCaretListener(this);
        this.telaPrincipal.getVendas_LimparBtn().addActionListener(this);
        
        this.telaPrincipal.getApenasDesativadosCheckBox().addActionListener(this);
    }

    private void atualizaTableFuncionario(ArrayList<Funcionario> funcionarios) {
        if(funcionarios == null){
            this.funcionarios = funcionarioDao.listar();
            FuncionarioTableModel funcionarioModel = new FuncionarioTableModel(this.funcionarios);
            this.telaPrincipal.getFuncionarioTable().setModel(funcionarioModel);
            this.telaPrincipal.getApenasDesativadosCheckBox().setSelected(false);
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

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(this.telaPrincipal.getFuncionarioTable())){
            if(e.getClickCount() == 2){
                int index = this.telaPrincipal.getFuncionarioTable().getSelectedRow();
                MostrarFuncionarioController mostrarFuncionarioController = new MostrarFuncionarioController(this.connection,this.funcionarios.get(index));
             }
        }
        
        if(e.getSource().equals(this.telaPrincipal.getClienteTable())){
            if(e.getClickCount() == 2){
                int index = this.telaPrincipal.getClienteTable().getSelectedRow();
                MostrarClienteController MostrarClienteController = new MostrarClienteController(this.connection, this.clientes.get(index));
            }
        }
        
        if(e.getSource().equals(this.telaPrincipal.getFornecedorTable())){
            if(e.getClickCount() == 2){
                int index = this.telaPrincipal.getFornecedorTable().getSelectedRow();
                MostrarFornecedorController mostrarFornecedorController = new MostrarFornecedorController(this.connection,this.fornecedores.get(index));
            }
        }
        
        if(e.getSource().equals(this.telaPrincipal.getMaterialTable())){
            if(e.getClickCount() == 2){
                int index = this.telaPrincipal.getMaterialTable().getSelectedRow();
                MostrarItemController mostrarMaterialController = new MostrarItemController(this.connection,this.materiais.get(index));
                atualizaTableMaterial(null);
                atualizaTableAcessorio(null);
            }
        }
        
        if(e.getSource().equals(this.telaPrincipal.getAcessorioTable())){
            if(e.getClickCount() == 2){
                int index = this.telaPrincipal.getAcessorioTable().getSelectedRow();
                MostrarItemController mostrarAcessorioController = new MostrarItemController(this.connection,this.acessorios.get(index));
            }
        }
        
        if(e.getSource().equals(this.telaPrincipal.getVendas_DataTxt())){
            if(this.telaPrincipal.getVendas_DataTxt().getDate() != null){
                atualizaTableVenda(vendaDAO.pesquisarByData(this.telaPrincipal.getVendas_DataTxt().getDate()));
            }else{
                atualizaTableVenda(null);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void atualizaTableVenda(ArrayList<Venda> vendas) {
        if(vendas == null){
            this.vendas = vendaDAO.listar();
            VendaTableModel vendaModel = new VendaTableModel(this.vendas);
            this.telaPrincipal.getVendasTable().setModel(vendaModel);
        }else{
            VendaTableModel vendaModel = new VendaTableModel(vendas);
            this.telaPrincipal.getVendasTable().setModel(vendaModel);
        }
    }

    @Override
    public void caretUpdate(CaretEvent evento) {
        if(evento.getSource().equals(this.telaPrincipal.getVendas_clienteTxt())){
            if(this.telaPrincipal.getVendas_clienteTxt().getText().length() > 0){
                atualizaTableVenda(vendaDAO.pesquisar(this.telaPrincipal.getVendas_clienteTxt().getText()));
            }else{
                if(this.telaPrincipal.getVendas_funcionarioTxt().getText().length() == 0)
                atualizaTableVenda(null);
            }
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getVendas_funcionarioTxt())){
            
            if(this.telaPrincipal.getVendas_funcionarioTxt().getText().length() > 0){
                atualizaTableVenda(vendaDAO.pesquisarByFuncionario(this.telaPrincipal.getVendas_funcionarioTxt().getText()));
            }else{
                if(this.telaPrincipal.getVendas_clienteTxt().getText().length() == 0){
                    atualizaTableVenda(null);
                }
                
            }
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getFuncionarios_funcionarioTxt())){
            String nomeFuncionario = this.telaPrincipal.getFuncionarios_funcionarioTxt().getText();
            if(nomeFuncionario.length() == 0){
                atualizaTableFuncionario(null);
            }else{
                this.funcionarios = funcionarioDao.pesquisar(nomeFuncionario);
                atualizaTableFuncionario(this.funcionarios);
            }
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getFornecedorTxt())){
            String nomeFornecedor = this.telaPrincipal.getFornecedorTxt().getText();
            if(nomeFornecedor.length() == 0){
                atualizaTableFornecedor(null);
            }else{
                this.fornecedores = fornecedorDao.pesquisar(nomeFornecedor);
                atualizaTableFornecedor(this.fornecedores);
            }
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getClientes_clienteTxt())){
            String nomeCliente = this.telaPrincipal.getClientes_clienteTxt().getText();
            if(nomeCliente.length() == 0){
                atualizaTableCliente(null);
            }else{
                this.clientes = clienteDao.pesquisar(nomeCliente);
                atualizaTableCliente(this.clientes);
            }
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getItemTxt())){
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
    }
} 
