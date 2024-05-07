import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame {
    static JFrame Frame = new JFrame("Trivia Game");
    static JLabel Label = new JLabel("<html>TRIVIA GAME<html><br>The Game Where The Answers Just Don't Add Up<br>");
    static JLabel Status = new JLabel();
    static JButton Button1 = new JButton();
    static JButton Button2 = new JButton();
    static JButton Button3 = new JButton();
    static JButton Button4 = new JButton();
    static int Correct = 0;
    static int QuestionLevel = 0;
    public static void main(String[] args) throws Exception {
        Dimension Size = Toolkit.getDefaultToolkit().getScreenSize();

        Frame.setLayout(null);
        Frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        Frame.setSize((int)Size.getWidth(), (int)Size.getHeight());

        Label.setLocation(600, 0);
        Label.setSize(1000, 500);
        Label.setFont(new Font("Arial", Font.BOLD, 30));

        JButton Button = new JButton("Play");
        Button.setLocation(800, 500);
        Button.setSize(300, 200);
        Button.setFont(new Font("Arial", Font.BOLD, 30));
        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Button.setVisible(false);
                Frame.add(Button1);
                Frame.add(Button2);
                Frame.add(Button3);
                Frame.add(Button4);
                Question();
            }
        });

        Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Status.setText("Correct!");
                Increse(1);
                Question();
            }
        });

        Button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Status.setText("Wrong!");
                Increse(0);
                Question();
            }
        });

        Status.setLocation(600, 0);
        Status.setSize(1000, 500);
        Status.setFont(new Font("Arial", Font.BOLD, 50));

        Button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Status.setText("Wrong!");
                Increse(0);
            }
        });
        
        Frame.add(Label);
        Frame.add(Button);
        Frame.add(Status);
        Frame.setVisible(true);
    }

    public static void Question() {

        String[] Questions = {"Qustion 1: Yes or No", "Qustion 2: No or Yes", "Question 3: CHEESSE", "Question 4: FAFAF", "Qustion 5: SADSADA"};
        String[] Button1Text = {"Yes", "No", "CHEESSE", "FAFAF", "SADSADA"};
        String[] Button2Text = {"No", "Yes", "CHEESSE", "IDK", "what"};

        System.out.print(QuestionLevel);

        Label.setText(Questions[QuestionLevel]);

        Button1.setText(Button1Text[QuestionLevel]);
        Button1.setLocation(600, 500);
        Button1.setSize(300, 200);
        Button1.setFont(new Font("Arial", Font.BOLD, 30));

        Button2.setText(Button2Text[QuestionLevel]);
        Button2.setLocation(1200, 500);
        Button2.setSize(300, 200);
        Button2.setFont(new Font("Arial", Font.BOLD, 30));
    }

    public static void Increse(int Value) {
        QuestionLevel += 1;
        Correct += Value;
    }
}
