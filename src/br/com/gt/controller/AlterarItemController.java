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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Luciano Júnior
 */
public class AlterarItemController implements ActionListener,KeyListener{
    
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
        this.telaAlterar.getPrecoUnitarioTxt().addKeyListener(this);
        this.telaAlterar.getEstoqueMinimoTxt().addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(this.telaAlterar.getCancelarBtn())){
            this.telaAlterar.dispose();
        }
        
        if(evento.getSource().equals(this.telaAlterar.getSalvarBtn())){
            this.item.setNome(this.telaAlterar.getNomeTxt().getText());
            if(this.telaAlterar.getPrecoUnitarioTxt().getText().length() > 0){
                this.item.setPrecoUnitario(Double.parseDouble(this.telaAlterar.getPrecoUnitarioTxt().getText()));
            }else{
                this.item.setPrecoUnitario(-1);
            }
            
            if(this.telaAlterar.getIsAcessorioCheckBox().isSelected()){
                this.item.setIsAcessorio(true);
            }else{
                this.item.setIsAcessorio(false);
            }
            
            if(this.telaAlterar.getEstoqueMinimoTxt().getText().length() > 0){
                this.item.setEstoqueMinimo(Integer.parseInt(this.telaAlterar.getEstoqueMinimoTxt().getText()));
            }else{
                this.item.setEstoqueMinimo(-1);
            }
            
            
            ItemDAO itemDAO = new ItemDAO(this.connection);
            
            if(itemDAO.alterar(this.item) == true){
                JOptionPane.showMessageDialog(null, "Alteração efetuada com sucesso");
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
    
    @Override
    public void keyTyped(KeyEvent evento) {
        if(evento.getSource().equals(this.telaAlterar.getEstoqueMinimoTxt())){
            String caracteres="0987654321";
            if(!caracteres.contains(evento.getKeyChar()+"")){
                evento.consume();
            }
        }
        
        if(evento.getSource().equals(this.telaAlterar.getPrecoUnitarioTxt())){
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
