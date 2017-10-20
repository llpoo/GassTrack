/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.controller;

import br.com.gt.model.Aquisicao;
import br.com.gt.view.estoque.MostrarAdicaoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

/**
 *
 * @author Luciano Júnior
 */
public class MostrarAquisicaoController implements ActionListener{
    Connection connection;
    MostrarAdicaoView telaMostrar;
    Aquisicao aquisicao;
    
    
    public MostrarAquisicaoController(Connection con, Aquisicao a) {
        this.connection = con;
        this.aquisicao = a;
        this.telaMostrar = new MostrarAdicaoView(null,true);
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
        this.telaMostrar.getDataTxt().setText(this.aquisicao.getData().toString());
        this.telaMostrar.getItemComboBox().addItem(this.aquisicao.getItem().getNome());
        this.telaMostrar.getItemComboBox().setSelectedItem(this.aquisicao.getItem().getNome());
        this.telaMostrar.getValorUnitarioTxt().setText("R$"+Double.toString(this.aquisicao.getValorUitario())+"0");
        this.telaMostrar.getQtdeItemTxt().setText(Integer.toString(this.aquisicao.getQuantidadeItem()));
        this.telaMostrar.getValorTotalTxt().setText("R$"+Double.toString(this.aquisicao.getValorTotal())+"0");
        this.telaMostrar.getFornecedorComboBox().addItem(this.aquisicao.getFornecedor().getNome());
        this.telaMostrar.getFornecedorComboBox().setSelectedItem(this.aquisicao.getFornecedor().getNome());
    }
}
