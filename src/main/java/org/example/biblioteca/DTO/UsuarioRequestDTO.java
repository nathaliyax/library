package org.example.biblioteca.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.biblioteca.entity.Usuario;

import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequestDTO {
    private String nome;
    private String email;


    public UsuarioRequestDTO(Usuario usuario) {
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
    }
}
