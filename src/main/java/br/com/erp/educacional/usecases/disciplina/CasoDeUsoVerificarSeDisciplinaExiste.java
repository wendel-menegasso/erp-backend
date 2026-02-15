package br.com.erp.educacional.usecases.disciplina;

import br.com.erp.educacional.domain.entity.disciplina.Disciplina;
import br.com.erp.educacional.domain.repository.disciplina.DisciplinaRepository;
import br.com.erp.educacional.infrastructure.database.model.DisciplinaModel;

public class CasoDeUsoVerificarSeDisciplinaExiste {
    private final DisciplinaRepository disciplinaRepo;

    public CasoDeUsoVerificarSeDisciplinaExiste(DisciplinaRepository disciplinaRpo) {
        this.disciplinaRepo = disciplinaRpo;
    }

    public boolean execute(String nome) {
        Disciplina disciplina = new Disciplina();
        disciplina.setNome(nome);
        return disciplinaRepo.disciplinaExiste(disciplina);
    }
}
