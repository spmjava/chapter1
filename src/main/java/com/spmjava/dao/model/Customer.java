package com.spmjava.dao.model;

import lombok.Data;

/**
 * @author 齐伟超
 * @date 2018-09-04 15:20
 * @since 1.0.0
 **/
@Data
public class Customer {
    private Long id;
    private String name;
    private String telephone;
    private String remark;
    private String contact;
    private String email;

}
