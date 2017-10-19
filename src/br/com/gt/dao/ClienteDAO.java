/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.dao;

import br.com.gt.model.Endereco;
import br.com.gt.model.PessoaFisica;
import br.com.gt.model.Usuario;
import br.com.gt.model.Venda;
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
public class ClienteDAO implements DAO<PessoaFisica>{

    Connection connection;

    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public boolean inserir(PessoaFisica cliente) {
        String sql = "insert into cliente (email,nome,telefone,cpf,rg,endereco_id,sexo) values (?,?,?,?,?,?,?)";
        
        PreparedStatement pst;
        
        if(validarCampos(cliente)==true){
            if(existe(cliente)==false){
                try {
                    pst = connection.prepareStatement(sql);

                    pst.setString(1, cliente.getEmail());
                    pst.setString(2, cliente.getNome());
                    pst.setString(3, cliente.getTelefone());
                    pst.setString(4, cliente.getCpf());
                    pst.setString(5, cliente.getRg());

                    Endereco endereco = new Endereco();
                    EnderecoDAO enderecoDAO = new EnderecoDAO(connection);
                    endereco = enderecoDAO.buscar(cliente.getEndereco());

                    if(endereco.getId() < 1){
                        enderecoDAO.inserir(cliente.getEndereco());
                        endereco = enderecoDAO.buscar(cliente.getEndereco());
                    }

                    cliente.getEndereco().setId(endereco.getId());

                    pst.setInt(6, cliente.getEndereco().getId());

                    pst.setString(7, cliente.getSexo());

                    pst.execute();
                    pst.close();
                    JOptionPane.showMessageDialog(null, "Cadastro efetuado com sucesso");
                    return true;
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Não foi possível salvar o cliente");
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Já existe cliente registrado com este CPF");
                return false;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
            return false;
        }
        return false;
    }

    @Override
    public boolean alterar(PessoaFisica cliente) {
        String sql = "update cliente set email = ?, nome = ?, telefone = ?, cpf = ?, rg = ?, endereco_id = ?, sexo = ? where id = ?";
        
        PreparedStatement pst;
        
        if(validarCampos(cliente)==true){
            if(existeAlterar(cliente)==false){
                try {
                    pst = connection.prepareStatement(sql);

                    pst.setString(1, cliente.getEmail());
                    pst.setString(2, cliente.getNome());
                    pst.setString(3, cliente.getTelefone());
                    pst.setString(4, cliente.getCpf());
                    pst.setString(5, cliente.getRg());

                    Endereco endereco = new Endereco();
                    EnderecoDAO enderecoDAO = new EnderecoDAO(connection);
                    endereco = enderecoDAO.buscar(cliente.getEndereco());

                    if(endereco.getId() < 1){
                        enderecoDAO.inserir(cliente.getEndereco());
                        endereco = enderecoDAO.buscar(cliente.getEndereco());
                    }

                    cliente.getEndereco().setId(endereco.getId());

                    pst.setInt(6, cliente.getEndereco().getId());

                    pst.setString(7, cliente.getSexo());

                    pst.setInt(8, cliente.getId());

                    pst.execute();
                    pst.close();
                    JOptionPane.showMessageDialog(null, "Alteração efetuada com sucesso");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Não foi possível alterar o cliente");
                    Logger.getLogger(FuncionarioDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Já existe cliente registrado com este CPF");
                return false;
            }
        }else{
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
            return false;
        }
        return false;
    }

    @Override
    public boolean excluir(PessoaFisica cliente) {
        String sql = "delete from cliente where id = ?";
        
        PreparedStatement pst;
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setInt(1, cliente.getId());
            
            Endereco e = cliente.getEndereco();
            
            pst.execute();
            pst.close();
            
            EnderecoDAO eDao = new EnderecoDAO(this.connection);
            
            if(eDao.existeEmCliente(e) == false){
                eDao.excluir(e);
            }
            
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o cliente");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public PessoaFisica buscar(PessoaFisica cliente) {
        String sql = "SELECT * FROM cliente where id = ?";
                
        PreparedStatement pst;
        ResultSet rs;
        
        PessoaFisica cli = new PessoaFisica();
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setInt(1, cliente.getId());
            
            rs = pst.executeQuery();
            
            EnderecoDAO eDao = new EnderecoDAO(this.connection);
            
            while(rs.next()){
                PessoaFisica c = new PessoaFisica();
                
                c.setId(rs.getInt("Id"));
                c.setEmail(rs.getString("email"));
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));
                c.setCpf(rs.getString("cpf"));
                c.setRg(rs.getString("rg"));
                
                Endereco e = new Endereco();
                
                e.setId(rs.getInt("endereco_id"));
                e = eDao.buscarById(e.getId());
                
                c.setEndereco(e);
                
                cli = c;
            }
            
            rs.close();
            pst.close();
            return cli;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o cliente");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<PessoaFisica> listar() {
        String sql = "SELECT * FROM cliente order by nome";
                
        PreparedStatement pst;
        ResultSet rs;
        
        ArrayList<PessoaFisica> clientes = new ArrayList<>();
        
        try {
            pst = connection.prepareStatement(sql);
            
            rs = pst.executeQuery();
            
            EnderecoDAO eDao = new EnderecoDAO(this.connection);
            
            while(rs.next()){
                PessoaFisica c = new PessoaFisica();
                Endereco e = new Endereco();
                
                c.setId(rs.getInt("Id"));
                c.setCpf(rs.getString("cpf"));
                c.setEmail(rs.getString("email"));
                c.setNome(rs.getString("nome"));
                c.setRg(rs.getString("rg"));
                c.setSexo(rs.getString("sexo"));
                c.setTelefone(rs.getString("telefone"));
                
                e.setId(rs.getInt("endereco_id"));
                
                c.setEndereco(eDao.buscarById(e.getId()));
                
                clientes.add(c);
            }
            
            rs.close();
            pst.close();
            return clientes;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o cliente");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public ArrayList<PessoaFisica> pesquisar(String nome) {
        String sql = "SELECT * FROM cliente where nome ~* ?";
                
        PreparedStatement pst;
        ResultSet rs;
        
        ArrayList<PessoaFisica> clientes = new ArrayList<>();
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setString(1, nome);
            
            rs = pst.executeQuery();
            
            EnderecoDAO eDao = new EnderecoDAO(this.connection);
            
            while(rs.next()){
                PessoaFisica c = new PessoaFisica();
                Endereco e = new Endereco();
                
                c.setId(rs.getInt("Id"));
                c.setCpf(rs.getString("cpf"));
                c.setEmail(rs.getString("email"));
                c.setNome(rs.getString("nome"));
                c.setRg(rs.getString("rg"));
                c.setSexo(rs.getString("sexo"));
                c.setTelefone(rs.getString("telefone"));
                
                e.setId(rs.getInt("endereco_id"));
                
                c.setEndereco(eDao.buscarById(e.getId()));
                
                clientes.add(c);
            }
            
            rs.close();
            pst.close();
            return clientes;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o cliente");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public boolean possuiCompras(PessoaFisica cliente){
        String sql = "SELECT * FROM venda where cliente_id = ?";
                
        PreparedStatement pst;
        ResultSet rs;
        
        Venda venda = new Venda();
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setInt(1, cliente.getId());
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                Venda v = new Venda();
                
                v.setId(rs.getInt("Id"));
                
                venda = v;
            }
            
            rs.close();
            pst.close();
            
            if(venda.getId() > 0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar a venda");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    private boolean validarCampos(PessoaFisica cliente) {
        if(cliente.getNome().length() != 0 && cliente.getEmail().length() != 0 && 
            cliente.getCpf().length()!=0 && cliente.getRg().length()  != 0 && 
            cliente.getSexo() != null && cliente.getTelefone().length() != 0){
                EnderecoDAO eDao = new EnderecoDAO(this.connection);
                if(eDao.validarCampos(cliente.getEndereco()) == true){
                    return true;
                }else{
                    return false;
                }             
        }else{
            return false;
        }
    }

    public boolean existe(PessoaFisica cliente){
        String sql = "SELECT * FROM cliente where cpf like ?";
                
        PreparedStatement pst;
        ResultSet rs;
        
        PessoaFisica cli = new PessoaFisica();
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setString(1, cliente.getCpf());
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                cli.setId(rs.getInt("Id"));
            }
            
            rs.close();
            pst.close();
            
            if(cli.getId() > 0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o cliente");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean existeAlterar(PessoaFisica cliente){
        String sql = "SELECT * FROM cliente where cpf like ? and id != ?";
                
        PreparedStatement pst;
        ResultSet rs;
        
        PessoaFisica cli = new PessoaFisica();
        
        try {
            pst = connection.prepareStatement(sql);
            
            pst.setString(1, cliente.getCpf());
            pst.setInt(2, cliente.getId());
            
            rs = pst.executeQuery();
            
            while(rs.next()){
                cli.setId(rs.getInt("Id"));
            }
            
            rs.close();
            pst.close();
            
            if(cli.getId() > 0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o cliente");
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
