package vtc.room.a101.homeworkdayone;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageActivity extends AppCompatActivity implements View.OnClickListener {

    private Button firstButton;
    private Button secondButton;
    private Button endButton;
    private ImageView image;
    private String URL = "http://khabarsoutheastasia.com/wp-content/uploads/2018/06/beautiful-hd-wallpapers-for-desktop-hd-wallpapers-wallpapers13-regarding-150-beautiful-buetifull-wallpapers-image-2018.jpg";
    public static final int RESULT_GALLERY = 0;
    private Uri imageUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        firstButton = (Button) findViewById(R.id.firstImageButton);
        secondButton = (Button) findViewById(R.id.secondImageButton);
        endButton = (Button) findViewById(R.id.endImageButton);
        image = (ImageView) findViewById(R.id.image);
        firstButton.setOnClickListener(this);
        secondButton.setOnClickListener(this);
        endButton.setOnClickListener(this);

    }

    //http://khabarsoutheastasia.com/wp-content/uploads/2018/06/beautiful-hd-wallpapers-for-desktop-hd-wallpapers-wallpapers13-regarding-150-beautiful-buetifull-wallpapers-image-2018.jpg


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.firstImageButton:
                image.setImageResource(R.drawable.giphy);
                break;
            case R.id.secondImageButton:
                Picasso.with(ImageActivity.this)
                        .load(URL).into(image);
                break;
            case R.id.endImageButton:
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(intent, 69);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            if (requestCode == 69 && data !=null){
                imageUri = data.getData();
                image.setImageURI(imageUri);
            }
        }
    }
}

