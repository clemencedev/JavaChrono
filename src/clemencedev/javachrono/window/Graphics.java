/**
 * @author clemencedev
 * @version 1.0.0
 * @since 1.0.0
 */

package clemencedev.javachrono.window;

// Import the required swing and awt libraries
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Graphics extends JPanel {

    // GUI elements
    private JLabel chronoLabel;
    private JLabel chronoMillisLabel;

    public Graphics() {
        chronoLabel = new JLabel("00:00:00");
        chronoLabel.setFont(new Font("Arial", Font.PLAIN, 128));
        chronoLabel.setBounds(20, 5, 500, 160);

        chronoMillisLabel = new JLabel("00");
        chronoMillisLabel.setFont(new Font("Arial", Font.PLAIN, 64));
        chronoMillisLabel.setBounds(525, 28, 500, 160);

        this.setLayout(null);
        this.add(chronoLabel);
        this.add(chronoMillisLabel);
    }
}
