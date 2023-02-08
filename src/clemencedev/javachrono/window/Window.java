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
     * @param height
     * @param width
     * @param title
     */
    public static void createWindow(int height, int width, String title) {
        jf = new JFrame(title);
        Graphics g = new Graphics();    // Import the graphics class
        jf.setContentPane(g);
        jf.pack();
        jf.setSize(height, width);
        jf.setResizable(true);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
}
