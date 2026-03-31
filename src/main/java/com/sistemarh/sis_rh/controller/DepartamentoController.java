package com.sistemarh.sis_rh.controller;


import com.sistemarh.sis_rh.model.Departamento;
import com.sistemarh.sis_rh.service.DepartamentoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/departamento")
public class DepartamentoController {

    private final DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @PostMapping
    public Departamento salvar(@RequestBody  Departamento departamento){
        return departamentoService.salvar(departamento);
    }

    @GetMapping
    public List<Departamento> listarTodos(){
        return departamentoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Departamento> listarPorId(@PathVariable Long id){
        return departamentoService.listarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        departamentoService.deletar(id);
    }

    //atualiza apenas dados parciais
    @PatchMapping("/{id}")
    public Departamento atualizar (@PathVariable  Long id, @RequestBody Departamento dados){
        return departamentoService.atualizar(id, dados);
    }
}
