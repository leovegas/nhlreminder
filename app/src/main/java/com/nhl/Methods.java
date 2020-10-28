package com.nhl;

import android.content.Context;
import android.widget.ImageView;

public class Methods {
    public int GetLogo(Context context, String FavTeam) {

        if (FavTeam.equals(context.getString(R.string.Anaheim))) {
            return R.drawable.anaheim;

        }
        if (FavTeam.equals(context.getString(R.string.Winnipeg))) {
            return R.drawable.winnipeg;


        }
        if (FavTeam.equals(context.getString(R.string.Boston))) {
            return R.drawable.boston;

        }
        if (FavTeam.equals(context.getString(R.string.Buffalo))) {
            return R.drawable.buffalo;


        }
        if (FavTeam.equals(context.getString(R.string.Calgary))) {
            return R.drawable.calgary;

        }
        if (FavTeam.equals(context.getString(R.string.Carolina))) {
            return R.drawable.carolina;

        }
        if (FavTeam.equals(context.getString(R.string.Chicago))) {
            return R.drawable.chicago;


        }
        if (FavTeam.equals(context.getString(R.string.Colorado))) {
            return R.drawable.colorado;


        }
        if (FavTeam.equals(context.getString(R.string.DallasStars))) {
            return R.drawable.dallas;


        }
        if (FavTeam.equals(context.getString(R.string.Detroit))) {
            return R.drawable.detroit;


        }
        if (FavTeam.equals(context.getString(R.string.Edmonton))) {
            return R.drawable.oilers;

        }
        if (FavTeam.equals(context.getString(R.string.Florida))) {
            return R.drawable.florida;


        }
        if (FavTeam.equals(context.getString(R.string.Montreal))) {
            return R.drawable.monreal;


        }
        if (FavTeam.equals(context.getString(R.string.Nashville))) {
            return R.drawable.nashvill;


        }
        if (FavTeam.equals(context.getString(R.string.NewJersey))) {
            return R.drawable.devils;


        }
        if (FavTeam.equals(context.getString(R.string.NYRangers))) {
            return R.drawable.rangers;


        }
        if (FavTeam.equals(context.getString(R.string.Islanders))) {
            return R.drawable.islanders;


        }
        if (FavTeam.equals(context.getString(R.string.LosAngeles))) {
            return R.drawable.la;



        }
        if (FavTeam.equals(context.getString(R.string.Ottawa))) {
            return R.drawable.ottawa;

        }
        if (FavTeam.equals(context.getString(R.string.Pittsburgh))) {
            return R.drawable.pitsburg;


        }
        if (FavTeam.equals(context.getString(R.string.Philadelphia))) {
            return R.drawable.filadelfia;


        }
        if (FavTeam.equals(context.getString(R.string.Arizona))) {
            return R.drawable.arizona;


        }
        if (FavTeam.equals(context.getString(R.string.SanJose))) {
            return R.drawable.sharks;


        }
        if (FavTeam.equals(context.getString(R.string.Blues))) {
            return R.drawable.blues;

        }
        if (FavTeam.equals(context.getString(R.string.Toronto))) {
            return R.drawable.toronto;


        }
        if (FavTeam.equals(context.getString(R.string.TampaBay))) {
            return R.drawable.tampa;


        }
        if (FavTeam.equals(context.getString(R.string.Vancouver))) {
            return R.drawable.vancouver;


        }
        if (FavTeam.equals(context.getString(R.string.WashingtonCap))) {
            return R.drawable.washington;


        }
        if (FavTeam.equals(context.getString(R.string.Minnesota))) {
            return R.drawable.minnessota;


        }
        if (FavTeam.equals(context.getString(R.string.Columbus))) {
            return R.drawable.colambus;


        }
        if (FavTeam.equals(context.getString(R.string.Vegas))) {
            return R.drawable.vegas;


        }
        return 0;
    }
}
