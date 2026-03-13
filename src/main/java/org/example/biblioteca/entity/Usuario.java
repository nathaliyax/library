package org.example.biblioteca.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private String nome;
    @NotNull
    private String email;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private CarteiraBiblioteca carteira;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<Emprestimo> emprestimos;

    public Usuario(org.example.biblioteca.DTO.UsuarioRequestDTO dto) {
        this.nome = dto.getNome();
        this.email = dto.getEmail();
    }
}
