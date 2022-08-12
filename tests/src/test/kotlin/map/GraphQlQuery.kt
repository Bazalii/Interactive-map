package map

class GraphQlQuery() {
    lateinit var query: String
    lateinit var variables: Variables

    constructor(queryInput: String) : this() {
        query = queryInput
    }

    constructor(queryInput: String, variablesInput: Variables) : this() {
        query = queryInput
        variables = variablesInput
    }
}