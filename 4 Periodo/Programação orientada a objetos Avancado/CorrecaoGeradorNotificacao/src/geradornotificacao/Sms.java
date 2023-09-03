package geradornotificacao;

public class Sms implements TipoNotificacao{
    public void notificar(String mensagem){
        System.out.println("SMS: " + mensagem);
    }
}