



```javascript
console.log("Press Any key to start");

var todos={
    todo:[123,124],
    doing:[123,444],
    done:[]
  };

//  console.log(todos.todo[0]);
var info=[
  {id:"123",value:"자바스크립트 공부하기",tag:["favorite","programming"]},
  {id:"124",value:"ios 공부하기",tag:["anything","programming"]}
]

  function SearchIdx(Id,dir){
    if(dir=="info"){
      for(var i in info){
        if(info[i].id===Id){
          return i;
        }
      }
    }else{
      var idx=[];
      for(var i in todos){
        for(var j in todos[i]){
          if(todos[i][j]==Id){
            idx.push(i);
            idx.push(j);
            return idx;
          }
        }
      }
    }
    return false;
  }
  
  function CurrentState(){
    console.log("현재상태 : todo:[" + todos.todo +"], doing:["+todos.doing+"], done:["+todos.done+']');
  }
  function redirect(){
    rl.prompt();
  }
  function deleteme(tmp){
    
      var flag=false;
      var a,b;
      for(var i in todos){
        if(flag) break;
        for(var j in todos[i]){
          if(todos[i][j]==tmp){
            flag=true;
            a=i;b=j;
            break;
            
          }
        }
      }
    if(!flag) console.log(tmp+"는 목록에 없습니다.");
    else{
      async function test(){
        setTimeout(function(){
          console.log(tmp+"가 "+i+"목록에서 삭제됐습니다.");
          delete todos[a][b];
          },2000)  
        await repeat();
      }
      

      function repeat(){
        CurrentState();
        redirect();
      }
    }
    

 }
  
function makeList(){
  var list=" ";
  for(var i in info){
    list+="'"+info[i].value+","+info[i].id+"번'";
    if(i!=info.length-1){
      list+=",";
    }
 }
 return list;
}

function Update(Id){
  var idx=[];
    idx=SearchIdx(Id,"todos");
    if(idx==false){
      return false;
    }
    else{
      delete todos[idx[0]][idx[1]];
      todos.doing.push(Id);
      return true;
    } 
}
function Add(list){
  var rand=Math.floor(Math.random()*1000);
  var Data=new Object();
  Data.id=rand;
  Data.value=list[1];
  Data.tag=list[2];
  info.push(Data);
  todos.todo.push(rand);
  return rand;
}


  function cmd(string){
    var str=string.split("$$");
    if(str[0]=="delete"){
     deleteme(str[1]);
    }else{
        if(str[0]=="show"){
            if(str[1]=="current"){
              CurrentState();
            }
            else{
              var list=""; // 초기화 안하면 undefined
              list=makeList();
              console.log("todo리스트 :  총"+todos.todo.length+"건 : "+list);
            }
        }
        if(str[0]=="add"){
           var Addid=Add(str);
            console.log(str[1]+"가 추가됐습니다.(id :"+Addid+")");
            CurrentState();
        }
        if(str[0]=="update"){
          var check=Update(str[1]);
          if(check==false){
            console.log(str[1]+"은 목록에 없습니다.");
            redirect();
            return;
          }
          var idx=SearchIdx(str[1],"info");
          var v=info[idx].value;
          //var v=info[SearchIdx(str[1],"info")].value;
          console.log(v+" doing으로 상태가 변경됐습니다.");
          CurrentState();
        }
        redirect();
    }
  }
  
  const readline = require('readline');
  const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
    prompt: '명령하세요 : '
  });

  rl.on('line', (line) => {
    if(line==='q'){
      console.log("(프로그램 종료)");
      process.exit(0);
    }
    cmd(line);
  });
```

