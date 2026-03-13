package org.example.biblioteca.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CarteiraRequestDTO {
    private Date dataEmissao;
    private Boolean isValid;
}
