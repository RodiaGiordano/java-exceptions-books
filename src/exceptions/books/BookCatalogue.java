package exceptions.books;

import com.sun.security.jgss.GSSUtil;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BookCatalogue {
   public static void main(String[] args){

       Book[] books = new Book[2];
       Scanner scanner = new Scanner(System.in);


       String titleInput, authorInput,publisherInput;
       int pagesInput;

       try{
           for (int i = 0; i < books.length; i++) {
               System.out.println("inserisci il titolo del libro " + (i+1));
               titleInput = scanner.nextLine();
               System.out.println("Quante pagine ha?");
               try{

               pagesInput = Integer.parseInt(scanner.nextLine());
               }catch(NumberFormatException e){
                   throw new IllegalArgumentException("Non hai inserito numero valido");
               }
               System.out.println("Chi è l'autore?");
               authorInput = scanner.nextLine();
               System.out.println("Chi è l'editore?");
               publisherInput = scanner.nextLine();

               books[i] =  new Book(titleInput, pagesInput, authorInput, publisherInput);
               System.out.println("Libro inserito!\n");

               BookCatalogue.writeInFiles(books[i].toString());


           }


       }catch(IllegalArgumentException e){
          System.out.println(e.getMessage());
       }
       finally{
           scanner.close();
       }




   }
   // scrivere immediatamente il file senza aspettare il termine del ciclo for
    private static void writeInFiles(String row){


        File path = new File("./resources/data.txt");
        try{
            if(!path.exists()){
                path.createNewFile();
                // immagino che resource sia nello scaffolding standard
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        try(FileWriter fileWriter = new FileWriter(path, true)){

            fileWriter.write(row + System.lineSeparator());
            fileWriter.flush();

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
   }
}
