package com.blues.bean

import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import androidx.room.Entity
import java.io.Serializable

/**
 * @author lanhuajian
 * create at 2020-01-19 22:09
 */
@Entity(tableName = "course")
class CourseEntity(@field:ColumnInfo(name = "name") var name: String,
                   @field:ColumnInfo(name = "icon") var icon: String) : Serializable {

    /*

        "http://edu-image.nosdn.127.net/fbbf1cfc-45f2-4a42-bcbb-df5cad63d3c2.png?imageView&quality=100",
        "http://edu-image.nosdn.127.net/23444883-fc1a-4972-8a22-591e5b790ee0.png?imageView&quality=100",
        "http://edu-image.nosdn.127.net/b216231d-4b93-4d5c-8e7c-e22389f194b8.png?imageView&quality=100",
        "http://edu-image.nosdn.127.net/55329cd44f7142c7b2eaaca1a68e2430.png?imageView&quality=100",
        "http://edu-image.nosdn.127.net/8f2db166988542c2b720f418e6330500.png?imageView&quality=100",
        "http://edu-image.nosdn.127.net/dd3fdff7aeea4b37af8d623be3695331.png?imageView&quality=100",
        "http://edu-image.nosdn.127.net/c0c090e1872748ff8cec40ed03b3e476.png?imageView&quality=100",
        "http://edu-image.nosdn.127.net/fd322af24d8947a8961b99c42b8261e8.png?imageView&quality=100"


        "微专业",
        "职场提升",
        "编程开发",
        "人工智能",
        "产品运营",
        "创意设计",
        "电子商务",
        "语言学习",
     */
    @PrimaryKey(autoGenerate = true)
    var id = 0

    override fun toString(): String {
        return "CourseEntity{id=$id, name='$name', icon='$icon'}"
    }
}