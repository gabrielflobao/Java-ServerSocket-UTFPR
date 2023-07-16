import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Application {
    public static void main(String[] args) throws IOException {

       /* ServerSocket listen = new ServerSocket(6000);
        Socket cliente = listen.accept();
        DataInputStream entrada = new  DataInputStream(cliente.getInputStream());
        String CPF = entrada.readUTF();
        DataOutputStream saida = new DataOutputStream(cliente.getOutputStream());saida.writeBoolean(true);
        saida.writeBoolean(true);
        System.out.println(saida.writeBoolean(true));
    */
        ServerSocket servidor = new ServerSocket(64321);
        System.out.println("A porta : 64321 está aberta");

        Socket conexao = servidor.accept();

         DataInputStream entrada = new DataInputStream(conexao.
                getInputStream());

        String mensagem = entrada.readUTF();
         mensagem = mensagem.toUpperCase();

         System.out.println("A mensagem em maiusculo e: " +
                mensagem);

    }
}
