// Imports Java Swing library
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

//Imports Java AWT Library
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Extends JFrame, then creates its components
public class App extends JFrame {
    static Dimension Size = Toolkit.getDefaultToolkit().getScreenSize();

    static JFrame Frame = new JFrame("Trivia Game");
    static JLabel Title = new JLabel("TRIVIA GAME");
    static JButton Play = new JButton("Play");
    static JButton Credit = new JButton("Credit");

    static JLabel Status = new JLabel();
    static JButton Button1 = new JButton();
    static JButton Button2 = new JButton();
    static JButton Button3 = new JButton();
    static JButton Button4 = new JButton();
    static int Correct = 0;
    static int QuestionLevel = 0;
    public static void main(String[] args) throws Exception {

        //Adds an action listener for drawing the credits. 
        Credit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CreditSreen();
            }
        });

        //Sets up the frame and its components
        Frame.setLayout(null);
        Frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        Frame.setSize((int)Size.getWidth(), (int)Size.getHeight());
        Frame.getContentPane().setBackground(new java.awt.Color(17,95,244));

        //Adds a title to the Frame and sets its size, font, and location
        Title.setLocation(635, 195);
        Title.setSize(650, 100);
        Title.setFont(new Font("Arial", Font.BOLD, 100));
        Frame.add(Title);

        //Adds in the play button, sets size, font and location
        Play.setLocation(710, 490);
        Play.setSize(500, 100);
        Play.setFont(new Font("Arial", Font.BOLD, 50));
        Frame.add(Play);

        //Adds a credits button, sets Location, Size, and Font.
        Credit.setLocation(710, 690);
        Credit.setSize(500, 100);
        Credit.setFont(new Font("Arial", Font.BOLD, 50));
        Frame.add(Credit);

        //Action Listener is added to the play button.
        Play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Play.setVisible(false);
                Credit.setVisible(false);
                Frame.add(Button1);
                Frame.add(Button2);
                Frame.add(Button3);
                Frame.add(Button4);
                Question();
            }
        });

        //Action Listener is added to Button 1
        Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Status.setText("Correct!");
                Increse(1);
                Question();
            }
        });

        //Action Listener is added to Button 2
        Button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Status.setText("Wrong!");
                Increse(0);
                Question();
            }
        });
        
        //Frame is set visible
        Frame.setVisible(true);
    }


    //Draws CreditScreen, removes Play Button
    public static void CreditSreen() {

        Play.setVisible(false);
        Title.setText("<html>Credits<br>Frank<br>Ashraf<br><html>");
        Title.setLocation(785, 83);
        Title.setSize(350, 325);
    }

    //String arrays for questions and answers
    public static void Question() {

        String[] Questions = {"Qustion 1: Yes or No", "Qustion 2: No or Yes", "Question 3: CHEESSE"};
        String[] Button1Text = {"A: Yes", "A: No", "A: CHEESSE"};
        String[] Button2Text = {"B: No", "B: Yes", "B: CHEESSE"};
        String[] Button3Text = {"", "", "CHEESSE"};
        String[] Button4Text = {"", "", "CHEESSE"};
        
        Title.setLocation(710, 250);

        if (Button3Text[QuestionLevel] == "")
            Button3.setVisible(false);
        else
            Button3.setVisible(true);

        if (Button4Text[QuestionLevel] == "")
            Button4.setVisible(false);
        else
            Button4.setVisible(true);

        Title.setText(Questions[QuestionLevel]);

        Button1.setText(Button1Text[QuestionLevel]);
        Button1.setLocation(100, 490);
        Button1.setSize(800, 100);
        Button1.setFont(new Font("Arial", Font.BOLD, 50));

        Button2.setText(Button2Text[QuestionLevel]);
        Button2.setLocation(1020, 490);
        Button2.setSize(800, 100);
        Button2.setFont(new Font("Arial", Font.BOLD, 50));

        Button3.setText(Button3Text[QuestionLevel]);
        Button3.setLocation(100, 690);
        Button3.setSize(800, 100);
        Button3.setFont(new Font("Arial", Font.BOLD, 50));

        Button4.setText(Button4Text[QuestionLevel]);
        Button4.setLocation(1020, 690);
        Button4.setSize(800, 100);
        Button4.setFont(new Font("Arial", Font.BOLD, 50));
    }

    public static void Increse(int Value) {
        QuestionLevel += 1;
        Correct += Value;
    }
}
