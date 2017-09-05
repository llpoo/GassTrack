/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.model;

//import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
/**
 *
 * @author lucas
 */
@Entity
public class Material {
    @Id
    @GeneratedValue
    private long id;
    @Column
    private int quantidadeAtual;
    @Column
    private int estoqueMinimo;
    @Column
    private double precoUnitario;
    @Column
    private boolean isAcessorio;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantidadeAtual() {
        return quantidadeAtual;
    }

    public void setQuantidadeAtual(int quantidadeAtual) {
        this.quantidadeAtual = quantidadeAtual;
    }

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public boolean isIsAcessorio() {
        return isAcessorio;
    }

    public void setIsAcessorio(boolean isAcessorio) {
        this.isAcessorio = isAcessorio;
    }
}
