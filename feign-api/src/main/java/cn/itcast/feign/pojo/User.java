package cn.itcast.feign.pojo;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String userName;
    private String address;
}