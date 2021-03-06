# 서브넷 마스크(subnet Mask)

```
- IPv4주소의 고갈 현실화를 해결하기 위해 호스트의 IP대역을 외부 네트워크와 명확하게 구분할 수 있는 수단

=> 클래스단위 할당의 비효율성
클래스 A(65000개의 IP)를 기업체에 할당했을 때 아이피를 다쓰지않고
20000개 정도 쓴다고 가정하면 45000개의 IP는 쓰이지 않은채로 낭비된다.
이는 곧 IP자원의 고갈을 의미한다.
이를 해결하기 위해 부분망인 서브넷을 사용한다.

- 서브넷은 말그대로 부분망이라는 뜻
- 서브넷마스크의 목적은 IP주소와 AND연산을 통해 Network 부분의 정보를 걸러내는 것
```

## ip 분리 원리

```
IP주소는 IP클래스에 의해 분리되는 Network Prefix와 나머지 Host Number로 분리된다.
서브넷 마스크에 의해 이루어지는 서브넷팅은 이 Host Number를 Subnet Number와 서브넷안에서 식별되는 Host Number로 다시 분리한다.
```

![image](https://user-images.githubusercontent.com/49560745/90354373-22a89580-e084-11ea-8396-49252797b9fa.png)

- 출처 : http://korean-daeddo.blogspot.com/2016/01/blog-post_26.html

## IP주소 체계

```
- 크기 : 32bit(2^32 대략 4억개)
- A,B,C,D,E 클래스
```

### 1. 유니케스트 주소

#### - A class

```
A class(0 ~ 127) : 맨 앞에 비트가 '0'인 공통 비트 클래스

0.0.0.0 ~ 127.255.255.255  기본 서브넷 마스크 : 255.0.0.0
0 0000000.   0 1111111.     네트워크 아이디당 IP 주소 개수 : 2^24개 (0.0.0  8 * 3)
```

#### - B class

```
B class(128 ~ 191) : 맨 앞에 비트가 '10'인 공통 비트 클래스

128.0.0.0 ~ 191.255.255.255 기본 서브넷 마스크 : 255.255.0.0
10 000000.    10 111111.     네트워크 아이디당 IP 주소 개수 : 2^16개(0.0  8*2)
```

#### - C class

```
C class(192 ~ 223) : 맨 앞에 비트가 '110'인 공통 비트 클래스

192.0.0.0 ~ 223.255.255.255  기본 서브넷 마스크 : 255.255.255.0
110 00000.   110 11111.      네트워크 아이디당 IP주소 개수 : 2^8개 (0  8*1)
```

#### class 구분 예제

```
EX) 121.160.54.223 - IP   255.255.255.0 - 서브넷마스크
위는 A클래스이다.
(기본 서브넷마스크는 말그대로 디폴트일 뿐 A클래스에서 C클래스의 기본 서브넷 마스크를 사용할 수 있다. 즉, 클래스를 구분하는 유일한 것은 맨 앞 비트이다.)
```

### 2. 멀티케스트 주소

```
D class (224~239) : 맨 앞에 비트가 '1110'인 공통 비트클래스

224.0.0.0 ~ 239.255.255.255   서브넷 마스크 x(없다)
1110 0000.   1110 1111.
```

#### 3. IANA 예비용으로 예약한 주소

```
E Class (240 ~ 250)

240.0.0.0  ~ 255.255.255.255
```



```
설정이 불가능한 IP 주소

- D Class  							사용 O, 설정 X
- E Class   						사용 X, 설정 X
- 0.x.x.x   					    사용 X, 설정 X
- local loopback 					사용 O, 설정 X
- 네트워크 이름, 서브넷 브로드케스트 주소

네트워크 이름 & 서브넷 브로드케스트 주소

121.160.42.0 <- 네트워크 이름
121.160.42.255 <- 서브넷 브로드케스트 주소

IP                 마스크
121.160.42.11  ~   255.255.255.0



서브넷 마스크           Prefix Mask						설정 가능한 IP 주소 개수
			  (앞에서 부터 1의개수를 표시하는 것)  

255.255.255.255      /32
255.255.255.0        /24   (네트워크 아이디가 24bit host8bit)  2^8 - 2(네트워크 이름, 서브넷 브로드케스트 주소 => 설정 불가능)
255.255.0.0          /16								  2^16-2
255.0.0.0            /8                                   2^24-2
0.0.0.0              /0



11111111 = 255
11111110 = 254
11111100 = 252
11111000 = 248
11110000 = 240
11100000 = 224
11000000 = 192
10000000 = 128
00000000 = 0


```

# 서브넷 계산

```
클래스에 할당된 ip를 더 세분화해서 사용하기 위해 서브넷 마스크를 이용해 분리한다.
```

## 1) 서브넷 비트 개수를 제곱한만큼 ip 주소가 분리된다.

```
즉, B클래스에서 사용할 서브넷 비트가 5라면
기본 서브넷 마스크 255.255.0.0 에서 255.255.248.0 로 서브넷 마스크가 확장(?)된다.
(11111000 만큼 2^5=32  =>  11111111 11111111 11111000 00000000)
```

## 2) 서브넷 개수

```
이때 B클래스의 서브넷 비트인 5만큼인 2^5=32가 서브넷 개수가 되고
서브넷당 호스트의 개수는 0의 개수를 2의 제곱한 값인 2^11=2048개 - 2개인 2046 개가 된다.

(-2를 해주는 이유는 네트워크 주소와 서브넷 브로드캐스트 주소는 호스트로 할당가능한 ip가 아니기 때문이다.)

* IP 주소의 첫째 부분은 네트워크 주소로 사용되고, 마지막 부분은 호스트 주소로 사용됨

 네트워크 주소는 작은 네트워크를 식별하는데 사용된다. 즉, 그 네트워크 자체를 대표하는 놈이다.
 브로드캐스트 주소는 이름에서 알 수 있듯이 여기로 데이터를 전송하면 모든 컴퓨터로 송신된다.
 
 따라서, 두 아이피는 사용할 수 없다.

ex) 192.168.123.132

	192.168.12.0 - network address
    0.0.0.132 - host address
```

## 3) 호스트 IP 범위

```
[네트워크 시작주소 +1] ~ [브로드 캐스트 주소 -1]

192.168.0.1 의 주소를 C클래스를 5비트만큼 사용한다고 해보자.

이때, 서브넷 마스크는 255.255.255.252 가 되고, 
최대 서브넷 개수 64개(2^6 11111100), 서브넷당 호스트 개수는 2개가 된다.

네트워크 시작주소는
192.168.0.1 & 255.255.255.252 => 192.168.0.0 이 되고,

브로드 캐스트 주소는
네트워크 시작주소에
마지막 8비트 11111100(252)의 0 개수만큼 2진 비트연산을 한 값(3)이 추가된다.

따라서 호스트 IP 범위는
192.168.0.1 ~ 192.168.0.2 가 된다.
```





# 서브넷 계산기

```
http://www.subnet-calculator.com/subnet.php?net_class=A
위 웹사이트에 접속하면 서브넷을 계산할 수 있다.
```

![image](https://user-images.githubusercontent.com/49560745/90407052-f7a05f00-e0e0-11ea-94fd-5f238b9bbccc.png)

```
위는 c클래스의 기본 서브넷 마스크를 설정한 것이다.
그렇기때문에 subnet Bits가 0임을 확인할 수 있고, ip를 하나도 쪼개지 않고 사용한다.
```

![image](https://user-images.githubusercontent.com/49560745/90407170-24ed0d00-e0e1-11ea-822b-b57b8c33030a.png)

```
서브넷 마스크 비트를 1개로 늘려보자
서브넷이 두개로 증가한 것을 볼 수 있다.
즉, ip로 들어온 것을 두개의 main network 분할한 것이고
이 대표 network들은 Hosts Per Subnet을 보면 알 수 있듯이
각각 126개의 기기에 ip를 할당할 수 있다.
```

