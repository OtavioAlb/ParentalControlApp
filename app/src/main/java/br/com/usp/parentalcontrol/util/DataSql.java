package br.com.usp.parentalcontrol.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataSql extends SQLiteOpenHelper {

    SQLiteDatabase sqLiteDatabase;

    private static final String DBNAME = "db_parent";
    private static final int DBVERSION = 1;

    /*Dados para a tabela Rules*/
    private static final String TABLENAME_RULE="rules";

    /*General Section*/
    private static final String ID_COLUMN="rule_id";
    private static final String NAMERULE_COLUMN="name_rule";
    private static final String DESCRIRULE_COLUMN="describ_rule";
    private static final String CHECKREAD="check_read";

    private static final String CREATE_RULE = "CREATE TABLE "+TABLENAME_RULE+"("+ID_COLUMN+
            " INTEGER PRIMARY KEY AUTOINCREMENT,"+NAMERULE_COLUMN+" TEXT,"+DESCRIRULE_COLUMN+" TEXT," +
            ""+CHECKREAD+" BOOLEAN"+")";

    private static final String DROP_TABLE_RULE= "DROP TABLE IF EXISTS "+TABLENAME_RULE;

    public DataSql(Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_RULE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(DROP_TABLE_RULE);
    }

    public boolean insertRule(String name_rule, String descri_rule, Boolean check_read){

        sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(NAMERULE_COLUMN, name_rule);
        contentValues.put(DESCRIRULE_COLUMN, descri_rule);
        contentValues.put(CHECKREAD, check_read);

        sqLiteDatabase.insert(TABLENAME_RULE, null, contentValues);
        return true;
    }

    public Cursor viewData(){
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String returnTable = "SELECT * FROM "+TABLENAME_RULE;
        Cursor cursor = sqLiteDatabase.rawQuery(returnTable, null);
        return cursor;
    }
}
