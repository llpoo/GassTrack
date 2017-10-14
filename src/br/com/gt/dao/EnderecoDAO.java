/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.dao;

import br.com.gt.model.Endereco;
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
 * @author lucas
 */
public class EnderecoDAO implements DAO<Endereco>{
    Connection connection;

    public EnderecoDAO(Connection con) {
        this.connection = con;
    }

    @Override
    public void inserir(Endereco endereco) {
        String sql = "insert into endereco (cep,cidade,estado,numero,rua,bairro) values (?,?,?,?,?,?)";
        
        PreparedStatement pst;
        
        Endereco e = this.buscar(endereco);
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setString(1, endereco.getCep());
            pst.setString(2, endereco.getCidade());
            pst.setString(3, endereco.getEstado());
            pst.setString(4, endereco.getNumero());
            pst.setString(5, endereco.getRua());
            pst.setString(6, endereco.getBairro());
            
            pst.execute();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o endereço");
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void alterar(Endereco endereco) {
        String sql = "update endereco set cep = ?, cidade= ?, estado= ?, numero= ?, rua= ?, bairro = ? where id = ?";
        
        PreparedStatement pst;
        
        Endereco e = this.buscar(endereco);
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setString(1, endereco.getCep());
            pst.setString(2, endereco.getCidade());
            pst.setString(3, endereco.getEstado());
            pst.setString(4, endereco.getNumero());
            pst.setString(5, endereco.getRua());
            pst.setString(6, endereco.getBairro());
            pst.setInt(7, endereco.getId());
            
            pst.execute();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o endereço");
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public boolean excluir(Endereco objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Endereco buscarById(int idEndereco){
        String sql = "SELECT * FROM endereco WHERE id = ?";
        
        Endereco e = new Endereco();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setInt(1, idEndereco);
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                e.setId(rs.getInt("id"));
                e.setBairro(rs.getString("bairro"));
                e.setCep(rs.getString("cep"));
                e.setCidade(rs.getString("cidade"));
                e.setEstado(rs.getString("estado"));
                e.setNumero(rs.getString("numero"));
                e.setRua(rs.getString("rua"));
            }
            
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o endereço");
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return e;
    }

    @Override
    public Endereco buscar(Endereco endereco) {
        String sql = "SELECT * FROM endereco WHERE rua ~* ? AND numero like ? AND cep like ?";
        
        Endereco e = new Endereco();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setString(1, endereco.getRua());
            pst.setString(2, endereco.getNumero());
            pst.setString(3, endereco.getCep());
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                e.setId(rs.getInt("id"));
                e.setBairro(rs.getString("bairro"));
                e.setCep(rs.getString("cep"));
                e.setCidade(rs.getString("cidade"));
                e.setEstado(rs.getString("estado"));
                e.setNumero(rs.getString("numero"));
                e.setRua(rs.getString("rua"));
            }
            
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o endereço");
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return e;
    }

    @Override
    public ArrayList<Endereco> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Endereco> pesquisar(String objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
