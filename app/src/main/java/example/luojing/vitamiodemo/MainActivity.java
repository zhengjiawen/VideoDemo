package example.luojing.vitamiodemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button searchBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
//        new Thread(){
//            @Override
//            public void run() {
//                Vitamio.initialize(getApplicationContext());
//            }
//        }.start();
    }
/*    public void next(View v){
        Intent intent = new Intent(this,VideoActivity.class);
        startActivity(intent);
    }*/

    private void initView(){
        searchBtn = (Button)findViewById(R.id.searchBtn);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("video/*");//这里是设置打开文件的类型，也可以换成图片

                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK && requestCode == 1) {
            Uri uri = data.getData();
            String path = uri.getPath();
            Log.d("VideoPath", "onActivityResult: "+path);
            Intent intent = new Intent(this,VideoActivity.class);
            intent.putExtra("path",path);
            startActivity(intent);
        }
    }
}
