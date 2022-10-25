package com.example.sharedpreference_hanan;

import static com.example.sharedpreference_hanan.R.id.text_kelas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    TextView textView_name, textView_npm, textView_kelas, textView_prodi;
    Button button_logout;

    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";
    private static final String KEY_NPM = "npm";
    private static final String KEY_KELAS = "kelas";
    private static final String KEY_PRODI = "prodi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        textView_npm = findViewById(R.id.text_npm);
        textView_name = findViewById(R.id.text_fullname);
        textView_kelas = findViewById(text_kelas);
        textView_prodi = findViewById(R.id.text_prodi);

        button_logout = findViewById(R.id.button_logout);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String name = sharedPreferences.getString(KEY_NAME, null);
        String npm = sharedPreferences.getString(KEY_NPM, null);
        String kelas = sharedPreferences.getString(KEY_KELAS, null);
        String prodi = sharedPreferences.getString(KEY_PRODI, null);

        if (name != null || npm != null){
            textView_name.setText("Nama - "+name);
            textView_npm.setText("NPM - "+npm);
            textView_kelas.setText("Kelas - "+kelas);
            textView_prodi.setText("Prodi - "+prodi);
        }

        button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(HomeActivity.this, "Logout Success", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}