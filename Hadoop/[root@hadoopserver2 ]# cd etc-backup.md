[root@hadoopserver2 ~]# cd /etc
[root@hadoopserver2 etc]# cd hadoop-1.2.1/
[root@hadoopserver2 hadoop-1.2.1]# cd conf/
[root@hadoopserver2 conf]# hive
19/08/08 11:12:08 WARN conf.HiveConf: DEPRECATED: Configuration property hive.metastore.local no longer has any effect. Make sure to provide a valid value for hive.metastore.uris if you are connecting to a remote metastore.
19/08/08 11:12:08 WARN conf.HiveConf: HiveConf of name hive.metastore.local does not exist

Logging initialized using configuration in jar:file:/etc/hive/lib/hive-common-1.0.1.jar!/hive-log4j.properties
Exception in thread "main" java.lang.RuntimeException: java.net.ConnectException: Call to hadoopserver2/70.12.114.201:9000 failed on connection exception: java.net.ConnectException: 연결이 거부됨
	at org.apache.hadoop.hive.ql.session.SessionState.start(SessionState.java:444)
	at org.apache.hadoop.hive.cli.CliDriver.run(CliDriver.java:626)
	at org.apache.hadoop.hive.cli.CliDriver.main(CliDriver.java:570)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.apache.hadoop.util.RunJar.main(RunJar.java:160)
Caused by: java.net.ConnectException: Call to hadoopserver2/70.12.114.201:9000 failed on connection exception: java.net.ConnectException: 연결이 거부됨
	at org.apache.hadoop.ipc.Client.wrapException(Client.java:1142)
	at org.apache.hadoop.ipc.Client.call(Client.java:1118)
	at org.apache.hadoop.ipc.RPC$Invoker.invoke(RPC.java:229)
	at com.sun.proxy.$Proxy8.getProtocolVersion(Unknown Source)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.apache.hadoop.io.retry.RetryInvocationHandler.invokeMethod(RetryInvocationHandler.java:85)
	at org.apache.hadoop.io.retry.RetryInvocationHandler.invoke(RetryInvocationHandler.java:62)
	at com.sun.proxy.$Proxy8.getProtocolVersion(Unknown Source)
	at org.apache.hadoop.ipc.RPC.checkVersion(RPC.java:422)
	at org.apache.hadoop.hdfs.DFSClient.createNamenode(DFSClient.java:183)
	at org.apache.hadoop.hdfs.DFSClient.<init>(DFSClient.java:281)
	at org.apache.hadoop.hdfs.DFSClient.<init>(DFSClient.java:245)
	at org.apache.hadoop.hdfs.DistributedFileSystem.initialize(DistributedFileSystem.java:100)
	at org.apache.hadoop.fs.FileSystem.createFileSystem(FileSystem.java:1446)
	at org.apache.hadoop.fs.FileSystem.access$200(FileSystem.java:67)
	at org.apache.hadoop.fs.FileSystem$Cache.get(FileSystem.java:1464)
	at org.apache.hadoop.fs.FileSystem.get(FileSystem.java:263)
	at org.apache.hadoop.fs.FileSystem.get(FileSystem.java:124)
	at org.apache.hadoop.hive.ql.session.SessionState.start(SessionState.java:427)
	... 7 more
Caused by: java.net.ConnectException: 연결이 거부됨
	at sun.nio.ch.SocketChannelImpl.checkConnect(Native Method)
	at sun.nio.ch.SocketChannelImpl.finishConnect(SocketChannelImpl.java:717)
	at org.apache.hadoop.net.SocketIOWithTimeout.connect(SocketIOWithTimeout.java:206)
	at org.apache.hadoop.net.NetUtils.connect(NetUtils.java:511)
	at org.apache.hadoop.net.NetUtils.connect(NetUtils.java:481)
	at org.apache.hadoop.ipc.Client$Connection.setupConnection(Client.java:457)
	at org.apache.hadoop.ipc.Client$Connection.setupIOstreams(Client.java:583)
	at org.apache.hadoop.ipc.Client$Connection.access$2200(Client.java:205)
	at org.apache.hadoop.ipc.Client.getConnection(Client.java:1249)
	at org.apache.hadoop.ipc.Client.call(Client.java:1093)
	... 27 more
[root@hadoopserver2 conf]# select * from dir
bash: syntax error near unexpected token `from'
[root@hadoopserver2 conf]# start-all.sh
starting namenode, logging to /etc/hadoop-1.2.1/libexec/../logs/hadoop-root-namenode-hadoopserver2.out
localhost: starting datanode, logging to /etc/hadoop-1.2.1/libexec/../logs/hadoop-root-datanode-hadoopserver2.out
localhost: starting secondarynamenode, logging to /etc/hadoop-1.2.1/libexec/../logs/hadoop-root-secondarynamenode-hadoopserver2.out
starting jobtracker, logging to /etc/hadoop-1.2.1/libexec/../logs/hadoop-root-jobtracker-hadoopserver2.out
localhost: starting tasktracker, logging to /etc/hadoop-1.2.1/libexec/../logs/hadoop-root-tasktracker-hadoopserver2.out
[root@hadoopserver2 conf]# hive
19/08/08 11:12:54 WARN conf.HiveConf: DEPRECATED: Configuration property hive.metastore.local no longer has any effect. Make sure to provide a valid value for hive.metastore.uris if you are connecting to a remote metastore.
19/08/08 11:12:54 WARN conf.HiveConf: HiveConf of name hive.metastore.local does not exist

Logging initialized using configuration in jar:file:/etc/hive/lib/hive-common-1.0.1.jar!/hive-log4j.properties
Exception in thread "main" java.lang.RuntimeException: org.apache.hadoop.ipc.RemoteException: org.apache.hadoop.hdfs.server.namenode.SafeModeException: Cannot create directory /tmp/hive/root/3e955fbb-9444-4488-a07f-a59b7b3c6846. Name node is in safe mode.
The reported blocks 7 has reached the threshold 0.9990 of total blocks 7. Safe mode will be turned off automatically in 22 seconds.
	at org.apache.hadoop.hdfs.server.namenode.FSNamesystem.mkdirsInternal(FSNamesystem.java:2497)
	at org.apache.hadoop.hdfs.server.namenode.FSNamesystem.mkdirs(FSNamesystem.java:2469)
	at org.apache.hadoop.hdfs.server.namenode.NameNode.mkdirs(NameNode.java:911)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.apache.hadoop.ipc.RPC$Server.call(RPC.java:587)
	at org.apache.hadoop.ipc.Server$Handler$1.run(Server.java:1432)
	at org.apache.hadoop.ipc.Server$Handler$1.run(Server.java:1428)
	at java.security.AccessController.doPrivileged(Native Method)
	at javax.security.auth.Subject.doAs(Subject.java:422)
	at org.apache.hadoop.security.UserGroupInformation.doAs(UserGroupInformation.java:1190)
	at org.apache.hadoop.ipc.Server$Handler.run(Server.java:1426)

	at org.apache.hadoop.hive.ql.session.SessionState.start(SessionState.java:444)
	at org.apache.hadoop.hive.cli.CliDriver.run(CliDriver.java:626)
	at org.apache.hadoop.hive.cli.CliDriver.main(CliDriver.java:570)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.apache.hadoop.util.RunJar.main(RunJar.java:160)
Caused by: org.apache.hadoop.ipc.RemoteException: org.apache.hadoop.hdfs.server.namenode.SafeModeException: Cannot create directory /tmp/hive/root/3e955fbb-9444-4488-a07f-a59b7b3c6846. Name node is in safe mode.
The reported blocks 7 has reached the threshold 0.9990 of total blocks 7. Safe mode will be turned off automatically in 22 seconds.
	at org.apache.hadoop.hdfs.server.namenode.FSNamesystem.mkdirsInternal(FSNamesystem.java:2497)
	at org.apache.hadoop.hdfs.server.namenode.FSNamesystem.mkdirs(FSNamesystem.java:2469)
	at org.apache.hadoop.hdfs.server.namenode.NameNode.mkdirs(NameNode.java:911)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.apache.hadoop.ipc.RPC$Server.call(RPC.java:587)
	at org.apache.hadoop.ipc.Server$Handler$1.run(Server.java:1432)
	at org.apache.hadoop.ipc.Server$Handler$1.run(Server.java:1428)
	at java.security.AccessController.doPrivileged(Native Method)
	at javax.security.auth.Subject.doAs(Subject.java:422)
	at org.apache.hadoop.security.UserGroupInformation.doAs(UserGroupInformation.java:1190)
	at org.apache.hadoop.ipc.Server$Handler.run(Server.java:1426)

	at org.apache.hadoop.ipc.Client.call(Client.java:1113)
	at org.apache.hadoop.ipc.RPC$Invoker.invoke(RPC.java:229)
	at com.sun.proxy.$Proxy8.mkdirs(Unknown Source)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.apache.hadoop.io.retry.RetryInvocationHandler.invokeMethod(RetryInvocationHandler.java:85)
	at org.apache.hadoop.io.retry.RetryInvocationHandler.invoke(RetryInvocationHandler.java:62)
	at com.sun.proxy.$Proxy8.mkdirs(Unknown Source)
	at org.apache.hadoop.hdfs.DFSClient.mkdirs(DFSClient.java:1457)
	at org.apache.hadoop.hdfs.DistributedFileSystem.mkdirs(DistributedFileSystem.java:362)
	at org.apache.hadoop.hive.ql.session.SessionState.createPath(SessionState.java:556)
	at org.apache.hadoop.hive.ql.session.SessionState.createSessionDirs(SessionState.java:498)
	at org.apache.hadoop.hive.ql.session.SessionState.start(SessionState.java:430)
	... 7 more
[root@hadoopserver2 conf]# ifconfig
ens33: flags=4163<UP,BROADCAST,RUNNING,MULTICAST>  mtu 1500
        inet 70.12.114.201  netmask 255.255.255.0  broadcast 70.12.114.255
        inet6 fe80::250:56ff:fe3b:f6de  prefixlen 64  scopeid 0x20<link>
        ether 00:50:56:3b:f6:de  txqueuelen 1000  (Ethernet)
        RX packets 2524  bytes 398958 (389.6 KiB)
        RX errors 0  dropped 25  overruns 0  frame 0
        TX packets 2129  bytes 193128 (188.6 KiB)
        TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0

lo: flags=73<UP,LOOPBACK,RUNNING>  mtu 65536
        inet 127.0.0.1  netmask 255.0.0.0
        inet6 ::1  prefixlen 128  scopeid 0x10<host>
        loop  txqueuelen 0  (Local Loopback)
        RX packets 3217  bytes 737845 (720.5 KiB)
        RX errors 0  dropped 0  overruns 0  frame 0
        TX packets 3217  bytes 737845 (720.5 KiB)
        TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0

virbr0: flags=4099<UP,BROADCAST,MULTICAST>  mtu 1500
        inet 192.168.122.1  netmask 255.255.255.0  broadcast 192.168.122.255
        ether 62:7a:93:6f:a4:ca  txqueuelen 0  (Ethernet)
        RX packets 0  bytes 0 (0.0 B)
        RX errors 0  dropped 0  overruns 0  frame 0
        TX packets 1  bytes 90 (90.0 B)
        TX errors 0  dropped 0 overruns 0  carrier 0  collisions 0

[root@hadoopserver2 conf]# . /etc/profile
[root@hadoopserver2 conf]# hive
19/08/08 11:16:02 WARN conf.HiveConf: DEPRECATED: Configuration property hive.metastore.local no longer has any effect. Make sure to provide a valid value for hive.metastore.uris if you are connecting to a remote metastore.
19/08/08 11:16:02 WARN conf.HiveConf: HiveConf of name hive.metastore.local does not exist

Logging initialized using configuration in jar:file:/etc/hive/lib/hive-common-1.0.1.jar!/hive-log4j.properties
hive> [root@hadoopserver2 conf]# 

[root@hadoopserver2 etc]# cd h
hadoop-1.2.1/ highlight/    hive/         hp/           httpd/
[root@hadoopserver2 etc]# cd h
hadoop-1.2.1/ highlight/    hive/         hp/           httpd/
[root@hadoopserver2 etc]# cd hive/
[root@hadoopserver2 hive]# ls
LICENSE  README.txt         bin   examples  lib
NOTICE   RELEASE_NOTES.txt  conf  hcatalog  scripts
[root@hadoopserver2 hive]# cd conf
[root@hadoopserver2 conf]# ls
beeline-log4j.properties.template  hive-exec-log4j.properties.template
hive-default.xml.template          hive-log4j.properties.template
hive-env.sh.template               hive-site.xml
[root@hadoopserver2 conf]# vi hive-site.xml 
[root@hadoopserver2 conf]# hive
19/08/08 11:17:51 WARN conf.HiveConf: DEPRECATED: Configuration property hive.metastore.local no longer has any effect. Make sure to provide a valid value for hive.metastore.uris if you are connecting to a remote metastore.
19/08/08 11:17:51 WARN conf.HiveConf: HiveConf of name hive.metastore.local does not exist

Logging initialized using configuration in jar:file:/etc/hive/lib/hive-common-1.0.1.jar!/hive-log4j.properties
hive> select * from HDI
    > ;
OK
hdi.id	hdi.country	hdi.hdi	hdi.lifeex	hdi.mysch	hdi.eysch	hdi.gni
1	Norway	0.943	81	12	17	47557
2	Australia	0.929	81	12	18	34431
3	Netherlands	0.91	80	11	16	36402
4	United States	0.91	78	12	16	43017
5	New Zealand	0.908	80	12	18	23737
6	Canada	0.908	81	12	16	35166
7	Ireland	0.908	80	11	18	29322
8	Liechtenstein	0.905	79	10	14	83717
9	Germany	0.905	80	12	15	34854
10	Sweden	0.904	81	11	15	35837
11	Switzerland	0.903	82	11	15	39924
12	Japan	0.901	83	11	15	32295
13	Hong Kong China (SAR)	0.898	82	10	15	44805
14	Iceland	0.898	81	10	18	29354
15	Korea (Republic of)	0.897	80	11	16	28230
16	Denmark	0.895	78	11	16	34347
17	Israel	0.888	81	11	15	25849
18	Belgium	0.886	80	10	16	33357
19	Austria	0.885	80	10	15	35719
20	France	0.884	81	10	16	30462
21	Slovenia	0.884	79	11	16	24914
22	Finland	0.882	80	10	16	32438
23	Spain	0.878	81	10	16	26508
24	Italy	0.874	81	10	16	26484
25	Luxembourg	0.867	80	10	13	50557
26	Singapore	0.866	81	8	14	52569
27	Czech Republic	0.865	77	12	15	21405
28	United Kingdom	0.863	80	9	16	33296
29	Greece	0.861	79	10	16	23747
30	United Arab Emirates	0.846	76	9	13	59993
31	Cyprus	0.84	79	9	14	24841
32	Andorra	0.838	80	10	11	36095
33	Brunei Darussalam	0.838	78	8	14	45753
34	Estonia	0.835	74	12	15	16799
35	Slovakia	0.834	75	11	14	19998
36	Malta	0.832	79	9	14	21460
37	Qatar	0.831	78	7	12	107721
38	Hungary	0.816	74	11	15	16581
39	Poland	0.813	76	10	15	17451
40	Lithuania	0.81	72	10	16	16234
41	Portugal	0.809	79	7	15	20573
42	Bahrain	0.806	75	9	13	28169
43	Latvia	0.805	73	11	15	14293
44	Chile	0.805	79	9	14	13329
45	Argentina	0.797	75	9	15	14527
46	Croatia	0.796	76	9	13	15729
47	Barbados	0.793	76	9	13	17966
48	Uruguay	0.783	77	8	15	13242
49	Palau	0.782	71	12	14	9744
50	Romania	0.781	74	10	14	11046
51	Cuba	0.776	79	9	17	5416
52	Seychelles	0.773	73	9	13	16729
53	Bahamas	0.771	75	8	12	23029
54	Montenegro	0.771	74	10	13	10361
55	Bulgaria	0.771	73	10	13	11412
56	Saudi Arabia	0.77	73	7	13	23274
57	Mexico	0.77	77	8	13	13245
58	Panama	0.768	76	9	13	12335
59	Serbia	0.766	74	10	13	10236
60	Antigua and Barbuda	0.764	72	8	14	15521
61	Malaysia	0.761	74	9	12	13685
62	Trinidad and Tobago	0.76	70	9	12	23439
63	Kuwait	0.76	74	6	12	47926
64	Libyan Arab Jamahiriya	0.76	74	7	16	12637
65	Belarus	0.756	70	9	14	13439
66	Russian Federation	0.755	68	9	14	14561
67	Grenada	0.748	76	8	16	6982
68	Kazakhstan	0.745	67	10	15	10585
69	Costa Rica	0.744	79	8	11	10497
70	Albania	0.739	76	10	11	7803
71	Lebanon	0.739	72	7	13	13076
72	Saint Kitts and Nevis	0.735	73	8	12	11897
73	Venezuela (Bolivarian Republic of)	0.735	74	7	14	10656
74	Bosnia and Herzegovina	0.733	75	8	13	7664
75	Georgia	0.733	73	12	13	4780
76	Ukraine	0.729	68	11	14	6175
77	Mauritius	0.728	73	7	13	12918
78	The former Yugoslav Republic of Macedonia	0.728	74	8	13	8804
79	Jamaica	0.727	73	9	13	6487
80	Peru	0.725	74	8	12	8389
81	Dominica	0.724	77	7	13	7889
82	Saint Lucia	0.723	74	8	13	8273
83	Ecuador	0.72	75	7	14	7589
84	Brazil	0.718	73	7	13	10162
85	Saint Vincent and the Grenadines	0.717	72	8	13	8013
86	Armenia	0.716	74	10	12	5188
87	Colombia	0.71	73	7	13	8315
88	Iran (Islamic Republic of)	0.707	73	7	12	10164
89	Oman	0.705	73	5	11	22841
90	Tonga	0.704	72	10	13	4186
91	Azerbaijan	0.7	70	8	11	8666
92	Turkey	0.699	74	6	11	12246
93	Belize	0.699	76	8	12	5812
94	Tunisia	0.698	74	6	14	7281
95	Jordan	0.698	73	8	13	5300
96	Algeria	0.698	73	7	13	7658
97	Sri Lanka	0.691	74	8	12	4943
98	Dominican Republic	0.689	73	7	11	8087
99	Samoa	0.688	72	10	12	3931
100	Fiji	0.688	69	10	13	4145
101	China	0.687	73	7	11	7476
102	Turkmenistan	0.686	65	9	12	7306
103	Thailand	0.682	74	6	12	7694
104	Suriname	0.68	70	7	12	7538
105	El Salvador	0.674	72	7	12	5925
106	Gabon	0.674	62	7	13	12249
107	Paraguay	0.665	72	7	12	4727
108	Bolivia (Plurinational State of)	0.663	66	9	13	4054
109	Maldives	0.661	76	5	12	5276
110	Mongolia	0.653	68	8	14	3391
111	Moldova (Republic of)	0.649	69	9	11	3058
112	Philippines	0.644	68	8	11	3478
113	Egypt	0.644	73	6	11	5269
114	Occupied Palestinian Territory	0.641	72	8	12	2656
115	Uzbekistan	0.641	68	10	11	2967
116	Micronesia (Federated States of)	0.636	69	8	12	2935
117	Guyana	0.633	69	8	11	3192
118	Botswana	0.633	53	8	12	13049
119	Syrian Arab Republic	0.632	75	5	11	4243
120	Namibia	0.625	62	7	11	6206
121	Honduras	0.625	73	6	11	3443
122	Kiribati	0.624	68	7	12	3140
123	South Africa	0.619	52	8	13	9469
124	Indonesia	0.617	69	5	13	3716
125	Vanuatu	0.617	71	6	10	3950
126	Kyrgyzstan	0.615	67	9	12	2036
127	Tajikistan	0.607	67	9	11	1937
128	Viet Nam	0.593	75	5	10	2805
129	Nicaragua	0.589	74	5	10	2430
130	Morocco	0.582	72	4	10	4196
131	Guatemala	0.574	71	4	10	4167
132	Iraq	0.573	69	5	9	3177
133	Cape Verde	0.568	74	3	11	3402
134	India	0.547	65	4	10	3468
135	Ghana	0.541	64	7	10	1584
136	Equatorial Guinea	0.537	51	5	7	17608
137	Congo	0.533	57	5	10	3066
138	Lao People's Democratic Republic	0.524	67	4	9	2242
139	Cambodia	0.523	63	5	9	1848
140	Swaziland	0.522	48	7	10	4484
141	Bhutan	0.522	67	2	11	5293
142	Solomon Islands	0.51	67	4	9	1782
143	Kenya	0.509	57	7	11	1492
144	Sao Tome and Principe	0.509	64	4	10	1792
145	Pakistan	0.504	65	4	6	2550
146	Bangladesh	0.5	68	4	8	1529
147	Timor-Leste	0.495	62	2	11	3005
148	Angola	0.486	51	4	9	4874
149	Myanmar	0.483	65	4	9	1535
150	Cameroon	0.482	51	5	10	2031
151	Madagascar	0.48	66	5	10	824
152	Tanzania (United Republic of)	0.466	58	5	9	1328
153	Papua New Guinea	0.466	62	4	5	2271
154	Yemen	0.462	65	2	8	2213
155	Senegal	0.459	59	4	7	1708
156	Nigeria	0.459	51	5	8	2069
157	Nepal	0.458	68	3	8	1160
158	Haiti	0.454	62	4	7	1123
159	Mauritania	0.453	58	3	8	1859
160	Lesotho	0.45	48	5	9	1664
161	Uganda	0.446	54	4	10	1124
162	Togo	0.435	57	5	9	798
163	Comoros	0.433	61	2	10	1079
164	Zambia	0.43	49	6	7	1254
165	Djibouti	0.43	57	3	5	2335
166	Rwanda	0.429	55	3	11	1133
167	Benin	0.427	56	3	9	1364
168	Gambia	0.42	58	2	9	1282
169	Sudan	0.408	61	3	4	1894
170	C�te d'Ivoire	0.4	55	3	6	1387
171	Malawi	0.4	54	4	8	753
172	Afghanistan	0.398	48	3	9	1416
173	Zimbabwe	0.376	51	7	9	376
174	Ethiopia	0.363	59	1	8	971
175	Mali	0.359	51	2	8	1123
176	Guinea-Bissau	0.353	48	2	9	994
177	Eritrea	0.349	61	3	4	536
178	Guinea	0.344	54	1	8	863
179	Central African Republic	0.343	48	3	6	707
180	Sierra Leone	0.336	47	2	7	737
181	Burkina Faso	0.331	55	1	6	1141
182	Liberia	0.329	56	3	11	265
183	Chad	0.328	49	1	7	1105
184	Mozambique	0.322	50	1	9	898
185	Burundi	0.316	50	2	10	368
186	Niger	0.295	54	1	4	641
187	Congo (Democratic Republic of the)	0.286	48	3	8	280
Time taken: 0.905 seconds, Fetched: 187 row(s)
hive> cd
    > [root@hadoopserver2 conf]# cd
[root@hadoopserver2 ~]# mkdir data
[root@hadoopserver2 ~]# cd data
[root@hadoopserver2 data]# ls
[root@hadoopserver2 data]# wget http://stat-computing.org/dataexpo/2009/2006.csv.bz2
--2019-08-08 11:28:53--  http://stat-computing.org/dataexpo/2009/2006.csv.bz2
Resolving stat-computing.org (stat-computing.org)... 52.218.234.170
Connecting to stat-computing.org (stat-computing.org)|52.218.234.170|:80... connected.
HTTP request sent, awaiting response... 200 OK
Length: 115019195 (110M) [application/x-bzip2]
Saving to: ‘2006.csv.bz2’

100%[======================================>] 115,019,195 13.0MB/s   in 10s    

2019-08-08 11:29:04 (10.8 MB/s) - ‘2006.csv.bz2’ saved [115019195/115019195]

[root@hadoopserver2 data]# wget http://stat-computing.org/dataexpo/2009/2007.csv.bz2
--2019-08-08 11:29:09--  http://stat-computing.org/dataexpo/2009/2007.csv.bz2
Resolving stat-computing.org (stat-computing.org)... 52.218.249.123
Connecting to stat-computing.org (stat-computing.org)|52.218.249.123|:80... connected.
HTTP request sent, awaiting response... 200 OK
Length: 121249243 (116M) [application/x-bzip2]
Saving to: ‘2007.csv.bz2’

100%[======================================>] 121,249,243 12.0MB/s   in 12s    

2019-08-08 11:29:22 (9.76 MB/s) - ‘2007.csv.bz2’ saved [121249243/121249243]

[root@hadoopserver2 data]# wget http://stat-computing.org/dataexpo/2009/2008.csv.bz2
--2019-08-08 11:29:29--  http://stat-computing.org/dataexpo/2009/2008.csv.bz2
Resolving stat-computing.org (stat-computing.org)... 52.218.225.42
Connecting to stat-computing.org (stat-computing.org)|52.218.225.42|:80... connected.
HTTP request sent, awaiting response... 200 OK
Length: 113753229 (108M) [application/x-bzip2]
Saving to: ‘2008.csv.bz2’

100%[======================================>] 113,753,229 14.2MB/s   in 26s    

2019-08-08 11:29:55 (4.25 MB/s) - ‘2008.csv.bz2’ saved [113753229/113753229]

[root@hadoopserver2 data]# ls
2006.csv.bz2  2007.csv.bz2  2008.csv.bz2
[root@hadoopserver2 data]# bzip2 -kd 2006.csv.bz2 
[root@hadoopserver2 data]# bzip2 -kd 2007.csv.bz2 
[root@hadoopserver2 data]# bzip2 -kd 2008.csv.bz2 