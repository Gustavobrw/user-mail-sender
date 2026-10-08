package dev.java10x.user.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Dados necessários para cadastrar um usuário")
public record UserDto(
        @Schema(description = "Nome do usuário", example = "Maria Silva", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank
        String name,
        @Schema(description = "Endereço de e-mail do usuário", example = "maria@example.com",
                requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank @Email
        String email
        ) {
}
