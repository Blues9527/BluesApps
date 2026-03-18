package com.blues.db.user

import androidx.room.*
import kotlinx.coroutines.flow.Flow

/**
 * File: com.blues.db.user.UserDao.kt
 * Description: 用户DAO
 *
 * @author: lanhuajian
 * @time: 2022/1/20
 **/

@Dao
interface UserDao {

    /**
     * 入库一个用户信息
     */
    @Insert
    fun insertUser(user: User)

    /**
     * 删除一个用户信息
     */
    @Delete
    fun deleteUser(user: User)

    /**
     * 更新用户信息
     */
    @Update
    fun updateUser(user: User)

    /**
     * 删除所有用户信息
     */
    @Query("DELETE FROM user_info")
    fun deleteAll()

    /**
     * 根据用户名删除用户信息
     */
    @Query("DELETE FROM user_info WHERE username = :userName")
    fun deleteByName(userName: String)

    /**
     * 获取所有用户
     */
    @Query("SELECT * FROM user_info")
    fun getAllUsers(): Flow<List<User>>

    /**
     * 判断用户是否已存在
     */
    @Query("SELECT * FROM user_info WHERE username = :userName")
    fun isUsernameExist(userName: String): Flow<List<User>>

    /**
     * 通过手机号获取用户信息
     */
    @Query("SELECT * FROM user_info WHERE phone = :phone")
    fun isUserPhoneExist(phone: String): Flow<List<User>>

    /**
     * 校验用户信息有效性
     */
    @Query("SELECT * FROM user_info WHERE username = :userName AND password = :password")
    fun isUserNameInfoValidate(userName: String, password: String): Flow<List<User>>

    /**
     * 校验用户手机号码有效性
     */
    @Query("SELECT * FROM user_info WHERE phone = :phone AND password = :password")
    fun isUserPhoneInfoValidate(phone: String, password: String): Flow<List<User>>
}