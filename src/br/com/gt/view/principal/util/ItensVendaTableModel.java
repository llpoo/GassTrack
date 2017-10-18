/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.view.principal.util;

import br.com.gt.model.Item;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author lucas
 */
public class ItensVendaTableModel extends AbstractTableModel{
    private List<Item> itens;
    private List<String> colunas;
    private List<Double> quantidades;
    
    public ItensVendaTableModel(List<Item> itens,List<Double> quantidades){
        this.itens = itens;
        this.quantidades = quantidades;
        colunas = Arrays.asList("Item","Quantidade", "Preço Unitário", "Valor");
    }
    
    
    @Override
    public String getColumnName(int column) {
        return colunas.get(column);
    }
    
    @Override
    public int getRowCount() {
        return itens.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Item item = itens.get(rowIndex);
        Double quantidade = quantidades.get(rowIndex);
        switch(columnIndex){
            
            case 0: return item.getNome();
            case 1: 
                    if(item.isIsAcessorio() == true){
                        return quantidade+" Unidade(s)";
                    }else{
                        return quantidade+" m²";
                    }
            case 2: return "R$"+item.getPrecoUnitario()+"0";
            case 3: return "R$"+item.getPrecoUnitario()*quantidade+"0";
            
        }
        return null;
    }
    
    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}
