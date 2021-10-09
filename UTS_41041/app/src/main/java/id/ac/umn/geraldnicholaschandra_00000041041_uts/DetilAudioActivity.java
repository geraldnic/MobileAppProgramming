package id.ac.umn.geraldnicholaschandra_00000041041_uts;

import android.content.Intent;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class DetilAudioActivity extends AppCompatActivity {
    private TextView tvJudul;
    private TextView tvKeterangan;
    private Button btnPlay;
    MediaPlayer mediaPlayer;
    private Resources idt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detil_audio);
        tvJudul = (TextView) findViewById(R.id.detilJudul);
        tvKeterangan = (TextView) findViewById(R.id.detilKeterangan);
        btnPlay = (Button) findViewById(R.id.btnPlay);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        SumberAudio sa = (SumberAudio) bundle.getSerializable(
                "DetilAudio");
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(sa.getJudul());
        tvJudul.setText(sa.getJudul());
        tvKeterangan.setText(sa.getKeterangan());
        int getAudio = sa.getAudioURI();
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                idt = getResources();
                int getIdt = idt.getIdentifier(String.valueOf(getAudio), "raw", getPackageName());
                mediaPlayer = MediaPlayer.create(getApplicationContext(), getIdt);
                mediaPlayer.setOnCompletionListener(mediaPlayer1 -> stopAudio());
                mediaPlayer.start();
            }
        });
    }
    public void stopAudio(){
        mediaPlayer.release();
    }

    @Override
    public void onStop(){
        super.onStop();
        try {
            mediaPlayer.release();
        }catch (Exception e){

        }
    }
}
