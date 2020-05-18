package com.abner.greendao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;

import com.abner.greendao.bean.User;
import com.abner.greendao.dao.DaoSession;
import com.abner.greendao.dao.UserDao;

import org.greenrobot.greendao.query.Query;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private UserDao userDao;
    private Query<User> userQuery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DaoSession daoSession = ((GreenDaoApplication)getApplication()).getDaoSession();
        userDao = daoSession.getUserDao();
        User user =new User();
        user.setAge(20);
        user.setName("zhangsan");

        userDao.insert(user);
        Log.d("DaoExample", "Inserted new user, ID: " + user.getId());

        userQuery = userDao.queryBuilder().orderAsc(UserDao.Properties.Name).build();
        Query<User> q1 =userDao.queryBuilder().where(UserDao.Properties.Name.eq("zhangsan")).build();
        Query<User> q2 =userDao.queryBuilder().where(UserDao.Properties.Name.eq("zhangsan")).build();
        updateUsers();
        Looper.getMainLooper();
        Looper.prepare();
        Looper.loop();
        Looper.myLooper();
        Looper.myQueue();
    }


    private void updateUsers() {
        List<User> users = userQuery.list();
    }
}
