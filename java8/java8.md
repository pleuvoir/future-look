# Java-8-Tutorials #


## forEach ##
### map ###
```java
//1.7
Map<String, Object> map = new HashMap<>();
map.put("A","map-A");
map.put("B","map-B");
map.put("C","map-C");
map.put("D","map-D");
for (Entry<String, Object> entry : map.entrySet()) {
	System.out.println("key:"+entry.getKey()+"  value:"+entry.getValue());
}
//1.8
map.forEach((k,v)->{
	System.out.println("key:"+k+"  value:"+v);
});

map.forEach((k,v)->{
	if(k.equals("A")){
		System.out.println(v);
	};
});
```

### list ###
```java
//1.7
List<Integer> list = Arrays.asList(1,2,3,4);
for (Integer s : list) {
System.out.println(s);
}

//1.8
list.forEach(s->System.out.println(s));

list.forEach(s->{
if(s.equals("A")){
	System.out.println(s);
}
});
list.stream().
	     filter(s->s.compareTo(2)>0).
	     filter(s->s.compareTo(4)<0).
	     //forEach(s->System.out.println(s));
	     forEach(System.out::println);

User user = new User("fw","1@qq.com");
User user2 = new User("fw2","2@qq.com");
List<User> userList = Arrays.asList(user,user2);
List<String> collect = userList.stream()
					.map(u->u.getName())
					.collect(Collectors.toList());
collect.forEach(n->{System.out.println(n);});

	private  static class User{
		public User(String name, String email) {
			super();
			this.name = name;
			Email = email;
		}
		String name;
		String Email;
		public String getName() {
			return name;
		}
		public String getEmail() {
			return Email;
		}
		
	}
```

## Comparator  ##
```java
List<User> userList = Arrays.asList(new User("scott", 18),new User("andy", 20));
//1.7只能使用Collections.sort
Collections.sort(userList, new Comparator<User>() {
	@Override
	public int compare(User o1, User o2) {
		return o1.getAge()-o2.getAge();
	}
});
Collections.sort(userList, new Comparator<User>() {
	@Override
	public int compare(User o1, User o2) {
		return o1.getName().compareTo(o2.getName());
	}
});
//1.8可以直接用list的sort方法
Comparator<User> c = (o1,o2)->o2.getAge()-o1.getAge();
userList.sort(c);
userList.forEach(u->System.out.println(u));
```