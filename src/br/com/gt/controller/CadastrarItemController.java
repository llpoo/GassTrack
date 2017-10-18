/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.controller;

import br.com.gt.dao.ItemDAO;
import br.com.gt.model.Item;
import br.com.gt.view.item.CadastrarItemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

/**
 *
 * @author Luciano Júnior
 */
public class CadastrarItemController implements ActionListener{
    
    Connection connection;
    CadastrarItemView telaCadastro;
    Item item;
    
    public CadastrarItemController(Connection con, Item i) {
        this.connection = con;
        telaCadastro = new CadastrarItemView(null, true);
        item = i;
        adicionaEventos();
        telaCadastro.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(this.telaCadastro.getCancelarBtn())){
            this.telaCadastro.dispose();
        }
        
        if(evento.getSource().equals(this.telaCadastro.getSalvarBtn())){
            this.item.setNome(this.telaCadastro.getNomeTxt().getText());
            this.item.setQuantidadeAtual(0);
            this.item.setPrecoUnitario(Double.parseDouble(this.telaCadastro.getPrecoUnitarioTxt().getText()));
            this.item.setIsAcessorio(this.telaCadastro.getIsAcessorioCheckBox().isSelected());
            this.item.setEstoqueMinimo(Integer.parseInt(this.telaCadastro.getEstoqueMinimoTxt().getText()));
            
            ItemDAO itemDao = new ItemDAO(this.connection);
            itemDao.inserir(this.item);
            
            this.telaCadastro.setVisible(false);
            if(itemDao.inserir(this.item) == true){
                this.telaCadastro.dispose();
            }
        }
    }

    private void adicionaEventos() {
        this.telaCadastro.getSalvarBtn().addActionListener(this);
        this.telaCadastro.getCancelarBtn().addActionListener(this);
    }
    
}
