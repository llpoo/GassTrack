/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.controller;

import br.com.gt.dao.AquisicaoDAO;
import br.com.gt.model.Aquisicao;
import br.com.gt.model.Fornecedor;
import br.com.gt.view.estoque.ListaEstoqueForView;
import br.com.gt.view.principal.util.AquisicaoTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Luciano Júnior
 */
public class ListarAquisicaoForController implements ActionListener, MouseListener{
    Connection connection;
    ListaEstoqueForView telaListarEstoque;
    Fornecedor fornecedor;
    private ArrayList<Aquisicao> aquisicoes;
    private AquisicaoDAO aquisicaoDao;
    
    public ListarAquisicaoForController(Connection con, Fornecedor f) {
        this.connection = con;
        this.fornecedor=f;
        this.telaListarEstoque = new ListaEstoqueForView(null,true);
        this.aquisicaoDao= new AquisicaoDAO(this.connection);
        atualizaTableAquisicao(null);
        adicionaEventos();
        preencheComboBoxItem(fornecedor);
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
            this.aquisicoes = aquisicaoDao.listarByFornecedor(this.fornecedor);
            AquisicaoTableModel aquisicaoModel = new AquisicaoTableModel(this.aquisicoes);
            this.telaListarEstoque.getEstoqueTable().setModel(aquisicaoModel);
        }else{
            AquisicaoTableModel aquisicaoModel = new AquisicaoTableModel(aquisicoes);
            this.telaListarEstoque.getEstoqueTable().setModel(aquisicaoModel);
        }
    }

    private void adicionaEventos() {
        this.telaListarEstoque.getVoltarBtn().addActionListener(this);
        this.telaListarEstoque.getEstoqueTable().addMouseListener(this);
    }

    private void preencheComboBoxItem(Fornecedor fornecedor) {
        this.telaListarEstoque.getFornecedorComboBox().addItem(fornecedor.getNome());
        this.telaListarEstoque.getFornecedorComboBox().setSelectedItem(this.fornecedor.getNome());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(this.telaListarEstoque.getEstoqueTable())){
            if(e.getClickCount() == 2){
                int index = this.telaListarEstoque.getEstoqueTable().getSelectedRow();
                MostrarAquisicaoController mostrarAquisicaoController = new MostrarAquisicaoController(this.connection, this.aquisicoes.get(index));
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
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
