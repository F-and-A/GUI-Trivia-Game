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
    static JLabel Title = new JLabel("<html><font color='yellow'>TRIVIA GAME</font></html>");
    static JButton Play = new JButton("Play");
    static JButton Credit = new JButton("Credits");

    static boolean Option = false;

    static JButton Button1 = new JButton();
    static JButton Button2 = new JButton();
    static JButton Button3 = new JButton();
    static JButton Button4 = new JButton();

    static int Correct = 0;
    static int QuestionLevel = 0;

    public static void main(String[] args) throws Exception {
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
                QuestionsScreen();
            }
        });

        //Adds an action listener for drawing the credits. 
        Credit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Option != true) {
                    Option = true;
                    CreditsSreen();
                }
                else {
                    Option = false;
                    Play.setVisible(true);
                    Credit.setText("Credits");
                    Title.setLocation(635, 195);
                    Title.setSize(650, 100);
                    Title.setText("<html><font color='yellow'>TRIVIA GAME</font></html>");
                }
            }
        });
 
        //Action Listener is added to Button 1
        Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Status.setText("Correct!");
                Increse(0);
                QuestionsScreen();
            }
        });

        //Action Listener is added to Button 2
        Button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Status.setText("Wrong!");
                Increse(0);
                QuestionsScreen();
            }
        });
        
        Button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Status.setText("Correct!");
                Increse(0);
                QuestionsScreen();
            }
        });

        Button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Status.setText("Correct!");
                Increse(0);
                QuestionsScreen();
            }
        });

        //Frame is set visible
        Frame.setVisible(true);
    }


    //Draws CreditScreen, removes Play Button
    public static void CreditsSreen() {
        Credit.setText("Back");
        Play.setVisible(false);
        Title.setText("<html>Credits<br>Frank<br>Ashraf<br><html>");
        Title.setLocation(800, 180);
        Title.setSize(350, 325);
    }

    //String arrays for questions and answers
    public static void QuestionsScreen() {
        if (QuestionLevel == 3) {
            EndScreen();
        }

        String[] Questions = {"Qustion 1: Yes or No?", "Qustion 2: No or Yes?", "Question 3: Did you enjoy the game?"};
        String[] Button1Text = {"A: Yes", "A: No", "A: Yes"};
        String[] Button2Text = {"B: No", "B: Yes", "B: Yes"};
        String[] Button3Text = {"", "", "C: Yes"};
        String[] Button4Text = {"", "", "D: Yes"};
        int[] Position = {560, 560, 298};
        int[] Size = {800, 800, 1325};
        
        Title.setFont(new Font("Arial", Font.BOLD, 75));
        Title.setSize(Size[QuestionLevel], 100);
        Title.setLocation(Position[QuestionLevel], 195);

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

    public static void EndScreen() {
        Button1.setVisible(false);
        Button2.setVisible(false);
        Button3.setVisible(false);
        Button4.setVisible(false);
        Title.setLocation(385, 490);
        Title.setSize(1150, 100);
        Title.setFont(new Font("Arial", Font.BOLD, 100));
        Title.setText("You did it!!! ig didn't keep count");
    }

    public static void Increse(int Value) {
        QuestionLevel += 1;
        Correct += Value;
    }
}
