package com.dcx.minicurso.restapispring.services;

import java.util.ArrayList;
import java.util.List;

import com.dcx.minicurso.restapispring.models.Disciplina;

import org.springframework.stereotype.Service;

@Service
public class DisciplinaService {

    private List<Disciplina> disciplinas = new ArrayList<>();

    
    public List<Disciplina> getAllDisciplinas() {
        return disciplinas;
    }

    public Disciplina findById(int id) {
        if (disciplinas.isEmpty() || id < 0 || id >= disciplinas.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return disciplinas.get(id);
    }

    public Disciplina addDisciplina(Disciplina disciplina) {
        disciplina.setId(disciplinas.size());
        disciplinas.add(disciplina);

        return disciplinas.get(disciplinas.size() - 1);
    }

    public Disciplina updateDisciplina(int id, Disciplina disciplina) throws ArrayIndexOutOfBoundsException {
        findById(id);

        disciplina.setId(id);
        disciplinas.set(id, disciplina);

        return disciplina;
    }

    public Disciplina deleteDisciplina(int id) throws ArrayIndexOutOfBoundsException {
        findById(id);

        return disciplinas.remove(id);
    }


}