package lambda;

public class Wine {
    private double alcohol;
    private String color;

    public Wine(double alcohol, String color) {
        this.alcohol = alcohol;
        this.color = color;
    }

    public double getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(double alcohol) {
        this.alcohol = alcohol;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
