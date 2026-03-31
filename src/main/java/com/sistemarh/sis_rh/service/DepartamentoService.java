package com.sistemarh.sis_rh.service;


import com.sistemarh.sis_rh.model.Departamento;
import com.sistemarh.sis_rh.repository.DepartametoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    private final DepartametoRepository departametoRepository;

    public DepartamentoService(DepartametoRepository departametoRepository) {
        this.departametoRepository = departametoRepository;
    }

    public Departamento salvar(Departamento departamento){
        return departametoRepository.save(departamento);
    }

    public List<Departamento> listarTodos(){
        return departametoRepository.findAll();
    }

    public Optional<Departamento> listarPorId(Long id){
        return departametoRepository.findById(id);
    }

    public void deletar(Long id){
        departametoRepository.deleteById(id);
    }

    //update

    public Departamento atualizar(Long id, Departamento dados){
        Departamento departamento = departametoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("cargo não encontrado"));

        if (dados.getName() != null) {
            departamento.setName(dados.getName());
        }

        return departametoRepository.save(departamento);
    }
}
