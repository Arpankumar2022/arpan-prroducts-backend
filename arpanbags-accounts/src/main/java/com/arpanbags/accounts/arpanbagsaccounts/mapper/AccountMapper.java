package com.arpanbags.accounts.arpanbagsaccounts.mapper;

import com.arpanbags.accounts.arpanbagsaccounts.dto.AccountDTO;
import com.arpanbags.accounts.arpanbagsaccounts.entity.Account;

import java.time.LocalDateTime;

public class AccountMapper {

    /**
     *  MapStruct and other Mapper library we can use and officially Spring recommend lombok only
     *
     * @param accountEntity
     * @return
     */
    public static AccountDTO mappingEntityToDTO(Account accountEntity){
        return new AccountDTO(accountEntity.getId(),accountEntity.getAccountName(),
                accountEntity.getAccountNumber());
    }

    public static Account mappingDTOtoEntity(AccountDTO accountDTO){
        Account accountEntity =  new Account(accountDTO.getId(),accountDTO.getAccountName(),
                accountDTO.getAccountNumber());
        accountEntity.setCreatedBy("Arpan");
        accountEntity.setCreatedAt(LocalDateTime.now());
        accountEntity.setUpdatedAt(LocalDateTime.now());
        return accountEntity;
    }

}
