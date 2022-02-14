## Code Coverage 파일 형식
| 형식       | 파일 이름              |
|-----------|------------------------|
| json      | coverage.json          |
| lcov      | coverage.info          |
| cobertura | coverage.cobertura.xml |
| opencover | coverage.opencover.xml |

## Code Coverage 생성
### Code Coverage 패키지
- `coverlet.msbuild`

### 단일 파일 형식 : Json
```shell
dotnet test `
	/p:CollectCoverage=true  `
	/p:CoverletOutput=./TestResults/Coverage/ `
	/p:CoverletOutputFormat=json
```
- 결과
  ```
  ClassLibrary1.UnitTest\TestResults\Coverage
    coverage.json 
  ```
- `\`` : PowerShell 복수 라인을 가능하게 하는 기호이다.

### 복수 파일 형식 : json,lcov,cobertura,opencover
```
dotnet test `
	/p:CollectCoverage=true  `
	/p:CoverletOutput=./TestResults/Coverage/ `
	/p:CoverletOutputFormat=json%2clcov%2ccobertura%2copencover
```
- 결과
  ```
  ClassLibrary1.UnitTest\TestResults\Coverage
    coverage.json
    coverage.info
    coverage.cobertura.xml
    coverage.opencover.xml
  ```
- `%2c` : `,` URL 인코딩 코드이다.

### VSCode Task : `settings.json`
```json
{
    "version": "2.0.0",
    "tasks": [
        {
            "label": "test",
            "command": "dotnet",
            "type": "process",
            "args": [
                "test",
                "/p:CollectCoverage=true",
	            "/p:CoverletOutput=./TestResults/Coverage/",
	            "/p:CoverletOutputFormat=json%2clcov%2ccobertura%2copencover"
            ],
            "problemMatcher": "$msCompile"
        }
```
- `Ctrl + ,`

### VSCode Task 단축키 : `keybindings.json`
```json
// Place your key bindings in this file to override the defaultsauto[]
[
    {
        "key": "ctrl+shift+t",
        "command": "workbench.action.tasks.runTask",
        "args": "test"
    }
]
```
- `Ctrl + K + S`
- `Ctrl + Shift + P` + `Open Keyboard Shortcuts`


## VSCode 확장 도구
### Coverage Gutters 확장 도구 : Code Coverage 확인
```json
"coverage-gutters.showGutterCoverage": true,
"coverage-gutters.showLineCoverage": true,
"coverage-gutters.showRulerCoverage": true,
"coverage-gutters.coverageFileNames": [
    "lcov.info",
    "cov.xml",
    "coverage.xml",
    "jacoco.xml",
    "coverage.info"
],
```

### .NET Test Explorer 확장 도구 : 단위 테스트 실행 
```json
"dotnet-test-explorer.testArguments": "/p:CollectCoverage=true /p:CoverletOutput=./TestResults/Coverage/ /p:CoverletOutputFormat=json%2clcov%2ccobertura%2copencover",
"dotnet-test-explorer.testProjectPath": "**\\*.UnitTest.csproj",
"dotnet-test-explorer.treeMode": "merged",
```

## Code Coverage 실시간 반영
```shell
dotnet watch `
    test --project ./ClassLibrary1.UnitTest `
	/p:CollectCoverage=true  `
	/p:CoverletOutput=./TestResults/Coverage/ `
	/p:CoverletOutputFormat=json%2clcov%2ccobertura%2copencover
```

## Code Coverage 제외
### 코드
```cs
using System.Diagnostics.CodeAnalysis;

public class Class1
{
    [ExcludeFromCodeCoverage]
    public int Method2()
    {
        return 3;
    }
}
```

### 명령
```shell
dotnet test `
	/p:CollectCoverage=true  `
	/p:CoverletOutput=./TestResults/Coverage/ `
	/p:CoverletOutputFormat=json%2clcov%2ccobertura%2copencover `
    /p:Exclude="[xunit.*]*
```