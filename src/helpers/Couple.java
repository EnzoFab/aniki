package helpers;

/**
 * This class will help to manage queries to the data base
 * such has update queries
 * It contains the attribute name and the value we want to give
 * It can also be used in a WHERE clause
 */
public class Couple {
    private final String attributeName;
    private final String attributeValue;

    /**
     *
     * @param attributeName
     * @param attributeValue
     */
    public Couple(String attributeName, String attributeValue){
        this.attributeName = attributeName;
        this.attributeValue = attributeValue;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public String getAttributeValue() {
        return attributeValue;
    }
}
