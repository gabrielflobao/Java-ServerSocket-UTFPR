import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class FormCliente extends JFrame {

    private JTextField nomeTextField;
    private JTextField idadeTextField;
    private JTextArea respostaTextArea;

    public FormCliente() {
        // Configurações básicas da janela
        setTitle("Aplicação Cliente Servidor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(null); // Centraliza a janela na tela

        // Criação dos componentes
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(5, 5, 5, 5);

        JLabel nomeLabel = new JLabel("Nome:");
        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(nomeLabel, constraints);

        nomeTextField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(nomeTextField, constraints);

        JLabel idadeLabel = new JLabel("Idade:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(idadeLabel, constraints);

        idadeTextField = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(idadeTextField, constraints);

        JLabel respostaLabel = new JLabel("Resposta do Servidor:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(respostaLabel, constraints);

        respostaTextArea = new JTextArea(5, 20);
        respostaTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(respostaTextArea);
        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(scrollPane, constraints);

        JButton enviarButton = new JButton("Enviar");
        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;
        panel.add(enviarButton, constraints);

        // Ação do botão enviar
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = nomeTextField.getText();
                String idade = idadeTextField.getText();

                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        try {
                            Socket socket = new Socket("127.0.0.1", 54321);
                            Pessoa pessoa = new Pessoa(nome, idade);

                            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                            objectOutputStream.writeObject(pessoa);
                            objectOutputStream.flush();


                            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                            String resposta = objectInputStream.readObject().toString();
                            objectInputStream.close();

                            respostaTextArea.setText(resposta);

                            socket.close();
                        } catch (IOException | ClassNotFoundException ex) {
                            ex.printStackTrace();
                        }

                        return null;
                    }
                };

                worker.execute();
            }
        });

        getContentPane().add(panel);
    }

    public void abrirTela() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FormCliente tela = new FormCliente();
                tela.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        FormCliente tela = new FormCliente();
        tela.abrirTela();
    }
}
