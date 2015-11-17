package tranings;


/**
 * Created by clouway on 11/17/15.
 */
public class DataStore {

    UserRepository userRepository;

    Cache cache;

    public DataStore(UserRepository userRepository, Cache cache) {
        this.userRepository = userRepository;
        this.cache = cache;
    }

    public void registerNotExistingUser(User user) {

        User existingUser = cache.get(user.id);

        if (existingUser == null) {
            userRepository.get(user.id);
        }
        if (existingUser == null) {
            userRepository.registerUser(user);
            cache.put(user, user.id);
        }
    }
}
