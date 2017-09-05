/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author lucas
 */
@Entity
public class Aquisicao {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private Date data;
    @OneToOne(cascade = CascadeType.ALL)
    private Material material;
    @Column
    private double valorUitario;
    @Column
    private int quantidadeMaterial;
    @Column
    private double valorTotal;
    @ManyToOne
    private Fornecedor fornecedor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public double getValorUitario() {
        return valorUitario;
    }

    public void setValorUitario(double valorUitario) {
        this.valorUitario = valorUitario;
    }

    public int getQuantidadeMaterial() {
        return quantidadeMaterial;
    }

    public void setQuantidadeMaterial(int quantidadeMaterial) {
        this.quantidadeMaterial = quantidadeMaterial;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    
}
