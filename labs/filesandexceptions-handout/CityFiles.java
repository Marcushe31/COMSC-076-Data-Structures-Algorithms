/*
 * Name: Marcus Hernandez
 * Assignment: Files and Exceptions 
 * 
 * Description: Reads a file of cities (name,state,population per line),
 * sorts them alphabetically with Collections.sort, and writes them to an
 * output file. Returns a Status code saying whether or not it worked.
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Balaji Srinivasan
 */
public class CityFiles {

    /**
     * The status for the sortPopulation operation.
     */
    public enum Status {
        SUCCESS, // Returned when operation completes successfully.
        INPUT_FILE_EXCEPTION, // Returned when input file could not be opened.
        OUTPUT_FILE_EXCEPTION, // Returned if output file could not be opened or written to.
        BADLY_FORMATTED_LINE // Returned when the line is not formatted correctly in the input file
    };

    /**
     * Processes the given input file and sorts the cities in alphabetical order.
     * @param in The input file name.
     * @param out The output file name.
     * @return The return status which should be one of the enum values above.
     */
    public static Status sortPopulation(String in, String out) {
        ArrayList<City> cities = new ArrayList<>();

        // Read the input file one line at a time and build City objects
        try (BufferedReader reader = new BufferedReader(new FileReader(in))) {
            String line = reader.readLine();
            while (line != null) {
                // Each line must have EXACTLY THREE items: name, state, population
                String[] parts = line.split(",");
                if (parts.length != 3) {
                    return Status.BADLY_FORMATTED_LINE;
                }
                // parseInt will throw a NumberFormatException if the population is not a number
                int population = Integer.parseInt(parts[2]);
                cities.add(new City(parts[0], parts[1], population));
                line = reader.readLine();
            }
        } catch (NumberFormatException ex) {
            return Status.BADLY_FORMATTED_LINE;
        } catch (IOException ex) {

            // Input file does not exist or could not be read
            return Status.INPUT_FILE_EXCEPTION;
        }

        // Sort by name, then state (uses compareTo in City)
        Collections.sort(cities);

        // Write each sorted city to the output file, one per line
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(out))) {
            for (City city : cities) {
                writer.write(city.toString());
                writer.newLine();
            }
        } catch (IOException ex) {
            // Output file could not be opened or written to
            return Status.OUTPUT_FILE_EXCEPTION;
        }

        return Status.SUCCESS;
    }
}