package aboba;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class VisualTimer {
    private int secondsRemaining;
    private JLabel label;
    private Color boxColor;

    VisualTimerPanel visualTimerPanel;
    private Timer timer1;
    //private Timer timer2;

    public VisualTimer(int initialSeconds, Color boxColor,VisualTimerPanel visualTimerPanel) {
        this.secondsRemaining = initialSeconds;
        this.boxColor = boxColor;
        this.label = createTimerLabel();
        this.visualTimerPanel = visualTimerPanel;
        this.timer1 = new Timer(1000, new TimerActionListener());
        //this.timer2 = new Timer(1000, new TimerActionListener());
    }

    public void startTimer() {
        Timer timer = new Timer(1000, new TimerActionListener());
        timer.start();
    }

    public JLabel getLabel() {
        return label;
    }

    private JLabel createTimerLabel() {
        JLabel label = new JLabel(getTimeText());
        label.setFont(new Font("Arial", Font.BOLD, 24));
        label.setForeground(Color.WHITE); // Text color
        label.setHorizontalAlignment(SwingConstants.CENTER);

        // Create a colored box around the label
        label.setOpaque(true);
        label.setBackground(boxColor);

        return label;
    }

    private String getTimeText() {
        return String.format("%02d:%02d", secondsRemaining / 60, secondsRemaining % 60);
    }

    private class TimerActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
          //  System.out.println(visualTimerPanel.timer1.getLabel().getText());
            if(visualTimerPanel.timer1.getLabel().getText().equals("00:01") && !RoshanTimer.soundPlayed){
                String desktopPath = System.getProperty("user.home") + "\\Desktop\\voimyaAllaha.wav";
                SoundPlayer.playSound(desktopPath);
                RoshanTimer.soundPlayed = true;
            }
            if(visualTimerPanel.timer2.getLabel().getText().equals("00:01") && !RoshanTimer.soundPlayed2){
                String desktopPath2 = System.getProperty("user.home") + "\\Desktop\\RovneeRovnogo.wav";
                SoundPlayer.playSound(desktopPath2);
                RoshanTimer.soundPlayed2 = true;
            }
            if  (secondsRemaining > 0) {
                updateTimerDisplay();
                secondsRemaining--;
            } else {
                ((Timer) e.getSource()).stop();
                displayTimeIsUp();
            }
        }

        private void updateTimerDisplay() {
            label.setText(getTimeText());
        }

        private void displayTimeIsUp() {
            label.setText("SLAVA UKRAINE!");
        }
    }
}