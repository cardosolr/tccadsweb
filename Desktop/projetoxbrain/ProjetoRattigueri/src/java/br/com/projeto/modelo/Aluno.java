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
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author Larissa
 */
@Entity
@Table (name = "aluno")
public class Aluno implements Serializable{
    @Id
    @Column (name = "id")
    @SequenceGenerator(name="seq_aluno", sequenceName = "seq_aluno_id", allocationSize = 1)
    @GeneratedValue(generator="seq_aluno", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column (name = "nome", nullable = false, length = 60)
    @Length (max = 60, message = "O nome não deve ter mais de 60 caracteres!")
    @NotEmpty(message = "O nome não pode ser vazio!")
    private String nome;
    @Column (name = "rg", nullable = false, length = 12)
    @Length (max = 12, message = "O RG não deve ter mais de 12 caracteres!")
    @NotEmpty(message = "O RG não pode ser vazio!")
    private String rg;
    @Column (name = "cpf", nullable = false, length = 14)
    @Length (max = 14, message = "O CPF não deve ter mais de 14 caracteres!")
    @NotEmpty(message = "O CPF não pode ser vazio!")
    private String cpf;
    @Column (name = "endereco", nullable = false, length = 150)
    @Length (max = 150, message = "O endereço não deve ter mais de 150 caracteres!")
    @NotEmpty(message = "O endereço não pode ser vazio!")
    private String endereco;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "cursoaluno",
           joinColumns = @JoinColumn(name = "id_aluno", referencedColumnName = "id", nullable = false),
           inverseJoinColumns = @JoinColumn(name = "id_curso", referencedColumnName = "id", nullable = false),
           uniqueConstraints = {@UniqueConstraint(columnNames = {"id_curso","id_aluno"})})
    private List<Curso> cursos = new ArrayList<>();

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final Aluno other = (Aluno) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    
    
}
