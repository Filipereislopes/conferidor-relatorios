package br.com.filipe.conferidor_relatorios.dto;

import br.com.filipe.conferidor_relatorios.model.Modalidade;
import lombok.Data;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Data
public class ResumoDTO {
    private BigDecimal totalSimples = BigDecimal.ZERO;
    private BigDecimal totalBolao = BigDecimal.ZERO;
    private BigDecimal totalGeral = BigDecimal.ZERO;

    private Map<Modalidade, ValoresDetalhadosDTO> simplesPorModalidade = new HashMap<>();
    private Map<Modalidade, ValoresDetalhadosDTO> bolaoPorModalidade = new HashMap<>();

    public BigDecimal getTotalSimples() {
        return totalSimples;
    }

    public void setTotalSimples(BigDecimal totalSimples) {
        this.totalSimples = totalSimples;
    }

    public BigDecimal getTotalBolao() {
        return totalBolao;
    }

    public void setTotalBolao(BigDecimal totalBolao) {
        this.totalBolao = totalBolao;
    }

    public BigDecimal getTotalGeral() {
        return totalGeral;
    }

    public void setTotalGeral(BigDecimal totalGeral) {
        this.totalGeral = totalGeral;
    }

    public Map<Modalidade, ValoresDetalhadosDTO> getSimplesPorModalidade() {
        return simplesPorModalidade;
    }

    public void setSimplesPorModalidade(Map<Modalidade, ValoresDetalhadosDTO> simplesPorModalidade) {
        this.simplesPorModalidade = simplesPorModalidade;
    }

    public Map<Modalidade, ValoresDetalhadosDTO> getBolaoPorModalidade() {
        return bolaoPorModalidade;
    }

    public void setBolaoPorModalidade(Map<Modalidade, ValoresDetalhadosDTO> bolaoPorModalidade) {
        this.bolaoPorModalidade = bolaoPorModalidade;
    }
}
