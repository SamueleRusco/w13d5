public class Rivista extends OggettiBiblioteca{
    String periodicita;
    public Rivista(long isbnCode, String titolo, int annoDiPubblicazione, int numeroPagine, String periodicita){
        super(isbnCode, titolo, annoDiPubblicazione, numeroPagine);
        this.periodicita = periodicita;
    }
}
