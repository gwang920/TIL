# comparator

```java
Arrays.sort(result,new Comparator<String>(){
           
            @Override
            public int compare(String s1,String s2){
                return ((s2+s1).compareTo(s1+s2));
            }
            
        });
```

