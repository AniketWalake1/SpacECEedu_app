package com.spacECE.spaceceedu.Authentication;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.spacECE.spaceceedu.Authentication.Account;

public class UserLocalStore {

    public static final String DETAILS = "UserDetails";
    SharedPreferences userLocalDatabase;

    public UserLocalStore(Context context) {
        userLocalDatabase = context.getSharedPreferences(DETAILS, 0);
    }

    public Account getLoggedInAccount() {
        Log.e( "7 auth ","----------------------------------------------");

        String name = userLocalDatabase.getString("username", null);
        String account_id = userLocalDatabase.getString("account_id", null);
        String contact_number = userLocalDatabase.getString("contact_number", null);
        String UID = userLocalDatabase.getString("UID", null);
        String profile_pic = userLocalDatabase.getString("profile_pic", null);
        boolean isConsultant = userLocalDatabase.getBoolean("isConsultant", false);

        Account account = new Account(account_id, name, contact_number,isConsultant,profile_pic);
        return account;
    }

    public void setUserLoggedIn(boolean loggedIn, Account account) {

        Log.e( "7 auth ","----------------------------------------------");

        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        if(account.isCONSULTANT()){
            spEditor.putBoolean("loggedIn", loggedIn);
            spEditor.putString("account_id", account.getAccount_id());
            spEditor.putString("username", account.getUsername());
            spEditor.putString("contact_number", account.getContact_number());
            spEditor.putString("UID", account.getuId());
            spEditor.putBoolean("isConsultant", account.isCONSULTANT());
            spEditor.putString("profile_pic", account.getProfile_pic());
            Log.e( "UserLocalStore",account.getProfile_pic()+"---link");
            spEditor.putString("consultant_category", account.getConsultant_Category());
            spEditor.putString("consultant_office", account.getConsultant_Office());
            spEditor.putString("consultant_start_time", account.getConsultant_StartTime());
            spEditor.putString("consultant_end_time", account.getConsultant_Language());
            spEditor.putString("consultant_fee", account.getConsultant_Fee());
            spEditor.putString("consultant_qualification", account.getConsultant_Qualification());
            spEditor.commit();
        } else {
            spEditor.putBoolean("loggedIn", loggedIn);
            spEditor.putString("account_id", account.getAccount_id());
            spEditor.putString("username", account.getUsername());
            spEditor.putString("contact_number", account.getContact_number());
            spEditor.putString("UID", account.getuId());
            spEditor.putBoolean("isConsultant", account.isCONSULTANT());
            spEditor.putString("profile_pic", account.getProfile_pic());
            spEditor.commit();
        }

    }

    public void setUserLoggedIn(boolean loggedIn) {
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.putBoolean("loggedIn", loggedIn);
        spEditor.commit();
    }

    public void clearUserData() {
        SharedPreferences.Editor spEditor = userLocalDatabase.edit();
        spEditor.clear();
        spEditor.commit();
    }
    public boolean getUserLoggedIn(){
        if(userLocalDatabase.getBoolean("loggedIn", false)==true){
            return true;
        }
        return false;
    }
}

