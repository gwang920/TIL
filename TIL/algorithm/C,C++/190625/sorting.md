# 배열 정렬

### 	I. int형 배열

```c++
arr[0]=0;
arr[1]=2;
arr[3]=1;
sort(arr,arr+3);

결과 0 1 2
```

### 	II. 오름차순(greater)

```c++
arr[0]=0;
arr[1]=2;
arr[3]=1;
sort(arr,arr+3,greater<int>);

결과 2 1 0
```

### 	III. Vector 정렬

```c++
vector<char> v;
v.push_back('c');
v.push_back('b');
v.push_back('a');

sort(v.begin(),v.end());

결과 a b c

vector<string> v;
v.push_back("456");
v.push_back('123');
v.push_back('789');

sort(v.begin(),v.end());

결과 123 456 789


```

