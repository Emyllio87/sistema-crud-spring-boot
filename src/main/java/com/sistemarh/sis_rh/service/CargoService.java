package com.sistemarh.sis_rh.service;

import com.sistemarh.sis_rh.model.Cargo;

import com.sistemarh.sis_rh.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargoService {

    private final CargoRepository cargoRepository;

    public CargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    //salvar
    public Cargo salvar(Cargo cargo){
        return cargoRepository.save(cargo);

    }

    //listar todos
    public List<Cargo> listarTodos(){
        return cargoRepository.findAll();
    }


    //listar por Id
    public Optional<Cargo> listarPorId(Long id){
        return cargoRepository.findById(id);
    }


    //deletar por id
    public void deletar(Long id){
        cargoRepository.deleteById(id);
    }



    //update

    public Cargo atualizar(Long id, Cargo dados){
        Cargo cargo = cargoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("cargo não encontrado"));

        if (dados.getNome() != null) {
            cargo.setNome(dados.getNome());
        }

        if (dados.getSalarioBase() != null) {
            cargo.setSalarioBase(dados.getSalarioBase());
        }

        return cargoRepository.save(cargo);
    }




}
