package com.example.urvish.Adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.urvish.Activity.JsonActivity;
import com.example.urvish.R;
import com.example.urvish.modelClasses.SimpleJsonResponse;

public class JsonActivityAdapter extends RecyclerView.Adapter<JsonActivityAdapter.myvieww111>{

    JsonActivity jsonActivity;
    SimpleJsonResponse permedical;
    /*ArrayList<String> namelist11;
    ArrayList<String> strength11;
    ArrayList<String> dose11;
    ArrayList<String> route11;
    ArrayList<String> sig11;
    ArrayList<String>pillCount11;
    ArrayList<String> refills11;
    ArrayList<String>namelab;
    ArrayList<String> timelab;
    ArrayList<String>locationlab;
*/
    public JsonActivityAdapter(JsonActivity jsonActivity,/* ArrayList<String> namelist11, ArrayList<String> strength11,
                           ArrayList<String> dose11, ArrayList<String> route11, ArrayList<String> sig11, ArrayList<String> pillCount11,
                           ArrayList<String> refills11, ArrayList<String> namelab, ArrayList<String> timelab,
                            ArrayList<String> locationlab*/SimpleJsonResponse permedical) {
        this.jsonActivity = jsonActivity;
        this.permedical=permedical;
        /*this.namelist11 = namelist11;
        this.strength11 = strength11;
        this.dose11 = dose11;
        this.route11 = route11;
        this.sig11 = sig11;
        this.pillCount11 = pillCount11;
        this.refills11 = refills11;
        this.namelab = namelab;
        this.timelab = timelab;
        this.locationlab = locationlab;*/
    }



    @NonNull
    @Override
    public JsonActivityAdapter.myvieww111 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(jsonActivity.getApplicationContext()).inflate(R.layout.simplejsonexample,parent,false);

        return new myvieww111(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull JsonActivityAdapter.myvieww111 holder, int position) {

        holder.namelab1.setText(permedical.getLabs().get(position).getName());
        holder.timelab1.setText(permedical.getLabs().get(position).getTime());
        holder.locationlab1.setText(permedical.getLabs().get(position).getLocation());

        if(position<permedical.getMedications().size())
        {
            holder.user1.setText(permedical.getMedications().get(position).getName());
            holder.user2.setText(permedical.getMedications().get(position).getStrength());
            holder.user3.setText(permedical.getMedications().get(position).getDose());
            holder.user4.setText(permedical.getMedications().get(position).getRoute());
            holder.user5.setText(permedical.getMedications().get(position).getSig());
            holder.user6.setText(permedical.getMedications().get(position).getPillCount());
            holder.user7.setText(permedical.getMedications().get(position).getRefills());
        }else {
            holder.user1.setText("No Data");
            holder.user2.setText("No Data");
            holder.user3.setText("No Data");
            holder.user4.setText("No Data");
            holder.user5.setText("No Data");
            holder.user6.setText("No Data");
            holder.user7.setText("No Data");
        }


       /* }else
        {
            holder.user1.setText("No Data");
            holder.user2.setText("No Data");
            holder.user3.setText("No Data");
            holder.user4.setText("No Data");
            holder.user5.setText("No Data");
            holder.user6.setText("No Data");
            holder.user7.setText("No Data");
        }*/

        /*
        holder.namelab1.setText(namelab.get(position));
        holder.timelab1.setText(timelab.get(position));
        holder.locationlab1.setText(locationlab.get(position));

        if(position<namelist11.size())
        {
            holder.user1.setText(namelist11.get(position));
            holder.user2.setText(strength11.get(position));
            holder.user3.setText(dose11.get(position));
            holder.user4.setText(route11.get(position));
            holder.user5.setText(sig11.get(position));
            holder.user6.setText(pillCount11.get(position));
            holder.user7.setText(refills11.get(position));
        }else
        {
            holder.user1.setText("No Data");
            holder.user2.setText("No Data");
            holder.user3.setText("No Data");
            holder.user4.setText("No Data");
            holder.user5.setText("No Data");
            holder.user6.setText("No Data");
            holder.user7.setText("No Data");
        }
*/
    }
    @Override
    public int getItemCount() {
        return permedical.getLabs().size();
    }

    public class myvieww111 extends RecyclerView.ViewHolder {

        TextView namelab1,timelab1,locationlab1,user1,user2,user3,user4,user5,user6,user7;

        public myvieww111(@NonNull View itemView) {
            super(itemView);

            namelab1=itemView.findViewById(R.id.namelab);
            timelab1=itemView.findViewById(R.id.timelab);
            locationlab1=itemView.findViewById(R.id.locationlab);
            user1=itemView.findViewById(R.id.user1);
            user2=itemView.findViewById(R.id.user2);
            user3=itemView.findViewById(R.id.user3);
            user4=itemView.findViewById(R.id.user4);
            user5=itemView.findViewById(R.id.user5);
            user6=itemView.findViewById(R.id.user6);
            user7=itemView.findViewById(R.id.user7);

        }
    }
}
