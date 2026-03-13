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
public class CarteiraBiblioteca {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long numeroCarteira;
    private Date dataEmissao;
    private Boolean isValid;

    @OneToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
}
