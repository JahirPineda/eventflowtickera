package cl.duoc.api_gateway;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class GatewayConfig {

    @Bean
    public RouterFunction<ServerResponse> clientesRoute() {
        return GatewayRouterFunctions.route("msvc_clientes")
                .route(RequestPredicates.path("/api/clientes/**"),
                        HandlerFunctions.http("http://localhost:8081"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> eventosRoute() {
        return GatewayRouterFunctions.route("msvc_eventos")
                .route(RequestPredicates.path("/api/eventos/**"),
                        HandlerFunctions.http("http://localhost:8082"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> categoriasRoute() {
        return GatewayRouterFunctions.route("msvc_categorias")
                .route(RequestPredicates.path("/api/categorias/**"),
                        HandlerFunctions.http("http://localhost:8082"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> recintosRoute() {
        return GatewayRouterFunctions.route("msvc_recintos")
                .route(RequestPredicates.path("/api/recintos/**"),
                        HandlerFunctions.http("http://localhost:8083"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> exponentesRoute() {
        return GatewayRouterFunctions.route("msvc_exponentes")
                .route(RequestPredicates.path("/api/exponentes/**"),
                        HandlerFunctions.http("http://localhost:8084"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> preciosRoute() {
        return GatewayRouterFunctions.route("msvc_precios")
                .route(RequestPredicates.path("/api/precios/**"),
                        HandlerFunctions.http("http://localhost:8085"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> ordenesRoute() {
        return GatewayRouterFunctions.route("msvc_ordenes")
                .route(RequestPredicates.path("/api/ordenes/**"),
                        HandlerFunctions.http("http://localhost:8086"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> ticketsRoute() {
        return GatewayRouterFunctions.route("msvc_tickets")
                .route(RequestPredicates.path("/api/tickets/**"),
                        HandlerFunctions.http("http://localhost:8087"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> resenasRoute() {
        return GatewayRouterFunctions.route("msvc_resenas")
                .route(RequestPredicates.path("/api/resenas/**"),
                        HandlerFunctions.http("http://localhost:8088"))
                .build();
    }

    @Bean
    public RouterFunction<ServerResponse> preguntasRoute() {
        return GatewayRouterFunctions.route("msvc_preguntas")
                .route(RequestPredicates.path("/api/preguntas/**"),
                        HandlerFunctions.http("http://localhost:8088"))
                .build();
    }
}