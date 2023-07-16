import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaCPF extends JFrame {
    private JTextField cpfTextField = new JTextField();
    private  JButton enviarButton = new JButton("Enviar");
    private  JButton limparButton = new JButton("Limpar");
    private String campoCPF = "";
    private ActionBotaoEnviar actionEnviar = new ActionBotaoEnviar();
    private ActionBotaoLimpar actionLimpar = new ActionBotaoLimpar();

    public TelaCPF() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Tela CPF");
        setSize(300, 200);
        setLocationRelativeTo(null); // Centraliza a janela no meio da tela

        // Criação do painel principal
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Criação do campo de texto

        this.cpfTextField.setHorizontalAlignment(JTextField.CENTER); // Centraliza o texto
        this.cpfTextField.setPreferredSize(new Dimension(150, 30));

        // Criação do painel de campos
        JPanel fieldsPanel = new JPanel();
        fieldsPanel.setLayout(new FlowLayout());
        fieldsPanel.add(cpfTextField);
        // Criação do painel de botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(this.enviarButton);
        buttonPanel.add(this.limparButton);
        // Adiciona o painel de campos e o painel de botões ao painel principal
        panel.add(fieldsPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Adiciona o painel à janela
        getContentPane().add(panel);
        this.actionEnviar.setField(this.cpfTextField);
        this.actionEnviar.setRetorno(campoCPF);
        this.enviarButton.addActionListener(this.actionEnviar);
        this.actionLimpar.setField(cpfTextField);
        this.limparButton.addActionListener(this.actionLimpar);


        setVisible(true);
    }



    public void  abrirTelaCpf(){
        SwingUtilities.invokeLater(() -> {
            new TelaCPF();
        });
    }

    public String getCampoCPF() {
        return campoCPF;
    }


}