package com.portfolio.backend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.portfolio.backend.entity.Client;
import com.portfolio.backend.exception.ResourceNotFoundException;
import com.portfolio.backend.repository.ClientRepository;
import com.portfolio.backend.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService{
	
	private final ClientRepository clientRepository;
	
	public ClientServiceImpl(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@Override
	public Client createClient(Client client) {
		// TODO Auto-generated method stub
		return clientRepository.save(client);
	}

	@Override
	public List<Client> getAllClients() {
		// TODO Auto-generated method stub
		return clientRepository.findAll();
	}

	@Override
	public Client getClientById(Long id) {
		// TODO Auto-generated method stub
		return clientRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Client not found with id " + id));
	}
	@Override
public void deleteClient(Long id) {
    Client client = getClientById(id);
    clientRepository.delete(client);
}


}
