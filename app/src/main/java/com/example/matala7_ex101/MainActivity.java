package com.example.matala7_ex101;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.Random;

import static android.graphics.Color.RED;
import static android.graphics.Color.WHITE;

/**
 * @author noa rhahmim
 * @version 1.0
 * @since  2/1/2021 description:
 * in the app there is 5 different buttons ,every button triggers an Alert Dialog every time according to what is written on it.
 */

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.constraintLayout);
    }

    /**
      * @param view  get the view
     *  button num 1 in the main activity,Displays message only.
     */
    public void messege(View view) {

        AlertDialog.Builder adb;
        adb = new AlertDialog.Builder(this);
        adb.setTitle("I have a secret  message for you");
        adb.setMessage("boo!! Just kidding this is a simple alert");
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * @param view  get the view
     * button num 2 in the main activity,Displays message with icon.
     */
    public void IconAndMessege(View view) {

        AlertDialog.Builder adb;
        adb = new AlertDialog.Builder(this);
        adb.setTitle("text&icon");
        adb.setIcon(R.drawable.hart);
        adb.setMessage("this is a simple alert with an hart icon because I love you, kisses");
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * @param view  get the view
     * button num 3 in the main activity,Displays one button with icon.
     */
    public void OneButton(View view) {

        AlertDialog.Builder adb;
        adb = new AlertDialog.Builder(this);
        adb.setTitle("one button");
        adb.setMessage("this is a one button with an icon hart Because I still love you ");
        adb.setIcon(R.drawable.hart);
        adb.setNegativeButton("close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }

    /**
     * @param view get the view
     * button num 4 in the main activity,Displays two buttons.
     */
    public void twoButtons(View view) {

        AlertDialog.Builder adb;
        adb = new AlertDialog.Builder(this);
        adb.setTitle("random or close");
        adb.setMessage("Choose one of the following options");
        adb.setPositiveButton("random", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                 //calls to getRandomcolor
                layout.setBackgroundColor(getRandomColor());
            }
        });
        adb.setNegativeButton("close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog ad = adb.create();
        ad.show();
    }

    public int getRandomColor(){
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
    /**
     * @param view  get the view
     * button num 5 in the main activity,Displays three buttons:
     * 1: changes the color background randomly.
     * 2:resets the background to white.
     * 3:goes to the creds activity.
     */
    public void threeButtons(View view) {

        AlertDialog.Builder adb;
        adb = new AlertDialog.Builder(this);
        adb.setTitle("The choice becomes harder !!!!!");
        adb.setMessage("I'am Just kidding, the same choice as before but whit the possible to return the background to white");


          //changes the color to random background .

        adb.setPositiveButton("random", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                layout.setBackgroundColor(getRandomColor());
            }
        });

        adb.setNegativeButton("close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });


        // resets the  background color to white.

        adb.setNeutralButton("resets", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                layout.setBackgroundColor(WHITE);
            }
        });
        AlertDialog ad = adb.create();
        ad.show();
    }


    /**
     *
      * @param menu-General menu
     * @return true
     */



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        menu.add("Credits");
        return true;
    }


     // goes to the creds activity.

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String st = item.getTitle().toString();

        if (st.endsWith("Credits")) {
            Intent si = new Intent(this, creds.class);
            startActivity(si);
        }
        return true;
    }
}