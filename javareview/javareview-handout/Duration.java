/**
 * Represents a length of time in hours and minutes. A Duration can be built
 * from int values
 * or parsed from "hh:mm" format, converted into string form, and combined with
 * another Duration using addition.
 * 
 * @author Marcus Hernandez
 */
class Duration {
    private int hours;
    private int minutes;

    /**
     * public no-arg constructor that initializes variables to 0
     */
    public Duration() {
        hours = 0;
        minutes = 0;
    }

    /**
     * two parameter constructor that sets both properties as specified in the
     * parameters
     * 
     * @param hours   the hours
     * @param minutes the minutes
     * @throws IllegalArgumentException if minutes or hours is negative or minutes
     *                                  is greater than 59
     */
    public Duration(int hours, int minutes) {
        if (hours >= 0 && minutes >= 0 && minutes <= 59) {
            this.hours = hours;
            this.minutes = minutes;
        } else {
            throw new IllegalArgumentException("Invalid Hours or Minutes");
        }
    }

    /**
     * accessors that gets the number of hours
     * 
     * @return the number of hours
     */
    public int getHours() {
        return hours;
    }

    /**
     * accessor that gets the minutes
     * 
     * @return the number of minutes
     */
    public int getMinutes() {
        return minutes;
    }

    // mutators
    /**
     * mutator that sets the hours
     * 
     * @param hours the int number of hours to set
     * @throws IllegalArgumentException if hours is negative
     */
    public void setHours(int hours) {
        if (hours >= 0) {
            this.hours = hours;
        } else {
            throw new IllegalArgumentException("Cannot have negative hours");
        }
    }

    /**
     * mutator that sets the minutes
     * 
     * @param minutes the int number of minutes to set
     * @throws IllegalArgumentException if minutes is negative or greater than 59
     */
    public void setMinutes(int minutes) {
        if (minutes >= 0 && minutes <= 59) {
            this.minutes = minutes;
        } else {
            throw new IllegalArgumentException("Minutes must be between 0-59 and cannot be negative");
        }
    }

    /**
     * returns a string as hh:mm form
     * 
     * @return the string in hh:mm
     */
    public String toString() {
        return String.format("%02d:%02d", this.hours, this.minutes);
    }

    /**
     * takes string in hh:mm form and returns a Duration object
     * 
     * @param str the string in hh:mm form
     * @return new Duration object with hh and mm parameters
     * @throws IllegalArgumentException if the number of parts is not 2, or if the
     *                                  parsed hours or minutes is invalid
     * @throws NumberFormatException    if the hours or minutes part of the string
     *                                  is not a valid number
     */
    public static Duration fromString(String str) {
        String[] parts = str.split(":");

        if (parts.length != 2) {
            throw new IllegalArgumentException();
        }
        int hh = Integer.parseInt(parts[0]);
        int mm = Integer.parseInt(parts[1]);

        return new Duration(hh, mm);
    }

    /**
     * adds duration to new duration and accounts for minute overflow
     * 
     * @param other the Duration object that's added to "this" object
     * @return the same Duration object, updated with the combined time
     */
    public Duration add(Duration other) {
        this.hours += other.getHours();
        this.minutes += other.getMinutes();

        if (this.minutes >= 60) {
            this.hours += (this.minutes / 60);
            this.minutes -= ((this.minutes / 60) * 60);
        }

        return this;
    }

}
