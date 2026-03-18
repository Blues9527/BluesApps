package com.blues.db.user

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

/**
 * File: com.blues.db.user.User.kt
 * Description: 用户实体类
 *
 * @author: lanhuajian
 * @time: 2022/1/20
 **/

@Entity(tableName = "user_info")
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id", typeAffinity = ColumnInfo.INTEGER)
    val id: Int? = null,//用户id

    @ColumnInfo(name = "username", typeAffinity = ColumnInfo.TEXT)
    val userName: String? = null,//用户名

    @ColumnInfo(name = "gender", typeAffinity = ColumnInfo.INTEGER)
    val gender: Int = 0,//用户性别,0女，1男

    @ColumnInfo(name = "phone", typeAffinity = ColumnInfo.TEXT)
    val phone: String? = null,//手机号

    @ColumnInfo(name = "password", typeAffinity = ColumnInfo.TEXT)
    val password: String? = null,//密码

    @ColumnInfo(name = "desc", typeAffinity = ColumnInfo.TEXT)
    val desc: String? = null,//自我介绍

    @ColumnInfo(name = "head_image", typeAffinity = ColumnInfo.TEXT)
    val headImage: String? = null,//用户头像
){
    @Ignore
    constructor():this(0,"",0,"","","")
}
