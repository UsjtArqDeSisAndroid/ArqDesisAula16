package project.caixaeletronico.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import project.caixaeletronico.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    //acess to account
    public void acessAccount(View view){

        Intent intent = new Intent(this, Account.class);

        startActivity(intent);
    }
}
