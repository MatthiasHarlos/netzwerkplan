package com.simaur.netzwerkplan;

import forms.Beans;
import forms.Knots;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NetzwerkplanController {

    private List<Beans> beansliste = new ArrayList<>();

    @PostMapping("/changing")
    public String changing(Beans beans) {
        beans.setVorgangsnummer(beansliste.size()+1);
        beansliste.add(beans);
        return "redirect:/startpage";
    }

    @GetMapping("/result")
    public String result(Model model) {
        List<Knots> knotenliste = calculateBeansToKnots(beansliste);
        model.addAttribute("knotenliste", knotenliste);
        return "result-template";
    }

    private List<Knots> calculateBeansToKnots(List<Beans> beanslist) {
        List<Knots> result = new ArrayList<>();
        for (Beans bean : beanslist) {
            result.add(new Knots(bean.getVorgangsnummer(),bean.getInputVorgangsbezeichnung(),bean.getInputDauer()));
        }
        result = getVorgaenger(result);
        result = kalkuliereNachfolger(result);
        return result;
    }

    private List<Knots> kalkuliereNachfolger(List<Knots> knotenlist) {
        for (int i = (beansliste.size()-1); i >= 0; i--) {
            int vorgaengereins;
            int vorgaengerzwei;
            int vorgaengerdrei;
            int nachfolgerfuerVorgaenger = beansliste.get(i).getVorgangsnummer();
            if (beansliste.get(i).getVorgaengerEins() != null) {
                vorgaengereins = beansliste.get(i).getVorgaengerEins() - 1;
                knotenlist.get(vorgaengereins).getNachfolger().add(knotenlist.get(nachfolgerfuerVorgaenger-1));
            }
            if (beansliste.get(i).getVorgaengerZwei() != null) {
                vorgaengerzwei = beansliste.get(i).getVorgaengerZwei() - 1;
                knotenlist.get(vorgaengerzwei).getNachfolger().add(knotenlist.get(nachfolgerfuerVorgaenger-1));
            }
            if (beansliste.get(i).getVorgaengerDrei() != null) {
                vorgaengerdrei =beansliste.get(i).getVorgaengerDrei() - 1;
                knotenlist.get(vorgaengerdrei).getNachfolger().add(knotenlist.get(nachfolgerfuerVorgaenger-1));
            }
            System.out.println(beansliste.get(i).toString());
        }
        return knotenlist;
    }

    private List<Knots> getVorgaenger(List<Knots> knotenlist) {
        for (int i = 0; i< beansliste.size(); i++ ) {
            if (beansliste.get(i).getVorgaengerEins() != null) {
                knotenlist.get(i).getVorgaenger().add(knotenlist.get(beansliste.get(i).getVorgaengerEins() - 1));
            }
            if (beansliste.get(i).getVorgaengerZwei() != null) {
                knotenlist.get(i).getVorgaenger().add(knotenlist.get(beansliste.get(i).getVorgaengerZwei() - 1));
            }
            if (beansliste.get(i).getVorgaengerDrei() != null) {
                knotenlist.get(i).getVorgaenger().add(knotenlist.get(beansliste.get(i).getVorgaengerDrei() - 1));
            }
        }
        return knotenlist;
    }

    @GetMapping("/deleteOne")
    public String deleting(Beans beans) {
        beansliste.remove(beansliste.size()-1);
        return "redirect:/startpage";
    }

    @GetMapping("/deleteAll")
    public String deletingAll(Beans beans) {
        beansliste = new ArrayList<>();
        return "redirect:/startpage";
    }

    @GetMapping("startpage")
    private String startpage(Model model) {
        model.addAttribute("knoten", new Beans());
        model.addAttribute("vorgangsnummer", beansliste.size()+1);
        model.addAttribute("vorgaenger", beansliste);
        model.addAttribute("geschrieben", beansliste);

        return "userInput-template";
    }

}
