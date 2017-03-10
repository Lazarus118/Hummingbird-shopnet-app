package co.aulatech.e_portal_auth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;


public class StartActivity extends Activity {
    EditText officer_number, user_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        // ACTIVITY WILL START ONLY ONCE
        // -----------------------------------------------------------------
        SharedPreferences pref = getSharedPreferences("ActivityPREF", Context.MODE_PRIVATE);
        if (pref.getBoolean("activity_executed", false)) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            SharedPreferences.Editor ed = pref.edit();
            ed.putBoolean("activity_executed", true);
            ed.apply();
        }

        // OFFICER EDIT LOGIC
        // -----------------------------------------------------------------
        officer_number = (EditText) findViewById(R.id.enter_officer_number);
        //user_name =  (EditText) findViewById(R.id.enter_user_name);

//        user_name.setOnEditorActionListener(new TextView.OnEditorActionListener() {
//            @Override
//            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
//
//                // Add info from EditText to db
//                String on = officer_number.getText().toString();
//                String un = user_name.getText().toString();
//
//                // Starts AuthActivity
//                startActivity(new Intent(getApplicationContext(), AuthActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
//                return true;
//            }
//        });
    }
}
