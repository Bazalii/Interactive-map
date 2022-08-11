package map

class GraphQlQuery() {
    private lateinit var query: String
    private lateinit var variables: Variables

    constructor(query: String): this() {
        this.query = query
    }

    constructor(query: String, variables: Variables): this() {
        this.query = query
        this.variables = variables
    }

    fun getQuery(): String {
        return query
    }

    fun setQuery(query: String) {
        this.query = query
    }

    fun getVariables(): Any {
        return variables
    }

    fun setVariables(variables: Variables) {
        this.variables = variables
    }
}