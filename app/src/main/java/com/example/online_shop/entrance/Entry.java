package com.example.online_shop.entrance;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.online_shop.MainActivity;
import com.example.online_shop.R;

public class Entry extends AppCompatActivity {
    Button toCome;
    TextView creatAcc;
    TextView skip;
    Context context = Entry.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.entry);
        toCome = (Button) findViewById(R.id.toCome);
        creatAcc = (TextView) findViewById(R.id.haveRegist);
        skip = (TextView) findViewById(R.id.skip);

        toCome.setOnClickListener(listener);
        creatAcc.setOnClickListener(listener);
        skip.setOnClickListener(listener);
    }
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.toCome:
                    Toast.makeText(context, "11", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.haveRegist:
                    Intent entryIntent = new Intent(context, CreateAccount.class);
                    startActivity(entryIntent);
                    break;
                case R.id.skip:
                    Intent mainIntent = new Intent(context, MainActivity.class);
                    startActivity(mainIntent);
                    break;
            }

        }
    };
}
