/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author lucas
 */
@Entity
@DiscriminatorValue("J")
public class Fornecedor extends Pessoa{
    @Column
    private String cnpj;
    @OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL)
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
