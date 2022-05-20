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

public class CreateAccount extends AppCompatActivity {
    Button create;
    TextView haveAcc;
    TextView skip;
    Context context = CreateAccount.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_account);

        create = (Button) findViewById(R.id.create);
        haveAcc = (TextView) findViewById(R.id.haveAcc);
        skip = (TextView) findViewById(R.id.skip);

        create.setOnClickListener(listener);
        haveAcc.setOnClickListener(listener);
        skip.setOnClickListener(listener);
    }
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.create:
                    Toast.makeText(context, "11", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.haveAcc:
                    Intent entryIntent = new Intent(context, Entry.class);
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
