package com.example.attendance;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
     FloatingActionButton fab;
     RecyclerView recyclerView;
     ClassAdapter classAdapter;
     RecyclerView.LayoutManager layoutManager;
     ArrayList<Classitem> classitems =new ArrayList<>();

     EditText class_edt;
     EditText subject_edt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fab=findViewById(R.id.fab_main);
        fab.setOnClickListener(v -> showDialog());

        recyclerView=findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(this);

        classAdapter= new ClassAdapter(this, classitems);
        recyclerView.setAdapter(classAdapter);
    }

    private void showDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.class_dialog, null);
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.show();


        class_edt= view.findViewById(R.id.class_edt);
        subject_edt= view.findViewById(R.id.subject_edt);

        Button cancel = view.findViewById(R.id.cancel_button);
        Button add = view.findViewById(R.id.add_button);

        cancel.setOnClickListener(v -> dialog.dismiss());

    }
    
    private void addClass(){
         String className = class_edt.getText().toString();
         String subjectName = subject_edt.getText().toString();
         classitems.add(new Classitem(className,subjectName));

    }
}