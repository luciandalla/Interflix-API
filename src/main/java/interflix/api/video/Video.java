package interflix.api.video;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;

@Table(name = "videos")
@Entity(name = "Video")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Video {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Boolean ativo;
    private String titulo;
    private String descricao;
    private String url;
    private String competicao;

    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp data;

    public Video(DadosCadastroVideo dados) {
        this.ativo = true;
        this.titulo = dados.titulo();
        this.descricao = dados.descricao();
        this.url = dados.url();
        this.data = new Timestamp(dados.data().getTime());
        this.competicao = dados.competicao();
        System.out.println(this.data);
    }

    public void atualizarInformacoes(DadosAtualizaVideo dados) {
        if(dados.titulo() != null){
            this.titulo = dados.titulo();
        }
        if(dados.descricao() != null){
            this.descricao = dados.descricao();
        }
        if(dados.url() != null){
            this.url = dados.url();
        }
        if(dados.competicao() != null){
            this.competicao = dados.competicao();
        }
        if(dados.data() != null){
            this.data = new Timestamp(dados.data().getTime());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
