import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(54321);
        System.out.println("A porta 54321 foi aberta.");
        Socket conexao = servidor.accept();
        DataInputStream entrada = new DataInputStream(conexao.getInputStream());
        String mensagem = entrada.readUTF().toString();

        validarCPF(mensagem);
        conexao.close();
    }

    public static void validarCPF(String cpf) {
        System.out.println("CPF : "+cpf + "É VALIDO");
    }

}
