package com.example.android.glyph;

import android.app.VoiceInteractor;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MyVoiceActivity extends AppCompatActivity {
    @RequiresApi(api = Build.VERSION_CODES.M)
    class Confirm extends VoiceInteractor.ConfirmationRequest {
        @RequiresApi(api = Build.VERSION_CODES.M)
        public Confirm(String ttsPrompt, String visualPrompt) {

            VoiceInteractor.Prompt prompt = new VoiceInteractor.Prompt(

                    new String[]{ttsPrompt}, visualPrompt);
            super(prompt, null);
        }

        }


        public void onConfirmationResult(
                boolean confirmed, Bundle null) {
            if (confirmed) {
                doAction();
            }
            finish();
        }

        private void doAction() {
        }




    @Override
    public void onResume() {
        if (isVoiceInteraction()) {
            String ttsPrompt = getConfirmationTts();
            String visualPrompt = getConfirmationDisplayText();
            getVoiceInteractor().sendRequest(new Confirm(ttsPrompt, visualPrompt));
        } else {
            finish();
        }
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_voice);

    }

}








