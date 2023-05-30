public class Principal {
    public static void main(String[] args) {
        ManipuladorDeElementos manipular = new ManipuladorDeElementos();

        Circulo cir = new Circulo(5);
        manipular.obterInformacoes(cir);

        Quadrilatero quar = new Quadrilatero(5,4);
        manipular.obterInformacoes(quar);

        Triangulo tri = new Triangulo(10, 12, 12);
        manipular.obterInformacoes(tri);
    }
}