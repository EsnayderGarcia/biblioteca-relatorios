package com.snayder.relatorio.cliente;

import com.snayder.relatorio.emprego.EmpregoRelatorioDto;

import java.util.List;

public record InformacoesRelatorioDetalhesCliente(
        ClienteRelatorioDto clienteRelatorioDto,
        List<EmpregoRelatorioDto> empregos
) {}
