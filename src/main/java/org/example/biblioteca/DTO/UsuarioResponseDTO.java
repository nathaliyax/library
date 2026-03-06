package org.example.biblioteca.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.biblioteca.entity.Usuario;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioResponseDTO {

    private long id;
    private String nome;
    private String email;

    public UsuarioResponseDTO(Usuario usuario) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }
}
