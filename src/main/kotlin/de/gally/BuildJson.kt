package de.gally

import org.json.JSONObject

class BuildJson {
    private val values = mutableListOf<Pair<String, Any>>()

    infix fun String.with(value: Any) {
        values.add(this to value)
    }

    fun build(): String {
        val jsonObject = JSONObject()
        values.map { jsonObject.put(it.first, it.second) }
        return jsonObject.toString()
    }

}

fun buildJson(buildJsonBuilder: BuildJson.() -> Unit) = BuildJson().apply(buildJsonBuilder).build()
