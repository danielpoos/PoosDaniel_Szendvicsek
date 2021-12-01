package hu.petrik.szendvicsek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SearchResultActivity extends AppCompatActivity {
    private Button backToMain;
    private TextView textView;

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
        //textview
    }
    public void init(){
        textView = findViewById(R.id.list);
        backToMain = findViewById(R.id.backFromSearch);
    }
}