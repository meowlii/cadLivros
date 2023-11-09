package AtivFormativa.prj.servicie;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senai.melissa.PrjGame.entities.Jogo;

@Service
public class LivroService {
	
	private final LivroRepository livroRepository;
	
	@Autowired
	public LivroService(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}
	
	public Livro saveLivro(Livro livro) {
		return livroRepository.save(livro);
	}
	
	public Livro getLivroById(Long Id) {
		return LivroRepository.findById(Id).orElse(null);
	}
	
	public List<Livro> getAllLivros() {
		return livroRepository.findAll();
	}
	
	public void deleteLivro(Long id) {
		livroRepository.deleteById(id);
	}
	
	public Livro updateLivro(Long id, Livro novoLivro) {
        Optional<Livro> LivroOptional = livroRepository.findById(id);
        if (livroOptional.isPresent()) {
        	Livro livroExistente = livroOptional.get();
           	livroExistente.setName(novoLivro.getName());
        	livroExistente.setPlataform(novoLivro.getPlataform());          
            return livroRepository.save(livroExistente); 
        } else {
            return null; 
        }
    }
}