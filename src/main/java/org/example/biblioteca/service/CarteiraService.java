package org.example.biblioteca.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.biblioteca.DTO.CarteiraRequestDTO;
import org.example.biblioteca.DTO.CarteiraResponseDTO;
import org.example.biblioteca.entity.CarteiraB;
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
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(usuarioId);
        if (usuarioOpt.isEmpty()) {
            return "Usuário não encontrado!";
        }

        CarteiraB carteira = new CarteiraB();
        carteira.setDataEmis(dto.getDataEmis());
        carteira.setIsValid(dto.getIsValid());
        carteira.setUsuario(usuarioOpt.get());

        carteiraRepository.save(carteira);
        return new CarteiraResponseDTO(carteira);
    }
}