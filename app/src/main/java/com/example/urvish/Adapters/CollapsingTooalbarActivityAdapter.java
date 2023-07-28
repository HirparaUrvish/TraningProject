package com.example.urvish.Adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.urvish.Activity.CollapsingTooalbarActivity;
import com.example.urvish.R;
import com.example.urvish.modelClasses.EmployDetailResponse;

public class CollapsingTooalbarActivityAdapter extends  RecyclerView.Adapter<CollapsingTooalbarActivityAdapter.myvieww1> {

    CollapsingTooalbarActivity collapsingTooalbar;
    EmployDetailResponse personString;

    public CollapsingTooalbarActivityAdapter(CollapsingTooalbarActivity collapsingTooalbar, EmployDetailResponse personString) {
        this.collapsingTooalbar = collapsingTooalbar;
        this.personString = personString;
    }


    @NonNull
    @Override
    public CollapsingTooalbarActivityAdapter.myvieww1 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(collapsingTooalbar).inflate(R.layout.collapsing_item,parent,false);

        return new myvieww1(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull CollapsingTooalbarActivityAdapter.myvieww1 holder, int position) {

        holder.gsonname.setText("Name \n"+personString.getEmployeeDetails().get(position).getName());
        holder.gsongender.setText("Gander \n"+personString.getEmployeeDetails().get(position).getGender());
        holder.gsoneyecolor.setText("Eye Color :"+personString.getEmployeeDetails().get(position).getEyeColor());
        holder.gsonemail.setText("Email :"+personString.getEmployeeDetails().get(position).getEmail());
        holder.gsonphonenumber.setText("Phone number :"+personString.getEmployeeDetails().get(position).getPhone());
        holder.gsoncompany.setText("Company :"+personString.getEmployeeDetails().get(position).getCompany());
        holder.gsonaddress.setText("Address :"+personString.getEmployeeDetails().get(position).getAddress());
        holder.gsontag.setText("Tag :"+personString.getEmployeeDetails().get(position).getTags());
        holder.gsonfriend.setText("No of friend :"+personString.getEmployeeDetails().get(position).getFriends().size());
        holder.gsonfruit.setText("Favourit Fruit :"+personString.getEmployeeDetails().get(position).getFavoriteFruit());
        holder.gsonbalance.setText("Balance :"+personString.getEmployeeDetails().get(position).getBalance());

    }

    @Override
    public int getItemCount() {
        return personString.getEmployeeDetails().size();
    }

    public class myvieww1 extends RecyclerView.ViewHolder {

        TextView gsonname,gsongender,gsoneyecolor,gsonemail,gsonphonenumber,gsoncompany,gsonaddress,gsontag,gsonfriend,gsonfruit,gsonbalance;

        public myvieww1(@NonNull View itemView) {
            super(itemView);

            gsonname=itemView.findViewById(R.id.gsonname1);
            gsongender=itemView.findViewById(R.id.gsongender1);
            gsoneyecolor=itemView.findViewById(R.id.gsoneyecolor1);
            gsonemail=itemView.findViewById(R.id.gsonemail1);
            gsonphonenumber=itemView.findViewById(R.id.gsonphonenumber1);
            gsoncompany=itemView.findViewById(R.id.gsoncompany1);
            gsonaddress=itemView.findViewById(R.id.gsonaddress1);
            gsontag=itemView.findViewById(R.id.gsontag1);
            gsonfriend=itemView.findViewById(R.id.gsonfriend1);
            gsonfruit=itemView.findViewById(R.id.gsonfruit1);
            gsonbalance=itemView.findViewById(R.id.gsonbalance1);

        }
    }
}
