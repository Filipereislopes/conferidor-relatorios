package br.com.filipe.conferidor_relatorios.controller;

import br.com.filipe.conferidor_relatorios.dto.ResumoDTO;
import br.com.filipe.conferidor_relatorios.dto.VendaDTO;
import br.com.filipe.conferidor_relatorios.service.RelatorioService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/vendas")
@CrossOrigin(origins = "*") // Revertido para permitir o front-end local sem bloqueios
public class RelatorioController {

    private final RelatorioService service;

    public RelatorioController(RelatorioService service) {
        this.service = service;
    }

    @PostMapping
    public ResumoDTO adicionar(@Valid @RequestBody VendaDTO venda) {
        service.adicionar(venda);
        return service.calcularResumo();
    }

    @DeleteMapping("/{id}")
    public ResumoDTO remover(@PathVariable String id) {
        return service.remover(id);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void resetar() {
        service.limpar();
    }
}
