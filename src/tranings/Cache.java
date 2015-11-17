package tranings;

/**
 * Created by clouway on 11/17/15.
 */
public interface Cache {

    User get(String id);

    void put(User user, String id);
}
