package com.donus.fin.presenter.http.entrypoint;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerEntrypoint {
		
	@GetMapping(value = "/{id}")
	public ResponseEntity<?> getCustomerByCpf(@PathVariable Integer id){
		return (ResponseEntity<?>) ResponseEntity.ok();
	}

}
