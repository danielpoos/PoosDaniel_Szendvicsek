package hu.petrik.szendvicsek;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

    public class DBHelper extends SQLiteOpenHelper {
        private static final String DB_NAME = "szendvics.db";
        private static final int DB_VERSION = 1;

        private static final String TABLE_NAME = "szendvicsek";
        private static final String COL_ID = "id";
        private static final String COL_NAME = "nev";
        private static final String COL_DETAIL = "leiras";
        private static final String COL_MAKING = "elkeszites";
        private static final String COL_PRICE = "ar";


        public DBHelper(Context context) {
            super(context, DB_NAME, null, DB_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            String sql = "CREATE TABLE "+TABLE_NAME +
                    " ("+COL_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+COL_NAME+ " TEXT NOT NULL, "+COL_DETAIL+ " TEXT NOT NULL, "+COL_MAKING+ " INTEGER NOT NULL, "+COL_PRICE+ " INTEGER NOT NULL );";
            db.execSQL(sql);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
            onCreate(db);
        }

        public boolean save(String name, String detail, String making, String price){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COL_NAME, name);
            values.put(COL_DETAIL, detail);
            values.put(COL_MAKING, making);
            values.put(COL_PRICE, price);
            return db.insert(TABLE_NAME, null, values)!=-1;
        }
        public Cursor list(){
            SQLiteDatabase db = this.getReadableDatabase();
            return db.rawQuery("SELECT * FROM "+TABLE_NAME,null);
        }
        public int delete(String id){
            SQLiteDatabase db = this.getWritableDatabase();
            return db.delete(TABLE_NAME, COL_ID +" = ? ", new String[]{id});
        }
        public int modify(String id, String name, String detail, String making, String price){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COL_ID, id);
            values.put(COL_NAME, name);
            values.put(COL_DETAIL, detail);
            values.put(COL_MAKING, making);
            values.put(COL_PRICE, price);
            return db.update(TABLE_NAME, values ,COL_ID +" = ? ", new String[]{id});
        }
    }