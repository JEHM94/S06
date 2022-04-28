package com.example.seccion_06_fragments.Activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.example.seccion_06_fragments.Fragments.DataFragment;
import com.example.seccion_06_fragments.Fragments.DetailsFragment;
import com.example.seccion_06_fragments.R;

public class MainActivity extends FragmentActivity implements DataFragment.DataListener {

    private boolean isMultiPanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setMultiPanel();
    }

    @Override
    public void sendData(String text) {
        // LLamar al metodo renderizarTexto del DetailsFragments
        // pasando el texto que recibimos por parametro en este mismo metodo.

        // Verificamos si se renderizaron los 2 fragment
        if(isMultiPanel){
            DetailsFragment detailsFragment = (DetailsFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.detailsFragment);
            detailsFragment.renderText(text);
        } else{
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            intent.putExtra("text", text);
            startActivity(intent);
        }
    }

    public void setMultiPanel(){
        isMultiPanel = (getSupportFragmentManager().findFragmentById(R.id.detailsFragment)) != null;
    }
}