package reactusing_spring.reactusing_spring.controller;

import org.springframework.web.bind.annotation.RestController;

import reactusing_spring.reactusing_spring.model.Register;
import reactusing_spring.reactusing_spring.service.RegisterService;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class RegisterController {
    
    private RegisterService registerService;

    public RegisterController(RegisterService registerService) {
        this.registerService = registerService;
    }

    @PostMapping("/user")
    public ResponseEntity<Register> postMethodName(@RequestBody Register register) {
        
        if(registerService.safe(register)==false)
        {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }
    

    @GetMapping("/user")
    public List<Register> getMethodName() {
        return registerService.MethodName();
    }
    


    @GetMapping("/user/{username}")
    public Optional<Register> getMethod(@PathVariable String  name) {
        return registerService.Alldetail(name);
    }


    @PutMapping("/user/{username}")
    public ResponseEntity<Register> Update(@PathVariable String username, @RequestBody Register register) {

        if(registerService.updatedetail(username,register))
        {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
    }


    @DeleteMapping("/user/{username}")
    public ResponseEntity<Register> DeleteAll(@PathVariable String username)
    {

        if(registerService.deleteAll(username))
        {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);

    }
    
}
