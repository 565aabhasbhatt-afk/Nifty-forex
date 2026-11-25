# NiftyForex Project Structure

This project follows the folder organization used by the supplied Banking System Demo reference, while retaining NiftyForex-specific code and features.

- `src/main`: console entry point, menu routing, and console UI.
- `src/model`: domain objects such as Wallet, Currency, Transaction, and PriceAlert.
- `src/service`: application/business workflows.
- `src/dao`: JDBC data-access classes.
- `src/exception`: custom application/database exceptions.
- `src/thread`: background monitor.
- `src/util`: database configuration, password utility, and input helper.
- `database/schema.sql`: TiDB/MySQL-compatible schema and seed exchange rates.
- `config/`: example environment and database configuration files.
- `lib/`: place the MySQL Connector/J JAR here.
- `test/`: location for tests.
- `scripts/`: helper scripts.
- `out/`: compiled `.class` files; generated locally and not committed.

The project remains a plain Java console application and does not add Maven or a GUI.
