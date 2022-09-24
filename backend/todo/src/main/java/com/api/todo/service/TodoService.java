package com.api.todo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.api.todo.entity.Todo;
import com.api.todo.repository.TodoRepository;
import com.api.todo.service.exception.MyObjectNotFoundException;

@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;
	
	public Todo findById(Integer id) {
		Optional<Todo> obj = todoRepository.findById(id);
		return obj.orElseThrow(() -> new MyObjectNotFoundException("Objeto " + id + " não encontrado do tipo " + Todo.class.getName()));
	}

	public List<Todo> findAllOpen() {
		List<Todo> list = todoRepository.findAllOpen();
		return list;
	}

	public List<Todo> findAllClose() {
		List<Todo> list = todoRepository.findAllClose();
		return list;
	}

	public List<Todo> findAll() {
		List<Todo> list = todoRepository.findAll();
		return list;
	}

	public Todo create(Todo todo) {
		todo.setId(null);
		return todoRepository.save(todo);
	}

	public void delete(Integer id) {
		todoRepository.deleteById(id);		
	}

	public Todo update(Integer id, Todo todo) {
		Todo newTodo = findById(id);
		newTodo.setTitulo(todo.getTitulo());
		newTodo.setDataParaFinalizar(todo.getDataParaFinalizar());
		newTodo.setDescricao(todo.getDescricao());
		newTodo.setFinalizado(todo.getFinalizado());
		return todoRepository.save(newTodo);
	}

}
