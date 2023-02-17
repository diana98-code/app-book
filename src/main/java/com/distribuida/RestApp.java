package com.distribuida;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Info;

@ApplicationPath("/")
@OpenAPIDefinition(info = @Info(title="CRUD Libros", version = "1.0.0",
                description = "Realiza todas la operaciones CRUD de Libros"))
public class RestApp extends Application {
}
