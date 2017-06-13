/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpackage;

import dao.DAOCliente;

/**
 *
 * @author Larissa
 */
public class MainClass {
    private int result;
    private int id=0;
    private String nomCompletoEntity="Teste IDE",
                   nomUserCliente="testeide",
                   sexCliente="F",
                   celCliente="14997060652",
                   passCliente="testeide";
    
    
    public static void main (String args[]){
        System.out.println("Funciona bicha");
        MainClass mc = new MainClass();
        mc.javaViadao();
        
    }
    
    public void javaViadao(){
        //DAOCliente dc = new DAOCliente();
        //result = dc.manterCliente(id, nomCompletoEntity, nomUserCliente,sexCliente,celCliente,passCliente);
        System.out.println("Rsultado: ");
    }
    
}
