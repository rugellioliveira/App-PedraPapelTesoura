package com.example.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view) {

        System.out.println("selecionado pedra");
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view) {

        System.out.println("selecionado papel");
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view) {

        System.out.println("selecionado tesoura");
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String opcaoSelecionada) {

        ImageView imageResultado = findViewById(R.id.imageResultado); //variável do tipo "ImageView" permite clicar na imagem
        TextView textoResultado = findViewById(R.id.textoResultado); //findViewById retorna resultado no tipo correspondente

        int numero = new Random().nextInt(3); //gera número aleatório entre 0 e 3 sem incluir o "3".

        String[] opcoes = {"pedra", "papel", "tesoura"};
        String opcaoApp = opcoes[numero];

        switch (opcaoApp) {// alternativa ao IF-ELSE
            case "pedra":
                imageResultado.setImageResource(R.drawable.pedra);  //acessa recursos armazenados na pasta drawable
                break;

            case "papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;

            case "tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if(
                (opcaoApp == "tesoura" && opcaoSelecionada=="papel") ||
                (opcaoApp == "papel" && opcaoSelecionada=="pedra")||
                (opcaoApp == "pedra" && opcaoSelecionada=="tesoura"))
        {//App ganhador
            textoResultado.setText("Você perdeu :(");
             }

        else if(
                (opcaoSelecionada == "tesoura" && opcaoApp=="papel") ||
                (opcaoSelecionada == "papel" && opcaoApp=="pedra")||
                (opcaoSelecionada == "pedra" && opcaoApp=="tesoura"))
        {//Usuario ganhador
            textoResultado.setText("Você ganhou :)");
             }

        else {//empate
            textoResultado.setText("Empatamos ;)");

        }

            System.out.println(opcaoApp);


        }


    }
