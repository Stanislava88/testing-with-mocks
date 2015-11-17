import fake.DataStore;
import fake.FakeCache;
import fake.User;
import fake.UserRepository;
import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

/**
 * Created by clouway on 11/17/15.
 */
public class FakeCacheTest {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Mock
    UserRepository userRepository;

    /*@Mock
    Cache cache;*/

    @Test
    public void registerNotExistUser() throws Exception {

        User user = new User();
        user.id = "dsds";

        FakeCache fakeCache = new FakeCache();

        context.checking(new Expectations(){
            {
                oneOf(userRepository).getUserById(user.id);
                will(returnValue(null));
                oneOf(userRepository).register(user);
            }
        });
        DataStore dataStore = new DataStore(userRepository,fakeCache);
        dataStore.registerUserIfNotExist(user);
        fakeCache.assertCacheContains(user.id);
    }
}
