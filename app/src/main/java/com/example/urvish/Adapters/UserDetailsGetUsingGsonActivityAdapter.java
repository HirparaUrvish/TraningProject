package com.example.urvish.Adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.urvish.Activity.UserDetailsGetUsingGsonActivity;
import com.example.urvish.R;
import com.example.urvish.modelClasses.EmployDetailResponse;

public class UserDetailsGetUsingGsonActivityAdapter extends RecyclerView.Adapter<UserDetailsGetUsingGsonActivityAdapter.myvieww>{

    UserDetailsGetUsingGsonActivity userDetailsgetusingGsonActivity;
    EmployDetailResponse personString;
    /*ArrayList<String> taglist;
    ArrayList<String> namelist;
    ArrayList<String> genderlist;
    ArrayList<String> eyelist;
    ArrayList<String> emaillist;
    ArrayList<String> phonelist;
    ArrayList<String> companylist;
    ArrayList<String> addresslist;
    ArrayList<String> friendnamelist;
    ArrayList<String> idlist;
    ArrayList<String> fruitlist;
    ArrayList<String> balancelist;*/

    public UserDetailsGetUsingGsonActivityAdapter(UserDetailsGetUsingGsonActivity userDetailsgetusingGsonActivity,/* ArrayList<String> taglist, ArrayList<String> namelist,
                           ArrayList<String> genderlist, ArrayList<String> eyelist, ArrayList<String> emaillist, ArrayList<String> phonelist,
                           ArrayList<String> companylist, ArrayList<String> addresslist, ArrayList<String> friendnamelist,
                           ArrayList<String> idlist, ArrayList<String> fruitlist, ArrayList<String> balancelist*/EmployDetailResponse personString) {
        this.userDetailsgetusingGsonActivity = userDetailsgetusingGsonActivity;
        this.personString=personString;
       /* this.taglist = taglist;
        this.namelist = namelist;
        this.genderlist = genderlist;
        this.eyelist = eyelist;
        this.emaillist = emaillist;
        this.phonelist = phonelist;
        this.companylist = companylist;
        this.addresslist = addresslist;
        this.friendnamelist = friendnamelist;
        this.idlist = idlist;
        this.fruitlist = fruitlist;
        this.balancelist = balancelist;*/
    }


    @NonNull
    @Override
    public UserDetailsGetUsingGsonActivityAdapter.myvieww onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(userDetailsgetusingGsonActivity.getApplicationContext()).inflate(R.layout.usergsonitemadpter,parent,false);

        return new myvieww(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull UserDetailsGetUsingGsonActivityAdapter.myvieww holder, int position) {


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

        /*holder.gsonname.setText("Name \n"+namelist.get(position));
        holder.gsongender.setText("Gander \n"+genderlist.get(position));
        holder.gsoneyecolor.setText("Eye Color :"+eyelist.get(position));
        holder.gsonemail.setText("Email :"+emaillist.get(position));
        holder.gsonphonenumber.setText("Phone number :"+phonelist.get(position));
        holder.gsoncompany.setText("Company :"+companylist.get(position));
        holder.gsonaddress.setText("Address :"+addresslist.get(position));
        holder.gsontag.setText("Tag :"+taglist.get(position));
        holder.gsonfriend.setText("No of friend :"+friendnamelist.get(position));
        holder.gsonfruit.setText("Favourit Fruit :"+fruitlist.get(position));
        holder.gsonbalance.setText("Balance :"+balancelist.get(position));*/

    }

    @Override
    public int getItemCount() {
        return personString.getEmployeeDetails().size();
    }

    public class myvieww extends RecyclerView.ViewHolder {

        TextView gsonname,gsongender,gsoneyecolor,gsonemail,gsonphonenumber,gsoncompany,gsonaddress,gsontag,gsonfriend,gsonfruit,gsonbalance;

        public myvieww(@NonNull View itemView) {
            super(itemView);

            gsonname=itemView.findViewById(R.id.gsonname);
            gsongender=itemView.findViewById(R.id.gsongender);
            gsoneyecolor=itemView.findViewById(R.id.gsoneyecolor);
            gsonemail=itemView.findViewById(R.id.gsonemail);
            gsonphonenumber=itemView.findViewById(R.id.gsonphonenumber);
            gsoncompany=itemView.findViewById(R.id.gsoncompany);
            gsonaddress=itemView.findViewById(R.id.gsonaddress);
            gsontag=itemView.findViewById(R.id.gsontag);
            gsonfriend=itemView.findViewById(R.id.gsonfriend);
            gsonfruit=itemView.findViewById(R.id.gsonfruit);
            gsonbalance=itemView.findViewById(R.id.gsonbalance);

        }
    }

}
