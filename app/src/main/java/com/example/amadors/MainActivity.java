package com.example.amadors;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.sql.Array;

public class MainActivity extends AppCompatActivity {
    //Empezamos a crear los objetos
    Button play_pause, btn_repetir;
    MediaPlayer mp; //En la clase Media player se crea el objeto mp siendo esta la que reproduce los audios largos
    ImageView iv; //Esta clase crea el control para cambiar la portada del reproductor

    //Creamos las variables que ayudaran a definir si se lleva un ciclo al momento de cambiar canciones
    int repetir=2, posicion =0;//Se define el índice mediante la variable posicion
    MediaPlayer vectormp [] = new MediaPlayer[19];//Empezamos un arreglo que define el numero de canciones que tendrá el reproductor

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Se establece conectividad entre la parte antes creada y la parte lógica
        //La conectividad se logrará a base de la variable R y los id dados a cada boton
        play_pause = (Button) findViewById(R.id.btn_play);
        btn_repetir = (Button) findViewById(R.id.btn_repetir);
        iv = (ImageView) findViewById(R.id.imageView);
        //Se utiliza el vector que ya habíamos creado y empezamos a definir las posiciones de las canciones y como se reproduciran
        vectormp[0] = MediaPlayer.create(this, R.raw.aloneagain);
        vectormp[1] = MediaPlayer.create(this, R.raw.aprovechate);
        vectormp[3] = MediaPlayer.create(this, R.raw.boysdontcry);
        vectormp[4] = MediaPlayer.create(this, R.raw.comeas);
        vectormp[5] = MediaPlayer.create(this, R.raw.ataque);
        vectormp[6] = MediaPlayer.create(this, R.raw.killer);
        vectormp[7] = MediaPlayer.create(this, R.raw.le);
        vectormp[8] = MediaPlayer.create(this, R.raw.let);
        vectormp[9] = MediaPlayer.create(this, R.raw.lobo);
        vectormp[10] = MediaPlayer.create(this, R.raw.on);
        vectormp[11] = MediaPlayer.create(this, R.raw.pied);
        vectormp[12] = MediaPlayer.create(this, R.raw.something);
        vectormp[13] = MediaPlayer.create(this, R.raw.tequiero);
        vectormp[14] = MediaPlayer.create(this, R.raw.ven);
        vectormp[15] = MediaPlayer.create(this, R.raw.song1);
        vectormp[16] = MediaPlayer.create(this, R.raw.what);
        vectormp[17] = MediaPlayer.create(this, R.raw.yourock);
        vectormp[18] = MediaPlayer.create(this, R.raw.song1);
        vectormp[19] = MediaPlayer.create(this, R.raw.primer);
        posicion = 0;
        play_pause.setBackgroundResource(R.drawable.reproducir);
        iv.setImageResource(R.drawable.aloneagain);
        Toast.makeText(this,"Stop", Toast.LENGTH_SHORT).show();
    }
    //Daremos funcionalidad a la aplicación
    //play_pause
    public void PlayPause(View view){
        if(vectormp[posicion].isPlaying()){//Usamos una condicional if para indicar que SI tal cancion ubicada en tal vector esta reproduciendo
            vectormp[posicion].pause();//La canción se pausará
            play_pause.setBackgroundResource(R.drawable.reproducir);//Se sustituye la imagen anterior del boton por una nueva
            Toast.makeText(this,"Pausa", Toast.LENGTH_SHORT).show();//Envia un mensaje despues de presionar el boton
        }else{
            vectormp[posicion].start();//Empieza la música
            play_pause.setBackgroundResource(R.drawable.pausa);//cambia la imagen por pausa
            Toast.makeText(this,"Play", Toast.LENGTH_SHORT).show();//Envia un mensaje de reproducir
        }
    }
    //Metodo para el boton stop
    public void Stop(View view){
        if (vectormp[posicion] != null){
            vectormp[posicion].stop();
        }
    }
    //Metodo para repetir o no una canción mediante un SETLOOPIN
    public void Repetir(View view) {
        if (repetir == 1) {//Aqui estamos verificando si es igual a 1
            btn_repetir.setBackgroundResource(R.drawable.no_repetir);//Cambiamos el ícono
            Toast.makeText(this, "No repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(false);//Dependiendo el valor booleano falso o verdadero este metodo define si se repite una cancion
            repetir = 2;//Si se repite la canción
        } else {//entonces
            btn_repetir.setBackgroundResource(R.drawable.depetir); //Se activa el boton repetir
            Toast.makeText(this, "Repetir", Toast.LENGTH_SHORT).show();
            vectormp[posicion].setLooping(true);//Se hará un bucle para que se repita la canción
            repetir = 1;
        }
    }

    private void noname() {

        for (int i = 0; i < vectormp.length; i++) {
            MediaPlayer element = vectormp[i];

            iv.setImageResource(element.getAudioSessionId());
        }
    }
        public void Siguiente (View view){
            if (posicion < vectormp.length-1){//Esto para que no haya un desbordamiento de memoria

                if (vectormp[posicion].isPlaying()){//verifica si la canción se está reproduciendo
                    vectormp[posicion].stop();//Detiene la cancion para poder escuchar la siguiente
                    posicion++;//va a incrementar el índice y reccorer el vector
                    vectormp[posicion].start();//Empezará una nueva canción
                }

               // noname();

                if (posicion==0){
                    iv.setImageResource(R.drawable.aloneagain);
                } else if (posicion==1) {
                    iv.setImageResource(R.drawable.aprovechate);
                } else if (posicion==2) {
                    iv.setImageResource(R.drawable.song1);
                } else if (posicion==3) {
                    iv.setImageResource(R.drawable.boysdontcry);
                } else if (posicion==4) {
                    iv.setImageResource(R.drawable.comeas);
                } else if (posicion==5) {
                    iv.setImageResource(R.drawable.ataque);
                } else if (posicion==6) {
                    iv.setImageResource(R.drawable.killer);
                } else if (posicion==7) {
                    iv.setImageResource(R.drawable.le);
                } else if (posicion==8) {
                    iv.setImageResource(R.drawable.let);
                } else if (posicion==9) {
                    iv.setImageResource(R.drawable.lobo);
                } else if (posicion==10) {
                    iv.setImageResource(R.drawable.on);
                } else if (posicion==11) {
                    iv.setImageResource(R.drawable.pied);
                } else if (posicion==12) {
                    iv.setImageResource(R.drawable.something);
                } else if (posicion==13) {
                    iv.setImageResource(R.drawable.tequiero);
                } else if (posicion==14) {
                    iv.setImageResource(R.drawable.ven);
                } else if (posicion==15) {
                    iv.setImageResource(R.drawable.view);
                } else if (posicion==16) {
                    iv.setImageResource(R.drawable.what);
                } else if (posicion==17) {
                    iv.setImageResource(R.drawable.yourock);
                } else if (posicion==18) {
                    iv.setImageResource(R.drawable.song1);
                } else if (posicion==19) {
                    iv.setImageResource(R.drawable.primer);
                }
            }else {
                posicion++;
                if (posicion==0){
                    iv.setImageResource(R.drawable.aloneagain);
                } else if (posicion==1) {
                    iv.setImageResource(R.drawable.aprovechate);
                } else if (posicion==2) {
                    iv.setImageResource(R.drawable.song1);
                } else if (posicion==3) {
                    iv.setImageResource(R.drawable.boysdontcry);
                } else if (posicion==4) {
                    iv.setImageResource(R.drawable.comeas);
                } else if (posicion==5) {
                    iv.setImageResource(R.drawable.ataque);
                } else if (posicion==6) {
                    iv.setImageResource(R.drawable.killer);
                } else if (posicion==7) {
                    iv.setImageResource(R.drawable.le);
                } else if (posicion==8) {
                    iv.setImageResource(R.drawable.let);
                } else if (posicion==9) {
                    iv.setImageResource(R.drawable.lobo);
                } else if (posicion==10) {
                    iv.setImageResource(R.drawable.on);
                } else if (posicion==11) {
                    iv.setImageResource(R.drawable.pied);
                } else if (posicion==12) {
                    iv.setImageResource(R.drawable.something);
                } else if (posicion==13) {
                    iv.setImageResource(R.drawable.tequiero);
                } else if (posicion==14) {
                    iv.setImageResource(R.drawable.ven);
                } else if (posicion==15) {
                    iv.setImageResource(R.drawable.view);
                } else if (posicion==16) {
                    iv.setImageResource(R.drawable.what);
                } else if (posicion==17) {
                    iv.setImageResource(R.drawable.yourock);
                } else if (posicion==18) {
                    iv.setImageResource(R.drawable.song1);
                } else if (posicion==19) {
                    iv.setImageResource(R.drawable.primer);
                }else{
                    Toast.makeText(this,"No hay mas canciones", Toast.LENGTH_SHORT).show();
                }
            } //metodo para la cancion anterior
    }
    public void Anterior (View view){
        if (posicion >=1){//Abrimos condicional
            if (vectormp[posicion].isPlaying()){//Verifica si esta sonando o reproduciendo
                vectormp[posicion].stop();//Detiene la canción
                //Volvemos a indicar las canciones y sus posiciones
                vectormp[0] = MediaPlayer.create(this, R.raw.aloneagain);
                vectormp[1] = MediaPlayer.create(this, R.raw.aprovechate);
                vectormp[2] = MediaPlayer.create(this, R.raw.song1);
                vectormp[3] = MediaPlayer.create(this, R.raw.boysdontcry);
                vectormp[4] = MediaPlayer.create(this, R.raw.comeas);
                vectormp[5] = MediaPlayer.create(this, R.raw.ataque);
                vectormp[6] = MediaPlayer.create(this, R.raw.killer);
                vectormp[7] = MediaPlayer.create(this, R.raw.le);
                vectormp[8] = MediaPlayer.create(this, R.raw.let);
                vectormp[9] = MediaPlayer.create(this, R.raw.lobo);
                vectormp[10] = MediaPlayer.create(this, R.raw.on);
                vectormp[11] = MediaPlayer.create(this, R.raw.pied);
                vectormp[12] = MediaPlayer.create(this, R.raw.something);
                vectormp[13] = MediaPlayer.create(this, R.raw.tequiero);
                vectormp[14] = MediaPlayer.create(this, R.raw.ven);
                vectormp[15] = MediaPlayer.create(this, R.raw.song1);
                vectormp[16] = MediaPlayer.create(this, R.raw.what);
                vectormp[17] = MediaPlayer.create(this, R.raw.yourock);
                vectormp[18] = MediaPlayer.create(this, R.raw.song1);
                vectormp[19] = MediaPlayer.create(this, R.raw.primer);
                posicion--;
                //INDICAMOS NUEVAMENTE EL CAMBIO DE PORTADA
                if (posicion==0){
                    iv.setImageResource(R.drawable.aloneagain);
                } else if (posicion==1) {
                    iv.setImageResource(R.drawable.aprovechate);
                } else if (posicion==2) {
                    iv.setImageResource(R.drawable.song1);
                } else if (posicion==3) {
                    iv.setImageResource(R.drawable.boysdontcry);
                } else if (posicion==4) {
                    iv.setImageResource(R.drawable.comeas);
                } else if (posicion==5) {
                    iv.setImageResource(R.drawable.ataque);
                } else if (posicion==6) {
                    iv.setImageResource(R.drawable.killer);
                } else if (posicion==7) {
                    iv.setImageResource(R.drawable.le);
                } else if (posicion==8) {
                    iv.setImageResource(R.drawable.let);
                } else if (posicion==9) {
                    iv.setImageResource(R.drawable.lobo);
                } else if (posicion==10) {
                    iv.setImageResource(R.drawable.on);
                } else if (posicion==11) {
                    iv.setImageResource(R.drawable.pied);
                } else if (posicion==12) {
                    iv.setImageResource(R.drawable.something);
                } else if (posicion==13) {
                    iv.setImageResource(R.drawable.tequiero);
                } else if (posicion==14) {
                    iv.setImageResource(R.drawable.ven);
                } else if (posicion==15) {
                    iv.setImageResource(R.drawable.view);
                } else if (posicion==16) {
                    iv.setImageResource(R.drawable.what);
                } else if (posicion==17) {
                    iv.setImageResource(R.drawable.yourock);
                } else if (posicion==18) {
                    iv.setImageResource(R.drawable.song1);
                } else if (posicion==19) {
                    iv.setImageResource(R.drawable.primer);
                }
                vectormp[posicion].start();//Ya que ha recorrido el vector va a reproducir la canción anterior
            }else{
                posicion--;
                if (posicion==0){
                    iv.setImageResource(R.drawable.aloneagain);
                } else if (posicion==1) {
                    iv.setImageResource(R.drawable.aprovechate);
                } else if (posicion==2) {
                    iv.setImageResource(R.drawable.song1);
                } else if (posicion==3) {
                    iv.setImageResource(R.drawable.boysdontcry);
                } else if (posicion==4) {
                    iv.setImageResource(R.drawable.comeas);
                } else if (posicion==5) {
                    iv.setImageResource(R.drawable.ataque);
                } else if (posicion==6) {
                    iv.setImageResource(R.drawable.killer);
                } else if (posicion==7) {
                    iv.setImageResource(R.drawable.le);
                } else if (posicion==8) {
                    iv.setImageResource(R.drawable.let);
                } else if (posicion==9) {
                    iv.setImageResource(R.drawable.lobo);
                } else if (posicion==10) {
                    iv.setImageResource(R.drawable.on);
                } else if (posicion==11) {
                    iv.setImageResource(R.drawable.pied);
                } else if (posicion==12) {
                    iv.setImageResource(R.drawable.something);
                } else if (posicion==13) {
                    iv.setImageResource(R.drawable.tequiero);
                } else if (posicion==14) {
                    iv.setImageResource(R.drawable.ven);
                } else if (posicion==15) {
                    iv.setImageResource(R.drawable.view);
                } else if (posicion==16) {
                    iv.setImageResource(R.drawable.what);
                } else if (posicion==17) {
                    iv.setImageResource(R.drawable.yourock);
                } else if (posicion==18) {
                    iv.setImageResource(R.drawable.song1);
                } else if (posicion==19) {
                    iv.setImageResource(R.drawable.primer);
                }
            }
        }else{
            Toast.makeText(this, "NO hay mas canciones", Toast.LENGTH_SHORT).show();//Mandamos un mensaje de que ya no hay mas canciones
        }
    }

}