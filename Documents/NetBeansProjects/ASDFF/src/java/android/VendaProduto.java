/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android;

import dao.DAOVenda;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 *
 * @author Larissa
 */
public class VendaProduto {
    
    DAOVenda daoVenda = new DAOVenda();
    private int mesa;
    private int prod;
    private double qtd;
    private String obs;
    private String user;
    private int venda;
    public VendaProduto(DataInputStream in) throws IOException {
            //Faz a leitura das variaveis
            mesa = in.readInt();
            prod = in.readInt();
            qtd  = in.readDouble();
            obs  = in.readUTF();
            user = in.readUTF();
    }
    public int vender(){

        daoVenda = new DAOVenda();
        venda = daoVenda.venderProduto(mesa,prod,qtd,obs,user);

        return venda;
    }
    public void enviar(DataOutputStream out) throws IOException{
            //Envia o valor do retorno
            out.writeInt(venda);
    }

}
