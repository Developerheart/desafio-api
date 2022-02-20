package io.heart.developer.gastomicroservice.dto.response;

import io.heart.developer.gastomicroservice.constantes.Tag;
import org.apache.tomcat.jni.Local;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.StringJoiner;

public class GastoResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal valor;

	private String dataHora;

	private String descricao;

	private Tag tag;


	public GastoResponse(BigDecimal valor, LocalDateTime dataHora) {
		this.valor = valor;
		this.dataHora = dataHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	}

	public GastoResponse() {

	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Tag getTag() {
		return tag;
	}

	public void setTag(Tag tag) {
		this.tag = tag;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
	}

	public GastoResponse(BigDecimal valor, LocalDateTime dataHora, String descricao, Tag tag) {
		this.valor = valor;
		this.dataHora = dataHora.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
		this.descricao = descricao;
		this.tag = tag;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		GastoResponse that = (GastoResponse) o;
		return Objects.equals(valor, that.valor) && Objects.equals(dataHora, that.dataHora) && Objects.equals(descricao, that.descricao) && tag == that.tag;
	}

	@Override
	public int hashCode() {
		return Objects.hash(valor, dataHora, descricao, tag);
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", GastoResponse.class.getSimpleName() + "[", "]")
			.add("valor=" + valor)
			.add("dataHora='" + dataHora + "'")
			.add("descricao='" + descricao + "'")
			.add("tag=" + tag)
			.toString();
	}
}
