package map.controllers

import map.services.IMapService
import org.eclipse.microprofile.graphql.GraphQLApi

@GraphQLApi
class MapController(private val _mapService: IMapService) {
}