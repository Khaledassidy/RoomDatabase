package com.example.roomdatabase.Model.Migration;

import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

public  class Migration1_2 extends Migration {

    public Migration1_2(int startVersion, int endVersion) {
        super(startVersion, endVersion);
    }

    @Override
    public void migrate(@NonNull SupportSQLiteDatabase supportSQLiteDatabase) {
//        supportSQLiteDatabase.execSQL();
    }
}
