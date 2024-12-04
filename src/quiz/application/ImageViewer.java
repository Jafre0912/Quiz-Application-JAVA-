package quiz.application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImageViewer extends JFrame {

    private ImageIcon[] images;
    private int currentIndex;
    private JLabel imageLabel;

    public ImageViewer() {
        super("Image Viewer");

        // Initialize the array of images
        images = new ImageIcon[2];
        images[0] = new ImageIcon(getClass().getResource("/Icons/login_page_quiz.png"));
        images[1] = new ImageIcon(getClass().getResource("/Icons/quiz.png"));

        // Initialize the image label
        imageLabel = new JLabel(images[0]);

        // Create buttons for navigation
        JButton prevButton = new JButton("Previous");
        JButton nextButton = new JButton("Next");

        // Set event handlers for the buttons
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPreviousImage();
            }
        });

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showNextImage();
            }
        });

        // Arrange components in a JPanel
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(imageLabel, BorderLayout.CENTER);
        panel.add(prevButton, BorderLayout.WEST);
        panel.add(nextButton, BorderLayout.EAST);

        // Set up the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        add(panel);
        setVisible(true);
    }

    private void showPreviousImage() {
        currentIndex = (currentIndex - 1 + images.length) % images.length;
        imageLabel.setIcon(images[currentIndex]);
    }

    // private void showNextImage() {
    //     currentIndex = (currentIndex + 1) % images.length;
    //     imageLabel.setIcon(images[currentIndex]);
    // }

    private void showNextImage() {
        currentIndex = (currentIndex + 1) % images.length;
        System.out.println("Next Image Index: " + currentIndex);
        imageLabel.setIcon(images[currentIndex]);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ImageViewer();
            }
        });
    }
}
