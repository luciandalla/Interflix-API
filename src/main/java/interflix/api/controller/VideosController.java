package interflix.api.controller;

import interflix.api.video.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/videos")
public class VideosController {

    @Autowired
    private VideoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroVideo dados){
        repository.save(new Video(dados));
    }

    @GetMapping
    public Page<DadosListagemVideos> listar(@PageableDefault(size = 10, sort = {"titulo"}) Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemVideos::new);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemVideos> buscarPorId(@PathVariable Long id) {
        Optional<Video> video = repository.findById(id);

        if (video.isPresent()) {
            return ResponseEntity.ok(new DadosListagemVideos(video.get()));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizaVideo dados){
        var video = repository.getReferenceById(dados.id());
        video.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        var video = repository.getReferenceById(id);
        video.excluir();
    }

}
