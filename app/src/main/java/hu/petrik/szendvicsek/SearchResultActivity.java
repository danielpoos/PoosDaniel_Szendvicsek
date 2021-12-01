package hu.petrik.szendvicsek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SearchResultActivity extends AppCompatActivity {
    private Button backToMain;
    private TextView textView;
    private DBHelper ab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        init();
        backToMain.setOnClickListener(v->{
            Intent toMain = new Intent(this,MainActivity.class);
            startActivity(toMain);
            finish();
        });
        Cursor data = ab.list(String.valueOf(MainActivity.money));
        StringBuilder bob = new StringBuilder();
        if (data.getCount() == 0){
            bob.append("Nincs ilyen olcsó szendvics: ").append(MainActivity.money);
        } else {
            while (data.moveToNext()){
                bob.append("Id: ").append(data.getInt(0));
                bob.append(System.lineSeparator());
                bob.append("Név: ").append(data.getString(1));
                bob.append(System.lineSeparator());
                bob.append("Leírás: ").append(data.getString(2));
                bob.append(System.lineSeparator());
                bob.append("Elkészítési idő (perc): ").append(data.getInt(3));
                bob.append(System.lineSeparator());
                bob.append("Ár (Ft): ").append(data.getInt(4));
                bob.append(System.lineSeparator());
                bob.append("++++++++++++++++++++++");
            }
        }
        textView.setText(bob.toString());
    }
    public void init(){
        textView = findViewById(R.id.list);
        backToMain = findViewById(R.id.backFromSearch);
        ab = new DBHelper(this);
    }
}