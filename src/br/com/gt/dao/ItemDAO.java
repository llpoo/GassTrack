/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.dao;

import br.com.gt.model.Item;
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
public class ItemDAO implements DAO<Item>{
    
    private Connection connection;
    
    public ItemDAO(Connection con){
        this.connection = con;
    }

    @Override
    public void inserir(Item item) {
        String sql = "insert into item (nome, quantidadeatual, precounitario, "
                + "isacessorio, estoqueminimo) values (?,?,?,?,?)";
        
        PreparedStatement pst;
        //INSERIR BUSCAR
        
        try {
            pst = connection.prepareStatement(sql);
           
            pst.setString(1, item.getNome());
            pst.setInt(2, item.getQuantidadeAtual());
            pst.setDouble(3, item.getPrecoUnitario());
            pst.setBoolean(4, item.isIsAcessorio());
            pst.setDouble(5, item.getEstoqueMinimo());
            
            
            pst.execute();
            pst.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o item");
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void alterar(Item item) {
        JOptionPane.showMessageDialog(null, item.getId());
        String sql = "update item set nome=?,quantidadeatual=?,precounitario=?,"
                + "isacessorio=?, estoqueminimo=? where id=?";
        PreparedStatement pst;
        
        try {
            pst = connection.prepareStatement(sql);
            pst.setString(1,item.getNome());
            pst.setInt(2,item.getQuantidadeAtual());
            pst.setDouble(3,item.getPrecoUnitario());
            pst.setBoolean(4,item.isIsAcessorio());
            pst.setInt(5,item.getEstoqueMinimo());
            pst.setInt(6,item.getId());
            
            pst.execute();
            pst.close(); 
	} catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível editar o item");
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean excluir(Item item) {
        String sql = "delete from item where id=?";
        PreparedStatement pst;
        
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, item.getId());
            
            pst.execute();
            pst.close(); 
            return true;
	} catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o item");
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Item buscar(Item item) {
        String sql = "SELECT * FROM item WHERE nome= ?";
        
        Item i= new Item();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setString(1, item.getNome());
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                i.setId(rs.getInt("id"));
                i.setNome(rs.getString("nome"));
                i.setQuantidadeAtual(rs.getInt("quantidadeatual"));
                i.setPrecoUnitario(rs.getDouble("precounitario"));
                i.setIsAcessorio(rs.getBoolean("isacessorio"));
                i.setEstoqueMinimo(rs.getInt("estoqueminimo"));
            }
            
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o item");
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return i;
    }

    public ArrayList<Item> listarAcessorio() {
        String sql="select * from item order by nome";
        PreparedStatement pst;
        ArrayList<Item> listaAcessorio =new ArrayList<Item>();
        
        try{
            pst= connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
		    
           while(rs.next()){		 	
                Item item = new Item();
                item.setId(rs.getInt("id"));
                item.setNome(rs.getString("nome"));
                item.setQuantidadeAtual(rs.getInt("quantidadeatual"));
                item.setPrecoUnitario(rs.getDouble("precounitario"));
                item.setIsAcessorio(rs.getBoolean("isacessorio"));
                item.setEstoqueMinimo(rs.getInt("estoqueminimo"));
                
		if(item.isIsAcessorio()==true){
                    listaAcessorio.add(item);
                }
	    }
		    
            rs.close();
            pst.close();
		    
            return listaAcessorio;
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível listar os itens");
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
            return listaAcessorio;
        }
    }

    @Override
    public ArrayList<Item> pesquisar(String nome) {
        ArrayList<Item> buscaItem = new ArrayList<Item>(); 
	PreparedStatement pst;
        String sql="select * from item where nome ilike ?";
        try{
            pst= connection.prepareStatement(sql);
            pst.setString(1,"%" + nome + "%"); 
            ResultSet rs = pst.executeQuery();
	
            while(rs.next()){
                Item item = new Item();
                item.setId(rs.getInt("id"));
                item.setNome(rs.getString("nome"));
                item.setQuantidadeAtual(rs.getInt("quantidadeatual"));
                item.setPrecoUnitario(rs.getDouble("precounitario"));
                item.setIsAcessorio(rs.getBoolean("isacessorio"));
                item.setEstoqueMinimo(rs.getInt("estoqueminimo"));
                
		buscaItem.add(item);
            }

            rs.close();
            pst.close();
            return buscaItem;
	}catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível pesquisar o item");
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
            return buscaItem;
        }
    } 
    
    public ArrayList<Item> listarMaterial() {
        String sql="select * from item order by nome";
        PreparedStatement pst;
        ArrayList<Item> listaMaterial =new ArrayList<Item>();
        
        try{
            pst= connection.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
		    
           while(rs.next()){		 	
                Item item = new Item();
                item.setId(rs.getInt("id"));
                item.setNome(rs.getString("nome"));
                item.setQuantidadeAtual(rs.getInt("quantidadeatual"));
                item.setPrecoUnitario(rs.getDouble("precounitario"));
                item.setIsAcessorio(rs.getBoolean("isacessorio"));
                item.setEstoqueMinimo(rs.getInt("estoqueminimo"));
                
                if(item.isIsAcessorio()==false){
                    listaMaterial.add(item);
                }
	    }
		    
            rs.close();
            pst.close();
		    
            return listaMaterial;
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível listar os itens");
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
            return listaMaterial;
        }
    }

    Item buscarById(int id) {
        String sql = "SELECT * FROM item WHERE id = ?";
        
        Item i = new Item();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setInt(1, id);
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                i.setId(rs.getInt("id"));
                i.setNome(rs.getString("nome"));
                i.setQuantidadeAtual(rs.getInt("quantidadeatual"));
                i.setPrecoUnitario(rs.getDouble("precounitario"));
                i.setIsAcessorio(rs.getBoolean("isacessorio"));
                i.setEstoqueMinimo(rs.getInt("estoqueminimo"));
            }
            
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o item");
            Logger.getLogger(ItemDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return i;
    }

    @Override
    public ArrayList<Item> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
