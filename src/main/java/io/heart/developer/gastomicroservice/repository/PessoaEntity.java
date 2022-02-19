package io.heart.developer.gastomicroservice.repository;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "PESSOA", schema = "public")
public class PessoaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PESSOA_ID", nullable = false)
    private UUID id;

    @Column(name = "PESSOA_NOME")
    private String nome;

    @Column(name = "PESSOA_SALDO")
    private BigDecimal saldo;

    public PessoaEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
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
                '}';
    }
}
