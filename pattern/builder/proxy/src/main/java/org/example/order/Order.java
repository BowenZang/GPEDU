package org.example.order;

import lombok.Data;
import lombok.ToString;

/**
 * @author 003169
 * @since Create by BowenZang on 2020-06-18 15:31:39
 */
@Data
@ToString
public class Order {
    private Long id;
    private String orderInfo;
}
