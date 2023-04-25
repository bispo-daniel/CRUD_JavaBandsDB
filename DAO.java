import java.sql.SQLException;

public interface DAO<Type> {
    void save(Type t) throws SQLException;
}