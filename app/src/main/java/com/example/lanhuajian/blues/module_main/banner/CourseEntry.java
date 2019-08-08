package com.example.lanhuajian.blues.module_main.banner;

import java.io.Serializable;

/**
 * User : Blues
 * Date : 2019/8/8
 * Time : 15:17
 */

public class CourseEntry implements Serializable {

    private String entryIcon;

    private String entryTitle;

    public CourseEntry(String entryIcon, String entryTitle) {
        this.entryIcon = entryIcon;
        this.entryTitle = entryTitle;
    }

    public String getEntryIcon() {
        return entryIcon;
    }

    public CourseEntry setEntryIcon(String entryIcon) {
        this.entryIcon = entryIcon;
        return this;
    }

    public String getEntryTitle() {
        return entryTitle;
    }

    public CourseEntry setEntryTitle(String entryTitle) {
        this.entryTitle = entryTitle;
        return this;
    }
}
