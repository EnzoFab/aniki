package facade;

import business_logic.LightUser;
import business_logic.User;

import java.util.*;

/**
 * 
 */
public class FacadeManager {


    /**
     *
     */
    private User connectedUser;

    /**
     *
     */
    private AllTeamFacade allTeamFacade;

    /**
     *
     */
    private ToDoListFacade toDoListFacade;

    /**
     *
     */
    private InventoryFacade inventoryFacade;

    /**
     *
     */
    private StoryMadeFacade storyMadeFacade;

    /**
     *
     */
    private AnualBudgetFacade anualBudgetFacade;

    /**
     *
     */
    private BudgetFacade budgetFacade;

    /**
     *
     */
    private ExpenseFacade expenseFacade;

    /**
     *
     */
    private EventFacade eventFacade;

    /**
     *
     */
    private TeamFacade teamFacade;

    /**
     *
     */
    private ContactFacade contactFacade;

    /**
     *
     */
    private UserFacade userFacade;



    /**
     * Default constructor
     */
    public FacadeManager(User user) {
        System.out.println("Construction");
        this.connectedUser = user;
    }

    public UserFacade createUserFacade(){
        if(userFacade == null)
            userFacade = new UserFacade(connectedUser);
        return userFacade;
    }

    public InventoryFacade createInventoryFacade(){
        if(inventoryFacade == null)
            inventoryFacade = new InventoryFacade(connectedUser);
        return inventoryFacade;
    }

    public EventFacade createEventFacade(String team){
        if(this.eventFacade == null){
            eventFacade = new EventFacade(team,connectedUser);
        }
        return this.eventFacade;
    }

    public EventFacade createEventFacade(){
        if(this.eventFacade == null){
            eventFacade = new EventFacade(connectedUser);
        }
        return this.eventFacade;
    }

    public ExpenseFacade createExpenseFacade(){
        if(this.expenseFacade == null){
            expenseFacade = new ExpenseFacade(connectedUser);
        }
        return this.expenseFacade;
    }

    public ContactFacade createContactFacade(){
        if(this.contactFacade == null)
            this.contactFacade = new ContactFacade(connectedUser);
        return contactFacade;
    }

    public AllTeamFacade createAllTeamFacade(){
        if(allTeamFacade == null)
            allTeamFacade = new AllTeamFacade(connectedUser);
        return allTeamFacade;
    }




    public void setConnectedUser(User connectedUser) {
        this.connectedUser = connectedUser;
    }

    public AllTeamFacade getAllTeamFacade() {
        return allTeamFacade;
    }

    public void setAllTeamFacade(AllTeamFacade allTeamFacade) {
        this.allTeamFacade = allTeamFacade;
    }

    public ToDoListFacade getToDoListFacade() {
        return toDoListFacade;
    }

    public void setToDoListFacade(ToDoListFacade toDoListFacade) {
        this.toDoListFacade = toDoListFacade;
    }


    public StoryMadeFacade getStoryMadeFacade() {
        return storyMadeFacade;
    }

    public void setStoryMadeFacade(StoryMadeFacade storyMadeFacade) {
        this.storyMadeFacade = storyMadeFacade;
    }

    public AnualBudgetFacade getAnualBudgetFacade() {
        return anualBudgetFacade;
    }

    public void setAnualBudgetFacade(AnualBudgetFacade anualBudgetFacade) {
        this.anualBudgetFacade = anualBudgetFacade;
    }

    public BudgetFacade getBudgetFacade() {
        return budgetFacade;
    }

    public void setBudgetFacade(BudgetFacade budgetFacade) {
        this.budgetFacade = budgetFacade;
    }

    public ExpenseFacade getExpenseFacade() {
        return expenseFacade;
    }

    public void setExpenseFacade(ExpenseFacade expenseFacade) {
        this.expenseFacade = expenseFacade;
    }

    public EventFacade getEventFacade() {
        return eventFacade;
    }

    public void setEventFacade(EventFacade eventFacade) {
        this.eventFacade = eventFacade;
    }

    public TeamFacade getTeamFacade() {
        return teamFacade;
    }

    public void setTeamFacade(TeamFacade teamFacade) {
        this.teamFacade = teamFacade;
    }

    public ContactFacade getContactFacade() {
        return contactFacade;
    }

    public void setContactFacade(ContactFacade contactFacade) {
        this.contactFacade = contactFacade;
    }



    public LightUser getLightUser(){
        return this.connectedUser;
    }

    public AnualBudgetFacade createAnualBudgetFacade() {
        if(anualBudgetFacade == null)
            anualBudgetFacade = new AnualBudgetFacade();
        return anualBudgetFacade;
    }

    public BudgetFacade createBudgetFacade() {
        if(budgetFacade == null)
            budgetFacade =  new BudgetFacade();
        return budgetFacade;
    }
}