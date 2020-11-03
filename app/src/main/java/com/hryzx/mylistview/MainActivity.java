package com.hryzx.mylistview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    /*private String[] dataName = {"Institut Pertanian Bogor", " Universitas Indonesia", "Universitas Gadjah Mada",
            "Universitas Airlangga", "Institut Teknologi Bandung", "Institut Teknologi Sepuluh Nopember",
            "Universitas Hasanuddin", "Universitas Brawijaya", "Universitas Diponegoro", "Universitas Padjadjaran"};*/
    private UniversityAdapter adapter;
    private String[] dataName;
    private String[] dataDescription;
    private TypedArray dataImage;
    private ArrayList<University> universities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.lv_list);
        /*ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, dataName);
        listView.setAdapter(adapter);*/
        adapter = new UniversityAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, universities.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataImage = getResources().obtainTypedArray(R.array.data_images);
    }

    private void addItem() {
        universities = new ArrayList<>();

        for (int i = 0; i < dataName.length; i++) {
            University university = new University();
            university.setImage(dataImage.getResourceId(i, -1));
            university.setName(dataName[i]);
            university.setDescription(dataDescription[i]);
            universities.add(university);
        }
        adapter.setUniversities(universities);
    }
}