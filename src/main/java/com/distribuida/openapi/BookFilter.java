package com.distribuida.openapi;

import org.eclipse.microprofile.openapi.OASFactory;
import org.eclipse.microprofile.openapi.OASFilter;
import org.eclipse.microprofile.openapi.models.OpenAPI;
import org.eclipse.microprofile.openapi.models.info.Info;
import org.eclipse.microprofile.openapi.models.responses.APIResponse;

import java.util.*;

public class BookFilter implements OASFilter {

    @Override
    public APIResponse filterAPIResponse(APIResponse apiResponse) {
        if ("Falta descripcion".equals(apiResponse.getDescription())) {
            apiResponse.setDescription("Libro no encontrado ");
        }
        return apiResponse;
    }

    @Override
    public void filterOpenAPI(OpenAPI openAPI) {
        openAPI.setInfo(
                OASFactory.createObject(Info.class).title("Books App").version("1.0.")
                        .description(
                                "Permite realizar las operaciones CRUD de Libros")
        );

        List<String> tags = new ArrayList<>();
        tags.add("Books");
        openAPI.setPaths(OASFactory.createPaths()
                .addPathItem("/books", OASFactory.createPathItem()
                        .GET(OASFactory.createOperation()
                                .description("Consulta un Libro por Id")
                                .tags(tags))));

    }

}
