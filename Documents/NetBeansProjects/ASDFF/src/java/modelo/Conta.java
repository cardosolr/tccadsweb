/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Larissa
 */
public class Conta {
    
    private String nomProd;
    private int qtd;
    private double precott;

    public Conta() {}

    public Conta(String nomProd, int qtd, double precott) {
        this.nomProd = nomProd;
        this.qtd = qtd;
        this.precott = precott;
    }

    public String getNomProd() {
        return nomProd;
    }

    public int getQtd() {
        return qtd;
    }

    public double getPrecott() {
        return precott;
    }

    public void setNomProd(String nomProd) {
        this.nomProd = nomProd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public void setPrecott(double precott) {
        this.precott = precott;
    }
    
}
