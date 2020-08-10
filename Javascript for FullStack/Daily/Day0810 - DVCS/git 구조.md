# git 구조

```
git의 하위 디렉토리를 어떻게 표현할까 궁금했는데
디렉토리 구조는 tree 오브젝트로 나타낼 수 있다.


그런데 단순히 이진트리구조로 디렉토리를 구성하면 하위 디렉토리가 여러개(두개 이상)인 경우는 어떻게 처리해야 될까 궁금했다.

B-tree를 사용하면 되지않을까 생각했는데 약간 개념이 다른느낌이다.
그렇다면 링크드리스트로 구현할 수 있지 않을까?

commit, tree, blob, tag. 이것들이 전부 객체라는 사실도 알게되었다.

아래 링크에는 위 4가지 객체의 구조를 알려준다!

https://donggov.tistory.com/40
```



## git의 4가지 영역

```java
명령에 따른 흐름
			  [git add]           [git commit]                [git push]
 working Dir  =======> Staging Area =======> Local Repository ========> Remote Repository


 - git add : Working Directory 에서 Index 영역으로 정보가 저장됨.
 - git commit : Index(Staging Area)영역에서 local Repository로 정보가 저장됨.
 - git push : local Repository에서 remote Repository로 이동
 
 
1) Working Directory (작업영역)

 - 실제 프로젝트 디렉토리
 - 실제 코드의 추가, 수정, 삭제 작업이 이루어지는 영역

2) Index (Staging Area)

 - Working Directory에서 Local Repository로 정보 저장 전 준비 영역
 - 파일 상태를 기록, 스테이징 한다고 표현 한다.(Staged)
 
3) Repository (저장소)

 - 파일, 폴더를 변경 이력별로 저장해 두는 곳
 - Local Repository : 개인 PC에 파일이 저장되는 개인 저장소
 - Remote Repository : 원격 저장소 전용 서버에서 관리되며, 여러 사람들과 같이 공유도 가능한 저장소 
```



## 1. git init

```
git init 명령어는 .git이라는 하위디렉토리를 만든다.
.git 디렉토리에는 저장소에 필요한 뼈대 파일이 들어있다.
```

### .git의 초기구성

```
HEAD
config
description
/branches
/hooks
/objects
/refs
```

## 2. git add

```
- git add를 했을때 index(=stage area,tree구조)에 object이름과 실제파일이름이 추가되고(추적등록) objects에 blob타입으로 파일내용이 추가된다.

 **** working directory에서는 git이 관리는 하지만 git이 추적하지 않는다. ****

- 같은 파일이라도 파일내용이 달라지면 새로운 object가 생긴다.

- object의 이름은 SHA1로 HASH된다. 즉 파일내용이 같으면 object명이 같다.
```

## 3. git commit

```
- git commit을 하면 objects에 commit객체와 tree객체가 추가된다.

**** commit도 객체를 생성해서 전달하는구나! ****

- tree객체는 commit할때의 index를 스냅샷찍어서 저장한다.
- commit객체는 tree객체명과 Author, Date, Msg를 저장한다.
- 2번째 commit객체부터는 parent라고 이전 commit객체명을 저장한다.
```

###  **** git의 객체(object) ****

```
- object에는 blob(파일내용)과 tree(디렉터리와 blob의 정보(파일명)들을 담음)와 commit이 있다.

- 예를들어 1개파일을 생성하고 add하고 commit했을 때, git 내부에서는 blob객체와 tree객체, commit객체 3개가 만들어 지는 것이다.

- 이것은 git push를 했을때 Counting objects: 3, done 의 문구에서도 알 수 있다.

- tag객체는 커밋객체를 가리키며 태그명과 태그를 만든사람, 주석이 들어가 있다.

즉 git은 4가지 객체들로 이루어져 있다. blob , tree , commit , tag
```

## 4. git status

```
git status는 해당 디렉토리의 상태를 나타낸다.(폴더 + 파일)
```

## 참고

```
Git 기본: SHA-1 해시
Git은 데이터를 저장하기 전에 항상 체크섬을 구하고 그 기준으로 데이터를 관리합니다. 
그 체크섬을 구하는데 SHA-1 해시를 사용하고, 그러면 체크섬은 160 bit가 되고, 이를 16진수로 표현하면 40자가 됩니다.


이 40자는 온 세상에서 거의 유일한 값이라고 한다. 따라서 고유키로 사용할 수 있다.
```



출처: https://sjh836.tistory.com/37?category=695128 [빨간색코딩]