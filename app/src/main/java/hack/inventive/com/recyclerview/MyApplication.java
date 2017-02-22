package hack.inventive.com.recyclerview;

import android.app.Application;
import io.realm.Realm;

/**
 * 21/02/2017.
 */

public class MyApplication extends Application {

  @Override public void onCreate() {
    super.onCreate();
    Realm.init(this);
  }
}
