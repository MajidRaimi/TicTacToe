import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MyFrame extends JFrame {

    private final ArrayList<JButton> jButtons = new ArrayList<JButton>();
    private final Handler handler = new Handler();
    int counter = 0;

    MyFrame() {

        setLayout(new GridLayout(3, 3, 5, 5));

        for (int i = 0; i < 9; i++) {

            JButton mainButton = new JButton();
            mainButton.setFocusable(false);
            mainButton.addActionListener(handler);
            mainButton.setBackground(Color.lightGray);
            jButtons.add(mainButton);

        }

        for (int i = 0; i < jButtons.size(); i++) {
            add(jButtons.get(i));
        }

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

    }

    private class Handler implements ActionListener {

        boolean isX = true;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jButtons.get(0)) {
                checkButton(0);
            }
            if (e.getSource() == jButtons.get(1)) {
                checkButton(1);
            }
            if (e.getSource() == jButtons.get(2)) {
                checkButton(2);
            }
            if (e.getSource() == jButtons.get(3)) {
                checkButton(3);
            }
            if (e.getSource() == jButtons.get(4)) {
                checkButton(4);
            }
            if (e.getSource() == jButtons.get(5)) {
                checkButton(5);
            }
            if (e.getSource() == jButtons.get(6)) {
                checkButton(6);
            }
            if (e.getSource() == jButtons.get(7)) {
                checkButton(7);
            }
            if (e.getSource() == jButtons.get(8)) {
                checkButton(8);
            }

            if (counter < 8) {
                counter++;
                if (checkBlue(0) && checkBlue(1) && checkBlue(2)) {
                    whoWon(1);
                }
                if (checkBlue(3) && checkBlue(4) && checkBlue(5)) {
                    whoWon(1);
                }
                if (checkBlue(6) && checkBlue(7) && checkBlue(8)) {
                    whoWon(1);
                }
                if (checkBlue(0) && checkBlue(3) && checkBlue(6)) {
                    whoWon(1);
                }
                if (checkBlue(1) && checkBlue(4) && checkBlue(7)) {
                    whoWon(1);
                }
                if (checkBlue(2) && checkBlue(5) && checkBlue(8)) {
                    whoWon(1);
                }
                if (checkBlue(0) && checkBlue(4) && checkBlue(8)) {
                    whoWon(1);
                }
                if (checkBlue(2) && checkBlue(4) && checkBlue(6)) {
                    whoWon(1);
                }

                if (checkGreen(0) && checkGreen(1) && checkGreen(2)) {
                    whoWon(0);
                }
                if (checkGreen(3) && checkGreen(4) && checkGreen(5)) {
                    whoWon(0);
                }
                if (checkGreen(6) && checkGreen(7) && checkGreen(8)) {
                    whoWon(0);
                }
                if (checkGreen(0) && checkGreen(3) && checkGreen(6)) {
                    whoWon(0);
                }
                if (checkGreen(1) && checkGreen(4) && checkGreen(7)) {
                    whoWon(0);
                }
                if (checkGreen(2) && checkGreen(5) && checkGreen(8)) {
                    whoWon(0);
                }
                if (checkGreen(0) && checkGreen(4) && checkGreen(8)) {
                    whoWon(0);
                }
                if (checkGreen(2) && checkGreen(4) && checkGreen(6)) {
                    whoWon(0);
                }

            } else {
                JOptionPane.showMessageDialog(null, "No One Won The Game", "Draw", JOptionPane.PLAIN_MESSAGE);
                dispose();
                new MyFrame();
            }

        }

        public void whoWon(int who) {
            JOptionPane.showMessageDialog(null, ((who == 0) ? "Green" : "Blue") + " Kirby Won The Game",
                    "You Won The Game", JOptionPane.PLAIN_MESSAGE);
            dispose();
            new MyFrame();
        }

        public boolean checkGreen(int index) {
            return (jButtons.get(index).getDisabledIcon() + "").contains("greenKirby.png");
        }

        public boolean checkBlue(int index) {
            return (jButtons.get(index).getDisabledIcon() + "").contains("blueKirby.png");
        }

        public void checkButton(int index) {

            jButtons.get(index).setLayout(new BorderLayout());

            JLabel sign = new JLabel();
            Icon icon;

            if (isX) {
                icon = new ImageIcon(getClass().getResource("greenKirby.png"));
            } else {
                icon = new ImageIcon(getClass().getResource("blueKirby.png"));
            }

            jButtons.get(index).setDisabledIcon(icon);
            jButtons.get(index).setIcon(icon);
            jButtons.get(index).setEnabled(false);

            isX = !isX;
        }

    }

}
