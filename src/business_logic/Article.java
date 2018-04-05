package business_logic;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * 
 */
public class Article {

    private int idA;
    /**
     *
     */
    private String name;

    /**
     *
     */
    private String  description;

    /**
     *
     */
    private int quantity;

    /**
     *
     */
    private String type;


    /**
     *
     * @param name
     * @param description
     * @param quantity
     * @param type
     */
    public Article(String name, String description, int quantity, String type) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getIdA() {
        return idA;
    }

    public void setIdA(int idA) {
        this.idA = idA;
    }

    /**
     * create an ArticleForTableView in order to be display in a table view
     * @return
     */
    public ArticleForTableView createArticleForTableView(){
        return new ArticleForTableView(name,description,quantity,type);
    }
}