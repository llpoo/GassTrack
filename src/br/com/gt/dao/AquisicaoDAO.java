/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.dao;

import br.com.gt.model.Aquisicao;
import br.com.gt.model.Fornecedor;
import br.com.gt.model.Material;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            
            Material material = new Material();
            MaterialDAO materialDAO = new MaterialDAO(connection);
            material = materialDAO.buscar(aquisicao.getMaterial());
            
            if(material.getId() < 1){
                materialDAO.inserir(aquisicao.getMaterial());
                material = materialDAO.buscar(aquisicao.getMaterial());
            }
            
            aquisicao.getMaterial().setId(material.getId());
            
            pst.setInt(6, aquisicao.getMaterial().getId());
            
            pst.execute();
            pst.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar a aquisição");
            Logger.getLogger(AquisicaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void alterar(Aquisicao aquisicao) {
        String sql = "update aquisicao set data=?, valoruitario=?, "
                + "quantidadematerial=?, valortotal=? where id=?";
        PreparedStatement pst;
        
        try {
            pst = connection.prepareStatement(sql);
            pst.setDate(1, (Date) aquisicao.getData());
            pst.setDouble(2, aquisicao.getValorUitario());
            pst.setInt(3, aquisicao.getQuantidadeMaterial());
            pst.setDouble(4, aquisicao.getValorTotal());  
            
            FornecedorDAO fornecedorDAO = new FornecedorDAO(connection);
            fornecedorDAO.alterar(aquisicao.getFornecedor());
            
            MaterialDAO materialDAO = new MaterialDAO(connection);
            materialDAO.alterar(aquisicao.getMaterial());
            
            pst.setInt(5,aquisicao.getId());
            
            pst.execute();
            pst.close(); 
	} catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível editar a aquisicão");
            Logger.getLogger(AquisicaoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean excluir(Aquisicao aquisicao) {
        String sql = "delete from aquisicao where id=?";
        PreparedStatement pst;
        
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, aquisicao.getId());
            
            pst.execute();
            pst.close(); 
            return true;
	} catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o fornecedor");
            Logger.getLogger(AquisicaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Aquisicao buscar(Aquisicao aquisicao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Aquisicao> listar() {
        String sql="select * from aquisicao order by data";
        PreparedStatement pst;
        ArrayList<Aquisicao> listaAquisicao =new ArrayList<Aquisicao>();
        
        try{
            pst= connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            FornecedorDAO fornecedorDAO = new FornecedorDAO(connection);
            MaterialDAO materialDAO = new MaterialDAO(connection);
		    
           while(rs.next()){		 	
                Aquisicao aquisicao = new Aquisicao();
                aquisicao.setId(rs.getInt("id"));
                aquisicao.setData(rs.getDate("data"));
                aquisicao.setValorUitario(rs.getDouble("valoruitario"));
                aquisicao.setQuantidadeMaterial(rs.getInt("quantidadematerial"));
                aquisicao.setValorTotal(rs.getDouble("valortotal"));
		
                Fornecedor f =new Fornecedor();
                f.setId(rs.getInt("fornecedor_id"));
                
                aquisicao.setFornecedor(fornecedorDAO.buscarById(f.getId()));
                
                Material m =new Material();
                m.setId(rs.getInt("material_id"));
                
                aquisicao.setMaterial(materialDAO.buscarById(m.getId()));
                
		listaAquisicao.add(aquisicao);
	    }
		    
            rs.close();
            pst.close();
		    
            return listaAquisicao;
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível listar os fornecedores");
            Logger.getLogger(AquisicaoDAO.class.getName()).log(Level.SEVERE, null, ex);
            return listaAquisicao;
        }
    }

    @Override
    public ArrayList<Aquisicao> pesquisar(String objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
