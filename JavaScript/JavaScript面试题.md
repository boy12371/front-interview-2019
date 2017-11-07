[toc]

# 数字
## js 中， 0.1 + 0.2 === 0.3 是否为 true ?
**知识点：JavaScript在内部表示为64位的浮点数(double)**  
0.1 + 0.2 === 0.3 //false  
它们相加的结果并非刚好等于0.3,而是一个比较接近的数字，0.30000000000000004   
那么怎么判断0.1 + 0.2 和 0.3 是否相等呢？  
最常见的方法是设置一个误差范围值，通常称之为机器精度，对JavaScript来说，这个值通常是2^-52  
从ES6开始，该值定义在Number.EPSILON中，我们可以直接拿来用，也可以为ES6之前的版本写polyfill：  
```
if(!Number.EPSILON){
Number.EPSILON = Math.pow(2,-52); 
}
```
可以使用Number.EPSILION来比较两个数字是否相等（在指定的误差之内）：
```javascript
function numbersCloseEnoughToEqual(n1,n2){
    return Math.abs(n1 - n2) < Number.EPSILON;
}
var a = 0.1 + 0.2;
var b = 0.3;
numbersCloseEnoughToEqual(a,b) //true
```
## 在不知道浮点数位数时应该怎样判断两个浮点数之和与第三数是否相等？
如上，设置一个安全范围，并进行比较

# 数组
## 伪数组转换为数组
```javascript

1. 遍历复制元素
function makeArray(fakearr){
    var result = [];
    for(var i=0,len = arrayLike.length; i< len ;i++){
        result.push(fakearr[i]);
    }
    return result;
}
2. 方法借用
var arr = Array.prototype.slice.call(fakearr);

3. ES6 
var arr = Array.from();
```
## 数组去重
```javascript
// 方法一：
var arr1 =[1,2,2,2,3,3,3,4,5,6],
    arr2 = [];
for(var i = 0,len = arr1.length; i< len; i++){
    if(arr2.indexOf(arr1[i]) < 0){
        arr2.push(arr1[i]);
    }
}
document.write(arr2); // 1,2,3,4,5,6


set集合转数组
let set = new Set([9,2,2,3,1,1]),
    array = [...set];
 console.log(array) //  9 2 3 1 
```
#  字符串

## 优化下面字符串操作 
 ```
 var str="我喜欢我可爱的女朋友，"；
str=str+"她叫喵喵，";
str=str+"她时而可爱，时而认真，";
str=str+"她那天真的笑声可以让人忘掉一切烦恼。";
console.log(str);
```
这里的优化主要是对加号操作符的优化，因为加号在JavaScript中非常耗时和耗内存，需要经过以下六步：  
1、首先开辟一块临时空间，存储字符串，  
2、然后在开辟一块空间  
3、把str中的字符串复制到刚刚开辟的空间  
4、在把需要连接的字符串复制到str后面  
5、str指向这块空间  
6、回收str原来的空间和临时空间  
优化的方法是使用数组的push方法，数组是连续的存储空间，可以省下很多步
```
var res=[];
var str="我喜欢我可爱的女朋友，"；
res.push(str);
res.push("她叫喵喵，");
res.push("她时而可爱，时而认真，");
res.push("她那天真的笑声可以让人忘掉一切烦恼。");
console.log(res.join(""));
```
# 作用域

在面试时,作用域并不是一个很好问的知识点, 一般会问的是 es6 中 let 与 var 的区别, 或者列举代码,然后通过对代码的解读来看你对作用域的掌握比较方便.  

# JavaScript的值类型和引用类型


## 如何将值类型的变量以引用的方式传递?
通过将基础类型包装 (boxing) 可以以引用的方式传递.(复杂见注①)
```
funciton foo(wapper){
    wrapper.a = 42;
}
var obj = {
    a : 2
}
foo(obj);
obj.a; // 42
```

面试写代码的话, 可以通过 如何编写一个 json 对象的拷贝函数 等类似的问题来考察对引用的了解. 不过笔者偶尔会有恶趣味, 喜欢先问应聘者对于 == 的 === 的区别的了解. 然后再问 [1] == [1] 是 true 还是 false. 如果基础不好的同学可能会被自己对于 == 和 === 的结论影响然后得出错误的结论.

注①: 对于技术好的, 希望能直接反驳这个问题本身是有问题的, 比如讲清楚 Javascript 中没有引用传递只是传递引用. 参见 Is JavaScript a pass-by-reference or pass-by-value language?. 虽然说是复杂版, 但是这些知识对于 3年经验的同学真的应该是很简单的问题了.

另外如果简历中有写 C++, 则必问 指针与引用的区别.



# ES6 新特性

推荐阅读阮一峰的 [《ECMAScript 6 入门》](http://es6.ruanyifeng.com/)

比较简单的会问 `let` 与 `var` 的区别, 以及 `箭头函数` 与 `function` 的区别等等.

深入的话, es6 有太多细节可以深入了. 比如结合 `引用` 的知识点来询问 `const` 方面的知识. 结合 `{}` 的使用与缺点来谈 `Set, Map` 等. 比如私有化的问题与 `symbol` 等等.

其他像是 `闭包是什么?` 这种问烂了问题已经感觉没必要问了, 取而代之的是询问闭包应用的场景更加合理. 比如说, 如果回答者通常使用闭包实现数据的私有, 那么可以接着问 es6 的一些新特性 (例如 `class`, `symbol`) 能否实现私有, 如果能的话那为什么要用闭包? 亦或者是什么闭包中的数据/私有化的数据的内存什么时候释放? 等等.

`...` 的使用上, 如何实现一个数组的去重 (使用 Set 可以加分).

## const 定义的 Array 中间元素能否被修改? 如果可以, 那 const 修饰对象有什么意义?

其中的值可以被修改. 意义上, 主要保护引用不被修改 (如用 [Map](https://developer.mozilla.org/en/docs/Web/JavaScript/Reference/Global_Objects/Map) 等接口对引用的变化很敏感, 使用 const 保护引用始终如一是有意义的), 也适合用在 immutable 的场景.

暂时写上这些, 之后会慢慢整理, 如果内容比较多可能单独归一类来讨论.
