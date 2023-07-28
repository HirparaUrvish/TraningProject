package com.example.urvish.Adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.urvish.Activity.RetrofitUserAddActivity;
import com.example.urvish.Activity.UserUsingRetrofitActivity;
import com.example.urvish.R;
import com.example.urvish.modelClasses.RetrofitModal;

import java.util.List;

public class RetrofitUserAddActivityAdapter extends RecyclerView.Adapter<RetrofitUserAddActivityAdapter.volleyclass> {

    UserUsingRetrofitActivity userusingRetrofit;
    List<RetrofitModal> retrofitString;
    OneeAPIResponse oneeAPIResponse;
    RetrofitUserAddActivity retrofitUserAdd;

    public RetrofitUserAddActivityAdapter(RetrofitUserAddActivity retrofitUserAdd, List<RetrofitModal> retrofitString) {
        this.retrofitUserAdd = retrofitUserAdd;
        this.retrofitString = retrofitString;
    }

    public RetrofitUserAddActivityAdapter(UserUsingRetrofitActivity userusingRetrofit, List<RetrofitModal> retrofitString) {
        this.userusingRetrofit = userusingRetrofit;
        this.retrofitString = retrofitString;
    }

    public void setOneeAPIResponse(OneeAPIResponse oneeAPIResponse) {
        this.oneeAPIResponse = oneeAPIResponse;
    }


    @NonNull
    @Override
    public RetrofitUserAddActivityAdapter.volleyclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.userretrofitadpter, parent, false);
        return new volleyclass(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RetrofitUserAddActivityAdapter.volleyclass holder, int position) {

        RetrofitModal ll = retrofitString.get(position);

        holder.retrofit_id.setText("id           :" + ll.getId());
        holder.retrofit_email.setText("emai      :" + ll.getEmail());
        holder.retrofit_name.setText("name    :" + ll.getName());
        holder.retrofit_gender.setText("gender  :" + ll.getGender());
        holder.retrofit_status.setText("status   :" + ll.getStatus());

        holder.retrofit_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (oneeAPIResponse != null && ll != null) {
                    oneeAPIResponse.deleteUserretrofit(ll);
                }

            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (oneeAPIResponse != null && ll != null) {
                    oneeAPIResponse.UserUpadetretrofit(ll);
                }
            }
        });



    }

    @Override
    public int getItemCount() {
        return retrofitString.size();
    }

    public class volleyclass extends RecyclerView.ViewHolder {

        TextView retrofit_id, retrofit_name, retrofit_email, retrofit_gender, retrofit_status;
        ImageView retrofit_cancel;

        public volleyclass(@NonNull View itemView) {
            super(itemView);

            retrofit_id = itemView.findViewById(R.id.retrofit_id);
            retrofit_name = itemView.findViewById(R.id.retrofit_name);
            retrofit_email = itemView.findViewById(R.id.retrofit_email);
            retrofit_gender = itemView.findViewById(R.id.retrofit_gender);
            retrofit_status = itemView.findViewById(R.id.retrofit_status);
            retrofit_cancel = itemView.findViewById(R.id.retrofit_cancel);

        }
    }

    public interface OneeAPIResponse {

        void deleteUserretrofit(RetrofitModal ll);

        void UserUpadetretrofit(RetrofitModal ll);
    }

}
