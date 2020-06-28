package com.dcx.minicurso.restapispring.controllers;

import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import com.dcx.minicurso.restapispring.models.Disciplina;
import com.dcx.minicurso.restapispring.services.DisciplinaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;


    @GetMapping
    public ResponseEntity<List<Disciplina>> getDisciplinas() {
        return new ResponseEntity<List<Disciplina>>(disciplinaService.getAllDisciplinas(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> getDisciplina(@PathVariable int id) {
        
        try {
            return new ResponseEntity<Disciplina>(disciplinaService.findById(id), HttpStatus.OK);

        } catch (ArrayIndexOutOfBoundsException exception) {
            return new ResponseEntity<Disciplina>(new Disciplina(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Disciplina> addDisciplina(@Valid @RequestBody Disciplina disciplina) {
        return new ResponseEntity<Disciplina>(disciplinaService.addDisciplina(disciplina), HttpStatus.CREATED);
    }

    @PutMapping("/{id}/nome")
    public ResponseEntity<Disciplina> updateDisciplina(@PathVariable int id, @Valid @RequestBody Disciplina disciplina) {
        
        try {
            return new ResponseEntity<Disciplina>(disciplinaService.updateDisciplina(id, disciplina), HttpStatus.OK);

        } catch (ArrayIndexOutOfBoundsException exception) {
            return new ResponseEntity<Disciplina>(new Disciplina(), HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Disciplina> deleteDisciplina(@PathVariable int id) {

        try {
            return new ResponseEntity<Disciplina>(disciplinaService.deleteDisciplina(id), HttpStatus.OK);

        } catch (ArrayIndexOutOfBoundsException exception) {
            return new ResponseEntity<Disciplina>(new Disciplina(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/ranking")
    public ResponseEntity<List<Disciplina>> getRanking() {
        List<Disciplina> disciplinas = disciplinaService.getAllDisciplinas();

        Collections.sort(disciplinas);
        Collections.reverse(disciplinas);

        return new ResponseEntity<List<Disciplina>>(disciplinas, HttpStatus.OK);
    }

}