package cn.whu.wy.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BankPositionReqMsg {
    String bizNo;
//    LocalDateTime bizTime;

    String bankId;
    String bankAccount;

}
