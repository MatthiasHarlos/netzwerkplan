package com.simaur.netzwerkplan;

import formularinputs.Knoten;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NetzwerkplanController {

    private List<Knoten> knotenliste = new ArrayList<>();

    @PostMapping("/changing")
    public String changing(Knoten knoten) {
        knoten.setVorgangsnummer(Integer.toString(knotenliste.size()+1));
        knotenliste.add(knoten);
        return "redirect:/startpage";
    }

    @GetMapping("startpage")
    private String startpage(Model model) {
        model.addAttribute("knoten", new Knoten());
        model.addAttribute("vorgangsnummer", knotenliste.size()+1);
        model.addAttribute("vorgaenger", knotenliste);
        model.addAttribute("geschrieben", knotenliste);

        return "userInput-template";
    }

}
