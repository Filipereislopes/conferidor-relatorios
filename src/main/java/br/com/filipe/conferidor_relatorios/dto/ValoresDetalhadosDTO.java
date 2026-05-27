package br.com.filipe.conferidor_relatorios.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
public class ValoresDetalhadosDTO {
    private BigDecimal jogo = BigDecimal.ZERO;
    private BigDecimal tarifa = BigDecimal.ZERO;

    public ValoresDetalhadosDTO() {
    }

    public ValoresDetalhadosDTO(BigDecimal jogo, BigDecimal tarifa) {
        this.jogo = jogo;
        this.tarifa = tarifa;
    }

    public BigDecimal getJogo() {
        return jogo;
    }

    public void setJogo(BigDecimal jogo) {
        this.jogo = jogo;
    }

    public BigDecimal getTarifa() {
        return tarifa;
    }

    public void setTarifa(BigDecimal tarifa) {
        this.tarifa = tarifa;
    }
}
