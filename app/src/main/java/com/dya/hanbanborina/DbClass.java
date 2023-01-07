package com.dya.hanbanborina;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class DbClass extends SQLiteOpenHelper {
    public static String dbName = "hanbana.db";
    public static int dbVersion = 1;
    public static String dbPath ="";
    Context myContext;

    public DbClass(@Nullable Context context) {
        super(context,dbName,null,dbVersion);
        this.myContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private boolean ExistDatabase(){
        File myFile = new File(dbPath+dbName);

        return myFile.exists();
    }

    private void CopyDataBase(){

        try {
            InputStream myInput = myContext.getAssets().open(dbName);
            OutputStream myOutput =new FileOutputStream(dbPath+dbName);
            byte [] myBuffer = new byte[1024];
            int length;
            while ((length = myInput.read(myBuffer))>0){
                myOutput.write(myBuffer,0,length);
            }
            myOutput.flush(); myOutput.close(); myInput.close();
        } catch (Exception ignored){

        }
    }
    @Override
    public void onOpen(SQLiteDatabase db) {
        db.disableWriteAheadLogging();
        super.onOpen(db);
    }

    public void StartWork(){

        dbPath = myContext.getFilesDir().getParent()+"/databases/";
        if (!ExistDatabase()){
            this.getReadableDatabase();
            CopyDataBase();

        }

    }

   Cursor readAllkf(){
        String query ="select * from kf";
       SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=null;
        if (db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;

    }

    Cursor readAllfk(){
        String query ="select * from fk";
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cursor=null;
        if (db != null){
            cursor = db.rawQuery(query,null);
        }
        return cursor;

    }

}
