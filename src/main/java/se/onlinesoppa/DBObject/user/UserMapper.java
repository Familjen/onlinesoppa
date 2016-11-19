package se.onlinesoppa.DBObject.user;

/**
 * Created by Morgan on 2016-11-19.
 */

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class UserMapper implements RowMapper<User>{
    public User mapRow(ResultSet rs, int rowNr) throws SQLException
    {
        User user = new User();

        user.setId(rs.getInt("id"));
        user.setPassword(rs.getString("password"));
        user.setUsername(rs.getString("username"));

        return user;
    }
}
