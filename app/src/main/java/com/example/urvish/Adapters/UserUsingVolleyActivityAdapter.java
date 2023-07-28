package com.example.urvish.Adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.urvish.Activity.UserUsingVolleyActivity;
import com.example.urvish.Activity.VolleyUserAddActivity;
import com.example.urvish.R;
import com.example.urvish.modelClasses.VolleyModalClass;

import java.util.ArrayList;



public class UserUsingVolleyActivityAdapter extends RecyclerView.Adapter<UserUsingVolleyActivityAdapter.volleyclass> {

    private UserUsingVolleyActivity userusingvolley;
    private ArrayList<VolleyModalClass> volleystring;
    private VolleyUserAddActivity volleyuseradd;
    private OnAPIResponse onAPIResponse;

    public UserUsingVolleyActivityAdapter(UserUsingVolleyActivity userusingvolley, ArrayList<VolleyModalClass> volleystring) {
        this.userusingvolley = userusingvolley;
        this.volleystring = volleystring;
    }

    public UserUsingVolleyActivityAdapter(VolleyUserAddActivity volleyuseradd, ArrayList<VolleyModalClass> volleystring) {
        this.volleyuseradd=volleyuseradd;
        this.volleystring=volleystring;
    }

    public void setOnAPIResponse(OnAPIResponse onAPIResponse) {
        this.onAPIResponse = onAPIResponse;
    }

    @NonNull
    @Override
    public UserUsingVolleyActivityAdapter.volleyclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.uservolleyadpter,parent,false);
        return new volleyclass(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull UserUsingVolleyActivityAdapter.volleyclass holder, @SuppressLint("RecyclerView") int position) {

        VolleyModalClass ll= volleystring.get(position);

        holder.volley_id.setText    ("id           :"+ll.getId());
        holder.volley_email.setText ("emai      :"+ll.getEmail());
        holder.volley_name.setText  ("name    :"+ll.getName());
        holder.volley_gender.setText("gender  :"+ll.getGender());
        holder.volley_status.setText("status   :"+ll.getStatus());

        holder.volley_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(onAPIResponse!=null && ll!=null){
                    onAPIResponse.deleteUser(ll);
                }
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(onAPIResponse!=null && ll!=null){
                    onAPIResponse.UserUpadet(ll);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return volleystring.size();
    }

    public class volleyclass extends RecyclerView.ViewHolder {

        TextView volley_id,volley_name,volley_email,volley_gender,volley_status;
        ImageView volley_cancel;

        public volleyclass(@NonNull View itemView) {
            super(itemView);

            volley_id=itemView.findViewById(R.id.volley_id);
            volley_name=itemView.findViewById(R.id.volley_name);
            volley_email=itemView.findViewById(R.id.volley_email);
            volley_gender=itemView.findViewById(R.id.volley_gender);
            volley_status=itemView.findViewById(R.id.volley_status);
            volley_cancel=itemView.findViewById(R.id.volley_cancel);
        }
    }

    public interface OnAPIResponse{

        void deleteUser(VolleyModalClass example);

        void UserUpadet(VolleyModalClass ll);
    }

}
