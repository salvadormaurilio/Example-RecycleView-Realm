package hack.inventive.com.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyAdapter.MyItemListener {

  private RecyclerView mRecyclerView;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mRecyclerView = (RecyclerView) findViewById(R.id.my_list);
    //mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
    mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    MyAdapter myAdapter = new MyAdapter(getAnimals(), this);
    myAdapter.setMyItemListener(this);

    mRecyclerView.setAdapter(myAdapter);
  }

  private List<Animal> getAnimals() {
    RealmManager realmManager = new RealmManager();
    return realmManager.getAnimals();
  }

  //private List<Animal> createListAnimals() {
  //  List<Animal> animalList = new ArrayList<>();
  //
  //  for (int i = 0; i < 4; i++) {
  //    animalList.add(new Animal("Perro", "Animal domestico", "https://s-media-cache-ak0.pinimg.com/736x/bb/6e/ed/bb6eedc6907519c545c29841dc26680e.jpg"));
  //    animalList.add(new Animal("Gato", "Animal domestico que odia a los humanos", "http://product.cdn.cevaws.com/var/storage/images/feliway-v2/comportamiento-del-gato/test-de-bienestar/tu-gato-tiene-un-riesgo-de-estres-moderado/507378-47-esl-ES/Tu-gato-tiene-un-riesgo-de-estres-moderado.jpg"));
  //    animalList.add(new Animal("Delfin", "Animal acuatico", "http://www.dmax.marca.com/wp-content/uploads/2015/10/delfin.jpg"));
  //    animalList.add(new Animal("Lobo", "Animal de bosques frios", "http://www.bioenciclopedia.com/wp-content/uploads/2011/11/lobo4-800.jpg"));
  //  }
  //
  //  return animalList;
  //}

  @Override public void onItemClick(int position, String name) {
    Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
  }
}
