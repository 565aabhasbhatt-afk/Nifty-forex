

JAI HIND

# NiftyForex — Console-Based Forex Wallet & Trading Simulator

A plain Java console application using JDBC and a TiDB Cloud (MySQL-compatible) database. The project remains non-Maven/non-Gradle and has no graphical interface. Exchange rates are sample/static values and transactions are simulated for academic use.

## Project structure

```text
NiftyForex/
├── config/                 # Example database/environment configuration
├── database/               # SQL schema and sample exchange rates
├── docs/                   # Team responsibilities and project documentation
│   └── diagrams/           # NiftyForex diagrams
├── lib/                    # Place MySQL Connector/J JAR here
├── src/
│   ├── dao/                 # JDBC data access objects
│   ├── exception/           # Custom exceptions
│   ├── main/                # Main class, console UI, menu routing
│   ├── model/               # Wallet, Currency, Transaction, etc.
│   ├── service/             # Business logic
│   ├── thread/              # Background monitor
│   └── util/                # Configuration, password and input utilities
├── test/                    # Test plans and future automated tests
├── scripts/                 # PowerShell helper scripts
├── out/                     # Generated class files (not committed)
├── .gitignore
├── CLASS_COUNT.txt
└── README.md
```

This organization follows the supplied Banking System Demo reference project's package separation, while keeping NiftyForex-specific code.

## Requirements
- JDK 21 or later (the source is compatible with the project's JDK 26 target).
- MySQL Connector/J JAR: https://dev.mysql.com/downloads/connector/j/
- TiDB Cloud MySQL-compatible cluster, or a compatible MySQL server.
- MySQL Workbench is optional; TiDB SQL Editor can also execute the schema.

## 1. Add MySQL Connector/J
Download the platform-independent Connector/J archive, extract it, and copy its `.jar` file into `lib/`. For example:

```text
lib/mysql-connector-j-9.x.x.jar
```

The JAR is intentionally not bundled in this ZIP. Each teammate should download it separately; `lib/*.jar` is ignored by Git.

## 2. Configure the database (only needed for database features)
Copy `config/database.properties.example` to `config/database.properties`, then replace the placeholders with the exact connection values shown by your TiDB/MySQL provider. Example:

```properties
DB_URL=jdbc:mysql://YOUR_TIDB_HOST:4000/test?sslMode=VERIFY_IDENTITY&connectionTimeZone=UTC
DB_USER=YOUR_CLUSTER_PREFIX.root
DB_PASSWORD=YOUR_TIDB_PASSWORD
```

You can alternatively set environment variables named `DB_URL`, `DB_USER`, and `DB_PASSWORD`. Environment variables override the properties file. Keep real credentials private; `config/database.properties` is ignored by Git. Do not use the MySQL root account for shared team access; create restricted individual users where supported.

## 3. Create database tables
Connect to your database using TiDB SQL Editor or MySQL Workbench. Select the database/schema supplied by your provider and execute `database/schema.sql`. The script creates NiftyForex tables and inserts sample exchange rates.

## 4. Compile and run — Windows PowerShell
Run these commands from the NiftyForex project root.

**Compile (does not require a database or Connector/J):**
```powershell
New-Item -ItemType Directory -Force out | Out-Null
$files = Get-ChildItem -Recurse src -Filter *.java
javac -encoding UTF-8 -d out $files.FullName
```

**Run the console menu without configuring the database:**
```powershell
java -cp "out;config" forex.main.Main
```

The menu should launch, but registration, login, exchange-rate retrieval, wallet, transaction, watchlist, alert and portfolio operations require a working database connection.

**Run with database support:**
```powershell
java -cp "out;lib/*;config" forex.main.Main
```

Ensure the Connector/J JAR is in `lib/` and `config/database.properties` is configured before selecting database-dependent features.

## 5. Compile and run — macOS/Linux
```bash
mkdir -p out
find src -name '*.java' > sources.txt
javac -encoding UTF-8 -d out @sources.txt
java -cp "out:config" forex.main.Main
```

With database support and Connector/J in `lib/`:
```bash
java -cp "out:lib/*:config" forex.main.Main
```

## 6. Team collaboration
The project includes the original team responsibility and integration documents in `docs/`. All teammates should use the same schema and compatible source version. Keep individual database credentials local; do not commit them. Agree on DAO method signatures before merging changes.

## Limitations
TiDB is MySQL-compatible, not the MySQL Server product; behavior can differ for some MySQL-specific features. Exchange rates are sample/static values, transactions are simulated, and automatic live-price alert evaluation is not implemented. SHA-256 is included as a classroom utility and is not production-grade password storage.
