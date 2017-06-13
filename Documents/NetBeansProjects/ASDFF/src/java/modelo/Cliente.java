/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Larissa
 */
public class Cliente {
    private int idEntity;
    private String nomCompletoEntity,nomUserCliente,sexCliente,celCliente,passCliente;

    public Cliente(int idEntity, String nomCompletoEntity, String nomUserCliente, String sexCliente, String celCliente, String passCliente) {
        this.idEntity = idEntity;
        this.nomCompletoEntity = nomCompletoEntity;
        this.nomUserCliente = nomUserCliente;
        this.sexCliente = sexCliente;
        this.celCliente = celCliente;
        this.passCliente = passCliente;
    }

    public Cliente() {}

    public int getIdEntity() {
        return idEntity;
    }

    public String getNomCompletoEntity() {
        return nomCompletoEntity;
    }

    public String getNomUserCliente() {
        return nomUserCliente;
    }

    public String getSexCliente() {
        return sexCliente;
    }

    public String getCelCliente() {
        return celCliente;
    }

    public String getPassCliente() {
        return passCliente;
    }

    public void setIdEntity(int idEntity) {
        this.idEntity = idEntity;
    }

    public void setNomCompletoEntity(String nomCompletoEntity) {
        this.nomCompletoEntity = nomCompletoEntity;
    }

    public void setNomUserCliente(String nomUserCliente) {
        this.nomUserCliente = nomUserCliente;
    }

    public void setSexCliente(String sexCliente) {
        this.sexCliente = sexCliente;
    }

    public void setCelCliente(String celCliente) {
        this.celCliente = celCliente;
    }

    public void setPassCliente(String passCliente) {
        this.passCliente = passCliente;
    }
    
    
}
