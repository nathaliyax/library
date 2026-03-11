package org.example.biblioteca.service;

import org.example.biblioteca.DTO.EmprestimoRequestDTO;
import org.example.biblioteca.DTO.EmprestimoResponseDTO;
import org.example.biblioteca.entity.Emprestimo;
import org.example.biblioteca.entity.Usuario;
import org.example.biblioteca.repository.EmprestimoRepository;
import org.example.biblioteca.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    private final EmprestimoRepository emprestimoRepository;
    private final UsuarioRepository usuarioRepository;

    public EmprestimoService(EmprestimoRepository emprestimoRepository, UsuarioRepository usuarioRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Object criarEmprestimo(long usuarioId, EmprestimoRequestDTO dto) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(usuarioId);
        if (usuarioOpt.isEmpty()) return "Usuário não encontrado!";

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setDataEmprestimo(dto.getDataEmprestimo());
        emprestimo.setDataDevolucao(dto.getDataDevolucao());
        emprestimo.setUsuario(usuarioOpt.get());

        emprestimoRepository.save(emprestimo);
        return new EmprestimoResponseDTO(emprestimo);
    }

    public List<EmprestimoResponseDTO> listarPorUsuario(long usuarioId) {
        return emprestimoRepository.findByUsuarioId(usuarioId).stream()
                .map(EmprestimoResponseDTO::new).toList();
    }

    public List<EmprestimoResponseDTO> listarTodos() {
        return emprestimoRepository.findAll().stream()
                .map(EmprestimoResponseDTO::new).toList();
    }

    public Object atualizarEmprestimo(long id, EmprestimoRequestDTO dto) {
        Optional<Emprestimo> empOpt = emprestimoRepository.findById(id);
        if (empOpt.isEmpty()) return "Empréstimo não encontrado!";

        Emprestimo emprestimo = empOpt.get();
        emprestimo.setDataEmprestimo(dto.getDataEmprestimo());
        emprestimo.setDataDevolucao(dto.getDataDevolucao());

        emprestimoRepository.save(emprestimo);
        return new EmprestimoResponseDTO(emprestimo);
    }

    public String deletarEmprestimo(long id) {
        if (!emprestimoRepository.existsById(id)) return "Empréstimo não encontrado!";
        emprestimoRepository.deleteById(id);
        return "Empréstimo deletado com sucesso!";
    }
}