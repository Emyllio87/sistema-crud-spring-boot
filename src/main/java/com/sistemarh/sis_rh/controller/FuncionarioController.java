package com.sistemarh.sis_rh.controller;


import com.sistemarh.sis_rh.model.Funcionario;
import com.sistemarh.sis_rh.service.FuncionarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@RestController
@RequestMapping(path = "/funcionario")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }



    @GetMapping
    public List<Funcionario> listarTodos(){
        return funcionarioService.listarTodos();
    }

    @PostMapping
    public Funcionario salvar(@RequestBody Funcionario funcionario){
        return funcionarioService.salvar(funcionario);
    }
    @GetMapping("/{id}")
    public Optional<Funcionario> listarPorId(@PathVariable  Long id ){
        return funcionarioService.listarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        funcionarioService.deletar(id);
    }

    //atualiza apenas dados parciais
    @PatchMapping("/{id}")
    public Funcionario atualizar (@PathVariable  Long id, @RequestBody Funcionario dados){
        return funcionarioService.atualizar(id, dados);
    }

}
