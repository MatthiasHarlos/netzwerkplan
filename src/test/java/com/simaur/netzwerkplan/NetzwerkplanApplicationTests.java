package com.simaur.netzwerkplan;

import forms.Beans;
import forms.Knots;
import forms.Paths;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class NetzwerkplanApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void someSOUTPut() {
	NetzwerkplanController controller = new NetzwerkplanController();
		List<Beans> beanslist = new ArrayList<>();
		beanslist.add(new Beans("Entscheidung GE",2,1,null,null,null));
		beanslist.add(new Beans("Angebote einholen",14,2,1,null,null));
		beanslist.add(new Beans("Mitarbeiterinformationen",1,3,1,null,null));
		beanslist.add(new Beans("Testen G1",1,4,2,null,null));
		beanslist.add(new Beans("Testen G2",2,5,2,null,null));
		beanslist.add(new Beans("Testen G3",1,6,2,null,null));
		beanslist.add(new Beans("Auswahl Lieferanten",1,7,4,5,6));
		beanslist.add(new Beans("Lieferung",5,8,7,null,null));
		beanslist.add(new Beans("Raumauswahl",2,9,7,null,null));
		beanslist.add(new Beans("Elektroinstallation",2,10,9,null,null));
		beanslist.add(new Beans("Computeraufstellung",1,11,8,10,null));
		beanslist.add(new Beans("Mitarbeiterschulung",7,12,3,11,null));
		beanslist.add(new Beans("Arbeitsaufnahme",1,13,12,null,null));
		controller.beansliste.addAll(beanslist);
		controller.calculateBeansToKnots(beanslist);
		for (List<Knots> pfad : controller.testknotenliste) {
			//System.out.println(pfad.getFinalDuration());
			System.out.println("Vorgangsnummer: ");
			for (Knots knoten : pfad) {
				System.out.print(knoten.getVorgangsnummer() + ", ");
			}
			System.out.println("frühestes Ende: ");
			for (Knots knoten : pfad) {
				System.out.print(knoten.getFruehestesende() + ", ");
			}
			System.out.println("frühester Beginn: ");
			for (Knots knoten : pfad) {
				System.out.print(knoten.getFruehesterbeginn() + ", ");
			}
			System.out.println("next");
		}
	}

	@Test
	void someSOUTPut2() {
		NetzwerkplanController controller = new NetzwerkplanController();
		List<Beans> beanslist = new ArrayList<>();
		beanslist.add(new Beans("Vorgang1",2,1,null,null,null));
		beanslist.add(new Beans("Vorgang2",3,2,null,null,null));
		beanslist.add(new Beans("Vorgang3",6,3,1,2,null));
		beanslist.add(new Beans("Vorgang4",2,4,3,null,null));
		beanslist.add(new Beans("Vorgang5",1,5,3,null,null));
		beanslist.add(new Beans("Vorgang6",4,6,4,5,null));
		beanslist.add(new Beans("Vorgang7",2,7,6,null,null));
		controller.beansliste.addAll(beanslist);
		controller.calculateBeansToKnots(beanslist);
		for (List<Knots> pfad : controller.testknotenliste) {
			//System.out.println(pfad.getFinalDuration());
			System.out.println("Vorgangsnummer: ");
			for (Knots knoten : pfad) {
				System.out.print(knoten.getVorgangsnummer() + ", ");
			}
			System.out.println("frühestes Ende: ");
			for (Knots knoten : pfad) {
				System.out.print(knoten.getFruehestesende() + ", ");
			}
			System.out.println("frühester Beginn: ");
			for (Knots knoten : pfad) {
				System.out.print(knoten.getFruehesterbeginn() + ", ");
			}
			System.out.println("next");
		}
	}

	@Test
	void someSOUTPut3() {
		NetzwerkplanController controller = new NetzwerkplanController();
		List<Beans> beanslist = new ArrayList<>();
		beanslist.add(new Beans("Entscheidung GE",2,1,null,null,null));
		beanslist.add(new Beans("Angebote einholen",14,2,1,null,null));
		beanslist.add(new Beans("Mitarbeiterinformationen",1,3,2,null,null));
		beanslist.add(new Beans("Testen G1",1,4,3,null,null));
		beanslist.add(new Beans("Testen G2",2,5,4,null,null));
		beanslist.add(new Beans("Testen G3",1,6,5,null,null));
		beanslist.add(new Beans("Auswahl Lieferanten",1,7,6,null,null));
		controller.beansliste.addAll(beanslist);
		controller.calculateBeansToKnots(beanslist);
		for (List<Knots> pfad : controller.testknotenliste) {
			//System.out.println(pfad.getFinalDuration());
			System.out.println("Vorgangsnummer: ");
			for (Knots knoten : pfad) {
				System.out.print(knoten.getVorgangsnummer() + ", ");
			}
			System.out.println("frühestes Ende: ");
			for (Knots knoten : pfad) {
				System.out.print(knoten.getFruehestesende() + ", ");
			}
			System.out.println("frühester Beginn: ");
			for (Knots knoten : pfad) {
				System.out.print(knoten.getFruehesterbeginn() + ", ");
			}
			System.out.println("next");
		}
	}

	@Test
	void someSOUTPut4() {
		NetzwerkplanController controller = new NetzwerkplanController();
		List<Beans> beanslist = new ArrayList<>();
		beanslist.add(new Beans("Entscheidung GE",2,1,null,null,null));
		beanslist.add(new Beans("Angebote einholen",14,2,1,null,null));
		beanslist.add(new Beans("Mitarbeiterinformationen",1,3,2,null,null));
		controller.beansliste.addAll(beanslist);
		controller.calculateBeansToKnots(beanslist);
		for (List<Knots> pfad : controller.testknotenliste) {
			//System.out.println(pfad.getFinalDuration());
			System.out.println("Vorgangsnummer: ");
			for (Knots knoten : pfad) {
				System.out.print(knoten.getVorgangsnummer() + ", ");
			}
			System.out.println("frühestes Ende: ");
			for (Knots knoten : pfad) {
				System.out.print(knoten.getFruehestesende() + ", ");
			}
			System.out.println("frühester Beginn: ");
			for (Knots knoten : pfad) {
				System.out.print(knoten.getFruehesterbeginn() + ", ");
			}
			System.out.println("next");
		}
	}

}
