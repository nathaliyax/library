package org.example.biblioteca.controller;

import org.example.biblioteca.DTO.EmprestimoRequestDTO;
import org.example.biblioteca.service.EmprestimoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private final EmprestimoService emprestimoService;

    public EmprestimoController(EmprestimoService emprestimoService) {
        this.emprestimoService = emprestimoService;
    }

    @PostMapping("/usuario/{usuarioId}")
    public ResponseEntity<?> criarEmprestimo(@PathVariable long usuarioId, @RequestBody EmprestimoRequestDTO emprestimo) {
        return ResponseEntity.ok(emprestimoService.criarEmprestimo(usuarioId, emprestimo));
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<?> listarPorUsuario(@PathVariable long usuarioId) {
        return ResponseEntity.ok(emprestimoService.listarPorUsuario(usuarioId));
    }

    @GetMapping
    public ResponseEntity<?> listarTodos() {
        return ResponseEntity.ok(emprestimoService.listarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarEmprestimo(@PathVariable long id, @RequestBody EmprestimoRequestDTO emprestimo) {
        return ResponseEntity.ok(emprestimoService.atualizarEmprestimo(id, emprestimo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarEmprestimo(@PathVariable long id) {
        return ResponseEntity.ok(emprestimoService.deletarEmprestimo(id));
    }
}