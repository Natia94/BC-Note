package com.example.natia.cuny;

import android.app.ActivityOptions;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
    Button Monday;
    Button Tuesday;
    Button Wednesday;
    Button Thursday;
    Button Friday;
    Button Saturday;
    Button Sunday;
    Button language;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Monday = (Button) findViewById(R.id.monday);
        Tuesday = (Button) findViewById(R.id.tuesday);
        Wednesday = (Button) findViewById(R.id.wensday);
        Thursday = (Button) findViewById(R.id.thursday);
        Friday = (Button) findViewById(R.id.friday);
        Saturday = (Button) findViewById(R.id.saturday);
        Sunday = (Button) findViewById(R.id.sunday);


        //language=(Button)findViewById(R.id.Button_language);


        Monday.setOnClickListener(this);
        Tuesday.setOnClickListener(this);
        Wednesday.setOnClickListener(this);
        Thursday.setOnClickListener(this);
        Friday.setOnClickListener(this);
        Saturday.setOnClickListener(this);
        Sunday.setOnClickListener(this);
        language.setOnClickListener(this);



    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.monday:

                Intent myIntent1 = new Intent(getApplicationContext(), frag.class);
                ActivityOptions options1 = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
                myIntent1.putExtra("Colors", R.color.Berry);
                myIntent1.putExtra("paramName", "Monday");
                startActivity(myIntent1, options1.toBundle());
                break;


            case  R.id.tuesday:

                Intent myIntent2 = new Intent(getApplicationContext(), frag.class);
                ActivityOptions options2 = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
                myIntent2.putExtra("Colors", R.color.Yellow);
                myIntent2.putExtra("paramName", "Tuesday");
                startActivity(myIntent2, options2.toBundle());
                break;

            case  R.id.wensday:
                Intent myIntent3 = new Intent(getApplicationContext(), frag.class);
                ActivityOptions options3 = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
                myIntent3.putExtra("Colors", R.color.Green);
                myIntent3.putExtra("paramName", "Wednesday");
                startActivity(myIntent3, options3.toBundle());
                break;

            case  R.id.thursday:
                Intent myIntent4 = new Intent(getApplicationContext(), frag.class);
                ActivityOptions options4 = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
                myIntent4.putExtra("Colors", R.color.lightBlue);
                myIntent4.putExtra("paramName", "Thursday");
                startActivity(myIntent4, options4.toBundle());
                break;

            case  R.id.friday:
                Intent myIntent5 = new Intent(getApplicationContext(), frag.class);
                ActivityOptions options5 = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
                myIntent5.putExtra("Colors", R.color.Orange);
                myIntent5.putExtra("paramName", "Friday");
                startActivity(myIntent5, options5.toBundle());
                break;

            case  R.id.saturday:
                Intent myIntent6 = new Intent(getApplicationContext(), frag.class);
                ActivityOptions options6 = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
                myIntent6.putExtra("Colors", R.color.Purple);
                myIntent6.putExtra("paramName", "Saturday");
                startActivity(myIntent6, options6.toBundle());
                break;

            case  R.id.sunday:
                Intent myIntent7 = new Intent(getApplicationContext(), frag.class);
                ActivityOptions options7 = ActivityOptions.makeCustomAnimation(getApplicationContext(), R.anim.fade_in, R.anim.fade_out);
                myIntent7.putExtra("Colors", R.color.Peach);
                myIntent7.putExtra("paramName", "Sunday");
                startActivity(myIntent7, options7.toBundle());
                break;

            case R.id.Button_language:

                language.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Create the list fragment and add it as our sole content.


                        LanguageFragment LanguageFragment =new LanguageFragment();
                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        transaction.replace(R.id.language_fragment,LanguageFragment); // fragmen container id in first parameter is the  container(Main layout id) of Activity
                        transaction.addToBackStack(null);  // this will manage backstack
                        transaction.commit();
                    }
                });



        }

    }
}