package com.soft1851.spring.web.util;

import com.soft1851.spring.web.entity.GithubSponsors;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/3/21
 * @Version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseObject1 {
    private Integer code;
    private String msg;
    private Object data;

}