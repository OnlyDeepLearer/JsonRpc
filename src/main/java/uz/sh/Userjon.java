package uz.sh;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Author: Shoxruh Bekpulatov
 * Time: 11/3/22 5:02 PM
 **/
@Entity
@Getter
@Setter
public class Userjon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;
}
