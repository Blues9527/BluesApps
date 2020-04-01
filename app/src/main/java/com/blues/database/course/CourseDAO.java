package com.blues.database.course;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

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
