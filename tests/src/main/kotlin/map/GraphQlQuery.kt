package map

import com.google.gson.annotations.SerializedName

class GraphQlQuery() {
    @SerializedName("query")
    lateinit var query: String
    @SerializedName("variables")
    lateinit var variables: Variables

    constructor(queryInput: String) : this() {
        query = queryInput
    }

    constructor(queryInput: String, variablesInput: Variables) : this() {
        query = queryInput
        variables = variablesInput
    }
}