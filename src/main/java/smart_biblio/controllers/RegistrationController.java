package smart_biblio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import smart_biblio.DTO.RegistrationRequest;
import smart_biblio.services.EmailService;

@RestController
@RequestMapping("/api/inscription")
public class RegistrationController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/send")
    public ResponseEntity<String> sendInfo(@RequestBody RegistrationRequest req) {

        String content =
                "Nouvelle inscription :\n\n" +
                "Nom : " + req.getNom() + "\n" +
                "Email : " + req.getEmail() + "\n" +
                "Téléphone : " + req.getTelephone() + "\n" +
                "Adresse : " + req.getAdresse() + "\n" +
                "Message : " + req.getMessage();

        emailService.sendRegistrationEmail(content);

        return ResponseEntity.ok("Informations envoyées à l'administrateur.");
    }
}
