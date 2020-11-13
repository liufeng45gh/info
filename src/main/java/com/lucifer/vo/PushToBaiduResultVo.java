package com.lucifer.vo;

import lombok.Data;

import java.util.List;

@Data
public class PushToBaiduResultVo {
    Integer success;
    Integer remain;
    List not_same_site;
    List not_valid;
}
