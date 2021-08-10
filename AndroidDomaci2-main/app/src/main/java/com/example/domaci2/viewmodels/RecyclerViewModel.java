package com.example.domaci2.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.domaci2.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RecyclerViewModel extends ViewModel {


    public static int counter = 101;

    private final MutableLiveData<List<User>> users = new MutableLiveData<>();
    private final ArrayList<User> userList = new ArrayList<>();

    public RecyclerViewModel() {
        for(int i=0; i<=2; i++) {
            User user = new User(i, "https://png.pngtree.com/element_our/png/20181206/users-vector-icon-png_260862.jpg", "Nikola" + i,
                    "Paunovic", "npaunovic5718rn@raf.rs");
            userList.add(user);
        }
//        // ovo radimo zato sto cars.setValue u pozadini prvo proverava da li je pokazivac na objekat isti i ako jeste nece uraditi notifyAll
//        // kreiranjem nove liste dobijamo novi pokazivac svaki put
        ArrayList<User> listToSubmit = new ArrayList<>(userList);
        users.setValue(listToSubmit);
    }

    public LiveData<List<User>> getUsers() {
        return users;
    }

    public void filterUsers(String filter) {
        List<User> filteredList = userList.stream().filter(user -> user.getName().toLowerCase().startsWith(filter.toLowerCase())).collect(Collectors.toList());
        users.setValue(filteredList);
    }

    public void addUser(String pictureUrl, String name, String surname, String email) {
        User user = new User(counter++, pictureUrl, name, surname, email);
        userList.add(user);
        ArrayList<User> listToSubmit = new ArrayList<>(userList);
        users.setValue(listToSubmit);
    }

    public void removeUser(User user) {
        userList.remove(user);
        ArrayList<User> listToSubmit = new ArrayList<>(userList);
        users.setValue(listToSubmit);
    }

}
