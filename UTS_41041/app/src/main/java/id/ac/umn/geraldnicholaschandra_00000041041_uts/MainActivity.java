package id.ac.umn.geraldnicholaschandra_00000041041_uts;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
private Button btnProfile, btnLibrary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        btnLibrary = (Button) this.findViewById(R.id.btnLibrary);
        btnLibrary.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                startActivityForResult(intent, 1);
            }
        });

        Intent intent2 = new Intent(MainActivity.this, ProfileActivity.class);
        btnProfile = (Button) this.findViewById(R.id.btnProfile);
        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                startActivityForResult(intent2, 1);
            }
        });
    }
}