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
 * @author Luciano Júnior
 */
public class AcessorioTableModel extends AbstractTableModel{
    private List<Item> acessorios;
    private List<String> colunas;
    
    public AcessorioTableModel(List<Item> acessorios){
        this.acessorios = acessorios;
        colunas = Arrays.asList("Nome", "Quantidade Atual","Estoque Minimo", "Preço Unitário");
    }
    
    
    @Override
    public String getColumnName(int column) {
        return colunas.get(column);
    }
    
    @Override
    public int getRowCount() {
        return acessorios.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Item acessorio = acessorios.get(rowIndex);
        switch(columnIndex){
            
            case 0: return acessorio.getNome();
            case 1: return acessorio.getQuantidadeAtual();
            case 2: return acessorio.getEstoqueMinimo();
            case 3: return acessorio.getPrecoUnitario();
            
        }
        return null;
    }
    
    public List<Item> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Item> acessorios) {
        this.acessorios = acessorios;
    }
    
}
