package br.com.etechoracio.boa_viagem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.etechoracio.boa_viagem.entity.Viagem;
import br.com.etechoracio.boa_viagem.repository.ViagemRepository;

@Service
public class ViagemService {
	@Autowired
	private ViagemRepository repository;
	
	
	public List<Viagem> listarTodos(){
	return repository.findAll();
	}
	
	
	public Optional<Viagem> buscarPorID( long id) {
		return repository.findById(id); 
			
	}
		
	
	public boolean deletarID( long id) {
		boolean existe = repository.existsById(id);
		if(existe) {
			 repository.deleteById(id);		 
		} 
        	return existe;
	}
	
	
	public Viagem inserir( Viagem obj) {
 		return repository.save(obj);
 		 
 	
	}
	
	public Optional<Viagem> atualizar( Long id, Viagem viagem) {
		boolean existe = repository.existsById(id);
		
		if(!existe) {
			 return Optional.empty();
			 
		}
		
		return Optional.of(repository.save(viagem));
		
	}
}
