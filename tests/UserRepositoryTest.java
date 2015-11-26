import fake.*;
import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by clouway on 11/17/15.
 */
public class UserRepositoryTest {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Mock
    DataStore dataStore;

   /* @Mock
    Cache cache;*/

    @Test
    public void registerNotExistUser() throws Exception {

        User user = new User("dsds");


        InMemoryCache cache = new InMemoryCache();

        context.checking(new Expectations() {
            {
                oneOf(dataStore).getUserById(user.id);
                will(returnValue(null));
                oneOf(dataStore).register(user);
            }
        });
        UserRepository dataStore = new UserRepository(this.dataStore,cache);
        dataStore.registerUserIfNotExist(user);
        cache.assertCacheContains(user.id);
    }
}
