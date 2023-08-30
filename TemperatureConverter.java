import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureConverter extends JFrame {
    private JTextField inputField;
    private JLabel resultLabel;
    private JComboBox<String> conversionType;

    public TemperatureConverter() {
        setTitle("Temperature Converter");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new GridLayout(4, 1));

        inputField = new JTextField();
        resultLabel = new JLabel("Result: ");
        conversionType = new JComboBox<>(new String[]{"Celsius", "Fahrenheit", "Kelvin"});

        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double inputValue = Double.parseDouble(inputField.getText());
                    String selectedConversion = (String) conversionType.getSelectedItem();
                    double result = convertTemperature(inputValue, selectedConversion);
                    resultLabel.setText("Result: " + result);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Invalid input");
                }
            }
        });

        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputField.setText("");
                resultLabel.setText("Result: ");
            }
        });

        mainPanel.add(inputField);
        mainPanel.add(conversionType);
        mainPanel.add(convertButton);
        mainPanel.add(resultLabel);
        mainPanel.add(clearButton);

        add(mainPanel);
    }

    private double convertTemperature(double value, String conversionType) {
        if (conversionType.equals("Celsius")) {
            return value;
        } else if (conversionType.equals("Fahrenheit")) {
            return (value * 9 / 5) + 32;
        } else if (conversionType.equals("Kelvin")) {
            return value + 273.15;
        }
        return 0;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TemperatureConverter().setVisible(true);
            }
        });
    }
}
