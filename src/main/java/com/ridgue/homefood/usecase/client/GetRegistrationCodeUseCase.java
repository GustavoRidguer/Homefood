package com.ridgue.homefood.usecase.client;

import com.ridgue.homefood.database.entity.ClientEntity;
import com.ridgue.homefood.database.repository.facade.ClientRepositoryFacade;
import com.ridgue.homefood.exceptions.ClientAlreadyActivatedException;
import com.ridgue.homefood.exceptions.InvalidClientFieldException;
import com.ridgue.homefood.http.ws.util.SendEmail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class GetRegistrationCodeUseCase {
    private final ClientRepositoryFacade clientRepositoryFacade;
    private final SendEmail email;

    public ClientEntity execute(Long id, String redirection) {
        String token = (UUID.randomUUID() + String.valueOf(id)).substring(0,10);
        ClientEntity clientEntity = clientRepositoryFacade.updateTokenById(id, token);

        email.send(
                "guferrari007@gmail.com",
                "Activate account in Homefood.",
                "Hello " + clientEntity.getName() + "!\n" +
                "This is your token code: " + token + "\n" +
                "To activate your account, go to: " + redirection + " and insert your token code");

        return clientEntity;
    }

//    public String execute(Long id, String redirection) {
////        ClientEntity clientById = clientRepositoryFacade.findById(id);
////        System.out.println("Find CLient : " + clientById.toString());
////
////        if (clientById.isActive()) throw new ClientAlreadyActivatedException();
//
//        String token = (UUID.randomUUID() + String.valueOf(id)).substring(0,10);
//        System.out.println("Generated token : " + token);
////        clientById.setToken(token);
////        System.out.println("Client : " + clientById.toString());
//        ClientEntity clientEntity = clientRepositoryFacade.updateTokenById(id, token);
//        System.out.println("Client after update : " + clientEntity.toString());
//
//        email.send(
//                "guferrari007@gmail.com",
//                "Activate account in Homefood.",
//                "Hello " + clientEntity.getName() + "!\n" +
//                        "This is your token code: " + token + "\n" +
//                        "To activate your account, go to: " + redirection + " and insert your token code");
//
//        System.out.println("---------- END GetTokenUseCase() ----------");
//        return token;
//    }
}
