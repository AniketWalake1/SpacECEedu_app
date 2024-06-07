package com.spacECE.spaceceedu.Authentication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.*;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
<<<<<<< HEAD
import android.widget.TextView;
=======
>>>>>>> origin/khushi
import android.widget.Toast;

import com.spacECE.spaceceedu.R;

import com.spacECE.spaceceedu.Utils.UsefulFunctions;
import okhttp3.*;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.FileDescriptor;
import java.io.IOException;
import java.text.ParseException;

public class RegistrationFinal extends AppCompatActivity {

    private Button b_register;
    private ImageView iv_profile_pic;
<<<<<<< HEAD
    private EditText ev_email, ev_phoneNo, ev_password, ev_re_password, ev_name;
    private boolean imageUpload = false;
    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSION_CODE = 1001;
    private Uri picData = Uri.parse(String.valueOf(R.drawable.default_profilepic));
    private TextView uploadImageError;
    Toolbar toolbar;
    UserLocalStore userLocalStore;

    String TYPE = "customer", LANGUAGE, ADDRESS, FEE, QUALIFICATION, START_TIME, END_TIME;
=======
    private EditText ev_email,ev_phoneNo,ev_password, ev_re_password,ev_name;
    private boolean imageUpload=false;
    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSION_CODE = 1001;
    private Uri picData= Uri.parse(String.valueOf(R.drawable.default_profilepic));
    Toolbar toolbar;
    UserLocalStore userLocalStore;

    String TYPE = "customer", LANGUAGE, ADDRESS, FEE,
            QUALIFICATION, START_TIME, END_TIME;
>>>>>>> origin/khushi

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        userLocalStore = new UserLocalStore(getApplicationContext());
<<<<<<< HEAD

        b_register = findViewById(R.id.UserRegistration_Button_Signup);
        iv_profile_pic = findViewById(R.id.UserRegistration_ImageView_ProfilePic);

        ev_email = findViewById(R.id.UserRegistration_editTextText_Email);
        ev_password = findViewById(R.id.UserRegistration_editTextText_Password);
        ev_re_password = findViewById(R.id.UserRegistration_editTextText_Re_Password);
        ev_name = findViewById(R.id.UserRegistration_editTextText_Name);
        ev_phoneNo = findViewById(R.id.UserRegistration_editTextText_PhoneNumber);

        uploadImageError = findViewById(R.id.uploadImageError);

        Intent intent = getIntent();
=======
        Log.e( "5 auth ","----------------------------------------------");


        b_register= findViewById(R.id.UserRegistration_Button_Signup);
        iv_profile_pic= findViewById(R.id.UserRegistration_ImageView_ProfilePic);

        ev_email=findViewById(R.id.UserRegistration_editTextText_Email);
        ev_password=findViewById(R.id.UserRegistration_editTextText_Password);
        ev_re_password =findViewById(R.id.UserRegistration_editTextText_Re_Password);
        ev_name=findViewById(R.id.UserRegistration_editTextText_Name);
        ev_phoneNo=findViewById(R.id.UserRegistration_editTextText_PhoneNumber);

        //Intent and shit

        Intent intent = getIntent();

>>>>>>> origin/khushi
        TYPE = intent.getStringExtra("Type");
        LANGUAGE = intent.getStringExtra("Language");
        ADDRESS = intent.getStringExtra("Address");
        FEE = intent.getStringExtra("Fee");
        QUALIFICATION = intent.getStringExtra("Qualification");
        START_TIME = intent.getStringExtra("StartTime");
        END_TIME = intent.getStringExtra("EndTime");

<<<<<<< HEAD
        Log.d("TAG", "onCreate: " + TYPE + " " + LANGUAGE + " " + ADDRESS + " " + FEE + " " + QUALIFICATION + " " + START_TIME + " " + END_TIME);

        // Set onClickListener for profile picture selection
        iv_profile_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check runtime permission for reading external storage
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
                        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
                        // Request permission
                        requestPermissions(permissions, PERMISSION_CODE);
                    } else {
                        // Permission already granted
                        pickImageFromGallery();
                    }
                } else {
                    // System OS is less than marshmallow
                    pickImageFromGallery();
                }
            }
        });

        // Set onClickListener for registration button
        b_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateData()) {
                    try {
                        if (validTime(START_TIME, END_TIME)) {
                            sendUserRegistration(ev_name.getText().toString(), ev_email.getText().toString(),
=======
        Log.d("TAG", "onCreate: "+TYPE+" "+LANGUAGE+" "+ADDRESS+" "+FEE+" "+
                QUALIFICATION+" "+START_TIME+" "+END_TIME);



        //OnClickListener:
        iv_profile_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check runtime permission
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                    if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                            == PackageManager.PERMISSION_DENIED){
                        //permission not granted, request it.
                        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE};
                        //show popup for runtime permission
                        requestPermissions(permissions, PERMISSION_CODE);
                    }
                    else {
                        //permission already granted
                        pickImageFromGallery();
                    }
                }
                else {
                    //system os is less than marshmallow
                    pickImageFromGallery();
                }

            }
        });

        b_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (validateData()) {
                    try {
                        if(validTime(START_TIME, END_TIME)) {
                            sendUserRegistration( ev_name.getText().toString(), ev_email.getText().toString(),
>>>>>>> origin/khushi
                                    ev_password.getText().toString(), ev_phoneNo.getText().toString(), picData);
                        } else {
                            Toast.makeText(getApplicationContext(), "End Time must be greater than Start Time", Toast.LENGTH_LONG).show();
                        }
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Check Details", Toast.LENGTH_LONG).show();
                }
<<<<<<< HEAD
            }
        });
    }

    // Method to pick an image from the gallery
    private void pickImageFromGallery() {
=======

            }
        });




    }

    private void pickImageFromGallery() {
        //intent to pick image
>>>>>>> origin/khushi
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_PICK_CODE);
    }

<<<<<<< HEAD
    // Handle the result of permission request
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission was granted
                pickImageFromGallery();
            } else {
                // Permission was denied
                Toast.makeText(this, "Permission denied...!", Toast.LENGTH_SHORT).show();
=======
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PERMISSION_CODE: {
                if (grantResults.length > 0 && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED) {
                    //permission was granted
                    pickImageFromGallery();
                } else {
                    //permission was denied
                    Toast.makeText(this, "Permission denied...!", Toast.LENGTH_SHORT).show();
                }
>>>>>>> origin/khushi
            }
        }
    }

<<<<<<< HEAD
    // Handle the result of image picking
=======
>>>>>>> origin/khushi
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == IMAGE_PICK_CODE) {
<<<<<<< HEAD
            // Set image to image view
            b_register.setText("Register");
            picData = data.getData();
=======
            //set image to image view
            b_register.setText("Register");
            picData= data.getData();
>>>>>>> origin/khushi
            iv_profile_pic.setImageURI(data.getData());
        }
    }

<<<<<<< HEAD
    // Validate if the end time is greater than the start time
    private boolean validTime(String fromTime, String endTime) throws ParseException {
        if (fromTime == null && endTime == null) {
            return true;
        } else {
            return UsefulFunctions.DateFunc.StringToTime(fromTime + ":00").before(UsefulFunctions.DateFunc.StringToTime(endTime + ":00"));
        }
    }

    // Get Bitmap from Uri
    private Bitmap getBitmapFromUri(Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptor = getContentResolver().openFileDescriptor(uri, "r");
=======
    private boolean validTime(String fromTime, String endTime) throws ParseException {
        if(fromTime == null & endTime == null) {
            return true;
        } else {
            return UsefulFunctions.DateFunc.StringToTime(fromTime+":00").before(UsefulFunctions.DateFunc.StringToTime(endTime+":00"));
        }
    }

    private Bitmap getBitmapFromUri(Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptor =
                getContentResolver().openFileDescriptor(uri, "r");
>>>>>>> origin/khushi
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        parcelFileDescriptor.close();
        return image;
    }

<<<<<<< HEAD
    // Encode Bitmap image to byte array
    public static byte[] encodeBase64(Bitmap image) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 90, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    // Send user registration data to the server
    private void sendUserRegistration(String name, String email, String password, String phone, Uri image) {
=======
    public static byte[] encodeBase64(Bitmap image) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        image.compress(Bitmap.CompressFormat.JPEG, 90, byteArrayOutputStream);
        byte[] encoded = byteArrayOutputStream.toByteArray();
        return encoded;
    }

    private void sendUserRegistration(String name, String email, String password, String phone, Uri image){

>>>>>>> origin/khushi
        String register = "http://43.205.45.96/spacece_auth/register_action.php";

        new Thread(new Runnable() {

            JSONObject jsonObject;
            Bitmap selectedImage;
            byte[] encodedImage = {5};

<<<<<<< HEAD
            @Override
            public void run() {
=======

            @Override
            public void run() {

>>>>>>> origin/khushi
                try {
                    selectedImage = getBitmapFromUri(image);
                    encodedImage = encodeBase64(selectedImage);
                } catch (IOException e) {
                    e.printStackTrace();
                }

<<<<<<< HEAD
                if (encodedImage.length == 1) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (!imageUpload) {
                                Toast.makeText(getApplicationContext(), "Upload Image", Toast.LENGTH_SHORT).show();
                                uploadImageError.setVisibility(View.VISIBLE);
                                b_register.setText("Continue");
=======
                if(encodedImage.length == 1){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if(!imageUpload){
                                Toast.makeText(getApplicationContext(), "Upload Image", Toast.LENGTH_SHORT).show();
                                b_register.setText("Continue without Image!");
>>>>>>> origin/khushi
                                imageUpload = true;
                            }
                        }
                    });
<<<<<<< HEAD
                    if (!imageUpload) {
                        return;
                    }
                }

                OkHttpClient client = new OkHttpClient();
                RequestBody formBody;

                if (TYPE != null && LANGUAGE != null && ADDRESS != null && FEE != null && QUALIFICATION != null && START_TIME != null && END_TIME != null) {
                    formBody = new MultipartBody.Builder()
=======
                    if(!imageUpload){
                        return;
                    }

                }

                System.out.println("hello");

                OkHttpClient client = new OkHttpClient();
                RequestBody fromBody;

                if(TYPE != null & LANGUAGE != null & ADDRESS != null & FEE != null
                        & QUALIFICATION != null & START_TIME != null & END_TIME != null) {
                    fromBody = new MultipartBody.Builder()
>>>>>>> origin/khushi
                            .setType(MultipartBody.FORM)
                            .addFormDataPart("name", name)
                            .addFormDataPart("email", email)
                            .addFormDataPart("password", password)
                            .addFormDataPart("phone", phone)
<<<<<<< HEAD
                            .addFormDataPart("image", name + ".jpg", RequestBody.create(MediaType.parse("image/*jpg"), encodedImage))
=======
                            .addFormDataPart("image", name+".jpg",
                                    RequestBody.create(MediaType.parse("image/*jpg"), encodedImage))
>>>>>>> origin/khushi
                            .addFormDataPart("type", "consultant")
                            .addFormDataPart("c_categories", TYPE)
                            .addFormDataPart("c_office", ADDRESS)
                            .addFormDataPart("c_from_time", START_TIME)
                            .addFormDataPart("c_to_time", END_TIME)
                            .addFormDataPart("c_language", LANGUAGE)
                            .addFormDataPart("c_fee", FEE)
                            .addFormDataPart("c_available_from", "Monday")
                            .addFormDataPart("c_available_to", "Tuesday")
                            .addFormDataPart("c_qualification", QUALIFICATION)
                            .build();
                } else {
<<<<<<< HEAD
                    formBody = new MultipartBody.Builder()
=======
                    fromBody = new MultipartBody.Builder()
>>>>>>> origin/khushi
                            .setType(MultipartBody.FORM)
                            .addFormDataPart("name", name)
                            .addFormDataPart("email", email)
                            .addFormDataPart("password", password)
                            .addFormDataPart("phone", phone)
<<<<<<< HEAD
                            .addFormDataPart("image", name + ".jpg", RequestBody.create(MediaType.parse("image/*jpg"), encodedImage))
=======
                            .addFormDataPart("image", name+".jpg",
                                    RequestBody.create(MediaType.parse("image/*jpg"), encodedImage))
>>>>>>> origin/khushi
                            .addFormDataPart("type", "customer")
                            .build();
                }

<<<<<<< HEAD
                Request request = new Request.Builder()
                        .url(register)
                        .post(formBody)
                        .build();
                Log.d("Registration URL", request.url().toString());

                Call call = client.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(@NotNull Call call, @NotNull IOException e) {
                        Log.e("Registration Error API", e.getMessage());
=======
                Log.e( "run: pwndsfcnek", name +".jpeg --link");
                Request request = new Request.Builder()
                        .url(register)
                        .post(fromBody)
                        .build();

                Call call = client.newCall(request);

                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(@NotNull Call call, @NotNull IOException e) {
                        System.out.println("Registration Error ApI " + e.getMessage());
>>>>>>> origin/khushi
                    }

                    @Override
                    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
<<<<<<< HEAD
                        try {
                            jsonObject = new JSONObject(response.body().string());
                            Log.d("TAG", "onResponse: " + jsonObject);
=======

                        try {
                            jsonObject = new JSONObject(response.body().string());
                            Log.d("TAG", "onResponse: "+jsonObject);
>>>>>>> origin/khushi
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
<<<<<<< HEAD
                                try {
                                    Log.d("TAG", "onResponse: " + jsonObject.getString("status"));
                                    if (jsonObject.getString("status").equals("error")) {
                                        if (jsonObject.getString("message").equals("Email already exists!")) {
                                            ev_email.setError("Email already exists!");
                                        } else {
                                            Toast.makeText(getApplicationContext(), "Please try after some time!", Toast.LENGTH_SHORT).show();
                                        }
                                    } else if (jsonObject.getString("status").equals("success")) {
                                        Toast.makeText(getApplicationContext(), "Welcome to SpacECE! Login to continue!", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                        startActivity(intent);
=======


                                try {
                                    Log.d("TAG", "onResponse: "+jsonObject.getString("status"));
                                    if(jsonObject.getString("status").equals("error")) {
                                        if(jsonObject.getString("message").equals("Email already exists!")) {
                                            ev_email.setError("Email already exist!");
                                        } else {
                                            Toast.makeText(getApplicationContext(), "Please try after some time!", Toast.LENGTH_SHORT).show();
                                        }
                                    } else if(jsonObject.getString("status").equals("success")) {

                                        Toast.makeText(getApplicationContext(), "Welcome to SpacECE Login to Continue!", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                        startActivity(intent);

>>>>>>> origin/khushi
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                });
            }
        }).start();
<<<<<<< HEAD
    }

    // Validate all input data
    private boolean validateData() {
        return validateName() && validatePhone() && validateEmail() && validatePass() && validateRepass();
    }

    // Validate email input
    private boolean validateEmail() {
        if (ev_email.getText().toString().isEmpty()) {
            ev_email.setError("Field cannot be empty");
            return false;
        } else if (!ev_email.getText().toString().contains("@")) {
=======

    }


    private boolean validateData() {
        validateName();
        validatePhone();
        validateEmail();
        validatePass();
        validateRepass();

        if(validateEmail() && validateName() && validatePass()
                && validateRepass() && validatePhone()) {
            return true;
        }
        return false;
    }

    private boolean validateEmail(){
        if(ev_email.getText().toString().isEmpty()){
            ev_email.setError("Field cannot be empty");
            return false;
        }
        else if(!(ev_email.getText().toString().contains("@"))){
>>>>>>> origin/khushi
            ev_email.setError("Invalid Email address");
            return false;
        }
        return true;
    }

<<<<<<< HEAD
    // Validate name input
    private boolean validateName() {
        if (ev_name.getText().toString().isEmpty()) {
            ev_name.setError("Field cannot be empty");
            return false;
        }
        return true;
    }

    // Validate phone input
    private boolean validatePhone() {
        if (ev_phoneNo.getText().toString().isEmpty()) {
            ev_phoneNo.setError("Field cannot be empty");
            return false;
        }
        return true;
    }

    // Validate password input
    private boolean validatePass() {
        if (ev_password.getText().toString().isEmpty()) {
=======
    private boolean validateName(){
        if(ev_name.getText().toString().isEmpty()){
            ev_name.setError("Field cannot be empty");
            return false;
        }else{
            return true;
        }
    }

    private boolean validatePhone(){
        if(ev_phoneNo.getText().toString().isEmpty()){
            ev_phoneNo.setError("Field cannot be empty");
            return false;
        }else{
            return true;
        }
    }

    private boolean validatePass(){
        if(ev_re_password.getText().toString().isEmpty()){
            ev_re_password.setError("Field cannot be empty");
            return false;
        }else{
            return true;
        }
    }

    private boolean validateRepass(){
        if(!(ev_password.getText().toString().equals(ev_re_password.getText().toString()))){
            ev_re_password.setError("Reentered Password does not match");
            ev_re_password.setText("");
            ev_password.setText("");
            return false;
        }else if(ev_password.getText().toString().isEmpty()){
>>>>>>> origin/khushi
            ev_password.setError("Field cannot be empty");
            return false;
        }
        return true;
    }

<<<<<<< HEAD
    // Validate re-entered password
    private boolean validateRepass() {
        if (!ev_password.getText().toString().equals(ev_re_password.getText().toString())) {
            ev_re_password.setError("Reentered Password does not match");
            ev_re_password.setText("");
            ev_password.setText("");
            return false;
        } else if (ev_re_password.getText().toString().isEmpty()) {
            ev_re_password.setError("Field cannot be empty");
            return false;
        }
        return true;
    }
=======


>>>>>>> origin/khushi
}