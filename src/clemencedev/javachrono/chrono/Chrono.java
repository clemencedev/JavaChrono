/**
 * @author clemencedev
 * @version 1.0.0
 * @since 1.0.0
 */

package clemencedev.javachrono.chrono;

// Import the graphics class
import clemencedev.javachrono.window.Graphics;
// Import the timer class
import java.util.TimerTask;

public class Chrono extends TimerTask {

    // Variables for the chrono
    public static int hours;
    public static int minutes;
    public static int seconds;
    public static int milliseconds;

    // Variables for the labels
    private boolean hasSecondsChanged = false;
    private boolean hasMinutesChanged = false;
    private boolean hasHoursChanged = false;

    // Get the old time
    public Chrono(int oldHours, int oldMinutes, int oldSeconds, int oldMilliseconds) {
        hours = oldHours;
        minutes = oldMinutes;
        seconds = oldSeconds;
        milliseconds = oldMilliseconds;
    }

    @Override
    public void run() {
        // Add 10 ms everytime
        milliseconds = milliseconds + 1;
    
        // Check if 1000ms has passed
        if(milliseconds >= 100) {
            milliseconds = 0;
            seconds++;
            hasSecondsChanged = true;
            
            // Check if 60sec has passed
            if(seconds >= 60) {
                seconds = 0;
                minutes++;
                hasMinutesChanged = true;

                // Check if 60min has passed
                if(minutes >= 60) {
                    minutes = 0;
                    hours++;
                    hasHoursChanged = true;
                }
            }
        } else {
            // Set the label text
            // Milliseconds
            String millisecondsText = "";

            // Check if there is a need to add another zero in the text
            if(milliseconds < 10) {
                millisecondsText = "0" + milliseconds;
            } else {
                millisecondsText = milliseconds + "";
            }

            Graphics.chronoMillisLabel.setText(millisecondsText);
        }

        // Modify the label text
        // Get the current label text to modify
        String currentLabelText = Graphics.chronoLabel.getText();
        
        // Check if seconds had changed
        if(hasSecondsChanged) {
            StringBuilder stringBuilder = new StringBuilder(currentLabelText);

            // Check if there is a need to add another zero in the text
            if(seconds == 0) {
                stringBuilder.insert(5, "00");
                stringBuilder.delete(8, stringBuilder.length());
            } else if(seconds < 10) {
                stringBuilder.insert(6, "0" + seconds);
                stringBuilder.delete(8, stringBuilder.length());
            } else {
                stringBuilder.insert(6, seconds);
                stringBuilder.delete(8, stringBuilder.length());
            }

            // Check if minutes has changed
            if(hasMinutesChanged) {
                // Check if there is a need to add another zero in the text
                if(minutes == 0) {
                    stringBuilder.insert(3, "00");
                    stringBuilder.delete(5, 7);
                } else if(minutes < 10) {
                    stringBuilder.insert(3, "0" + minutes);
                    stringBuilder.delete(5, 7);
                } else {
                    stringBuilder.insert(3, minutes);
                    stringBuilder.delete(5, 7);
                }

                // Check if hours has changed
                if(hasHoursChanged) {
                    // Check if there is a need to add another zero in the text
                    if(hours == 0) {
                        stringBuilder.insert(0, "00");
                        stringBuilder.delete(2, 4);
                    } else if(hours < 10) {
                        stringBuilder.insert(0, "0" + hours);
                        stringBuilder.delete(2, 4);
                    } else {
                        stringBuilder.insert(0, hours);
                        stringBuilder.delete(2, 4);
                    }

                    // Set the boolean value for hours to false
                    hasHoursChanged = false;
                }

                // Set the boolean value for minutes to false
                hasMinutesChanged = false;
            }

            // Set the boolean value for seconds to false
            hasSecondsChanged = false;

            // Update the label only if there was a modification
            Graphics.chronoLabel.setText(stringBuilder.toString());
        }
    }
}
