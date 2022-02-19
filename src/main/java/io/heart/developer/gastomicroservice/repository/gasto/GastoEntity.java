package io.heart.developer.gastomicroservice.repository.gasto;

import io.heart.developer.gastomicroservice.constantes.Tag;
import io.heart.developer.gastomicroservice.repository.pessoa.PessoaEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "GASTO", schema = "public")
public class GastoEntity {
    @Id
    @Column(name = "GASTO_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "GASTO_VALOR")
    private BigDecimal valor;


    @Column(name = "GASTO_DATA_HORA")
    private LocalDateTime dataHora;


    @Column(name = "GASTO_TAG")
    @Enumerated(EnumType.STRING)
    private Tag tag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "PESSOA_ID", name = "PESSOA_ID")
    public PessoaEntity pessoaEntity;

    public GastoEntity() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public PessoaEntity getPessoaEntity() {
        return pessoaEntity;
    }

    public void setPessoaEntity(PessoaEntity pessoaEntity) {
        this.pessoaEntity = pessoaEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GastoEntity that = (GastoEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(valor, that.valor) && Objects.equals(dataHora, that.dataHora) && tag == that.tag;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, valor, dataHora, tag);
    }

    @Override
    public String toString() {
        return "GastoEntity{" +
                "id=" + id +
                ", valor=" + valor +
                ", dataHora=" + dataHora +
                ", tag=" + tag +
                '}';
    }
}
