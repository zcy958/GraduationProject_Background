package com.niit.gamecenter_pojo.page.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageVo<T> {
    private List<T> rows;
    private Integer total;
}
