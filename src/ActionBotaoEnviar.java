import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionBotaoEnviar implements ActionListener {
    private JTextField field;
    private String retorno = "";
    @Override
    public void actionPerformed(ActionEvent e) {
      this.retorno = this.field.getText();
        System.out.println(this.retorno);
    }

    public JTextField getField() {
        return field;
    }

    public void setField(JTextField field) {
        this.field = field;
    }

    public String getRetorno() {
        return retorno;
    }

    public void setRetorno(String retorno) {
        this.retorno = retorno;
    }
}
