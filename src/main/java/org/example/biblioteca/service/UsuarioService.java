package org.example.biblioteca.service;

import org.example.biblioteca.DTO.UsuarioRequestDTO;
import org.example.biblioteca.DTO.UsuarioResponseDTO;
import org.example.biblioteca.entity.Usuario;
import org.example.biblioteca.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public String saveUser(UsuarioRequestDTO user){
        Usuario usuario = new Usuario(user);
        usuarioRepository.save(usuario);
        return "Usuario salvo com sucesso";
    }

    public List<UsuarioResponseDTO> listUsers(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        List<UsuarioResponseDTO> usuariosDTO = usuarios.stream()
                .map(usuario -> new UsuarioResponseDTO(usuario))
                .toList();
        return usuariosDTO;
    }

    public String deleteUser(long id){
        if (!usuarioRepository.existsById(id)) {
            return "Usuario nao encontrado";
        } else {
            usuarioRepository.deleteById(id);
            return "Usuario deletado com sucesso";
        }
    }

    public UsuarioResponseDTO searchUser(long id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isEmpty()) {
            return null;
        }
        return new UsuarioResponseDTO(usuario.get());
    }

    public String updateUser(long id, UsuarioRequestDTO user) {
        if (!usuarioRepository.existsById(id)) {
            return "Usuario nao encontrado";
        } else {
            Usuario updateUser = usuarioRepository.findById(id).get();
            updateUser.setNome(user.getNome());
            updateUser.setEmail(user.getEmail());
            usuarioRepository.save(updateUser);
            return "Usuario atualizado com sucesso";
        }
    }
}