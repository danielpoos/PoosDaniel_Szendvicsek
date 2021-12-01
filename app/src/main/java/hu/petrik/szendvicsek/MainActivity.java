package hu.petrik.szendvicsek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button searchA,insertA;
    private static EditText priceET;
    public static int money = Integer.parseInt(priceET.getText().toString());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        insertA.setOnClickListener(v -> {
            Intent toInsert = new Intent(this, InsertActivity.class);
            startActivity(toInsert);
            finish();
        });
        searchA.setOnClickListener(v->{
            Intent toSearch = new Intent(this, SearchResultActivity.class);
            if (!priceET.getText().toString().isEmpty()){
                startActivity(toSearch);
                finish();
            }
            else Toast.makeText(this, "Nem hagyhatja üresen a mezőt!", Toast.LENGTH_SHORT).show();
        });
    }
    public void init(){
        priceET = findViewById(R.id.price);
        insertA = findViewById(R.id.newBtn);
        searchA = findViewById(R.id.searchBtn);
    }
}