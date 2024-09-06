public class State {
    private String name;
    private long population;
    private String continent;
    private String officialLanguage;

    public State(String name, long population, String continent, String officialLanguage) {
        this.name = name;
        this.population = population;
        this.continent = continent;
        this.officialLanguage = officialLanguage;
    }

    public String getName() {
        return name;
    }

    public long getPopulation() {
        return population;
    }

    public String getContinent() {
        return continent;
    }

    public String getOfficialLanguage() {
        return officialLanguage;
    }
}
