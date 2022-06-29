# qa-guru-hw-15

**API тесты**

gradle clean test --tests ApiTests -DbaseUri=https://reqres.in/ -Dtoken=QpwL5tke4Pnpja7X4

**WEB тесты**

**Локально:** gradle clean test --tests WebTests -DlocalOrRemote=local

**Удаленно:** gradle clean test --tests WebTests -DlocalOrRemote=remote
