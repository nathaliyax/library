package org.example.biblioteca.entity;

import jakarta.persistence.*;
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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long numCarteira;
    private Date dataEmis;
    private Boolean isValid;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
