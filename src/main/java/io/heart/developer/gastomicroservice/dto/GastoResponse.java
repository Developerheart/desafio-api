package io.heart.developer.gastomicroservice.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class GastoResponse {

    private BigDecimal valor;
    private LocalDateTime localDateTime;

    public GastoResponse(BigDecimal valor, LocalDateTime localDateTime) {
        this.valor = valor;
        this.localDateTime = localDateTime;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GastoResponse that = (GastoResponse) o;
        return Objects.equals(valor, that.valor) && Objects.equals(localDateTime, that.localDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor, localDateTime);
    }

    @Override
    public String toString() {
        return "GastoResponse{" +
                "valor=" + valor +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
