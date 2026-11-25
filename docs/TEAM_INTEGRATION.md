# Team Integration — TiDB Cloud Starter

- Use TiDB Cloud Starter in **MySQL-compatible** mode, not PostgreSQL mode.
- Keep monthly spending limit at 0 if a strictly free project is required. Monitor free quota.
- In the cluster Connect dialog, copy exact public host, port, database, prefixed username and password.
- Add all three teammates' public IPs to the IP access list. Public Starter connections require TLS.
- Each laptop needs JDK 26, MySQL Connector/J in `lib/mysql-connector-j.jar`, and its own untracked `src/main/resources/db.properties`. Keep `sslMode=VERIFY_IDENTITY`.
- Execute `schema.sql` against the database selected in Connect. Do not assume a database named `forex_db`.
- Branches: `member1-auth`, `member2-forex`, `member3-database`. Push only to your branch; merge through reviewed Pull Requests.
- Agree DAO method signatures before service integration. Members 1 and 2 can use mock data while Member 3 builds persistence.
- Never commit credentials, `db.properties`, or passwords.
