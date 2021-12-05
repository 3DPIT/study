## Git커밋할때사용하는개발컨벤션

## 목차

1. **Commit시 컨벤션 용어**
2. **구성**
3. **사용법예시**
4. **번외 Commit Message Emogji**

## 1.Commit시 컨벤션 용어

- feat : feature
  - 새로운 기능을 추가할 경우
- fix : bug fix
  -  버그를 고친 경우
- docs : documentation
  - 문서를 수정한 경우 
- test : when adding missing tests
  - 테스트 추가, 테스트 리팩토링(프로덕션 코드 변경 X)
- chore : maintain
  - 빌드 업무 수정, 패키지 매니저 수정
- style : formatting, missing semi colons,...
  -  코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우
- refactor
  - 프로덕션 코드 리팩토링
- comment 
  - 필요한 주석 추가 및 변경
- !BREAKING CHANGE: 커다란 API 변경의 경우 (
  - 예) API의 arguments, return 값의 변경, DB 테이블 변경, 급하게 치명적인 버그를 고쳐야 하는 경우)
- !HOTFIX : 급하게 치명적인 버그를 고쳐야하는 경우
- rename : 파일 혹은 폴더명을 수정하거나 옮기는 작업만 하는 경우
- remove : 파일을 삭제하는 작업만 수행한 경우
- design : CSS등 사용자 UI 디자인 변

#### 기능태그의 종류

- feat, fix, design, !BREAKING CHANGE 
  - 추가적인 문맥정보 제공하기 위해서는 	
    - feat(navigation)
    - fix(database)

![image-20211205184201710](Git커밋할때사용하는개발컨벤션.assets/image-20211205184201710.png)

#### 개선태그의 종류

- style, refactor, comment

#### 그 외

- docs, test, chore, rename, remove 

## 2.구성

### Subject

- 제목은 50자를 넘기지 않기
- 대문자로 작성하고 마침표 붙이지 않음

- 영문으로 표기하는 경우 동사(원형)을 가장 앞에 두고 첫글자를 대문자로 표기
  - 과거시제를 사용하지 않고 명령어로 작성
    - 예) Fixed -> Fix
      - Added -> Add

### Body

 -  선택 사항으로 모든 커밋에 작성할 필요 없음
 -  부연 설명이 필요하거나 커밋의 이유를 설명할 경우 작성
 -  72자 넘기지 않고 제목과 구분되기 위해 한칸을 띄워 작성
    	-  한칸 띄워 작성해야 보기도 편함
-  포인트는  어떻게 했는지가 아니라, 
   -  무엇을 왜 했는지를 작성해야함

### Footer

- 선택 사항 모든 커밋에 꼬리말 작성 필요 없음
- issue tracker id(이슈 트래커 ID)를 작성할 때 사용
- 여러 개의 이슈 번호를 적을 때는 쉼표로 구분
  - 이슈 트래커 유형
    - Fixes: 이슈 수정중 (아직 해결되지 않은 경우)
    - Resolves: 이슈를 해결했을 때 사용
    - Ref: 참고할 이슈가 있을 때 사용
    - Related to: 해당 커밋에 관련된 이슈번호 (아직 해결되지 않은 경우)
      - 예) Fixes: #40 Related to: #12, # 20

## 3.사용법 예시

- 기본 예시

  ```markdown
  feat: Summarize changes in around 50 characters or less
  
  More detailed explanatory text, if necessary. Wrap it to about 72
  characters or so. In some contexts, the first line is treated as the
  subject of the commit and the rest of the text as the body. The
  blank line separating the summary from the body is critical (unless
  you omit the body entirely); various tools like `log`, `shortlog`
  and `rebase` can get confused if you run the two together.
  
  Explain the problem that this commit is solving. Focus on why you
  are making this change as opposed to how (the code explains that).
  Are there side effects or other unintuitive consequenses of this
  change? Here's the place to explain them.
  
  Further paragraphs come after blank lines.
  
   - Bullet points are okay, too
  
   - Typically a hyphen or asterisk is used for the bullet, preceded
     by a single space, with blank lines in between, but conventions
     vary here
  
  If you use an issue tracker, put references to them at the bottom,
  like this:
  
  Resolves: #123
  See also: #456, #789
  ```

- 실제 예시

  ```markdown
  Feat: "회원 가입 기능 구현"
  
  SMS, 이메일 중복확인 API 개발
  
  Resolves: #123
  Ref: #456
  Related to: #48, #45
  ```

## 4.번외 Commit Message Emogji

- 아래는 대표적으로 사용되는 일부 몇가지

| Emogi | Description                                                  |
| ----- | ------------------------------------------------------------ |
| 🎨     | 코드의 **형식 / 구조**를 개선 할 때                          |
| 📰     | **새 파일**을 만들 때                                        |
| 📝     | **사소한 코드 또는 언어**를 변경할 때                        |
| 🐎     | **성능**을 향상시킬 때                                       |
| 📚     | **문서**를 쓸 때                                             |
| 🐛     | **버그** reporting할 때, @FIXME 주석 태그 삽입               |
| 🚑     | **버그를 고칠 때**                                           |
| 🔥     | **코드 또는 파일 제거할 때** , @CHANGED주석 태그와 함께      |
| 🚜     | **파일 구조를 변경**할 때 . 🎨과 함께 사용                    |
| 🔨     | 코드를 **리팩토링** 할 때                                    |
| 💄     | **UI / style 개선시**                                        |
| ♿️     | **접근성**을 향상시킬 때                                     |
| 🚧     | **WIP** (진행중인 작업)에 커밋, @REVIEW주석 태그와 함께 사용 |
| 💎     | New **Release**                                              |
| 🔖     | 버전 **태그**                                                |
| ✨     | **새로운 기능**을 소개 할 때                                 |
| ⚡️     | 도입 할 때 **이전 버전과 호환되지 않는 특징**, @CHANGED주석 태그 사용 |
| 💡     | **새로운 아이디어**, @IDEA주석 태그                          |
| 🚀     | **배포 / 개발 작업** 과 관련된 모든 것                       |

[커밋 메시지 이모지 관련 참고자료](https://treasurebear.tistory.com/70)

