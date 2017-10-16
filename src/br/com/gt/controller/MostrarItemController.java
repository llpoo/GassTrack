/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.controller;

import br.com.gt.model.Item;
import br.com.gt.view.item.MostrarItemView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

/**
 *
 * @author Luciano Júnior
 */
public class MostrarItemController implements ActionListener{
    Connection connection;
    MostrarItemView telaMostrar;
    Item item;
    
    public MostrarItemController(Connection con, Item i) {
        this.connection = con;
        this.item = i;
        this.telaMostrar = new MostrarItemView(null,true);
        adicionaEventos();
        preencheCampos();
        this.telaMostrar.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(this.telaMostrar.getOkBtn())){
            this.telaMostrar.dispose();
        }
    }

    private void adicionaEventos() {
        this.telaMostrar.getOkBtn().addActionListener(this);
    }

    private void preencheCampos() {
        this.telaMostrar.getNomeTxt().setText(this.item.getNome());
        this.telaMostrar.getPrecoUnitarioTxt().setText(Double.toString(this.item.getPrecoUnitario()));
        this.telaMostrar.getIsAcessorioCheckBox().setSelected(this.item.isIsAcessorio());
        this.telaMostrar.getEstoqueMinTxt().setText(Integer.toString(this.item.getEstoqueMinimo()));
        this.telaMostrar.getQtdeAtualTxt().setText(Integer.toString(this.item.getQuantidadeAtual()));
    }

}
