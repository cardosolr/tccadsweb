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
public class CadastraUsuario {
    
    DAOCliente dc = new DAOCliente();
    private String nomCompletoEntity;
    private String nomUserCliente;
    private String sexCliente;
    private String celCliente;
    private String passCliente;
    private int flag;
    
    public CadastraUsuario(DataInputStream in) throws IOException {
	//Faz a leitura do usuario e senha
	nomCompletoEntity = in.readUTF();
	nomUserCliente = in.readUTF();  
        sexCliente = in.readUTF(); 
        celCliente = in.readUTF(); 
        passCliente = in.readUTF(); 
    }
    //String nomCompletoEntity,String nomUserCliente,String sexCliente,String celCliente,String passCliente) throws IOException {
    public int cadastrar(){
        //Chama a classe dao para fazer validacao dos campos
        Cliente cli = new Cliente();
        cli.setNomCompletoEntity(nomCompletoEntity);
        cli.setNomUserCliente(nomUserCliente);
        cli.setSexCliente(sexCliente);
        cli.setCelCliente(celCliente);
        cli.setPassCliente(passCliente);
            
        if(dc.manterCliente(cli)) {
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
