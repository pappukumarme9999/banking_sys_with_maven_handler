package com.pappu.banking.observer;

import com.pappu.banking.model.Account;

public interface AccountObserver {
    void update(Account account);
}
