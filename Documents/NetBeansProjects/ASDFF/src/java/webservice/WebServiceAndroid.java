/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import dao.DAOCliente;
import dao.DAOProduto;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import modelo.Cliente;
import modelo.Conta;
import modelo.Entity;
import modelo.Produto;

/**
 *
 * @author Larissa
 */
@WebService(serviceName = "WebServiceAndroid")
public class WebServiceAndroid {

    /**
     * This is a sample web service operation
     */

    /**
     * Web service operation
     */
    @WebMethod(operationName = "validaLogin")
    public Integer validaLogin(@WebParam(name = "usuario") String usuario, @WebParam(name = "senha") String senha) {
        //TODO write your implementation code here:
        int retorno=0;
        DAOCliente dc = new DAOCliente();
        Cliente cli = new Cliente();

        cli.setNomUserCliente(usuario);
        cli.setPassCliente(senha);
        boolean validar = dc.validaLogin(cli);
        if (validar){
            retorno = 1;
        }
        
        return retorno;
    }
    
    /**
     * Operação de Web service
     */
    @WebMethod(operationName = "getProdutosAndroid")
    public List<Produto> getCategoriaAndroid() {
        DAOProduto dp = new DAOProduto();
        List<Produto> listCat = dp.selectProdutoAndroid();
        
        return listCat;
    }
    
    @WebMethod(operationName = "getMesas")
    public List<Entity> getMesas() {  
        DAOProduto dp = new DAOProduto();
        List<Entity> listEnt = dp.selectMesa();
        
        return listEnt;
    }
    
    @WebMethod(operationName = "getConta")
    public List<Conta> getConta(@WebParam(name = "usuario") String usuario) {  
        DAOProduto dp = new DAOProduto();
        List<Conta> listConta = dp.selectContaAndroid(usuario);
        
        return listConta;
    }
}
