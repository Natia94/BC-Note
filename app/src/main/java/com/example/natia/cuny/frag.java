package com.example.natia.cuny;

import android.app.ActivityOptions;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AndroidException;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import static com.example.natia.cuny.R.layout.activity_frag;
import static com.example.natia.cuny.R.layout.time;

@RequiresApi(api = Build.VERSION_CODES.N)
public class frag extends AppCompatActivity {
    private LinearLayout line;
    private TextView Natia;
    private ImageView Icon;

    private TextView view1;
    private TextView view2;
    private TextView view3;
    private TextView view4;
    private TextView view5;
    private TextView view6;
    private TextView view7;
    private TextView view8;

    private TimePicker timePicker;

//preferences

    public String MyPREFERENCES = "MyPrefs";
    public String time1 = "timeKey1";
    public String time2 = "timeKey2";
    public String time3 = "timeKey3";
    public String time4 = "timeKey4";
    public String time5 = "timeKey5";
    public String time6 = "timeKey6";
    public String time7 = "timeKey7";
    public String time8 = "timeKey8";

    public String note1 = "noteKey1";
    public String note2 = "noteKey2";
    public String note3 = "noteKey3";
    public String note4 = "noteKey4";
    public String note5 = "noteKey5";
    public String note6 = "noteKey6";
    public String note7 = "noteKey7";
    public String note8 = "noteKey8";


    private EditText class1, class2, class3, class4, class5, class6, class7, class8;


    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(activity_frag);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        Bundle extras = getIntent().getExtras();
        String strResult1 = extras.getString("paramName");

        preferenceNames(strResult1);

        Natia = (TextView) findViewById(R.id.natia);
        Icon = (ImageView) findViewById(R.id.image);

        Icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
                overridePendingTransition(R.anim.slide_down,R.anim.soso);
            }
        });


        view1 = (TextView) findViewById(R.id.time1);
        view1.setText(sharedpreferences.getString(time1, "00:00"));
        timePicker = (TimePicker) findViewById(R.id.timePicker);

        view2 = (TextView) findViewById(R.id.time2);
        view2.setText(sharedpreferences.getString(time2, "00:00"));
        timePicker = (TimePicker) findViewById(R.id.timePicker);

        view3 = (TextView) findViewById(R.id.time3);
        view3.setText(sharedpreferences.getString(time3, "00:00"));
        timePicker = (TimePicker) findViewById(R.id.timePicker);

        view4 = (TextView) findViewById(R.id.time4);
        view4.setText(sharedpreferences.getString(time4, "00:00"));
        timePicker = (TimePicker) findViewById(R.id.timePicker);

        view5 = (TextView) findViewById(R.id.time5);
        view5.setText(sharedpreferences.getString(time5, "00:00"));
        timePicker = (TimePicker) findViewById(R.id.timePicker);

        view6 = (TextView) findViewById(R.id.time6);
        view6.setText(sharedpreferences.getString(time6, "00:00"));
        timePicker = (TimePicker) findViewById(R.id.timePicker);

        view7 = (TextView) findViewById(R.id.time7);
        view7.setText(sharedpreferences.getString(time7, "00:00"));
        timePicker = (TimePicker) findViewById(R.id.timePicker);

        view8 = (TextView) findViewById(R.id.time8);
        view8.setText(sharedpreferences.getString(time8, "00:00"));
        timePicker = (TimePicker) findViewById(R.id.timePicker);


        class1 = (EditText) findViewById(R.id.editText1);
        class1.setText(sharedpreferences.getString(note1, ""));
        class2 = (EditText) findViewById(R.id.editText2);
        class2.setText(sharedpreferences.getString(note2, ""));
        class3 = (EditText) findViewById(R.id.editText3);
        class3.setText(sharedpreferences.getString(note3, ""));
        class4 = (EditText) findViewById(R.id.editText4);
        class4.setText(sharedpreferences.getString(note4, ""));
        class5 = (EditText) findViewById(R.id.editText11);
        class5.setText(sharedpreferences.getString(note5, ""));
        class6 = (EditText) findViewById(R.id.editText22);
        class6.setText(sharedpreferences.getString(note6, ""));
        class7 = (EditText) findViewById(R.id.editText33);
        class7.setText(sharedpreferences.getString(note7, ""));
        class8 = (EditText) findViewById(R.id.editText44);
        class8.setText(sharedpreferences.getString(note8, ""));


        final Dialog dialog = new Dialog(frag.this);
        dialog.setContentView(R.layout.time);
        line = (LinearLayout) findViewById(R.id.fragment_id);


        int color = extras.getInt("Colors");
        line.setBackgroundResource(color);


        Natia.setText(strResult1);


// time Pickers for each textView


        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final TimePicker tp1 = (TimePicker) dialog.findViewById(R.id.timePicker);
                tp1.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                    @Override
                    public void onTimeChanged(TimePicker timePicker, int i, int i1) {

                        Toast.makeText(frag.this, i + "", Toast.LENGTH_LONG);

                        String minuteFormatter = "";
                        if (tp1.getMinute() < 10) {
                            minuteFormatter = "0" + tp1.getMinute();
                        } else {
                            minuteFormatter = String.valueOf(tp1.getMinute());
                        }

                        String hourFormatter = "";
                        if (tp1.getHour() < 10) {
                            hourFormatter = "0" + tp1.getHour();
                        } else {
                            hourFormatter = String.valueOf(tp1.getHour());
                        }

                        //StringBuilder Time = new StringBuilder().append(hourFormatter).append(" : ").append(minuteFormatter);

                        view1.setText(hourFormatter + ":" + minuteFormatter);


                        String n1 = view1.getText().toString();

                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString(time1, n1);
                        editor.commit();
                        Toast.makeText(frag.this, "Thanks", Toast.LENGTH_LONG).show();

                    }
                });
                dialog.show();
            }
        });


        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final TimePicker tp2 = (TimePicker) dialog.findViewById(R.id.timePicker);
                tp2.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                    @Override
                    public void onTimeChanged(TimePicker timePicker, int i, int i1) {

                        Toast.makeText(frag.this, i + "", Toast.LENGTH_LONG);

                        //view2.setText(tp2.getHour()+":"+tp2.getMinute());

                        String minuteFormatter = "";
                        if (tp2.getMinute() < 10) {
                            minuteFormatter = "0" + tp2.getMinute();
                        } else {
                            minuteFormatter = String.valueOf(tp2.getMinute());
                        }

                        String hourFormatter = "";
                        if (tp2.getHour() < 10) {
                            hourFormatter = "0" + tp2.getHour();
                        } else {
                            hourFormatter = String.valueOf(tp2.getHour());
                        }

                        //StringBuilder Time = new StringBuilder().append(hourFormatter).append(" : ").append(minuteFormatter);

                        view2.setText(hourFormatter + ":" + minuteFormatter);

                        String n2 = view1.getText().toString();

                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString(time2, n2);
                        editor.commit();
                        Toast.makeText(frag.this, "Thanks", Toast.LENGTH_LONG).show();

                    }
                });


                dialog.show();
            }
        });


        view3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final TimePicker tp3 = (TimePicker) dialog.findViewById(R.id.timePicker);
                tp3.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                    @Override
                    public void onTimeChanged(TimePicker timePicker, int i, int i1) {

                        Toast.makeText(frag.this, i + "", Toast.LENGTH_LONG);

                        String minuteFormatter = "";
                        if (tp3.getMinute() < 10) {
                            minuteFormatter = "0" + tp3.getMinute();
                        } else {
                            minuteFormatter = String.valueOf(tp3.getMinute());
                        }

                        String hourFormatter = "";
                        if (tp3.getHour() < 10) {
                            hourFormatter = "0" + tp3.getHour();
                        } else {
                            hourFormatter = String.valueOf(tp3.getHour());
                        }

                        //StringBuilder Time = new StringBuilder().append(hourFormatter).append(" : ").append(minuteFormatter);

                        view3.setText(hourFormatter + ":" + minuteFormatter);

                        String n3 = view3.getText().toString();

                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString(time3, n3);
                        editor.commit();
                        Toast.makeText(frag.this, "Thanks", Toast.LENGTH_LONG).show();

                    }
                });

                dialog.show();
            }
        });


        view4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final TimePicker tp4 = (TimePicker) dialog.findViewById(R.id.timePicker);
                tp4.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                    @Override
                    public void onTimeChanged(TimePicker timePicker, int i, int i1) {

                        Toast.makeText(frag.this, i + "", Toast.LENGTH_LONG);

                        String minuteFormatter = "";
                        if (tp4.getMinute() < 10) {
                            minuteFormatter = "0" + tp4.getMinute();
                        } else {
                            minuteFormatter = String.valueOf(tp4.getMinute());
                        }

                        String hourFormatter = "";
                        if (tp4.getHour() < 10) {
                            hourFormatter = "0" + tp4.getHour();
                        } else {
                            hourFormatter = String.valueOf(tp4.getHour());
                        }

                        //StringBuilder Time = new StringBuilder().append(hourFormatter).append(" : ").append(minuteFormatter);

                        view4.setText(hourFormatter + ":" + minuteFormatter);

                        String n4 = view4.getText().toString();

                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString(time4, n4);
                        editor.commit();
                        Toast.makeText(frag.this, "Thanks", Toast.LENGTH_LONG).show();


                    }
                });


                dialog.show();
            }
        });


        view5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final TimePicker tp5 = (TimePicker) dialog.findViewById(R.id.timePicker);
                tp5.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                    @Override
                    public void onTimeChanged(TimePicker timePicker, int i, int i1) {

                        Toast.makeText(frag.this, i + "", Toast.LENGTH_LONG);


                        String minuteFormatter = "";
                        if (tp5.getMinute() < 10) {
                            minuteFormatter = "0" + tp5.getMinute();
                        } else {
                            minuteFormatter = String.valueOf(tp5.getMinute());
                        }

                        String hourFormatter = "";
                        if (tp5.getHour() < 10) {
                            hourFormatter = "0" + tp5.getHour();
                        } else {
                            hourFormatter = String.valueOf(tp5.getHour());
                        }

                        //StringBuilder Time = new StringBuilder().append(hourFormatter).append(" : ").append(minuteFormatter);

                        view5.setText(hourFormatter + ":" + minuteFormatter);


                        String n5 = view5.getText().toString();

                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString(time5, n5);
                        editor.commit();
                        Toast.makeText(frag.this, "Thanks", Toast.LENGTH_LONG).show();


                    }
                });

                dialog.show();
            }
        });


        view6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final TimePicker tp6 = (TimePicker) dialog.findViewById(R.id.timePicker);
                tp6.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                    @Override
                    public void onTimeChanged(TimePicker timePicker, int i, int i1) {

                        Toast.makeText(frag.this, i + "", Toast.LENGTH_LONG);

                        String minuteFormatter = "";
                        if (tp6.getMinute() < 10) {
                            minuteFormatter = "0" + tp6.getMinute();
                        } else {
                            minuteFormatter = String.valueOf(tp6.getMinute());
                        }

                        String hourFormatter = "";
                        if (tp6.getHour() < 10) {
                            hourFormatter = "0" + tp6.getHour();
                        } else {
                            hourFormatter = String.valueOf(tp6.getHour());
                        }

                        //StringBuilder Time = new StringBuilder().append(hourFormatter).append(" : ").append(minuteFormatter);

                        view6.setText(hourFormatter + ":" + minuteFormatter);


                        String n6 = view6.getText().toString();

                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString(time6, n6);
                        editor.commit();
                        Toast.makeText(frag.this, "Thanks", Toast.LENGTH_LONG).show();

                    }
                });


                dialog.show();
            }
        });


        view7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final TimePicker tp7 = (TimePicker) dialog.findViewById(R.id.timePicker);
                tp7.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                    @Override
                    public void onTimeChanged(TimePicker timePicker, int i, int i1) {

                        Toast.makeText(frag.this, i + "", Toast.LENGTH_LONG);

                        String minuteFormatter = "";
                        if (tp7.getMinute() < 10) {
                            minuteFormatter = "0" + tp7.getMinute();
                        } else {
                            minuteFormatter = String.valueOf(tp7.getMinute());
                        }

                        String hourFormatter = "";
                        if (tp7.getHour() < 10) {
                            hourFormatter = "0" + tp7.getHour();
                        } else {
                            hourFormatter = String.valueOf(tp7.getHour());
                        }

                        //StringBuilder Time = new StringBuilder().append(hourFormatter).append(" : ").append(minuteFormatter);

                        view7.setText(hourFormatter + ":" + minuteFormatter);


                        String n7 = view7.getText().toString();

                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString(time7, n7);
                        editor.commit();
                        Toast.makeText(frag.this, "Thanks", Toast.LENGTH_LONG).show();

                    }
                });


                dialog.show();
            }
        });


        view8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final TimePicker tp8 = (TimePicker) dialog.findViewById(R.id.timePicker);
                tp8.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                    @Override
                    public void onTimeChanged(TimePicker timePicker, int i, int i1) {

                        Toast.makeText(frag.this, i + "", Toast.LENGTH_LONG);

                        String minuteFormatter = "";
                        if (tp8.getMinute() < 10) {
                            minuteFormatter = "0" + tp8.getMinute();
                        } else {
                            minuteFormatter = String.valueOf(tp8.getMinute());
                        }

                        String hourFormatter = "";
                        if (tp8.getHour() < 10) {
                            hourFormatter = "0" + tp8.getHour();
                        } else {
                            hourFormatter = String.valueOf(tp8.getHour());
                        }

                        //StringBuilder Time = new StringBuilder().append(hourFormatter).append(" : ").append(minuteFormatter);

                        view8.setText(hourFormatter + ":" + minuteFormatter);


                        String n8 = view8.getText().toString();

                        SharedPreferences.Editor editor = sharedpreferences.edit();
                        editor.putString(time8, n8);
                        editor.commit();
                        Toast.makeText(frag.this, "Thanks", Toast.LENGTH_LONG).show();

                    }
                });


                dialog.show();
            }
        });


        //classes

        class1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(note1, charSequence.toString());
                editor.commit();
                Toast.makeText(frag.this, "Thanks", Toast.LENGTH_LONG).show();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        class2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(note2, charSequence.toString());
                editor.commit();
                Toast.makeText(frag.this, "Thanks", Toast.LENGTH_LONG).show();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        class3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(note3, charSequence.toString());
                editor.commit();
                Toast.makeText(frag.this, "Thanks", Toast.LENGTH_LONG).show();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        class4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(note4, charSequence.toString());
                editor.commit();
                Toast.makeText(frag.this, "Thanks", Toast.LENGTH_LONG).show();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        class5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(note5, charSequence.toString());
                editor.commit();
                Toast.makeText(frag.this, "Thanks", Toast.LENGTH_LONG).show();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        class6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(note6, charSequence.toString());
                editor.commit();
                Toast.makeText(frag.this, "Thanks", Toast.LENGTH_LONG).show();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        class7.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(note7, charSequence.toString());
                editor.commit();
                Toast.makeText(frag.this, "Thanks", Toast.LENGTH_LONG).show();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        class8.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(note8, charSequence.toString());
                editor.commit();
                Toast.makeText(frag.this, "Thanks", Toast.LENGTH_LONG).show();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }

    public void preferenceNames(String day) {

                 time1 = day+"timeKey1";
                 time2 = day+"timeKey2";
                 time3 = day+"timeKey3";
                 time4 = day+"timeKey4";
                 time5 = day+"timeKey5";
                 time6 = day+"timeKey6";
                 time7 = day+"timeKey7";
                 time8 = day+"timeKey8";

                 note1 = day+"noteKey1";
                 note2 = day+"noteKey2";
                 note3 = day+"noteKey3";
                 note4 = day+"noteKey4";
                 note5 = day+"noteKey5";
                 note6 = day+"noteKey6";
                 note7 = day+"noteKey7";
                 note8 = day+"noteKey8";

    }
}
