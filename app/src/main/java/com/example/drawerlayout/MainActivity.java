package com.example.drawerlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    Employee employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getitemstarted();
        deserialization();
        usingjson();

    }

    public void getitemstarted()
    {
        navigationView=findViewById(R.id.navview);
        drawerLayout=findViewById(R.id.drawlayout);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if(item.getItemId()==R.id.item_home)
                {
                    Toast.makeText(MainActivity.this, "Home", Toast.LENGTH_SHORT).show();
                    return true;
                }
                else if(item.getItemId()==R.id.item_search)
                {
                    Toast.makeText(MainActivity.this, "Search", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });

    }

    public void usingjson()
    {
        employee=new Employee("Ibrahim","Ibrahim@gmail.com",20);
        Gson gson=new Gson();
        String json=gson.toJson(employee);

    }

    public void deserialization()
    {
        Gson gson=new Gson();

        String json="{\"name\":\"Ibrahim\",\"Email\":\"Ibrahim@gmail.com\",\"age\":20}";
        Employee employee=gson.fromJson(json,Employee.class);
    }
}
