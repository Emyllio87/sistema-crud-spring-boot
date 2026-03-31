package com.sistemarh.sis_rh.service;

import com.sistemarh.sis_rh.model.Endereco;

import com.sistemarh.sis_rh.repository.EnderecoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    //metodo salvar
    public Endereco salvar (Endereco endereco){
        return enderecoRepository.save(endereco);
    }


    //metodo listar todos
    public List<Endereco> listarTodos(){
        return enderecoRepository.findAll();
    }

    //metodo listar por id
    public Optional<Endereco> listarPorId(Long id){
        return enderecoRepository.findById(id);
    }


    //metodo deletar por id
    public void deletar(Long id){
        enderecoRepository.deleteById(id);
    }


    //update

    public Endereco atualizar(Long id, Endereco dados){
        Endereco endereco = enderecoRepository.findById(id)
                .orElseThrow(()->new RuntimeException("endereço não encontrado"));

        if (dados.getLogradouro() != null) {
            endereco.setLogradouro(dados.getLogradouro());
        }

        if (dados.getNumero() != null) {
            endereco.setNumero(dados.getNumero());
        }

        if (dados.getBairro() != null) {
            endereco.setBairro(dados.getBairro());
        }

        if (dados.getCidade() != null) {
            endereco.setCidade(dados.getCidade());
        }

        if (dados.getCep() != null) {
            endereco.setCep(dados.getCep());
        }



        return enderecoRepository.save(endereco);
    }


}
