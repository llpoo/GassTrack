/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.dao;

import br.com.gt.model.Usuario;
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
public class UsuarioDAO implements DAO<Usuario>{
    private Connection connection;

    public UsuarioDAO(Connection con) {
        this.connection = con;
    }

    @Override
    public void inserir(Usuario usuario) {
        String sql = "insert into usuario (usuario, senha,isgerente) values (?,?,?)";
        
        PreparedStatement pst;
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setString(1, usuario.getUsuario());
            pst.setString(2, usuario.getSenha());
            pst.setBoolean(3, false);
            
            pst.execute();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar o usuário");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void alterar(Usuario objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Usuario objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Usuario buscarById(int idUsuario){
        String sql = "SELECT * FROM usuario WHERE id = ?";
        
        Usuario u = new Usuario();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setInt(1, idUsuario);
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                u.setId(rs.getInt("id"));
                u.setUsuario(rs.getString("usuario"));
                u.setSenha(rs.getString("senha"));
                u.setIsGerente(rs.getBoolean("isgerente"));
            }
            
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o usuário");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return u;
    }

    @Override
    public Usuario buscar(Usuario usuario) {
        String sql = "SELECT * FROM usuario WHERE usuario like ?";
        
        Usuario u = new Usuario();
        
        PreparedStatement pst;
        ResultSet rs;
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setString(1, usuario.getSenha());
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                u.setId(rs.getInt("id"));
                u.setUsuario(rs.getString("usuario"));
                u.setSenha(rs.getString("senha"));
                u.setIsGerente(rs.getBoolean("isgerente"));
            }
            
            rs.close();
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o usuário");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return u;
    }

    @Override
    public ArrayList<Usuario> listar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Usuario> pesquisar(Usuario objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
