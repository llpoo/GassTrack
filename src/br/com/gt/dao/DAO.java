/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.gt.dao;

import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public interface DAO<T> {
    public void inserir(T objeto);
    public void alterar(T objeto);
    public boolean excluir(T objeto);
    public T buscar(T objeto);
    public ArrayList<T> listar();
    public ArrayList<T> pesquisar(String objeto);
}
