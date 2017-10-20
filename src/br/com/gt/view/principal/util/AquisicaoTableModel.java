/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.view.principal.util;

import br.com.gt.model.Aquisicao;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Luciano Júnior
 */
public class AquisicaoTableModel extends AbstractTableModel{
    private List<Aquisicao> aquisicoes;
    private List<String> colunas;
    
    public AquisicaoTableModel(List<Aquisicao> aquisicoes){
        this.aquisicoes = aquisicoes;
        colunas = Arrays.asList("Data","Fornecedor", "Quantidade de Itens","Valor Unitário", "Valor Total");
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas.get(column);
    }    
    @Override
    public int getRowCount() {
        return aquisicoes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Aquisicao aquisicao = aquisicoes.get(rowIndex);
        switch(columnIndex){
            
            case 0: return getFormatDate(aquisicao.getData());
            case 1: return aquisicao.getFornecedor().getNome();
            case 2: return aquisicao.getQuantidadeItem();
            case 3: return aquisicao.getValorUitario();
            case 4: return aquisicao.getValorTotal();
            
        }
        return null;
        
        
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
