package com.example.jure_lokovsek.greendao_app.DataBase.DataBaseManager;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.jure_lokovsek.greendao_app.DataBase.DaoMaster;
import com.example.jure_lokovsek.greendao_app.DataBase.DaoSession;
import com.example.jure_lokovsek.greendao_app.DataBase.Nutrient;
import com.example.jure_lokovsek.greendao_app.DataBase.User;
import com.example.jure_lokovsek.greendao_app.DataBase.UserDao;

import java.util.List;

public class DatabaseManager {

    private static DaoSession mDaoSession;
    private static DaoMaster.DevOpenHelper daoMasterDevOpenHelper;
    private static DaoMaster daoMaster;
    private static SQLiteDatabase sqLiteDatabase;
    private Context context;
    private static final boolean ENCRYPTED = false;

    public DatabaseManager(Context context) {
        this.context = context;
        setupDatabase();
    }

    private void setupDatabase(){
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
        return mDaoSession.getUserDao().queryBuilder().where(UserDao.Properties.Year.eq(87)).list();
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

    public void addNu(){
        mDaoSession.runInTx(new Runnable() {
            @Override
            public void run() {
                mDaoSession.getNutrientDao().insert(new Nutrient("nutrient", "value", "unit"));
                mDaoSession.getNutrientDao().insert(new Nutrient("nutrient", "value", "unit"));
            }
        });
    }

    public void saveNutrients(final List<Nutrient> seznam){
        mDaoSession.runInTx(new Runnable() {
            @Override
            public void run() {
                mDaoSession.getNutrientDao().insertInTx(seznam);
            }
        });
    }

    public int getNuSize(){
        return mDaoSession.getNutrientDao().loadAll().size();
    }

    public void insertNu(Nutrient nutrient){
        mDaoSession.getNutrientDao().insertInTx(nutrient);
    }

    public void deleteAllNu(){
        mDaoSession.getNutrientDao().deleteAll();
    }


    // endregion

    // region Hello

    // endregion

    public void deleteAllDaos(){
        mDaoSession.runInTx(new Runnable() {
            @Override
            public void run() {
                mDaoSession.getNutrientDao().deleteAll();
                mDaoSession.getUserDao().deleteAll();
                mDaoSession.getProduktDao().deleteAll();
            }
        });

    }


}
