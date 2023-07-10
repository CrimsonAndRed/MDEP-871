# What

This is a small reproduction setup for Apache Dependency Plugin 
issue https://issues.apache.org/jira/projects/MDEP/issues/MDEP-871.

Dependency graph looks like this:
```text
             +--- good
             V 
dep1  <--  dep2
             ^
             +--- bad
``` 

_good_ and _bad_ modules differs only in one simple thing - 
_good_ module uses interface that produces class from rt (_Object_); 
_bad_ module uses interface that produces class from _dep1_.

# Usage
Run the following:

```shell
mvn dependency:analyze -pl :bad,:good -am
```

Tried on maven 3.9.3 (latest at the moment of writing, 10.07.2023) + OpenJDK 17.0.2.

Result for dependency plugin 3.5.0:
```text
[INFO] --- dependency:3.5.0:analyze (default-cli) @ bad ---
[INFO] No dependency problems found
<...>
[INFO] --- dependency:3.6.0:analyze (default-cli) @ good ---
[INFO] No dependency problems found
```

Result for dependency plugin 3.6.0:
```text
[INFO] --- dependency:3.6.0:analyze (default-cli) @ bad ---
[WARNING] Used undeclared dependencies found:
[WARNING]    mdep.example:dep1:jar:0.0.1:compile
<...>
[INFO] --- dependency:3.6.0:analyze (default-cli) @ good ---
[INFO] No dependency problems found
```