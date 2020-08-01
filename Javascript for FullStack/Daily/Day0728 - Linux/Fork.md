# Fork

```JAVA
Fork란 ?
fork는 다른 사람의 Github repository에서 "내가 어떤 부분을 수정하거나 추가 기능을 넣고 싶을 때" 
해당 repository를 내 Github repository로 그대로 복제하는 기능이다.

여기서 한 가지 중요한 점은
fork한 저장소는 원본(위의 해당 repository)와 연결되어 있다는 점이다.
따라서, 원본 repository에 어떤 변화가 생기면(새로운 commit) 이는 그대로 forked된 repository로 반영할 수 있다.

그 후 original repository(원본)에 변경사항을 적용하고 싶으면 해당 저장소에 pull request를 해야한다.
이 pull request가 original repository의 관리자로부터 승인 되었으면 내가 작성한(수정하거나 만든)코드가
"commit, merger"되어 original에 반영된다.

pull request 하기 전 까지는 내 github에 있는 forked repository에만 변경사항이 적용된다.
    
    
    쉽게 말해 수정하고자 하는 original repository를 fork하고 
    내 저장소로 Clone한 후에 
    수정사항을 적용하고, 관리자에게 pull request를 보내면 
    변경 사항이 original repository에 적용된다.
    
    
    Github 
    ---------------------------------
   			     "fork" 
    recipes 	   ->      Myaccount
    (original 
     repository)
    ---------------------------------
    
    			    | "clone"
    			    v
   Mycomputer 
    ---------------------------------
    						
    			   recipes
    			
    ---------------------------------
```



# Clone

```
clone은 특정 repository를 내 local machine에 복사하여 새로운 저장소를 만든다.
clone한 원본 repository를 remote 저장소 "origin"으로 가지고 있다. 

권한이 없는 경우 해당 저장소로 push 하지 못한다.
또한 기존의 제일 처음 original repository와 연결되지 못한다.

original repository를 clone에서 협업할 떄
변경사항을 다른 작업자가 먼저 commit했다면 그 후 내가 바로 push하지 못한다.
충돌이나기 때문이다.
따라서, 수정된 commit을 fetch하고 merge한 이후에 push를 할 수 있다.


[me]        [server]         [other]
    clone	     ------>
   <----   	      clone
   		     <-----
   ----->	      push
   push
   (error:failed to push)
   <-----
   git fetch origin
   merge
   ----->
   push(success)
```

# fork - > clone -> pull request

주의사항은 clone할때 single-branch 옵션을 주어야 한다는 것이다.

```shell
git clone https://github.com/{본인 GitHub Username}/{저장소이름} -b {브랜치명} --single-branch

single branch는 특정 브랜치를 클론해올 때 사용한다.

ex) 본인 GitHub Username은 gwang920, 브랜치명 gwang, 저장소가 TIL 인경우,
git clone https://github.com/gwang920/TIL -b gwang --single-branch

```

##### 2. commit

```shell
git status //확인

git rm 파일명 //삭제된 파일

git add 파일명(or * 모두) // 추가/변경 파일

git commit -m "메세지" // 커밋

```

##### 3. 본인 원격 저장소에 올리기

```shell
git push origin 본인_브랜치

ex) git push origin gwang

```

##### 4. Pull Request보내기

```
- pull request는 github 웹 서비스에서 진행할 수 있다.
- git push origin 명령을 수행하고, github 웹 브랜치에 접근하면 pull request가 가능하다.
```


# [GIT] pull vs fetch

```
pull
- 원격 저장소로부터 필요한 파일을 다운 + 병합
- 원격 저장소와 내 저장소를 동일하게 만들어준다.
- 지역 브랜치와 원격저장소 origin/master가 같은 위치를 가리킨다.

fetch
- 원격 저장소로 부터 파일을 다운 (병합은 별개이다. 따로 해줘야함)
- 사용하는 이유?
	원래 내용과 바뀐 내용의 차이를 알 수 있다. (병합이 아닌 다운이기 때문)
	이후에 merge를 해주면 git pull과 같아진다.
	
git clone 은 git remote add + git pull 과 거의 같다.
```