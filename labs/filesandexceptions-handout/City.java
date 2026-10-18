public class City implements Comparable<City> {
    final private String name;
    final private String state;
    final private int population;

    /**
     * Creates a city with the given name, state and population.
     */
    public City(String name, String state, int population) {
        this.name = name;
        this.state = state;
        this.population = population;
    }

    /**
     * @return a comma-separated String representation of this City.
     */
    @Override
    public String toString() {
        return name + "," + state + "," + population;
    }

    /** 
     * @return The name of this city.
     */
    public String getName() {
        return name;
    }

    /**
     * @return The state this city is in.
     */
    public String getState() {
        return state;
    }

    /**
     * @return The population of this city.
     */
    public int getPopulation() {
        return population;
    }

    /**
     * Compare two City objects. First, use the name to 
     * determine the order. If the names are the same, use 
     * the state to break the tie. If the states are the 
     * same (which should never happen, but, hey...), 
     * use the population to break the tie. 
     */ 
    @Override
    public int compareTo(City other) { 
        int result = this.name.compareTo(other.name); 
        if (result == 0) { 
            result = this.state.compareTo(other.state); 
            if (result == 0) { 
                result = Integer.compare(this.population, 
                    other.population); 
            } 
        } 
        return result;
    }

}