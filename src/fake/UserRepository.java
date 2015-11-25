package fake;

/**
 * Created by clouway on 11/17/15.
 */
public class UserRepository {

    private DataStore dataStore;
    private Cache cache;

    private User existingUser;

    public UserRepository(DataStore dataStore, Cache cache) {
        this.dataStore = dataStore;
        this.cache = cache;
    }

    public void registerUserIfNotExist(User user) {

         existingUser = cache.get(user.id);

         existingUser = dataStore.getUserById(user.id);

        if (existingUser == null) {

            dataStore.register(user);
        }
            cache.put(user.id, user);
    }

    public void registerExistingUser(User user) {

         existingUser = cache.get(user.id);

        if (user != null) {

            throw new IllegalArgumentException("User exist");
        }
    }
}
