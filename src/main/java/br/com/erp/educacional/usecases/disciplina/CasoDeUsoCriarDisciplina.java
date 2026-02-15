package br.com.erp.educacional.usecases.disciplina;

import br.com.erp.educacional.domain.entity.disciplina.Disciplina;
import br.com.erp.educacional.domain.repository.disciplina.DisciplinaRepository;
import br.com.erp.educacional.infrastructure.database.model.DisciplinaModel;

public class CasoDeUsoCriarDisciplina {
    private final DisciplinaRepository disciplinaRepo;

    public CasoDeUsoCriarDisciplina(DisciplinaRepository disciplinaRpo) {
        this.disciplinaRepo = disciplinaRpo;
    }

    public void execute(String nome) {
        Disciplina disciplina = new Disciplina();
        disciplina.setNome(nome);
        CasoDeUsoVerificarSeDisciplinaExiste casoDeUsoVerificarSeDisciplinaExiste = new CasoDeUsoVerificarSeDisciplinaExiste(disciplinaRepo);
        if (!casoDeUsoVerificarSeDisciplinaExiste.execute(nome)) {
            disciplinaRepo.save(disciplina);
        }
    }
}
