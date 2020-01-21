package com.example.lanhuajian.blues.database.course;

import android.arch.persistence.room.Room;
import android.content.Context;

import java.util.List;

/**
 * @author lanhuajian
 * create at 2020-01-19 22:09
 */
public class CourseManger {

    private CourseDataBase courseDataBase;

    private CourseManger() {
    }

    private static class Holder {
        private static final CourseManger INSTANCE = new CourseManger();
    }

    public static CourseManger getInstance() {
        return Holder.INSTANCE;
    }


    /**
     * 初始化创建数据库
     *
     * @param ctx 上下文依赖
     */
    public void initDataBase(Context ctx) {
        courseDataBase = Room.databaseBuilder(ctx, CourseDataBase.class, "blues.db")
                //允许在主线程中进行查找操作
                .allowMainThreadQueries()
                .build();
    }


    /**
     * 获取dao
     *
     * @return 数据库操作接口
     */
    public CourseDAO getDao() {
        return courseDataBase.courseDAO();
    }


    //---------------------数据库基本操作
    public void insertCourse(CourseEntity course) {
        getDao().insertCourse(course);
    }

    public void deleteCourse(CourseEntity course) {
        getDao().deleteCourse(course);
    }

    public void updateCourse(CourseEntity course) {
        getDao().updateCourse(course);
    }

    public List<CourseEntity> getAllCourse() {
        return getDao().getAllCourses();
    }

    public List<CourseEntity> getCourse(String name) {
        return getDao().getCourse(name);
    }

    //数据库扩展操作
    public boolean courseExits(String name) {
        return getCourse(name).size() > 0;
    }
}
