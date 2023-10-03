package interflix.api.video;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.Date;

public record DadosCadastroVideo(@NotBlank String titulo,
                                 @NotBlank String descricao,
                                 @NotBlank @Pattern(regexp = "https://youtube\\.com\\.br/.*") String url,
                                 @NotBlank String competicao,
                                 @NotNull Date data) {
}
