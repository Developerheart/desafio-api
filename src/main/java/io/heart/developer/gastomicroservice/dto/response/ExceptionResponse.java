package io.heart.developer.gastomicroservice.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;

public class ExceptionResponse {

    private String mensagem;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String causa;

    public ExceptionResponse(String mensagem, String casua) {
        this.mensagem = mensagem;
        this.causa = casua;
    }

    public ExceptionResponse(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }
}
