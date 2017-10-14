/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.controller;

import br.com.gt.model.Material;
import br.com.gt.view.material.AlterarMaterialView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

/**
 *
 * @author Luciano Júnior
 */
public class AlterarMaterialController implements ActionListener{
    
    Connection connection;
    AlterarMaterialView telaAlterar;
    Material material;
    
    public AlterarMaterialController(Connection con, Material m){
        this.connection = con;
        this.material = m;
        this.telaAlterar = new AlterarMaterialView(null, true);
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
            Material mat = new Material();
            
            mat.setId(this.material.getId());
            mat.setNome(this.telaAlterar.getNomeTxt().getText());
            mat.setQuantidadeAtual(Integer.parseInt(this.telaAlterar.getQtdeAtualTxt().getText()));
            mat.setPrecoUnitario(Double.parseDouble(this.telaAlterar.getPrecoUnitarioTxt().getText()));
            mat.setIsAcessorio(this.telaAlterar.getIsAcessorioCheckBox().isSelected());
            mat.setEstoqueMinimo(Integer.parseInt(this.telaAlterar.getEstoqueMinimoTxt().getText()));
            
            this.telaAlterar.setVisible(false);
            this.telaAlterar.dispose();
        }
    }

    private void preencheCampos() {
        this.telaAlterar.getNomeTxt().setText(this.material.getNome());
        this.telaAlterar.getQtdeAtualTxt().setText(Integer.toString(this.material.getQuantidadeAtual()));
        this.telaAlterar.getPrecoUnitarioTxt().setText(Double.toString(this.material.getPrecoUnitario()));
        this.telaAlterar.getIsAcessorioCheckBox().setDoubleBuffered(this.material.isIsAcessorio());
        this.telaAlterar.getEstoqueMinimoTxt().setText(Integer.toString(this.material.getEstoqueMinimo()));
    }
    
}
