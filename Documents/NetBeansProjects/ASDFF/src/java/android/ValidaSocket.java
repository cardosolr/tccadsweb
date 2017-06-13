/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package android;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

/**
 *
 * @author Larissa
 */
public class ValidaSocket {
    private static final int PORTA = 7777;

    public static void main(String[] args) throws IOException {
            ServerSocket serverSocket = new ServerSocket(PORTA);
            System.out.println("Socket aberto na porta 7777");
            try{
            while(true){
                    System.out.println("esperando ...");
                    Socket socket = serverSocket.accept();
                    System.out.println("conectou!");
                    new ValidaSocketThread(socket).run();
            }
            }catch (SocketTimeoutException e){
                serverSocket.close();
            }
            catch (IOException e){
                serverSocket.close();
            }
    }
    
}
