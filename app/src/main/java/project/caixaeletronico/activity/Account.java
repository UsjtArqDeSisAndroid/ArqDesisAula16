package project.caixaeletronico.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import project.caixaeletronico.R;

public class Account extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
    }

    public void extractActivity(View view) {

        Intent intent = new Intent(this, Extract.class);

        startActivity(intent);

    }

    public void transferActivity(View view) {

        Intent intent = new Intent(this, Transfer.class);

        startActivity(intent);

    }

}
