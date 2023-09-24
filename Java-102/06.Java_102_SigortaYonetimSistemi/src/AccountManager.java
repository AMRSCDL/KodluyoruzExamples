import java.util.*;
public class AccountManager {
    private TreeSet<Account> accounts;
    private Map<String, Account> accountCache;

    public AccountManager() {
        accounts = new TreeSet<>();
        accountCache = new HashMap<>();
    }

    public Account login(String email, String password) throws InvalidAuthenticationException {
        if (accountCache.containsKey(email)) {
            Account cachedAccount = accountCache.get(email);
            if (cachedAccount.loginUser(email, password) == AuthenticationStatus.SUCCESS) {
                return cachedAccount;
            }
        }

        for (Account account : accounts) {
            try {
                if (account.loginUser(email, password) == AuthenticationStatus.SUCCESS) {
                    accountCache.put(email, account);
                    return account;
                }
            } catch (InvalidAuthenticationException e) {
            }
        }
        return null;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
        accountCache.remove(account.getUser().getEmail());
    }
}
