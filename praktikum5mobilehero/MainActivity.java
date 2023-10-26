package com.gading.praktikum5mobilehero;
        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.GridLayoutManager;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import android.content.res.TypedArray;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuItem;
        import android.widget.Toast;


        import com.gading.praktikum5mobilehero.hero;

        import java.util.ArrayList;
public class MainActivity extends AppCompatActivity {
    private RecyclerView rvHeroes;
    private ArrayList<hero> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvHeroes = findViewById(R.id.rv_heroes);
        rvHeroes.setHasFixedSize(true);
        list.addAll(getListHeroes());
        showRecyclerList();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_list) {
            rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        }else if (item.getItemId() == R.id.action_grid) {
            rvHeroes.setLayoutManager(new GridLayoutManager(this, 2));
        }
        return super.onOptionsItemSelected(item);
    }
    public ArrayList<hero> getListHeroes(){
        String[] dataName = getResources().getStringArray(R.array.data_name);
        String[] dataDescription = getResources().getStringArray
                (R.array.data_description);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
        ArrayList<hero> listhero = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++){
            hero hero = new hero();
            hero.setName(dataName[i]);
            hero.setDescription(dataDescription[i]);
            hero.setPhoto(dataPhoto.getResourceId(i, -1));
            listhero.add(hero);
        }
        return listhero;
    }
    private void showRecyclerList(){
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        list_hero_adapter listHeroAdapter = new list_hero_adapter(list);
        rvHeroes.setAdapter(listHeroAdapter);
        listHeroAdapter.setOnItemClickCallback(this::showSelectedHero);
    }
    private void showSelectedHero(hero hero) {
        Toast.makeText(this, "Kamu memilih" + hero.getName(), Toast.LENGTH_SHORT).show();
    }
}