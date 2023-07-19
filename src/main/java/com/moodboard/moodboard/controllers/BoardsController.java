package com.moodboard.moodboard.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	  public Board findById(@PathVariable Long id ){
		  
		  Optional<Board> board = Repository.findById(id);
		  
		  return board.orElseThrow();
		  
	  }
	  
	  @PostMapping
	  public void addBoardData(@RequestBody Board b ) {
		   
		  Repository.save(b);
		  
	  }
	  
	@DeleteMapping(value = "/{id}")
	public void deleteBoard(@PathVariable Long id ) {
		
		Repository.deleteById(id);
	}
	
	@PutMapping(value = "/{id}")
	public void updateBoard(@PathVariable Long id, @RequestBody Board b ) {
		
		Board obj = findById(id);
		
		obj.setDescription(b.getDescription());
		obj.setImgUrl(b.getImgUrl());
		
		Repository.save(obj);
		
		
	}
	  
	  
	
}
