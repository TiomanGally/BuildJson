package de.gally

import org.junit.jupiter.api.Test
import strikt.api.expectThat
import strikt.assertions.isEqualTo

class BuildJsonTest {

    @Test
    fun `build super basic JsonObject`() {
        val myJson = buildJson {
            "name" with "NotMyName"
        }

        expectThat(myJson)
            .isEqualTo("""{"name":"NotMyName"}""")
    }

    @Test
    fun `build basic JsonObject with multiple values`() {
        val myJson = buildJson {
            "name" with "Tioman"
            "lastName" with "Gally"
            "age" with 22
        }

        expectThat(myJson)
            .isEqualTo("""{"name":"Tioman","lastName":"Gally","age":22}""")
    }

    @Test
    fun `buildJson with JsonObject inside`() {
        val myJson = buildJson {
            "simple" with "value"
            "object" with buildJson {
                "insideObject" with 1337L
            }
        }
    }

}

