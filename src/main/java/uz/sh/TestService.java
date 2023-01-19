package uz.sh;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Shoxruh Bekpulatov
 * Time: 11/3/22 5:02 PM
 **/
@AutoJsonRpcServiceImpl
@Service
public class TestService implements TestController {

    private final UserJonRepo userJonRepo;

    TestService(UserJonRepo userJonRepo) {
        this.userJonRepo = userJonRepo;
    }

    @Override
    public Userjon saveUser(Userjon request) {
        return userJonRepo.save(request);
    }

    @Override
    public List<Userjon> getAll() {
        return userJonRepo.findAll();
    }
}
