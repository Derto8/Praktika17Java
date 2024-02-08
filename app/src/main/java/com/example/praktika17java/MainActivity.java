package com.example.praktika17java;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public int step = 1;
    public boolean ch1 = false;
    public boolean ch2 = false;
    public boolean ch3 = false;
    public boolean ch4 = false;
    public void onStep(View view){
        step++;

        if(step == 2)
            setContentView(R.layout.step_2);
        if(step == 3){
            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView id1 = findViewById(R.id.editTextText);
            String text = id1.getText().toString();
            if(text.equals("Имя") || text.equals(""))
            {
                AlertDialog("Предупреждение", "Введите имя");
                step--;
                return;
            }
            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView id2= findViewById(R.id.editTextText1);
            String text2 = id2.getText().toString();
            if(text2.equals("Фамилия") || text2.equals(""))
            {
                AlertDialog("Предупреждение", "Введите фамилию");
                step--;
                return;
            }
            setContentView(R.layout.step_3);
        }
        if(step == 4){
            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) RadioGroup rg = findViewById(R.id.radioGroup);
            int isChecked = rg.getCheckedRadioButtonId();
            if(isChecked != -1)
                setContentView(R.layout.step_4);
            else{
                AlertDialog("Предупреждение", "Выберите упражнение");
                step--;
            }
        }
        if(step == 5){
            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) CheckBox checkBox1 = findViewById(R.id.checkbox1);
            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) CheckBox checkBox2 = findViewById(R.id.checkbox2);
            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) CheckBox checkBox3 = findViewById(R.id.checkbox3);
            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) CheckBox checkBox4 = findViewById(R.id.checkbox4);
            ch1 = checkBox1.isChecked();
            ch2 = checkBox2.isChecked();
            ch3 = checkBox3.isChecked();
            ch4 = checkBox4.isChecked();

            if(ch1|| ch2 || ch3|| ch4)
                setContentView(R.layout.step_5);
            else{
                AlertDialog("Предупреждение", "Выберите группы мышц");
                step--;
            }
        }
        if(step == 6){
            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView id2 = findViewById(R.id.editTextText2);
            String text = id2.getText().toString();
            if(text.equals("Вес") || text.equals(""))
            {
                AlertDialog("Предупреждение", "Введите вес");
                step--;
                return;
            }

            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView id3 = findViewById(R.id.editTextText2);
            String text2 = id3.getText().toString();
            if(text2.equals("Рост") || text2.equals(""))
            {
                AlertDialog("Предупреждение", "Введите рост");
                step--;
                return;
            }

            setContentView(R.layout.step_6);
        }
        if(step == 7){
            @SuppressLint({"MissingInflatedId", "LocalSuppress"}) RadioGroup rg = findViewById(R.id.radioGroup2);
            int isChecked = rg.getCheckedRadioButtonId();
            if(isChecked != -1){
                setContentView(R.layout.step_7);
                if(!ch1)
                {
                    LinearLayout ll = findViewById(R.id.layoutSpina);
                    ll.setVisibility(View.GONE);
                }
                if(!ch2){
                    LinearLayout ll = findViewById(R.id.layoutBitceps);
                    ll.setVisibility(View.GONE);
                }
                if(!ch3){
                    LinearLayout ll1 = findViewById(R.id.layoutTriceps);
                    ll1.setVisibility(View.GONE);
                }
                if(!ch4){
                    LinearLayout ll1 = findViewById(R.id.layoutIkra);
                    ll1.setVisibility(View.GONE);
                }
            }
            else{
                AlertDialog("Предупреждение", "Укажите ваш пол");
                step--;
            }
        }
    }

    public void AlertDialog(String titile, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(titile)
                .setMessage(message)
                .setCancelable(false)
                .setNegativeButton("OK",
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public void Spina(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=aKcGNtG32jE"));
        startActivity(browserIntent);
    }

    public void Biceps(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=PvtWt6DI3TI"));
        startActivity(browserIntent);
    }

    public void Triceps(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=RJQisT_dndc"));
        startActivity(browserIntent);
    }

    public void Ikra(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=zfUjxQexhjA"));
        startActivity(browserIntent);
    }
}