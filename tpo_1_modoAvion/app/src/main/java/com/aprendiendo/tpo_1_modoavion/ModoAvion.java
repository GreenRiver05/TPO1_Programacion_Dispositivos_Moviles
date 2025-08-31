package com.aprendiendo.tpo_1_modoavion;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

public class ModoAvion extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        //ACTION_AIRPLANE_MODE_CHANGED trae un valor extra que es el "state" indica si esta activo o no el MA🛫
        Boolean estadoModoAvion = intent.getBooleanExtra("state", false);

        if (estadoModoAvion) {
            Toast.makeText(context, "Modo Avión ACTIVADO 🛫", Toast.LENGTH_LONG).show();
            Intent hacerLlamada = new Intent(Intent.ACTION_DIAL);
            hacerLlamada.setData(Uri.parse("tel:2657545872"));
            hacerLlamada.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(hacerLlamada);
        } else {
            Toast.makeText(context, "Modo Avión DESACTIVADO 🛬", Toast.LENGTH_LONG).show();
        }

    }
}