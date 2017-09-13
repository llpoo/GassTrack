/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.model;

//import java.util.List;
/**
 *
 * @author lucas
 */
public class Material {
    private long id;
    private int quantidadeAtual;
    private int estoqueMinimo;
    private double precoUnitario;
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
