package io.heart.developer.gastomicroservice.controller;

import io.heart.developer.gastomicroservice.dto.request.GastoRequest;
import io.heart.developer.gastomicroservice.dto.response.GastoResponse;
import io.heart.developer.gastomicroservice.mapper.GastoMapper;
import io.heart.developer.gastomicroservice.repository.gasto.GastoEntity;
import io.heart.developer.gastomicroservice.repository.pessoa.PessoaEntity;
import io.heart.developer.gastomicroservice.service.GastoService;
import io.heart.developer.gastomicroservice.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@Controller
@RequestMapping("/gasto")
public class GastoController implements Serializable {
    public static final long serialVersionUID = 1L;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private GastoService gastoService;

    @PostMapping()
    public ResponseEntity<Integer> criarGasto(@RequestBody GastoRequest gastoRequest) {
        PessoaEntity pessoaEntity = pessoaService.buscarPorId(gastoRequest.getId());
        GastoEntity gastoEntity = GastoMapper.toEntity(gastoRequest,  pessoaEntity);
        gastoService.salvarGasto(gastoEntity);
        return ResponseEntity.ok(gastoService.salvarGasto(gastoEntity).getId());
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<List<GastoResponse>> listarGastos(@PathVariable("id") Integer id) {
        List<GastoEntity> gastoEntities = gastoService.buscarGastosPorPessoa(id);
        List<GastoResponse> gastoResponseList = GastoMapper.toResponseList(gastoEntities);
        return ResponseEntity.ok(gastoResponseList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GastoResponse> buscarPorId(@PathVariable("id") Integer id) {
        GastoEntity gastoEntity = gastoService.buscarGastoPorID(id);
        GastoResponse gastoResponse = GastoMapper.toResponse(gastoEntity);
        return ResponseEntity.ok(gastoResponse);
    }


}
