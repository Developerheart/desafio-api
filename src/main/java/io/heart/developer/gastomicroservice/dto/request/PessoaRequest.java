package io.heart.developer.gastomicroservice.dto.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class PessoaRequest implements Serializable {
    public static final long serialVersionUID = 1L;

    private String nome;

    private BigDecimal saldo;

    public PessoaRequest() {
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
        PessoaRequest that = (PessoaRequest) o;
        return Objects.equals(nome, that.nome) && Objects.equals(saldo, that.saldo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, saldo);
    }

    @Override
    public String toString() {
        return "PessoaRequest{" +
                "nome='" + nome + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
