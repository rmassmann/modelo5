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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Renan
 */

@Entity
@Table(name = "voo")
public class Voo implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_voo", sequenceName = "seq_voo_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_voo", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "descricao", nullable = true)  
    private String Descricao;
    @NotNull(message = "Tempo Estimado deve ser informado")
    @Column(name = "tempoEstimado", nullable = false, columnDefinition = "numeric(12,2)")
    private Double tempoEstimado;
    @NotNull(message = "Ativo não pode ser nulo")
    @Column(name = "ativo", nullable = false)
    private Boolean ativo;
    @Length(max = 100, message = "A periodicidade não pode ter mais de {max} caracteres")
    @Column(name = "periodicidade", length = 100, nullable = true)
    private String pediodicidade;
    @OneToMany(mappedBy = "voo",cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<VooAgendado> voosAgendados = new ArrayList<>();
    @ManyToMany
    @JoinTable(name = "escalas",
            joinColumns = 
            @JoinColumn(name = "voo", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = 
            @JoinColumn(name = "aeroporto", referencedColumnName = "id", nullable = false))
    private List<Aeroporto> escalas = new ArrayList<>();
    public Voo(){};

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public void adicionarVooAgendado(VooAgendado obj){
        obj.setVoo(this);
        this.voosAgendados.add(obj);
    }
    
    public void removerTelefone(int index){
        this.voosAgendados.remove(index);
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public Double getTempoEstimado() {
        return tempoEstimado;
    }

    public void setTempoEstimado(Double tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getPediodicidade() {
        return pediodicidade;
    }

    public void setPediodicidade(String pediodicidade) {
        this.pediodicidade = pediodicidade;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Voo other = (Voo) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public List<VooAgendado> getVoosAgendados() {
        return voosAgendados;
    }

    public void setVoosAgendados(List<VooAgendado> voosAgendados) {
        this.voosAgendados = voosAgendados;
    }

    public List<Aeroporto> getEscalas() {
        return escalas;
    }

    public void setEscalas(List<Aeroporto> escalas) {
        this.escalas = escalas;
    }
    
    
    
    
}
