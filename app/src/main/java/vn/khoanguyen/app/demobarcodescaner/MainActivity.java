package vn.khoanguyen.app.demobarcodescaner;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler{
    private ZXingScannerView mScannerView;
    Button btnScanner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnScanner= (Button) findViewById(R.id.btnScanner);
        btnScanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QrScanner(view);
            }
        });
    }

    public void QrScanner(View view){
            mScannerView= new ZXingScannerView(this);
            setContentView(mScannerView);
            mScannerView.setResultHandler(this);
            mScannerView.startCamera();
    }
    @Override
    public void handleResult(Result result) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Scan Result");
        String textString = result.getText();
        builder.setMessage(result.getText());
        /*String[] words=textString.split("\\s");
        for(String w:words){
            Toast.makeText(this,w, Toast.LENGTH_SHORT).show();
        }
        */
        AlertDialog alert1 = builder.create();
        alert1.show();


    }
}
