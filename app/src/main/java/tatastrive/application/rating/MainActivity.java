package tatastrive.application.rating;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
RatingBar bar;
TextView textView;
EditText editText;
Button button;
ProgressBar progressBar;
float ss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        bar=findViewById( R.id.ratingBar );
       editText=findViewById( R.id.edit );
        button=findViewById( R.id.button );
        textView=findViewById( R.id.text);
        progressBar=findViewById( R.id.progressBar2);
        bar.setOnRatingBarChangeListener( new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
              // Toast.makeText( MainActivity.this, "Thank you for rating"+v, Toast.LENGTH_SHORT ).show();
               ss=v;
            }
        } );
        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE );
                new Handler().postDelayed( new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText( MainActivity.this, "hello", Toast.LENGTH_SHORT ).show();
                        progressBar.setVisibility( View.INVISIBLE );
                    }

                } ,5000);

                //s = editText.getText().toString().trim();
               // Toast.makeText( MainActivity.this, "thanks for giving feedback to us..."+s+"your rating is "+ss, Toast.LENGTH_SHORT ).show();
               // Toast.makeText( MainActivity.this, "thanks for giving feedback to us..."+ss, Toast.LENGTH_SHORT ).show();
   showmsg("thanks for giving feedback to us... "+editText.getText().toString(), "your rating is "+ss);

            }

            private void showmsg(String s, String s1) {

                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                builder.setTitle(textView.getText().toString());
                builder.setMessage(s+s1);
                builder.show();

            }
        } );

    }
}
