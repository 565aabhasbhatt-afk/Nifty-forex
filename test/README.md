# NiftyForex testing

No automated test suite was present in the supplied ForexTradingConsole source ZIP, so no unverified tests have been invented. Use this folder for unit tests as they are added.

Initial manual smoke-test checklist:
- [ ] Compile all Java source files.
- [ ] Launch the console and verify the menu appears.
- [ ] Enter an invalid menu option and verify validation.
- [ ] Exit using option `0`.
- [ ] After configuring TiDB/MySQL, test registration, login, wallet, conversion, watchlist, alerts, portfolio, and transaction history.
