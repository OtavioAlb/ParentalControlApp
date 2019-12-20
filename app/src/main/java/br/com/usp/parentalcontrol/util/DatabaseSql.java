package br.com.usp.parentalcontrol.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import br.com.usp.parentalcontrol.Model.Profile;
import br.com.usp.parentalcontrol.Model.Rule;

public class DatabaseSql extends SQLiteOpenHelper {

    SQLiteDatabase sqLiteDatabase;

    private static final String DBNAME = "DB_PARENTALCONTROL";
    private static final int DBVERSION = 1;

    /* Parent Section */
    private static final String TABLENAME="profile";
    private static final String ID_COLUMN="parent_id";
    private static final String FIRSTNAME_COLUMN="first_name";
    private static final String LASTNAME_COLUMN="last_name";
    private static final String EMAIL_COLUMN= "email";
    private static final String CHECKBOXPARENT_COLUMN = "check_update";

    /*  Child Section  */
    private static final String CHILDNAME_COLUMN = "child_name";
    private static final String CHECKBOXCHILD_COLUMN = "check_eula";

    /* Review Section */
    private static final String CHECKBOXREVIEW_COLUMN ="check_policy";

    /* Query */
    private static final String CREATE_TABLE = "CREATE TABLE "+TABLENAME+"("+ID_COLUMN+
            " INTEGER PRIMARY KEY AUTOINCREMENT,"+FIRSTNAME_COLUMN+" TEXT,"+LASTNAME_COLUMN+" TEXT,"
            +EMAIL_COLUMN+" TEXT,"+CHECKBOXPARENT_COLUMN+" BOOLEAN,"+CHILDNAME_COLUMN+" TEXT,"
            +CHECKBOXCHILD_COLUMN+" BOOLEAN,"+CHECKBOXREVIEW_COLUMN+" BOOLEAN"+")";

    private static final String DROP_TABLE = "DROP TABLE IF EXISTS "+TABLENAME;

    public DatabaseSql(Context context) {

        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);
        sqLiteDatabase.execSQL(CREATE_RULE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE);
        sqLiteDatabase.execSQL(DROP_TABLE_RULE);

    }

    public boolean insert(String firstName, String lastName, String email, boolean checkParent,
                          String childname, boolean checkChild, boolean checkReview){

        sqLiteDatabase = getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(FIRSTNAME_COLUMN, firstName);
        cv.put(LASTNAME_COLUMN, lastName);
        cv.put(EMAIL_COLUMN, email);
        cv.put(CHECKBOXPARENT_COLUMN, checkParent);
        cv.put(CHILDNAME_COLUMN, childname);
        cv.put(CHECKBOXCHILD_COLUMN, checkChild);
        cv.put(CHECKBOXREVIEW_COLUMN, checkReview);

        sqLiteDatabase.insert(TABLENAME, null, cv);
        return true;
    }

    public boolean insertRule(String name_rule, String descri_rule, String spinner_Service,String operation_check,
                              String object_check, String purpose, String recipient, String obligation, String retention){

        sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(NAMERULE_COLUMN, name_rule);
        contentValues.put(DESCRIRULE_COLUMN, descri_rule);
        contentValues.put(WEBSERVICE_COLUMN, spinner_Service);
        contentValues.put(OPERATION_CHECK, operation_check);
        contentValues.put(OBJECT_CHECK, object_check);
        contentValues.put(PURPOSE_COLUMN, purpose);
        contentValues.put(RECIPIENT_COLUMN, recipient);
        contentValues.put(OBLIGATION_COLUMN, obligation);
        contentValues.put(RETENTION_COLUMN, retention);

        sqLiteDatabase.insert(TABLENAME_RULE, null, contentValues);
        return true;
    }

    /*Dados para a tabela Rules*/
    private static final String TABLENAME_RULE="rules";

    /*General Section*/
    private static final String IDRULE_COLUMN="rule_id";
    private static final String NAMERULE_COLUMN="name_rule";
    private static final String DESCRIRULE_COLUMN="describ_rule";
    private static final String WEBSERVICE_COLUMN="spinner_Service";
    private static final String OPERATION_CHECK="operation_check";
    private static final String OBJECT_CHECK="object_check";
    private static final String PURPOSE_COLUMN="purpose";
    private static final String RECIPIENT_COLUMN="recipient";
    private static final String OBLIGATION_COLUMN="obligation";
    private static final String RETENTION_COLUMN="retention";

    private static final String CREATE_RULE = "CREATE TABLE "+TABLENAME_RULE+"("+IDRULE_COLUMN+
            " INTEGER PRIMARY KEY AUTOINCREMENT,"+NAMERULE_COLUMN+" TEXT," +
            ""+DESCRIRULE_COLUMN+" TEXT,"+WEBSERVICE_COLUMN+" TEXT,"+OPERATION_CHECK+" TEXT,"+OBJECT_CHECK+" TEXT,"
            +PURPOSE_COLUMN+" TEXT,"+RECIPIENT_COLUMN+" TEXT,"+OBLIGATION_COLUMN+" TEXT,"+RETENTION_COLUMN+" TEXT"+")";

    private static final String DROP_TABLE_RULE= "DROP TABLE IF EXISTS "+TABLENAME_RULE;

    public void deleteRule(int sid){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String DELETE_LINE = "DELETE FROM " + TABLENAME_RULE + " WHERE rule_id = '"+sid+"'";
        String ALTER_INCREMENT ="UPDATE SQLITE_SEQUENCE SET SEQ = (SELECT MAX(rule_id) FROM '"+TABLENAME_RULE+"') WHERE NAME='"+TABLENAME_RULE+"'";
        //String ALTER_INCREMENT ="UPDATE SQLITE_SEQUENCE SET SEQ =0 WHERE NAME= '"+TABLENAME_RULE+"'";
        sqLiteDatabase.execSQL(DELETE_LINE);
        sqLiteDatabase.execSQL(ALTER_INCREMENT);

    }

    public List<Rule> getAllRules(){

        List<Rule> ruleList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        //Cursor cursor = sqLiteDatabase.rawQuery("SELECT "+NAMERULE_COLUMN+", "+WEBSERVICE_COLUMN+" FROM "+TABLENAME_RULE, null);

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLENAME_RULE, null);


        if (cursor.moveToFirst()){
            do {
                String nameRule = cursor.getString(1);
                String descrp = cursor.getString(2);
                String webService = cursor.getString(3);
                String operationCheck = cursor.getString(4);
                String objectCheck = cursor.getString(5);
                String purpose = cursor.getString(6);
                String recipient = cursor.getString(7);
                String obligation = cursor.getString(8);
                String retention = cursor.getString(9);

                Rule rule = new Rule(nameRule, descrp, webService, operationCheck, objectCheck, purpose, recipient, obligation, retention);
                ruleList.add(rule);
            }while (cursor.moveToNext());
        }

        return ruleList;
    }

    public Cursor viewData(){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String returnTable = "SELECT * FROM "+TABLENAME_RULE;
        Cursor cursor = sqLiteDatabase.rawQuery(returnTable, null);
        return cursor;
    }

    public List<Profile> getProfile(){
        List<Profile> profiles = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+TABLENAME, null);

        cursor.moveToLast();
        String name = cursor.getString(2);
        System.out.println("Teste 2");
        System.out.println(name);
        return profiles;
    }

    public String buscarUser(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String name = "";
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " +TABLENAME, null);
        if(cursor.moveToLast()){
            name = cursor.getString(1);
        }

        return name;
    }

    public String getString(String var) {
        String query = "SELECT * FROM " + TABLENAME_RULE + "";
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);

        cursor.moveToFirst();

        String name = cursor.getString(cursor.getColumnIndex(IDRULE_COLUMN));
            cursor.close();

        return name;
    }
}
