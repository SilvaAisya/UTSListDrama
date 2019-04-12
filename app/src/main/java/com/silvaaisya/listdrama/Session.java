package com.silvaaisya.listdrama;

import android.content.Context;
import android.content.SharedPreferences;

public class Session {

    public static final String Session_LISTALATMUSIK = "sessionDrama";

    public static final String Session_SUDAH_LOGIN = "sessionSudahLogin";

    SharedPreferences session;
    SharedPreferences.Editor sessionEditor;

    public Session(Context context) {
        session = context.getSharedPreferences(Session_LISTALATMUSIK, Context.MODE_PRIVATE);
        sessionEditor = session.edit();
    }

    public void saveSPString(String key, String value){
        sessionEditor.putString(key, value);
        sessionEditor.commit();
    }

    public void saveSPInt(String key, int value){
        sessionEditor.putInt(key, value);
        sessionEditor.commit();
    }

    public void saveSPBoolean(String key, boolean value){
        sessionEditor.putBoolean(key, value);
        sessionEditor.commit();
    }

    public Boolean getSession_SUDAHLOGIN(){
        return session.getBoolean(Session_SUDAH_LOGIN, false);
    }
}
