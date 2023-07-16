import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionBotaoLimpar implements ActionListener {
    private JTextField field;
    @Override
    public void actionPerformed(ActionEvent e) {
        this.field.setText("");
    }

    public JTextField getField() {
        return field;
    }

    public void setField(JTextField field) {
        this.field = field;
    }
}

