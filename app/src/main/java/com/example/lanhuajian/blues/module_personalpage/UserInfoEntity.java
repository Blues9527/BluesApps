package com.example.lanhuajian.blues.module_personalpage;

import java.io.Serializable;

/**
 * User : Blues
 * Date : 2019/5/23
 * Time : 10:00
 */

public class UserInfoEntity implements Serializable {

    /**
     * msg : success
     * code : 200
     * data : {"username":"l)jkc9K6&CSm*","user_id":79,"school":"广东财经大学","major":"信息与计算科学"}
     */

    private String msg;
    private int code;
    private DataBean data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * username : l)jkc9K6&CSm*
         * user_id : 79
         * school : 广东财经大学
         * major : 信息与计算科学
         */

        private String username;
        private int user_id;
        private String school;
        private String major;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getSchool() {
            return school;
        }

        public void setSchool(String school) {
            this.school = school;
        }

        public String getMajor() {
            return major;
        }

        public void setMajor(String major) {
            this.major = major;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "username='" + username + '\'' +
                    ", user_id=" + user_id +
                    ", school='" + school + '\'' +
                    ", major='" + major + '\'' +
                    '}';
        }
    }
}
