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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;

/**
 *
 * @author Luciano Júnior
 */
public class CadastrarItemController implements ActionListener,KeyListener{
    
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
            if(this.telaCadastro.getPrecoUnitarioTxt().getText().length() > 0){
                this.item.setPrecoUnitario(Double.parseDouble(this.telaCadastro.getPrecoUnitarioTxt().getText()));
            }else{
                this.item.setPrecoUnitario(-1);
            }
            
            this.item.setIsAcessorio(this.telaCadastro.getIsAcessorioCheckBox().isSelected());
            if(this.telaCadastro.getEstoqueMinimoTxt().getText().length() > 0){
                this.item.setEstoqueMinimo(Integer.parseInt(this.telaCadastro.getEstoqueMinimoTxt().getText()));
            }else{
                this.item.setEstoqueMinimo(-1);
            }
            
            
            ItemDAO itemDao = new ItemDAO(this.connection);
            
            if(itemDao.inserir(this.item) == true){
                this.telaCadastro.dispose();
            }
        }
    }

    private void adicionaEventos() {
        this.telaCadastro.getSalvarBtn().addActionListener(this);
        this.telaCadastro.getCancelarBtn().addActionListener(this);
        this.telaCadastro.getPrecoUnitarioTxt().addKeyListener(this);
        this.telaCadastro.getEstoqueMinimoTxt().addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent evento) {
        if(evento.getSource().equals(this.telaCadastro.getEstoqueMinimoTxt())){
            String caracteres="0987654321";
            if(!caracteres.contains(evento.getKeyChar()+"")){
                evento.consume();
            }
        }
        
        if(evento.getSource().equals(this.telaCadastro.getPrecoUnitarioTxt())){
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
