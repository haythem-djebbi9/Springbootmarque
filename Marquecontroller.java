package com.example.Finale.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Finale.entities.Marque;
import com.example.Finale.service.MarqueService;

@Controller
public class Marquecontroller {

    @Autowired
    private MarqueService marqueService;

    @RequestMapping("/showCreate")
    public String showCreate() {
        return "createMarque";
    }

    @RequestMapping("/saveMarque")
    public String saveMarque(@ModelAttribute("marque") Marque marque, ModelMap modelMap) {
        Marque saveMarque = marqueService.saveMarque(marque);
        String msg = "Marque enregistrée avec l'identifiant " + saveMarque.getNomMarque();
        modelMap.addAttribute("msg", msg);
        return "createMarque";
    }
    @RequestMapping("/ListeMarques")
    public String listeMarques(ModelMap modelMap) {
        List<Marque> marques = marqueService.getAllMarques();
        modelMap.addAttribute("marques", marques);
        return "listeMarques";
    }
    @RequestMapping("/supprimerMarque")
    public String supprimerMarque(@RequestParam("id") Long id,
     ModelMap modelMap)
    { 
    marqueService.deleteMarqueById(id);
    List<Marque> marques = marqueService.getAllMarques();
    modelMap.addAttribute("marques", marques);
    return "listeMarques";
    }
    @RequestMapping("/modifierMarque")
    public String editerMarque(@RequestParam("id") Long id, ModelMap modelMap) {
        Marque m = marqueService.getMarque(id);
        modelMap.addAttribute("marque", m);
        return "editerMarque";
    }

    @RequestMapping("/updateMarque")
    public String updateMarque(@ModelAttribute("marque") Marque marque,
                                ModelMap modelMap) {
        marqueService.updateMarque(marque);
        List<Marque> marques = marqueService.getAllMarques();
        modelMap.addAttribute("marques", marques);
        return "listeMarques";
    }
    @RequestMapping("/ListeMarques")
    public String listeMarques(ModelMap modelMap,
    @RequestParam (name="page",defaultValue = "0") int page,
    @RequestParam (name="size", defaultValue = "2") int size)
    {
    Page<Marque> marques = marqueService.getAllMarquesParPage(page, size);
    modelMap.addAttribute("marques", marques);
    modelMap.addAttribute("pages", new int[marques.getTotalPages()]);
    modelMap.addAttribute("currentPage", page);
    return "listeMarques";
    }

}