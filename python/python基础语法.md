---
tags: python
categories: python
title: python基础语法
---


## 定义方法

### 返回多个参数
```
#求list元素之和
def square_of_sum(L):

    constant = 0
    sum_ = 0
    for x in L:
        sum_+=  x*x
    return sum_,constant

print(square_of_sum([1, 2, 3, 4, 5]))
a,b = square_of_sum([1, 2, 3, 4, 5])
print(a,b)

```
结果:
```
(55, 0)
55 0
```
**python的函数返回多值其实就是返回一个tuple,也就是说可以返回多值,在语法上，返回一个tuple可以省略括号**

<!-- more -->


### 定义默认参数
```
#计算计算x的N次方的函数(这里设置了默认参数则计算平方,方法调用时无需传默认参数)
def power(x, n=2):
    s = 1
    while n > 0:
        n = n - 1
        s = s * x
    return s

print(power(6))
```


### 可变参数(简化调用)
```
# 定义可变参数
def average(*args):
    print(sum(args)/len(args))

average(1,2,3)
```

## 循环

### 循环几次
```
for i in range(2):
    print(i)
```

>range()函数可以创建一个数列：

>range(1, 101)
[1, 2, 3, ..., 100]


### 类似java foreach
```
 for i in list:
     print(i)
```

### 类似java普通for循环
```
for i,v in enumerate(list):
     print(i,list[i])
```

### while循环
```
#simple while iterator
sum = 0
x = 1
while True:
    sum = sum + x
    x = x + 1
    if x > 100:
        break
print(sum)
```

### 多重循环
```
#多重循环
for x in ['A', 'B', 'C']:
    for y in ['1', '2', '3']:
        print(x+y)
```
> x 每循环一次，y 就会循环 3 次，这样，我们可以打印出一个全排列：
> A1
> A2
> A3
> B1
> B2
> B3
> C1
> C2
> C3


## if else
```
age = 19
if age >= 18:
    print('adult')
elif age >= 6:
    print('teenager')
elif age >= 3:
    print('kid')
else:
    print('baby')
```

## 集合

### list
```
#define a list
list = ['apple','orange']
##add an object
list.append('banana')
##remeove an object
list.remove('apple')
##replace an object
list[0] = 'potato'
###list size
len(list)
```


### tuple
> tuple是另一种有序的列表，中文翻译为“ 元组 ”。tuple 和 list 非常类似，但是，tuple一旦创建完毕，就不能修改了。
> 创建tuple和创建list唯一不同之处是用( )替代了[ ]

```
#create a tuple
_tuple_ = ('a', 'b', ['A', 'B'])
tuple__ = _tuple_[2]
tuple__[0] = 'C'
javafor(_tuple_)
```
值得注意的是这里说的不可变指的是tuple的元素,其中list的元素可变,所以输出结果为`['C', 'B']`


## dict(格式类似于json,数据结构类似于map,无序的)
```
#define a dict
d = {
    'Adam': 95,
    'Lisa': 85,
    'Bart': 59
}
#取出
print('Adam',str(d.get('Adam')))

#重新赋值
d['Adam'] = 'fw'

#遍历
for k in d:
    print(k+":",d[k])
```


## set(和java类似)
```
#create a set
list = ['lx','fw','lx']
#将一个List转换为set
s = set(list)
print(s)
#这里新增元素和list不同list是append(),而这是add()
s.add('duck')
s.remove('lx')
print(s)
```
结果:
```
{'lx', 'fw'}
{'duck', 'fw'}
```


## 切片操作(取部分元素操作)

### list和tuple的切片
```
#range()函数可以创建一个数列
L = range(1, 101)
#前10个数
print L[0:10]
#3的倍数
print L[2::3]
#不大于50的5的倍数
print L[4:50:5]
#第一个参数表示从索引几开始取,第二个表示结束索引,第三个参数表示隔几位一取
```
**把list换成tuple，切片操作完全相同**

### 字符串的切片
```
#首字母大写
def firstCharUpper(s):
    return s[0:1].upper()+s[1:]

print(firstCharUpper('hello'))
```