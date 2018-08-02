package me.wenchao.javapro.comm.rmi;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Author wenchaofu
 * @DATE 14:24 2018/7/23
 * @DESC
 */

@Data
@ToString
public class User implements Serializable{

    private static final long serialVersionUID = 2L;
    private String userName;
    private String userDesc;
    private String userAge;
    private String userSex;
}
