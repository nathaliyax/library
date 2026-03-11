package org.example.biblioteca.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nome;
    private String email;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private CarteiraB carteira;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Emprestimo> emprestimos;

    public Usuario(org.example.biblioteca.DTO.UsuarioRequestDTO dto) {
        this.nome = dto.getNome();
        this.email = dto.getEmail();
    }
}
