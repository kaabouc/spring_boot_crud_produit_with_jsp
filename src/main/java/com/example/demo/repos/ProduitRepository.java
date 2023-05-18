package com.example.demo.repos;

import com.example.demo.entite.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
