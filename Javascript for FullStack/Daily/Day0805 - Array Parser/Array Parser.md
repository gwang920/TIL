# Array Parser

## tokenizer

```javascript
의미있는 단위로 문자열을 자르는 역할을 한다.

"[4,[5],'peson','abc']"

=>['[','4','[','5','person','abc',']']
```



## lexer

```javascript
lexer는 lexical analysis(어휘 분석)을 한다.
텍스트를 받아서 한 글자씩 읽어나가다 의미를 가진단어(분류 기준에 들어오는(?))를
만나면 그 단어를 전체 텍스트로부터 잘라 Token을 만든다.

"tokenizer로부터 쪼개진 각각의 데이터에 의미를 부여한다."
```

```javascript
var str="123,person,true";

lexer(str);

{
	type:Integer,value="123",
	type:string,value="pserson",
	type:boolean,value="true"
}
```



## parser

```javascript
파서는 컴파일의 일부로서 구문을 해석할 수 있는 단위로 여러 부분으로 분할해 주는 역할을 한다.
즉, compiler나 Interpreter에서 원시프로그램을 읽어 들여 그 문장의 구조를 알아내는
구문분석(parsing)을 행하는 프로그램이라한다.

쉽게 말해 "데이터를 구조화" 하는 역할이다.
```

## tokenizer => lexer => parser

```
예제를 통해 알아보자.
```

초기에 받은 데이터이다.

```
"[4,[5],'peson','abc']"
```

tokenizer를 거친 문자열이다. 의미있는 단위로 문자열을 쪼갠 상태이다.

```js
['[','4','[','5','person','abc',']']
```

laxer를 거친 데이터이다. 각각의 데이터에 의미를 부여하였다.

```js
[{type: 'LBracket', value: '['},
 {type: 'number', value: '4'},
 {type: 'LBracket',value:'['},
 {type: 'number', value: '5'},
 {type: 'string', value: 'person'},
 {type: 'string', value: 'abc'},
 {type: 'RBracket', value: ']'}]
```

parser를 거친 데이터이다.

```js
{ type: 'array',
  child: 
   [ { type: 'number', value: '4', child: [] },
     { type: 'array', child:[
        			type:'number',value:'5',child:[]
     	}
     ]
	 },
     { type: 'string', value: 'person', child: [] } ,
     { type: 'string', value: 'abc', child: [] } 
    ] 
}
```



* split

```
split을 사용하면 type이 string 에서 object로 변한다
한번 split을 적용한 string은 object가 되어 재차 split을 적용할 수 없다(?)
```

