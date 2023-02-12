/**
 * @author clemencedev
 * @version 1.0.0
 * @since 1.0.0
 */

package clemencedev.javachrono.window;

// Import the swing libraries
import javax.swing.JFrame;

public class Window {

    // Create the window variables
    private static JFrame jf;

    /**
     * Create the main program window
     * @param width
     * @param height
     * @param title
     */
    public static void createWindow(int width, int height, String title) {
        // Create the frame
        jf = new JFrame(title);

        // Import and implement the graphics class
        Graphics g = new Graphics();
        jf.setContentPane(g);
        jf.pack();

        // Set the frame parameters
        jf.setSize(width, height);
        jf.setResizable(false);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
}
