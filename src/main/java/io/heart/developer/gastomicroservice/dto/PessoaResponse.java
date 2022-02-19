package io.heart.developer.gastomicroservice.dto;

import java.util.List;

public class PessoaResponse {

    private String nome;
    private List<GastoResponse> gastoResponseList;


    public PessoaResponse() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<GastoResponse> getGastoResponseList() {
        return gastoResponseList;
    }

    public void setGastoResponseList(List<GastoResponse> gastoResponseList) {
        this.gastoResponseList = gastoResponseList;
    }

    @Override
    public String toString() {
        return "Response{" +
                "nome='" + nome + '\'' +
                ", gastoResponseList=" + gastoResponseList +
                '}';
    }
}

