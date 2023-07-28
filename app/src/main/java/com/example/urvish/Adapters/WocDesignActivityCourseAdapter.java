package com.example.urvish.Adapters;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Build;
import android.text.format.DateFormat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.urvish.Activity.WocDesignActivity;
import com.example.urvish.R;
import com.example.urvish.modelClasses.WocCourseModal;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Calendar;

import de.hdodenhof.circleimageview.CircleImageView;

public class WocDesignActivityCourseAdapter extends RecyclerView.Adapter<WocDesignActivityCourseAdapter.ViewHolder> {

    ArrayList<WocCourseModal> courseModalArrayList;
    WocDesignActivity woc_activity;
    public static Uri adpateruri;
    final int SENDER = 0;
    final int RECEIVER = 1;
    private OnImageAndTextUpdateListener listener;


    public WocDesignActivityCourseAdapter(ArrayList<WocCourseModal> courseModalArrayList, WocDesignActivity woc_activity) {
        this.courseModalArrayList = courseModalArrayList;
        this.woc_activity = woc_activity;
    }

    @Override
    public int getItemViewType(int position) {
        WocCourseModal modal = courseModalArrayList.get(position);
        if (modal.getSendername().equals("User")) {
            return SENDER;
        } else {
            return RECEIVER;
        }

    }

    @NonNull
    @Override
    public WocDesignActivityCourseAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 1) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.woc_item1, parent, false);
            return new ViewHolder(v);
        } else {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.woc_item2, parent, false);
            return new ViewHolder(v);
        }
    }

    public interface OnImageAndTextUpdateListener {
        void onImageAndTextUpdate(int position, Uri imageUri, String text);
    }


    public void setOnImageAndTextUpdateListener(OnImageAndTextUpdateListener listener) {
        this.listener = listener;
    }


    private void updateImageAndText(int position, Uri imageUri, String text) {
        if (listener != null) {
            listener.onImageAndTextUpdate(position, imageUri, text);
        }
    }

    @SuppressLint({"SetTextI18n", "ResourceAsColor"})
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        WocCourseModal modal = courseModalArrayList.get(position);

        //for date
        long previous_position = 0;
        if (position >= 1) {
            WocCourseModal modal1 = courseModalArrayList.get(position - 1);
            previous_position = modal1.getDateee();
        }
        if (previous_position == 0) {
            holder.date_woc.setVisibility(View.VISIBLE);
            Calendar cal1 = Calendar.getInstance();
            cal1.setTimeInMillis(modal.getDateee());
            Calendar now = Calendar.getInstance();
            if (now.get(Calendar.DATE) == cal1.get(Calendar.DATE)) {
                holder.date_woc.setText("Today");
            } else if (now.get(Calendar.DATE) - cal1.get(Calendar.DATE) == 1) {
                holder.date_woc.setText("Yesterday");
            } else {
                holder.date_woc.setText(DateFormat.format("dd-MM-yyyy", cal1.getTimeInMillis()));
            }
        } else {
            Calendar cal1 = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();
            cal1.setTimeInMillis(modal.getDateee());
            cal2.setTimeInMillis(previous_position);

            boolean sameDay = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH) &&
                    cal1.get(Calendar.DAY_OF_YEAR) == cal2.get(Calendar.DAY_OF_YEAR);
            if (sameDay) {
                holder.date_woc.setVisibility(View.GONE);
                holder.date_woc.setText("");
            } else {
                holder.date_woc.setVisibility(View.VISIBLE);
                Calendar cal11 = Calendar.getInstance();
                cal11.setTimeInMillis(modal.getDateee());
                Calendar now = Calendar.getInstance();
                if (now.get(Calendar.DATE) == cal11.get(Calendar.DATE)) {
                    holder.date_woc.setText("Today");
                } else if (now.get(Calendar.DATE) - cal11.get(Calendar.DATE) == 1) {
                    holder.date_woc.setText("Yesterday");
                } else {
                    holder.date_woc.setText(DateFormat.format("dd-MM-yyyy", cal11.getTimeInMillis()));
                }
            }

        }

        //for gravity
        if (modal.getSendername().equals("User")) {
            if (modal.getSetgrvity() == Gravity.RIGHT) {
                holder.wocitem1.setGravity(Gravity.RIGHT);
                holder.woc_item1_arrow.setImageResource(R.drawable.ic_baseline_keyboard_arrow_left_24);
            }
            if (modal.getSetgrvity() == Gravity.CENTER_HORIZONTAL) {
                holder.wocitem1.setGravity(Gravity.CENTER_HORIZONTAL);
                holder.woc_item1_arrow.setImageResource(R.drawable.ic_baseline_keyboard_arrow_right_24);
            }
        } else {
            if (modal.getSetgrvity() == Gravity.LEFT) {
                holder.wocitem1.setGravity(Gravity.LEFT);
                holder.woc_item1_arrow.setImageResource(R.drawable.ic_baseline_keyboard_arrow_right_24);
            }
            if (modal.getSetgrvity() == Gravity.CENTER_HORIZONTAL) {
                holder.wocitem1.setGravity(Gravity.CENTER_HORIZONTAL);
                holder.woc_item1_arrow.setImageResource(R.drawable.ic_baseline_keyboard_arrow_left_24);
            }
        }

        //for User message
        String messge = modal.getUsermassage();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            if (!messge.isEmpty()) {
                holder.woc_item1_textview.setVisibility(View.VISIBLE);
                holder.woc_item1_textview.setText("" + modal.getUsermassage());
            } else {
                holder.woc_item1_textview.setVisibility(View.GONE);
            }
        }
        holder.woc_item1_time.setText("" + modal.getStrDate());

        //for user message image
        String user_image = String.valueOf(modal.getImagesss());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
            if (!user_image.isEmpty()) {
                holder.woc_images.setImageURI(Uri.parse(user_image));
                holder.woc_images.setVisibility(View.VISIBLE);
            } else {
                holder.woc_images.setVisibility(View.GONE);
            }
        }

        //delete user message
        holder.woc_item1_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(woc_activity);
                builder.setMessage("Do you want to Delete this Message ?").setCancelable(false);
                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @SuppressLint("NotifyDataSetChanged")
                    public void onClick(DialogInterface dialog, int id) {
                        courseModalArrayList.remove(position);
                        WocDesignActivity.sharedPreferences = woc_activity.getSharedPreferences("shared preferences", MODE_PRIVATE);
                        WocDesignActivity.editor = WocDesignActivity.sharedPreferences.edit();
                        Gson gson = new Gson();
                        String json = gson.toJson(courseModalArrayList);
                        WocDesignActivity.editor.putString("courses", json);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                            WocDesignActivity.editor.apply();
                        }
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        //edit user message & image
        holder.woc_item1_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user_message = modal.getUsermassage();
                setOnImageAndTextUpdateListener(listener);
                Uri User_imageuri = Uri.parse(modal.getImagesss());
                updateImageAndText(position, User_imageuri, user_message);

            }
        });


        //change the gravity for message
        holder.woc_item1_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (modal.getSendername().equals("User")) {
                    if (modal.getSetgrvity() == Gravity.RIGHT) {
                        int first = Gravity.CENTER_HORIZONTAL;
                        modal.setSetgrvity(first);
                        holder.wocitem1.setGravity(Gravity.CENTER_HORIZONTAL);
                        holder.woc_item1_arrow.setImageResource(R.drawable.ic_baseline_keyboard_arrow_right_24);

                    } else {
                        int second = Gravity.RIGHT;
                        modal.setSetgrvity(second);
                        holder.wocitem1.setGravity(Gravity.RIGHT);
                        holder.woc_item1_arrow.setImageResource(R.drawable.ic_baseline_keyboard_arrow_left_24);

                    }
                } else {
                    if (modal.getSetgrvity() == Gravity.LEFT) {
                        int first1 = Gravity.CENTER_HORIZONTAL;
                        modal.setSetgrvity(first1);
                        holder.wocitem1.setGravity(Gravity.CENTER_HORIZONTAL);
                        holder.woc_item1_arrow.setImageResource(R.drawable.ic_baseline_keyboard_arrow_left_24);

                    } else {
                        int second1 = Gravity.LEFT;
                        modal.setSetgrvity(second1);
                        holder.wocitem1.setGravity(Gravity.LEFT);
                        holder.woc_item1_arrow.setImageResource(R.drawable.ic_baseline_keyboard_arrow_right_24);

                    }
                }
                WocDesignActivity.sharedPreferences = woc_activity.getSharedPreferences("shared preferences", MODE_PRIVATE);
                WocDesignActivity.editor = WocDesignActivity.sharedPreferences.edit();
                Gson gson = new Gson();
                String json = gson.toJson(courseModalArrayList);
                WocDesignActivity.editor.putString("courses", json);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD) {
                    WocDesignActivity.editor.apply();
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return courseModalArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView woc_item1_textview, woc_item1_time, date_woc;
        ImageView woc_images;
        CircleImageView woc_item1_arrow, woc_item1_edit, woc_item1_delete;
        LinearLayout wocitem1;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            woc_item1_textview = itemView.findViewById(R.id.woc_item1_textview);
            woc_item1_time = itemView.findViewById(R.id.woc_item1_time);
            woc_item1_arrow = itemView.findViewById(R.id.woc_item1_arrow);
            woc_item1_edit = itemView.findViewById(R.id.woc_item1_edit);
            woc_item1_delete = itemView.findViewById(R.id.woc_item1_delete);
            wocitem1 = itemView.findViewById(R.id.wocitem1);
            date_woc = itemView.findViewById(R.id.date_woc);
            woc_images = itemView.findViewById(R.id.woc_images);
        }
    }
}
