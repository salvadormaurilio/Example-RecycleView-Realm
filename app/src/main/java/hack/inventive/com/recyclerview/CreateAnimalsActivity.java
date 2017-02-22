package hack.inventive.com.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateAnimalsActivity extends AppCompatActivity implements View.OnClickListener {

  private EditText nameAnimal;
  private EditText descriptionAnimal;
  private Button saveAnimal;
  private Button getAnimals;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_create_animals);

    nameAnimal = (EditText) findViewById(R.id.name);
    descriptionAnimal = (EditText) findViewById(R.id.description);

    saveAnimal = (Button) findViewById(R.id.save_animal);
    getAnimals = (Button) findViewById(R.id.get_animals);

    saveAnimal.setOnClickListener(this);
    getAnimals.setOnClickListener(this);
  }

  @Override public void onClick(View view) {
    switch (view.getId()) {
      case R.id.save_animal:
        saveAnimal();
        break;
      case R.id.get_animals:
        showAnimals();
        break;
    }
  }

  private void saveAnimal() {
    RealmManager realmManager = new RealmManager();

    realmManager.saveAnimal(nameAnimal.getText().toString(),
        descriptionAnimal.getText().toString());
  }

  private void showAnimals() {
    Intent intent = new Intent(this, MainActivity.class);
    startActivity(intent);
  }

}
