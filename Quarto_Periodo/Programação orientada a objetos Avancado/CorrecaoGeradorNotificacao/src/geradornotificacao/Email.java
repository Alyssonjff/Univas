package geradornotificacao;

public class Email implements TipoNotificacao{
    public void notificar(String mensagem){
        System.out.println("Email: " + mensagem);
    }
}