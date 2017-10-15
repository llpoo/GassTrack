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
public class MaterialTableModel extends AbstractTableModel{
    
    private List<Item> materiais;
    private List<String> colunas;
    
    public MaterialTableModel(List<Item> materiais){
        this.materiais = materiais;
        colunas = Arrays.asList("Nome", "Quantidade Atual","Estoque Minimo", "Preço Unitário");
    }
    
    
    @Override
    public String getColumnName(int column) {
        return colunas.get(column);
    }
    
    @Override
    public int getRowCount() {
        return materiais.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Item material = materiais.get(rowIndex);
        switch(columnIndex){
            
            case 0: return material.getNome();
            case 1: return material.getQuantidadeAtual();
            case 2: return material.getEstoqueMinimo();
            case 3: return material.getPrecoUnitario();
            
        }
        return null;
    }
    
    public List<Item> getMateriais() {
        return materiais;
    }

    public void setMateriais(List<Item> materiais) {
        this.materiais = materiais;
    }
}
