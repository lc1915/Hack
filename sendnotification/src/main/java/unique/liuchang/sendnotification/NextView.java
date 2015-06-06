package unique.liuchang.sendnotification;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NextView extends Activity {

    private Button numButton;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_view);

        editText = (EditText)findViewById(R.id.editText);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                editText.setText(" ");
            }
        }, 5000);

        numButton = (Button)findViewById(R.id.button_num);
        numButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        //        new Handler().postDelayed(new Runnable() {
        //            @Override
        //            public void run() {
                        Toast.makeText(getApplicationContext(), "成功呼出!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"
                                + "15527597072"));
                        NextView.this.startActivity(intent);
        //            }
        //        }, 1000);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_next_view, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
