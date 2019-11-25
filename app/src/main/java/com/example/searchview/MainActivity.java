package com.example.searchview;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.widget.SearchView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.searchview.Adapter.ItemsAdapter;
import com.example.searchview.Adapter.Model.modelclass;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerview;
    ItemsAdapter itemsAdapter;
    List<modelclass> list = new ArrayList<>();
    List<modelclass> lists1 = new ArrayList<>();
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview = findViewById(R.id.recyclerview);
        searchView = findViewById(R.id.searching);

        getDetails();


        recyclerview.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerview.hasFixedSize();
        itemsAdapter = new ItemsAdapter(getApplicationContext(),list);
        recyclerview.setAdapter(itemsAdapter);




        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                itemsAdapter.getFilter().filter(newText);

                Log.d("xyzz",newText);

                return true;
            }
        });


    }

    private void getDetails() {
        list.add(new modelclass("ATLANTIC"));
        list.add(new modelclass("BRITISH"));
        list.add(new modelclass("CANBERRA"));
        list.add(new modelclass("DOG"));
        list.add(new modelclass("ELEPHANT"));
        list.add(new modelclass("FAN"));
        list.add(new modelclass("GUN"));
        list.add(new modelclass("HINDI"));
        list.add(new modelclass("INK POT"));
        list.add(new modelclass("JACKAL"));
        list.add(new modelclass("KINGSTON"));
        list.add(new modelclass("LITHIUM"));

    }
}