package vezbe.domaci1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    private ImageView image;
    private EditText password;
    private EditText username;
    private Button loginBtn;
    private String userSave;

    public static final String PREF_MESSAGE_KEY = "prefMessageKey";
    public static final int PREFERENCE_WRITE_REQUEST_CODE = 222;
    private boolean messageWritten = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

    private void init() {
        initView();
        initListener();
    }

    private void initView() {
        image = findViewById(R.id.imageLogin);
        password = findViewById(R.id.passwordLogin);
        username = findViewById(R.id.usernameLogin);
        loginBtn = findViewById(R.id.loginBtn);
    }

    private void initListener() {
        loginBtn.setOnClickListener(v -> {
            cuvanje();
//            SharedPreferences sharedPreferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
//            sharedPreferences
//                    .edit()
//                    .putString(PREF_MESSAGE_KEY, username.getText().toString())
//                    .apply();
//            messageWritten = true;
//            if (messageWritten){
//                Intent intent = new Intent(this, ArticleActivity.class);
//                intent.putExtra(ArticleActivity.USER_KEY, new User(username.getText().toString()));
//                startActivityForResult(intent, PREFERENCE_WRITE_REQUEST_CODE);
//                Toast.makeText(this, "Dobro ti meni doso " + username.getText().toString(), Toast.LENGTH_SHORT).show();
//            }
////            Intent intent = new Intent(this, ArticleActivity.class);
//           // Toast.makeText(this, "Dobro ti meni doso bato" + username.getText().toString(), Toast.LENGTH_SHORT).show();
        });

    }

    private void cuvanje() {
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        sharedPreferences
                .edit()
                .putString(PREF_MESSAGE_KEY, username.getText().toString())
                .apply();
        messageWritten = true;
        if (messageWritten){
            Intent intent = new Intent(this, ArticleActivity.class);
            intent.putExtra(ArticleActivity.USER_KEY, new User(username.getText().toString()));
            startActivityForResult(intent, PREFERENCE_WRITE_REQUEST_CODE);
            Toast.makeText(this, "Dobro ti meni doso " + username.getText().toString(), Toast.LENGTH_SHORT).show();
        }
    }

}