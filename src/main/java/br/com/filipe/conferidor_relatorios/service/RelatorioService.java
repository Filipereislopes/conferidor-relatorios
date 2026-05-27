package br.com.filipe.conferidor_relatorios.service;

import br.com.filipe.conferidor_relatorios.dto.ResumoDTO;
import br.com.filipe.conferidor_relatorios.dto.ValoresDetalhadosDTO;
import br.com.filipe.conferidor_relatorios.dto.VendaDTO;
import br.com.filipe.conferidor_relatorios.model.Modalidade;
import br.com.filipe.conferidor_relatorios.model.TipoJogo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RelatorioService {

    private final List<VendaDTO> vendas = new ArrayList<>();

    public void adicionar(VendaDTO venda) {
        if (venda.getTarifa() == null) venda.setTarifa(BigDecimal.ZERO);
        if (venda.getValor() == null) venda.setValor(BigDecimal.ZERO);
        if (venda.getValorResquicio() == null) venda.setValorResquicio(BigDecimal.ZERO);
        if (venda.getTarifaResquicio() == null) venda.setTarifaResquicio(BigDecimal.ZERO);
        if (venda.getCotas() == null || venda.getCotas() <= 0) venda.setCotas(1);

        vendas.add(venda);
    }

    public ResumoDTO calcularResumo() {
        ResumoDTO resumo = new ResumoDTO();
        Map<Modalidade, ValoresDetalhadosDTO> mapSimples = new HashMap<>();
        Map<Modalidade, ValoresDetalhadosDTO> mapBolao = new HashMap<>();

        for (VendaDTO v : vendas) {
            BigDecimal valorPuroTotal = v.getValor().multiply(new BigDecimal(v.getCotas())).add(v.getValorResquicio());
            BigDecimal tarifaTotal = v.getTarifa().multiply(new BigDecimal(v.getCotas())).add(v.getTarifaResquicio());
            BigDecimal totalLinha = valorPuroTotal.add(tarifaTotal);

            if (v.getTipo() == TipoJogo.SIMPLES) {
                resumo.setTotalSimples(resumo.getTotalSimples().add(totalLinha));
                acumular(mapSimples, v.getModalidade(), valorPuroTotal, tarifaTotal);
            } else {
                resumo.setTotalBolao(resumo.getTotalBolao().add(totalLinha));
                acumular(mapBolao, v.getModalidade(), valorPuroTotal, tarifaTotal);
            }
            resumo.setTotalGeral(resumo.getTotalGeral().add(totalLinha));
        }

        resumo.setSimplesPorModalidade(mapSimples);
        resumo.setBolaoPorModalidade(mapBolao);
        return resumo;
    }

    private void acumular(Map<Modalidade, ValoresDetalhadosDTO> map, Modalidade mod, BigDecimal jogo, BigDecimal tarifa) {
        ValoresDetalhadosDTO atual = map.getOrDefault(mod, new ValoresDetalhadosDTO(BigDecimal.ZERO, BigDecimal.ZERO));
        atual.setJogo(atual.getJogo().add(jogo));
        atual.setTarifa(atual.getTarifa().add(tarifa));
        map.put(mod, atual);
    }

    public ResumoDTO remover(String id) {
        vendas.removeIf(v -> v.getId() != null && v.getId().equals(id));
        return calcularResumo();
    }

    public void limpar() {
        vendas.clear();
    }
}
