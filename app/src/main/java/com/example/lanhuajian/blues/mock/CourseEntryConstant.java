package com.example.lanhuajian.blues.mock;


import com.example.lanhuajian.blues.module_main.banner.CourseEntry;

import java.util.ArrayList;
import java.util.List;

/**
 * User : Blues
 * Date : 2019/8/8
 * Time : 15:21
 */

public class CourseEntryConstant {

    private static final String[] iconsUrl = {
            "http://edu-image.nosdn.127.net/fbbf1cfc-45f2-4a42-bcbb-df5cad63d3c2.png?imageView&quality=100",
            "http://edu-image.nosdn.127.net/23444883-fc1a-4972-8a22-591e5b790ee0.png?imageView&quality=100",
            "http://edu-image.nosdn.127.net/b216231d-4b93-4d5c-8e7c-e22389f194b8.png?imageView&quality=100",
            "http://edu-image.nosdn.127.net/55329cd44f7142c7b2eaaca1a68e2430.png?imageView&quality=100",
            "http://edu-image.nosdn.127.net/8f2db166988542c2b720f418e6330500.png?imageView&quality=100",
            "http://edu-image.nosdn.127.net/dd3fdff7aeea4b37af8d623be3695331.png?imageView&quality=100",
            "http://edu-image.nosdn.127.net/c0c090e1872748ff8cec40ed03b3e476.png?imageView&quality=100",
            "http://edu-image.nosdn.127.net/fd322af24d8947a8961b99c42b8261e8.png?imageView&quality=100"
    };

    private static final String[] entryTitles = {
            "微专业",
            "职场提升",
            "编程开发",
            "人工智能",
            "产品运营",
            "创意设计",
            "电子商务",
            "语言学习",
    };

    public static List<CourseEntry> getEntries() {
        List<CourseEntry> courseEntries = new ArrayList<>();
        for (int i = 0; i < CourseEntryConstant.iconsUrl.length; i++) {
            courseEntries.add(new CourseEntry(CourseEntryConstant.iconsUrl[i], CourseEntryConstant.entryTitles[i]));
        }
        return courseEntries;
    }
}
