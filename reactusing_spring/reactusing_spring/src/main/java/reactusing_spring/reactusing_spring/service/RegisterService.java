package reactusing_spring.reactusing_spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import reactusing_spring.reactusing_spring.model.Register;
import reactusing_spring.reactusing_spring.repository.RegisterRepo;

@Service
public class RegisterService {
    
    private RegisterRepo registerRepo;

    public RegisterService(RegisterRepo registerRepo) {
        this.registerRepo = registerRepo;
    }


    public boolean safe(@RequestBody Register register)
    {
        try{
            registerRepo.save(register);
        }
        catch(Exception e)
        {
            System.out.print(e.getMessage());
            return false;
        }
        return true;
    }
    
    public List<Register>MethodName()
    {
        return registerRepo.findAll();
    }


    public Optional<Register> Alldetail(String name)
    {
        return registerRepo.findById(name);
    }


    public boolean updatedetail(String name,Register register)
    {
        if(this.Alldetail(name)==null)
        {
            return false;
        }
        registerRepo.save(register);
        return true;
    }

    public boolean deleteAll(String name)
    {
        if(this.Alldetail(name)==null)
        {
            return false;
        }
        registerRepo.deleteById(name);
        return true;
    }


}
