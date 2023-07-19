import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

public class Servidor {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket servidor = new ServerSocket(54321);
        System.out.println("A porta 54321 foi aberta.");
        String mensagemParaCliente = "Dados recebidos corretamente";
        Socket conexao = servidor.accept();
        ObjectInputStream objectInputStream;
        ObjectOutputStream objectOutputStream;
        objectInputStream = new ObjectInputStream(conexao.getInputStream());


        Pessoa pessoa = (Pessoa) objectInputStream.readObject();
        System.out.println("Dados recebidos do cliente:");
        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("Idade: " + pessoa.getIdade());

        objectOutputStream = new ObjectOutputStream(conexao.getOutputStream());
        objectOutputStream.writeObject(mensagemParaCliente);

        objectOutputStream.close();
        objectInputStream.close();
        conexao.close();
        servidor.close();

    }




}
