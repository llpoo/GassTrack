/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.controller;

import br.com.gt.dao.ClienteDAO;
import br.com.gt.dao.FuncionarioDAO;
import br.com.gt.dao.ItemDAO;
import br.com.gt.dao.VendaDAO;
import br.com.gt.model.Funcionario;
import br.com.gt.model.Item;
import br.com.gt.model.PessoaFisica;
import br.com.gt.model.Usuario;
import br.com.gt.model.Venda;
import br.com.gt.view.acesso.login.LoginView;
import br.com.gt.view.principal.PrincipalFuncionarioView;
import br.com.gt.view.principal.util.AcessorioTableModel;
import br.com.gt.view.principal.util.ItensVendaTableModel;
import br.com.gt.view.principal.util.MaterialTableModel;
import br.com.gt.view.principal.util.VendaEmAbertoTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

/**
 *
 * @author lucas
 */
public class PrincipalFuncionarioController implements ActionListener,KeyListener,CaretListener,MouseListener{

    private PrincipalFuncionarioView telaPrincipal;
    private Connection connection;
    private Funcionario funcionario;
    private FuncionarioDAO funcionarioDAO;
    private LoginView telaLogin;
    private ArrayList<Item> materiais;
    private ArrayList<Item> acessorios;
    private ItemDAO itemDAO;
    private ClienteDAO clienteDAO;
    private ArrayList<PessoaFisica> clientes;
    private PessoaFisica cliente;
    private ArrayList<Item> itensDaVenda;
    private ArrayList<Double> quantidades;
    private ArrayList<Venda> vendasEmAberto;
    private VendaDAO vendaDAO;
    int index;
    
    public PrincipalFuncionarioController(Connection con, Usuario u, LoginView tela) {
        this.connection = con;
        this.telaLogin = tela;
        this.itensDaVenda = new ArrayList<>();
        this.quantidades = new ArrayList<>();
        this.clienteDAO = new ClienteDAO(this.connection);
        this.vendaDAO = new VendaDAO(this.connection);
        this.funcionarioDAO = new FuncionarioDAO(this.connection);
        this.funcionario = new Funcionario();
        this.funcionario.setUsuario(u);
        this.funcionario = funcionarioDAO.buscar(funcionario);
        telaPrincipal = new PrincipalFuncionarioView();
        this.telaPrincipal.getAlterarVendaBtn().setEnabled(false);
        adicionaEventos();
        
        this.itemDAO = new ItemDAO(this.connection);
        atualizaTableMaterial(null);
        atualizaTableAcessorio(null);
        atualizaTableVenda(null);
        
        preencheComboBoxMaterial(this.materiais);
        preencheComboBoxAcessorio(this.acessorios);
        
        this.clientes = clienteDAO.listar();
        preencheComboBoxCliente(this.clientes);
        
        this.telaPrincipal.getTituloTxt().setText("Módulo de Vendedor. Logado como "+this.funcionario.getUsuario().getUsuario());
        
        telaPrincipal.setVisible(true);
    }
    
    private void adicionaEventos(){
        this.telaPrincipal.getSairBtn().addActionListener(this);
        this.telaPrincipal.getMaterial_baixaSelectBox().addActionListener(this);
        this.telaPrincipal.getAcessorio_baixaSelectBox().addActionListener(this);
        this.telaPrincipal.getPesquisarItemBtn().addActionListener(this);
        this.telaPrincipal.getItemTxt().addActionListener(this);
        this.telaPrincipal.getClienteComboBox().addActionListener(this);
        this.telaPrincipal.getAddMaterialBtn().addActionListener(this);
        this.telaPrincipal.getAddAcessorioBtn().addActionListener(this);
        this.telaPrincipal.getNovoClienteBtn().addActionListener(this);
        this.telaPrincipal.getMaoDeObraTxt().addKeyListener(this);
        this.telaPrincipal.getDescontoTxt().addKeyListener(this);
        this.telaPrincipal.getMaoDeObraTxt().addCaretListener(this);
        this.telaPrincipal.getDescontoTxt().addCaretListener(this);
        this.telaPrincipal.getAlturaMaterialTxt().addKeyListener(this);
        this.telaPrincipal.getLarguraMaterialTxt().addKeyListener(this);
        this.telaPrincipal.getQuantidadeAcessorioTxt().addKeyListener(this);
        this.telaPrincipal.getExcluirItemBtn().addActionListener(this);
        this.telaPrincipal.getLimparBtn().addActionListener(this);
        this.telaPrincipal.getEncaminharVendaBtn().addActionListener(this);
        this.telaPrincipal.getFinalizarVendaBtn().addActionListener(this);
        this.telaPrincipal.getBuscarVendaBtn().addActionListener(this);
        this.telaPrincipal.getClienteVendaTxt().addActionListener(this);
        this.telaPrincipal.getCancelarVendaBtn().addActionListener(this);
        this.telaPrincipal.getVendasTable().addMouseListener(this);
        this.telaPrincipal.getAlterarVendaBtn().addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(this.telaPrincipal.getAlterarVendaBtn())){
            Venda venda = new Venda();
            
            venda.setId(this.vendasEmAberto.get(index).getId());
            venda.setFuncionario(this.vendasEmAberto.get(index).getFuncionario());
            
            
            if(this.telaPrincipal.getDescontoTxt().getText().length() == 0){
                venda.setDesconto(0);
            }else{
                venda.setDesconto(Double.parseDouble(this.telaPrincipal.getDescontoTxt().getText()));
            }
            venda.setDescricao(this.telaPrincipal.getDescricaoTxt().getText());
            venda.setItens(this.itensDaVenda);
            venda.setQuantidades(this.quantidades);
            venda.setSituacao(false);
            if(this.telaPrincipal.getMaoDeObraTxt().getText().length() == 0){
                venda.setValorMaoDeObra(0);
            }else{
                venda.setValorMaoDeObra(Double.parseDouble(this.telaPrincipal.getMaoDeObraTxt().getText()));
            }
            venda.setValorTotal(Double.parseDouble(this.telaPrincipal.getValorTotalTxt().getText()));
            
            venda.setCliente(this.clientes.get(this.telaPrincipal.getClienteComboBox().getSelectedIndex()));
            
            
            
            vendaDAO.alterar(venda);
            limparTudo();
            atualizaTableVenda(null);
            this.telaPrincipal.getPainelDeGuias().setSelectedIndex(1);
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getCancelarVendaBtn())){
            if (JOptionPane.showConfirmDialog(null, "Realmente deseja cancelar esta venda?", null, JOptionPane.YES_NO_OPTION) 
                    == JOptionPane.YES_OPTION){
                int index = this.telaPrincipal.getVendasTable().getSelectedRow();
                vendaDAO.excluir(this.vendasEmAberto.get(index));
                atualizaTableVenda(null);
            }
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getBuscarVendaBtn()) ||
           evento.getSource().equals(this.telaPrincipal.getClienteVendaTxt())){
            if(this.telaPrincipal.getClienteVendaTxt().getText().length() > 0){
                atualizaTableVenda(vendaDAO.pesquisarEmAberto(this.telaPrincipal.getClienteVendaTxt().getText()));
            }else{
                atualizaTableVenda(null);
            }
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getFinalizarVendaBtn())){
            int index = this.telaPrincipal.getVendasTable().getSelectedRow();
            vendaDAO.baixaEstoque(this.vendasEmAberto.get(index));
            atualizaTableVenda(null);
            atualizaTableMaterial(null);
            atualizaTableAcessorio(null);
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getEncaminharVendaBtn())){
            Venda venda = new Venda();
            
            Date dataAtual = new Date();
            
            venda.setDataAbertura(dataAtual);
            if(this.telaPrincipal.getDescontoTxt().getText().length() == 0){
                venda.setDesconto(0);
            }else{
                venda.setDesconto(Double.parseDouble(this.telaPrincipal.getDescontoTxt().getText()));
            }
            venda.setDescricao(this.telaPrincipal.getDescricaoTxt().getText());
            venda.setItens(this.itensDaVenda);
            venda.setQuantidades(this.quantidades);
            venda.setSituacao(false);
            if(this.telaPrincipal.getMaoDeObraTxt().getText().length() == 0){
                venda.setValorMaoDeObra(0);
            }else{
                venda.setValorMaoDeObra(Double.parseDouble(this.telaPrincipal.getMaoDeObraTxt().getText()));
            }
            venda.setValorTotal(Double.parseDouble(this.telaPrincipal.getValorTotalTxt().getText()));
            venda.setFuncionario(this.funcionario);
            venda.setCliente(this.clientes.get(this.telaPrincipal.getClienteComboBox().getSelectedIndex()));
            
            
            
            vendaDAO.inserir(venda);
            limparTudo();
            atualizaTableVenda(null);
            this.telaPrincipal.getPainelDeGuias().setSelectedIndex(1);
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getLimparBtn())){
            limparTudo();
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getExcluirItemBtn())){
            int index = this.telaPrincipal.getItensTable().getSelectedRow();
            this.itensDaVenda.remove(this.itensDaVenda.get(index));
            this.quantidades.remove(this.quantidades.get(index));
            
            atualizaItensVenda(null,null);
            atualizaValorTotal();
        }
        
        
        if(evento.getSource().equals(this.telaPrincipal.getAddAcessorioBtn())){
            Item i = this.acessorios.get(this.telaPrincipal.getAcessorioComboBox().getSelectedIndex());
            Double quantidade;
            
            quantidade = new Double(Double.parseDouble(this.telaPrincipal.getQuantidadeAcessorioTxt().getText()));
            
            this.itensDaVenda.add(i);
            this.quantidades.add(quantidade);
            
            atualizaItensVenda(null,null);
            atualizaValorTotal();
            limparCampos();
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getAddMaterialBtn())){
            Item i = this.materiais.get(this.telaPrincipal.getMaterialComboBox().getSelectedIndex());
            Double quantidade;
            
            quantidade = new Double((Double.parseDouble(this.telaPrincipal.getLarguraMaterialTxt().getText())/100)*(Double.parseDouble(this.telaPrincipal.getAlturaMaterialTxt().getText())/100));
            
            this.itensDaVenda.add(i);
            this.quantidades.add(quantidade);
            ItensVendaTableModel tableModel = new ItensVendaTableModel(this.itensDaVenda,this.quantidades);
            this.telaPrincipal.getItensTable().setModel(tableModel);
            atualizaValorTotal();
            limparCampos();
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getNovoClienteBtn())){
            CadastrarClienteController cadastrarClienteController = new CadastrarClienteController(this.connection);
            this.clientes = clienteDAO.listar();
            preencheComboBoxCliente(this.clientes);
        }
             
        if(evento.getSource().equals(this.telaPrincipal.getClienteComboBox())){
            if(this.telaPrincipal.getClienteComboBox().getSelectedIndex() != -1){
                    this.telaPrincipal.getCpfClienteTxt().setText(this.clientes.get(this.telaPrincipal.getClienteComboBox().getSelectedIndex()).getCpf());
            }
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getSairBtn())){
            if (JOptionPane.showConfirmDialog(null, "Realmente deseja sair?", null, JOptionPane.YES_NO_OPTION) 
                    == JOptionPane.YES_OPTION){
                this.telaPrincipal.dispose();
                this.telaLogin.setVisible(true);
            }
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getAcessorio_baixaSelectBox())){
            if(this.telaPrincipal.getAcessorio_baixaSelectBox().isSelected()==true){
                ArrayList<Item> itens = itemDAO.listarAcessorioBaixa();
                this.acessorios.clear();
                for(int i=0; i<itens.size(); i++){
                    this.acessorios.add(itens.get(i));
                }
                atualizaTableAcessorio(this.acessorios);
            }else{
                this.acessorios.clear();
                ArrayList<Item> itens = itemDAO.listarAcessorio();
                for(int i=0; i<itens.size(); i++){
                    this.acessorios.add(itens.get(i));
                }
                atualizaTableAcessorio(acessorios);
            }
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getMaterial_baixaSelectBox())){
            if(this.telaPrincipal.getMaterial_baixaSelectBox().isSelected()==true){
                ArrayList<Item> itens = itemDAO.listarMaterialBaixa();
                this.materiais.clear();
                for(int i=0; i<itens.size(); i++){
                    this.materiais.add(itens.get(i));
                }
                atualizaTableMaterial(this.materiais);
            }else{
                this.materiais.clear();
                ArrayList<Item> itens = itemDAO.listarMaterial();
                for(int i=0; i<itens.size(); i++){
                    this.materiais.add(itens.get(i));
                }
                atualizaTableMaterial(materiais);
            }
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getPesquisarItemBtn()) ||
           evento.getSource().equals(this.telaPrincipal.getItemTxt())){
            String itemNome = this.telaPrincipal.getItemTxt().getText();
            
            if(itemNome.length() == 0){
                atualizaTableAcessorio(null);
                atualizaTableMaterial(null);
            }else{
                ArrayList<Item> itens = itemDAO.pesquisar(itemNome);
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
    
    
    private void atualizaTableMaterial(ArrayList<Item> materiais) {
        if(materiais == null){
            this.materiais = itemDAO.listarMaterial();
            MaterialTableModel materialModel = new MaterialTableModel(this.materiais);
            this.telaPrincipal.getMaterialTable().setModel(materialModel);
        }else{
            MaterialTableModel materialModel = new MaterialTableModel(materiais);
            this.telaPrincipal.getMaterialTable().setModel(materialModel);
        }
    }

    private void atualizaTableAcessorio(ArrayList<Item> acessorios) {
        if(acessorios == null){
            this.acessorios = itemDAO.listarAcessorio();
            AcessorioTableModel acessorioModel = new AcessorioTableModel(this.acessorios);
            this.telaPrincipal.getAcessorioTable().setModel(acessorioModel);
        }else{
            AcessorioTableModel acessorioModel = new AcessorioTableModel(acessorios);
            this.telaPrincipal.getAcessorioTable().setModel(acessorioModel);
        }
    }
    
    private void preencheComboBoxMaterial(ArrayList<Item> m){
        if(m.size()==0){
            JOptionPane.showMessageDialog(null, "Não há materiais cadastrados");
        }
           this.telaPrincipal.getMaterialComboBox().removeAllItems();
           int i=0;
           
           do{
             this.telaPrincipal.getMaterialComboBox().addItem(m.get(i).getNome());
             i++;
           }while(m.size()!=i);
           this.telaPrincipal.getMaterialComboBox().setSelectedItem(null);
    }
    
    private void preencheComboBoxAcessorio(ArrayList<Item> a){
        if(a.size()==0){
            JOptionPane.showMessageDialog(null, "Não há acessórios cadastrados");
        }
           this.telaPrincipal.getAcessorioComboBox().removeAllItems();
           int i=0;
           
           do{
             this.telaPrincipal.getAcessorioComboBox().addItem(a.get(i).getNome());
             i++;
           }while(a.size()!=i);
           this.telaPrincipal.getAcessorioComboBox().setSelectedItem(null);
    }

    private void preencheComboBoxCliente(ArrayList<PessoaFisica> c) {
        if(c.size()==0){
            JOptionPane.showMessageDialog(null, "Não há clientes cadastrados");
        }
           this.telaPrincipal.getClienteComboBox().removeAllItems();
           int i=0;
           
           do{
             this.telaPrincipal.getClienteComboBox().addItem(c.get(i).getNome());
             i++;
           }while(c.size()!=i);
           
          this.telaPrincipal.getClienteComboBox().setSelectedItem(null);
          this.telaPrincipal.getCpfClienteTxt().setText(null);
    }

    private void atualizaValorTotal() {
        Double valor = new Double(0);
        for(int i=0; i<this.itensDaVenda.size(); i++){
            valor += this.itensDaVenda.get(i).getPrecoUnitario()*this.quantidades.get(i);
        }
        
        if(this.telaPrincipal.getMaoDeObraTxt().getText().length() > 0){
            valor+=Double.parseDouble(this.telaPrincipal.getMaoDeObraTxt().getText());
        }
        
        if(this.telaPrincipal.getDescontoTxt().getText().length() > 0){
            valor-=(valor*Double.parseDouble(this.telaPrincipal.getDescontoTxt().getText()))/100;
        }
        
        this.telaPrincipal.getValorTotalTxt().setText(valor.toString()+"0");
    }

    private void limparCampos() {
        this.telaPrincipal.getMaterialComboBox().setSelectedItem(null);
        this.telaPrincipal.getAcessorioComboBox().setSelectedItem(null);
        this.telaPrincipal.getAlturaMaterialTxt().setText(null);
        this.telaPrincipal.getLarguraMaterialTxt().setText(null);
        this.telaPrincipal.getQuantidadeAcessorioTxt().setText(null);
    }
    
    private void limparTudo(){
        limparCampos();
        this.telaPrincipal.getMaoDeObraTxt().setText(null);
        this.telaPrincipal.getDescontoTxt().setText(null);
        this.telaPrincipal.getClienteComboBox().setSelectedItem(null);
        this.telaPrincipal.getCpfClienteTxt().setText(null);
        this.telaPrincipal.getDescricaoTxt().setText(null);
        this.telaPrincipal.getValorTotalTxt().setText(null);
        this.itensDaVenda.clear();
        this.telaPrincipal.getAlterarVendaBtn().setEnabled(false);
        this.telaPrincipal.getEncaminharVendaBtn().setEnabled(true);
        atualizaItensVenda(null,null);
    }

    @Override
    public void keyTyped(KeyEvent evento) {
        if(evento.getSource().equals(this.telaPrincipal.getMaoDeObraTxt())){
            if(this.telaPrincipal.getMaoDeObraTxt().getText().length() > 0){
                String caracteres="0987654321.";
                if(!caracteres.contains(evento.getKeyChar()+"")){
                    evento.consume();
                }
            }
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getDescontoTxt())){
            if(this.telaPrincipal.getDescontoTxt().getText().length() > 0){
                String caracteres="0987654321.";
                if(!caracteres.contains(evento.getKeyChar()+"")){
                    evento.consume();
                }
            }
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getAlturaMaterialTxt()) ||
           evento.getSource().equals(this.telaPrincipal.getLarguraMaterialTxt())){
                String caracteres="0987654321.";
                if(!caracteres.contains(evento.getKeyChar()+"")){
                    evento.consume();
                }
        }
        
        if(evento.getSource().equals(this.telaPrincipal.getQuantidadeAcessorioTxt())){
            String caracteres="0987654321";
            if(!caracteres.contains(evento.getKeyChar()+"")){
                evento.consume();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void caretUpdate(CaretEvent evento) {
        if(evento.getSource().equals(this.telaPrincipal.getMaoDeObraTxt()) || evento.getSource().equals(this.telaPrincipal.getDescontoTxt())){
            atualizaValorTotal();
        }
    }

    private void atualizaItensVenda(ArrayList<Item> localItens, ArrayList<Double> localQuantidades) {
        ItensVendaTableModel tableModel;
        if(localItens == null && localQuantidades == null){
            tableModel = new ItensVendaTableModel(this.itensDaVenda,this.quantidades);
        }else{
            tableModel = new ItensVendaTableModel(localItens,localQuantidades);
        }
        
        this.telaPrincipal.getItensTable().setModel(tableModel);
    }

    private void atualizaTableVenda(ArrayList<Venda> vendas) {
        if(vendas == null){
            this.vendasEmAberto = vendaDAO.listarVendasEmAberto();
            VendaEmAbertoTableModel vendaModel = new VendaEmAbertoTableModel(this.vendasEmAberto);
            this.telaPrincipal.getVendasTable().setModel(vendaModel);
        }else{
            VendaEmAbertoTableModel vendaModel = new VendaEmAbertoTableModel(vendas);
            this.telaPrincipal.getVendasTable().setModel(vendaModel);
        }
    }

    @Override
    public void mouseClicked(MouseEvent evento) {
        if(evento.getSource().equals(this.telaPrincipal.getVendasTable())){
            if(evento.getClickCount() == 2){
                this.index = this.telaPrincipal.getVendasTable().getSelectedRow();
                this.telaPrincipal.getClienteComboBox().setSelectedItem(this.vendasEmAberto.get(index).getCliente().getNome());
                this.telaPrincipal.getDescricaoTxt().setText(this.vendasEmAberto.get(index).getDescricao());
                
                this.itensDaVenda = this.vendasEmAberto.get(index).getItens();
                this.quantidades = this.vendasEmAberto.get(index).getQuantidades();
                
                atualizaItensVenda(null, null);
                
                //this.telaPrincipal.getValorTotalTxt().setText(Double.toString(this.vendasEmAberto.get(index).getValorTotal()));
                this.telaPrincipal.getMaoDeObraTxt().setText(Double.toString(this.vendasEmAberto.get(index).getValorMaoDeObra()));
                this.telaPrincipal.getDescontoTxt().setText(Double.toString(this.vendasEmAberto.get(index).getDesconto()));
                this.telaPrincipal.getPainelDeGuias().setSelectedIndex(0);
                this.telaPrincipal.getAlterarVendaBtn().setEnabled(true);
                this.telaPrincipal.getEncaminharVendaBtn().setEnabled(false);
                
                JOptionPane.showMessageDialog(null, this.vendasEmAberto.get(index).getValorTotal());
                JOptionPane.showMessageDialog(null, this.vendasEmAberto.get(index).getItens().size());
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
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
