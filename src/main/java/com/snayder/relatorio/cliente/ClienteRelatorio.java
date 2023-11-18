package com.snayder.relatorio.cliente;

import com.snayder.relatorio.util.RelatorioUtil;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ClienteRelatorio {
    private static final String CAMINHO_RELATORIO_CLIENTES = "/relatorio/cliente/relatorioClientes.jrxml";
    private static final String CAMINHO_RELATORIO_DETALHES_CLIENTES = "/relatorio/cliente/relatorioDetalhesCliente.jrxml";

    public static byte[] gerarPdfRelatorioClientes(InformacoesRelatorioCliente informacoesRelatorioCliente) {
        InputStream stream = ClienteRelatorio.class.getResourceAsStream(CAMINHO_RELATORIO_CLIENTES);

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("dataEmissao", new Date());

        return RelatorioUtil.gerarRelatorio(stream, parametros, informacoesRelatorioCliente.clientes());
    }

    public static byte[] gerarPdfRelatorioDetalhesCliente(InformacoesRelatorioDetalhesCliente informacoesRelatorioDetalhesCliente) {
        InputStream stream = ClienteRelatorio.class.getResourceAsStream(CAMINHO_RELATORIO_DETALHES_CLIENTES);

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("dataEmissao", new Date());
        parametros.put("nome", informacoesRelatorioDetalhesCliente.clienteRelatorioDto().getNome());
        parametros.put("cpf", informacoesRelatorioDetalhesCliente.clienteRelatorioDto().getCpf());
        parametros.put("dataNascimento", informacoesRelatorioDetalhesCliente.clienteRelatorioDto().getDataNascimento());

        return RelatorioUtil.gerarRelatorio(stream, parametros, informacoesRelatorioDetalhesCliente.empregos());
    }
}
