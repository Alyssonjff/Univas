package geradornotificacao;

public class Main {
    public static void main(String[] args) {
        CentralDeNotificacao notificacao = new CentralDeNotificacao(new Sms());
        notificacao.notificar("Ola mundo");
    }
}