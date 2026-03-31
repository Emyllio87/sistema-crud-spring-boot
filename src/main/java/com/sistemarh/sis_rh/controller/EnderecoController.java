package com.sistemarh.sis_rh.controller;

import com.sistemarh.sis_rh.model.Endereco;

import com.sistemarh.sis_rh.service.EnderecoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/endereco")
public class EnderecoController {
    private final EnderecoService enderecoService;

    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    @PostMapping
    public Endereco salvar(@RequestBody Endereco endereco){
        return enderecoService.salvar(endereco);
    }

    @GetMapping
    public List<Endereco> listarTodos(){
        return enderecoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Endereco> listarPorId(@PathVariable Long id){
        return enderecoService.listarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        enderecoService.deletar(id);
    }

    //atualiza apenas dados parciais
    @PatchMapping("/{id}")
    public Endereco atualizar (@PathVariable  Long id, @RequestBody Endereco dados){
        return enderecoService.atualizar(id, dados);
    }
}
