package com.dya.hanbanborina;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.makeramen.roundedimageview.RoundedImageView;

public class MainActivity extends AppCompatActivity {


    CardView cardViewKr,cardViewFk;
    TextView txtSarder,txtDrezha;
    RoundedImageView ivH;
    GridLayout gridLayout;
    ConstraintLayout conText ,constraintLayout0;
    int click ;
    ImageView close,about , aboutApp ,share , home , telegram;

    BottomSheetDialog sheetDialog ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtSarder = findViewById(R.id.txtSarder);
        txtDrezha = findViewById(R.id.txtDrezha);

        close = findViewById(R.id.close);
        telegram = findViewById(R.id.telegram);
        about = findViewById(R.id.about);
        aboutApp = findViewById(R.id.aboutApp);
        share = findViewById(R.id.share);
        ivH = findViewById(R.id.ivH);
        home = findViewById(R.id.Home);
        home.setColorFilter(ContextCompat.getColor(this, R.color.purple_700), android.graphics.PorterDuff.Mode.SRC_IN);

        gridLayout = findViewById(R.id.gridLayout);

        conText = findViewById(R.id.conText);

        constraintLayout0 = findViewById(R.id.constraintLayout0);

        telegram.setOnClickListener(view -> getTelegramInt(MainActivity.this));

        close.setOnClickListener(view -> {

            if (conText.getVisibility()== View.VISIBLE){
                conText.setVisibility(View.GONE);
                home.setColorFilter(ContextCompat.getColor(this, R.color.purple_700), android.graphics.PorterDuff.Mode.SRC_IN);
                about.setColorFilter(ContextCompat.getColor(this, R.color.color_nav_item), android.graphics.PorterDuff.Mode.SRC_IN);
                aboutApp.setColorFilter(ContextCompat.getColor(this, R.color.color_nav_item), android.graphics.PorterDuff.Mode.SRC_IN);
                gridLayout.setVisibility(View.VISIBLE);
                constraintLayout0.setVisibility(View.VISIBLE);
            }

        });
        share.setOnClickListener(view -> {
            String pa =getApplicationContext().getPackageName();
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            String shareSubject=" ئەپڵیکەیشنی هەنبانە بۆرینە  \n  لەڕێگەی ئەم لینکەوە دایبەزێنە\n";
            String shareBode =" ئەپڵیکەیشنی هەنبانە بۆرینە  \n  لەڕێگەی ئەم لینکەوە دایبەزێنە\n";
            String shareBode1 ="https://play.google.com/store/apps/details?id="+pa;
            shareIntent.putExtra(Intent.EXTRA_TEXT,shareBode+"\n"+shareBode1);
            shareIntent.putExtra(Intent.EXTRA_SUBJECT,shareSubject);
            startActivity(Intent.createChooser(shareIntent,"share using"));

        });


        home.setOnClickListener(view -> {

            if (conText.getVisibility()== View.VISIBLE){
                conText.setVisibility(View.GONE);
                home.setColorFilter(ContextCompat.getColor(this, R.color.purple_700), android.graphics.PorterDuff.Mode.SRC_IN);
                about.setColorFilter(ContextCompat.getColor(this, R.color.color_nav_item), android.graphics.PorterDuff.Mode.SRC_IN);
                aboutApp.setColorFilter(ContextCompat.getColor(this, R.color.color_nav_item), android.graphics.PorterDuff.Mode.SRC_IN);

                gridLayout.setVisibility(View.VISIBLE);
                constraintLayout0.setVisibility(View.VISIBLE);
            }

        });

        about.setOnClickListener(view -> {

            if (conText.getVisibility()!= View.VISIBLE){
                gridLayout.setVisibility(View.GONE);
                constraintLayout0.setVisibility(View.GONE);
                ivH.setImageResource(R.drawable.about);
                ivH.setVisibility(View.VISIBLE);
                telegram.setVisibility(View.VISIBLE);
                conText.setVisibility(View.VISIBLE);
                click=0;
                home.setColorFilter(ContextCompat.getColor(this, R.color.color_nav_item), android.graphics.PorterDuff.Mode.SRC_IN);
                about.setColorFilter(ContextCompat.getColor(this, R.color.purple_700), android.graphics.PorterDuff.Mode.SRC_IN);
                aboutApp.setColorFilter(ContextCompat.getColor(this, R.color.color_nav_item), android.graphics.PorterDuff.Mode.SRC_IN);

                txtSarder.setText(R.string.developer_about2);
                txtDrezha.setText(R.string.developer_about);

            }
            else if (click>0){
                gridLayout.setVisibility(View.GONE);
                constraintLayout0.setVisibility(View.GONE);
                ivH.setImageResource(R.drawable.about);
                ivH.setVisibility(View.VISIBLE);
                conText.setVisibility(View.VISIBLE);
                telegram.setVisibility(View.VISIBLE);
                home.setColorFilter(ContextCompat.getColor(this, R.color.color_nav_item), android.graphics.PorterDuff.Mode.SRC_IN);
                about.setColorFilter(ContextCompat.getColor(this, R.color.purple_700), android.graphics.PorterDuff.Mode.SRC_IN);
                aboutApp.setColorFilter(ContextCompat.getColor(this, R.color.color_nav_item), android.graphics.PorterDuff.Mode.SRC_IN);

                click=0;
                txtSarder.setText(R.string.developer_about2);
                txtDrezha.setText(R.string.developer_about);

            }

        });

        aboutApp.setOnClickListener(view -> {

            if (conText.getVisibility()!= View.VISIBLE){
                gridLayout.setVisibility(View.GONE);
                constraintLayout0.setVisibility(View.GONE);
                conText.setVisibility(View.VISIBLE);
                telegram.setVisibility(View.GONE);
                click=1;
                home.setColorFilter(ContextCompat.getColor(this, R.color.color_nav_item), android.graphics.PorterDuff.Mode.SRC_IN);
                about.setColorFilter(ContextCompat.getColor(this, R.color.color_nav_item), android.graphics.PorterDuff.Mode.SRC_IN);
                aboutApp.setColorFilter(ContextCompat.getColor(this, R.color.purple_700), android.graphics.PorterDuff.Mode.SRC_IN);

                txtSarder.setText(R.string.application_about2);
                txtDrezha.setText(R.string.application_about);
                ivH.setImageResource(R.drawable.hajar);
                ivH.setVisibility(View.VISIBLE);


            }
            else if (click ==0|| click <1){
                gridLayout.setVisibility(View.GONE);
                constraintLayout0.setVisibility(View.GONE);
                telegram.setVisibility(View.GONE);
                conText.setVisibility(View.VISIBLE);
                click=1;
                home.setColorFilter(ContextCompat.getColor(this, R.color.color_nav_item), android.graphics.PorterDuff.Mode.SRC_IN);
                about.setColorFilter(ContextCompat.getColor(this, R.color.color_nav_item), android.graphics.PorterDuff.Mode.SRC_IN);
                aboutApp.setColorFilter(ContextCompat.getColor(this, R.color.purple_700), android.graphics.PorterDuff.Mode.SRC_IN);

                txtSarder.setText(R.string.application_about2);
                txtDrezha.setText(R.string.application_about);
                ivH.setImageResource(R.drawable.hajar);
                ivH.setVisibility(View.VISIBLE);


            }

        });


        // dic
        cardViewKr = findViewById(R.id.cardViewKr);
        cardViewFk = findViewById(R.id.cardViewFk);
        cardViewKr.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,Detail.class);
            startActivity(intent);
            finish();

        });

        cardViewFk.setOnClickListener(view -> {

            Intent intent = new Intent(MainActivity.this,Detail2.class);
            startActivity(intent);
            finish();

        });
    }

    void getTelegramInt(Context context) {
        Intent intent;
        try {
            try { // check for telegram app
                context.getPackageManager().getPackageInfo("org.telegram.messenger", 0);
            } catch (PackageManager.NameNotFoundException e) {
                // check for telegram X app
                context.getPackageManager().getPackageInfo("org.thunderdog.challegram", 0);
            }
            // set app Uri
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("tg://resolve?domain={wallacoding}"));
            startActivity(intent);
        } catch (PackageManager.NameNotFoundException e) {
            // set browser URI
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.telegram.me/wallacoding"));
            startActivity(intent);
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public void onBackPressed() {

        Button btnYes,btnNo;


        sheetDialog = new BottomSheetDialog(MainActivity.this,R.style.BottomSheetStyle);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        View vi = LayoutInflater.from(MainActivity.this).inflate(R.layout.bottomshet_dialog,
                findViewById(R.id.sheet));

        btnYes =vi.findViewById(R.id.btnYes);
        btnNo =vi.findViewById(R.id.btnNo);

        btnYes.setOnClickListener(v -> System.exit(0));
        btnNo.setOnClickListener(view -> sheetDialog.cancel());

        sheetDialog.setContentView(vi);

        sheetDialog.show();


    }
}