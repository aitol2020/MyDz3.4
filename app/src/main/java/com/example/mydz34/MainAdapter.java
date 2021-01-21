package com.example.mydz34;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    ArrayList<TytleModel> list;
    Context context;

    public MainAdapter(ArrayList<TytleModel> list, Context context) {
        list = new ArrayList<>();
        this.list = list;
        this.context = context;   {


        }
    }

    public void addText(TytleModel titlemodel) {
        list.add(titlemodel);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_list, parent, false);

        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.onBind(list.get(position),position + 1);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
       TextView textView;
       TextView date;
       TextView number;
       TextView textView1;
        TytleModel titlemodel;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.Заголовок);
            textView1 = itemView.findViewById(R.id.Описание);
            date= itemView.findViewById(R.id.date);
            number= itemView.findViewById(R.id.number);

        }

        public void onBind(TytleModel titlemodel , int n) {
            this.titlemodel = titlemodel;
            textView.setText(titlemodel.Tytle);
            textView1.setText(titlemodel.des);
            number.setText(String.valueOf(n));
            date.setText(getStringDate(titlemodel.getDate()));
        }

        private String getStringDate(Date date){
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            String todayAsString = df.format(date);
            return todayAsString;
        }
    }


}
