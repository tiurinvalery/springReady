package service;

import com.yopselmopsel.service.model.Client;
import com.yopselmopsel.service.repo.ClientRepository;
import com.yopselmopsel.service.service.ClientService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.LinkedList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:root-context.xml"})
public class ClientServiceTest extends Assert {
    private static Logger logger = LoggerFactory.getLogger(ClientServiceTest.class);
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ClientService clientService;

    @Before
    public void initMockCompany() {
        logger.info("init");
    }

    @Test
    public void checkCRUDGoodService() throws Exception {
        logger.info("test");
    }

    @Test
    public void checkClientCreate() throws Exception {
        Client client = new Client();
        client.setName("1");
        client.setOrderSet(null);
        clientService.createClient(client);
        Client test = clientService.findClientByName(client.getName());
        assertTrue(test!=null);
    }

    @Test
    public void checkClientsCreate() throws Exception {
        Client client1 = new Client();
        client1.setName("client1");
        client1.setOrderSet(null);

        Client client2 = new Client();
        client2.setName("client2");
        client2.setOrderSet(null);

        List<Client> clientsListForCreate = new LinkedList<>();
        clientsListForCreate.add(client1);
        clientsListForCreate.add(client2);

        clientService.createClients(clientsListForCreate);

        Client test1 = clientService.findClientByName(client1.getName());
        Client test2 = clientService.findClientByName(client2.getName());

        assertTrue(test1!=null && test2!=null);
    }

    @Test
    public void checkClientUpdate() {
        Client client = new Client();
        client.setName("3");
        client.setOrderSet(null);
        clientService.createClient(client);
        client.setName("2");
        clientService.updateClient(client);
        Client test = clientService.findClientByName(client.getName());
        assertTrue(test.getName().equals(client.getName()));
    }

    @Test
    public void checkClientsUpdate() throws Exception {
        Client client1 = new Client();
        client1.setName("client1");
        client1.setOrderSet(null);

        Client client2 = new Client();
        client2.setName("client2");
        client2.setOrderSet(null);

        List<Client> clientsListForCreate = new LinkedList<>();
        clientsListForCreate.add(client1);
        clientsListForCreate.add(client2);

        clientService.createClients(clientsListForCreate);

        client1.setName("updative_client_name");
        client2.setName("new_name");

        List<Client> clientListForUpdate = new LinkedList();
        clientListForUpdate.add(client1);
        clientListForUpdate.add(client2);
        clientService.updateClients(clientListForUpdate);

        Client test1 = clientService.findClientByName(client1.getName());
        Client test2 = clientService.findClientByName(client2.getName());

        assertTrue(client1.getName().equals(test1.getName())&&client2.getName().equals(test2.getName()));
    }

    @Test
    public void checkDeleteClient() throws Exception {
        Client client = new Client();
        client.setName("1");
        client.setOrderSet(null);
        clientService.createClient(client);
        clientService.deleteClient(client);
        Client test = clientService.findClientByName(client.getName());
        assertTrue(null==test);
    }

    @Test
    public void checkClientsDelete() throws Exception {
        Client client1 = new Client();
        client1.setName("client1");
        client1.setOrderSet(null);

        Client client2 = new Client();
        client2.setName("client2");
        client2.setOrderSet(null);

        List<Client> clientsListForCreate = new LinkedList<>();
        clientsListForCreate.add(client1);
        clientsListForCreate.add(client2);

        clientService.createClients(clientsListForCreate);

        List<Client> deleteList = new LinkedList<>();
        deleteList.add(client1);
        deleteList.add(client2);

        clientService.deleteClients(deleteList);
        Client test1 = clientService.findClientByName(client1.getName());
        Client test2 = clientService.findClientByName(client2.getName());

        assertTrue(test1==null && test2==null);
    }

    @Test
    public void checkFindClientByName() {
        Client client = new Client();
        client.setName("name");
        client.setOrderSet(null);
        clientService.createClient(client);

        Client test = clientService.findClientByName(client.getName());
        assertTrue(client.getName().equals(test.getName()));
    }
}
