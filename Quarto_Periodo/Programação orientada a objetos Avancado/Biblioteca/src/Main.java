
public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca("Biblioteca");
        Livro livro01 = new Livro("Harry Potter", "AutorDeHP");
        Livro livro02 = new Livro("O Hobbit", "AutorDeHobbit");


        Autor autor01 = new Autor("Autor01");
        Autor autor02 = new Autor("Autor02");


        biblioteca.adicionarLivro(livro01);
        biblioteca.adicionarLivro(livro02);

        biblioteca.adicionarAutor(autor01);
        biblioteca.adicionarAutor(autor02);

        if(biblioteca.verificarDisponibilidade(livro02.getTitulo())){
            System.out.println("O livro está disponível!");
        }
        else{
            System.out.println("O livro não está disponível!");
        }

    }
}