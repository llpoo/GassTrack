/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.view.principal.util;

import br.com.gt.model.PessoaFisica;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author lucas
 */
public class ClienteTableModel extends AbstractTableModel{
    private List<PessoaFisica> clientes;
    private List<String> colunas;
    
    public ClienteTableModel(List<PessoaFisica> clientes){
        this.clientes = clientes;
        colunas = Arrays.asList("Nome", "CPF","Telefone");
    }

    @Override
    public String getColumnName(int column) {
        return colunas.get(column);
    }
    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int ColumnIndex) {
        PessoaFisica cliente = clientes.get(rowIndex);
        switch(ColumnIndex){
            
            case 0: return cliente.getNome();
            case 1: return cliente.getCpf();
            case 2: return cliente.getTelefone();
            
        }
        return null;
        
        
    }

    public List<PessoaFisica> getPessoaFisicas() {
        return clientes;
    }

    public void setPessoaFisicas(List<PessoaFisica> clientes) {
        this.clientes = clientes;
    }
    
    
    private String getFormatDate(Date data) { 
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(data); 
    }
    
    private String getFormatTime(Date data) { 
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        return dateFormat.format(data); 
    }
}
