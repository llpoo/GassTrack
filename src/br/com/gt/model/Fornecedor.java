/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.model;

import java.util.List;

/**
 *
 * @author lucas
 */
public class Fornecedor extends Pessoa{
    private String cnpj;
    private List<Aquisicao> aquisicoes;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<Aquisicao> getAquisicoes() {
        return aquisicoes;
    }

    public void setAquisicoes(List<Aquisicao> aquisicoes) {
        this.aquisicoes = aquisicoes;
    }
    
    
}
