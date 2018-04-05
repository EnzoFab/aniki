package facade;

import business_logic.LightUser;
import business_logic.User;

import java.util.*;

/**
 * Manage the facade of the project.
 * It permits to have only facade created per type.
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
     * set the connected user
     * @param  user
     */
    public FacadeManager(User user) {
        System.out.println("Construction");
        this.connectedUser = user;
    }

    /**
     * create a user facade if it doesn't already exist and return it
     * otherwise just return it
     * @see UserFacade
     * @return
     */
    public UserFacade createUserFacade(){
        if(userFacade == null)
            userFacade = new UserFacade(connectedUser);
        return userFacade;
    }

    /**
     * create a inventory facade if it doesn't already exist and return it
     * otherwise just return it
     * @see InventoryFacade
     * @return
     */
    public InventoryFacade createInventoryFacade(){
        if(inventoryFacade == null)
            inventoryFacade = new InventoryFacade(connectedUser);
        return inventoryFacade;
    }


    /**
     * create a event facade if it doesn't already exist and return it
     * otherwise just return it
     * @see EventFacade
     * @return
     */
    public EventFacade createEventFacade(){
        if(this.eventFacade == null){
            eventFacade = new EventFacade(connectedUser);
        }
        return this.eventFacade;
    }

    /**
     * create a expense facade if it doesn't already exist and return it
     * otherwise just return it
     * @see ExpenseFacade
     * @return
     */
    public ExpenseFacade createExpenseFacade(){
        if(this.expenseFacade == null){
            expenseFacade = new ExpenseFacade(connectedUser);
        }
        return this.expenseFacade;
    }

    /**
     * create a todoList facade if it doesn't already exist and return it
     * otherwise just return it
     * @see ToDoListFacade
     * @return
     */
    public  ToDoListFacade createToDoListFacade(){
        if(this.toDoListFacade == null){
            toDoListFacade = new ToDoListFacade(connectedUser);
        }
        return this.toDoListFacade;
    }

    /**
     * create a contact facade if it doesn't already exist and return it
     * otherwise just return it
     * @see ContactFacade
     * @return
     */
    public ContactFacade createContactFacade(){
        if(this.contactFacade == null)
            this.contactFacade = new ContactFacade(connectedUser);
        return contactFacade;
    }

    /**
     * create a allTeam facade if it doesn't already exist and return it
     * otherwise just return it
     * @see AllTeamFacade
     * @return
     */
    public AllTeamFacade createAllTeamFacade(){
        if(allTeamFacade == null)
            allTeamFacade = new AllTeamFacade(connectedUser);
        return allTeamFacade;
    }

    /**
     * create a team facade if it doesn't already exist and return it
     * otherwise just return it
     * @see TeamFacade
     * @return
     */
    public TeamFacade createTeamFacade(){
        if(teamFacade == null)
            teamFacade = new TeamFacade(connectedUser);
        return teamFacade;
    }

    /**
     * create a anualBudget facade if it doesn't already exist and return it
     * otherwise just return it
     * @see AnualBudgetFacade
     * @return
     */
    public AnualBudgetFacade createAnualBudgetFacade() {
        if(anualBudgetFacade == null)
            anualBudgetFacade = new AnualBudgetFacade();
        return anualBudgetFacade;
    }


    /**
     * create a budget facade if it doesn't already exist and return it
     * otherwise just return it
     * @see BudgetFacade
     * @return
     */
    public BudgetFacade createBudgetFacade() {
        if(budgetFacade == null)
            budgetFacade =  new BudgetFacade(connectedUser);
        return budgetFacade;
    }

    /**
     * create a storyMade facade if it doesn't already exist and return it
     * otherwise just return it
     * @see StoryMadeFacade
     * @return
     */
    public StoryMadeFacade createStoryMadeFacade(){
        if(storyMadeFacade == null)
            storyMadeFacade =  new StoryMadeFacade(connectedUser);
        return storyMadeFacade;
    }


    /**
     * return the connected user in the LighUser form
     * @see LightUser
     * @return
     */
    public LightUser getLightUser(){
        return this.connectedUser;
    }
}