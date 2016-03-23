package com.ut.mis49m.phonebooklab;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Contact> CONTACTS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeData();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        RecyclerView rv = (RecyclerView) findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        ContactsAdapter adapter = new ContactsAdapter();
        rv.setAdapter(adapter);
        adapter.setOnItemClickListener(new ContactsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(DetailActivity.POSITION, position);

                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void initializeData() {
        CONTACTS = new ArrayList<>();
        CONTACTS.add(new Contact("Marc-Andre ter Stegen", "#33b5e5", "+34 987654321", "terstegen@fcb.com"));
        CONTACTS.add(new Contact("Luis Suares", "#ffbb33", "+34 987654321", "suares@fcb.com"));
        CONTACTS.add(new Contact("Jordi Alba", "#ff4444", "+34 123456789", "alba@fcb.com"));
        CONTACTS.add(new Contact("Lionel Messi", "#99cc00", "+34 123456789", "messi@fcb.com"));
        CONTACTS.add(new Contact("Neymar", "#33b5e5", "+34 987654321", "neymar@fcb.com"));
        CONTACTS.add(new Contact("Javier Mascherano", "#ffbb33", "+34 123456789", "mascherano@fcb.com"));
        CONTACTS.add(new Contact("Andres Iniesta", "#ff4444", "+34 11235813", "iniesta@fcb.lu"));
        CONTACTS.add(new Contact("Dani Alves", "#99cc00", "+34 987654321", "alves@fcb.com"));

    }
}
