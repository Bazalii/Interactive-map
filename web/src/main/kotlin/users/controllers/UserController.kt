package users.controllers

import org.eclipse.microprofile.graphql.GraphQLApi
import users.services.IUserService
import javax.enterprise.context.ApplicationScoped

@GraphQLApi
@ApplicationScoped
class UserController(private val _userService: IUserService) {
}