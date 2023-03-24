import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static List<OggettiBiblioteca> archivio = new ArrayList<>();

    public static void main(String[] args) {
        //instanziate variabili e chiamata metodi

        Libro l1 = new Libro(01234567, "l'arte della sbrugna", 20220101, 205, "gerryScotty", "thriller");
        Libro l2 = new Libro(16281471, "Il Silmarillion", 19770915, 205, "J.R.R. Tolkien", "fantasy");
        Libro l3 = new Libro(92871636, "Lo Hobbit", 19370101, 205, "J.R.R. Tolkien", "fantasy");
        Libro l4 = new Libro(87074135, "il richiamo di Chtulhu", 19280201, 205, "H.P. Lovecraft", "Horror FIction");
        Libro l5 = new Libro(36714861, "Shining", 19770128, 205, "Stephen King", "Horror FIction");

        Rivista r1 = new Rivista(36714861, "Focus", 19920101, 55, "MENSILE");
        Rivista r2 = new Rivista(67641318, "La settimana enigmistica", 19320123, 55, "SEMESTRALE");
        Rivista r3 = new Rivista(14617836, "Internazionale", 19930101, 48, "SETTIMANALE");


        aggiungiElemento(l1);
        aggiungiElemento(l2);
        aggiungiElemento(l3);
        aggiungiElemento(l4);
        aggiungiElemento(l5);
        aggiungiElemento(r1);
        aggiungiElemento(r2);
        aggiungiElemento(r3);


    }

    public static void aggiungiElemento(OggettiBiblioteca e) {
        archivio.add(e);
    }

    ;

    public OggettiBiblioteca ricercaISBN() {
        return archivio.stream().filter(obj -> obj.getisbnCode() == obj.isbnCode)
                .findFirst()
                .orElse(null);


    }

    ;

    public List<OggettiBiblioteca> ricercaAnno() {
        return archivio.stream()
                .filter(obj -> obj.getannoPubblicazione() >= obj.annoDiPubblicazione)
                .collect(Collectors.toList());
    }

    ;

    public static List<OggettiBiblioteca> ricercaAutore(String autore) {
        return archivio.stream()
                .filter(obj -> obj instanceof Libro)
                .filter(obj -> ((Libro) obj).getAutore().equals(autore))
                .collect(Collectors.toList());
    }

    ;

    public void salvaArchivio() {
    }

    ;

    public void importaArchivio() {
    }

    ;

}