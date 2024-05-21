package exceptions.books;

public class Book {
    private String title;
    private int pages;
    private String author;
    private String publisher;

    Book(String tile, int pages, String author, String publisher){
        this.title = checkString(tile, "titolo");
        this.pages = checkPages(pages);
        this.author = checkString(author, "autore");
        this.publisher =checkString(publisher, "editore");
    }


    private String checkString(String value, String varName) throws IllegalArgumentException {
      // if(value instanceof String) throw new IllegalArgumentException("ciao");
       if(value.length() <= 0) throw new IllegalArgumentException("Il campo: " + varName + " non può essere vuoto");
       return value;
    }

    private int checkPages(int pages) throws IllegalArgumentException{
        if(pages <= 0) throw new IllegalArgumentException("Un libro deve avere almeno una pagina");
        return pages;
    }

    public String getTitle(){
        return title;
    }

    public String getPublisher(){
        return publisher;
    }

    public String getAuthor(){
        return author;
    }

    public void setTitle(String title)throws IllegalArgumentException {
        this.title = checkString(title, "titolo");
    }

    public void setPages(int pages)throws IllegalArgumentException{
        this.pages = checkPages(pages);
    }

    public void setAuthor(String author)throws IllegalArgumentException{
        this.title = checkString(author, "autore");
    }

    public void setPublisher(String publisher)throws IllegalArgumentException{
        this.title = checkString(publisher, "editore");
    }

    @Override
    public String toString(){
        return String.format("Titolo: %s - Pagine: %d - Autore: %s - Editore: %s\n", title, pages, author, publisher);
    }
}


