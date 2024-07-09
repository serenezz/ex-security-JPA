package serenezz.securityjpa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    @GetMapping("/allusers")
    public ResponseEntity<?> getAPI1() {
        return ResponseEntity.ok().body("Open to all users.");
    }

    @GetMapping("/manager")
    @PreAuthorize("hasAnyRole('ROLE_MANAGER','ROLE_ADMIN')")
    public ResponseEntity<?> getAPI2(Principal principal) {
        return ResponseEntity.ok().body(principal.getName() + " : is accessing manager api");
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> getAPI3(Principal principal) {
        return ResponseEntity.ok().body(principal.getName() + " : is accessing admin api");
    }

}
