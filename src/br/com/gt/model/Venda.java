/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.model;

import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 *
 * @author lucas
 */
@Entity
public class Venda {
    @Id
    private long id;
    @Column
    private Date dataAbertura;
    @Column
    private Date dataPagametno;
    @Column
    private boolean situacao;
    @Column
    private double valorMaoDeObra;
    @Column
    private double valorTotal;
    @Column
    private double desconto;
    @Column (length = 300)
    private String Descricao;
    @ManyToMany
    @JoinTable(name="venda_tem_materiais", joinColumns={@JoinColumn(name="venda_id")}, inverseJoinColumns={@JoinColumn(name="material_id")})
    private List<Material> materiais;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataPagametno() {
        return dataPagametno;
    }

    public void setDataPagametno(Date dataPagametno) {
        this.dataPagametno = dataPagametno;
    }

    public boolean isSituacao() {
        return situacao;
    }

    public void setSituacao(boolean situacao) {
        this.situacao = situacao;
    }

    public double getValorMaoDeObra() {
        return valorMaoDeObra;
    }

    public void setValorMaoDeObra(double valorMaoDeObra) {
        this.valorMaoDeObra = valorMaoDeObra;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public List<Material> getMateriais() {
        return materiais;
    }

    public void setMateriais(List<Material> materiais) {
        this.materiais = materiais;
    }
}
