package facade;

import business_logic.Article;
import persistent.daos.ArticleDAO;
import persistent.factories.DaoFactory;
import persistent.factories.DaoPostgresFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 */
public class InventoryFacade {

    private ArticleDAO articleDAO;
    private ArrayList<Article> articlesList;

    private final DaoFactory factory;
    private FacadeManager facadeManager;

    /**
     * Default constructor
     */
    public InventoryFacade() {
        factory = DaoPostgresFactory.getInstance();
        this.articleDAO = factory.createArticleDAO();
        this.articlesList = new ArrayList<>();
        try {
            this.getArticles();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





    /**
     * @param name 
     * @param description 
     * @param quantity 
     * @param type 
     * @return
     */
    public boolean addArticle(String name, String description, int quantity, String type) throws SQLException {
        Article article = new Article(name, description, quantity, type);
        boolean state = this.articleDAO.insert(article);

        if (state) {
            // If the insert is ok, we get the id given by the database and add it to the java object before inserted it in the arrayList
            int idA = (int) this.articleDAO.selectLast().getObject("article_id");
            article.setIdA(idA);
            this.articlesList.add(article);
        }
        return state;
    }

    /**
     * @param idA
     * @return
     */
    public boolean deleteArticle(int idA) {
        // idT is the index of the event in the arrayList
        boolean state = this.articleDAO.delete(this.articlesList.get(idA).getIdA());
        if (state){
            this.articlesList.remove(idA);
        }
        return state;
    }

    /**
     * @param capacity 
     * @param name
     */
    public void updateArticle(int capacity, String name) {
        // TODO implement here
    }

    /**
     * @param
     * @return
     */
    public void getArticles() throws SQLException {
        ResultSet result = this.articleDAO.selectAll();
        Article article;
        if (result.first()) {
            article = new Article(result.getString("article_name"), result.getString("article_description"), result.getInt("article_number"), result.getString("type_name"));
            article.setIdA(result.getInt("article_id"));
            this.articlesList.add(article);
            while(result.next()){
                article = new Article(result.getString("article_name"), result.getString("article_description"), result.getInt("article_number"), result.getString("type_name"));
                article.setIdA(result.getInt("article_id"));
                this.articlesList.add(article);
            }
        }
    }

    /**
     * @return
     */
    public ArrayList<String> getTypes() {
        // TODO implement here
        return null;
    }

    public ArrayList<Article> getArticlesList() {
        return articlesList;
    }

}