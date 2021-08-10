package com.example.domaci2.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.domaci2.R;
import com.example.domaci2.view.recylcer.adapter.UserAdapter;
import com.example.domaci2.view.recylcer.differ.UserDiffItemCallback;
import com.example.domaci2.viewmodels.RecyclerViewModel;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private EditText findContact;
    private Button addBtn;
    private EditText addText;

    private RecyclerViewModel recyclerViewModel;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        recyclerViewModel = new ViewModelProvider(this).get(RecyclerViewModel.class);
        init();
    }

    private void init() {
        initView();
        initListeneres();
        initObservers();
        initRecycler();
    }

    private void initView() {
        findContact = findViewById(R.id.findUser);
        recyclerView = findViewById(R.id.listRv);
        addText = findViewById(R.id.inputEt);
        addBtn = findViewById(R.id.doMagicBtn);
    }

    private void initListeneres() {
        findContact.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                addBtn.setEnabled(false);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                recyclerViewModel.filterUsers(s.toString());

            }
        });

        addText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                findContact.getText().clear();
                addBtn.setEnabled(true);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        addBtn.setOnClickListener(v -> {
            recyclerViewModel.addUser("https://static.thenounproject.com/png/17241-200.png",addText.getText().toString(), "Paunovic",
                    addText.getText().toString() + "paunovic5718rn@raf.rs");
        });
    }

    private void initObservers() {
        recyclerViewModel.getUsers().observe(this, users -> {
            userAdapter.submitList(users);
        });
    }

    private void initRecycler() {
        userAdapter = new UserAdapter(new UserDiffItemCallback(), user -> {
            recyclerViewModel.removeUser(user);
//            Toast.makeText(this, user.getId()+"", Toast.LENGTH_SHORT).show();
            return null;
        });
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(userAdapter);

    }
}