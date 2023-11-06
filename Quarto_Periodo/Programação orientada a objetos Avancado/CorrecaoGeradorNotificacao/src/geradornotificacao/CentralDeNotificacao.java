package geradornotificacao;

public class CentralDeNotificacao {
    private TipoNotificacao tipo;
    public CentralDeNotificacao(TipoNotificacao tipo) {
        this.tipo = tipo;
    }
    public void notificar(String mensagem){
        tipo.notificar(mensagem);
    }
}