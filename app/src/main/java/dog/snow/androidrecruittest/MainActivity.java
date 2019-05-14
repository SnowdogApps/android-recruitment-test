package dog.snow.androidrecruittest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.ListFragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import dog.snow.androidrecruittest.data_repository.SnowDogViewModel;
import dog.snow.androidrecruittest.db.SDDatabase;

public class MainActivity extends AppCompatActivity {


    private SnowDogViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(SnowDogViewModel.class);
//        SDDatabase.Companion.getInstance(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.conteiner_fragment,new ListFragment()).commit();
    }
}
