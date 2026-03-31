package com.sistemarh.sis_rh.controller;

import com.sistemarh.sis_rh.model.Cargo;

import com.sistemarh.sis_rh.service.CargoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/cargo")
public class CargoController {

    private final CargoService cargoService;

    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    @PostMapping
    public Cargo salvar(@RequestBody Cargo cargo){
        return cargoService.salvar(cargo);
    }

    @GetMapping
    public List<Cargo> listarTodos(){
        return cargoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Optional<Cargo> listarPorId(@PathVariable Long id){
        return cargoService.listarPorId(id);
    }


    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        cargoService.deletar(id);
    }


    //atualiza apenas dados parciais
    @PatchMapping("/{id}")
    public Cargo atualizar (@PathVariable  Long id, @RequestBody Cargo dados){
        return cargoService.atualizar(id, dados);
    }

}
