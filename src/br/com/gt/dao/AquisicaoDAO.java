/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.dao;

import br.com.gt.model.Aquisicao;
import br.com.gt.model.Fornecedor;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Luciano Júnior
 */
public class AquisicaoDAO implements DAO<Aquisicao>{
    
    private Connection connection;
    
    public AquisicaoDAO(Connection con){
        this.connection = con;
    }

    @Override
    public void inserir(Aquisicao aquisicao) {
        String sql = "insert into aquisicao (data, valoruitario, "
                + "quantidadematerial, valortotal, fornecedor_id, material_id) "
                + "values (?,?,?,?,?,?)";
        
        PreparedStatement pst;
        //INSERIR BUSCAR
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setDate(1, (Date) aquisicao.getData());
            pst.setDouble(2, aquisicao.getValorUitario());
            pst.setInt(3, aquisicao.getQuantidadeMaterial());
            pst.setDouble(4, aquisicao.getValorTotal());
            
            Fornecedor fornecedor = new Fornecedor();
            FornecedorDAO fornecedorDAO = new FornecedorDAO(connection);
            fornecedor = fornecedorDAO.buscar(aquisicao.getFornecedor());
            
            if(fornecedor.getId() < 1){
                fornecedorDAO.inserir(aquisicao.getFornecedor());
                fornecedor = fornecedorDAO.buscar(aquisicao.getFornecedor());
            }
            
            aquisicao.getFornecedor().setId(fornecedor.getId());
            
            pst.setInt(5, aquisicao.getFornecedor().getId());
            
            //MATERIAL 
            
            pst.execute();
            pst.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o funcionário");
            Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void alterar(Aquisicao objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Aquisicao objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Aquisicao buscar(Aquisicao objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Aquisicao> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Aquisicao> pesquisar(String objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
