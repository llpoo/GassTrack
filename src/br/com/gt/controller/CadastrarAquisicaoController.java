/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.controller;

import br.com.gt.dao.AquisicaoDAO;
import br.com.gt.dao.FornecedorDAO;
import br.com.gt.dao.ItemDAO;
import br.com.gt.model.Aquisicao;
import br.com.gt.model.Fornecedor;
import br.com.gt.model.Item;
import br.com.gt.view.estoque.AdicionarEstoqueView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

/**
 *
 * @author Luciano Júnior
 */
public class CadastrarAquisicaoController implements ActionListener,CaretListener,KeyListener{
    Connection connection;
    AdicionarEstoqueView telaCadastro;
    Aquisicao aquisicao;
    Item item;
    ArrayList<Fornecedor> fornecedores;
    
    public CadastrarAquisicaoController(Connection con, Aquisicao a, Item i) {
        this.connection = con;
        telaCadastro = new AdicionarEstoqueView(null, true);
        aquisicao = a;
        item= i;
        adicionaEventos();
        FornecedorDAO fornecedor= new FornecedorDAO(con);
        fornecedores = fornecedor.listar();
        ItemDAO itemDao= new ItemDAO(con);
        List<Item> listaItem=itemDao.listar();
        preencheComboBoxFornecedor(fornecedores);
        preencheComboBoxItem(listaItem);
        telaCadastro.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(this.telaCadastro.getCancelarBtn())){
            this.telaCadastro.dispose();
        }
       
        if(evento.getSource().equals(this.telaCadastro.getSalvarBtn())){
            this.aquisicao.setData(this.telaCadastro.getDataCalendar().getDate());
            
            if(this.telaCadastro.getValorUnitarioTxt().getText().length() > 0){
                this.aquisicao.setValorUitario(Double.parseDouble(this.telaCadastro.getValorUnitarioTxt().getText()));
            }else{
                this.telaCadastro.getValorUnitarioTxt().setText(null);
                this.aquisicao.setValorUitario(-1);
            }
            
            if(this.telaCadastro.getQtdeItemTxt().getText().length() > 0){
                this.aquisicao.setQuantidadeItem(Integer.parseInt(this.telaCadastro.getQtdeItemTxt().getText()));
            }else{
                this.telaCadastro.getQtdeItemTxt().setText(null);
                this.aquisicao.setQuantidadeItem(-1);
            }
            
            if(this.telaCadastro.getValorTotalTxt().getText().length() > 0){
               this.aquisicao.setValorTotal(Double.parseDouble(this.telaCadastro.getValorTotalTxt().getText())); 
            }else{
                this.telaCadastro.getValorTotalTxt().setText(null);
                this.aquisicao.setValorTotal(-1);
            }
            
            this.aquisicao.setItem(this.item);
            
            int index = this.telaCadastro.getFornecedorComboBox().getSelectedIndex();
            this.aquisicao.setFornecedor(this.fornecedores.get(index));
            
            
            AquisicaoDAO aquiDao = new AquisicaoDAO(this.connection);
            
            if(aquiDao.inserir(this.aquisicao) == true){
                this.telaCadastro.dispose();
            }
        }
    }

    private void adicionaEventos() {
        this.telaCadastro.getSalvarBtn().addActionListener(this);
        this.telaCadastro.getCancelarBtn().addActionListener(this);
        this.telaCadastro.getQtdeItemTxt().addCaretListener(this);
        this.telaCadastro.getValorUnitarioTxt().addCaretListener(this);
        this.telaCadastro.getQtdeItemTxt().addKeyListener(this);
        this.telaCadastro.getValorUnitarioTxt().addKeyListener(this);
        this.telaCadastro.getDataCalendar().addKeyListener(this);
    }
    
    private void preencheComboBoxFornecedor(List<Fornecedor> fornecedores){
        if(fornecedores.size()==0){
            JOptionPane.showMessageDialog(null, "Não há fornecedores cadastrados");
        }
           this.telaCadastro.getFornecedorComboBox().removeAllItems();
           int i=0;
           
           do{
             this.telaCadastro.getFornecedorComboBox().addItem(fornecedores.get(i).getNome());
             i++;
           }while(fornecedores.size()!=i);
    }

    private void preencheComboBoxItem(List<Item> itens) {
        if(itens.size()==0){
            JOptionPane.showMessageDialog(null, "Não há itens cadastrados");
        }
           this.telaCadastro.getItemComboBox().removeAllItems();
           int i=0;
           
           do{
             this.telaCadastro.getItemComboBox().addItem(itens.get(i).getNome());
             i++;
           }while(itens.size()!=i);
           
           this.telaCadastro.getItemComboBox().setSelectedItem(this.item.getNome());
    }

    @Override
    public void caretUpdate(CaretEvent evento) {
        if(evento.getSource().equals(this.telaCadastro.getQtdeItemTxt()) ||
           evento.getSource().equals(this.telaCadastro.getValorUnitarioTxt())){
            if(this.telaCadastro.getQtdeItemTxt().getText().length() > 0 &&
               this.telaCadastro.getValorUnitarioTxt().getText().length() > 0){
                Double valor = (Double.parseDouble(this.telaCadastro.getQtdeItemTxt().getText()))*(Double.parseDouble(this.telaCadastro.getValorUnitarioTxt().getText()));
                this.telaCadastro.getValorTotalTxt().setText(valor.toString());
            }else{
                this.telaCadastro.getValorTotalTxt().setText(null);
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent evento) {
        if(evento.getSource().equals(this.telaCadastro.getQtdeItemTxt())){
            String caracteres="0987654321";
            if(!caracteres.contains(evento.getKeyChar()+"")){
                evento.consume();
            }
        }
        
        if(evento.getSource().equals(this.telaCadastro.getValorUnitarioTxt())){
            String caracteres="0987654321.";
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
}
