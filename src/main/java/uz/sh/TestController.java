package uz.sh;

import com.googlecode.jsonrpc4j.JsonRpcMethod;
import com.googlecode.jsonrpc4j.JsonRpcParam;
import com.googlecode.jsonrpc4j.JsonRpcService;

import java.util.List;

/**
 * Author: Shoxruh Bekpulatov
 * Time: 11/3/22 5:01 PM
 **/
@JsonRpcService("/api/v1/test")
public interface TestController {

    @JsonRpcMethod("save.user")
    Userjon saveUser(
            @JsonRpcParam(value = "request") Userjon request
    );

    @JsonRpcMethod("get.users")
    List<Userjon> getAll();
}
