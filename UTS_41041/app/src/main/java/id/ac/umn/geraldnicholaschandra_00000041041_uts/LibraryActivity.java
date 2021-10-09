package id.ac.umn.geraldnicholaschandra_00000041041_uts;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.LinkedList;

public class LibraryActivity extends AppCompatActivity {
    RecyclerView rvDaftarAudio;
    DaftarAudioAdapter mAdapter;
    LinkedList<SumberAudio> daftarAudio = new LinkedList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        isiDaftarVideo();
        rvDaftarAudio = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new DaftarAudioAdapter(this, daftarAudio);
        rvDaftarAudio.setAdapter(mAdapter);
        rvDaftarAudio.setLayoutManager(new LinearLayoutManager(this));

        Intent intentNama = getIntent();
        String stringNama = intentNama.getStringExtra("input");

        // use ActionBar utility methods
        ActionBar actionBar = getSupportActionBar();

        // providing title for the ActionBar
        actionBar.setTitle(stringNama);
    }
    public void isiDaftarVideo(){
        daftarAudio.add(new SumberAudio("Safe And Sound",
                "Music", R.raw.safe_and_sound));
        daftarAudio.add(new SumberAudio("OTW Bandung",
                "Music", R.raw.otw_bandung));
        daftarAudio.add(new SumberAudio("DJ Corona vs Carlota",
                "Music", R.raw.corona_vs_carlota));
        daftarAudio.add(new SumberAudio("GTA San Andreas Ringtone",
                "Ringtone", R.raw.gta_san_andreas));
        daftarAudio.add(new SumberAudio("Spongebob Ringtone",
                "Ringtone", R.raw.spongebob));
    }



    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.profileAction:
                Intent profileIntent = new Intent(LibraryActivity.this,
                        ProfileActivity.class);
                startActivity(profileIntent);
                return true;
            case R.id.homeAction:
                Intent homeIntent = new Intent(LibraryActivity.this,
                        MainActivity.class);
                startActivity(homeIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


}