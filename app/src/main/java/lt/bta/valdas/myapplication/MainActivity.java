package lt.bta.valdas.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Context context = getApplicationContext();
        GridLayout gridLayout = findViewById(R.id.table);

        final TextView textView = findViewById(R.id.buttonLabelText);

        class BtNumber {
            int row;
            int col;

            BtNumber(int row, int col) {
                this.row = row;
                this.col = col;
            }
        }

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BtNumber btNumber = (BtNumber) v.getTag();
                textView.setText("row: " + btNumber.row + ", col:" + btNumber.col);
                v.setBackgroundColor(Color.RED);
            }
        };

        for (int row = 0; row < 10; ++row) {
            for (int col = 0; col < 10; ++col) {
                Button button = new Button(context);
                button.setBackgroundColor((row + col) % 2 == 0 ? Color.DKGRAY : Color.LTGRAY);

                GridLayout.LayoutParams params = new GridLayout.LayoutParams();
                params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL,1f);
                params.width = 0;
                params.rowSpec = GridLayout.spec(GridLayout.UNDEFINED, GridLayout.FILL,1f);
                params.height = 0;
                button.setLayoutParams(params);
                gridLayout.addView(button);

                button.setTag(new BtNumber(row, col));
                button.setOnClickListener(listener);
            }
        }
    }
}
