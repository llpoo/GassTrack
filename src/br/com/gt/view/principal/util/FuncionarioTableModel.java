/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.view.principal.util;

import br.com.gt.model.Funcionario;
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
public class FuncionarioTableModel extends AbstractTableModel{

    private List<Funcionario> funcionarios;
    private List<String> colunas;
    
    public FuncionarioTableModel(List<Funcionario> funcionarios){
        this.funcionarios = funcionarios;
        colunas = Arrays.asList("Nome", "CPF","Data de admissão","Situação");
    }

    @Override
    public String getColumnName(int column) {
        return colunas.get(column);
    }
    
    
    
    @Override
    public int getRowCount() {
        return funcionarios.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int ColumnIndex) {
        Funcionario funcionario = funcionarios.get(rowIndex);
        switch(ColumnIndex){
            
            case 0: return funcionario.getNome();
            case 1: return funcionario.getCpf();
            case 2: return getFormatDate(funcionario.getDataAdmissao());
            case 3:
                if(funcionario.getUsuario().getId() == 0){
                    return "Desativado";
                }else{
                    return "Ativo";
                }
            
        }
        return null;
        
        
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
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
