package com.example.demo;

import com.example.demo.entite.Produit;
import com.example.demo.repos.ProduitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class ProduitApplicationTests {

    @Autowired
    private ProduitRepository produitRepository;
//    @Test
//    public void testCreateProduit() {
//
//        Produit prod = new Produit("PC",2200.500,new Date());
//        produitRepository.save(prod);}

    @Test
    public void testListerTousProduits()
    {
        List<Produit> prods = produitRepository.findAll();
        for (Produit p : prods)
        {
            System.out.println(p);
        }
    }

}
