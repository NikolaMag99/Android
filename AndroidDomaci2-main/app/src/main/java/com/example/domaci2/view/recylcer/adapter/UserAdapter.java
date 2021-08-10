package com.example.domaci2.view.recylcer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.domaci2.R;
import com.example.domaci2.models.User;
import com.example.domaci2.viewmodels.RecyclerViewModel;

import java.util.function.Function;

public class UserAdapter extends ListAdapter<User, UserAdapter.ViewHolder> {


    private final Function<User, Void> onUserClicked;
    private RecyclerViewModel recyclerViewModel;

    public UserAdapter(@NonNull DiffUtil.ItemCallback<User> diffCallback, Function<User, Void> onCarClicked) {
        super(diffCallback);
        this.onUserClicked = onCarClicked;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list_item,parent,false);
        return new ViewHolder(view,parent.getContext(), position -> {
            User user = getItem(position);
//            recyclerViewModel.removeUser(user);
            onUserClicked.apply(user);
            return null;
        });
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = getItem(position);
        holder.bind(user);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final Context context;


        public ViewHolder(@NonNull View itemView, Context context, Function<Integer, Void> onItemClicked) {
            super(itemView);
            this.context = context;
            // TODO
            itemView.findViewById(R.id.imageDelete).setOnClickListener(user -> {
                if(getAdapterPosition() != RecyclerView.NO_POSITION) {
                    onItemClicked.apply(getAdapterPosition());
                }
            });
        }

        public void bind(User user) {
            ImageView imageView = itemView.findViewById(R.id.carPictureIv);
            Glide.with(context).load(user.getPic()).circleCrop().into(imageView);
            ((TextView)itemView.findViewById(R.id.manufacturerTv)).setText(user.getName());
            ((TextView)itemView.findViewById(R.id.modelTv)).setText(user.getSurname());
            ((TextView)itemView.findViewById(R.id.email)).setText(user.getEmail());
            ImageView imageDelete = itemView.findViewById(R.id.imageDelete);
            Glide.with(context).load(user.getPic()).into(imageView);

        }
    }
}
