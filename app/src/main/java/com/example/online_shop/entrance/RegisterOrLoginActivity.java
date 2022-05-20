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


public class RegisterOrLoginActivity extends AppCompatActivity {
    Button regist;
    TextView sign;
    TextView skip;
    Context context = RegisterOrLoginActivity.this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_or_login);
        regist = (Button) findViewById(R.id.regist);
        sign = (TextView) findViewById(R.id.sign);
        skip = (TextView) findViewById(R.id.skip);
        regist.setOnClickListener(listener);
        sign.setOnClickListener(listener);
        skip.setOnClickListener(listener);
    }

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.regist:
                    Intent registIntent = new Intent(context, CreateAccount.class);
                    startActivity(registIntent);
                    break;
                case R.id.sign:
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


    public void ClickText(View view) {


    }
}
