/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.model;

import java.util.Date;;

/**
 *
 * @author lucas
 */

public class Aquisicao {
    
    private int id;
    private Date data;
    private Material material;
    private double valorUitario;
    private int quantidadeMaterial;
    private double valorTotal;
    private Fornecedor fornecedor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
