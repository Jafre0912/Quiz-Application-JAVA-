package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz_Page extends JFrame implements ActionListener {

    String name;

    String options[][] = new String[20][4];
    String answers[][] = new String[20][2];

    String userAnswers[][] = new String[20][1];

    public static int count = 0;
    public static int timer = 60;
    public static int ansGiven = 0;
    public static int score = 0;

    JLabel queno, question;

    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup buttonGroup;
    JButton next, clear;
    ImageIcon[] images;

    public Quiz_Page(String name) {
        this.name = name;
        setTitle("Quiz App");

        ImageIcon icon = new ImageIcon(getClass().getResource("/Icons/quiz.png"));
        setIconImage(icon.getImage());

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        setSize(screenWidth, screenHeight);
        setResizable(false);

        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);

        JLabel heading = new JLabel("Welcome " + name + " to Growing Minds");
        heading.setBounds(550, 60, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 25));
        heading.setForeground(new Color(3, 132, 252));
        add(heading);

        JLabel que = new JLabel("Choose the correct name for the image shown below");
        que.setBounds(500, 100, 720, 50);
        que.setFont(new Font("serif", Font.BOLD, 25));
        add(que);

        queno = new JLabel();
        queno.setBounds(200, 300, 50, 30);
        queno.setFont(new Font("serif", Font.BOLD, 25));
        add(queno);

        question = new JLabel();
        question.setBounds(250, 150, 400, 300);
        question.setFont(new Font("serif", Font.PLAIN, 25));
        add(question);

        images = new ImageIcon[20];
        images[0] = new ImageIcon(getClass().getResource("/Images/apple.jpg"));
        images[1] = new ImageIcon(getClass().getResource("/Images/banana.jpg"));

        images[2] = new ImageIcon(getClass().getResource("/Images/cake.jpg"));
        images[3] = new ImageIcon(getClass().getResource("/Images/duck.jpg"));

        images[4] = new ImageIcon(getClass().getResource("/Images/elephant.jpg"));
        images[5] = new ImageIcon(getClass().getResource("/Images/fish.jpeg"));

        images[6] = new ImageIcon(getClass().getResource("/Images/grapes.png"));
        images[7] = new ImageIcon(getClass().getResource("/Images/horse.jpg"));

        images[8] = new ImageIcon(getClass().getResource("/Images/ice_cream.jpg"));
        images[9] = new ImageIcon(getClass().getResource("/Images/jungle.jpg"));

        images[10] = new ImageIcon(getClass().getResource("/Images/kids.png"));
        images[11] = new ImageIcon(getClass().getResource("/Images/leaf.jpeg"));

        images[12] = new ImageIcon(getClass().getResource("/Images/monkey.jpg"));
        images[13] = new ImageIcon(getClass().getResource("/Images/newspaper.jpg"));

        images[14] = new ImageIcon(getClass().getResource("/Images/orange.jpg"));
        images[15] = new ImageIcon(getClass().getResource("/Images/peacock.jpg"));

        images[16] = new ImageIcon(getClass().getResource("/Images/queen.png"));
        images[17] = new ImageIcon(getClass().getResource("/Images/rabbit.jpg"));

        images[18] = new ImageIcon(getClass().getResource("/Images/sunflower.jpeg"));
        images[19] = new ImageIcon(getClass().getResource("/Images/train.jpg"));

        int width = 250;
        int height = 250;

        for (int i = 0; i < images.length; i++) {
            Image image = images[i].getImage();
            Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            images[i] = new ImageIcon(scaledImage);
        }

        // Options for Apple
        options[0][0] = "Apple";
        options[0][1] = "Aple";
        options[0][2] = "Aplle";
        options[0][3] = "Applle";

        // Options for Banana
        options[1][0] = "Bannana";
        options[1][1] = "Banana";
        options[1][2] = "Baanana";
        options[1][3] = "Bananaa";

        // Options for Cake
        options[2][0] = "Caake";
        options[2][1] = "Ckae";
        options[2][2] = "Cak";
        options[2][3] = "Cake";

        // Options for Duck
        options[3][0] = "Duk";
        options[3][1] = "Duck";
        options[3][2] = "Dukc";
        options[3][3] = "Dukck";

        // Options for Elephant
        options[4][0] = "Elephnat";
        options[4][1] = "Elephnt";
        options[4][2] = "Elaephant";
        options[4][3] = "Elephant";

        // Options for Fish
        options[5][0] = "Fiish";
        options[5][1] = "Fsh";
        options[5][2] = "Fish";
        options[5][3] = "Fissh";

        // Options for Grapes
        options[6][0] = "Grpaes";
        options[6][1] = "Graps";
        options[6][2] = "Grapes";
        options[6][3] = "Grapess";

        // Options for Horse
        options[7][0] = "Hors";
        options[7][1] = "Horse";
        options[7][2] = "Hrse";
        options[7][3] = "Horsee";

        // Options for Ice Cream
        options[8][0] = "Ice Creame";
        options[8][1] = "Ice Creem";
        options[8][2] = "Ice Crem";
        options[8][3] = "Ice Cream";

        // Options for Jungle
        options[9][0] = "Jungle";
        options[9][1] = "Jugle";
        options[9][2] = "Junlge";
        options[9][3] = "Jungel";

        // Options for kids
        options[10][0] = "Kids";
        options[10][1] = "Kdis";
        options[10][2] = "Kidss";
        options[10][3] = "Kisd";

        // Options for Leaf
        options[11][0] = "Leave";
        options[11][1] = "Leeaf";
        options[11][2] = "Leaf";
        options[11][3] = "Laef";

        // Options for monkey
        options[12][0] = "Moneky";
        options[12][1] = "Monkey";
        options[12][2] = "Monkye";
        options[12][3] = "Monkeey";

        // Options for newspaper
        options[13][0] = "News Paaper";
        options[13][1] = "New Paper";
        options[13][2] = "Newss Paper";
        options[13][3] = "News Paper";

        // Options for orange
        options[14][0] = "Oarange";
        options[14][1] = "Ornage";
        options[14][2] = "Orange";
        options[14][3] = "Oraneg";

        // Options for peacock
        options[15][0] = "Peacock";
        options[15][1] = "Pecock";
        options[15][2] = "Paecock";
        options[15][3] = "Peacok";

        // Options for queen
        options[16][0] = "Queen";
        options[16][1] = "Quuen";
        options[16][2] = "Qeueen";
        options[16][3] = "Queene";

        // Options for rabbit
        options[17][0] = "Rabbet";
        options[17][1] = "Rabbit";
        options[17][2] = "Rabit";
        options[17][3] = "Rabite";

        // Options for Sun Flower
        options[18][0] = "Sun Flower";
        options[18][1] = "Sun Folwer";
        options[18][2] = "Sun Flowre";
        options[18][3] = "Sunn Flower";

        // Options for Train
        options[19][0] = "Traine";
        options[19][1] = "Trane";
        options[19][2] = "Train";
        options[19][3] = "Tranei";

        answers[0][1] = "Apple";
        answers[1][1] = "Banana";
        answers[2][1] = "Cake";
        answers[3][1] = "Duck";
        answers[4][1] = "Elephant";
        answers[5][1] = "Fish";
        answers[6][1] = "Grapes";
        answers[7][1] = "Horse";
        answers[8][1] = "Ice Cream";
        answers[9][1] = "Jungle";
        answers[10][1] = "Kids";
        answers[11][1] = "Leaf";
        answers[12][1] = "Monkey";
        answers[13][1] = "News Paper";
        answers[14][1] = "Orange";
        answers[15][1] = "Peacock";
        answers[16][1] = "Queen";
        answers[17][1] = "Rabbit";
        answers[18][1] = "Sun Flower";
        answers[19][1] = "Train";
        

        opt1 = new JRadioButton();
        opt1.setBounds(200, 450, 300, 50);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(550, 450, 300, 50);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(200, 550, 300, 50);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(550, 550, 300, 50);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(opt1);
        buttonGroup.add(opt2);
        buttonGroup.add(opt3);
        buttonGroup.add(opt4);

        next = new JButton("Next");
        next.setBounds(1100, 600, 120, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 20));
        next.setBackground(new Color(3, 132, 252));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        clear = new JButton("Clear");
        clear.setBounds(900, 600, 120, 40);
        clear.setFont(new Font("Tahoma", Font.PLAIN, 20));
        clear.setBackground(new Color(3, 132, 252));
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        startQuiz(count);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == next) {
            repaint();

            ansGiven = 1;

            if (buttonGroup.getSelection() == null) {
                userAnswers[count][0] = "";
            }

            else {
                userAnswers[count][0] = buttonGroup.getSelection().getActionCommand();
            }

            if (count == options.length - 2) {
                next.setText("Submit");

                next.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (next.getText().equals("Submit")) {
                    
                            ansGiven = 1;

                            if (buttonGroup.getSelection() == null) {
                                userAnswers[count][0] = "";
                            }

                            else {
                                userAnswers[count][0] = buttonGroup.getSelection().getActionCommand();
                            }

                            for (int i = 0; i < userAnswers.length; i++) {
                                if (userAnswers[i][0].equals(answers[i][1])) {
                                    score += 10;
                                }

                                else if (userAnswers[i][0] == "") {
                                    score += 0;
                                }

                                else {
                                    score -= 5;
                                }
                            }

                            setVisible(false);
                            new Result(name, score);

                            System.out.println("Submit button clicked!");
                        }
                    }
                });
            }

            count++;
            startQuiz(count);
        }

        else if (ae.getSource() == clear) {
            buttonGroup.clearSelection();
        }

    }

    public void paint(Graphics g) {
        super.paint(g);

        String timeLeft = "Time left - " + timer + " seconds";
        g.setColor(Color.RED);
        g.setFont(new Font("Tahoma", Font.PLAIN, 15));

        if (timer > 0) {
            g.drawString(timeLeft, 570, 450);
        }
        timer--;

        try {
            Thread.sleep(1000);
            repaint();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ansGiven == 1) {
            ansGiven = 0;
            timer = 60;
        }

        else if (timer < 0) {
            timer = 60;

            if (count == options.length - 2) {
                next.setText("Submit");

                next.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (next.getText().equals("Submit")) {
                            ansGiven = 1;

                            if (buttonGroup.getSelection() == null) {
                                userAnswers[count][0] = "";
                            }

                            else {
                                userAnswers[count][0] = buttonGroup.getSelection().getActionCommand();
                            }

                            for (int i = 0; i < userAnswers.length; i++) {
                                if (userAnswers[i][0].equals(answers[i][1])) {
                                    score += 10;
                                }

                                else if (userAnswers[i][0] == "") {
                                    score += 0;
                                }

                                else {
                                    score -= 5;
                                }
                            }

                            setVisible(false);
                            new Result(name, score);

                            // System.out.println("Submit button clicked!");
                        }
                    }
                });
            }

            // sumbit button case
            if (count == options.length - 1) {

                if (buttonGroup.getSelection() == null) {
                    userAnswers[count][0] = "";
                }

                else {
                    userAnswers[count][0] = buttonGroup.getSelection().getActionCommand();
                }

                for (int i = 0; i < userAnswers.length; i++) {
                    if (userAnswers[i][0].equals(answers[i][1])) {
                        score += 10;
                    }

                    else if (userAnswers[i][0] == "") {
                        score += 0;
                    }

                    else {
                        score -= 5;
                    }
                }

                setVisible(false);
                new Result(name, score);

            }

            else {

                if (buttonGroup.getSelection() == null) {
                    userAnswers[count][0] = "";
                }

                else {
                    userAnswers[count][0] = buttonGroup.getSelection().getActionCommand();
                }

                count++;
                startQuiz(count);
            }
        }

    }

    public void startQuiz(int count) {

        queno.setText("" + (count + 1) + ".");
        question.setIcon(images[count]);

        opt1.setText(options[count][0]);
        opt1.setActionCommand(options[count][0]);

        opt2.setText(options[count][1]);
        opt2.setActionCommand(options[count][1]);

        opt3.setText(options[count][2]);
        opt3.setActionCommand(options[count][2]);

        opt4.setText(options[count][3]);
        opt4.setActionCommand(options[count][3]);

        buttonGroup.clearSelection();

    }

    public static void main(String[] amk) {

        new Quiz_Page("");

    }
}

