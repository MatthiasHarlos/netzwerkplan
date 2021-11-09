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
    @PostMapping("/result")
    public String result(Knoten knoten) {
        for (int i = (knotenliste.size()-1); i >= 0; i--) {
            int vorgaengereins;
            int vorgaengerzwei;
            int vorgaengerdrei;
            String nachfolgerfuerVorgaenger = knotenliste.get(i).getVorgangsnummer();
            if (!knotenliste.get(i).getVorgaengerEins().equals("-")) {
                vorgaengereins = Integer.parseInt(knotenliste.get(i).getVorgaengerEins()) - 1;
                String nachfolgerEins = knotenliste.get(vorgaengereins).getNachfolger();
                nachfolgerEins += nachfolgerfuerVorgaenger + ", ";
                knotenliste.get(vorgaengereins).setNachfolger(nachfolgerEins);
            }
            if (!knotenliste.get(i).getVorgaengerZwei().equals("-")) {
                vorgaengerzwei = Integer.parseInt(knotenliste.get(i).getVorgaengerZwei()) - 1;
                String nachfolgerZwei = knotenliste.get(vorgaengerzwei).getNachfolger();
                nachfolgerZwei += nachfolgerfuerVorgaenger + ", ";
                knotenliste.get(vorgaengerzwei).setNachfolger(nachfolgerZwei);
            }
            if (!knotenliste.get(i).getVorgaengerDrei().equals("-")) {
                vorgaengerdrei = Integer.parseInt(knotenliste.get(i).getVorgaengerDrei()) - 1;
                String nachfolgerDrei = knotenliste.get(vorgaengerdrei).getNachfolger();
                nachfolgerDrei += nachfolgerfuerVorgaenger + ", ";
                knotenliste.get(vorgaengerdrei).setNachfolger(nachfolgerDrei);
            }
            System.out.println(knotenliste.get(i).toString());
        }
        return "result-template";
    }

    @PostMapping("/deleteOne")
    public String deleting(Knoten knoten) {
        knotenliste.remove(knotenliste.size()-1);
        return "redirect:/startpage";
    }

    @PostMapping("/deleteAll")
    public String deletingAll(Knoten knoten) {
        knotenliste = new ArrayList<>();
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
