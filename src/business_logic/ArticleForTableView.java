package business_logic;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ArticleForTableView {
    private SimpleStringProperty name;

    /**
     *
     */
    private SimpleStringProperty  description;

    /**
     *
     */
    private SimpleIntegerProperty quantity;

    /**
     *
     */
    private StringProperty type;

    public ArticleForTableView(String name, String description, int quantity, String type) {
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty(description);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.type = new SimpleStringProperty(type);
    }

    public String getName() {
        return name.get();
    }



    public void setName(String name) {
        this.name.set(name);
    }

    public String getDescription() {
        return description.get();
    }



    public void setDescription(String description) {
        this.description.set(description);
    }

    public int getQuantity() {
        return quantity.get();
    }



    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }

    public String getType() {
        return type.get();
    }



    public void setType(String type) {
        this.type.set(type);
    }
}
