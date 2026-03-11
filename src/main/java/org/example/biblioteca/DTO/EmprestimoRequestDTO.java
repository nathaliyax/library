package org.example.biblioteca.DTO;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class EmprestimoRequestDTO {
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
}