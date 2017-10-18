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
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Luciano Júnior
 */
public class CadastrarAquisicaoController implements ActionListener{
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
            
            Double valor;
            valor = Double.parseDouble(this.telaCadastro.getValorUnitarioTxt().getText());
            this.aquisicao.setValorUitario(valor);
            
            int quantidade;
            quantidade = Integer.parseInt(this.telaCadastro.getQtdeItemTxt().getText());
            this.aquisicao.setQuantidadeItem(quantidade);
            
            Double total=valor*quantidade;
            this.telaCadastro.getValorUnitarioTxt().setText(Double.toString(total));            
            this.aquisicao.setValorTotal(total);
            
            this.aquisicao.setItem(this.item);
            
            FornecedorDAO fornecedor= new FornecedorDAO(this.connection);
            int index = this.telaCadastro.getFornecedorComboBox().getSelectedIndex();
            this.aquisicao.setFornecedor(this.fornecedores.get(index));
            
            
            AquisicaoDAO aquiDao = new AquisicaoDAO(this.connection);
            aquiDao.inserir(this.aquisicao);
            
            this.telaCadastro.setVisible(false);
            this.telaCadastro.dispose();
        }
    }

    private void adicionaEventos() {
        this.telaCadastro.getSalvarBtn().addActionListener(this);
        this.telaCadastro.getCancelarBtn().addActionListener(this);
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
            

}
