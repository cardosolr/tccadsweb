/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.projeto.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Larissa
 */
@Entity
@Table (name = "curso")
public class Curso implements Serializable{
    
   @Id
   @Column (name = "id")
   @SequenceGenerator(name="seq_curso", sequenceName = "seq_curso_id", allocationSize = 1)
   @GeneratedValue(generator="seq_curso", strategy = GenerationType.SEQUENCE)
   private Integer id;
   @Column (name = "nome", nullable = false, length = 50)
   @Length (max = 50, message = "O nome não deve ter mais de 50 caracteres!")
   @NotEmpty(message = "O nome não pode ser vazio!")
   private String nome;
   @NotEmpty(message = "A descrição não pode ser vazia!")
   @Type(type = "org.hibernate.type.StringClobType")
   @Column (name = "descricao", nullable = false)
   @Lob
   private String descricao;
   @ManyToMany(fetch = FetchType.LAZY)
   @JoinTable(name = "cursoaluno",
           joinColumns = @JoinColumn(name = "id_curso", referencedColumnName = "id", nullable = false),
           inverseJoinColumns = @JoinColumn(name = "id_aluno", referencedColumnName = "id", nullable = false),
           uniqueConstraints = {@UniqueConstraint(columnNames = {"id_curso","id_aluno"})})
   private List<Aluno> alunos = new ArrayList<>();

    public Curso() {}

    public Curso(Integer id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Curso other = (Curso) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
    
    
}
