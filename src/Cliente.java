import java.io.*;
import java.net.Socket;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws IOException {
        Scanner ler = new Scanner(System.in);
        System.out.println("Escreva seu CPF :");
        String  mensagem=   ler.nextLine();


        System.out.println(mensagem);
        if (!mensagem.isEmpty() && mensagem != null) {
            Socket conexao = new Socket("127.0.0.1", 54321);
            DataOutputStream saida = new DataOutputStream(conexao.
                    getOutputStream());

            ByteArrayInputStream inputStream = new ByteArrayInputStream(mensagem.getBytes());
            BufferedReader br = new BufferedReader(new
                    InputStreamReader(inputStream));


            saida.writeUTF(mensagem);

            DataInputStream entrada = new DataInputStream(conexao.getInputStream());
             mensagem = entrada.readUTF().toString();
            System.out.println(mensagem);

            saida.close();
            conexao.close();
        }
    }
}
