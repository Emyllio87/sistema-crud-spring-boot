package com.sistemarh.sis_rh.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "funcionarios") //renomeia tabela
public class Funcionario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double salario;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(name = "data_admissao")
    private LocalDate dataAdmissao;




    // construtor vazio
    public Funcionario() {
    }


    //construtor com parametros


    public Funcionario(Long id, LocalDate dataAdmissao, String cpf, Double salario, String name) {
        this.id = id;
        this.dataAdmissao = dataAdmissao;
        this.cpf = cpf;
        this.salario = salario;
        this.name = name;
    }


    //getters e setters


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

//relacionamentos funcionario e departameto

    @ManyToOne //muitos funcionarios podem pertencer um mesmo departamento
    @JoinColumn(name = "departamento_id") //Cria uma coluna na tabela funcionarios chamada departamento_id, que vai guardar a referência para a tabela departamentos.
    private Departamento departamento; //Cria o atributo que será usado no Java para acessar o departamento do funcionário.



    //relacionamento funcionario e cargo
    @ManyToOne //Muitos funcionários podem ter o mesmo cargo
    @JoinColumn(name = "cargo_id") //Cria a coluna cargo_id no banco.
    private Cargo cargo; //Atributo para acessar o cargo do funcionário no Java.


    //relacionamento funcionario e endereço
    @OneToOne(cascade = CascadeType.ALL) //Cada funcionário possui um endereço único.
    //cascade = ALL significa que ao salvar um funcionário, o endereço será salvo automaticamente.
    @JoinColumn(name = "endereco_id", referencedColumnName = "id") // Cria coluna endereco_id na tabela funcionário, que referencia o id do endereço.
    private Endereco endereco; // Atributo para acessar o endereço do funcionário no Java.

    //getters e setters dos relacionamentos

        public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
