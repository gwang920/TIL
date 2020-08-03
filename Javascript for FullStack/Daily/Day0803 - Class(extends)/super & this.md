# super & this

## 1. super

```
super 키워드는 부모 오브젝트 함수를 호출할 때 사용된다.
```

```javascript
class Cat { 
    constructor(name) {
      this.name = name;
    }
    
    speak() {
      console.log(this.name + ' 야옹 ');
    }
  }
  
  class Tiger extends Cat {
    speak() {
      super.speak();
      console.log(this.name + ' 어흥.');
    }
  }

  var nTiger=new Tiger("백호");
  nTiger.speak();

[결과]
백호 야옹
백호 어흥.
```

