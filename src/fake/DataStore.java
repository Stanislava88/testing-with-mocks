package fake;

import java.util.Map;

/**
 * Created by clouway on 11/17/15.
 */
public interface DataStore {

    User getUserById(String id);

    void register(User user);

}
