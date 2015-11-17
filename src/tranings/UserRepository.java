package tranings;

import java.util.Map;

/**
 * Created by clouway on 11/17/15.
 */
public interface UserRepository {

    Map<User,String> get(String id);

    void registerUser(User user);
}
