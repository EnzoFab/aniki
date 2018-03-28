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
        this.connectedUser = user;
    }


    /**
     * @return
     */
    public User getConnectUser() {
        // TODO implement here
        return null;
    }

    /**
     * @param user
     */
    public void setConnectUser(User user) {
        // TODO implement here
    }

    /**
     * @return
     */
    public AllTeamFacade getAllTeamFacade() {
        // TODO implement here
        return null;
    }

    /**
     * @param allTeamFacade
     */
    public void setAllTeamFacade(AllTeamFacade allTeamFacade) {
        // TODO implement here
    }

    /**
     * @return
     */
    public ToDoListFacade getToDoList() {
        // TODO implement here
        return null;
    }

    /**
     * @param toDoListFacade
     */
    public void setToDoList(ToDoListFacade toDoListFacade) {
        // TODO implement here
    }

    /**
     * @return
     */
    public InventoryFacade getInventoryFacade() {
        // TODO implement here
        return null;
    }

    /**
     * @param inventoryFacade
     */
    public void setInventoryFacade(InventoryFacade inventoryFacade) {
        // TODO implement here
    }

    /**
     * @return
     */
    public StoryMadeFacade getStoryMadeFacade() {
        // TODO implement here
        return null;
    }

    /**
     * @param storyMadeFacade
     */
    public void setStoryMadeFacade(StoryMadeFacade storyMadeFacade) {
        // TODO implement here
    }

    /**
     * @return
     */
    public AnualBudgetFacade getAnualBudgetFacade() {
        // TODO implement here
        return null;
    }

    /**
     * @param anualBudgetFacade
     */
    public void setAnualBudgetFacade(AnualBudgetFacade anualBudgetFacade) {
        // TODO implement here
    }

    /**
     * @return
     */
    public BudgetFacade getBudgetFacade() {
        // TODO implement here
        return null;
    }

    /**
     * @param budgetFacade
     */
    public void setBudgetFacade(BudgetFacade budgetFacade) {
        // TODO implement here
    }

    /**
     * @return
     */
    public ExpenseFacade getExpenseFacade() {
        // TODO implement here
        return null;
    }

    /**
     * @param expenseFacade
     */
    public void setExpenseFacade(ExpenseFacade expenseFacade) {
        // TODO implement here
    }

    /**
     * @return
     */
    public EventFacade getEventFacade() {
        // TODO implement here
        return null;
    }

    /**
     * @param eventFacade
     */
    public void setEventFacade(EventFacade eventFacade) {
        // TODO implement here
    }

    /**
     * @return
     */
    public TeamFacade getTeamFacade() {
        // TODO implement here
        return null;
    }

    /**
     * @param teamFacade
     */
    public void setTeamFacade(TeamFacade teamFacade) {
        // TODO implement here
    }

    /**
     * @return
     */
    public ContactFacade getContactFacade() {
        // TODO implement here
        return null;
    }

    /**
     * @param contactFacade
     */
    public void setContactFacade(ContactFacade contactFacade) {
        // TODO implement here
    }

    /**
     * @return
     */
    public UserFacade getUserFacade() {
        // TODO implement here
        return null;
    }

    /**
     * @param userFacade
     */
    public void setUserFacade(UserFacade userFacade) {
        // TODO implement here
    }


    public LightUser getLightUser(){
        return this.connectedUser;
    }

}