package com.client.clientcrud;
import com.client.clientcrud.entity.Client;
import com.client.clientcrud.repo.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ClientDataInitializer implements CommandLineRunner {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientDataInitializer(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create and save three different clients
        Client client1 = new Client();
        client1.setName("Client 1");
        client1.setAddress("Address 1");
        clientRepository.save(client1);

        Client client2 = new Client();
        client2.setName("Client 2");
        client2.setAddress("Address 2");
        clientRepository.save(client2);

        Client client3 = new Client();
        client3.setName("Client 3");
        client3.setAddress("Address 3");
        clientRepository.save(client3);

        System.out.println("Three clients have been created and saved.");
    }
}
