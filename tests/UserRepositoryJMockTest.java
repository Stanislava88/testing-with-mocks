import fake.Cache;
import fake.DataStore;
import fake.User;
import fake.UserRepository;
import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;

import java.util.IllegalFormatCodePointException;


/**
 * Created by clouway on 11/17/15.
 */
public class UserRepositoryJMockTest {

    @Rule
    public JUnitRuleMockery context = new JUnitRuleMockery();

    @Mock
    DataStore dataStore;

   /* @Mock
    Cache cache;*/


    @Test
    public void registerUserDoNotExist() {

        User user = new User("dsdsd");

        context.checking(new Expectations() {
            {
                oneOf(dataStore).getUserById(user.id);

                will(returnValue(null));

                oneOf(dataStore).register(user);

              /*  oneOf(cache).put(with(any(String.class)), with(any(User.class)));*/

            }
        });

        UserRepository userRepository = new UserRepository(dataStore);
        userRepository.registerUserIfNotExist(user);
    }

    @Test(expected = IllegalArgumentException.class)
    public void registerExisitngUser() throws Exception {

        User user = new User("dsdsd");


        context.checking(new Expectations() {
            {
                UserRepository userRepository = new UserRepository(dataStore);
                oneOf(userRepository).registerExistingUser(user);
                will(returnValue(null));
            }
        });
    }
}
