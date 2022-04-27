package com.example.online_shop;




import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;


public class RegisterOrLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_or_login);
    }

    public void ClickText(View view) {
        Toast.makeText(this, "!!", Toast.LENGTH_SHORT).show();

    }
}
