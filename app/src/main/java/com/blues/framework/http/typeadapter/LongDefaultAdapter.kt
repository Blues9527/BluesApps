package com.blues.framework.http.typeadapter

import com.google.gson.JsonSerializer
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonSyntaxException
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonPrimitive
import java.lang.Exception
import java.lang.NumberFormatException
import java.lang.reflect.Type

/**
 * Created by Administrator on 2018/2/23.
 */
class LongDefaultAdapter : JsonSerializer<Long?>, JsonDeserializer<Long> {

    override fun deserialize(json: JsonElement, typeOfT: Type,
        context: JsonDeserializationContext): Long {
        try {
            if (json.asString == "" || json.asString == "null") { //定义为long类型,如果后台返回""或者null,则返回0
                return 0L
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return try {
            json.asLong
        } catch (e: NumberFormatException) {
            throw JsonSyntaxException(e)
        }
    }

    override fun serialize(src: Long?, typeOfSrc: Type,
        context: JsonSerializationContext): JsonElement {
        return JsonPrimitive(src)
    }
}