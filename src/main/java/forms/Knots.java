package forms;

import java.util.ArrayList;
import java.util.List;

public class Knots {
    private int vorgangsnummer;
    private String vorgangsbezeichnung;
    private int dauer;
    private int fruehesterbeginn;
    private int fruehestesende;
    private int spaetesterbeginn;
    private int spaetestesende;
    private int gesamtpuffer;
    private int freierpuffer;
    private List<Knots> vorgaenger = new ArrayList<>();
    private List<Knots> nachfolger = new ArrayList<>();

    public Knots(int vorgangsnummer, String vorgangsbezeichnung, int dauer) {
        this.vorgangsnummer = vorgangsnummer;
        this.vorgangsbezeichnung = vorgangsbezeichnung;
        this.dauer = dauer;
    }
    public Knots(){}

    @Override
    public String toString() {
        return "Knots{" +
                "vorgangsnummer=" + vorgangsnummer +
                ", vorgangsbezeichnung='" + vorgangsbezeichnung + '\'' +
                ", dauer=" + dauer +
                ", fruehesterbeginn=" + fruehesterbeginn +
                ", fruehestesende=" + fruehestesende +
                ", spaetesterbeginn=" + spaetesterbeginn +
                ", spaetestesende=" + spaetestesende +
                ", gesamtpuffer=" + gesamtpuffer +
                ", freierpuffer=" + freierpuffer +
                '}';
    }

    public int getVorgangsnummer() {
        return vorgangsnummer;
    }

    public void setVorgangsnummer(int vorgangsnummer) {
        this.vorgangsnummer = vorgangsnummer;
    }

    public String getVorgangsbezeichnung() {
        return vorgangsbezeichnung;
    }

    public void setVorgangsbezeichnung(String vorgangsbezeichnung) {
        this.vorgangsbezeichnung = vorgangsbezeichnung;
    }

    public int getDauer() {
        return dauer;
    }

    public void setDauer(int dauer) {
        this.dauer = dauer;
    }

    public int getFruehesterbeginn() {
        return fruehesterbeginn;
    }

    public void setFruehesterbeginn(int fruehesterbeginn) {
        this.fruehesterbeginn = fruehesterbeginn;
    }

    public int getFruehestesende() {
        return fruehestesende;
    }

    public void setFruehestesende(int fruehestesende) {
        this.fruehestesende = fruehestesende;
    }

    public int getSpaetesterbeginn() {
        return spaetesterbeginn;
    }

    public void setSpaetesterbeginn(int spaetesterbeginn) {
        this.spaetesterbeginn = spaetesterbeginn;
    }

    public int getSpaetestesende() {
        return spaetestesende;
    }

    public void setSpaetestesende(int spaetestesende) {
        this.spaetestesende = spaetestesende;
    }

    public int getGesamtpuffer() {
        return gesamtpuffer;
    }

    public void setGesamtpuffer(int gesamtpuffer) {
        this.gesamtpuffer = gesamtpuffer;
    }

    public int getFreierpuffer() {
        return freierpuffer;
    }

    public void setFreierpuffer(int freierpuffer) {
        this.freierpuffer = freierpuffer;
    }

    public List<Knots> getVorgaenger() {
        return vorgaenger;
    }

    public void setVorgaenger(List<Knots> vorgaenger) {
        this.vorgaenger = vorgaenger;
    }

    public List<Knots> getNachfolger() {
        return nachfolger;
    }

    public void setNachfolger(List<Knots> nachfolger) {
        this.nachfolger = nachfolger;
    }
}
