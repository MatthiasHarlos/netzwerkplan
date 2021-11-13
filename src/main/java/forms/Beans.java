package forms;

import java.util.ArrayList;
import java.util.List;

public class Beans {
    private String inputVorgangsbezeichnung;
    private int inputDauer;
    private int vorgangsnummer;
    private Integer vorgaengerEins;
    private Integer vorgaengerZwei;
    private Integer vorgaengerDrei;

    public Beans() {}

    public Beans(int vorgangsnummer) {
        this.vorgangsnummer = vorgangsnummer;
    }

    public Beans(String inputVorgangsbezeichnung, int inputDauer, int vorgangsnummer, Integer vorgaengerEins, Integer vorgaengerZwei, Integer vorgaengerDrei) {
        this.inputVorgangsbezeichnung = inputVorgangsbezeichnung;
        this.inputDauer = inputDauer;
        this.vorgangsnummer = vorgangsnummer;
        this.vorgaengerEins = vorgaengerEins;
        this.vorgaengerZwei = vorgaengerZwei;
        this.vorgaengerDrei = vorgaengerDrei;
    }

    @Override
    public String toString() {
        return "Knoten{" +
                "inputVorgangsbezeichnung='" + inputVorgangsbezeichnung + '\'' +
                ", inputDauer='" + inputDauer + '\'' +
                ", vorgangsnummer='" + vorgangsnummer + '\'' +
                ", vorgaengerEins='" + vorgaengerEins + '\'' +
                ", vorgaengerZwei='" + vorgaengerZwei + '\'' +
                ", vorgaengerDrei='" + vorgaengerDrei + '\'' +
                ", nachfolger='" +
                '}';
    }

    public String getInputVorgangsbezeichnung() {
        return inputVorgangsbezeichnung;
    }

    public void setInputVorgangsbezeichnung(String inputVorgangsbezeichnung) {
        this.inputVorgangsbezeichnung = inputVorgangsbezeichnung;
    }

    public int getInputDauer() {
        return inputDauer;
    }

    public void setInputDauer(int inputDauer) {
        this.inputDauer = inputDauer;
    }

    public int getVorgangsnummer() {
        return vorgangsnummer;
    }

    public void setVorgangsnummer(int vorgangsnummer) {
        this.vorgangsnummer = vorgangsnummer;
    }

    public Integer getVorgaengerEins() {
        return vorgaengerEins;
    }

    public void setVorgaengerEins(Integer vorgaengerEins) {
        this.vorgaengerEins = vorgaengerEins;
    }

    public Integer getVorgaengerZwei() {
        return vorgaengerZwei;
    }

    public void setVorgaengerZwei(Integer vorgaengerZwei) {
        this.vorgaengerZwei = vorgaengerZwei;
    }

    public Integer getVorgaengerDrei() {
        return vorgaengerDrei;
    }

    public void setVorgaengerDrei(Integer vorgaengerDrei) {
        this.vorgaengerDrei = vorgaengerDrei;
    }


}
