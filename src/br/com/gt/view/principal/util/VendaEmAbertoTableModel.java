/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.view.principal.util;

import br.com.gt.model.Venda;
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
public class VendaEmAbertoTableModel extends AbstractTableModel{
    private List<Venda> vendas;
    private List<String> colunas;
    
    public VendaEmAbertoTableModel(List<Venda> vendas){
        this.vendas = vendas;
        colunas = Arrays.asList("Data de abertura","Funcionário","Cliente","Valor da Venda","Situação");
    }
    
    
    @Override
    public String getColumnName(int column) {
        return colunas.get(column);
    }
    
    @Override
    public int getRowCount() {
        return vendas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Venda venda = vendas.get(rowIndex);
        
        switch(columnIndex){
            
            case 0: return getFormatDate(venda.getDataAbertura());
            case 1: return venda.getFuncionario().getNome();
            case 2: return venda.getCliente().getNome();
            case 3: return "R$"+venda.getValorTotal();
            case 4: 
                    if(venda.getSituacao() == false){
                        return "Em aberto";
                    }else{
                        return "Erro de busca";
                    }
        }
        return null;
    }
    
    public List<Venda> getMateriais() {
        return vendas;
    }

    public void setMateriais(List<Venda> vendas) {
        this.vendas = vendas;
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
