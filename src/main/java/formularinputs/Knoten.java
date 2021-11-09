package formularinputs;

public class Knoten {
    private String inputVorgangsbezeichnung;
    private String inputDauer;
    private Integer vorgangsnummer;
    private Integer vorgaengerEins;
    private Integer vorgaengerZwei;
    private Integer vorgaengerDrei;


    public String getInputVorgangsbezeichnung() {
        return inputVorgangsbezeichnung;
    }

    public void setInputVorgangsbezeichnung(String inputVorgangsbezeichnung) {
        this.inputVorgangsbezeichnung = inputVorgangsbezeichnung;
    }

    public String getInputDauer() {
        return inputDauer;
    }

    public void setInputDauer(String inputDauer) {
        this.inputDauer = inputDauer;
    }

    public Integer getVorgangsnummer() {
        return vorgangsnummer;
    }

    public void setVorgangsnummer(Integer vorgangsnummer) {
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
