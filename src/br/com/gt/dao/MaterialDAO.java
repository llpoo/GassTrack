/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.dao;

import br.com.gt.model.Material;
import java.sql.Connection;
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
public class MaterialDAO implements DAO<Material>{
    
    private Connection connection;
    
    public MaterialDAO(Connection con){
        this.connection = con;
    }

    @Override
    public void inserir(Material material) {
        String sql = "insert into material (nome, quantidadeatual, precounitario, "
                + "isacessorio, estoqueminimo) values (?,?,?,?,?,?)";
        
        PreparedStatement pst;
        //INSERIR BUSCAR
        
        try {
            pst = connection.prepareStatement(sql);
           
            pst.setString(1, material.getNome());
            pst.setInt(2, material.getQuantidadeAtual());
            pst.setDouble(3, material.getPrecoUnitario());
            pst.setBoolean(4, material.isIsAcessorio());
            pst.setDouble(5, material.getEstoqueMinimo());
            
            
            pst.execute();
            pst.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o material");
            Logger.getLogger(MaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void alterar(Material material) {
        String sql = "update material set nome=?,quantidadeatual=?,precounitario=?,"
                + "isacessorio=?, estoqueminimo=? where id=?";
        PreparedStatement pst;
        
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1,material.getNome());
            pst.setInt(2,material.getQuantidadeAtual());
            pst.setDouble(3,material.getPrecoUnitario());
            pst.setBoolean(4,material.isIsAcessorio());
            pst.setInt(5,material.getEstoqueMinimo());
            pst.setInt(6,material.getId());
            
            pst.execute();
            pst.close(); 
	} catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível editar o material");
            Logger.getLogger(MaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean excluir(Material material) {
        String sql = "delete from material where id=?";
        PreparedStatement pst;
        
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, material.getId());
            
            pst.execute();
            pst.close(); 
            return true;
	} catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o material");
            Logger.getLogger(MaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Material buscar(Material material) {
        String sql = "SELECT * FROM material WHERE nome= ?";
        
        Material m= new Material();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setString(1, material.getNome());
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                m.setId(rs.getInt("id"));
                m.setNome(rs.getString("nome"));
                m.setQuantidadeAtual(rs.getInt("quantidadeatual"));
                m.setPrecoUnitario(rs.getDouble("precounitario"));
                m.setIsAcessorio(rs.getBoolean("isacessorio"));
                m.setEstoqueMinimo(rs.getInt("estoqueminimo"));
            }
            
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o material");
            Logger.getLogger(MaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return m;
    }

    @Override
    public ArrayList<Material> listar() {
        String sql="select * from material order by nome";
        PreparedStatement pst;
        ArrayList<Material> listaMaterial =new ArrayList<Material>();
        
        try{
            pst= connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
		    
           while(rs.next()){		 	
                Material material = new Material();
                material.setId(rs.getInt("id"));
                material.setNome(rs.getString("nome"));
                material.setQuantidadeAtual(rs.getInt("quantidadeatual"));
                material.setPrecoUnitario(rs.getDouble("precounitario"));
                material.setIsAcessorio(rs.getBoolean("isacessorio"));
                material.setEstoqueMinimo(rs.getInt("estoqueminimo"));
                
		listaMaterial.add(material);
	    }
		    
            rs.close();
            pst.close();
		    
            return listaMaterial;
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível listar os materiais");
            Logger.getLogger(MaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
            return listaMaterial;
        }
    }

    @Override
    public ArrayList<Material> pesquisar(String nome) {
        ArrayList<Material> buscaMaterial = new ArrayList<Material>(); 
	PreparedStatement pst;
        String sql="select * from material where nome ilike ?";
        try{
            pst= connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            pst.setString(1,"%" + nome + "%"); 
	
            while(rs.next()){
                Material material = new Material();
                material.setId(rs.getInt("id"));
                material.setNome(rs.getString("nome"));
                material.setQuantidadeAtual(rs.getInt("quantidadeatual"));
                material.setPrecoUnitario(rs.getDouble("precounitario"));
                material.setIsAcessorio(rs.getBoolean("isacessorio"));
                material.setEstoqueMinimo(rs.getInt("estoqueminimo"));
                
		buscaMaterial.add(material);
            }

            rs.close();
            pst.close();
            return buscaMaterial;
	}catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar o material");
            Logger.getLogger(MaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
            return buscaMaterial;
        }
    }  

    Material buscarById(int id) {
        String sql = "SELECT * FROM material WHERE id = ?";
        
        Material m = new Material();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setInt(1, id);
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                m.setId(rs.getInt("id"));
                m.setNome(rs.getString("nome"));
                m.setQuantidadeAtual(rs.getInt("quantidadeatual"));
                m.setPrecoUnitario(rs.getDouble("precounitario"));
                m.setIsAcessorio(rs.getBoolean("isacessorio"));
                m.setEstoqueMinimo(rs.getInt("estoqueminimo"));
            }
            
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o endereço");
            Logger.getLogger(MaterialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return m;
    }
    
    
}
