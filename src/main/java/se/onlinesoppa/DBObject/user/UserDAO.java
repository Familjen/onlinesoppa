package se.onlinesoppa.DBObject.user;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by Morgan on 2016-11-19.
 */
public interface UserDAO {

    /**
     * This is the method to be used to initialize
     * database resources ie. connection.
     */
    void setDataSource(DataSource ds);
    /**
     * This is the method to be used to create
     * a record in the Student table.
     */
    void create(String name, String password);

    /**
     * This method gets a user by id
     */
    User getUser(Integer id);

    /**
     * This method gets a user by username
     */

    User getUser(String username);

    /**
     * This method gets all the user from the database
     */
    List<User> listUsers();
    /**
     * Delete a user by id
     */
    void delete(Integer id);

    /**
     * Delete a user by username
     */
    void delete(String username);

}
