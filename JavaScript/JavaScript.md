[toc]

# 基础

## JavaScript的数据类型

* 基本数据类型：Number，String，Boolean，Undefined，Null

* 复杂数据类型：Object，Array，Function，RegExp，Date，Error

* 全局数据类型：Math

## javascript的typeof返回哪些数据类型

* Ｏbject(null) number function boolean underfind String symbol(ES6);

## 例举3种强制类型转换和2种隐式类型转换?

* 强制（parseInt,parseFloat,number）隐式（== – ===）；

## 数组方法pop() push() unshift() shift()

* Push()尾部添加 pop()尾部删除
Unshift()头部添加 shift()头部删除

## js类型转换

值|字符串|数字|布尔值|对象
---|---|---|---|---
undefined|"undefined"|NaN|false|throws TypeError
null|'null'|0|false|throws TypeError
true|'true'|1| |new Boolean(true)
false|'flase'|0| |new Boolean(false)
""(空字符串)| |0|false|new String("")
"1.2"(非空，数组)| |1.2|false|new String("1.2")
"one"(非空，非数字)| |NaN|true|new String("one")
0|"0"| |false|new Number(0)
-0|"0"| |false|new Number(-0)
NaN|"NaN"| |false|new Number(NaN)
Infinity|"Infinity"| |true|new Number(Infinity)
-Infinity|"-Infinity"| |true|new Number(-Infinity)
1(无穷大，非零)|"1"| |true|new Number(1)
{}(任意对象)|toString()|toValueOf()|true
[](任意数组)|""|0|true
[9](1个数字元素)|"9"|0|true
['a'](其他数组)|使用join()方法|NaN|true
function(){}(任意函数)| |NaN|true



## null和undefined的区别？
* null是一个表示"无"的对象，转为数值时为0；undefined是一个表示"无"的原始值，转为数值时为NaN。
* undefined：  
（1）变量被声明了，但没有赋值时，就等于undefined。  
（2) 调用函数时，应该提供的参数没有提供，该参数等于undefined。  
（3）对象没有赋值的属性，该属性的值为undefined。  
（4）函数没有返回值时，默认返回undefined。
* null：  
（1） 作为函数的参数，表示该函数的参数不是对象。  
（2） 作为对象原型链的终点。

## 相等运算符
* 

### ===运算符
> 首先计算操作数的值，然后比较这两个值，比较过程中没有任何类型转换

* 如果两个值都是null或者都是undefined，则它们不相等
* 如果其中一个值是NaN,或者两个值都是NaN,则他们不相等，通过x!==x来判断x 是否为NaN，只有在x为NaN的时候，这个表达式的值才为true
* 如果一个值为0，另一个值为-0，则它们同样相等。

### ==运算符
> 和恒等运算符相似，但相等的运算符的比较并不严格，如果两个操作数不是同一类型，那么相等运算符会尝试一些类型转换，然后进行比较

* null == undefined
* 字符串和数字，先将字符串转为数字，然后使用转换后的值进行比较
* 如果一个值是true,则将其转换为1再进行比较，false->0
* 如果一个值是对象，另一个值是数字或字符串，则将对象转换为原始值，在进行比较。toString(),valueOf()
* 

# call和apply的区别

call和apply，假设要改变fn函数内部的this的指向，指向obj，那么可以fn.call(obj);或者fn.apply(obj);那么问题来了，call和apply的区别是什么，其是call和apply的区别在于参数，他们两个的第一个参数都是一样的，表示调用该函数的对象，apply的第二个参数是数组，是[arg1,arg2,arg3]这种形式，而call是arg1,arg2,arg3这样的形式。还有一个bind函数。

* Object.call(this,obj1,obj2,obj3)
* Object.apply(this,arguments)

# new操作符具体干了什么呢?
* （1）创建一个空对象，并且 this 变量引用该对象，同时还继承了该函数的原型。
* （2）属性和方法被加入到 this 引用的对象中。
* （3）新创建的对象由 this 所引用，并且最后隐式的返回 this 。

```javascript
var obj={};
obj.__proto__=fn.prototype;
fn.call(obj);
```
# 事件委托是什么

* 让利用事件冒泡的原理，让自己的所触发的事件，让他的父元素代替执行！
事件委托指的是，不再事件的发生地设立监听函数，而是在事件发生地的父元素或者祖先元素设置监听器函数，这样可以大大提高性能，因为可以减少绑定事件的元素，比如：
```
<ul>
 <li></li>
 <li></li>
 <li></li>
</ul>
```
要给li元素绑定click事件，使用事件委托机制的话，就只需要给ul绑定click事件就行了，这样就不需要给每个li'绑定click事件，减小内存占用，提高效率，有兴趣的童鞋可以去看看jQuery的live，bind，on，delegate函数的区别，这几个函数就采用了事件委托机制。
。
# 闭包是什么，有什么特性，对页面有什么影响?简要介绍你理解的闭包

* 闭包就是能够读取其他函数内部变量的函数。

```javascript
function a(x){
       var tem=3;
      function b(y){
          console.log(x+y+(++tem));
     }
}
```
a函数中的b函数就是闭包了，b函数可以使用a函数的局部变量，参数，最典型的闭包应该是下面这样，将定义在函数中的函数作为返回值
```javascript
function a(x){
       var tem=3;
      function b(y){
          console.log(x+y+(++tem));
     }
return b;
}
```
闭包的另一种作用是隔离作用域，请看下面这段代码
```javascript
for(var i=0;i<2;i++){
      setTimeout(function(){
              console.log(i);
        },0);
}
```
上面这段代码的执行结果是2,2而不是0,1，因为等for循环出来后，执行setTimeout中的函数时，i的值已经变成了2，这就是没有隔离作用域所造成的，请看下面代码
```javascript
for(var i=0;i<2;i++){
      (function(i){
             setTimeout(function(){
              console.log(i);
        },0)
    })(i);
}
```
这样就会输出0,1，我们的立即执行函数创建了一个作用域，隔离了外界的作用域，闭包的缺点是，因为内部闭包函数可以访问外部函数的变量，所以外部函数的变量不能被释放，如果闭包嵌套过多，会导致内存占用大，要合理使用闭包。


# 说一下什么是javascript的同源策略？

* 一段脚本只能读取来自于同一来源的窗口和文档的属性，这里的同一来源指的是主机名、协议和端口号的组合


# 如何阻止事件冒泡和默认事件
 事件处理机制：IE是事件冒泡、firefox同时支持两种事件模型，也就是：捕获型事件和冒泡型事件
```javascript
function stopBubble(e)
{
    if (e && e.stopPropagation)
        e.stopPropagation()
    else
        window.event.cancelBubble=true
}
return false
```

# 哪些常见操作会造成内存泄漏？
>* 内存泄漏指任何对象在您不再拥有或需要它之后仍然存在。
垃圾回收器定期扫描对象，并计算引用了每个对象的其他对象的数量。如果一个对象的引用数量为 0（没有其他对象引用过该对象），或对该对象的惟一引用是循环的，那么该对象的内存即可回收。
setTimeout 的第一个参数使用字符串而非函数的话，会引发内存泄漏。
闭包、控制台日志、循环（在两个对象彼此引用且彼此保留时，就会产生一个循环）


# 谈一谈JavaScript作用域链
>* 当执行一段JavaScript代码（全局代码或函数）时，JavaScript引擎会创建为其创建一个作用域又称为执行上下文（Execution Context），在页面加载后会首先创建一个全局的作用域，然后每执行一个函数，会建立一个对应的作用域，从而形成了一条作用域链。每个作用域都有一条对应的作用域链，链头是全局作用域，链尾是当前函数作用域。

>* 作用域链的作用是用于解析标识符，当函数被创建时（不是执行），会将this、arguments、命名参数和该函数中的所有局部变量添加到该当前作用域中，当JavaScript需要查找变量X的时候（这个过程称为变量解析），它首先会从作用域链中的链尾也就是当前作用域进行查找是否有X属性，如果没有找到就顺着作用域链继续查找，直到查找到链头，也就是全局作用域链，仍未找到该变量的话，就认为这段代码的作用域链上不存在x变量，并抛出一个引用错误（ReferenceError）的异常。

# 如何理解JavaScript原型链
>* JavaScript中的每个对象都有一个prototype属性，我们称之为原型，而原型的值也是一个对象，因此它也有自己的原型，这样就串联起来了一条原型链，原型链的链头是object,它的prototype比较特殊，值为null。

>* 原型链的作用是用于对象继承，函数A的原型属性(prototype property)是一个对象，当这个函数被用作构造函数来创建实例时，该函数的原型属性将被作为原型赋值给所有对象实例，比如我们新建一个数组，数组的方法便从数组的原型上继承而来。

>* 当访问对象的一个属性时, 首先查找对象本身, 找到则返回; 若未找到, 则继续查找其原型对象的属性(如果还找不到实际上还会沿着原型链向上查找, 直至到根). 只要没有被覆盖的话, 对象原型的属性就能在所有的实例中找到，若整个原型链未找到则返回undefined


#  如何解决跨域问题 
## JSONP：  

原理是：动态插入script标签，通过script标签引入一个js文件，这个js文件载入成功后会执行我们在url参数中指定的函数，并且会把我们需要的json数据作为参数传入。

由于同源策略的限制，XmlHttpRequest只允许请求当前源（域名、协议、端口）的资源，为了实现跨域请求，可以通过script标签实现跨域请求，然后在服务端输出JSON数据并执行回调函数，从而解决了跨域的数据请求。

优点是兼容性好，简单易用，支持浏览器与服务器双向通信。缺点是只支持GET请求。

JSONP：json+padding（内填充），顾名思义，就是把JSON填充到一个盒子里
```
<script>
    function createJs(sUrl){

        var oScript = document.createElement('script');
        oScript.type = 'text/javascript';
        oScript.src = sUrl;
        document.getElementsByTagName('head')[0].appendChild(oScript);
    }

    createJs('jsonp.js');

    box({
       'name': 'test'
    });

    function box(json){
        alert(json.name);
    }
</script>
```
## CORS
服务器端对于CORS的支持，主要就是通过设置Access-Control-Allow-Origin来进行的。如果浏览器检测到相应的设置，就可以允许Ajax进行跨域的访问。
## 通过修改document.domain来跨子域
将子域和主域的document.domain设为同一个主域.前提条件：这两个域名必须属于同一个基础域名!而且所用的协议，端口都要一致，否则无法利用document.domain进行跨域

主域相同的使用document.domain
## 使用window.name来进行跨域
window对象有个name属性，该属性有个特征：即在一个窗口(window)的生命周期内,窗口载入的所有的页面都是共享一个window.name的，每个页面对window.name都有读写的权限，window.name是持久存在一个窗口载入过的所有页面中的
## 使用HTML5中新引进的window.postMessage方法来跨域传送数据
还有flash、在服务器上设置代理页面等跨域方式。个人认为window.name的方法既不复杂，也能兼容到几乎所有浏览器，这真是极好的一种跨域方法。

# 创建ajax过程

(1)创建XMLHttpRequest对象,也就是创建一个异步调用对象.

(2)创建一个新的HTTP请求,并指定该HTTP请求的方法、URL及验证信息.

(3)设置响应HTTP请求状态变化的函数.

(4)发送HTTP请求.

(5)获取异步调用返回的数据.

(6)使用JavaScript和DOM实现局部刷新.

# Javascript垃圾回收方法

## 标记清除（mark and sweep）
这是JavaScript最常见的垃圾回收方式，当变量进入执行环境的时候，比如函数中声明一个变量，垃圾回收器将其标记为“进入环境”，当变量离开环境的时候（函数执行结束）将其标记为“离开环境”。

垃圾回收器会在运行的时候给存储在内存中的所有变量加上标记，然后去掉环境中的变量以及被环境中变量所引用的变量（闭包），在这些完成之后仍存在标记的就是要删除的变量了

## 引用计数(reference counting)
在低版本IE中经常会出现内存泄露，很多时候就是因为其采用引用计数方式进行垃圾回收。引用计数的策略是跟踪记录每个值被使用的次数，当声明了一个 变量并将一个引用类型赋值给该变量的时候这个值的引用次数就加1，如果该变量的值变成了另外一个，则这个值得引用次数减1，当这个值的引用次数变为0的时 候，说明没有变量在使用，这个值没法被访问了，因此可以将其占用的空间回收，这样垃圾回收器会在运行的时候清理掉引用次数为0的值占用的空间。

在IE中虽然JavaScript对象通过标记清除的方式进行垃圾回收，但BOM与DOM对象却是通过引用计数回收垃圾的， 
也就是说只要涉及BOM及DOM就会出现循环引用问题。


# javascript对象的几种创建方式

1，工厂模式

2，构造函数模式

3，原型模式

4，混合构造函数和原型模式

5，动态原型模式

6，寄生构造函数模式

7，稳妥构造函数模式

# javascript继承的6种方法

1，原型链继承

2，借用构造函数继承

3，组合继承(原型+借用构造)

4，原型式继承

5，寄生式继承

6，寄生组合式继承

# 创建ajax的过程

(1)创建`XMLHttpRequest`对象,也就是创建一个异步调用对象.

(2)创建一个新的`HTTP`请求,并指定该`HTTP`请求的方法、`URL`及验证信息.

(3)设置响应`HTTP`请求状态变化的函数.

(4)发送`HTTP`请求.

(5)获取异步调用返回的数据.

(6)使用JavaScript和DOM实现局部刷新.


var xmlHttp = new XMLHttpRequest();

xmlHttp.open('GET','demo.php','true');

xmlHttp.send()

xmlHttp.onreadystatechange = function(){

    if(xmlHttp.readyState === 4 & xmlHttp.status === 200){

    }

}

## ajax的缺点
  1、ajax不支持浏览器back按钮。

  2、安全问题 AJAX暴露了与服务器交互的细节。

  3、对搜索引擎的支持比较弱。

  4、破坏了程序的异常机制。

  5、不容易调试。
  
# 说说严格模式的限制

严格模式主要有以下限制：

变量必须声明后再使用

函数的参数不能有同名属性，否则报错

不能使用with语句

不能对只读属性赋值，否则报错

不能使用前缀0表示八进制数，否则报错

不能删除不可删除的属性，否则报错

不能删除变量delete prop，会报错，只能删除属性delete global[prop]

eval不会在它的外层作用域引入变量

eval和arguments不能被重新赋值

arguments不会自动反映函数参数的变化

不能使用arguments.callee

不能使用arguments.caller

禁止this指向全局对象

不能使用fn.caller和fn.arguments获取函数调用的堆栈

增加了保留字（比如protected、static和interface）
设立”严格模式”的目的，主要有以下几个：

消除Javascript语法的一些不合理、不严谨之处，减少一些怪异行为;

消除代码运行的一些不安全之处，保证代码运行的安全；

提高编译器效率，增加运行速度；

为未来新版本的Javascript做好铺垫。




# 在Javascript中什么是伪数组？如何将伪数组转化为标准数组？

伪数组（类数组）：无法直接调用数组方法或期望length属性有什么特殊的行为，但仍可以对真正数组遍历方法来遍历它们。典型的是函数的argument参数，还有像调用getElementsByTagName,document.childNodes之类的,它们都返回NodeList对象都属于伪数组。可以使用Array.prototype.slice.call(fakeArray)将数组转化为真正的Array对象。
```javascript
function log(){
      var args = Array.prototype.slice.call(arguments);  
//为了使用unshift数组方法，将argument转化为真正的数组
      args.unshift('(app)');
 
      console.log.apply(console, args);
};
```

# Javascript中callee和caller的作用？

* caller是返回一个对函数的引用，该函数调用了当前函数；
* callee是返回正在被执行的function函数，也就是所指定的function对象的正文。


JavaScript变量提升请看下面代码
```javascript
var bar=1;
function test(){
  console.log(bar);     //undeifned
  var bar=2; 
  console.log(bar);  //2
}
test();
```
为什么在test函数中会出现上述结果呢，这就是JavaScript的变量提升了，虽然变量bar的定义在后面，不过浏览器在解析的时候，会把变量的定义放到最前面，上面的test函数相当于
```javascript
function test(){
  var bar;
  console.log(bar);   //undefined
  bar=2; 
  console.log(bar);   //2
}
```
再看
```javascript
var foo=function(){  console.log(1); }
function foo(){  console.log(2); }
foo();  //结果为1
同样的，函数的定义也会到提升到最前面，上面的代码相当于
function foo(){  console.log(2); }
var foo;
foo=funciton(){ console.log(1); }
foo();   //1
```


# 优化下面代码 
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

# JavaScript的值类型和引用类型

JavaScript有两种类型的数据，值类型和引用类型，一般的数字，字符串，布尔值都是值类型，存放在栈中，而对象，函数，数组等是引用类型，存放在堆中，对引用类型的复制其实是引用复制，相当于复制着地址，对象并没有真正的复制。
```
var a=5;var b=a;a=null;    //那么b是5
var a={},var b=a;b.name="mbj";
console.log(a.name);   //mbj，
//因为a，b指向同一个对象
a=null;console.log(typeof b);  //object，a=null，
//只是a不再指向该对象，但是这个对象还  
//是在堆中确确实实的存在，b依然指向它。
```
