package com.example.domaci2.view.recylcer.differ;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.example.domaci2.models.User;

public class UserDiffItemCallback extends DiffUtil.ItemCallback<User> {

    @Override
    public boolean areItemsTheSame(@NonNull User oldItem, @NonNull User newItem) {
        return oldItem.getId() == newItem.getId();
    }

    @Override
    public boolean areContentsTheSame(@NonNull User oldItem, @NonNull User newItem) {
        return oldItem.getPic().equals(newItem.getPic()) &&
                oldItem.getEmail().equals(newItem.getEmail()) &&
                oldItem.getName().equals(newItem.getName()) &&
                oldItem.getSurname().equals(newItem.getSurname());
    }

}
