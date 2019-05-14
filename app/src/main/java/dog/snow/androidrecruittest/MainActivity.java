package dog.snow.androidrecruittest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import dog.snow.androidrecruittest.data_repository.SnowDogViewModel;
import dog.snow.androidrecruittest.ui.list.SnowDogListFragment;

public class MainActivity extends AppCompatActivity {


    private SnowDogViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        setContentView(R.layout.activity_main);
        viewModel = ViewModelProviders.of(this).get(SnowDogViewModel.class);
//        SnowDogDatabase.Companion.getInstance(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.conteiner_fragment,new SnowDogListFragment()).commit();
    }
}
