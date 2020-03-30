package com.soft1851.spring.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;

/**
 * @Description TODO
 * @Author wf
 * @Date 2020/3/28
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GithubSponsors {
    private Integer id;
    private String avatar;
    private String authorName;
    private String description;
}
