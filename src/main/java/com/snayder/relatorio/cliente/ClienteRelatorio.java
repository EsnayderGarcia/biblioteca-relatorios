package com.snayder.relatorio.cliente;

import com.snayder.relatorio.util.RelatorioUtil;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class  ClienteRelatorio {
    private static final String CAMINHO_RELATORIO_CLIENTES = "/relatorio/cliente/relatorioClientes.jrxml";

    public static byte[] gerarRelatorioClientes(InformacoesRelatorioClienteDto informacoesRelatorioClienteDto) {
        InputStream stream = ClienteRelatorio.class.getResourceAsStream(CAMINHO_RELATORIO_CLIENTES);

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("dataEmissao", new Date());

        return RelatorioUtil.gerarRelatorio(stream, parametros, informacoesRelatorioClienteDto.clientes());
    }
}
