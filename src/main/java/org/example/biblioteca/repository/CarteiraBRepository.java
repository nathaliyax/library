package org.example.biblioteca.repository;
import org.example.biblioteca.entity.CarteiraBiblioteca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarteiraBRepository extends JpaRepository<CarteiraBiblioteca, Long> {}