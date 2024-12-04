package quiz.application;

import javax.swing.*;
import java.awt.*;

public class Result extends JFrame {

    Result(String name, int score) {

        setTitle("Quiz App");

        ImageIcon icon = new ImageIcon(getClass().getResource("/Icons/quiz.png"));
        setIconImage(icon.getImage());

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        setSize(screenWidth, screenHeight);


        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Thank you " + name + " for writing your test on Growing Minds");
        heading.setBounds(150, 30, 700, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        heading.setForeground(new Color(3, 132, 252));
        add(heading);
        
        JLabel heading1 = new JLabel("Below is the your result, how you have perpormed in the test");
        heading1.setBounds(150, 100, 720, 50);
        heading1.setFont(new Font("serif", Font.BOLD, 25));
        add(heading1);


        JLabel lScore = new JLabel("Your score is " + score + " out of 200.");
        lScore.setFont(new Font("serif", Font.BOLD, 35));
        lScore.setForeground(new Color(3, 132, 252));

        lScore.setBounds(250, 200, 800, 100);
        add(lScore);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        setVisible(true);
        
    }

    
    public static void main(String[] args) {
        new Result("", 0);  
    }
}


// package quiz.application;

// import javax.swing.*;
// import java.awt.*;
// import java.io.FileInputStream;
// import java.io.FileOutputStream;
// import java.io.IOException;
// import java.io.ObjectInputStream;
// import java.io.ObjectOutputStream;
// import java.util.*;
// import java.util.List;

// public class Result extends JFrame {
//     private static Map<String, LinkedList<Integer>> userResults = new HashMap<>();
//     private static final String DATA_FILE = "userResults.dat";

//     Result(String name, int score) {
//         setTitle("Quiz App");

//         ImageIcon icon = new ImageIcon(getClass().getResource("/Icons/quiz.png"));
//         setIconImage(icon.getImage());

//         Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

//         int screenWidth = (int) screenSize.getWidth();
//         int screenHeight = (int) screenSize.getHeight();
//         setSize(screenWidth, screenHeight);

//         setLocationRelativeTo(null);
//         setLayout(null);
//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         setResizable(false);

//         getContentPane().setBackground(Color.WHITE);

//         JLabel heading = new JLabel("Thank you " + name + " for writing your test on Growing Minds");
//         heading.setBounds(150, 30, 700, 50);
//         heading.setFont(new Font("serif", Font.BOLD, 25));
//         heading.setForeground(new Color(3, 132, 252));
//         add(heading);

//         JLabel heading1 = new JLabel("Below is the your result, how you have performed in the test");
//         heading1.setBounds(150, 100, 720, 50);
//         heading1.setFont(new Font("serif", Font.BOLD, 25));
//         add(heading1);

//         JLabel lScore = new JLabel("Your score is " + score + " out of 200.");
//         lScore.setFont(new Font("serif", Font.BOLD, 35));
//         lScore.setForeground(new Color(3, 132, 252));

//         lScore.setBounds(250, 200, 800, 100);
//         add(lScore);

//         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//         setVisible(true);

//         // Add the result for this user
//         addResult(name, score);

//         saveResults();

//         // Display the last 10 results for this user
//         JTextArea resultsArea = new JTextArea();
//         resultsArea.setBounds(250, 300, 800, 200);
//         resultsArea.setEditable(false);
//         List<Integer> results = getResults(name);
//         for (Integer result : results) {
//             resultsArea.append(result + "\n");
//         }
//         add(resultsArea);
//     }

//     private static void addResult(String username, int result) {
        
//         LinkedList<Integer> results = userResults.get(username);
//         if (results == null) {
//             // This user has not taken a quiz before
//             results = new LinkedList<>();
//             userResults.put(username, results);
//         }

//         if (results.size() == 10) {
//             // If the user already has 10 results, remove the oldest one
//             results.removeFirst();
//         }

//         // Add the new result
//         results.add(result);
//     }

//     public static List<Integer> getResults(String username) {
//         return userResults.get(username);
//     }

//     private static void saveResults() {
//         try {
//             FileOutputStream fos = new FileOutputStream(DATA_FILE);
//             ObjectOutputStream oos = new ObjectOutputStream(fos);
//             oos.writeObject(userResults);
//             oos.close();
//             fos.close();
//         } catch (IOException ioe) {
//             ioe.printStackTrace();
//         }
//     }

//     @SuppressWarnings("unchecked")
//     private static void loadResults() {
//         try {
//             FileInputStream fis = new FileInputStream(DATA_FILE);
//             ObjectInputStream ois = new ObjectInputStream(fis);
//             userResults = (HashMap) ois.readObject();
//             ois.close();
//             fis.close();
//         } catch (IOException ioe) {
//             ioe.printStackTrace();
//         } catch (ClassNotFoundException c) {
//             System.out.println("Class not found");
//             c.printStackTrace();
//         }
//     }

//     public static void main(String[] args) {
//         loadResults();
//         new Result("", 0);  
//     }
// }

