/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.renanmassmann.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Renan
 */

@Entity
@Table(name = "aeroporto")
public class Aeroporto implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_aeroporto", sequenceName = "seq_aeroporto_id", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_aeroporto", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Length(max = 50, message = "O nome não pode ter mais que {max} caracteres")
    @NotNull(message = "O nome deve ser informado")
    @NotBlank(message = "O nome não pode ser em branco")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    @NotNull(message = "Operacional não pode ser nulo")
    @Column(name = "operacional", nullable = false)
    private Boolean operacional;
    @NotNull(message = "A cidade deve ser informada")
    @ManyToOne
    @JoinColumn(name = "cidade", referencedColumnName = "id",nullable = false)
    @ForeignKey(name = "fk_cidade_id")
    private Cidade cidade;
    @ManyToMany
    @JoinTable(name = "escalas",
            joinColumns = 
            @JoinColumn(name = "aeroporto", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = 
            @JoinColumn(name = "voo", referencedColumnName = "id", nullable = false))    
    private List<Voo> voos = new ArrayList<>();
    
    
    public Aeroporto(){};

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


    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + Objects.hashCode(this.id);
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
        final Aeroporto other = (Aeroporto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public List<Voo> getVoos() {
        return voos;
    }

    public void setVoos(List<Voo> voos) {
        this.voos = voos;
    }

    public Boolean getOperacional() {
        return operacional;
    }

    public void setOperacional(Boolean operacional) {
        this.operacional = operacional;
    }
    
    
    
    
}
