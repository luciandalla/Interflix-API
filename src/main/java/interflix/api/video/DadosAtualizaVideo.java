package interflix.api.video;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record DadosAtualizaVideo(@NotNull Long id, String titulo, String descricao, String url, String competicao, Date data) {

}
