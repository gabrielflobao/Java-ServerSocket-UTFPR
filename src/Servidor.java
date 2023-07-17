import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

public class Servidor {
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(54321);
        System.out.println("A porta 54321 foi aberta.");
        Socket conexao = servidor.accept();
        DataInputStream entrada = new DataInputStream(conexao.getInputStream());
        String mensagem = entrada.readUTF().toString();

         mensagem = validarCPF(mensagem);

        DataOutputStream saida = new DataOutputStream(conexao.
                getOutputStream());

        ByteArrayInputStream inputStream = new ByteArrayInputStream(mensagem.getBytes());
        BufferedReader br = new BufferedReader(new
                InputStreamReader(inputStream));


        saida.writeUTF(mensagem);

        saida.close();


        conexao.close();
    }

    public static String validarCPF(String cpf) {
        ArrayList <Integer>cpfConvertido = new ArrayList<Integer>();

        for(int i =0 ; i<cpf.length(); i++) {
           cpfConvertido.add(Integer.parseInt(String.valueOf(cpf.toCharArray()[i])));
           if(i==8)
               break;
        }
        cpfConvertido.add(retornaPrimeiroDigitoValidar(cpfConvertido));
        cpfConvertido.add(retornaSegundaDigitoValidar(cpfConvertido));
        String cpfValidado ="";
        for (Integer num: cpfConvertido) {
            cpfValidado += String.valueOf(num.intValue());
        }
        if(cpf.equals(cpfValidado)) {
           return "CPF VALIDO!";
        }
        return "CPF INVALIDO!";
    }

    public static Integer retornaPrimeiroDigitoValidar(ArrayList<Integer> cpf) {
        Integer soma = 0;
        int multiplicador = 2;
        for (Integer num : cpf) {
            soma += num.intValue() * multiplicador;
            multiplicador++;
        }

        double divisao = soma / 11.0;
        double modulo = (divisao - ((int) divisao)) * -1;
        modulo = Math.abs(modulo);
        BigDecimal quociente = new BigDecimal(divisao);
        quociente = quociente.setScale(2, RoundingMode.HALF_UP);
        Double resto = soma - (11.0 * quociente.doubleValue());
        resto = Math.abs(resto.doubleValue());

        if (resto > 2) {
            return 2;
        } else {
            Integer retorno = (int) Math.abs((modulo * 11.0));
            retorno = 11 - retorno;
            return retorno;
        }
    }

        public static Integer retornaSegundaDigitoValidar(ArrayList<Integer> cpf) {
            Integer soma = 0;
            int multiplicador = 2;
            for (Integer num : cpf) {
                soma += num.intValue() * multiplicador;
                multiplicador++;
            }

            double divisao = soma / 11.0;
            double modulo = (divisao - ((int) divisao)) * -1;
            modulo = Math.abs(modulo);
            BigDecimal quociente = new BigDecimal(divisao);
            quociente = quociente.setScale(2, RoundingMode.HALF_UP);
            Double resto = soma - (11.0 * quociente.doubleValue());
            resto = Math.abs(resto.doubleValue());

            Double retorno = 11-(11.0 * modulo);
            return  Integer.parseInt(String.valueOf(Math.round(retorno)));

        }


}
