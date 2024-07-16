import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {

    private JTextField display;
    private JButton[] numberButtons;
    private JButton[] functionButtons;
    private JButton addButton, subButton, mulButton, divButton, equButton, clearButton, dotButton, percentButton;
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    public Calculator() {
        setTitle("Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Display
        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        add(display, BorderLayout.NORTH);

        // Number Buttons
        numberButtons = new JButton[10];
        JPanel numberPanel = new JPanel(new GridLayout(4, 3, 5, 5));
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberPanel.add(numberButtons[i]);
        }

        // Function Buttons
        functionButtons = new JButton[8];
        JPanel functionPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        equButton = new JButton("=");
        clearButton = new JButton("C");
        dotButton = new JButton(".");
        percentButton = new JButton("%");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = equButton;
        functionButtons[5] = clearButton;
        functionButtons[6] = dotButton;
        functionButtons[7] = percentButton;

        for (JButton button : functionButtons) {
            button.addActionListener(this);
            functionPanel.add(button);
        }

        // Add Panels
        add(numberPanel, BorderLayout.CENTER);
        add(functionPanel, BorderLayout.EAST);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                display.setText(display.getText() + String.valueOf(i));
            }
        }

        if (e.getSource() == dotButton) {
            if (display.getText().contains(".")) {
                return;
            }
            display.setText(display.getText() + ".");
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '+';
            display.setText("");
        }

        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '-';
            display.setText("");
        }

        if (e.getSource() == mulButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '*';
            display.setText("");
        }

        if (e.getSource() == divButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '/';
            display.setText("");
        }
        if (e.getSource() == equButton) {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    if (num2 == 0) {
                        display.setText("Error");
                        return;
                    }
                    result = num1 / num2;
                    break;
            }
            display.setText(String.valueOf(result));
        }

        if (e.getSource() == clearButton) {
            display.setText("");
        }

        if (e.getSource() == percentButton) {
            num1 = Double.parseDouble(display.getText());
            result = num1 / 100;
            display.setText(String.valueOf(result));
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}