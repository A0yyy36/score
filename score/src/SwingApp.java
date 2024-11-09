import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SwingApp extends JFrame {

    private JTextField textField;
    private JButton saveButton;

    public SwingApp(String title) {
        // フレームの設定
        super(title);
        setBounds(100, 100, 400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // テキストフィールドの作成
        textField = new JTextField(20);

        // ボタンの作成
        saveButton = new JButton("保存");

        // パネルにコンポーネントを追加
        JPanel panel = new JPanel();
        panel.add(new JLabel("テキストを入力してください:"));
        panel.add(textField);
        panel.add(saveButton);

        // コンテントペインにパネルを追加
        Container contentPane = getContentPane();
        contentPane.add(panel, BorderLayout.CENTER);

        // ボタンのアクションリスナーを設定
        saveButton.addActionListener(new SaveButtonListener());
    }

    // ボタンがクリックされたときの処理
    class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String text = textField.getText();
            if (!text.isEmpty()) {
                saveToFile(text);
            } else {
                JOptionPane.showMessageDialog(SwingApp.this, "テキストフィールドが空です。");
            }
        }
    }

    // テキストをファイルに保存するメソッド
    private void saveToFile(String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt", true))) {
            writer.write(text);
            writer.newLine();
            JOptionPane.showMessageDialog(this, "テキストが output.txt に保存されました。");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "ファイルの保存に失敗しました: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SwingApp app = new SwingApp("テキスト保存アプリ");
            app.setVisible(true);
        });
    }
}
