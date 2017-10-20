/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.controller;

import br.com.gt.dao.ClienteDAO;
import br.com.gt.model.Item;
import br.com.gt.model.PessoaFisica;
import br.com.gt.model.Venda;
import br.com.gt.view.principal.util.ItensVendaTableModel;
import br.com.gt.view.venda.MostrarVendaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class MostrarVendaController implements ActionListener{
    Connection connection;
    Venda venda;
    MostrarVendaView telaMostrar;

    public MostrarVendaController(Connection con, Venda v) {
        this.connection = con;
        this.venda = v;
        this.telaMostrar = new MostrarVendaView(null,true);
        adicionaEventos();
        preencheCampos();
        this.telaMostrar.setVisible(true);
    }
    
    private void adicionaEventos() {
        this.telaMostrar.getOkBtn().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(this.telaMostrar.getOkBtn())){
            this.telaMostrar.dispose();
        }
    }

    private void preencheCampos() {
        ClienteDAO cDao = new ClienteDAO(this.connection);
        ArrayList<PessoaFisica> clientes = cDao.listar();
        preencheComboBoxCliente(clientes);
        
        this.telaMostrar.getClienteComboBox().setSelectedItem(this.venda.getCliente().getNome());
        this.telaMostrar.getCpfClienteTxt().setText(clientes.get(this.telaMostrar.getClienteComboBox().getSelectedIndex()).getCpf());
        
        ItensVendaTableModel tableModel = new ItensVendaTableModel(this.venda.getItens(),this.venda.getQuantidades());
        this.telaMostrar.getItensTable().setModel(tableModel);
        
        this.telaMostrar.getDescricaoTxt().setText(this.venda.getDescricao());
        this.telaMostrar.getMaoDeObraTxt().setText("R$"+Double.toString(this.venda.getValorMaoDeObra())+"0");
        this.telaMostrar.getDescontoTxt().setText("R$"+Double.toString(this.venda.getDesconto())+"0");
        this.telaMostrar.getValorTotalTxt().setText("R$"+Double.toString(this.venda.getValorTotal())+"0");
    }
    
    private void preencheComboBoxCliente(ArrayList<PessoaFisica> c) {
        if(c.size()==0){
            JOptionPane.showMessageDialog(null, "Não há clientes cadastrados");
        }
           this.telaMostrar.getClienteComboBox().removeAllItems();
           int i=0;
           
           do{
             this.telaMostrar.getClienteComboBox().addItem(c.get(i).getNome());
             i++;
           }while(c.size()!=i);
           
          this.telaMostrar.getClienteComboBox().setSelectedItem(null);
          this.telaMostrar.getCpfClienteTxt().setText(null);
    }
    
}
