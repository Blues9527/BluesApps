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

class DoubleDefaultAdapter : JsonSerializer<Double?>, JsonDeserializer<Double> {

    override fun deserialize(
        json: JsonElement, typeOfT: Type,
        context: JsonDeserializationContext
    ): Double {
        try {
            if (json.asString == null || json.asString == "" || json.asString == "null") { //定义为double类型,如果后台返回""或者null,则返回0.00
                return 0.00
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return try {
            json.asDouble
        } catch (e: NumberFormatException) {
            throw JsonSyntaxException(e)
        }
    }

    override fun serialize(
        src: Double?, typeOfSrc: Type,
        context: JsonSerializationContext
    ): JsonElement {
        return JsonPrimitive(src)
    }
}