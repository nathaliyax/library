package org.example.biblioteca.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarteiraB {

    private long numCarteira;
    private Date dataEmis;
    private Boolean isValid;

}
