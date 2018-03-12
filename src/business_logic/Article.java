package business_logic;

public class Article {

    private String name;
    private String description;
    private int quantity;

    private Type type;

    public Article (String naùe, String description, int quantity){
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public Type getType() {
        return type;
    }
}
