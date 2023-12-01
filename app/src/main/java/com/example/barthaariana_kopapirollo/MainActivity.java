package com.example.barthaariana_kopapirollo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewGamer;
    private ImageView imageViewComputer;
    private int randomNumber;
    private int number;
    private TextView gamersScoreNumber;
    private int numberGamers;
    private TextView computersScoreNumber;
    private int numberComputer;
    private Button rockButton;
    private Button paperButton;
    private Button scissorsButton;
    private AlertDialog.Builder alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageViewGamer.setImageResource(R.drawable.rock);
                number = 0;
                computerChoose();
                if(randomNumber == 0){
                    Toast.makeText(MainActivity.this, "Döntetlen", Toast.LENGTH_SHORT).show();
                }else if(randomNumber == 1){
                    Toast.makeText(MainActivity.this, "Jajj, a gép győzött!", Toast.LENGTH_SHORT).show();
                    //TODO Gépnek +1 pont
                    numberComputer++;
                    computersScoreNumber.setText(String.valueOf(numberComputer));
                    countWins();
                }else{
                    Toast.makeText(MainActivity.this, "Győztél! :)", Toast.LENGTH_SHORT).show();
                    //TODO Játékosnak +1 pont
                    numberGamers++;
                    gamersScoreNumber.setText(String.valueOf(numberGamers));
                    countWins();
                }
            }
        });
        paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageViewGamer.setImageResource(R.drawable.paper);
                number = 1;
                computerChoose();
                if(randomNumber == 0){
                    Toast.makeText(MainActivity.this, "Győztél! :)", Toast.LENGTH_SHORT).show();
                    //TODO Játékosnak +1 pont
                    numberGamers++;
                    gamersScoreNumber.setText(String.valueOf(numberGamers));
                    countWins();
                }else if(randomNumber == 1){
                    Toast.makeText(MainActivity.this, "Döntetlen", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Jajj, a gép győzött!", Toast.LENGTH_SHORT).show();
                    //TODO Gépnek +1 pont
                    numberComputer++;
                    computersScoreNumber.setText(String.valueOf(numberComputer));
                    countWins();
                }
            }
        });
        scissorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageViewGamer.setImageResource(R.drawable.scissors);
                number = 2;
                computerChoose();
                if(randomNumber == 0){
                    Toast.makeText(MainActivity.this, "Jajj, a gép győzött!", Toast.LENGTH_SHORT).show();
                    //TODO Gépnek +1 pont
                    numberComputer++;
                    computersScoreNumber.setText(String.valueOf(numberComputer));
                    countWins();
                }else if(randomNumber == 1){
                    Toast.makeText(MainActivity.this, "Győztél! :)", Toast.LENGTH_SHORT).show();
                    //TODO Játékosnak +1 pont
                    numberGamers++;
                    gamersScoreNumber.setText(String.valueOf(numberGamers));
                    countWins();
                }else{
                    Toast.makeText(MainActivity.this, "Döntetlen", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    public void computerChoose(){
        Random random = new Random();
        randomNumber = random.nextInt(3);
        if(randomNumber == 0){
            imageViewComputer.setImageResource(R.drawable.rock);
        }else if(randomNumber == 1){
            imageViewComputer.setImageResource(R.drawable.paper);
        }else{
            imageViewComputer.setImageResource(R.drawable.scissors);
        }

    }

    public void countWins() {
        if (numberGamers == 3 || numberComputer == 3) {
            gameOver();
        }
    }

    public void gameOver(){
        if(numberGamers == 3 && numberComputer < 3){
            alertDialog.setTitle("Győzelem");
            alertDialog.create();
            alertDialog.show();
        }else if(numberComputer == 3 && numberGamers < 3){
            alertDialog.setTitle("Vereség");
            alertDialog.create();
            alertDialog.show();
        }
    }

    public void newGame(){
        numberGamers = 0;
        gamersScoreNumber.setText(String.valueOf(numberGamers));
        numberComputer = 0;
        computersScoreNumber.setText(String.valueOf(numberComputer));
        Random random = new Random();
        randomNumber = random.nextInt(3);
        number = 0;


    }

    public void init(){
        imageViewGamer = findViewById(R.id.imageViewGamer);
        imageViewComputer = findViewById(R.id.imageViewComputer);
        gamersScoreNumber = findViewById(R.id.gamersScoreNumber);
        numberGamers = 0;
        computersScoreNumber = findViewById(R.id.computersScoreNumber);
        numberComputer = 0;
        rockButton = findViewById(R.id.rockButton);
        paperButton = findViewById(R.id.paperButton);
        scissorsButton = findViewById(R.id.scissorsButton);
        Random random = new Random();
        randomNumber = random.nextInt(3);
        number = 0;
        alertDialog = new AlertDialog.Builder(MainActivity.this);
        alertDialog.setTitle("Game Over");
        alertDialog.setMessage("Szeretnél megint játszani?");
        alertDialog.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alertDialog.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                newGame();
            }
        });
        alertDialog.setCancelable(false);
    }
}