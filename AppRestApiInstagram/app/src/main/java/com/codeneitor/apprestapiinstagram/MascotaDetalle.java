package com.codeneitor.apprestapiinstagram;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class MascotaDetalle extends AppCompatActivity {
    public static final String KEY_EXTRA_URL = "url";
    public static final String KEY_EXTRA_LIKES = "like";

    private ImageView imvMascota;
    //TextView tvMascotaNombre;
    private TextView tvLikesDetalle;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_foto);


        //Agregamos nuestro ToolBar
        Toolbar toolbar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(toolbar);
        // Eliminamos el título por defecto del Toolbar
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Bundle parametros = getIntent().getExtras();
        String fotoURL = parametros.getString(KEY_EXTRA_URL);
        int likes = parametros.getInt(KEY_EXTRA_LIKES);

        //tvMascotaNombre = (TextView) findViewById(R.id.tvMascotaNombre);
        tvLikesDetalle = (TextView) findViewById(R.id.tvLikesDetalle);

        imvMascota = (ImageView) findViewById(R.id.imvMascota);
        Picasso.get()
                .load(fotoURL)
                .placeholder(R.drawable.gyo)
                .into(imvMascota);

        tvLikesDetalle.setText(""+likes);
        Log.i("LIKES",""+likes);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(MascotaDetalle.this,MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_mascota, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.mDelMascota:
                try {
                    Toast.makeText(this, R.string.mDelete, Toast.LENGTH_LONG).show();
                } catch (Resources.NotFoundException e) {
                    Log.i("EROOR",getResources().getString(R.string.error011));
                }
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
