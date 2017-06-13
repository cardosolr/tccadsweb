/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android;

import dao.DAOCliente;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import modelo.Cliente;

/**
 *
 * @author Larissa
 */
public class ValidaLogin {
    DAOCliente dc = new DAOCliente();
    private String usuario;
    private String senha;
    private int flag;
    
    public ValidaLogin(DataInputStream in) throws IOException {
	//Faz a leitura do usuario e senha
	usuario = in.readUTF();
	senha = in.readUTF();      
    }
    
    public int validar(){
        //Chama a classe dao para fazer validacao dos campos
        Cliente cli = new Cliente();
        cli.setNomUserCliente(usuario);
        cli.setPassCliente(senha);
            
        if(dc.validaLogin(cli)) {
            flag = 0;
        }else{
            flag = 1;
        }  
        
        return flag;
    }
    public void enviar(DataOutputStream out) throws IOException{
        //Envia a validaçao
        out.writeInt(flag);
    }
}
