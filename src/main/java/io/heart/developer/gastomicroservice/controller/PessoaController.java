package io.heart.developer.gastomicroservice.controller;

import io.heart.developer.gastomicroservice.dto.request.PessoaRequest;
import io.heart.developer.gastomicroservice.dto.response.GastoResponse;
import io.heart.developer.gastomicroservice.dto.response.PessoaResponse;
import io.heart.developer.gastomicroservice.exception.ResourceNotFoundException;
import io.heart.developer.gastomicroservice.mapper.PessoaMapper;
import io.heart.developer.gastomicroservice.repository.gasto.GastoEntity;
import io.heart.developer.gastomicroservice.repository.pessoa.PessoaEntity;
import io.heart.developer.gastomicroservice.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;

@Controller
@RequestMapping("/pessoa")
public class PessoaController implements Serializable {
    public static final long serialVersionUID = 1L;

    @Autowired
    private PessoaService pessoaService;

    @PostMapping("/")
    public ResponseEntity<PessoaEntity> criarPessoa(@RequestBody PessoaRequest pessoaRequest) {
        PessoaEntity pessoaEntity = PessoaMapper.toEntity(pessoaRequest);
        return ResponseEntity.ok(pessoaService.salvar(pessoaEntity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponse> buscarPorID(@PathVariable Integer id) throws ResourceNotFoundException {
        PessoaEntity pessoaEntity = pessoaService.buscarPorId(id);
        if (pessoaEntity == null)
            throw new ResourceNotFoundException();
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
