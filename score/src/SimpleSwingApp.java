import javax.swing.*;

public class SimpleSwingApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Simple Swing App");
            frame.setSize(300, 200);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel label = new JLabel("Hello, Swing!");
            frame.getContentPane().add(label);

            frame.setVisible(true);
        });
    }
}