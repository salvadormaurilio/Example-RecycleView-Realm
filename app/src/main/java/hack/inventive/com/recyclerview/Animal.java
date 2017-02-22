package hack.inventive.com.recyclerview;

import io.realm.RealmObject;

/**
 * 20/02/2017.
 */

public class Animal extends RealmObject{

  private String nombre;
  private String description;
  private String urlImage;

  public Animal() {
  }

  public Animal(String nombre, String description, String urlImage) {
    this.nombre = nombre;
    this.description = description;
    this.urlImage = urlImage;
  }

  public String getNombre() {
    return nombre;
  }

  public String getDescription() {
    return description;
  }

  public String getUrlImage() {
    return urlImage;
  }
}
