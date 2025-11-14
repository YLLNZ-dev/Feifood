/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Yllan
 */
public class Alimento {
    private int id;           
    private String descricao; 
    private String tipo;       
    private double preco;      
    
    public Alimento(int id, String descricao, String tipo, double preco) {
        this.id = id;
        this.descricao = descricao;
        this.tipo = tipo;
        this.preco = preco;
    }
    
    public Alimento(String descricao, String tipo, double preco) {
        this.descricao = descricao;
        this.tipo = tipo;
        this.preco = preco;
    }
    
    public Alimento() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return String.format("%s - R$%.2f", this.descricao, this.preco);
    }
}

