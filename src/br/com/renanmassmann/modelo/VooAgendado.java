/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.renanmassmann.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Renan
 */
@Entity
@Table(name = "voo_agendado")
public class VooAgendado implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_voo_agendado", sequenceName = "seq_voo_agendado_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_voo_agendado", strategy = GenerationType.SEQUENCE) 
    private Integer id;
     @NotNull(message = "A aeronave não pode ser nulo")
    @Length(max = 40, message = "A aeronave não pode ter mais de {max} caracteres")
    @NotBlank(message = "O aeronave não pode ser em branco")
    @Column(name = "aeronave", length = 40, nullable = false) 
    private String aeronave;
    @NotNull(message = "A quantidade de passageiros deve ser informada")
    @Column(name = "totalPassageiros", nullable = false)
    private Integer totalPassageiros;
    @NotNull(message = "A data deve ser informada")
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data", nullable = false)
    private Calendar data;
    @NotNull(message = "O Voo deve ser informado")
    @ManyToOne
    @JoinColumn(name = "voo_id", referencedColumnName = "id", nullable = false)
    private Voo voo;
    
    public VooAgendado(){};

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAeronave() {
        return aeronave;
    }

    public void setAeronave(String aeronave) {
        this.aeronave = aeronave;
    }

    public Integer getTotalPassageiros() {
        return totalPassageiros;
    }

    public void setTotalPassageiros(Integer totalPassageiros) {
        this.totalPassageiros = totalPassageiros;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public Voo getVoo() {
        return voo;
    }

    public void setVoo(Voo voo) {
        this.voo = voo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final VooAgendado other = (VooAgendado) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
