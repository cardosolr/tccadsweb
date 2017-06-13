/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author Larissa
 */
public class ValidaSocketThread {
    private final Socket socket;
    public ValidaSocketThread(Socket socket) {
        this.socket = socket;
    }
    public void run() {
        try {
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            DataInputStream in 	= new DataInputStream(socket.getInputStream());
            String func  = in.readUTF();

            if (func.equals("valida")){
                ValidaLogin val = new ValidaLogin(in);
                val.validar();
                val.enviar(out);
            }else if(func.equals("cadcli")){
                CadastraUsuario caduser = new CadastraUsuario(in);
                caduser.cadastrar();
                caduser.enviar(out);
            }else if(func.equals("venda")){
                VendaProduto vd = new VendaProduto(in);
                vd.vender();
                vd.enviar(out);
            }
            out.close();
            in.close();
            socket.close();
        } catch (IOException e) {
                e.printStackTrace();
        }
    }
}