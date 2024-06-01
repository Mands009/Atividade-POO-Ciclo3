import javax.swing.*;
import java.awt.event.*;

public class CalculadoraIMC extends JFrame {
    private JLabel labelPeso, labelAltura, labelResultado;
    private JTextField campoPeso, campoAltura;
    private JButton botaoCalcular;

    public CalculadoraIMC() {
        setTitle("Calculadora de IMC");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        labelPeso = new JLabel("Peso (Kg):");
        labelAltura = new JLabel("Altura (cm):");
        labelResultado = new JLabel();

        campoPeso = new JTextField(10);
        campoAltura = new JTextField(10);

        botaoCalcular = new JButton("Calcular");
        botaoCalcular.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularIMC();
            }
        });

        JPanel painel = new JPanel();
        painel.add(labelPeso);
        painel.add(campoPeso);
        painel.add(labelAltura);
        painel.add(campoAltura);
        painel.add(botaoCalcular);
        painel.add(labelResultado);

        add(painel);
    }

    private void calcularIMC() {
        try {
            double peso = Double.parseDouble(campoPeso.getText());
            double altura = Double.parseDouble(campoAltura.getText()) / 100; // Converter altura para metros
            double imc = peso / (altura * altura);
            String resultadoIMC = "";

            if (imc < 17) {
                resultadoIMC = "Muito abaixo do peso";
            } else if (imc < 18.5) {
                resultadoIMC = "Abaixo do peso";
            } else if (imc < 25) {
                resultadoIMC = "Peso normal";
            } else if (imc < 30) {
                resultadoIMC = "Acima do peso";
            } else if (imc < 35) {
                resultadoIMC = "Obesidade I";
            } else if (imc < 40) {
                resultadoIMC = "Obesidade II (severa)";
            } else {
                resultadoIMC = "Obesidade III (mórbida)";
            }

            labelResultado.setText(String.format("Seu IMC é %.2f\nClassificação: %s", imc, resultadoIMC));
        } catch (NumberFormatException ex) {
            labelResultado.setText("Por favor, insira valores válidos para peso e altura.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CalculadoraIMC().setVisible(true);
            }
        });
    }
}
