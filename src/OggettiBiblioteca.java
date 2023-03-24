import java.time.LocalDate;

public class OggettiBiblioteca {
    long isbnCode;
    String titolo;
    int annoDiPubblicazione;
    int numeroPagine;

    public OggettiBiblioteca(long isbnCode, String titolo, int annoDiPubblicazione, int numeroPagine) {
        this.isbnCode = isbnCode;
        this.titolo = titolo;
        this.annoDiPubblicazione = LocalDate.of(annoDiPubblicazione / 10000, (annoDiPubblicazione / 100) % 100, annoDiPubblicazione % 100).getYear();
        this.numeroPagine = numeroPagine;

    }
    public long getisbnCode() {
        return isbnCode;
    }
    public int getannoPubblicazione(){
        return annoDiPubblicazione;
    }




}
