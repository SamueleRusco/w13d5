public class Libro extends OggettiBiblioteca{
String autore;
String genere;
    public Libro(long isbnCode, String titolo, int annoDiPubblicazione, int numeroPagine, String autore, String genere){
        super(isbnCode, titolo, annoDiPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }
    public String getAutore(){
        return autore;
    }
}
