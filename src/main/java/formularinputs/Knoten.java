package formularinputs;

public class Knoten {
    private String inputVorgangsbezeichnung;
    private String inputDauer;
    private String vorgangsnummer;
    private String vorgaengerEins;
    private String vorgaengerZwei;
    private String vorgaengerDrei;
    private String nachfolger;

    public Knoten() {}

    public Knoten(String vorgangsnummer) {
        this.vorgangsnummer = vorgangsnummer;
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
                ", nachfolger=" + nachfolger +
                '}';
    }

    public String getNachfolger() {
        return nachfolger;
    }

    public void setNachfolger(String nachfolger) {
        this.nachfolger = nachfolger;
    }

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

    public String getVorgangsnummer() {
        return vorgangsnummer;
    }

    public void setVorgangsnummer(String vorgangsnummer) {
        this.vorgangsnummer = vorgangsnummer;
    }

    public String getVorgaengerEins() {
        return vorgaengerEins;
    }

    public void setVorgaengerEins(String vorgaengerEins) {
        this.vorgaengerEins = vorgaengerEins;
    }

    public String getVorgaengerZwei() {
        return vorgaengerZwei;
    }

    public void setVorgaengerZwei(String vorgaengerZwei) {
        this.vorgaengerZwei = vorgaengerZwei;
    }

    public String getVorgaengerDrei() {
        return vorgaengerDrei;
    }

    public void setVorgaengerDrei(String vorgaengerDrei) {
        this.vorgaengerDrei = vorgaengerDrei;
    }


}
