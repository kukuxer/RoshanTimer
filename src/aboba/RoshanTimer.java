package aboba;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class RoshanTimer {
   static boolean  soundPlayed;
   static boolean  soundPlayed2;
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Roshan Timer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 150);

            JPanel panel = new JPanel(new BorderLayout());

            JButton button = createStylishButton("Roshan is dead");
            panel.add(button, BorderLayout.NORTH);

            button.setMnemonic(KeyEvent.VK_EQUALS);
            KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(e -> {
                if (e.getID() == KeyEvent.KEY_TYPED && e.getKeyChar() == '=') {
                    System.out.println("Global key event dispatched.");
                    button.doClick();
                }
                return false;
            });



            VisualTimerPanel visualTimerPanel = new VisualTimerPanel();
            panel.add(visualTimerPanel, BorderLayout.CENTER);

            frame.add(panel);
            frame.setVisible(true);
           // JButton equalsButton = new JButton("=");

            button.addActionListener(e -> {
                button.setVisible(false);
               //  frame.setState(Frame.ICONIFIED);
                visualTimerPanel.startTimers();
            });
        });

    }
    private static JButton createStylishButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(30, 144, 255)); // Dodger Blue
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setBorder(BorderFactory.createEmptyBorder(10, 30, 10, 30));
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(0, 102, 204)); // Darker Dodger Blue on hover
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(30, 144, 255)); // Restore original color on exit
            }
        });
        return button;
    }
}
