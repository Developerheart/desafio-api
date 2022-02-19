package io.heart.developer.gastomicroservice.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.heart.developer.gastomicroservice.constantes.Tag;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class GastoRequest implements Serializable {
    public static final long serialVersionUID = 1L;

    @JsonProperty(required = true, value = "id_pessoa")
    private Integer id;

    @JsonProperty(required = true)
    private String descricao;

    @JsonProperty(required = true, value = "valor_do_gasto")
    private BigDecimal valor;

    @JsonProperty(required = true)
    private Tag tag;

    @JsonProperty(required = true)
    @DateTimeFormat(pattern = "dd/MM/YYYY hh:mm:ss")
    private LocalDateTime dataHora;

    public GastoRequest() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GastoRequest that = (GastoRequest) o;
        return Objects.equals(id, that.id) && Objects.equals(descricao, that.descricao) && Objects.equals(valor, that.valor) && tag == that.tag && Objects.equals(dataHora, that.dataHora);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, valor, tag, dataHora);
    }

    @Override
    public String toString() {
        return "GastoRequest{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", tag=" + tag +
                ", dataHora=" + dataHora +
                '}';
    }
}
