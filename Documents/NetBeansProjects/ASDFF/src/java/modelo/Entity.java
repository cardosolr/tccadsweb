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
public class Entity {
    
    private int idEntity;
    private String nomEntity,tpoEntity;

    public Entity() {
    }

    public Entity(int idEntity, String nomEntity, String tpoEntity) {
        this.idEntity = idEntity;
        this.nomEntity = nomEntity;
        this.tpoEntity = tpoEntity;
    }

    public int getIdEntity() {
        return idEntity;
    }

    public void setIdEntity(int idEntity) {
        this.idEntity = idEntity;
    }

    public String getNomEntity() {
        return nomEntity;
    }

    public void setNomEntity(String nomEntity) {
        this.nomEntity = nomEntity;
    }

    public String getTpoEntity() {
        return tpoEntity;
    }

    public void setTpoEntity(String tpoEntity) {
        this.tpoEntity = tpoEntity;
    } 
    
}
