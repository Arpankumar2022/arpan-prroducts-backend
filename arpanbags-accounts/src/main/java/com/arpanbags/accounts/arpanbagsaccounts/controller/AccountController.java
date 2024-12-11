package com.arpanbags.accounts.arpanbagsaccounts.controller;


import com.arpanbags.accounts.arpanbagsaccounts.dto.AccountDTO;
import com.arpanbags.accounts.arpanbagsaccounts.dto.AccountMessageInfoDTO;
import com.arpanbags.accounts.arpanbagsaccounts.entity.Account;
import com.arpanbags.accounts.arpanbagsaccounts.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class AccountController {

    private final AccountMessageInfoDTO accountMessageInfoDTO;

    private final AccountService accountService;

    @GetMapping("/message")
    public ResponseEntity<AccountMessageInfoDTO> getMessage() {
        return ResponseEntity.status(HttpStatus.OK).body(accountMessageInfoDTO);
    }


    @PostMapping("/create-account")
    public ResponseEntity<String> createAccounts(@RequestBody AccountDTO accountDTO) {
        accountService.createAccount(accountDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Account added successfully !!");
    }

    @GetMapping("/get-accounts")
    public ResponseEntity<List<AccountDTO>> getAllAccountDetails() {
        return ResponseEntity.status(HttpStatus.OK).body(accountService.getAllAccountsData());
    }

    @DeleteMapping("/deleteBy-id/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id")Long id) {
        accountService.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Account Id successfully deleted !!");
    }

    @PutMapping("/update-account")
    public ResponseEntity<AccountDTO> updateAccount(@RequestBody AccountDTO accountDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(accountService
                .updateAccountDetails(accountDTO));
    }

    @GetMapping("/get-account-name/{accountName}")
    public ResponseEntity<AccountDTO> getAllAccountDetails(@PathVariable("accountName") String accountName) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(accountService.findByAccountName(accountName));
    }
}
