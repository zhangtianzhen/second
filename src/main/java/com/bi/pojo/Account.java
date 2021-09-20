package com.bi.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 狗头军师@Yeah~2021
 * @Date 2021/9/9 21:26
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    public int id;
    public String name;
    public int money;
}
