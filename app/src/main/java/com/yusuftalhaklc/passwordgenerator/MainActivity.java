package com.yusuftalhaklc.passwordgenerator;
import java.util.Random;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        passwordText = findViewById(R.id.passwordText);

    }
    public void passwordGenerator(){
        String passwordChars,password="";
        int randInt;
        Random rnd = new Random();

        passwordChars ="q Q w W e E r R t T y Y u U ı I o O p P ğ Ğ ü Ü i İ ş Ş l L k K j J h H g G f F d D s S a A ç Ç ö Ö m M n N b B v V c C x X z Z 0 1 2 3 4 5 6 7 8 9";
        String passwordCharsSplited[] = passwordChars.split(" ");

        for (int i =0; i< 16;i++) {
           randInt =  rnd.nextInt(passwordCharsSplited.length);
           password+= passwordCharsSplited[randInt];
        }
        passwordText.setText(password);
    }
    public void generatePassword(View view){
        passwordGenerator();
    }
    public void copyPassword(View view){
        //copy
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("password",passwordText.getText().toString());
        clipboard.setPrimaryClip(clip);
        //information message
        AlertDialog.Builder msg = new AlertDialog.Builder(MainActivity.this);
        msg.setMessage("Copied!");
        msg.show();
    }
}
