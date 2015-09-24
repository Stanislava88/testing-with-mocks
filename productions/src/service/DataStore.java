package service;

/**
 * Created by clouway on 15-9-8.
 */
public interface DataStore {
    void addInData(String name, String age);

    String getByName(String name);

}
