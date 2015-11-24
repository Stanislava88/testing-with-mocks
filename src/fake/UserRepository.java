package fake;

/**
 * Created by clouway on 11/17/15.
 */
public class UserRepository {

    private DataStore dataStore;
   /* private Cache cache;*/

    public UserRepository(DataStore dataStore) {
        this.dataStore = dataStore;
        /*this.cache = cache;*/
    }

    public void registerUserIfNotExist(User user) {

  /*      User existingUser = cache.get(user.id);*/

        User existingUser = dataStore.getUserById(user.id);

        if (existingUser == null) {

            dataStore.register(user);
        }
            /*cache.put(user.id, user);*/
    }

    public void registerExistingUser(User user) {

        /*User existingUser = cache.get(user.id);*/

        if (user != null) {

            throw new IllegalArgumentException("User exist");
        }
    }
}
