package interflix.api.video;

import java.util.Date;

public record DadosListagemVideos(Long id, String titulo, String descricao, String url, String competicao, Date data) {

    public DadosListagemVideos(Video video){
        this(video.getId(), video.getTitulo(), video.getDescricao(), video.getUrl(), video.getCompeticao(), video.getData());
    }
}
