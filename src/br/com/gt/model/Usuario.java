/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.model;


/**
 *
 * @author lucas
 */
public class Usuario {
    private int id;
    private String usuario;
    private String senha;
    private boolean isGerente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean getIsIsGerente() {
        return isGerente;
    }

    public void setIsGerente(boolean isGerente) {
        this.isGerente = isGerente;
    }
    
    
}
