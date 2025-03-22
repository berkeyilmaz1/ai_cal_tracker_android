package com.duzceders.aicaltracker.camera;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.duzceders.aicaltracker.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CameraActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int REQUEST_IMAGE_PICK = 2;
    private static final int REQUEST_PERMISSION_CAMERA = 101;
    private static final int REQUEST_PERMISSION_STORAGE = 102;

    private ImageView imagePreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        imagePreview = findViewById(R.id.imagePreview);

        FloatingActionButton fabCamera = findViewById(R.id.fabCamera);
        fabCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ContextCompat.checkSelfPermission(CameraActivity.this, Manifest.permission.CAMERA)
                        != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(CameraActivity.this,
                            new String[]{Manifest.permission.CAMERA},
                            REQUEST_PERMISSION_CAMERA);
                } else {
                    dispatchTakePictureIntent();
                }
            }
        });

        FloatingActionButton fabGallery = findViewById(R.id.fabGallery);
        fabGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
                    // Android 13 ve üstü için
                    if (ContextCompat.checkSelfPermission(CameraActivity.this, Manifest.permission.READ_MEDIA_IMAGES)
                            != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(CameraActivity.this,
                                new String[]{Manifest.permission.READ_MEDIA_IMAGES},
                                REQUEST_PERMISSION_STORAGE);
                    } else {
                        dispatchPickImageIntent();
                    }
                } else {

                    if (ContextCompat.checkSelfPermission(CameraActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                            != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(CameraActivity.this,
                                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                                REQUEST_PERMISSION_STORAGE);
                    } else {
                        dispatchPickImageIntent();
                    }
                }
            }
        });

    }


    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } else {
            Toast.makeText(this, "Kamera bulunamadı!", Toast.LENGTH_SHORT).show();
        }
    }


    private void dispatchPickImageIntent() {
        Intent pickIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        if (pickIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(pickIntent, REQUEST_IMAGE_PICK);
        } else {
            Toast.makeText(this, "Galeri bulunamadı!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            if (requestCode == REQUEST_IMAGE_CAPTURE) {
                // Kamera ile çekilen resim (thumbnail)
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                imagePreview.setImageBitmap(imageBitmap);
                saveImage(imageBitmap);
            } else if (requestCode == REQUEST_IMAGE_PICK) {
                // Galeriden seçilen resmin URI'sini alıp Bitmap'e dönüştürme
                Uri selectedImageUri = data.getData();
                if (selectedImageUri != null) {
                    try {
                        Bitmap selectedBitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImageUri);
                        imagePreview.setImageBitmap(selectedBitmap);
                        saveImage(selectedBitmap);
                    } catch (IOException e) {
                        e.printStackTrace();
                        Toast.makeText(this, "Galeri resminin kaydedilmesinde hata oluştu!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_PERMISSION_CAMERA) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                dispatchTakePictureIntent();
            } else {
                Toast.makeText(this, "Kamera izni gerekli.", Toast.LENGTH_SHORT).show();
            }
        } else if (requestCode == REQUEST_PERMISSION_STORAGE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                dispatchPickImageIntent();
            } else {
                Toast.makeText(this, "Depolama izni gerekli.", Toast.LENGTH_SHORT).show();
            }
        }
    }


    private void saveImage(Bitmap finalBitmap) {
        File storageDir = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "saved_images");
        if (!storageDir.exists()) {
            storageDir.mkdirs();
        }
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        String imageFileName = "IMG_" + timeStamp + ".png";
        File imageFile = new File(storageDir, imageFileName);
        try {
            FileOutputStream out = new FileOutputStream(imageFile);
            finalBitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
            out.flush();
            out.close();
            Toast.makeText(this, "Resim kaydedildi:\n" + imageFile.getAbsolutePath(), Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Resim kaydedilirken hata oluştu!", Toast.LENGTH_SHORT).show();
        }
    }
}
