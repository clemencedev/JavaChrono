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
    public int hours = 0;
    public int minutes = 0;
    public int seconds = 0;
    public int milliseconds = 0;

    @Override
    public void run() {
        // Add 10 ms everytime
        milliseconds = milliseconds + 1;
    
        // Check if 1000ms has passed
        if(milliseconds >= 100) {
            milliseconds = 0;
            seconds++;
            
            // Check if 60sec has passed
            if(seconds >= 60) {
                seconds = 0;
                minutes++;

                // Check if 60min has passed
                if(minutes >= 60) {
                    minutes = 0;
                    hours++;
                }
            }
        }

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

        // Seconds, minutes and hours
        String hoursText = "";
        String minutesText = "";
        String secondsText = "";

        // Check if there is a need to add another zero in the text
        if(hours == 0) {
            hoursText = "00";
        } else if(hours < 10) {
            hoursText = "0" + hours;
        } else {
            hoursText = hours + "";
        }

        // Check if there is a need to add another zero in the text
        if(minutes == 0) {
            minutesText = "00";
        } else if(minutes < 10) {
            minutesText = "0" + minutes;
        } else {
            minutesText = minutes + "";
        }

        // Check if there is a need to add another zero in the text
        if(seconds == 0) {
            secondsText = "00";
        } else if(seconds < 10) {
            secondsText = "0" + seconds;
        } else {
            secondsText = seconds + "";
        }

        Graphics.chronoLabel.setText(hoursText + ":" + minutesText + ":" + secondsText);
    }
    
}
