package GUI;
import javax.swing.*;
import java.awt.*;
import Model.*;
import Logic.*;

import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame{
    private JPanel mainPanel = new JPanel();
    private JPanel panel1 = new JPanel();
    private JPanel panel2 = new JPanel();
    private JPanel panel3 = new JPanel();
    private JPanel panel4 = new JPanel();
    private JPanel panel5 = new JPanel();
    private JPanel panel6 = new JPanel();
    private JPanel panel7 = new JPanel();
    private Font font1 = new Font("SansSerif", Font.BOLD, 15);

    private JLabel label1 = new JLabel("Primul polinom:");
    private JLabel label2 = new JLabel("Al doilea polinom:");
    private JLabel label3 = new JLabel("Rezultat");

    private JTextField text1 = new JTextField(40);
    private JTextField text2 = new JTextField(40);
    private JTextField text3 = new JTextField(40);

    private JButton btn1 = new JButton("Adunare  ");
    private JButton btn2 = new JButton("Scadere  ");
    private JButton btn3 = new JButton("Inmultire ");
    private JButton btn4 = new JButton("Impartire");
    private JButton btn5 = new JButton("Derivare ");
    private JButton btn6 = new JButton("Integrare");
    private JButton btn7 = new JButton("Exemplu");

    private Controller controller = new Controller(this);

    public View(String name) {
        super(name);
        this.prepareGui();
    }

    public void prepareGui(){
        this.setSize(520, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
        this.preparePanels();
        this.setContentPane(this.mainPanel);
    }

    public void preparePanels()
    {
        this.btn1.setActionCommand("Adunare");
        this.btn1.addActionListener(this.controller);
        this.btn2.setActionCommand("Scadere");
        this.btn2.addActionListener(this.controller);
        this.btn3.setActionCommand("Inmultire");
        this.btn3.addActionListener(this.controller);
        this.btn4.setActionCommand("Impartire");
        this.btn4.addActionListener(this.controller);
        this.btn5.setActionCommand("Derivare");
        this.btn5.addActionListener(this.controller);
        this.btn6.setActionCommand("Integrare");
        this.btn6.addActionListener(this.controller);
        this.btn7.setActionCommand("Exemplu");
        this.btn7.addActionListener(this.controller);

        this.text3.setEditable(false);
        this.text3.setFont(font1);

        panel1.setLayout(new FlowLayout());
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        panel4.setLayout(new BoxLayout(panel4, BoxLayout.X_AXIS));
        panel5.setLayout(new BoxLayout(panel5, BoxLayout.Y_AXIS));
        panel6.setLayout(new BoxLayout(panel6, BoxLayout.Y_AXIS));
        panel7.setLayout(new BoxLayout(panel7, BoxLayout.Y_AXIS));

        panel2.add(label1);
        panel2.add(text1);
        panel3.add(label2);
        panel3.add(text2);

        panel5.add(btn1);
        panel5.add(btn2);
        panel5.add(btn3);

        panel6.add(btn4);
        panel6.add(btn5);
        panel6.add(btn6);

        panel4.add(panel5);
        panel4.add(panel6);

        panel7.add(label3);
        panel7.add(text3);

        panel1.add(panel2);
        panel1.add(panel3);
        panel1.add(panel4);
        panel1.add(panel7);
        panel1.add(btn7);
        mainPanel.add(panel1);
    }

    public JTextField getFirstPolinom() {
        return text1;
    }

    public JTextField getSecondPolinom() {
        return text2;
    }

    public JTextField getResult() {
        return text3;
    }

    public void ClearResult(){
        this.text3.setText("");
    }
}
