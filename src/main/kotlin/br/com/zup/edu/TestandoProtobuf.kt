package br.com.zup.edu

import java.io.FileInputStream
import java.io.FileOutputStream

fun main() {

    val request = FuncionarioRequest
        .newBuilder()
        .setNome("Leonardo")
        .setCpf("111.111.111-11")
        .setSalario(3000.00)
        .setAtivo(true)
        .setCargo(Cargo.DEV)
        .addEnderecos(FuncionarioRequest.Endereco
            .newBuilder()
            .setLogradouro("Avenida Pompeia")
            .setCep("00000-000")
            .setComplemento("Apto 15")
            .build())
        .build()

    println(request)

    //Escrevemos o objeto - serializamos
    request.writeTo(FileOutputStream("funcionario-request.bin"))

    //Lemos o objeto - deserializamos
    val response = FuncionarioRequest
        .newBuilder()
        .mergeFrom(FileInputStream("funcionario-request.bin"))

    response.setCargo(Cargo.GERENTE)
    response.setSalario(7500.00)
    response.build()

    println(response)

}