package com.abner.greendao;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import com.abner.greendao.bean.User;
import com.abner.greendao.dao.DaoMaster;
import com.abner.greendao.dao.DaoSession;

public class GreenDaoApplication extends Application {
    private DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        initGreenDao();
    }

    private void initGreenDao() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this,"test.db");
        SQLiteDatabase sqLiteDatabase = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(sqLiteDatabase);
        daoSession = daoMaster.newSession();
        daoSession.getDao(new User().getClass());
        daoSession.getUserDao();
    }

    public DaoSession getDaoSession(){
        return daoSession;
    }
}
