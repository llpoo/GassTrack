/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.controller;

import br.com.gt.dao.AquisicaoDAO;
import br.com.gt.dao.FornecedorDAO;
import br.com.gt.dao.ItemDAO;
import br.com.gt.model.Aquisicao;
import br.com.gt.model.Fornecedor;
import br.com.gt.model.Item;
import br.com.gt.view.estoque.AlterarAdicaoView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

/**
 *
 * @author Luciano Júnior
 */
public class AlterarAquisicaoController implements ActionListener,CaretListener,KeyListener{
    Connection connection;
    AlterarAdicaoView telaAlterar;
    Aquisicao aquisicao;
    ArrayList<Fornecedor> fornecedores;
    int valorDeTeste;
    
    public AlterarAquisicaoController(Connection con, Aquisicao a){
        this.connection = con;
        this.telaAlterar = new AlterarAdicaoView(null, true);
        aquisicao = a;
        FornecedorDAO fornecedor= new FornecedorDAO(con);
        fornecedores = fornecedor.listar();
        adicionaEventos();
        preencheCampos();
        preencheComboBoxFornecedor(fornecedores);
        valorDeTeste = a.getQuantidadeItem();
        this.telaAlterar.setVisible(true);  
    }
    
    private void adicionaEventos(){
        this.telaAlterar.getSalvarBtn().addActionListener(this);
        this.telaAlterar.getCancelarBtn().addActionListener(this);
        this.telaAlterar.getQtdeItemTxt().addCaretListener(this);
        this.telaAlterar.getValorUnitarioTxt().addCaretListener(this);
        this.telaAlterar.getQtdeItemTxt().addKeyListener(this);
        this.telaAlterar.getValorUnitarioTxt().addKeyListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent evento) {
        if(evento.getSource().equals(this.telaAlterar.getCancelarBtn())){
            this.telaAlterar.dispose();
        }
        
        if(evento.getSource().equals(this.telaAlterar.getSalvarBtn())){
            this.aquisicao.setData(this.telaAlterar.getDataCalendar().getDate());
            
            if(this.telaAlterar.getValorUnitarioTxt().getText().length() > 0){
                this.aquisicao.setValorUitario(Double.parseDouble(this.telaAlterar.getValorUnitarioTxt().getText()));
            }else{
                this.telaAlterar.getValorUnitarioTxt().setText(null);
                this.aquisicao.setValorUitario(-1);
            }
            
            if(this.telaAlterar.getQtdeItemTxt().getText().length() > 0){
                this.aquisicao.setQuantidadeItem(Integer.parseInt(this.telaAlterar.getQtdeItemTxt().getText()));
            }else{
                this.telaAlterar.getQtdeItemTxt().setText(null);
                this.aquisicao.setQuantidadeItem(-1);
            }
            
            if(this.telaAlterar.getValorTotalTxt().getText().length() > 0){
               this.aquisicao.setValorTotal(Double.parseDouble(this.telaAlterar.getValorTotalTxt().getText())); 
            }else{
                this.telaAlterar.getValorTotalTxt().setText(null);
                this.aquisicao.setValorTotal(-1);
            }
            
            int index = this.telaAlterar.getFornecedorComboBox().getSelectedIndex();
            this.aquisicao.setFornecedor(this.fornecedores.get(index));
            
            if(valorDeTeste > this.aquisicao.getQuantidadeItem()){
                int valor = valorDeTeste-this.aquisicao.getQuantidadeItem();
                
                if(this.aquisicao.getItem().getQuantidadeAtual() - valor >= 0){
                    this.aquisicao.getItem().setQuantidadeAtual(this.aquisicao.getItem().getQuantidadeAtual()-valor);

                    AquisicaoDAO aquiDao = new AquisicaoDAO(this.connection);
                    
                    if(aquiDao.alterar(this.aquisicao) == true){
                        this.telaAlterar.dispose();
                    }
                }else{
                    if(this.telaAlterar.getQtdeItemTxt().getText().length() > 0){
                        JOptionPane.showMessageDialog(null, "Erro. Esta quantidade de itens irá resultar em estoque negativo");
                    }else{
                        JOptionPane.showMessageDialog(null, "Preencha todos os campos");
                    }
                }
            }else{
                int valor = this.aquisicao.getQuantidadeItem() - valorDeTeste;
                
                this.aquisicao.getItem().setQuantidadeAtual(this.aquisicao.getItem().getQuantidadeAtual()+valor);

                AquisicaoDAO aquiDao = new AquisicaoDAO(this.connection);

                if(aquiDao.alterar(this.aquisicao) == true){
                    this.telaAlterar.dispose();
                }
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
    
    @Override
    public void caretUpdate(CaretEvent evento) {
        if(evento.getSource().equals(this.telaAlterar.getQtdeItemTxt()) ||
           evento.getSource().equals(this.telaAlterar.getValorUnitarioTxt())){
            if(this.telaAlterar.getQtdeItemTxt().getText().length() > 0 &&
               this.telaAlterar.getValorUnitarioTxt().getText().length() > 0){
                Double valor = (Double.parseDouble(this.telaAlterar.getQtdeItemTxt().getText()))*(Double.parseDouble(this.telaAlterar.getValorUnitarioTxt().getText()));
                this.telaAlterar.getValorTotalTxt().setText(valor.toString());
            }else{
                this.telaAlterar.getValorTotalTxt().setText(null);
            }
        }
    }
    
    @Override
    public void keyTyped(KeyEvent evento) {
        if(evento.getSource().equals(this.telaAlterar.getQtdeItemTxt())){
            String caracteres="0987654321";
            if(!caracteres.contains(evento.getKeyChar()+"")){
                evento.consume();
            }
        }
        
        if(evento.getSource().equals(this.telaAlterar.getValorUnitarioTxt())){
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
