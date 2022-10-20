package streamAPI;

public class FooFirst {
    private String value;
    private String name;

    public FooFirst(String value,
                    String name) {
        this.value = value;
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FooFirst{" +
                "value='" + value + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
