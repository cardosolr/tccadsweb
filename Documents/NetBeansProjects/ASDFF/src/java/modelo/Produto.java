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
public class Produto {
    
    private String codCategoria,desCategoria;
    private String prods;

    public Produto() {
    }

    public Produto(String codCategoria, String desCategoria, String prods) {
        this.codCategoria = codCategoria;
        this.desCategoria = desCategoria;
        this.prods = prods;
    }

    public String getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(String codCategoria) {
        this.codCategoria = codCategoria;
    }

    public String getDesCategoria() {
        return desCategoria;
    }

    public void setDesCategoria(String desCategoria) {
        this.desCategoria = desCategoria;
    }

    public String getProds() {
        return prods;
    }

    public void setProds(String prods) {
        this.prods = prods;
    }
    
}
