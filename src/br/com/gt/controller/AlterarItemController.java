/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.controller;

import br.com.gt.dao.ItemDAO;
import br.com.gt.model.Item;
import br.com.gt.view.item.AlterarItemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

/**
 *
 * @author Luciano Júnior
 */
public class AlterarItemController implements ActionListener{
    
    Connection connection;
    AlterarItemView telaAlterar;
    Item item;
    
    public AlterarItemController(Connection con, Item i){
        this.connection = con;
        this.telaAlterar = new AlterarItemView(null, true);
        item = i;
        adicionaEventos();
        preencheCampos();
        this.telaAlterar.setVisible(true);
    }
    
    private void adicionaEventos(){
        this.telaAlterar.getSalvarBtn().addActionListener(this);
        this.telaAlterar.getCancelarBtn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(this.telaAlterar.getCancelarBtn())){
            this.telaAlterar.dispose();
        }
        
        if(evento.getSource().equals(this.telaAlterar.getSalvarBtn())){
            this.item.setNome(this.telaAlterar.getNomeTxt().getText());
            this.item.setPrecoUnitario(Double.parseDouble(this.telaAlterar.getPrecoUnitarioTxt().getText()));
            if(this.telaAlterar.getIsAcessorioCheckBox().isSelected()){
                this.item.setIsAcessorio(true);
            }else{
                this.item.setIsAcessorio(false);
            }
            this.item.setEstoqueMinimo(Integer.parseInt(this.telaAlterar.getEstoqueMinimoTxt().getText()));
            
            ItemDAO itemDAO = new ItemDAO(this.connection);
            itemDAO.alterar(this.item);
            
            if(itemDAO.alterar(this.item) == true){
                this.telaAlterar.dispose();
            }
        }
    }

    private void preencheCampos() {
        this.telaAlterar.getNomeTxt().setText(this.item.getNome());
        this.telaAlterar.getPrecoUnitarioTxt().setText(Double.toString(this.item.getPrecoUnitario()));
        this.telaAlterar.getIsAcessorioCheckBox().setSelected(this.item.isIsAcessorio());
        this.telaAlterar.getEstoqueMinimoTxt().setText(Integer.toString(this.item.getEstoqueMinimo()));
    }
    
}
