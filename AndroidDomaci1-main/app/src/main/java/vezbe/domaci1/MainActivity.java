package vezbe.domaci1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {



    private Button favorite;
    private ImageView zvezda;
    private TextView user;
    private TextView clanak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        initView();
        initListeneres();
    }

    private void initView() {
        clanak = findViewById(R.id.clanak);
        user = findViewById(R.id.textUserName);
        zvezda = findViewById(R.id.imageZvezda);
        favorite = findViewById(R.id.favoriteBtn);
    }

    private void initListeneres() {
    }
}