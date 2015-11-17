package fake;

/**
 * Created by clouway on 11/17/15.
 */
public interface Cache {

    User get(String id);

    void put(String id, User user);
}
