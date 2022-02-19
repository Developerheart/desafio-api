package io.heart.developer.gastomicroservice.repository.pessoa;

import io.heart.developer.gastomicroservice.repository.gasto.GastoEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PESSOA", schema = "public")
public class PessoaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "PESSOA_ID")
    private Integer id;

    @Column(name = "PESSOA_NOME")
    private String nome;

    @Column(name = "PESSOA_SALDO")
    private BigDecimal saldo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pessoaEntity", fetch = FetchType.LAZY)
    private List<GastoEntity> gastos;

    public PessoaEntity() {
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

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PessoaEntity that = (PessoaEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(saldo, that.saldo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, saldo);
    }

    @Override
    public String toString() {
        return "PessoaEntity{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", saldo=" + saldo +
                ", gastos=" + gastos +
                '}';
    }
}
