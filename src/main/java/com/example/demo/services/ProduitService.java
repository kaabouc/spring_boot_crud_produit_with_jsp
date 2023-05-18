package com.example.demo.services;

import com.example.demo.entite.Produit;

import java.util.List;

public interface ProduitService {

    Produit saveProduit(Produit p);

    Produit updateProduit(Produit p);
    void deleteProduit(Produit p);
    void deleteProduitById(Long id);
    Produit getProduit(Long id);
    List<Produit> getAllProduits();
}
