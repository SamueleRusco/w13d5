import java.io.File;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.apache.commons.io.FileUtils;
public class Main {
    public static List<OggettiBiblioteca> archivio = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        //instanziate variabili e chiamata metodi
        String filePath = "C:/Users/samue/Documents/compiti Epicode/backend2/w13d5";

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
        // cancellaPerISBN();
        //ricercaAnno();
        //ricercaAutore();
        salvaArchivio();

    }

    public static void aggiungiElemento(OggettiBiblioteca e) {
        archivio.add(e);
    }

    ;

    public static void cancellaPerISBN() {

        System.out.println("inserire isbn da eliminare");

        long elemento = scanner.nextLong();
        scanner.nextLine();

        List<OggettiBiblioteca> archivioStream = (List<OggettiBiblioteca>) archivio.stream()
                .filter(e -> e.isbnCode != elemento)
                .collect(Collectors.toList());
        archivio = archivioStream;
        for (int i = 0; i < archivio.size(); i++) {
            System.out.println(archivio.get(i).titolo);

        }
    }

    ;

    public static void ricercaAnno() {
        System.out.println("inserire anno di pubblicazione");
        long elemento = scanner.nextLong();
        scanner.nextLine();
        archivio.stream()
                .filter(obj -> obj.annoDiPubblicazione >= elemento)
                .forEach(e -> System.out.println(e.titolo.toString()));
    }

    ;

    public static void ricercaAutore() {
        System.out.println("inserire nome autore");
       String elemento = scanner.next();

        scanner.nextLine();
        archivio.stream().filter(primoObj -> primoObj.getClass().equals(Libro.class) )
                .filter(obj -> ((Libro) obj).autore.equals(elemento))
                .forEach(e -> System.out.println(e.titolo.toString()));

    }

    ;


    public static void salvaArchivio() throws Exception {
File archivioFile = new File("C:/Users/samue/Documents/compiti Epicode/backend2/w13d5/save.txt");
List<String> stringaArray = new ArrayList<String>();
       try{
           for(int i = 0; i < archivio.size(); i++){
               if (archivio.get(i) instanceof Libro) {
                   stringaArray.add(archivio.get(i).isbnCode + archivio.get(i).titolo + ((Libro) archivio.get(i)).autore );
                   System.out.println("libro");
               } else if (archivio.get(i) instanceof Rivista){
                   stringaArray.add(archivio.get(i).isbnCode + archivio.get(i).titolo + ((Rivista) archivio.get(i)).periodicita );
                   System.out.println("rivista");
               }

           }
           FileUtils.writeLines(archivioFile, stringaArray);
       }
       catch(Exception e){e.getStackTrace();}
        System.out.println("file salvato?");
    }

    ;

    public void importaArchivio() {
    }

    ;

}