package com.evansimpson.mobpro.lab1;

/**
 * Created by dhellen on 9/14/13.
 */

import android.app.ListActivity;

//package com.javasamples;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ArrayAdapterDemo extends ListActivity {
    TextView selection;
    //String[] items = { "this", "is", "a", "really",
            //"silly", "list" };

    ArrayList<String> tasks;
    private EditText mEditText;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        tasks = new ArrayList<String>();

        tasks.add("other string");
        tasks.add("string");
        tasks.add("whee!");
        tasks.remove(2);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setListAdapter(new ArrayAdapter<String>(
                this,
                android.R.layout.simple_expandable_list_item_1,
                tasks));
        selection=(TextView)findViewById(R.id.selection);


       Button b = (Button) findViewById(R.id.button1); // creates a button b and attaching it to the UI element called button1 on the view
        b.setOnClickListener(new View.OnClickListener() { // creates and sets an onClickListener for the button b
            @Override
               public void onClick(View view) {
                //tasks.add("yay");
               final EditText editText = (EditText) findViewById(R.id.editText);
               String editTextStr = editText.getText().toString();
               tasks.add(editTextStr);
           }
        });
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        String text = " position:" + position + "  " + tasks.get(position);
        selection.setText(text);
    }

}