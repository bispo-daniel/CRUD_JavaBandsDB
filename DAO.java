import java.sql.SQLException;

public interface DAO<Type> {
    void save(Type t) throws SQLException;

    String list() throws SQLException;

    void update(int id, String columnName, String newValue) throws SQLException;

    void delete(int id) throws SQLException;
}