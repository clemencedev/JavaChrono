/**
 * @author clemencedev
 * @version 1.0.0
 * @since 1.0.0
 */

package clemencedev.javachrono.window;

// Import the required swing and awt libraries
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
// Import the required libraries for the timer
import clemencedev.javachrono.chrono.Chrono;
import java.util.Timer;

public class Graphics extends JPanel {

    // GUI elements
    public static JLabel chronoLabel;
    public static JLabel chronoMillisLabel;
    public static JButton resetButton;
    public static JButton startstopButton;
    // Chrono variables
    private Timer timer;
    private boolean isTimerRunning = false;
    // Old time variables
    private int oldHours = 0;
    private int oldMinutes = 0;
    private int oldSeconds = 0;
    private int oldMilliseconds = 0;

    public Graphics() {
        // Label managing the hours, minutes and seconds
        chronoLabel = new JLabel("00:00:00");
        chronoLabel.setFont(new Font("Arial", Font.PLAIN, 128));
        chronoLabel.setBounds(10, 5, 500, 160);

        // Label managing the milliseconds
        chronoMillisLabel = new JLabel("00");
        chronoMillisLabel.setFont(new Font("Arial", Font.PLAIN, 64));
        chronoMillisLabel.setBounds(515, 28, 500, 160);

        // Button to reset the chrono
        resetButton = new JButton("Reset");
        resetButton.setBackground(Color.LIGHT_GRAY);
        resetButton.setEnabled(false);
        resetButton.setFont(new Font("Arial", Font.PLAIN, 32));
        resetButton.setBounds(50, 150, 205, 60);

        // Button to start or stop the chrono
        startstopButton = new JButton("Start");
        startstopButton.setBackground(Color.LIGHT_GRAY);
        startstopButton.setEnabled(true);
        startstopButton.setFont(new Font("Arial", Font.PLAIN, 32));
        startstopButton.setBounds(350, 150, 205, 60);

        // Button action listener
        // Reset button
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                // Reset the variables
                oldHours = 0;
                oldMinutes = 0;
                oldSeconds = 0;
                oldMilliseconds = 0;
                // Reset all the values showed on screen
                chronoLabel.setText("00:00:00");
                chronoMillisLabel.setText("00");
                // Disable the button
                resetButton.setEnabled(false);
            }
        });

        // Start/stop button
        startstopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                // Check if the timer is running
                if(isTimerRunning) {
                    // Get the old values
                    oldHours = Chrono.hours;
                    oldMinutes = Chrono.minutes;
                    oldSeconds = Chrono.seconds;
                    oldMilliseconds = Chrono.milliseconds;
                    // Stop the chrono
                    timer.cancel();
                    isTimerRunning = false;
                    // Modify the buttons status
                    startstopButton.setText("Start");
                    resetButton.setEnabled(true);
                } else {
                    // Create the timer
                    timer = new Timer();
                    // Start the chrono
                    timer.scheduleAtFixedRate(new Chrono(oldHours, oldMinutes, oldSeconds, oldMilliseconds), 0, 10);
                    isTimerRunning = true;
                    // Modify the buttons status
                    startstopButton.setText("Stop");
                    resetButton.setEnabled(false);
                }
            }
        });

        // Adding the elements to the frame
        this.setLayout(null);
        this.add(chronoLabel);
        this.add(chronoMillisLabel);
        this.add(resetButton);
        this.add(startstopButton);
    }
}
