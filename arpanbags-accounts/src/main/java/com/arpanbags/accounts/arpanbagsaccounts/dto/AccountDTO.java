package com.arpanbags.accounts.arpanbagsaccounts.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDTO {

   private Long id;
   private String accountName;
   private Integer accountNumber;
}
