package NewLesson6;

public class WeatherModel {
    private String name;
    private Double temprecher;

    public WeatherModel(String name, Double temprecher) {
        this.name = name;
        this.temprecher = temprecher;
    }

    public String getName() {
        return name;
    }

    public Double getTemprecher() {
        return temprecher;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTemprecher(Double temprecher) {
        this.temprecher = temprecher;
    }
}
