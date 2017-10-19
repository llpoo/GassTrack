/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.view.principal.util;

import br.com.gt.model.Fornecedor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Luciano Júnior
 */
public class FornecedorTableModel extends AbstractTableModel{
    
    private List<Fornecedor> fornecedores;
    private List<String> colunas;
    
    public FornecedorTableModel(List<Fornecedor> fornecedores){
        this.fornecedores = fornecedores;
        colunas = Arrays.asList("Nome", "CNPJ","Telefone");
    }
    
    
    @Override
    public String getColumnName(int column) {
        return colunas.get(column);
    }
    
    @Override
    public int getRowCount() {
        return fornecedores.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Fornecedor fornecedor = fornecedores.get(rowIndex);
        switch(columnIndex){
            
            case 0: return fornecedor.getNome();
            case 1: return fornecedor.getCnpj();
            case 2: return fornecedor.getTelefone();
            
        }
        return null;
    }
    
    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }

   
}
