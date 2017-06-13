/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.DAOGenerica.getConn;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import modelo.Conta;
import modelo.Entity;
import modelo.Produto;

/**
 *
 * @author Larissa
 */
public class DAOProduto {
    
    private PreparedStatement stm, stmA;
    
    public ArrayList<Produto> selectProdutoAndroid(){
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        try{

            stm = getConn().prepareStatement("SELECT codcategoria,descategoria FROM obter_produtos(1::numeric,NULL::bpchar)");
            ResultSet result = stm.executeQuery();
            
            while(result.next()){
                Produto c = new Produto();
                String prods = "";
                c.setCodCategoria(result.getString("codcategoria"));
                c.setDesCategoria(result.getString("descategoria"));
                
                stmA = getConn().prepareStatement("SELECT iditchv||'-'||nomitem||'  R$:'||vlritchv AS prod FROM obter_produtos(2::numeric,?::bpchar)");
                stmA.setString(1,result.getString("codcategoria"));
                ResultSet resultA = stmA.executeQuery();
               while(resultA.next()){
                   if (prods.equals("")){
                       prods = resultA.getString("prod");
                   }else{
                       prods = prods+";"+resultA.getString("prod");
                   }
               }
               c.setProds(prods);
               produtos.add(c);
            }
        } catch(Exception e){
                e.printStackTrace();
        }
        return produtos;
    }
    
    public ArrayList<Entity> selectMesa(){
        ArrayList<Entity> mesas = new ArrayList<Entity>();
        try{

            stm = getConn().prepareStatement("SELECT * "
                                             + "FROM entity "
                                            + "WHERE tpoentity = 'MES' "
                                            + "ORDER BY nomentity");
            ResultSet result = stm.executeQuery();
            
            while(result.next()){
                Entity m = new Entity();
                m.setIdEntity(result.getInt("identity"));
                m.setNomEntity(result.getString("nomentity"));
                mesas.add(m);
            }

        } catch(Exception e){
                e.printStackTrace();
        }
        
        return mesas;
    }
        
    public ArrayList<Conta> selectContaAndroid(String usuario){
        ArrayList<Conta> contaLista = new ArrayList<Conta>();
        try{
            stm = getConn().prepareStatement("SELECT nomitem AS prod, qtditem,vlrttitem FROM venda.obter_itenscliente(?::bpchar)");
            stm.setString(1,usuario);
            ResultSet resultA = stm.executeQuery();
            while(resultA.next()){
                Conta conta = new Conta();
                conta.setNomProd(resultA.getString("prod"));
                conta.setQtd(resultA.getInt("qtditem"));
                conta.setPrecott(resultA.getDouble("vlrttitem"));
                contaLista.add(conta);             
            }
        } catch(Exception e){
                e.printStackTrace();
        }
        return contaLista;
    }
    
}
