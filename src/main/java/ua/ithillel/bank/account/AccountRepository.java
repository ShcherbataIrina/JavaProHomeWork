package ua.ithillel.bank.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.ithillel.bank.person.Person;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByPerson(Person person);

    Optional<Account> findByUid(String id);
    Optional<Account> findByIban(String iban);
}
