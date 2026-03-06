package org.example.biblioteca.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmprestimoRequestDTO {

    private Date dataEmprestimo;
    private Date dataDevolucao;

    public EmprestimoRequestDTO(Date dataEmprestimo, Date dataDevolucao) {
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }
}
