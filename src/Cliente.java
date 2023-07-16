import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {
        TelaCPF tela = new TelaCPF();
        tela.abrirTelaCpf();
        String mensagem = null;
        boolean trava = true;
        mensagem = "";

        System.out.println(mensagem);
        if (!mensagem.isEmpty() && mensagem != null) {
            Socket conexao = new Socket("127.0.0.1", 54321);
            DataOutputStream saida = new DataOutputStream(conexao.
                    getOutputStream());

            ByteArrayInputStream inputStream = new ByteArrayInputStream(mensagem.getBytes());
            BufferedReader br = new BufferedReader(new
                    InputStreamReader(inputStream));


            saida.writeUTF(mensagem);

            saida.close();
            conexao.close();
        }
    }
}
