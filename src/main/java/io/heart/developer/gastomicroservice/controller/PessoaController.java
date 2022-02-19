package io.heart.developer.gastomicroservice.controller;

import io.heart.developer.gastomicroservice.dto.response.GastoResponse;
import io.heart.developer.gastomicroservice.dto.response.PessoaResponse;
import io.heart.developer.gastomicroservice.repository.gasto.GastoEntity;
import io.heart.developer.gastomicroservice.repository.pessoa.PessoaEntity;
import io.heart.developer.gastomicroservice.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/pessoa")
public class PessoaController implements Serializable {
    public static final long serialVersionUID = 1L;

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/")
    public ResponseEntity<PessoaEntity> criarPessoa() {
        PessoaEntity pessoaEntity = new PessoaEntity();
        pessoaEntity.setNome("LEONARDO SOUZA");
        pessoaEntity.setSaldo(new BigDecimal("1000.00"));
        return ResponseEntity.ok(pessoaService.salvar(pessoaEntity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponse> buscarPorID(@PathVariable Integer id) {
        PessoaEntity pessoaEntity = pessoaService.buscarPorId(id);
        PessoaResponse response = new PessoaResponse();
        response.setNome(pessoaEntity.getNome());
        List<GastoResponse> gastoResponseList = new ArrayList<>();
        for (GastoEntity gasto : pessoaEntity.getGastos()) {
            gastoResponseList.add(new GastoResponse(gasto.getValor(), gasto.getDataHora()));
        }
        response.setGastoResponseList(gastoResponseList);
        return ResponseEntity.ok(response);
    }


}
