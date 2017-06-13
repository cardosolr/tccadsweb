/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAOGenerica.getConn;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;

/**
 *
 * @author Larissa
 */
public class DAOCliente extends DAOGenerica implements Serializable{
    private PreparedStatement stm;
    
        public boolean manterCliente(Cliente cli){
            try{
                int idEntity = getNextIdEntity();

                System.out.println("SQL: SELECT manter_user("
                                            +idEntity+"::numeric,"
                                            +cli.getNomCompletoEntity()+","
                                            +cli.getNomUserCliente()+","
                                            +cli.getCelCliente()+","
                                            +cli.getSexCliente()+","
                                            +"MD5("+cli.getPassCliente()+")::varchar,true::boolean,1)");

                stm = getConn().prepareStatement("SELECT manter_usercliente(?::numeric,?::varchar,?::varchar,?::bpchar,MD5(?)::varchar,?::varchar,1::numeric) AS res");
                stm.setInt(1,idEntity);
                stm.setString(2,cli.getNomCompletoEntity());
                stm.setString(3,cli.getNomUserCliente());
                stm.setString(4,cli.getSexCliente());
                stm.setString(5,!cli.getPassCliente().equals("")?cli.getPassCliente():"NULL");
                stm.setString(6,cli.getPassCliente());
                ResultSet result = stm.executeQuery();

                if(result.next()){
                    return result.getString("res").equals("0");
                }
            } catch(Exception e){
                e.printStackTrace();
            }

            return false;
    }
        
    public int getNextIdEntity(){
        try {
            stm = getConn().prepareStatement("SELECT NEXTVAL('seq_entity_identity'::text) AS res");
            ResultSet result = stm.executeQuery();

            if(result.next()){
                return Integer.valueOf(result.getString("res"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    public boolean validaLogin(Cliente cli){
        try{
            stm = getConn().prepareStatement("SELECT valida_usercliente(?::varchar,MD5(?)::varchar) AS res");
            stm.setString(1,cli.getNomUserCliente());
            stm.setString(2,cli.getPassCliente());
            ResultSet result = stm.executeQuery();

            if(result.next()){
                return result.getString("res").equals("0");
            }
        } catch(Exception e){
            e.printStackTrace();
        }
         
        return false;
    }
}
