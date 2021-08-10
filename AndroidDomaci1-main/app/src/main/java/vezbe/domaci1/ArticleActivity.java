package vezbe.domaci1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ArticleActivity extends AppCompatActivity {

    private Button favorite;
    private ImageView zvezda;
    private TextView user;
    private TextView clanak;
    private Boolean favoriteWriten =  false;
    private Boolean load =  false;

    public static final String PREF_MESSAGE_KEY = "prefMessageKey";
    public static final String USER_KEY = "studentKey";
    public static final String FAV = "fav";
    public static final String FAV1 = "fav1";
    public static final String UNF = "unf";
    public static final String FAV2 = "fav2";
    public static final int FAV_WRITE_REQUEST_CODE = 333;
    private String text;
    private String text2;

    private User userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article);
        init();
    }


    private void init() {
        initView();
        parseIntent();
        metoda();
        initListeneres();
    }

    private void initView() {
        clanak = findViewById(R.id.clanak);
        user = findViewById(R.id.textUserName);
        zvezda = findViewById(R.id.imageZvezda);
        favorite = findViewById(R.id.favoriteBtn);
    }

    private void parseIntent() {
        // Proveravamo da li nam je sa Login-a prosledjen user
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        String message2 = sharedPreferences.getString(LoginActivity.PREF_MESSAGE_KEY, null);

        if(message2 != null) {
            Intent intent = getIntent();
            if (intent.getExtras() != null) {
                this.userName = (User) intent.getExtras().getSerializable(USER_KEY);
            }

            String message;
            if (this.userName != null) {
                message = "Welcome " + this.userName.getName();
                user.setText(message);
            } else {
                if (message2 != null){
                    user.setText("Welcome bro " + message2);
                } else
                {
                    message = "Jbg ne radi ";
                    user.setText(message);
                }
            }
        } else {

            user.setText("Sranje");
        }
    }
    private int counter = 2;

    private void initListeneres() {
        favorite.setOnClickListener(v -> {
            SharedPreferences sharedPreferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
            if(favorite.getText().equals("Favorite")) {
                favorite.setText("Unfavorite");
                zvezda.setImageResource(R.drawable.ic_baseline_star_24);
                sharedPreferences
                        .edit()
                        .putString(FAV,"true")
                        .apply();
            }
            else {
                favorite.setText("Favorite");
                zvezda.setImageResource(R.drawable.ic_baseline_star_border_24);
                sharedPreferences
                        .edit()
                        .putString(FAV,"false")
                        .apply();
            }

//            if(favoriteWriten == false){
//                saveDateFav();
////                zvezda.setImageResource(R.drawable.ic_baseline_star_24);
////                loadDateFav();
////                updateFav();
//            } else {
//                saveDateUnf();
////                zvezda.setImageResource(R.drawable.ic_baseline_star_border_24);
////                loadDateUnf();
////                updateUnf();
//            }

//            if (counter % 2 == 0){
//                favorite.setText("Unfavorite");
//                zvezda.setImageResource(R.drawable.ic_baseline_star_24);
//                counter++;
//            }
//            else {
//                favorite.setText("Favorite");
//                zvezda.setImageResource(R.drawable.ic_baseline_star_border_24);
//                counter++;
//            }


        });


    }

    private void saveDateFav() {
//        favorite.setText("Unfavorite");
        SharedPreferences btn = getSharedPreferences(FAV, MODE_PRIVATE);
        SharedPreferences.Editor editor = btn.edit();
        editor.putString(FAV1,favorite.getText().toString());
        editor.apply();
        favoriteWriten =  true;

    }

    private void metoda() {
        SharedPreferences sharedPreferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);
        String message2 = sharedPreferences.getString(FAV, null);
        if(message2 == null) {
            zvezda.setImageResource(R.drawable.ic_baseline_star_border_24);
        }
        else if (message2.equals("true")){
            favorite.setText("Unfavorite");
            zvezda.setImageResource(R.drawable.ic_baseline_star_24);
        }
        else {
            zvezda.setImageResource(R.drawable.ic_baseline_star_border_24);
        }
    }

    private void saveDateUnf() {
        favorite.setText("Favorite");
        SharedPreferences btn = getSharedPreferences(UNF, MODE_PRIVATE);
        SharedPreferences.Editor editor = btn.edit();
        editor.putString(FAV2,favorite.getText().toString());
        editor.apply();
        favoriteWriten =  false;
    }

    private void loadDateFav() {
        SharedPreferences btn = getSharedPreferences(FAV, MODE_PRIVATE);
        text = btn.getString(FAV1,"Favorite");
    }

    private void updateFav() {
        favorite.setText(text);
    }

    private void loadDateUnf() {
        SharedPreferences btn = getSharedPreferences(UNF, MODE_PRIVATE);
        text2 = btn.getString(FAV2,"Unfavorite");
    }

    private void updateUnf() {
        favorite.setText(text2);
        load = false;
    }


}
