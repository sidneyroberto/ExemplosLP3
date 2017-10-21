package br.edu.ifms.lp3.lojalp3.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.lp3.lojalp3.model.Cliente;
import br.edu.ifms.lp3.lojalp3.repository.ClienteRepository;

@RestController
@CrossOrigin("${origem-permitida}")
public class ClienteResource {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@GetMapping("/clientes")
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}
	
	@PostMapping("/clientes")
	public Cliente adicionar(@RequestBody @Valid Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PutMapping("/clientes")
	public ResponseEntity atualizar(@RequestBody @Valid Cliente cliente) {
		Long id = cliente.getId();
		if(id == null) {
			return new ResponseEntity("id nulo", HttpStatus.BAD_REQUEST);
		}
		if(clienteRepository.findOne(id) == null) {
			return new ResponseEntity("Cliente não encontrado", HttpStatus.NOT_FOUND);
		}
		cliente = clienteRepository.save(cliente);
		return new ResponseEntity(cliente, HttpStatus.OK);
	}
	
	@GetMapping("/clientes/{id}")
	public Cliente recupera(@PathVariable("id") Long id) {
		return clienteRepository.findOne(id);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@DeleteMapping("/clientes/{id}")
	public ResponseEntity remove(@PathVariable("id") Long id) {
		Cliente cliente = clienteRepository.findOne(id);
		if(cliente == null) {
			return new ResponseEntity("Cliente não encontrado", HttpStatus.NOT_FOUND);
		}
		clienteRepository.delete(cliente);
		return new ResponseEntity(id, HttpStatus.OK);
	}
}
