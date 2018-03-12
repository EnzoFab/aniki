package business_logic;

import java.util.Date;

public class StoryMade {

    private Date date;
    private String text;
    private String label;

    private Event event;

    public StoryMade (Date date, String text, String label){
        this.date = date;
        this.text = text;
        this.label = label;
    }

    public Date getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public String getLabel() {
        return label;
    }

    public Event getEvent() {
        return event;
    }
}
