package fake;

/**
 * Created by clouway on 11/17/15.
 */
public class DataStore {

    private UserRepository userRepository;
    private Cache cache;

    public DataStore(UserRepository userRepository, Cache cache) {
        this.userRepository = userRepository;
        this.cache = cache;
    }

    public void registerUserIfNotExist(User user) {

        User existingUser = cache.get(user.id);

        if (existingUser == null) {
            existingUser = (User) userRepository.getUserById(user, user.id);
        }
        if (existingUser == null) {
            userRepository.register(user);
            cache.put(user.id, user);
        }
    }
}
