package org.example.biblioteca.controller;

import org.example.biblioteca.DTO.CarteiraRequestDTO;
import org.example.biblioteca.service.CarteiraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carteiras")
public class CarteiraController {

    private final CarteiraService carteiraService;

    public CarteiraController(CarteiraService carteiraService) {
        this.carteiraService = carteiraService;
    }

    @PostMapping("/usuario/{usuarioId}")
    public ResponseEntity<?> criarCarteira(@PathVariable long usuarioId, @RequestBody CarteiraRequestDTO carteira) {
        return ResponseEntity.ok(carteiraService.criarCarteira(usuarioId, carteira));
    }
}