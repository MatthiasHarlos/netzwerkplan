package com.simaur.netzwerkplan;

import formularinputs.Knoten;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class NetzwerkplanController {

    private List<Knoten> knotenliste = new ArrayList<>();

    @GetMapping("startpage")
    private String startpage(Model model, Knoten knoten) {

        return "userInput-template";
    }

}
