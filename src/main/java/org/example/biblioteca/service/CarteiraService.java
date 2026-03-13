package org.example.biblioteca.service;

import org.example.biblioteca.DTO.CarteiraRequestDTO;
import org.example.biblioteca.DTO.CarteiraResponseDTO;
import org.example.biblioteca.entity.CarteiraBiblioteca;
import org.example.biblioteca.entity.Usuario;
import org.example.biblioteca.repository.CarteiraBRepository;
import org.example.biblioteca.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CarteiraService {

    private final CarteiraBRepository carteiraRepository;
    private final UsuarioRepository usuarioRepository;

    public CarteiraService(CarteiraBRepository carteiraRepository, UsuarioRepository usuarioRepository) {
        this.carteiraRepository = carteiraRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Object criarCarteira(long usuarioId, CarteiraRequestDTO dto) {
        Optional<Usuario> usuariopt = usuarioRepository.findById(usuarioId);
        if (usuariopt.isEmpty()) {
            return "Usuário não encontrado!";
        }

        CarteiraBiblioteca carteira = new CarteiraBiblioteca();
        carteira.setDataEmissao(dto.getDataEmissao());
        carteira.setIsValid(dto.getIsValid());
        carteira.setUsuario(usuariopt.get());

        carteiraRepository.save(carteira);
        return new CarteiraResponseDTO(carteira);
    }
}