package com.arpanbags.accounts.arpanbagsaccounts.service;


import com.arpanbags.accounts.arpanbagsaccounts.dto.AccountDTO;
import com.arpanbags.accounts.arpanbagsaccounts.exception.AccountNameAlreadyExists;
import com.arpanbags.accounts.arpanbagsaccounts.exception.AccountNameDoesNotExist;
import com.arpanbags.accounts.arpanbagsaccounts.mapper.AccountMapper;
import com.arpanbags.accounts.arpanbagsaccounts.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public void createAccount(AccountDTO accountDTO) {
        accountRepository.findByAccountName(accountDTO.getAccountName())
                .ifPresent(account -> {
                    throw new AccountNameAlreadyExists(" AccountName already exists !! ");
                 });
        accountRepository.save(AccountMapper.mappingDTOtoEntity(accountDTO));
    }

    public List<AccountDTO> getAllAccountsData() {
        List<AccountDTO> listAccount = new ArrayList<>();
        accountRepository.findAll().forEach(account ->
                listAccount.add(AccountMapper.mappingEntityToDTO(account)));
        return listAccount;
    }

    public AccountDTO updateAccountDetails(AccountDTO accountDTO){
        accountRepository.findByAccountName(accountDTO.getAccountName())
                .ifPresent(account -> {
                    account.setAccountName(accountDTO.getAccountName());
                    account.setAccountNumber(accountDTO.getAccountNumber());
                    accountRepository.save(account);
                });
        return  accountDTO;
    }


    public void deleteById(Long id){
        AccountDTO accountDTO = findByAccountName(
                accountRepository.findById(id).get().getAccountName());
       if(Objects.nonNull(accountDTO)){
           accountRepository.deleteById(accountDTO.getId());
       }else{
           throw new AccountNameDoesNotExist("Id is not present.!!");
       }
    }

    public AccountDTO  findByAccountName(String accountName){
        return AccountMapper.mappingEntityToDTO(accountRepository.findByAccountName(accountName)
                .orElseThrow(()->
                  new AccountNameDoesNotExist(" Account Name does not exist !!")));
    }


/**
 *
 * During Update
 *  .orElseThrow(()->  new AccountNameAlreadyExists(" AccountName already exists !! "));
 */
}
