import org.junit.Test;
import stub.FooCollection;
import stub.FooStub;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by clouway on 11/17/15.
 */
public class FooCollectionTest {

    private FooCollection fooCollection = new FooCollection();

    @Test
    public void shouldBarsJoined() throws Exception {

        fooCollection.add(new FooStub());
        fooCollection.add(new FooStub());

        assertThat("bazbaz", is(fooCollection.joined()));
    }
}
