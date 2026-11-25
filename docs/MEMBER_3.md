# Member 3 — Database and JDBC (12 classes)

Assigned: `DatabaseConfig`, `DatabaseConnection`, `UserDAO`, `WalletDAO`, `TransactionDAO`, `ExchangeRateDAO`, `WatchlistDAO`, `AlertDAO`, `PortfolioDAO`, `PasswordUtil`, `DatabaseException`, `BackgroundMonitor`.

1. Create TiDB Cloud Starter in **MySQL-compatible** mode at https://tidbcloud.com/.
2. Keep spending limit at 0 for free-tier-only use.
3. From Connect, copy exact public host, port, database, prefixed username and password.
4. Add each teammate's public IP to the IP access list.
5. Download MySQL Connector/J into `lib/mysql-connector-j.jar`.
6. Copy `db.properties.example` to `db.properties`, fill exact values and keep TLS `sslMode=VERIFY_IDENTITY`. Never commit this file.
7. Execute `schema.sql` against the database shown in Connect.
8. Publish DAO method signatures early so Members 1 and 2 can code against agreed interfaces using mocks.

Each teammate creates their own local properties file. Verify all three laptops can connect after IP allowlisting.
