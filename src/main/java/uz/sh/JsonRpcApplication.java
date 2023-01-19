package uz.sh;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.googlecode.jsonrpc4j.*;
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImpl;
import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceImplExporter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.*;

@SpringBootApplication
public class JsonRpcApplication {

    public static void main(String[] args) {
        SpringApplication.run(JsonRpcApplication.class, args);
    }

    @Bean
    public AutoJsonRpcServiceImplExporter autoJsonRpcServiceImplExporter() {
        AutoJsonRpcServiceImplExporter exp = new AutoJsonRpcServiceImplExporter();
        exp.setContentType(MediaType.APPLICATION_JSON_VALUE);
        exp.setErrorResolver(((throwable, method, list) -> {
            ErrorMessage error;
            try {
                error = (ErrorMessage) throwable;
            } catch (Throwable throwable1) {
                error = new ErrorMessage(-32603, "Internal error");
            }
            return new ErrorResolver.JsonError(error.getCode(), error.getMessage(), error.getData());
        }));
        exp.setHttpStatusCodeProvider(new CustomHttpStatusCodeProvider());
        return exp;
    }
}













