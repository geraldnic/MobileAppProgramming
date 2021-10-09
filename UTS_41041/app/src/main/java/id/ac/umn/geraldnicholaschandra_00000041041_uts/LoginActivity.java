package id.ac.umn.geraldnicholaschandra_00000041041_uts;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private Button btnNext;
    private EditText namaInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnNext = (Button) this.findViewById(R.id.btnNext);
        namaInput = (EditText) this.findViewById((R.id.namaInput));
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, LibraryActivity.class);
                String input = namaInput.getText().toString();
                if (input.length()==0){
                    namaInput.setError("Harap Di-isi");
                }
                else {
                    intent.putExtra("input", input);
                    startActivityForResult(intent, 1);
                }
            }
        });
    }
}