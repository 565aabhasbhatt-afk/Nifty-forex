$ErrorActionPreference = "Stop"
New-Item -ItemType Directory -Force out | Out-Null
$files = Get-ChildItem -Recurse src -Filter *.java
javac -encoding UTF-8 -d out $files.FullName
