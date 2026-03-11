package org.example.biblioteca.DTO;
import lombok.Getter;
import org.example.biblioteca.entity.Emprestimo;
import java.time.LocalDate;

@Getter
public class EmprestimoResponseDTO {
    private long id;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public EmprestimoResponseDTO(Emprestimo emprestimo) {
        this.id = emprestimo.getId();
        this.dataEmprestimo = emprestimo.getDataEmprestimo();
        this.dataDevolucao = emprestimo.getDataDevolucao();
    }
}