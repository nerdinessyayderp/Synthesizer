package com.example.per6.synthesizer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.NumberPicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button aButton, asButton, bButton, cButton, csButton, dButton, dsButton, eButton, fButton, fsButton, gButton, gsButton, majorDDorianButton, repeatButton, twinkleButton, birthdayButton;
    private MediaPlayer aNote, asNote, bNote, cNote, csNote, dNote, dsNote, eNote, fNote, fsNote, gNote, gsNote, highaNote, highbNote, highasNote, highcNote, highcsNote, highdNote, highdsNote, higheNote, highfNote, highfsNote, highgNote, highgsNote;
    private final int WHOLE_NOTE = 1000;
    private NumberPicker notePicker, timesPlayedPicker;
    private CheckBox twinklender;
    private MediaPlayer[] noteArr = new MediaPlayer[24];
    private MediaPlayer[] majorDDorian = new MediaPlayer[8];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wireWidgets();
        setListeners();
        createMediaPlayers();
        for(int i = 0; i < 23; i++){
            noteArr[i] = indexNote(i+1);
        }
        majorDDorian[0] = eNote;
        majorDDorian[1] = fsNote;
        majorDDorian[2] = gNote;
        majorDDorian[3] = highaNote;
        majorDDorian[4] = highbNote;
        majorDDorian[5] = highcsNote;
        majorDDorian[6] = highdNote;
        majorDDorian[7] = higheNote;
    }

    private void wireWidgets(){
        aButton = (Button) findViewById(R.id.button_a);
        asButton = (Button) findViewById(R.id.button_as);
        bButton = (Button) findViewById(R.id.button_b);
        cButton = (Button) findViewById(R.id.button_c);
        csButton = (Button) findViewById(R.id.button_cs);
        dButton = (Button) findViewById(R.id.button_d);
        dsButton = (Button) findViewById(R.id.button_ds);
        eButton = (Button) findViewById(R.id.button_e);
        fButton = (Button) findViewById(R.id.button_f);
        fsButton = (Button) findViewById(R.id.button_fs);
        gButton = (Button) findViewById(R.id.button_g);
        gsButton = (Button) findViewById(R.id.button_gs);
        majorDDorianButton = (Button) findViewById(R.id.button_major_d_dorian);
        notePicker = (NumberPicker) findViewById(R.id.note_picker);
        timesPlayedPicker = (NumberPicker) findViewById(R.id.times_played_picker);
        notePicker.setMinValue(1);
        notePicker.setMaxValue(12);
        timesPlayedPicker.setMinValue(1);
        timesPlayedPicker.setMaxValue(12);
        repeatButton = (Button) findViewById(R.id.button_repeater);
        twinkleButton = (Button) findViewById(R.id.twinkle_button);
        twinklender = (CheckBox) findViewById(R.id.twinkle_end);
        birthdayButton = (Button) findViewById(R.id.birthday_button);
    }

    private void setListeners(){
        aButton.setOnClickListener(this);
        asButton.setOnClickListener(this);
        bButton.setOnClickListener(this);
        cButton.setOnClickListener(this);
        csButton.setOnClickListener(this);
        dButton.setOnClickListener(this);
        dsButton.setOnClickListener(this);
        eButton.setOnClickListener(this);
        fButton.setOnClickListener(this);
        fsButton.setOnClickListener(this);
        gButton.setOnClickListener(this);
        gsButton.setOnClickListener(this);
        majorDDorianButton.setOnClickListener(this);
        repeatButton.setOnClickListener(this);
        twinkleButton.setOnClickListener(this);
        birthdayButton.setOnClickListener(this);
    }

    private MediaPlayer getaNote(){
        return aNote;
    }
    private MediaPlayer geteNote(){
        return eNote;
    }
    private MediaPlayer getfsNote(){
        return fsNote;
    }
    private MediaPlayer getdNote(){
        return dNote;
    }
    private MediaPlayer getcsNote(){
        return csNote;
    }
    private MediaPlayer getbNote(){
        return bNote;
    }
    private void createMediaPlayers(){
        aNote = MediaPlayer.create(this, R.raw.scalea);
        asNote = MediaPlayer.create(this, R.raw.scalebb);
        bNote = MediaPlayer.create(this, R.raw.scaleb);
        cNote = MediaPlayer.create(this, R.raw.scalec);
        csNote = MediaPlayer.create(this, R.raw.scalecs);
        dNote = MediaPlayer.create(this, R.raw.scaled);
        dsNote = MediaPlayer.create(this, R.raw.scaleds);
        eNote = MediaPlayer.create(this, R.raw.scalee);
        fNote = MediaPlayer.create(this, R.raw.scalef);
        fsNote = MediaPlayer.create(this, R.raw.scalefs);
        gNote = MediaPlayer.create(this, R.raw.scaleg);
        gsNote = MediaPlayer.create(this, R.raw.scalegs);
        highaNote = MediaPlayer.create(this, R.raw.scalehigha);
        highbNote = MediaPlayer.create(this, R.raw.scalehighb);
        highasNote = MediaPlayer.create(this, R.raw.scalehighb);
        highcNote = MediaPlayer.create(this, R.raw.scalehighc);
        highcsNote = MediaPlayer.create(this, R.raw.scalehighcs);
        highdNote = MediaPlayer.create(this, R.raw.scalehighd);
        highdsNote = MediaPlayer.create(this, R.raw.scalehighds);
        higheNote = MediaPlayer.create(this, R.raw.scalehighe);
        highfNote = MediaPlayer.create(this, R.raw.scalehighf);
        highfsNote = MediaPlayer.create(this, R.raw.scalehighfs);
        highgNote = MediaPlayer.create(this, R.raw.scalehighg);
        highgsNote = MediaPlayer.create(this, R.raw.scalehighgs);
    }
    //comment
    private void delayNote(int delay) throws InterruptedException {
        try{
            Thread.sleep(delay);
        } catch(InterruptedException e){
            Log.e("SynthesizerActivity", "Audio playback interrupted");
        }
    }

    public void play(MediaPlayer m, int delay) throws InterruptedException {
        m.seekTo(0);
        m.start();
        delayNote(delay);
        m.pause();
    }

    //returns a note given an index. Basically an array, except not an array.
    public MediaPlayer indexNote(int i){
        if(i == 1){
            return aNote;
        }
        else if(i == 2){
            return asNote;
        }
        else if(i == 3){
            return bNote;
        }
        else if(i == 4){
            return cNote;
        }
        else if(i == 5){
            return csNote;
        }
        else if(i == 6){
            return dNote;
        }
        else if(i == 7){
            return dsNote;
        }
        else if(i == 8){
            return eNote;
        }
        else if(i == 9){
            return fNote;
        }
        else if(i ==10){
            return fsNote;
        }
        else if(i == 11){
            return gNote;
        }
        else if(i == 12){
            return gsNote;
        }
        else if(i == 13){
            return highaNote;
        }
        else if(i == 14){
            return highasNote;
        }
        else if(i == 15){
            return highbNote;
        }
        else if(i == 16){
            return highcNote;
        }
        else if(i == 17){
            return highcsNote;
        }
        else if(i == 18){
            return highdNote;
        }
        else if(i == 19){
            return highdsNote;
        }
        else if(i == 20){
            return higheNote;
        }
        else if(i == 21){
            return highfNote;
        }
        else if(i == 22){
            return highfsNote;
        }
        else if(i == 23){
            return highgNote;
        }
        else{
            return highgsNote;
        }
    }

    @Override
    public void onClick(View view){
        switch(view.getId()) {
            case R.id.button_a:
                try {
                    play(aNote, WHOLE_NOTE/2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.button_as:
                try {
                    play(asNote, WHOLE_NOTE/2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.button_b:
                try {
                play(bNote, WHOLE_NOTE/2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                break;
            case R.id.button_c:
                try {
                    play(cNote, WHOLE_NOTE/2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.button_cs:
                try {
                    play(csNote, WHOLE_NOTE/2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.button_d:
                try {
                    play(dNote, WHOLE_NOTE/2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.button_ds:
                try {
                    play(dsNote, WHOLE_NOTE/2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.button_e:
                try {
                    play(eNote, WHOLE_NOTE/2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.button_f:
                try {
                    play(fNote, WHOLE_NOTE/2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.button_fs:
                try {
                    play(fsNote, WHOLE_NOTE/2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.button_g:
                try {
                    play(gNote, WHOLE_NOTE/2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.button_gs:
                try {
                    play(gsNote, WHOLE_NOTE/2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.button_major_d_dorian:
                Log.e("SynthesizerACtivity", "Challenge 0 Buton clicked");
                try{
                    for(int i = 0; i < 8; i ++){
                        play(majorDDorian[i], WHOLE_NOTE/2);
                    }
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
                break;
            case R.id.button_repeater:
                MediaPlayer n = noteArr[notePicker.getValue()];
                for(int j = 0; j < timesPlayedPicker.getValue(); j++){
                    try {
                        play(n, WHOLE_NOTE/2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case R.id.twinkle_button:
                try {
                    MediaPlayer[] twinkle = { aNote, aNote, eNote, eNote, fsNote, fsNote, eNote, dNote, dNote, csNote, csNote, bNote, bNote, aNote};
//                    play(getaNote(), WHOLE_NOTE/2);
//                    play(getaNote(), WHOLE_NOTE/2);
//                    play(geteNote(), WHOLE_NOTE/2);
//                    play(geteNote(), WHOLE_NOTE/2);
//                    play(getfsNote(), WHOLE_NOTE/2);
//                    play(getfsNote(), WHOLE_NOTE/2);
//                    play(geteNote(), WHOLE_NOTE/2);
//                    play(getdNote(), WHOLE_NOTE/2);
//                    play(getdNote(), WHOLE_NOTE/2);
//                    play(getcsNote(), WHOLE_NOTE/2);
//                    play(getcsNote(), WHOLE_NOTE/2);
//                    play(getbNote(), WHOLE_NOTE/2);
//                    play(getbNote(), WHOLE_NOTE/2);
//                    play(getaNote(), WHOLE_NOTE/2);
                    MediaPlayer[] twinklend = { eNote, eNote, dNote, dNote, csNote, csNote, bNote};
                    for(int i = 0; i < twinkle.length; i++){
                        play(twinkle[i], WHOLE_NOTE/2);
                    }
                    if(twinklender.isChecked()){
                        for(int j = 0; j < timesPlayedPicker.getValue(); j++){
                            for (int k = 0; k < twinklend.length; k++) {
                               play(twinklend[k], WHOLE_NOTE / 2);
                            }
                        }
                     }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            //my favorite song is the XC birthday song. Everybody sings in a different key, starts at a different
            //time, in a different tempo, and at a different volume. It's basically a random cacophony. Enjoy.
            case R.id.birthday_button:
                for(int i = 0;i < 500; i++){
                    int r1 = (int) (Math.random()*23);
                    int r2 = (int) (Math.random()*100+1);
                    try {
                        play(noteArr[r1], r2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            default:
        }
    }
}
