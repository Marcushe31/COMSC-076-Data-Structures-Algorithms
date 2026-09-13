/**
 * Encapulates a time duration.
 * @author Balaji Srinivasan
 */
public class Duration {
    private int hours;
    private int minutes;

    /**
     * Creates a duration of 0 hours and 0 minutes.
     */
    public Duration() {
        this.hours = 0;
        this.minutes = 0;
    }

    /**
     * Creates a Duration with the given hours and minutes.
     * @param hours The hours for this duration.
     * @param minutes The minutes for this duration.
     * @throws IllegalArgumentException if the hours is < 0, or if minutes is
     *                                  not between 0-59
     */
    public Duration(int hours, int minutes) {
        if (hours < 0 || (minutes < 0) || (minutes > 59)) {
            throw new IllegalArgumentException("Invalid hours/minutes.");
        }
        this.hours = hours;
        this.minutes = minutes;
    }

    /**
     * Returns the hours of this duration.
     * @returns The hours of this duration
     */
    public int getHours() {
        return this.hours;
    }
    
    /**
     * Returns the minutes of this duration.
     * @returns The minutes of this duration.
     */
    public int getMinutes() {
        return this.minutes;
    }

    /** 
     * Sets the hours
     * @param hours The hours to set this duration to.
     * @throws IllegalArgumentException if the hours < 0.
     */
    public void setHours(int hours) {
        if (hours < 0) {
            throw new IllegalArgumentException("Invalid hours.");
        }
        this.hours = hours;
    }

    /**
     * Set the minutes of this duration.
     * @param minutes The minutes to set this duration to.
     * @throws IllegalArgumentException If passed in minutes is not in between 0-59.
     */
    public void setMinutes(int minutes) {
        if ((minutes < 0) || (minutes > 59)) {
            throw new IllegalArgumentException("Invalid minutes.");
        }
        this.minutes = minutes;
    }

    /**
     * Returns a string representation of this duration object in hh:mm format.
     * @returns The string representation.
     */
    @Override
    public String toString() {
        return String.format("%02d:%02d", hours, minutes);
    }

    /**
     * Parses a string of the form hh:mm and returns a Duration object.
     * @param duration The string representation of the duration in hh:mm format.
     * @return The Duration object.
     * @throws IllegalArgumentException if the string is invalid.
     */
    public static Duration fromString(String duration) {
        String[] parts = duration.split(":");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid string passed to fromString");
        }
        int hh = Integer.parseInt(parts[0]);
        int mm = Integer.parseInt(parts[1]);
        return new Duration(hh, mm);
    }

    /** Adds the passed in duration to this Duration object
     * @param duration The duration object.
     */
    public void add(Duration duration) {
        this.hours += duration.getHours();
        this.minutes += duration.getMinutes();
        if (minutes > 59) {
            this.hours++;
            this.minutes -= 60;
        }
    }
}
