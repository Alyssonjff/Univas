package geradornotificacao;

public class Push implements TipoNotificacao{
    public void notificar(String mensagem){
        System.out.println("Push: " + mensagem);
    }
}