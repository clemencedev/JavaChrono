/**
 * @author clemencedev
 * @version 1.0.0
 * @since 1.0.0
 */

package clemencedev.javachrono.window;

// Import the events for the resize listener
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
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
        // Create the frame
        jf = new JFrame(title);

        // Import and implement the graphics class
        Graphics g = new Graphics();
        jf.setContentPane(g);
        jf.pack();

        // Set the frame parameters
        jf.setSize(height, width);
        jf.setResizable(true);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

        // Size all the graphics items
        g.resizeGraphicsItems(height, width);

        // Add a resize listener
        jf.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent event) {
                g.resizeGraphicsItems(jf.getWidth(), jf.getHeight());
            }
        });
    }
}
