package aboba;

import javax.swing.*;
import java.awt.*;

class VisualTimerPanel extends JPanel {
    public VisualTimer timer1;
    public VisualTimer timer2;

    public VisualTimerPanel() {
        setPreferredSize(new Dimension(400, 75));
        setLayout(new GridLayout(1, 2)); // Use GridLayout to divide the panel into two halves

        // Create a visual timer for the first countdown from 11 to 0 (Red)
        timer1 = new VisualTimer(9*60, Color.RED,VisualTimerPanel.this);

        // Create a visual timer for the second countdown from 8 to 0 (Blue)
        timer2 = new VisualTimer(11*60, Color.BLUE,VisualTimerPanel.this);

        // Add visual timers to the panel
        add(timer1.getLabel());
        add(timer2.getLabel());
    }

    public void startTimers() {
        // Start both visual timers
        timer1.startTimer();
        timer2.startTimer();
    }
}
