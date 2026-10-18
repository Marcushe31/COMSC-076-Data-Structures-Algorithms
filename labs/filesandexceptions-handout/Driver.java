
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Driver extends DriverBase {

    private static final String INPUT_FILENAME = "inputFile";
    private static final String OUTPUT_FILENAME = "outputFile";

    private static void createInputFile(String[]... info) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(INPUT_FILENAME, false));
            StringBuilder sb = new StringBuilder();
            for (String[] elem : info) {
                for (int j = 0; j < elem.length; j++) {
                    if (j != 0) {
                        sb.append(",");
                    }
                    sb.append(elem[j]);
                }
                sb.append("\n");
                writer.write(sb.toString());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkOutputFile(City... expectedCities) {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(OUTPUT_FILENAME));
        } catch (IOException ioe) {
            testOutput.put(currentTestCase, "Output file could not be opened");
            return;
        }
        ArrayList<City> cities = new ArrayList<>();
        while (true) {
            try {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                String[] parts = line.split(",");
                if (parts.length != 3) {
                    testOutput.put(currentTestCase, "Outputfile contained badly formatted line (" + line + ")");
                    return;
                }
                int population = Integer.parseInt(parts[2]);

                City city = new City(parts[0], parts[1], population);
                cities.add(city);
            } catch (IOException ioe) {
                testOutput.put(currentTestCase, "Reading output file threw an exception");
                return;
            } catch (NumberFormatException nfe) {
                testOutput.put(currentTestCase, "Outputfile contained badly formatted line");
                return;
            }
        }
        for (int i = 0; i < expectedCities.length; i++) {
            City foundCity = cities.get(i);
            if (foundCity.equals(expectedCities[i])) {
                testOutput.put(currentTestCase, "Expected city " + expectedCities[i] + ". Found city " + foundCity);
                return;
            }
        }
        testOutput.put(currentTestCase, null);
    }

    public static void main(String[] args) {
        // Test with non-existent input file
        setCurrentTestCase("non-existent input file");
        checkDoesNotThrowException(() -> {
            CityFiles.Status status = CityFiles.sortPopulation("12321", "out");
            if (status != CityFiles.Status.INPUT_FILE_EXCEPTION) {
                testOutput.put(currentTestCase, "Invalid input file did not return correct status");
            }
        });
        // Test with bad output file
        setCurrentTestCase("invalid output file");
        checkDoesNotThrowException(() -> {
            String[] city = {"1", "S1", "100"};
            createInputFile(city);
            CityFiles.Status status = CityFiles.sortPopulation(INPUT_FILENAME, "/foo");
            if (status != CityFiles.Status.OUTPUT_FILE_EXCEPTION) {
                testOutput.put(currentTestCase, "Invalid output file did not return correct status");
            }
        });
        // Test with non-integer population
        setCurrentTestCase("Invalid population");
        checkDoesNotThrowException(() -> {
            String[] city = {"1", "S1", "10=0"};
            createInputFile(city);
            CityFiles.Status status = CityFiles.sortPopulation(INPUT_FILENAME, OUTPUT_FILENAME);
            if (status != CityFiles.Status.BADLY_FORMATTED_LINE) {
                testOutput.put(currentTestCase, "Invalid population did not return correct status");
            }
        });
        // Test with fewer than three fields
        setCurrentTestCase("Invalid line with fewer than three elements");
        checkDoesNotThrowException(() -> {
            String[][] city = {{"1", "S1", "100"}, {"2", "S2"}};
            createInputFile(city);
            CityFiles.Status status = CityFiles.sortPopulation(INPUT_FILENAME, OUTPUT_FILENAME);
            if (status != CityFiles.Status.BADLY_FORMATTED_LINE) {
                testOutput.put(currentTestCase, "Badly formatted lines did not return correct status");
            }
        });
        // Test with more than a three fields
        setCurrentTestCase("Invalid line with more than three elements");
        checkDoesNotThrowException(() -> {
            String[][] city = {{"1", "S1", "100"}, {"2", "S2", "200", "oops"}};
            createInputFile(city);
            CityFiles.Status status = CityFiles.sortPopulation(INPUT_FILENAME, OUTPUT_FILENAME);
            if (status != CityFiles.Status.BADLY_FORMATTED_LINE) {
                testOutput.put(currentTestCase, "Badly formatted lines did not return correct status");
            }
        });
        // Test with correct number of fields.
        setCurrentTestCase("Test sorting of a valid file");
        checkDoesNotThrowException(() -> {
            String[][] city = {{"A", "S1", "100"}, {"C", "S2", "200"}, {"B", "S3", "300"}};
            createInputFile(city);
            CityFiles.Status status = CityFiles.sortPopulation(INPUT_FILENAME, OUTPUT_FILENAME);
            if (status != CityFiles.Status.SUCCESS) {
                testOutput.put(currentTestCase, "Correctly formatted lines did not return success");
            } else {
                // Check the output file.
                checkOutputFile(new City("A", "S1", 100),
                        new City("B", "S3", 300),
                        new City("C", "S2", 200));
            }
        });

        setCurrentTestCase("Test sorting of a valid file with cities with same name");
        checkDoesNotThrowException(() -> {
            String[][] city = {{"A", "S1", "100"}, {"C", "S2", "200"}, {"A", "S3", "300"}};
            createInputFile(city);
            CityFiles.Status status = CityFiles.sortPopulation(INPUT_FILENAME, OUTPUT_FILENAME);
            if (status != CityFiles.Status.SUCCESS) {
                testOutput.put(currentTestCase, "File with multiple lines for same city name didnt return success.");
            } else {
                // Check the output file.
                checkOutputFile(new City("A", "S1", 100),
                        new City("A", "S3", 300),
                        new City("C", "S2", 200));
            }
        });
        printJsonOutput();
    }
}
