/**
 * @author clemencedev
 * @version 1.0.0
 * @since 1.0.0
 */

package clemencedev.javachrono.window;

// Import the required swing and awt libraries
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Graphics extends JPanel {

    // GUI elements
    public static JLabel chronoLabel;
    public static JLabel chronoMillisLabel;
    public static JButton resetButton;
    public static JButton startstopButton;

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

        // Adding the elements to the frame
        this.setLayout(null);
        this.add(chronoLabel);
        this.add(chronoMillisLabel);
        this.add(resetButton);
        this.add(startstopButton);
    }
}
