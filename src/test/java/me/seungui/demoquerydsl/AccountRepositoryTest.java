package me.seungui.demoquerydsl;

import static org.junit.jupiter.api.Assertions.*;

import com.querydsl.core.types.Predicate;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
class AccountRepositoryTest {

  @Autowired
  AccountRepository accountRepository;

  @Test
  void crud() {
    Predicate predicate = QAccount.account.firstName.containsIgnoreCase("seungui")
        .and(QAccount.account.lastName.startsWith("jwa"));

    Optional<Account> account = accountRepository.findOne(predicate);
    assertEquals(Optional.empty(), account);
  }
}