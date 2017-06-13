/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAOGenerica.getConn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Larissa
 */
public class DAOVenda {
    
    private PreparedStatement stm;
    
    public int venderProduto(int mesa, int prod, double qtd, String obs,String user){
        try{
           
            stm = getConn().prepareStatement("SELECT manter_vendaandroid(?::numeric,?::numeric,?::numeric,?::text,?::varchar) AS res");
            stm.setInt(1,mesa);
            stm.setInt(2,prod);
            stm.setDouble(3,qtd);
            stm.setString(4,obs);
            stm.setString(5,user);
            ResultSet result = stm.executeQuery();

            if(result.next()){
                return Integer.valueOf(result.getString("res"));
            }
        } catch(Exception e){
            e.printStackTrace();
        }
         
        return 1;
    }
}
