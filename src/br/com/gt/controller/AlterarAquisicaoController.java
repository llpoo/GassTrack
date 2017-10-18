/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.controller;

import br.com.gt.dao.AquisicaoDAO;
import br.com.gt.dao.FornecedorDAO;
import br.com.gt.model.Aquisicao;
import br.com.gt.model.Fornecedor;
import br.com.gt.view.estoque.AlterarAdicaoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Luciano Júnior
 */
public class AlterarAquisicaoController implements ActionListener{
    Connection connection;
    AlterarAdicaoView telaAlterar;
    Aquisicao aquisicao;
    ArrayList<Fornecedor> fornecedores;
    
    public AlterarAquisicaoController(Connection con, Aquisicao a){
        this.connection = con;
        this.telaAlterar = new AlterarAdicaoView(null, true);
        aquisicao = a;
        FornecedorDAO fornecedor= new FornecedorDAO(con);
        fornecedores = fornecedor.listar();
        adicionaEventos();
        preencheCampos();
        preencheComboBoxFornecedor(fornecedores);
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
            this.aquisicao.setData(this.telaAlterar.getDataCalendar().getDate());
            
            Double valor;
            valor = Double.parseDouble(this.telaAlterar.getValorUnitarioTxt().getText());
            this.aquisicao.setValorUitario(valor);
            
            int quantidade;
            quantidade = Integer.parseInt(this.telaAlterar.getQtdeItemTxt().getText());
            this.aquisicao.setQuantidadeItem(quantidade);
            
            Double total=valor*quantidade;
            this.telaAlterar.getValorUnitarioTxt().setText(Double.toString(total));            
            this.aquisicao.setValorTotal(total);
            
            int index = this.telaAlterar.getFornecedorComboBox().getSelectedIndex();
            this.aquisicao.setFornecedor(this.fornecedores.get(index));
            
            AquisicaoDAO aquiDao = new AquisicaoDAO(this.connection);
            aquiDao.alterar(this.aquisicao);
            
            if(aquiDao.alterar(this.aquisicao) == true){
                this.telaAlterar.dispose();
            }
        }
    }

    private void preencheCampos() {
        this.telaAlterar.getDataCalendar().setDate(this.aquisicao.getData());
        this.telaAlterar.getItemComboBox().addItem(this.aquisicao.getItem().getNome());
        this.telaAlterar.getItemComboBox().setSelectedItem(this.aquisicao.getItem().getNome());
        this.telaAlterar.getValorUnitarioTxt().setText(Double.toString(this.aquisicao.getValorUitario()));
        this.telaAlterar.getQtdeItemTxt().setText(Integer.toString(this.aquisicao.getQuantidadeItem()));
        this.telaAlterar.getValorTotalTxt().setText(Double.toString(this.aquisicao.getValorTotal()));
        //this.telaAlterar.getFornecedorComboBox().setSelectedItem(this.aquisicao.getFornecedor().getNome());
    }
    
    private void preencheComboBoxFornecedor(List<Fornecedor> fornecedores){
        if(fornecedores.size()==0){
            JOptionPane.showMessageDialog(null, "Não há fornecedores cadastrados");
        }
           this.telaAlterar.getFornecedorComboBox().removeAllItems();
           int i=0;
           
           do{
             this.telaAlterar.getFornecedorComboBox().addItem(fornecedores.get(i).getNome());
             i++;
           }while(fornecedores.size()!=i);
           this.telaAlterar.getFornecedorComboBox().setSelectedItem(this.aquisicao.getFornecedor().getNome());
    }
    
}
