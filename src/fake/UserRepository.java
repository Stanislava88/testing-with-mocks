package fake;

import java.util.Map;

/**
 * Created by clouway on 11/17/15.
 */
public interface UserRepository {
    Map<User,String> getUserById(User user, String id);
    void register(User user);
}
