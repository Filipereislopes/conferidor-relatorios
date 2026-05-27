package br.com.filipe.conferidor_relatorios;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConferidorRelatoriosApplication {

    public static void main(String[] args) {
        // Este comando inicia o Spring Boot e o servidor na porta 8080
        SpringApplication.run(ConferidorRelatoriosApplication.class, args);

        System.out.println("=========================================");
        System.out.println("SISTEMA DE CONFERENCIA LOTERICA INICIADO");
        System.out.println("=========================================");
    }
}
