package unique.liuchang.sendnotification;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NotificationVIew extends Activity {

    private Button newButton;
    private EditText newTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);

        newTextView = (EditText)findViewById(R.id.new_textview);

        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                newTextView.setText("距您5公里,可抢单");
            }
        }, 5000);*/

        /*new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(NotificationVIew.this, NextView.class);
                startActivity(intent);
                //MainActivity.this.finish();
            }
        }, 5000);*/

        newButton = (Button) findViewById(R.id.new_button1);
        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = newButton.getResources().getResourceName(newButton.getId());
                Toast.makeText(getApplicationContext(), "抢单成功！", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(NotificationVIew.this, NextView.class);
                startActivity(intent);
                NotificationVIew.this.finish();
            }
        });

        // ---look up the notification manager service---
        //NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        // ---cancel the notification that we started---
        //nm.cancel(getIntent().getExtras().getInt("notificationID"));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_notification_view, menu);
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
