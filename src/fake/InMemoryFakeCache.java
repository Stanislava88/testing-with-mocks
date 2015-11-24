package fake;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by clouway on 11/17/15.
 */
public class InMemoryFakeCache implements Cache {

    private Map<String, User> cache = new HashMap<>();

    @Override
    public User get(String id) {
        return cache.get(id);
    }

    @Override
    public void put(String id, User user) {
        cache.put(id, user);
    }

    public void assertCacheContains(String id) {
        assertThat(cache.containsKey(id), is(true));
    }
}
