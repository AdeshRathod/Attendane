package com.example.attendance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

class ClassAdapter extends RecyclerView.Adapter<ClassAdapter.ClassViewHolder> {

    Context context;

    public ClassAdapter(Context context, ArrayList<Classitem> classitems) {
        this.classitems = classitems;
        this.context=context;
    }

    ArrayList<Classitem> classitems;
    public static class ClassViewHolder extends RecyclerView.ViewHolder{

        TextView className;
        TextView subjectName;
        public ClassViewHolder(@NonNull View itemView){

            super(itemView);
            className= itemView.findViewById(R.id.class_tv);
            subjectName= itemView.findViewById(R.id.subject_tv);
        }
    }
    @NonNull
    @Override
    public ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.class_item,parent, false);
        return new ClassViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ClassViewHolder holder, int position) {

        holder.className.setText(classitems.get(position).getClassName());
        holder.subjectName.setText(classitems.get(position).getSubjectName());
    }

    @Override
    public int getItemCount(){
        return classitems.size();

    }

}
