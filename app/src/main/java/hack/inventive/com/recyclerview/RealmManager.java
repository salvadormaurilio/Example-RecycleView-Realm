package hack.inventive.com.recyclerview;

import io.realm.Realm;
import io.realm.RealmResults;
import java.util.ArrayList;
import java.util.List;

/**
 * 21/02/2017.
 */

public class RealmManager {

  private Realm realm;

  public RealmManager() {
    realm = Realm.getDefaultInstance();
  }

  public void saveAnimal(String name, String description) {
    Animal animal = new Animal(name, description,
        "http://www.dmax.marca.com/wp-content/uploads/2015/10/delfin.jpg");

    realm.beginTransaction();
    realm.copyToRealm(animal);
    realm.commitTransaction();
  }

  public List<Animal> getAnimals() {

    RealmResults<Animal> animalRealmResults = realm.where(Animal.class).findAll();

    List<Animal> animalList = new ArrayList<>();

    for (Animal animal : animalRealmResults) {
      animalList.add(animal);
    }

    return animalList;
  }
}
