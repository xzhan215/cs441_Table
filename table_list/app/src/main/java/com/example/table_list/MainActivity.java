package com.example.table_list;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TableLayout table;
    private EditText textbox;
    private Button button_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        table = (TableLayout) findViewById(R.id.table_layout);
        textbox = (EditText) findViewById(R.id.inputText);
        button_add = (Button) findViewById(R.id.button);
    }

    public void buttonClicked(View view){
        button_add.setVisibility(view.GONE);
        textbox.setVisibility(view.GONE);
        table.setVisibility(view.VISIBLE);
        String inputValue = textbox.getText().toString();
        TableRow tableRow;
        tableRow = new TableRow(this);
        TextView text1 = new TextView(this);
        TextView text2 = new TextView(this);
        text1.setText("*");
        text1.setTextSize(20);
        text2.setText(inputValue);
        text2.setTextSize(20);
        tableRow.addView(text1, 0);
        tableRow.addView(text2, 1);
        tableRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                int rowIndex = table.indexOfChild(arg0);
                table.removeViewAt(rowIndex);
            }
        });
        table.addView(tableRow);
        textbox.setText("");
    }

    public void addNewNote(View view){
        table.setVisibility(view.GONE);
        button_add.setVisibility(view.VISIBLE);
        textbox.setVisibility(view.VISIBLE);
    }
}
