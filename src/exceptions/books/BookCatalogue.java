package exceptions.books;

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

        File file = writeInFiles();

       try(FileWriter fileWriter = new FileWriter(file, true)){
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

               fileWriter.write( books[i] + System.lineSeparator());
               fileWriter.flush();

           }// non riesco a scrivere immediatamente il file senza aspettare la fine del loop


       }catch(IllegalArgumentException e){
          System.out.println(e.getMessage());
       }catch(IOException e){
           System.out.println(e.getMessage());
       }
       finally{
           scanner.close();
       }



       try(Scanner reader = new Scanner(file);) {


       while(reader.hasNextLine()){
           String row = reader.nextLine();
           System.out.println(row);
       }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

   }

    private static File writeInFiles() {


        File path = new File("./resources/data.txt");
        try {
            if (!path.exists()) {
                 path.createNewFile();
                // immagino che resource sia nello scaffolding standard
            }
           return path;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return path;
        }
    }
}
