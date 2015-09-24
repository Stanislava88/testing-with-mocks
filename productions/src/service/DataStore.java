package service;

/**
 * @author Slavi Dichkov (slavidichkof@gmail.com)
 */
public interface DataStore {
    void addInData(String name, String age);

    String getByName(String name);

}
