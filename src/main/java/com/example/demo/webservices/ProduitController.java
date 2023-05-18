package com.example.demo.webservices;//package com.example.demo.webservices;
//
//
//import com.example.demo.entite.Produit;
//import com.example.demo.services.ProduitService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@CrossOrigin
//public class ProduitController {
//
//    @PostMapping("/add")
//    public Produit saveProduit(@RequestBody Produit p) {
//        return produitService.saveProduit(p);
//    }
//
//    @PutMapping("/edit")
//    public Produit updateProduit(@RequestBody Produit p) {
//        return produitService.updateProduit(p);
//    }
//
//    @DeleteMapping("/delete")
//    public void deleteProduit(@RequestBody Produit p) {
//        produitService.deleteProduit(p);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void deleteProduitById(@PathVariable Long id) {
//        produitService.deleteProduitById(id);
//    }
//
//    @GetMapping("/produit/{id}")
//    public Produit getProduit(@PathVariable Long id) {
//        return produitService.getProduit(id);
//    }
//
//    @GetMapping("/list")
//    public List<Produit> getAllProduits() {
//        return produitService.getAllProduits();
//    }
//
//    @Autowired
//    private ProduitService produitService;
//}
//_________________________________________________ pas par web services ...>>>>>>>>>>>>>>>>>>>>

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.demo.entite.Produit;
import com.example.demo.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sun.xml.messaging.saaj.packaging.mime.internet.ParseException;

@Controller

public class ProduitController {


    @Autowired
    ProduitService produitService;

    @RequestMapping("/showCreate")
    public String showCreate()
    {
        return "createProduit";
    }



    @RequestMapping("/saveProduit")
    public String saveProduit(@ModelAttribute("produit") Produit produit,@RequestParam(value = "date" ,required=false)
            String date,ModelMap modelMap) throws ParseException, Exception
    {
        //conversion de la date

        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateformat.parse(String.valueOf(date));
        produit.setDateCreation(dateCreation);
        Produit saveProduit = produitService.saveProduit(produit);
        String msg ="produit enregistré avec Id "+saveProduit.getIdProduit();
        modelMap.addAttribute("msg", msg);
        return "createProduit";
    }


    @RequestMapping("/ListeProduits")
    public String listeProduits(ModelMap modelMap)
    {
        List<Produit> prods = produitService.getAllProduits();
        modelMap.addAttribute("produits", prods);
        return "listeProduits";
    }



    @RequestMapping("/supprimerProduit")
    public String supprimerProduit(@RequestParam("id") Long id,
                                   ModelMap modelMap)
    {
        produitService.deleteProduitById(id);
        List<Produit> prods = produitService.getAllProduits();
        modelMap.addAttribute("produits", prods);
        return "listeProduits";
    }
    @RequestMapping("/modifierProduit")
    public String editerProduit(@RequestParam("id") Long id,ModelMap modelMap)
    {
        Produit p= produitService.getProduit(id);
        modelMap.addAttribute("produit", p);
        return "editerProduits";
    }



    @RequestMapping("/updateProduit")
    public String updateProduit(@ModelAttribute("produit") Produit produit,
                                @RequestParam("date") String date, ModelMap modelMap) throws ParseException, Exception
    {
        //conversion de la date
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateformat.parse(String.valueOf(date));
        produit.setDateCreation(dateCreation);
        produitService.updateProduit(produit);
        List<Produit> prods = produitService.getAllProduits();
        modelMap.addAttribute("produits", prods);
        return "listeProduits";
    }
}
