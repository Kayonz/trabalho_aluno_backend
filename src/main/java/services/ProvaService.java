package services;

import models.ProvaModel;
import repository.ProvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvaService {

    @Autowired
    private ProvaRepository provaRepository;

    public List<ProvaModel> listarTodos() {
        return provaRepository.findAll();
    }

    public Optional<ProvaModel> buscarPorId(Long id) {
        return provaRepository.findById(id);
    }

    public ProvaModel salvar(ProvaModel provaModel) {
        return provaRepository.save(provaModel);
    }

    public ProvaModel atualizar(Long id, ProvaModel provaModelAtualizado) {
        return provaRepository.findById(id)
                .map(provaModel -> {
                    provaModel.setNome(provaModelAtualizado.getNome());
                    provaModel.setCurso(provaModelAtualizado.getCurso());
                    provaModel.setTelefone(provaModelAtualizado.getTelefone());
                    return provaRepository.save(provaModel);
                })
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado com id: " + id));
    }

    public void deletar(Long id) {
        provaRepository.deleteById(id);
    }
}


