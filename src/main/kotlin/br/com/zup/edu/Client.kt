package br.com.zup.edu

import io.grpc.ManagedChannelBuilder

fun main() {

    val channel = ManagedChannelBuilder
        .forAddress("localhost", 50051)
        .usePlaintext()
        .build()

    val request = FuncionarioRequest
        .newBuilder()
        .setNome("Leonardo")
        .setCpf("111.111.111-11")
        .setIdade(18)
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

    val client = FuncionarioServiceGrpc.newBlockingStub(channel)
    val response = client.cadastrar(request)

    println(response)
}