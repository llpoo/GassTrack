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
public class ListaAquisicaoController implements ActionListener, MouseListener{
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
        if(evento.getSource().equals(this.telaListarEstoque.getAlterarBtn())){
            int index = this.telaListarEstoque.getEstoqueTable().getSelectedRow();
            AlterarAquisicaoController alterarAquisicaoController = new AlterarAquisicaoController(this.connection, this.aquisicoes.get(index));
            atualizaTableAquisicao(null);
        }
        
        if(evento.getSource().equals(this.telaListarEstoque.getExcluirBtn())){
            int index = this.telaListarEstoque.getEstoqueTable().getSelectedRow();
            if (JOptionPane.showConfirmDialog(null, "Deseja excluir o registro do estoque "+
                    this.aquisicoes.get(index).getItem().getNome()+"?", null, JOptionPane.YES_NO_OPTION) 
                    == JOptionPane.YES_OPTION){
                this.aquisicaoDao.excluir(this.aquisicoes.get(index));
                this.aquisicoes.remove(index);
                atualizaTableAquisicao(null);
            }
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
        this.telaListarEstoque.getEstoqueTable().addMouseListener(this);
    }

    private void preencheComboBoxItem(Item item) {
        this.telaListarEstoque.getItemComboBox().addItem(item.getNome());
        this.telaListarEstoque.getItemComboBox().setSelectedItem(this.item.getNome());
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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
