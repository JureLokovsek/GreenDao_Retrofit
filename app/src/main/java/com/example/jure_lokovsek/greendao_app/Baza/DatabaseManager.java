package com.example.jure_lokovsek.greendao_app.Baza;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.jure_lokovsek.greendao_app.DataBase.DaoMaster;
import com.example.jure_lokovsek.greendao_app.DataBase.DaoSession;
import com.example.jure_lokovsek.greendao_app.DataBase.User;
import com.example.jure_lokovsek.greendao_app.DataBase.UserDao;

import java.util.List;

public class DatabaseManager {

    static DaoSession mDaoSession;
    static DaoMaster.DevOpenHelper daoMasterDevOpenHelper;
    static DaoMaster daoMaster;
    static SQLiteDatabase sqLiteDatabase;
    Context context;
    public static final boolean ENCRYPTED = false;

    public DatabaseManager(Context context) {
        this.context = context;
        setupDatabase();
    }

    public void setupDatabase(){
        daoMasterDevOpenHelper = new DaoMaster.DevOpenHelper(context, ENCRYPTED ? "notes-db-encrypted" : "notes-db");
        sqLiteDatabase = daoMasterDevOpenHelper.getWritableDatabase();
        daoMaster = new DaoMaster(sqLiteDatabase);
        mDaoSession = daoMaster.newSession();
    }

    // region Test
    public void add(){
        mDaoSession.getUserDao().insert(new User("Jure", 15,46,89));
        mDaoSession.getUserDao().insert(new User("Lokovsek", 16,42,89));
        mDaoSession.getUserDao().insert(new User("Ok", 17,45,81));
        mDaoSession.getUserDao().insert(new User("Bed", 18,45,84));
    }

    public List<User> getUsers(){
        List<User> users = mDaoSession.getUserDao().queryBuilder().where(UserDao.Properties.Year.eq(87)).list();
        return users;
    }

    public int getSize(){
        List<User> users = mDaoSession.getUserDao().loadAll();
        return  users.size();
    }

    public void deleteAllUsers(){
        mDaoSession.getUserDao().deleteAll();
    }

    // endregion

    // region Nutrient




    // endregion

    // region Hello

    // endregion




}
