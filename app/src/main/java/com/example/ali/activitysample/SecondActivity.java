package com.example.ali.activitysample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class SecondActivity extends MainActivity {
    TextView txtName;
    TextView txtAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Button btnSend = (Button) findViewById(R.id.btnSend);
        //TextView txtName  =(TextView) findViewById(R.id.txtName);
        //TextView txtAge =(TextView) findViewById(R.id.txtAge);

        Intent i = getIntent();
        //Bundle b = i.getExtras();

        model = (PersonModel) i.getSerializableExtra("model");

        String age = model.getAge();
        String name = model.getName();

        txtName = (TextView) findViewById(R.id.txtName);
        txtAge = (TextView) findViewById(R.id.txtAge);

        txtAge.setText(age);
        txtName.setText(name);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return true;
    }

    public void returnData(){
        Intent returnIntent = new Intent();
        String name = txtName.getText().toString();
        String age = txtAge.getText().toString();

        model.setModel(name,age);

        returnIntent.putExtra("model", model);
        setResult(RESULT_OK, returnIntent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:
                break;
            case android.R.id.home:
                returnData();
                return true;
            default:
                break;
        }
        return true;
        //return super.onOptionsItemSelected(item);
    }
}

