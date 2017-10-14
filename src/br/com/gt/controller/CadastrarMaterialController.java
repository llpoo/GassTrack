/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.controller;

import br.com.gt.model.Material;
import br.com.gt.view.material.CadastrarMaterialView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

/**
 *
 * @author Luciano Júnior
 */
public class CadastrarMaterialController implements ActionListener{
    
    Connection connection;
    CadastrarMaterialView telaCadastro;
    Material material;
    
    public CadastrarMaterialController(Connection con, Material m) {
        this.connection = con;
        telaCadastro = new CadastrarMaterialView(null, true);
        material = m;
        adicionaEventos();
        telaCadastro.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(this.telaCadastro.getCancelarBtn())){
            this.telaCadastro.dispose();
        }
        
        if(evento.getSource().equals(this.telaCadastro.getSalvarBtn())){
            this.material.setNome(this.telaCadastro.getNomeTxt().getText());
            this.material.setQuantidadeAtual(Integer.parseInt(this.telaCadastro.getQtdeAtualTxt().getText()));
            this.material.setPrecoUnitario(Double.parseDouble(this.telaCadastro.getPrecoUnitarioTxt().getText()));
            this.material.setIsAcessorio(this.telaCadastro.getIsAcessorioCheckBox().isSelected());
            this.material.setEstoqueMinimo(Integer.parseInt(this.telaCadastro.getEstoqueMinimoTxt().getText()));
            
            this.telaCadastro.setVisible(false);
            this.telaCadastro.dispose();
        }
    }

    private void adicionaEventos() {
        this.telaCadastro.getSalvarBtn().addActionListener(this);
        this.telaCadastro.getCancelarBtn().addActionListener(this);
    }
    
}
