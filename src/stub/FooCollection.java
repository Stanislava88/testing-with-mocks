package stub;

/**
 * Created by clouway on 11/17/15.
 */
public class FooCollection {

    StringBuilder sb = new StringBuilder();

    public void add(FooStub fooStub) {
        sb.append(fooStub.bar());
    }

    public String joined() {
        return sb.toString();
    }
}
