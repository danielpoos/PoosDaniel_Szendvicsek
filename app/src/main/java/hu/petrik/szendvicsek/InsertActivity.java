package hu.petrik.szendvicsek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InsertActivity extends AppCompatActivity {
    private Button backToMain, save;
    private EditText name, detail, makingT, prise;
    private DBHelper ab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        init();
        backToMain.setOnClickListener(v->{
            Intent toMain = new Intent(this, MainActivity.class);
            startActivity(toMain);
            finish();
        });
        save.setOnClickListener(v->{
            if (!(name.getText().toString().isEmpty()&&prise.getText().toString().isEmpty()&&detail.getText().toString().isEmpty()&&makingT.getText().toString().isEmpty())){
                if(ab.save(name.getText().toString(),detail.getText().toString(),makingT.getText().toString(),prise.getText().toString())){
                    Toast.makeText(this, "Sikeres szendvics felvétel :)", Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(this, "Sikertelen szendvics felvétel :(", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void init(){
        name = findViewById(R.id.nameET);
        detail = findViewById(R.id.detailsET);
        makingT = findViewById(R.id.makingET);
        prise = findViewById(R.id.priceET);
        backToMain = findViewById(R.id.backFromInsert);
        save = findViewById(R.id.saveBtn);
        ab = new DBHelper(this);
    }
}