package br.com.filipe.conferidor_relatorios.dto;

import br.com.filipe.conferidor_relatorios.model.*;
import lombok.Data;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;


@Data
public class VendaDTO {

    private BigDecimal valorResquicio;
    private BigDecimal tarifaResquicio;
    private String id;

    @NotNull(message = "A modalidade é obrigatória")
    private Modalidade modalidade;

    @NotNull(message = "O tipo do jogo é obrigatório")
    private TipoJogo tipo;

    @NotNull(message = "O cenário é obrigatório")
    private Cenario cenario;

    @NotNull(message = "O valor é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false, message = "O valor deve ser maior que zero")
    private BigDecimal valor;

    @NotNull(message = "A tarifa é obrigatória")
    @DecimalMin(value = "0.0", message = "A tarifa não pode ser negativa")
    private BigDecimal tarifa;

    @NotNull(message = "O número de cotas é obrigatório")
    @Min(value = 1, message = "O número de cotas deve ser no mínimo 1")
    private Integer cotas;

    public BigDecimal getValorResquicio() {
        return valorResquicio;
    }

    public void setValorResquicio(BigDecimal valorResquicio) {
        this.valorResquicio = valorResquicio;
    }

    public BigDecimal getTarifaResquicio() {
        return tarifaResquicio;
    }

    public void setTarifaResquicio(BigDecimal tarifaResquicio) {
        this.tarifaResquicio = tarifaResquicio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Modalidade getModalidade() {
        return modalidade;
    }

    public void setModalidade(Modalidade modalidade) {
        this.modalidade = modalidade;
    }

    public TipoJogo getTipo() {
        return tipo;
    }

    public void setTipo(TipoJogo tipo) {
        this.tipo = tipo;
    }

    public Cenario getCenario() {
        return cenario;
    }

    public void setCenario(Cenario cenario) {
        this.cenario = cenario;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public BigDecimal getTarifa() {
        return tarifa;
    }

    public void setTarifa(BigDecimal tarifa) {
        this.tarifa = tarifa;
    }

    public Integer getCotas() {
        return cotas;
    }

    public void setCotas(Integer cotas) {
        this.cotas = cotas;
    }
}
