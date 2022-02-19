package io.heart.developer.gastomicroservice.controller;

import io.heart.developer.gastomicroservice.dto.request.GastoRequest;
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

    @PostMapping("/{id}")
    public ResponseEntity<Integer> criarGasto(@PathVariable Integer id, @RequestBody GastoRequest gastoRequest) {
        PessoaEntity pessoaEntity = pessoaService.buscarPorId(id);
        GastoEntity gastoEntity = GastoMapper.toEntity(gastoRequest);
        gastoEntity.setPessoaEntity(pessoaEntity);
        GastoEntity gasto = new GastoEntity();
        gasto.setPessoaEntity(pessoaEntity);
        gastoService.salvarGasto(gasto);
        return ResponseEntity.ok(gastoService.salvarGasto(gasto).getId());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<GastoEntity>> buscarPorId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(gastoService.buscarPorID(id));
    }


}
