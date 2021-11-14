package com.simaur.netzwerkplan;

import forms.Beans;
import forms.Knots;
import forms.Paths;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@Controller
public class NetzwerkplanController {

    public List<Beans> beansliste = new ArrayList<>();
    public List<Paths> testPathList = new ArrayList<>();
    public List<List<Knots>> testknotenliste = new ArrayList<>();

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

    public List<Knots> calculateBeansToKnots(List<Beans> beanslist) {
        List<Knots> result = new ArrayList<>();
        for (Beans bean : beanslist) {
            result.add(new Knots(bean.getVorgangsnummer(),bean.getInputVorgangsbezeichnung(),bean.getInputDauer()));
        }
        List<Knots> resultAddedPredecessor = getVorgaenger(result);
        List<Knots> resultAddedSuccessor = kalkuliereNachfolger(resultAddedPredecessor);
        List<List<Knots>> endpaths = kalkulierePfade(resultAddedSuccessor);

        List<Paths> paths = new ArrayList<>();
        int max = 0;
        for (List<Knots> durationCounter : endpaths) {
            int duration = 0;
            for (Knots knots : durationCounter) {
                knots.setFruehesterbeginn(duration);
                duration += knots.getDauer();
                if (duration>max) {
                    max = duration;
                }
                knots.setFruehestesende(duration);
            }
            Paths path = new Paths(durationCounter, duration);
            paths.add(path);
        }
        List<Paths> biggestPath = new ArrayList<>();
        for (int i = 0; i<paths.size(); i++) {
            for (int y = 0; y<paths.size(); y++) {
                if (paths.get(i).getFinalDuration() == max) {
                    biggestPath.add(paths.get(i));
                }
            }
        }
        for (Paths großerpfad : biggestPath) {
            for (int i = 0; i < biggestPath.get(0).getPath().size(); i++) {
                if (großerpfad.getPath().get(i).getVorgaenger().size() < 1) {
                    großerpfad.getPath().get(i).setFruehestesende(großerpfad.getPath().get(i).getDauer());
                } else if (großerpfad.getPath().get(i).getVorgaenger().size() > 0) {
                    int beginn = großerpfad.getPath().get(i - 1).getFruehestesende();
                    großerpfad.getPath().get(i).setFruehesterbeginn(beginn);
                    großerpfad.getPath().get(i).setFruehestesende(großerpfad.getPath().get(i).getDauer() + beginn);
                }
            }
        }
        testPathList.addAll(paths);
        testknotenliste = endpaths;
        for (List<Knots> path : endpaths) {
            for (int i = 0; i<path.size(); i++) {
                if (path.get(i).getVorgaenger().size() == 1) {
                    int beginn = path.get(i).getVorgaenger().get(0).getFruehestesende();
                    path.get(i).setFruehesterbeginn(beginn);
                    path.get(i).setFruehestesende(beginn+path.get(i).getDauer());
                }
            }
        }

        return resultAddedSuccessor;
    }

    private List<List<Knots>> kalkulierePfade(List<Knots> knotenlist) {
        List<List<Knots>> resultPfade = new ArrayList<>();
        List<List<Knots>> endpaths = new ArrayList<>();
        boolean schleife;
        List<List<Knots>> pfade = new ArrayList<>();
       List<Knots> pfad;
       List<Knots> zweig;
        for (Knots knoten : knotenlist) {
            if (knoten.getVorgaenger().size() > 0) {
                for (Knots vorgaenger : knoten.getVorgaenger()) {
                    pfad  = new ArrayList<>();
                    pfad.add(vorgaenger);
                    pfad.add(knoten);
                    if (knoten.getNachfolger().size() > 0) {
                        for (Knots nachfolger : knoten.getNachfolger()) {
                            zweig = new ArrayList<>(pfad);
                            zweig.add(nachfolger);
                            pfade.add(zweig);
                        }
                    } else if (pfad.get(0).getVorgaenger().size()<1 && pfad.get(pfad.size()-1).getNachfolger().size()<1){
                        endpaths.add(pfad);
                    }
                }
            }
        }
        for (List<Knots> looker : pfade) {
            for (Knots knoten : looker) {
                System.out.print("Alte Pfadstücke " + knoten.getVorgangsnummer() + ", ");
            }
            if (looker.get(0).getVorgaenger().size()<1 && looker.get(looker.size()-1).getNachfolger().size()<1){
                endpaths.add(looker);
            }
            System.out.println();
        }
        do {
            for (List<Knots> pfadresulting : pfade) {
                for (List<Knots> pfadlooking : pfade) {
               if (pfadresulting.get(pfadresulting.size()-1).getVorgangsnummer() == pfadlooking.get(0).getVorgangsnummer()) {
                   List<Knots> finishedpath = new ArrayList<>(pfadresulting);
                   for (int i = 1; i<pfadlooking.size(); i++) {
                       finishedpath.add(pfadlooking.get(i));
                   }
                   resultPfade.add(finishedpath);
               }
                    if (pfadresulting.get(pfadresulting.size() - 1).getVorgangsnummer() == pfadlooking.get(1).getVorgangsnummer()) {
                   List<Knots> finishedpath = new ArrayList<>(pfadresulting);
                        for (int i = 2; i < pfadlooking.size(); i++) {
                            finishedpath.add(pfadlooking.get(i));
                        }
                        resultPfade.add(finishedpath);
                    }
                }
            }
            for (List<Knots> looker : resultPfade) {
                    if (looker.get(0).getVorgaenger().size()<1 && looker.get(looker.size()-1).getNachfolger().size()<1){
                        endpaths.add(looker);
                    }
            }
            schleife = false;
            for (List<Knots> pfadresulting : resultPfade) {
                for (List<Knots> pfadlooking : resultPfade) {
                    if (pfadresulting.get(pfadresulting.size() - 1).getVorgangsnummer() == pfadlooking.get(1).getVorgangsnummer()) {
                        pfade = resultPfade;
                        resultPfade = new ArrayList<>();
                        System.out.println("resetResultPfad");
                        schleife = true;
                        break;
                    }
                }
            }
        } while (schleife);
        for(int i = 0; i<endpaths.size(); i++) {
            for (int y = endpaths.size()-1; y>=0; y--) {
                if (endpaths.get(i).equals(endpaths.get(y)) && endpaths.size()>1 && y != i) {
                    endpaths.remove(y);
                }
            }
        }
        return endpaths;
    }

    private List<Knots> kalkuliereNachfolger(List<Knots> knotenlist) {
        for (int i = (beansliste.size()-1); i >= 0; i--) {
            int vorgaengereins;
            int vorgaengerzwei;
            int vorgaengerdrei;
            int nachfolgerfuerVorgaenger = beansliste.get(i).getVorgangsnummer()-1;
            if (beansliste.get(i).getVorgaengerEins() != null) {
                vorgaengereins = beansliste.get(i).getVorgaengerEins() - 1;
                knotenlist.get(vorgaengereins).getNachfolger().add(knotenlist.get(nachfolgerfuerVorgaenger));
            }
            if (beansliste.get(i).getVorgaengerZwei() != null) {
                vorgaengerzwei = beansliste.get(i).getVorgaengerZwei() - 1;
                knotenlist.get(vorgaengerzwei).getNachfolger().add(knotenlist.get(nachfolgerfuerVorgaenger));
            }
            if (beansliste.get(i).getVorgaengerDrei() != null) {
                vorgaengerdrei =beansliste.get(i).getVorgaengerDrei() - 1;
                knotenlist.get(vorgaengerdrei).getNachfolger().add(knotenlist.get(nachfolgerfuerVorgaenger));
            }
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
