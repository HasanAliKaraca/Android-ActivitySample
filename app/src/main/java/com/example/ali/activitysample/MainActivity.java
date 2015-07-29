package com.example.ali.activitysample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {

    static final int SECONDACTIVITY_REQUEST = 1;  // The request code
    protected PersonModel model;
    TextView txtName;
    TextView txtAge;
    Intent intentSecondAct;

    private View.OnClickListener btnSendClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            String name = txtName.getText().toString();
            String age = txtAge.getText().toString();

            model.setModel(name, age);

            Bundle b = new Bundle();
            b.putString("myVal", "hoppicanko");
            intentSecondAct.putExtras(b);

            intentSecondAct.putExtra("model", model);

            startActivityForResult(intentSecondAct, SECONDACTIVITY_REQUEST);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == SECONDACTIVITY_REQUEST) {
            if (resultCode == RESULT_OK) {
                //String result = data.getStringExtra("result");

                model = (PersonModel) data.getSerializableExtra("model");
                setForm();
            }
            if (resultCode == RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }


    protected void setForm() {

        String name = model.getName();
        String age = model.getAge();

        txtName.setText(name);
        txtAge.setText(age);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intentSecondAct = new Intent(this, SecondActivity.class);

        Button btnSend = (Button) findViewById(R.id.btnSend);
        btnSend.setOnClickListener(btnSendClickListener);

        model = new PersonModel();
        txtName = (TextView) findViewById(R.id.txtName);
        txtAge = (TextView) findViewById(R.id.txtAge);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
