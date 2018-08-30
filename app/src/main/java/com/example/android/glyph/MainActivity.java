package com.example.android.glyph;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText inputView;
    private TextView outputView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //EdittextView where user will enter input
        inputView = (EditText) findViewById(R.id.input_view);

        //TextView for showing output
        outputView = (TextView) findViewById(R.id.output_view);

        inputView.addTextChangedListener(passwordWatcher);
    }
    //Text watcher is applied so as to change form dynamically
    private final TextWatcher passwordWatcher = new TextWatcher() {
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        public void afterTextChanged(Editable s) {
            if (s.length() == 0) {

            } else{


                //Custom font is applied
                Typeface tf = Typeface.createFromAsset(MainActivity.this.getAssets(),"Pacifico.ttf");
                outputView.setTypeface(tf);

                outputView.setText(inputView.getText().toString());
            }
        }
    };
}
