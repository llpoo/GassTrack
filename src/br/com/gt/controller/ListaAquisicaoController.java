/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.controller;

import br.com.gt.dao.AquisicaoDAO;
import br.com.gt.model.Aquisicao;
import br.com.gt.model.Item;
import br.com.gt.view.estoque.ListaEstoqueView;
import br.com.gt.view.principal.util.AquisicaoTableModel;
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
public class ListaAquisicaoController implements ActionListener{
    Connection connection;
    ListaEstoqueView telaListarEstoque;
    Item item;
    private ArrayList<Aquisicao> aquisicoes;
    private AquisicaoDAO aquisicaoDao;
    
    public ListaAquisicaoController(Connection con, Item i) {
        this.connection = con;
        this.item=i;
        this.telaListarEstoque = new ListaEstoqueView(null,true);
        this.aquisicaoDao= new AquisicaoDAO(this.connection);
        atualizaTableAquisicao(null);
        adicionaEventos();
        preencheComboBoxItem(item);
        this.telaListarEstoque.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(this.telaListarEstoque.getVoltarBtn())){
            this.telaListarEstoque.dispose();
        }
    }

    private void atualizaTableAquisicao(ArrayList<Aquisicao> aquisicoes) {
        if(aquisicoes == null){
            this.aquisicoes = aquisicaoDao.listarByItem(this.item);
            AquisicaoTableModel aquisicaoModel = new AquisicaoTableModel(this.aquisicoes);
            this.telaListarEstoque.getEstoqueTable().setModel(aquisicaoModel);
        }else{
            AquisicaoTableModel aquisicaoModel = new AquisicaoTableModel(aquisicoes);
            this.telaListarEstoque.getEstoqueTable().setModel(aquisicaoModel);
        }
    }

    private void adicionaEventos() {
        this.telaListarEstoque.getAlterarBtn().addActionListener(this);
        this.telaListarEstoque.getExcluirBtn().addActionListener(this);
        this.telaListarEstoque.getVoltarBtn().addActionListener(this);
    }

    private void preencheComboBoxItem(Item item) {
        this.telaListarEstoque.getItemComboBox().addItem(item.getNome());
        this.telaListarEstoque.getItemComboBox().setSelectedItem(this.item.getNome());
    }
    
}
