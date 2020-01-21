package com.example.lanhuajian.blues.database.course;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * @author lanhuajian
 * create at 2020-01-19 22:09
 */

@Dao
public interface CourseDAO {

    @Insert
    void insertCourse(CourseEntity course);

    @Delete
    void deleteCourse(CourseEntity course);

    @Update
    void updateCourse(CourseEntity course);

    @Query("SELECT * FROM course")
    List<CourseEntity> getAllCourses();

    @Query("SELECT * FROM course WHERE name LIKE :courseName")
    List<CourseEntity> getCourse(String courseName);
}
