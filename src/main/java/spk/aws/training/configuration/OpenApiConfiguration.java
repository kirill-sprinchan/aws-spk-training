package spk.aws.training.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
class OpenApiConfiguration {

    public static final String AWS_BASIC_AUTH = "AWS Basic Auth";

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components().addSecuritySchemes(AWS_BASIC_AUTH, getSecScheme()))
                .addSecurityItem(new SecurityRequirement().addList(AWS_BASIC_AUTH, "[]"))
                .info(new Info().title("AWS SPK Training").description(
                        "Training project for AWS."));
    }

    private SecurityScheme getSecScheme() {
        SecurityScheme securityScheme = new SecurityScheme();
        securityScheme.setType(SecurityScheme.Type.HTTP);
        securityScheme.setScheme("basic");
        return securityScheme;
    }

}
