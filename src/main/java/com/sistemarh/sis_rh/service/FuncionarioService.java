package com.sistemarh.sis_rh.service;

import com.sistemarh.sis_rh.model.Funcionario;
import com.sistemarh.sis_rh.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> listarTodos() {
        return funcionarioRepository.findAll();
    }

    public Funcionario salvar(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }

    public Optional<Funcionario> listarPorId(Long id){
        return funcionarioRepository.findById(id);
    }

    public void deletar(Long id){
        funcionarioRepository.deleteById(id);
    }

    //update

    public Funcionario atualizar( Long id, Funcionario dados){
        Funcionario funcionario = funcionarioRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Funcionario não encontrado"));

        if (dados.getName() != null) {
            funcionario.setName(dados.getName());
        }

        if (dados.getSalario() != null) {
            funcionario.setSalario(dados.getSalario());
        }

        if (dados.getCpf() != null) {
            funcionario.setCpf(dados.getCpf());
        }

        if (dados.getDataAdmissao() != null) {
            funcionario.setDataAdmissao(dados.getDataAdmissao());
        }

        // 🔹 Relacionamentos
        if (dados.getDepartamento() != null) {
            funcionario.setDepartamento(dados.getDepartamento());
        }

        if (dados.getCargo() != null) {
            funcionario.setCargo(dados.getCargo());
        }

        if (dados.getEndereco() != null) {
            funcionario.setEndereco(dados.getEndereco());
        }

        return funcionarioRepository.save(funcionario);
    }




}


