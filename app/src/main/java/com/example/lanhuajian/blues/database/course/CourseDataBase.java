package com.example.lanhuajian.blues.database.course;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * @author lanhuajian
 * create at 2020-01-19 22:09
 */
@Database(entities = CourseEntity.class, version = 1)
public abstract class CourseDataBase extends RoomDatabase {

    public abstract CourseDAO courseDAO();
}
