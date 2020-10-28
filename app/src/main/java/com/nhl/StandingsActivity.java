package com.nhl;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.ExecutionException;

public class StandingsActivity extends AppCompatActivity {
public static Button but,butcon;
 public static SharedPreferences sp;
 public static ImageView image1;
 Context context;

    public int getlistlogo(String string){

if (string.equals("Capitals WSH"))
            return(R.drawable.washington);
            else
if (string.equals("Blues STL"))
                return(R.drawable.blues);
        else
if (string.equals("Bruins BOS"))
            return(R.drawable.boston);

        else
if (string.equals("Islanders NYI"))
            return R.drawable.islanders;

        else
if (string.equals("Avalanche COL"))
            return R.drawable.colorado;

        else
if (string.equals("Hurricanes CAR"))
            return R.drawable.carolina;

        else
if (string.equals("Penguins PIT"))
            return R.drawable.pitsburg;

        else
if (string.equals("Stars DAL"))
            return R.drawable.dallas;

       else
if (string.equals("Coyotes ARI"))
           return R.drawable.arizona;

        else
if (string.equals("Golden Knights VGK"))
            return R.drawable.vegas;


        else
if (string.equals("Flyers PHI"))
            return R.drawable.filadelfia;


        else
if (string.equals("Jets WPG"))
            return R.drawable.winnipeg;


        else
if (string.equals("Oilers EDM"))
            return R.drawable.oilers;


        else
if (string.equals("Flames CGY"))
            return R.drawable.calgary;


        else
if (string.equals("Canadiens MTL"))
            return R.drawable.monreal;


        else
if (string.equals("Maple Leafs TOR"))
            return R.drawable.toronto;


        else
if (string.equals("Panthers FLA"))
            return R.drawable.florida;


        else
if (string.equals("Wild MIN"))
            return R.drawable.minnessota;


        else
if (string.equals("Sabres BUF"))
            return R.drawable.buffalo;


        else
if (string.equals("Predators NSH"))
            return R.drawable.nashvill;


        else
if (string.equals("Canucks VAN"))
            return R.drawable.vancouver;


        else
if (string.equals("Lightning TB"))
            return R.drawable.tampa;


        else
if (string.equals("Rangers NYR"))
            return R.drawable.rangers;


        else
if (string.equals("Blue Jackets CBJ"))
            return R.drawable.colambus;


        else
if (string.equals("Sharks SJ"))
            return R.drawable.sharks;


        else
if (string.equals("Blackhawks CHI"))
            return R.drawable.chicago;


        else
if (string.equals("Kings LA"))
            return R.drawable.la;


        else
if (string.equals("Senators OTT"))
            return R.drawable.ottawa;


        else
if (string.equals("Ducks ANA"))
            return R.drawable.anaheim;


        else
if (string.equals("Devils NJ"))
            return R.drawable.devils;


        else
if (string.equals("Red Wings DET"))
            return R.drawable.detroit;
else
return R.drawable.detroit;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standings2);

        TextView name1= (TextView) findViewById(R.id.textView1);
        TextView name2= (TextView) findViewById(R.id.textView2);
        TextView name3= (TextView) findViewById(R.id.textView3);
        TextView name4= (TextView) findViewById(R.id.textView4);
        TextView name5= (TextView) findViewById(R.id.textView5);
        TextView name6= (TextView) findViewById(R.id.textView6);
        TextView name7= (TextView) findViewById(R.id.textView7);
        TextView name8= (TextView) findViewById(R.id.textView8);
        TextView name9= (TextView) findViewById(R.id.textView9);
        TextView name10= (TextView) findViewById(R.id.textView10);
        TextView name11= (TextView) findViewById(R.id.textView11);
        TextView name12= (TextView) findViewById(R.id.textView12);
        TextView name13= (TextView) findViewById(R.id.textView13);
        TextView name14= (TextView) findViewById(R.id.textView14);
        TextView name15= (TextView) findViewById(R.id.textView15);
        TextView name16= (TextView) findViewById(R.id.textView16);
        TextView name17= (TextView) findViewById(R.id.textView17);
        TextView name18= (TextView) findViewById(R.id.textView18);
        TextView name19= (TextView) findViewById(R.id.textView19);
        TextView name20= (TextView) findViewById(R.id.textView20);
        TextView name21= (TextView) findViewById(R.id.textView21);
        TextView name22= (TextView) findViewById(R.id.textView22);
        TextView name23= (TextView) findViewById(R.id.textView23);
        TextView name24= (TextView) findViewById(R.id.textView24);
        TextView name25= (TextView) findViewById(R.id.textView25);
        TextView name26= (TextView) findViewById(R.id.textView26);
        TextView name27= (TextView) findViewById(R.id.textView27);
        TextView name28= (TextView) findViewById(R.id.textView28);
        TextView name29= (TextView) findViewById(R.id.textView29);
        TextView name30= (TextView) findViewById(R.id.textView30);
        TextView name31= (TextView) findViewById(R.id.textView31);


        TextView num1 = (TextView) findViewById(R.id.textView501);
        TextView num2 = (TextView) findViewById(R.id.textView502);
        TextView num3 = (TextView) findViewById(R.id.textView503);
        TextView num4 = (TextView) findViewById(R.id.textView504);
        TextView num5 = (TextView) findViewById(R.id.textView505);
        TextView num6 = (TextView) findViewById(R.id.textView506);
        TextView num7 = (TextView) findViewById(R.id.textView507);
        TextView num8 = (TextView) findViewById(R.id.textView508);
        TextView num9 = (TextView) findViewById(R.id.textView509);
        TextView num10 = (TextView) findViewById(R.id.textView510);
        TextView num11 = (TextView) findViewById(R.id.textView511);
        TextView num12 = (TextView) findViewById(R.id.textView512);
        TextView num13 = (TextView) findViewById(R.id.textView513);
        TextView num14 = (TextView) findViewById(R.id.textView514);
        TextView num15 = (TextView) findViewById(R.id.textView515);
        TextView num16 = (TextView) findViewById(R.id.textView516);
        TextView num17 = (TextView) findViewById(R.id.textView517);
        TextView num18 = (TextView) findViewById(R.id.textView518);
        TextView num19 = (TextView) findViewById(R.id.textView519);
        TextView num20 = (TextView) findViewById(R.id.textView520);
        TextView num21 = (TextView) findViewById(R.id.textView521);
        TextView num22 = (TextView) findViewById(R.id.textView522);
        TextView num23 = (TextView) findViewById(R.id.textView523);
        TextView num24 = (TextView) findViewById(R.id.textView524);
        TextView num25 = (TextView) findViewById(R.id.textView525);
        TextView num26 = (TextView) findViewById(R.id.textView526);
        TextView num27 = (TextView) findViewById(R.id.textView527);
        TextView num28 = (TextView) findViewById(R.id.textView528);
        TextView num29 = (TextView) findViewById(R.id.textView529);
        TextView num30 = (TextView) findViewById(R.id.textView530);
        TextView num31 = (TextView) findViewById(R.id.textView531);

        TextView gp1 = (TextView) findViewById(R.id.textView101);
        TextView gp2 = (TextView) findViewById(R.id.textView102);
        TextView gp3 = (TextView) findViewById(R.id.textView103);
        TextView gp4 = (TextView) findViewById(R.id.textView104);
        TextView gp5 = (TextView) findViewById(R.id.textView105);
        TextView gp6 = (TextView) findViewById(R.id.textView106);
        TextView gp7 = (TextView) findViewById(R.id.textView107);
        TextView gp8 = (TextView) findViewById(R.id.textView108);
        TextView gp9 = (TextView) findViewById(R.id.textView109);
        TextView gp10 = (TextView) findViewById(R.id.textView110);
        TextView gp11 = (TextView) findViewById(R.id.textView111);
        TextView gp12 = (TextView) findViewById(R.id.textView112);
        TextView gp13 = (TextView) findViewById(R.id.textView113);
        TextView gp14 = (TextView) findViewById(R.id.textView114);
        TextView gp15 = (TextView) findViewById(R.id.textView115);
        TextView gp16 = (TextView) findViewById(R.id.textView116);
        TextView gp17 = (TextView) findViewById(R.id.textView117);
        TextView gp18 = (TextView) findViewById(R.id.textView118);
        TextView gp19 = (TextView) findViewById(R.id.textView119);
        TextView gp20 = (TextView) findViewById(R.id.textView120);
        TextView gp21 = (TextView) findViewById(R.id.textView121);
        TextView gp22 = (TextView) findViewById(R.id.textView122);
        TextView gp23 = (TextView) findViewById(R.id.textView123);
        TextView gp24 = (TextView) findViewById(R.id.textView124);
        TextView gp25 = (TextView) findViewById(R.id.textView125);
        TextView gp26 = (TextView) findViewById(R.id.textView126);
        TextView gp27 = (TextView) findViewById(R.id.textView127);
        TextView gp28 = (TextView) findViewById(R.id.textView128);
        TextView gp29 = (TextView) findViewById(R.id.textView129);
        TextView gp30 = (TextView) findViewById(R.id.textView130);
        TextView gp31 = (TextView) findViewById(R.id.textView131);

        TextView w1 = (TextView) findViewById(R.id.textView201);
        TextView w2 = (TextView) findViewById(R.id.textView202);
        TextView w3 = (TextView) findViewById(R.id.textView203);
        TextView w4 = (TextView) findViewById(R.id.textView204);
        TextView w5 = (TextView) findViewById(R.id.textView205);
        TextView w6 = (TextView) findViewById(R.id.textView206);
        TextView w7 = (TextView) findViewById(R.id.textView207);
        TextView w8 = (TextView) findViewById(R.id.textView208);
        TextView w9 = (TextView) findViewById(R.id.textView209);
        TextView w10 = (TextView) findViewById(R.id.textView210);
        TextView w11 = (TextView) findViewById(R.id.textView211);
        TextView w12 = (TextView) findViewById(R.id.textView212);
        TextView w13 = (TextView) findViewById(R.id.textView213);
        TextView w14 = (TextView) findViewById(R.id.textView214);
        TextView w15 = (TextView) findViewById(R.id.textView215);
        TextView w16 = (TextView) findViewById(R.id.textView216);
        TextView w17 = (TextView) findViewById(R.id.textView217);
        TextView w18 = (TextView) findViewById(R.id.textView218);
        TextView w19 = (TextView) findViewById(R.id.textView219);
        TextView w20 = (TextView) findViewById(R.id.textView220);
        TextView w21 = (TextView) findViewById(R.id.textView221);
        TextView w22 = (TextView) findViewById(R.id.textView222);
        TextView w23 = (TextView) findViewById(R.id.textView223);
        TextView w24 = (TextView) findViewById(R.id.textView224);
        TextView w25 = (TextView) findViewById(R.id.textView225);
        TextView w26 = (TextView) findViewById(R.id.textView226);
        TextView w27 = (TextView) findViewById(R.id.textView227);
        TextView w28 = (TextView) findViewById(R.id.textView228);
        TextView w29 = (TextView) findViewById(R.id.textView229);
        TextView w30 = (TextView) findViewById(R.id.textView230);
        TextView w31 = (TextView) findViewById(R.id.textView231);

        ImageView image1 = (ImageView) findViewById(R.id.imageView1);
        ImageView image2 = (ImageView) findViewById(R.id.imageView2);
        ImageView image3 = (ImageView) findViewById(R.id.imageView3);
        ImageView image4 = (ImageView) findViewById(R.id.imageView4);
        ImageView image5 = (ImageView) findViewById(R.id.imageView5);
        ImageView image6 = (ImageView) findViewById(R.id.imageView6);
        ImageView image7 = (ImageView) findViewById(R.id.imageView7);
        ImageView image8 = (ImageView) findViewById(R.id.imageView8);
        ImageView image9 = (ImageView) findViewById(R.id.imageView9);
        ImageView image10 = (ImageView) findViewById(R.id.imageView10);
        ImageView image11 = (ImageView) findViewById(R.id.imageView11);
        ImageView image12 = (ImageView) findViewById(R.id.imageView12);
        ImageView image13 = (ImageView) findViewById(R.id.imageView13);
        ImageView image14 = (ImageView) findViewById(R.id.imageView14);
        ImageView image15 = (ImageView) findViewById(R.id.imageView15);
        ImageView image16 = (ImageView) findViewById(R.id.imageView16);
        ImageView image17 = (ImageView) findViewById(R.id.imageView17);
        ImageView image18 = (ImageView) findViewById(R.id.imageView18);
        ImageView image19 = (ImageView) findViewById(R.id.imageView19);
        ImageView image20 = (ImageView) findViewById(R.id.imageView20);
        ImageView image21 = (ImageView) findViewById(R.id.imageView21);
        ImageView image22 = (ImageView) findViewById(R.id.imageView22);
        ImageView image23 = (ImageView) findViewById(R.id.imageView23);
        ImageView image24 = (ImageView) findViewById(R.id.imageView24);
        ImageView image25 = (ImageView) findViewById(R.id.imageView25);
        ImageView image26 = (ImageView) findViewById(R.id.imageView26);
        ImageView image27 = (ImageView) findViewById(R.id.imageView27);
        ImageView image28 = (ImageView) findViewById(R.id.imageView28);
        ImageView image29 = (ImageView) findViewById(R.id.imageView29);
        ImageView image30 = (ImageView) findViewById(R.id.imageView30);
        ImageView image31 = (ImageView) findViewById(R.id.imageView31);


        TextView L1 = (TextView) findViewById(R.id.textView301);
        TextView L2 = (TextView) findViewById(R.id.textView302);
        TextView L3 = (TextView) findViewById(R.id.textView303);
        TextView L4 = (TextView) findViewById(R.id.textView304);
        TextView L5 = (TextView) findViewById(R.id.textView305);
        TextView L6 = (TextView) findViewById(R.id.textView306);
        TextView L7 = (TextView) findViewById(R.id.textView307);
        TextView L8 = (TextView) findViewById(R.id.textView308);
        TextView L9 = (TextView) findViewById(R.id.textView309);
        TextView L10 = (TextView) findViewById(R.id.textView310);
        TextView L11 = (TextView) findViewById(R.id.textView311);
        TextView L12 = (TextView) findViewById(R.id.textView312);
        TextView L13 = (TextView) findViewById(R.id.textView313);
        TextView L14 = (TextView) findViewById(R.id.textView314);
        TextView L15 = (TextView) findViewById(R.id.textView315);
        TextView L16 = (TextView) findViewById(R.id.textView316);
        TextView L17 = (TextView) findViewById(R.id.textView317);
        TextView L18 = (TextView) findViewById(R.id.textView318);
        TextView L19 = (TextView) findViewById(R.id.textView319);
        TextView L20 = (TextView) findViewById(R.id.textView320);
        TextView L21 = (TextView) findViewById(R.id.textView321);
        TextView L22 = (TextView) findViewById(R.id.textView322);
        TextView L23 = (TextView) findViewById(R.id.textView323);
        TextView L24 = (TextView) findViewById(R.id.textView324);
        TextView L25 = (TextView) findViewById(R.id.textView325);
        TextView L26 = (TextView) findViewById(R.id.textView326);
        TextView L27 = (TextView) findViewById(R.id.textView327);
        TextView L28 = (TextView) findViewById(R.id.textView328);
        TextView L29 = (TextView) findViewById(R.id.textView329);
        TextView L30 = (TextView) findViewById(R.id.textView330);
        TextView L31 = (TextView) findViewById(R.id.textView331);

        TextView STRK1 = (TextView) findViewById(R.id.textView401);
        TextView STRK2 = (TextView) findViewById(R.id.textView402);
        TextView STRK3 = (TextView) findViewById(R.id.textView403);
        TextView STRK4 = (TextView) findViewById(R.id.textView404);
        TextView STRK5 = (TextView) findViewById(R.id.textView405);
        TextView STRK6 = (TextView) findViewById(R.id.textView406);
        TextView STRK7 = (TextView) findViewById(R.id.textView407);
        TextView STRK8 = (TextView) findViewById(R.id.textView408);
        TextView STRK9 = (TextView) findViewById(R.id.textView409);
        TextView STRK10 = (TextView) findViewById(R.id.textView410);
        TextView STRK11 = (TextView) findViewById(R.id.textView411);
        TextView STRK12 = (TextView) findViewById(R.id.textView412);
        TextView STRK13 = (TextView) findViewById(R.id.textView413);
        TextView STRK14 = (TextView) findViewById(R.id.textView414);
        TextView STRK15 = (TextView) findViewById(R.id.textView415);
        TextView STRK16 = (TextView) findViewById(R.id.textView416);
        TextView STRK17 = (TextView) findViewById(R.id.textView417);
        TextView STRK18 = (TextView) findViewById(R.id.textView418);
        TextView STRK19 = (TextView) findViewById(R.id.textView419);
        TextView STRK20 = (TextView) findViewById(R.id.textView420);
        TextView STRK21 = (TextView) findViewById(R.id.textView421);
        TextView STRK22 = (TextView) findViewById(R.id.textView422);
        TextView STRK23 = (TextView) findViewById(R.id.textView423);
        TextView STRK24 = (TextView) findViewById(R.id.textView424);
        TextView STRK25 = (TextView) findViewById(R.id.textView425);
        TextView STRK26 = (TextView) findViewById(R.id.textView426);
        TextView STRK27 = (TextView) findViewById(R.id.textView427);
        TextView STRK28 = (TextView) findViewById(R.id.textView428);
        TextView STRK29 = (TextView) findViewById(R.id.textView429);
        TextView STRK30 = (TextView) findViewById(R.id.textView430);
        TextView STRK31 = (TextView) findViewById(R.id.textView431);


        TableRow row1 = (TableRow) findViewById(R.id.row1);
        TableRow row2 = (TableRow) findViewById(R.id.row2);
        TableRow row3 = (TableRow) findViewById(R.id.row3);
        TableRow row4 = (TableRow) findViewById(R.id.row4);
        TableRow row5 = (TableRow) findViewById(R.id.row5);
        TableRow row6 = (TableRow) findViewById(R.id.row6);
        TableRow row7 = (TableRow) findViewById(R.id.row7);
        TableRow row8 = (TableRow) findViewById(R.id.row8);
        TableRow row9 = (TableRow) findViewById(R.id.row9);
        TableRow row10 = (TableRow) findViewById(R.id.row10);
        TableRow row11 = (TableRow) findViewById(R.id.row11);
        TableRow row12 = (TableRow) findViewById(R.id.row12);
        TableRow row13 = (TableRow) findViewById(R.id.row13);
        TableRow row14 = (TableRow) findViewById(R.id.row14);
        TableRow row15 = (TableRow) findViewById(R.id.row15);
        TableRow row16 = (TableRow) findViewById(R.id.row16);
        TableRow row17 = (TableRow) findViewById(R.id.row17);
        TableRow row18 = (TableRow) findViewById(R.id.row18);
        TableRow row19 = (TableRow) findViewById(R.id.row19);
        TableRow row20 = (TableRow) findViewById(R.id.row20);
        TableRow row21 = (TableRow) findViewById(R.id.row21);
        TableRow row22 = (TableRow) findViewById(R.id.row22);
        TableRow row23 = (TableRow) findViewById(R.id.row23);
        TableRow row24 = (TableRow) findViewById(R.id.row24);
        TableRow row25 = (TableRow) findViewById(R.id.row25);
        TableRow row26 = (TableRow) findViewById(R.id.row26);
        TableRow row27 = (TableRow) findViewById(R.id.row27);
        TableRow row28 = (TableRow) findViewById(R.id.row28);
        TableRow row29 = (TableRow) findViewById(R.id.row29);
        TableRow row30 = (TableRow) findViewById(R.id.row30);
        TableRow row31 = (TableRow) findViewById(R.id.row31);
        TableRow rowtitle1 = (TableRow) findViewById(R.id.rowtitle1);
        TableRow rowtitle2 = (TableRow) findViewById(R.id.rowtitle2);
        TableRow conrow1 = (TableRow) findViewById(R.id.conname1);
        TableRow conrow2 = (TableRow) findViewById(R.id.conname2);
        rowtitle1.setBackgroundColor(R.color.black_overlay);
        rowtitle2.setBackgroundColor(R.color.black_overlay);
        conrow1.setBackgroundColor(R.color.black_overlay);
        conrow2.setBackgroundColor(R.color.black_overlay);
        rowtitle2.setVisibility(View.GONE);
        conrow1.setVisibility(View.GONE);
        conrow2.setVisibility(View.GONE);

        Button but2 = (Button) findViewById(R.id.button1);








/*

        row1.setClickable(true);
                row2.setClickable(true);
        row3.setClickable(true);
                row4.setClickable(true);
        row5.setClickable(true);
                row6.setClickable(true);
        row7.setClickable(true);
                row8.setClickable(true);
        row9.setClickable(true);
                row10.setClickable(true);
        row11.setClickable(true);
                row12.setClickable(true);
        row13.setClickable(true);
                row14.setClickable(true);
        row15.setClickable(true);
                row16.setClickable(true);
        row17.setClickable(true);
                row18.setClickable(true);
        row19.setClickable(true);
                row20.setClickable(true);
        row21.setClickable(true);
                row22.setClickable(true);
        row23.setClickable(true);
                row24.setClickable(true);
        row25.setClickable(true);
                row26.setClickable(true);
        row27.setClickable(true);
                row28.setClickable(true);
        row29.setClickable(true);
                row30.setClickable(true);
        row31.setClickable(true);

       */
                but = (Button) findViewById(R.id.button);
                butcon = (Button) findViewById(R.id.button5);

        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StandingsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });



        String url = "https://www.foxsports.com/nhl/standings?season=2019&seasonType=1&grouping=4";

        ArrayList<Element> list=new ArrayList<Element>();
        try {

            list = new Task5(getApplicationContext(),url).execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        list.remove(0);
        for (int i=0;i<list.size();i++){
            System.out.println(i+"::"+list.get(i).text());
        }
        Elements td=null;

        for (int i=0;i<list.size();i++){
            if (i==0) {
                td = list.get(i).select("td");
                gp1.setText(td.get(5).text());
                w1.setText(td.get(1).text());
                L1.setText(td.get(2).text());
                STRK1.setText(td.get(15).text());
                name1.setText(td.get(0).text());
                num1.setText(String.valueOf(i+1));
                image1.setImageResource(getlistlogo(td.get(0).text()));
                System.out.println("1111");


            }
            if (i==1) {
                td = list.get(i).select("td");
                System.out.println(td.get(0).text().length());

                gp2.setText(td.get(5).text());
                w2.setText(td.get(1).text());
                L2.setText(td.get(2).text());
                STRK2.setText(td.get(15).text());
name2.setText(td.get(0).text());
num2.setText(String.valueOf(i+1));
                image2.setImageResource(getlistlogo(td.get(0).text()));

                System.out.println("222");


            }
            if (i==2) {
                td = list.get(i).select("td");
                gp3.setText(td.get(5).text());
                w3.setText(td.get(1).text());
                L3.setText(td.get(2).text());
                STRK3.setText(td.get(15).text());
name3.setText(td.get(0).text());
num3.setText(String.valueOf(i+1));
                image3.setImageResource(getlistlogo(td.get(0).text()));


            }
            if (i==3) {
                td = list.get(i).select("td");
                gp4.setText(td.get(5).text());
                w4.setText(td.get(1).text());
                L4.setText(td.get(2).text());
                STRK4.setText(td.get(15).text());
                name4.setText(td.get(0).text());
                num4.setText(String.valueOf(i+1));
                image4.setImageResource(getlistlogo(td.get(0).text()));
                System.out.println("333");

            }
            if (i==4) {
                td = list.get(i).select("td");
                gp5.setText(td.get(5).text());
                w5.setText(td.get(1).text());
                L5.setText(td.get(2).text());
                STRK5.setText(td.get(15).text());
name5.setText(td.get(0).text());
num5.setText(String.valueOf(i+1));
                image5.setImageResource(getlistlogo(td.get(0).text()));



            }
            if (i==5) {
                td = list.get(i).select("td");
                gp6.setText(td.get(5).text());
                w6.setText(td.get(1).text());
                L6.setText(td.get(2).text());
                STRK6.setText(td.get(15).text());
name6.setText(td.get(0).text());
num6.setText(String.valueOf(i+1));
                image6.setImageResource(getlistlogo(td.get(0).text()));


            }
            if (i==6) {
                td = list.get(i).select("td");
                gp7.setText(td.get(5).text());
                w7.setText(td.get(1).text());
                L7.setText(td.get(2).text());
                STRK7.setText(td.get(15).text());
name7.setText(td.get(0).text());
num7.setText(String.valueOf(i+1));
                image7.setImageResource(getlistlogo(td.get(0).text()));
                System.out.println("444");


            }
            if (i==7) {
                td = list.get(i).select("td");
                gp8.setText(td.get(5).text());
                w8.setText(td.get(1).text());
                L8.setText(td.get(2).text());
                STRK8.setText(td.get(15).text());
name8.setText(td.get(0).text());
num8.setText(String.valueOf(i+1));
                image8.setImageResource(getlistlogo(td.get(0).text()));


            }
            if (i==8) {
                td = list.get(i).select("td");
                gp9.setText(td.get(5).text());
                w9.setText(td.get(1).text());
                L9.setText(td.get(2).text());
                STRK9.setText(td.get(15).text());
name9.setText(td.get(0).text());
num9.setText(String.valueOf(i+1));
                image9.setImageResource(getlistlogo(td.get(0).text()));
                System.out.println("555");


            }
            if (i==9) {
                td = list.get(i).select("td");
                gp10.setText(td.get(5).text());
                w10.setText(td.get(1).text());
                L10.setText(td.get(2).text());
                STRK10.setText(td.get(15).text());
name10.setText(td.get(0).text());
num10.setText(String.valueOf(i+1));
                image10.setImageResource(getlistlogo(td.get(0).text()));


            }
            if (i==10) {
                td = list.get(i).select("td");
                gp11.setText(td.get(5).text());
                w11.setText(td.get(1).text());
                L11.setText(td.get(2).text());
                STRK11.setText(td.get(15).text());
name11.setText(td.get(0).text());
num11.setText(String.valueOf(i+1));
                image11.setImageResource(getlistlogo(td.get(0).text()));
                System.out.println("666");


            }
            if (i==11) {
                td = list.get(i).select("td");
                gp12.setText(td.get(5).text());
                w12.setText(td.get(1).text());
                L12.setText(td.get(2).text());
                STRK12.setText(td.get(15).text());
name12.setText(td.get(0).text());
num12.setText(String.valueOf(i+1));
                image12.setImageResource(getlistlogo(td.get(0).text()));


            }
            if (i==12) {
                td = list.get(i).select("td");
                gp13.setText(td.get(5).text());
                w13.setText(td.get(1).text());
                L13.setText(td.get(2).text());
                STRK13.setText(td.get(15).text());
name13.setText(td.get(0).text());
num13.setText(String.valueOf(i+1));
                image13.setImageResource(getlistlogo(td.get(0).text()));


            }
            if (i==13) {
                td = list.get(i).select("td");
                gp14.setText(td.get(5).text());
                w14.setText(td.get(1).text());
                L14.setText(td.get(2).text());
                STRK14.setText(td.get(15).text());
name14.setText(td.get(0).text());
num14.setText(String.valueOf(i+1));
                image14.setImageResource(getlistlogo(td.get(0).text()));
                System.out.println("777");


            }
            if (i==14) {
                td = list.get(i).select("td");
                gp15.setText(td.get(5).text());
                w15.setText(td.get(1).text());
                L15.setText(td.get(2).text());
                STRK15.setText(td.get(15).text());
name15.setText(td.get(0).text());
num15.setText(String.valueOf(i+1));
                image15.setImageResource(getlistlogo(td.get(0).text()));


            }
            if (i==15) {
                td = list.get(i).select("td");
                gp16.setText(td.get(5).text());
                w16.setText(td.get(1).text());
                L16.setText(td.get(2).text());
                STRK16.setText(td.get(15).text());
name16.setText(td.get(0).text());
num16.setText(String.valueOf(i+1));
                image16.setImageResource(getlistlogo(td.get(0).text()));
                System.out.println("88");


            }
            if (i==16) {
                td = list.get(i).select("td");
                gp17.setText(td.get(5).text());
                w17.setText(td.get(1).text());
                L17.setText(td.get(2).text());
                STRK17.setText(td.get(15).text());
name17.setText(td.get(0).text());
num17.setText(String.valueOf(i+1));
                image17.setImageResource(getlistlogo(td.get(0).text()));


            }
            if (i==17) {
                td = list.get(i).select("td");
                gp18.setText(td.get(5).text());
                w18.setText(td.get(1).text());
                L18.setText(td.get(2).text());
                STRK18.setText(td.get(15).text());
name18.setText(td.get(0).text());
num18.setText(String.valueOf(i+1));
                image18.setImageResource(getlistlogo(td.get(0).text()));


            }
            if (i==18) {
                td = list.get(i).select("td");
                gp19.setText(td.get(5).text());
                w19.setText(td.get(1).text());
                L19.setText(td.get(2).text());
                STRK19.setText(td.get(15).text());
name19.setText(td.get(0).text());
num19.setText(String.valueOf(i+1));
                image19.setImageResource(getlistlogo(td.get(0).text()));
                System.out.println("99");


            }
            if (i==19) {
                td = list.get(i).select("td");
                gp20.setText(td.get(5).text());
                w20.setText(td.get(1).text());
                L20.setText(td.get(2).text());
                STRK20.setText(td.get(15).text());
name20.setText(td.get(0).text());
num20.setText(String.valueOf(i+1));
                image20.setImageResource(getlistlogo(td.get(0).text()));


            }
            if (i==20) {
                td = list.get(i).select("td");
                gp21.setText(td.get(5).text());
                w21.setText(td.get(1).text());
                L21.setText(td.get(2).text());
                STRK21.setText(td.get(15).text());
name21.setText(td.get(0).text());
num21.setText(String.valueOf(i+1));
                image21.setImageResource(getlistlogo(td.get(0).text()));
                System.out.println("10");


            }
            if (i==21) {
                td = list.get(i).select("td");
                gp22.setText(td.get(5).text());
                w22.setText(td.get(1).text());
                L22.setText(td.get(2).text());
                STRK22.setText(td.get(15).text());
name22.setText(td.get(0).text());
num22.setText(String.valueOf(i+1));
                image22.setImageResource(getlistlogo(td.get(0).text()));


            }
            if (i==22) {
                td = list.get(i).select("td");
                gp23.setText(td.get(5).text());
                w23.setText(td.get(1).text());
                L23.setText(td.get(2).text());
                STRK23.setText(td.get(15).text());
name23.setText(td.get(0).text());
num23.setText(String.valueOf(i+1));
                image23.setImageResource(getlistlogo(td.get(0).text()));


            }
            if (i==23) {
                td = list.get(i).select("td");
                gp24.setText(td.get(5).text());
                w24.setText(td.get(1).text());
                L24.setText(td.get(2).text());
                STRK24.setText(td.get(15).text());
name24.setText(td.get(0).text());
num24.setText(String.valueOf(i+1));
                image24.setImageResource(getlistlogo(td.get(0).text()));


            }
            if (i==24) {
                td = list.get(i).select("td");
                gp25.setText(td.get(5).text());
                w25.setText(td.get(1).text());
                L25.setText(td.get(2).text());
                STRK25.setText(td.get(15).text());
name25.setText(td.get(0).text());
num25.setText(String.valueOf(i+1));
                image25.setImageResource(getlistlogo(td.get(0).text()));
                System.out.println("11");


            }
            if (i==25) {
                td = list.get(i).select("td");
                gp26.setText(td.get(5).text());
                w26.setText(td.get(1).text());
                L26.setText(td.get(2).text());
                STRK26.setText(td.get(15).text());
name26.setText(td.get(0).text());
num26.setText(String.valueOf(i+1));
                image26.setImageResource(getlistlogo(td.get(0).text()));


            }
            if (i==26) {
                td = list.get(i).select("td");
                gp27.setText(td.get(5).text());
                w27.setText(td.get(1).text());
                L27.setText(td.get(2).text());
                STRK27.setText(td.get(15).text());
name27.setText(td.get(0).text());
num27.setText(String.valueOf(i+1));
                image27.setImageResource(getlistlogo(td.get(0).text()));


            }
            if (i==27) {
                td = list.get(i).select("td");
                gp28.setText(td.get(5).text());
                w28.setText(td.get(1).text());
                L28.setText(td.get(2).text());
                STRK28.setText(td.get(15).text());
name28.setText(td.get(0).text());
num28.setText(String.valueOf(i+1));
                image28.setImageResource(getlistlogo(td.get(0).text()));


            }
            if (i==28) {
                td = list.get(i).select("td");
                gp29.setText(td.get(5).text());
                w29.setText(td.get(1).text());
                L29.setText(td.get(2).text());
                STRK29.setText(td.get(15).text());
name29.setText(td.get(0).text());
num29.setText(String.valueOf(i+1));
                image29.setImageResource(getlistlogo(td.get(0).text()));
                System.out.println("12");


            }
            if (i==29) {
                td = list.get(i).select("td");
                gp30.setText(td.get(5).text());
                w30.setText(td.get(1).text());
                L30.setText(td.get(2).text());
                STRK30.setText(td.get(15).text());
name30.setText(td.get(0).text());
num30.setText(String.valueOf(i+1));
                image30.setImageResource(getlistlogo(td.get(0).text()));


            }
            if (i==30) {
                td = list.get(i).select("td");
                gp31.setText(td.get(5).text());
                w31.setText(td.get(1).text());
                L31.setText(td.get(2).text());
                STRK31.setText(td.get(15).text());
name31.setText(td.get(0).text());
num31.setText(String.valueOf(i+1));
                image31.setImageResource(getlistlogo(td.get(0).text()));
                System.out.println("13");



            }
        }
        for (int i=0;i<td.size();i++){
            System.out.println(i+"::"+td.get(i).text());
        }



        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                rowtitle2.setVisibility(View.GONE);
                conrow1.setVisibility(View.GONE);
                conrow2.setVisibility(View.GONE);


                but.setTextColor(Color.RED);
                butcon.setTextColor(Color.WHITE);
                String url = "https://www.foxsports.com/nhl/standings?season=2019&seasonType=1&grouping=4";
                ArrayList<Element> list=new ArrayList<Element>();
                try {

                    list = new Task5(getApplicationContext(),url).execute().get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                list.remove(0);
                for (int i=0;i<list.size();i++){
                    System.out.println(i+"::"+list.get(i).text());
                }
                Elements td=null;

                for (int i=0;i<list.size();i++){
                    if (i==0) {
                        td = list.get(i).select("td");
                        gp1.setText(td.get(5).text());
                        w1.setText(td.get(1).text());
                        L1.setText(td.get(2).text());
                        STRK1.setText(td.get(15).text());
                        name1.setText(td.get(0).text());
                        num1.setText(String.valueOf(i+1));
                image1.setImageResource(getlistlogo(td.get(0).text()));


                    }
                    if (i==1) {
                        td = list.get(i).select("td");
                        gp2.setText(td.get(5).text());
                        w2.setText(td.get(1).text());
                        L2.setText(td.get(2).text());
                        STRK2.setText(td.get(15).text());
                        name2.setText(td.get(0).text());
                        num2.setText(String.valueOf(i+1));
                image2.setImageResource(getlistlogo(td.get(0).text()));


                    }
                    if (i==2) {
                        td = list.get(i).select("td");
                        gp3.setText(td.get(5).text());
                        w3.setText(td.get(1).text());
                        L3.setText(td.get(2).text());
                        STRK3.setText(td.get(15).text());
                        name3.setText(td.get(0).text());
                        num3.setText(String.valueOf(i+1));
                image3.setImageResource(getlistlogo(td.get(0).text()));


                    }
                    if (i==3) {
                        td = list.get(i).select("td");
                        gp4.setText(td.get(5).text());
                        w4.setText(td.get(1).text());
                        L4.setText(td.get(2).text());
                        STRK4.setText(td.get(15).text());
                        name4.setText(td.get(0).text());
                        num4.setText(String.valueOf(i+1));
                image4.setImageResource(getlistlogo(td.get(0).text()));

                    }
                    if (i==4) {
                        td = list.get(i).select("td");
                        gp5.setText(td.get(5).text());
                        w5.setText(td.get(1).text());
                        L5.setText(td.get(2).text());
                        STRK5.setText(td.get(15).text());
                        name5.setText(td.get(0).text());
                        num5.setText(String.valueOf(i+1));
                image5.setImageResource(getlistlogo(td.get(0).text()));



                    }
                    if (i==5) {
                        td = list.get(i).select("td");
                        gp6.setText(td.get(5).text());
                        w6.setText(td.get(1).text());
                        L6.setText(td.get(2).text());
                        STRK6.setText(td.get(15).text());
                        name6.setText(td.get(0).text());
                        num6.setText(String.valueOf(i+1));
                image6.setImageResource(getlistlogo(td.get(0).text()));


                    }
                    if (i==6) {
                        td = list.get(i).select("td");
                        gp7.setText(td.get(5).text());
                        w7.setText(td.get(1).text());
                        L7.setText(td.get(2).text());
                        STRK7.setText(td.get(15).text());
                        name7.setText(td.get(0).text());
                        num7.setText(String.valueOf(i+1));
                image7.setImageResource(getlistlogo(td.get(0).text()));


                    }
                    if (i==7) {
                        td = list.get(i).select("td");
                        gp8.setText(td.get(5).text());
                        w8.setText(td.get(1).text());
                        L8.setText(td.get(2).text());
                        STRK8.setText(td.get(15).text());
                        name8.setText(td.get(0).text());
                        num8.setText(String.valueOf(i+1));
                image8.setImageResource(getlistlogo(td.get(0).text()));


                    }
                    if (i==8) {
                        td = list.get(i).select("td");
                        gp9.setText(td.get(5).text());
                        w9.setText(td.get(1).text());
                        L9.setText(td.get(2).text());
                        STRK9.setText(td.get(15).text());
                        name9.setText(td.get(0).text());
                        num9.setText(String.valueOf(i+1));
                image9.setImageResource(getlistlogo(td.get(0).text()));


                    }
                    if (i==9) {
                        td = list.get(i).select("td");
                        gp10.setText(td.get(5).text());
                        w10.setText(td.get(1).text());
                        L10.setText(td.get(2).text());
                        STRK10.setText(td.get(15).text());
                        name10.setText(td.get(0).text());
                        num10.setText(String.valueOf(i+1));
                image10.setImageResource(getlistlogo(td.get(0).text()));


                    }
                    if (i==10) {
                        td = list.get(i).select("td");
                        gp11.setText(td.get(5).text());
                        w11.setText(td.get(1).text());
                        L11.setText(td.get(2).text());
                        STRK11.setText(td.get(15).text());
                        name11.setText(td.get(0).text());
                        num11.setText(String.valueOf(i+1));
                image11.setImageResource(getlistlogo(td.get(0).text()));


                    }
                    if (i==11) {
                        td = list.get(i).select("td");
                        gp12.setText(td.get(5).text());
                        w12.setText(td.get(1).text());
                        L12.setText(td.get(2).text());
                        STRK12.setText(td.get(15).text());
                        name12.setText(td.get(0).text());
                        num12.setText(String.valueOf(i+1));
                image12.setImageResource(getlistlogo(td.get(0).text()));


                    }
                    if (i==12) {
                        td = list.get(i).select("td");
                        gp13.setText(td.get(5).text());
                        w13.setText(td.get(1).text());
                        L13.setText(td.get(2).text());
                        STRK13.setText(td.get(15).text());
                        name13.setText(td.get(0).text());
                        num13.setText(String.valueOf(i+1));
                image13.setImageResource(getlistlogo(td.get(0).text()));


                    }
                    if (i==13) {
                        td = list.get(i).select("td");
                        gp14.setText(td.get(5).text());
                        w14.setText(td.get(1).text());
                        L14.setText(td.get(2).text());
                        STRK14.setText(td.get(15).text());
                        name14.setText(td.get(0).text());
                        num14.setText(String.valueOf(i+1));
                image14.setImageResource(getlistlogo(td.get(0).text()));


                    }
                    if (i==14) {
                        td = list.get(i).select("td");
                        gp15.setText(td.get(5).text());
                        w15.setText(td.get(1).text());
                        L15.setText(td.get(2).text());
                        STRK15.setText(td.get(15).text());
                        name15.setText(td.get(0).text());
                        num15.setText(String.valueOf(i+1));
                image15.setImageResource(getlistlogo(td.get(0).text()));


                    }
                    if (i==15) {
                        td = list.get(i).select("td");
                        gp16.setText(td.get(5).text());
                        w16.setText(td.get(1).text());
                        L16.setText(td.get(2).text());
                        STRK16.setText(td.get(15).text());
                        name16.setText(td.get(0).text());
                        num16.setText(String.valueOf(i+1));
                image16.setImageResource(getlistlogo(td.get(0).text()));


                    }
                    if (i==16) {
                        td = list.get(i).select("td");
                        gp17.setText(td.get(5).text());
                        w17.setText(td.get(1).text());
                        L17.setText(td.get(2).text());
                        STRK17.setText(td.get(15).text());
                        name17.setText(td.get(0).text());
                        num17.setText(String.valueOf(i+1));
                image17.setImageResource(getlistlogo(td.get(0).text()));


                    }
                    if (i==17) {
                        td = list.get(i).select("td");
                        gp18.setText(td.get(5).text());
                        w18.setText(td.get(1).text());
                        L18.setText(td.get(2).text());
                        STRK18.setText(td.get(15).text());
                        name18.setText(td.get(0).text());
                        num18.setText(String.valueOf(i+1));
                image18.setImageResource(getlistlogo(td.get(0).text()));


                    }
                    if (i==18) {
                        td = list.get(i).select("td");
                        gp19.setText(td.get(5).text());
                        w19.setText(td.get(1).text());
                        L19.setText(td.get(2).text());
                        STRK19.setText(td.get(15).text());
                        name19.setText(td.get(0).text());
                        num19.setText(String.valueOf(i+1));
                image19.setImageResource(getlistlogo(td.get(0).text()));


                    }
                    if (i==19) {
                        td = list.get(i).select("td");
                        gp20.setText(td.get(5).text());
                        w20.setText(td.get(1).text());
                        L20.setText(td.get(2).text());
                        STRK20.setText(td.get(15).text());
                        name20.setText(td.get(0).text());
                        num20.setText(String.valueOf(i+1));
                image20.setImageResource(getlistlogo(td.get(0).text()));


                    }
                    if (i==20) {
                        td = list.get(i).select("td");
                        gp21.setText(td.get(5).text());
                        w21.setText(td.get(1).text());
                        L21.setText(td.get(2).text());
                        STRK21.setText(td.get(15).text());
                        name21.setText(td.get(0).text());
                        num21.setText(String.valueOf(i+1));
                image21.setImageResource(getlistlogo(td.get(0).text()));


                    }
                    if (i==21) {
                        td = list.get(i).select("td");
                        gp22.setText(td.get(5).text());
                        w22.setText(td.get(1).text());
                        L22.setText(td.get(2).text());
                        STRK22.setText(td.get(15).text());
                        name22.setText(td.get(0).text());
                        num22.setText(String.valueOf(i+1));
                image22.setImageResource(getlistlogo(td.get(0).text()));


                    }
                    if (i==22) {
                        td = list.get(i).select("td");
                        gp23.setText(td.get(5).text());
                        w23.setText(td.get(1).text());
                        L23.setText(td.get(2).text());
                        STRK23.setText(td.get(15).text());
                        name23.setText(td.get(0).text());
                        num23.setText(String.valueOf(i+1));
                image23.setImageResource(getlistlogo(td.get(0).text()));


                    }
                    if (i==23) {
                        td = list.get(i).select("td");
                        gp24.setText(td.get(5).text());
                        w24.setText(td.get(1).text());
                        L24.setText(td.get(2).text());
                        STRK24.setText(td.get(15).text());
                        name24.setText(td.get(0).text());
                        num24.setText(String.valueOf(i+1));
                image24.setImageResource(getlistlogo(td.get(0).text()));


                    }
                    if (i==24) {
                        td = list.get(i).select("td");
                        gp25.setText(td.get(5).text());
                        w25.setText(td.get(1).text());
                        L25.setText(td.get(2).text());
                        STRK25.setText(td.get(15).text());
                        name25.setText(td.get(0).text());
                        num25.setText(String.valueOf(i+1));
                image25.setImageResource(getlistlogo(td.get(0).text()));


                    }
                    if (i==25) {
                        td = list.get(i).select("td");
                        gp26.setText(td.get(5).text());
                        w26.setText(td.get(1).text());
                        L26.setText(td.get(2).text());
                        STRK26.setText(td.get(15).text());
                        name26.setText(td.get(0).text());
                        num26.setText(String.valueOf(i+1));
                image26.setImageResource(getlistlogo(td.get(0).text()));


                    }
                    if (i==26) {
                        td = list.get(i).select("td");
                        gp27.setText(td.get(5).text());
                        w27.setText(td.get(1).text());
                        L27.setText(td.get(2).text());
                        STRK27.setText(td.get(15).text());
                        name27.setText(td.get(0).text());
                        num27.setText(String.valueOf(i+1));
                image27.setImageResource(getlistlogo(td.get(0).text()));


                    }
                    if (i==27) {
                        td = list.get(i).select("td");
                        gp28.setText(td.get(5).text());
                        w28.setText(td.get(1).text());
                        L28.setText(td.get(2).text());
                        STRK28.setText(td.get(15).text());
                        name28.setText(td.get(0).text());
                        num28.setText(String.valueOf(i+1));
                image28.setImageResource(getlistlogo(td.get(0).text()));


                    }
                    if (i==28) {
                        td = list.get(i).select("td");
                        gp29.setText(td.get(5).text());
                        w29.setText(td.get(1).text());
                        L29.setText(td.get(2).text());
                        STRK29.setText(td.get(15).text());
                        name29.setText(td.get(0).text());
                        num29.setText(String.valueOf(i+1));
                image29.setImageResource(getlistlogo(td.get(0).text()));


                    }
                    if (i==29) {
                        td = list.get(i).select("td");
                        gp30.setText(td.get(5).text());
                        w30.setText(td.get(1).text());
                        L30.setText(td.get(2).text());
                        STRK30.setText(td.get(15).text());
                        name30.setText(td.get(0).text());
                        num30.setText(String.valueOf(i+1));
                image30.setImageResource(getlistlogo(td.get(0).text()));


                    }
                    if (i==30) {
                        td = list.get(i).select("td");
                        gp31.setText(td.get(5).text());
                        w31.setText(td.get(1).text());
                        L31.setText(td.get(2).text());
                        STRK31.setText(td.get(15).text());
                        name31.setText(td.get(0).text());
                        num31.setText(String.valueOf(i+1));
                image31.setImageResource(getlistlogo(td.get(0).text()));


                    }
                }
                for (int i=0;i<td.size();i++){
                    System.out.println(i+"::"+td.get(i).text());
                }

            }
        });

        butcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                butcon.setTextColor(Color.RED);
                but.setTextColor(Color.WHITE);
                rowtitle2.setVisibility(View.VISIBLE);
                conrow1.setVisibility(View.VISIBLE);
                conrow2.setVisibility(View.VISIBLE);


                String url = "https://www.foxsports.com/nhl/standings?season=2019&seasonType=1&grouping=2";
                ArrayList<Element> list=new ArrayList<Element>();
                try {

                    list = new Task5(getApplicationContext(),url).execute().get();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                list.remove(0);
                list.remove(17);
                list.remove(16);


                for (int i=0;i<list.size();i++){
                    System.out.println(i+"::"+list.get(i).text());
                }
                Elements td=null;

                int j=1;
                for (int i=0;i<list.size();i++){
                    if (i==0) {
                        td = list.get(i).select("td");
                        gp1.setText(td.get(5).text());
                        w1.setText(td.get(1).text());
                        L1.setText(td.get(2).text());
                        STRK1.setText(td.get(15).text());
                        name1.setText(td.get(0).text());
                        num1.setText(String.valueOf(j));
                image1.setImageResource(getlistlogo(td.get(0).text()));

j++;

                    }
                    if (i==1) {
                        td = list.get(i).select("td");
                        gp2.setText(td.get(5).text());
                        w2.setText(td.get(1).text());
                        L2.setText(td.get(2).text());
                        STRK2.setText(td.get(15).text());
                        name2.setText(td.get(0).text());
                        num2.setText(String.valueOf(j));
                image2.setImageResource(getlistlogo(td.get(0).text()));

j++;

                    }
                    if (i==2) {
                        td = list.get(i).select("td");
                        gp3.setText(td.get(5).text());
                        w3.setText(td.get(1).text());
                        L3.setText(td.get(2).text());
                        STRK3.setText(td.get(15).text());
                        name3.setText(td.get(0).text());
                        num3.setText(String.valueOf(j));
                image3.setImageResource(getlistlogo(td.get(0).text()));

j++;

                    }
                    if (i==3) {
                        td = list.get(i).select("td");
                        gp4.setText(td.get(5).text());
                        w4.setText(td.get(1).text());
                        L4.setText(td.get(2).text());
                        STRK4.setText(td.get(15).text());
                        name4.setText(td.get(0).text());
                        num4.setText(String.valueOf(j));
                image4.setImageResource(getlistlogo(td.get(0).text()));

j++;
                    }
                    if (i==4) {
                        td = list.get(i).select("td");
                        gp5.setText(td.get(5).text());
                        w5.setText(td.get(1).text());
                        L5.setText(td.get(2).text());
                        STRK5.setText(td.get(15).text());
                        name5.setText(td.get(0).text());
                        num5.setText(String.valueOf(j));
                image5.setImageResource(getlistlogo(td.get(0).text()));

j++;


                    }
                    if (i==5) {
                        td = list.get(i).select("td");
                        gp6.setText(td.get(5).text());
                        w6.setText(td.get(1).text());
                        L6.setText(td.get(2).text());
                        STRK6.setText(td.get(15).text());
                        name6.setText(td.get(0).text());
                        num6.setText(String.valueOf(j));
                image6.setImageResource(getlistlogo(td.get(0).text()));

j++;

                    }
                    if (i==6) {
                        td = list.get(i).select("td");
                        gp7.setText(td.get(5).text());
                        w7.setText(td.get(1).text());
                        L7.setText(td.get(2).text());
                        STRK7.setText(td.get(15).text());
                        name7.setText(td.get(0).text());
                        num7.setText(String.valueOf(j));
                image7.setImageResource(getlistlogo(td.get(0).text()));

j++;

                    }
                    if (i==7) {
                        td = list.get(i).select("td");
                        gp8.setText(td.get(5).text());
                        w8.setText(td.get(1).text());
                        L8.setText(td.get(2).text());
                        STRK8.setText(td.get(15).text());
                        name8.setText(td.get(0).text());
                        num8.setText(String.valueOf(j));
                image8.setImageResource(getlistlogo(td.get(0).text()));

j++;

                    }
                    if (i==8) {
                        td = list.get(i).select("td");
                        gp9.setText(td.get(5).text());
                        w9.setText(td.get(1).text());
                        L9.setText(td.get(2).text());
                        STRK9.setText(td.get(15).text());
                        name9.setText(td.get(0).text());
                        num9.setText(String.valueOf(j));
                image9.setImageResource(getlistlogo(td.get(0).text()));

j++;

                    }
                    if (i==9) {
                        td = list.get(i).select("td");
                        gp10.setText(td.get(5).text());
                        w10.setText(td.get(1).text());
                        L10.setText(td.get(2).text());
                        STRK10.setText(td.get(15).text());
                        name10.setText(td.get(0).text());
                        num10.setText(String.valueOf(j));
                image10.setImageResource(getlistlogo(td.get(0).text()));

j++;

                    }
                    if (i==10) {
                        td = list.get(i).select("td");
                        gp11.setText(td.get(5).text());
                        w11.setText(td.get(1).text());
                        L11.setText(td.get(2).text());
                        STRK11.setText(td.get(15).text());
                        name11.setText(td.get(0).text());
                        num11.setText(String.valueOf(j));
                image11.setImageResource(getlistlogo(td.get(0).text()));

j++;

                    }
                    if (i==11) {
                        td = list.get(i).select("td");
                        gp12.setText(td.get(5).text());
                        w12.setText(td.get(1).text());
                        L12.setText(td.get(2).text());
                        STRK12.setText(td.get(15).text());
                        name12.setText(td.get(0).text());
                        num12.setText(String.valueOf(j));
                image12.setImageResource(getlistlogo(td.get(0).text()));

j++;

                    }
                    if (i==12) {
                        td = list.get(i).select("td");
                        gp13.setText(td.get(5).text());
                        w13.setText(td.get(1).text());
                        L13.setText(td.get(2).text());
                        STRK13.setText(td.get(15).text());
                        name13.setText(td.get(0).text());
                        num13.setText(String.valueOf(j));
                image13.setImageResource(getlistlogo(td.get(0).text()));

j++;

                    }
                    if (i==13) {
                        td = list.get(i).select("td");
                        gp14.setText(td.get(5).text());
                        w14.setText(td.get(1).text());
                        L14.setText(td.get(2).text());
                        STRK14.setText(td.get(15).text());
                        name14.setText(td.get(0).text());
                        num14.setText(String.valueOf(j));
                image14.setImageResource(getlistlogo(td.get(0).text()));

j++;

                    }
                    if (i==14) {
                        td = list.get(i).select("td");
                        gp15.setText(td.get(5).text());
                        w15.setText(td.get(1).text());
                        L15.setText(td.get(2).text());
                        STRK15.setText(td.get(15).text());
                        name15.setText(td.get(0).text());
                        num15.setText(String.valueOf(j));
                image15.setImageResource(getlistlogo(td.get(0).text()));

j++;

                    }
                    if (i==15) {
                        td = list.get(i).select("td");
                        gp16.setText(td.get(5).text());
                        w16.setText(td.get(1).text());
                        L16.setText(td.get(2).text());
                        STRK16.setText(td.get(15).text());
                        name16.setText(td.get(0).text());
                        num16.setText(String.valueOf(j));
                image16.setImageResource(getlistlogo(td.get(0).text()));

j=1;

                    }
                    if (i==16) {
                        td = list.get(i).select("td");
                        gp17.setText(td.get(5).text());
                        w17.setText(td.get(1).text());
                        L17.setText(td.get(2).text());
                        STRK17.setText(td.get(15).text());
                        name17.setText(td.get(0).text());
                        num17.setText(String.valueOf(j));
                image17.setImageResource(getlistlogo(td.get(0).text()));

j++;

                    }
                    if (i==17) {
                        td = list.get(i).select("td");
                        gp18.setText(td.get(5).text());
                        w18.setText(td.get(1).text());
                        L18.setText(td.get(2).text());
                        STRK18.setText(td.get(15).text());
                        name18.setText(td.get(0).text());
                        num18.setText(String.valueOf(j));
                image18.setImageResource(getlistlogo(td.get(0).text()));

j++;

                    }
                    if (i==18) {
                        td = list.get(i).select("td");
                        gp19.setText(td.get(5).text());
                        w19.setText(td.get(1).text());
                        L19.setText(td.get(2).text());
                        STRK19.setText(td.get(15).text());
                        name19.setText(td.get(0).text());
                        num19.setText(String.valueOf(j));
                image19.setImageResource(getlistlogo(td.get(0).text()));

j++;

                    }
                    if (i==19) {
                        td = list.get(i).select("td");
                        gp20.setText(td.get(5).text());
                        w20.setText(td.get(1).text());
                        L20.setText(td.get(2).text());
                        STRK20.setText(td.get(15).text());
                        name20.setText(td.get(0).text());
                        num20.setText(String.valueOf(j));
                image20.setImageResource(getlistlogo(td.get(0).text()));

j++;

                    }
                    if (i==20) {
                        td = list.get(i).select("td");
                        gp21.setText(td.get(5).text());
                        w21.setText(td.get(1).text());
                        L21.setText(td.get(2).text());
                        STRK21.setText(td.get(15).text());
                        name21.setText(td.get(0).text());
                        num21.setText(String.valueOf(j));
                image21.setImageResource(getlistlogo(td.get(0).text()));

j++;

                    }
                    if (i==21) {
                        td = list.get(i).select("td");
                        gp22.setText(td.get(5).text());
                        w22.setText(td.get(1).text());
                        L22.setText(td.get(2).text());
                        STRK22.setText(td.get(15).text());
                        name22.setText(td.get(0).text());
                        num22.setText(String.valueOf(j));
                image22.setImageResource(getlistlogo(td.get(0).text()));

j++;

                    }
                    if (i==22) {
                        td = list.get(i).select("td");
                        gp23.setText(td.get(5).text());
                        w23.setText(td.get(1).text());
                        L23.setText(td.get(2).text());
                        STRK23.setText(td.get(15).text());
                        name23.setText(td.get(0).text());
                        num23.setText(String.valueOf(j));
                image23.setImageResource(getlistlogo(td.get(0).text()));

j++;

                    }
                    if (i==23) {
                        td = list.get(i).select("td");
                        gp24.setText(td.get(5).text());
                        w24.setText(td.get(1).text());
                        L24.setText(td.get(2).text());
                        STRK24.setText(td.get(15).text());
                        name24.setText(td.get(0).text());
                        num24.setText(String.valueOf(j));
                image24.setImageResource(getlistlogo(td.get(0).text()));

j++;

                    }
                    if (i==24) {
                        td = list.get(i).select("td");
                        gp25.setText(td.get(5).text());
                        w25.setText(td.get(1).text());
                        L25.setText(td.get(2).text());
                        STRK25.setText(td.get(15).text());
                        name25.setText(td.get(0).text());
                        num25.setText(String.valueOf(j));
                image25.setImageResource(getlistlogo(td.get(0).text()));

j++;

                    }
                    if (i==25) {
                        td = list.get(i).select("td");
                        gp26.setText(td.get(5).text());
                        w26.setText(td.get(1).text());
                        L26.setText(td.get(2).text());
                        STRK26.setText(td.get(15).text());
                        name26.setText(td.get(0).text());
                        num26.setText(String.valueOf(j));
                image26.setImageResource(getlistlogo(td.get(0).text()));

j++;

                    }
                    if (i==26) {
                        td = list.get(i).select("td");
                        gp27.setText(td.get(5).text());
                        w27.setText(td.get(1).text());
                        L27.setText(td.get(2).text());
                        STRK27.setText(td.get(15).text());
                        name27.setText(td.get(0).text());
                        num27.setText(String.valueOf(j));
                image27.setImageResource(getlistlogo(td.get(0).text()));

j++;

                    }
                    if (i==27) {
                        td = list.get(i).select("td");
                        gp28.setText(td.get(5).text());
                        w28.setText(td.get(1).text());
                        L28.setText(td.get(2).text());
                        STRK28.setText(td.get(15).text());
                        name28.setText(td.get(0).text());
                        num28.setText(String.valueOf(j));
                image28.setImageResource(getlistlogo(td.get(0).text()));

j++;

                    }
                    if (i==28) {
                        td = list.get(i).select("td");
                        gp29.setText(td.get(5).text());
                        w29.setText(td.get(1).text());
                        L29.setText(td.get(2).text());
                        STRK29.setText(td.get(15).text());
                        name29.setText(td.get(0).text());
                        num29.setText(String.valueOf(j));
                image29.setImageResource(getlistlogo(td.get(0).text()));

j++;

                    }
                    if (i==29) {
                        td = list.get(i).select("td");
                        gp30.setText(td.get(5).text());
                        w30.setText(td.get(1).text());
                        L30.setText(td.get(2).text());
                        STRK30.setText(td.get(15).text());
                        name30.setText(td.get(0).text());
                        num30.setText(String.valueOf(j));
                image30.setImageResource(getlistlogo(td.get(0).text()));

j++;

                    }
                    if (i==30) {
                        td = list.get(i).select("td");
                        gp31.setText(td.get(5).text());
                        w31.setText(td.get(1).text());
                        L31.setText(td.get(2).text());
                        STRK31.setText(td.get(15).text());
                        name31.setText(td.get(0).text());
                        num31.setText(String.valueOf(j));
                image31.setImageResource(getlistlogo(td.get(0).text()));

j++;

                    }
                }
                for (int i=0;i<td.size();i++){
                    System.out.println(i+"::"+td.get(i).text());
                }

            }
        });


     /*   row1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row1.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));
                MainActivity.FavTeam="New York Rangers";
                Intent intent = new Intent(StandingsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });

        row2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row2.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Vegas Golden Knights";
                Intent intent = new Intent(StandingsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row3.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Toronto Maple Leafs";
                Intent intent = new Intent(StandingsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                row4.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Tampa Bay Lightning";
                Intent intent = new Intent(StandingsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row5.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Vancouver Canucks";
                Intent intent = new Intent(StandingsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row6.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Washington Capitals";
                Intent intent = new Intent(StandingsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row7.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Minnesota Wild";
                Intent intent = new Intent(StandingsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row8.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Columbus Blue Jackets";
                Intent intent = new Intent(StandingsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row9.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Ottawa Senators";
                Intent intent = new Intent(StandingsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row10.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Pittsburgh Penguins";
                Intent intent = new Intent(StandingsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row11.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Philadelphia Flyers";
                Intent intent = new Intent(StandingsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });

        row12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row12.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Arizona Coyotes";
                Intent intent = new Intent(StandingsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row13.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="San Jose Sharks";
                Intent intent = new Intent(StandingsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row14.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="St. Louis Blues";
                Intent intent = new Intent(StandingsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row15.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Florida Panthers";
                Intent intent = new Intent(StandingsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row16.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Montreal Canadiens";
                Intent intent = new Intent(StandingsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row17.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Nashville Predators";
                Intent intent = new Intent(StandingsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row18.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="New Jersey Devils";
                Intent intent = new Intent(StandingsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row19.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="New York Islanders";
                Intent intent = new Intent(StandingsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row20.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Los Angeles Kings";
                Intent intent = new Intent(StandingsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row21.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Winnipeg Jets";
                Intent intent = new Intent(StandingsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row22.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Buffalo Sabres";
                Intent intent = new Intent(StandingsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row23.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Boston Bruins";
                Intent intent = new Intent(StandingsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row24.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Calgary Flames";
                Intent intent = new Intent(StandingsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row25.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Carolina Hurricanes";
                Intent intent = new Intent(StandingsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row26.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row26.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Chicago Blackhawks";
                Intent intent = new Intent(StandingsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row27.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row27.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Colorado Avalanche";
                Intent intent = new Intent(StandingsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row28.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Dallas Stars";
                Intent intent = new Intent(StandingsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row29.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row29.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Detroit Red Wings";
                Intent intent = new Intent(StandingsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
            }
        });
        row30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row30.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));

                MainActivity.FavTeam="Edmonton Oilers";
                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
                Intent intent = new Intent(StandingsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
        row31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                row31.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.colorred));
                MainActivity.FavTeam="Anaheim Ducks";

                sp = getSharedPreferences("FavTeam", MODE_PRIVATE);
                sp.edit().putString("FavTeam",MainActivity.FavTeam).apply();
                Intent intent = new Intent(StandingsActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

      */

    }
    @Override
    public void onBackPressed() {

        super.onBackPressed();
        Intent intent = new Intent(StandingsActivity.this, MainActivity.class);
        startActivity(intent);
        finish();

    }


}
