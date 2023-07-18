package com.moodboard.moodboard.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moodboard.moodboard.entities.Board;
import com.moodboard.moodboard.repositories.BoardRepository;

@RestController
@RequestMapping(value = "/boards")
public class BoardsController {
	
	@Autowired
	private BoardRepository Repository;
	
	  @GetMapping 
	  public ResponseEntity<List<Board>> findAll(){
		  	
		  List<Board> List = Repository.findAll();
		  return ResponseEntity.ok().body(List);
	  }
	 
	  @GetMapping(value = "/{id}")
	  
	  public ResponseEntity<Optional<Board>> findById(@PathVariable Long id ){
		  
		  return ResponseEntity.ok(Repository.findById(id));
	  }
	  
	  
	
}