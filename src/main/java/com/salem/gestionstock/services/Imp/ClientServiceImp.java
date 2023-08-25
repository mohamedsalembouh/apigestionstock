package com.salem.gestionstock.services.Imp;

import com.salem.gestionstock.dto.ClientDto;
import com.salem.gestionstock.exceptions.EntityNotFoundException;
import com.salem.gestionstock.exceptions.ErrorCodes;
import com.salem.gestionstock.exceptions.InvalidEntityException;
import com.salem.gestionstock.repository.ClientRepository;
import com.salem.gestionstock.services.ClientService;
import com.salem.gestionstock.validator.ClientValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClientServiceImp implements ClientService {
    ClientRepository clientRepository;
    @Autowired
    public ClientServiceImp(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public ClientDto save(ClientDto clientDto) {
        List<String> errors = ClientValidator.validate(clientDto);
        if(!errors.isEmpty()){
            log.error("Invalid client");
            throw new InvalidEntityException("client not found", ErrorCodes.CLIENT_NOT_FOUND,errors);
        }
        return ClientDto.fromEntity(clientRepository.save(ClientDto.toEntity(clientDto)));
    }

    @Override
    public ClientDto findById(Integer id) {
        if(id == null){
            log.error("id is null");
            return null;
        }
        return clientRepository.findById(id).map(ClientDto::fromEntity).orElseThrow(
                () -> new EntityNotFoundException("id = "+id+"n'a pas trouve",ErrorCodes.CLIENT_NOT_FOUND)
        );
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream().map(ClientDto::fromEntity).collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
    if(id == null){
        log.error("id is null");
        return;
    }
    clientRepository.deleteById(id);
    }
}
