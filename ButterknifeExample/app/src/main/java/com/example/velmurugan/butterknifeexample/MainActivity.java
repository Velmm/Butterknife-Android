package com.example.velmurugan.butterknifeexample;

import android.app.Dialog;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Property;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindColor;
import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import butterknife.Optional;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tvName)
    TextView tvName;

    @BindColor(R.color.black) int black;
    @BindString(R.string.website) String website;
    @BindDrawable(R.drawable.ic_launcher_background)
    Drawable image;

    @BindViews({R.id.tvName,R.id.address,R.id.city})
    List<TextView> location;

    @BindView(R.id.spinner)
    Spinner spinner;

    private List<Movie> movieList;
    private RecyclerviewAdapter recyclerviewAdapter;

    @BindView(R.id.recylerview)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieList = new ArrayList<>();
        ButterKnife.bind(this);
        tvName.setText(website);
        tvName.setTextColor(black);

        List<String> stringList = new ArrayList<>();
        stringList.add("Item 1");
        stringList.add("Item 2");
        stringList.add("Item 3");
        ArrayAdapter arrayAdapter = new ArrayAdapter(this,R.layout.support_simple_spinner_dropdown_item,stringList);
        spinner.setAdapter(arrayAdapter);


        Movie movie = new Movie("Star Wars The Last Jedi","2016");
        movieList.add(movie);
        movie = new Movie("Coco","2016");
        movieList.add(movie);
        movie = new Movie("Justice League ","2016");
        movieList.add(movie);
        movie = new Movie("Thor: Ragnarok","2016");
        movieList.add(movie);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerviewAdapter = new RecyclerviewAdapter(movieList);
        recyclerView.setAdapter(recyclerviewAdapter);

        ButterKnife.Action<TextView> ACTION_COLOR = new ButterKnife.Action<TextView>() {
            @Override
            public void apply(@NonNull TextView view, int index) {
                view.setTextColor(black);
            }
        };

        ButterKnife.apply(location, ACTION_COLOR);


        ButterKnife.apply(location,View.ROTATION_X,0.3f);

        ButterKnife.Setter<TextView,Boolean> SETTER = new ButterKnife.Setter<TextView, Boolean>() {
            @Override
            public void set(@NonNull TextView view, Boolean value, int index) {

                view.setClickable(value);
            }
        };
        ButterKnife.apply(location,SETTER,true);

    }




    // Single view button click event with view param
    // @OnClick(R.id.button1)
    // public void sayHello(View view){
    // Toast.makeText(this,helloText,Toast.LENGTH_SHORT).show();
    // }

    @OnClick(R.id.tvName)
    public void NameClick(TextView view){
        Toast.makeText(getApplicationContext(),view.getText().toString(),Toast.LENGTH_SHORT).show();

    }


    @OnItemSelected(value = R.id.spinner, callback = OnItemSelected.Callback.ITEM_SELECTED)
    public void OnItemSelected(Spinner spinner){
        Toast.makeText(getApplicationContext(),spinner.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
    }


}
