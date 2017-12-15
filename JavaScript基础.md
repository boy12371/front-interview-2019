[toc]
# JavaScript的数据类型
* 基本数据类型：Number，String，Boolean，Undefined，Null
* 复杂数据类型：Object，Array，Function，RegExp，Date，Error
* 全局数据类型：Math

## 类型判断
> Javascript 的类型判断其实是个挺折磨人的话题, 不然也不会有 Typescript 出现了.  
在类型判断的问题上, 基础上 推荐阅读 lodash 的源代码.  
这类问题一般只是简单的开场, 不会因为说你不知道 undefined == null 的结果是 true就一票否决一个人. 只是根据个人经验看来，这个问题答不清楚的有不小的概率属于基础较差. 如果你对这种问题没有任何概念, 也许要反思一下是不是该找本书过一下 Js 的基础了.  
另外在这个问题上, 对使用 TypeScript 以及 flow 同学会有一定的加分.

## javascript的typeof返回哪些数据类型

* Ｏbject(null) number function boolean underfind String symbol(ES6);

## 例举3种强制类型转换和2种隐式类型转换?

* 强制（parseInt,parseFloat,number）隐式（== – ===）；


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
\[](任意数组)|""|0|true
\[9](1个数字元素)|"9"|0|true
\['a'](其他数组)|使用join()方法|NaN|true
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

### ES6 /Object.is()
```
var a = 2 / 'foo';
var b = -3 * 0;

Object.is(a,NaN); // true
Object.is(b,-0); //true
Object.is(b,0); //false

ES6之前polyfill

if(!Object.is){
    Object.is = function(v1,v2){
    //判断是否是-0
        if(v1 === 0 && v2 === 0){
        return 1 / v1 === 1 /v2;
        }
    //判断是否为NaN
        if (v1!==v1){
            return v2 !==v2;
        }
        return v1 ===v2 ;
    }
}
```

# 数字
知识点：JavaScript在内部表示为64位的浮点数(double)
## 整数的安全范围
能够被安全呈现的最大整数是2^53-1
即 9007199254740991,在ES6中被定义为Number.MAX_SAFE_INTEGER.最小整数是-9007199254740991.,在ES6中被定义为Number.MIN_SAFE_INTEGER  
检测是否是一个安全的整数，可以使用ES6的Number.isSafeInteger()方法

# 字符串

# 数组


## 伪数组
伪数组（类数组）：无法直接调用数组方法或期望length属性有什么特殊的行为，但仍可以对真正数组遍历方法来遍历它们。典型的是函数的argument参数，还有像调用getElementsByTagName,document.childNodes之类的,它们都返回NodeList对象都属于伪数组。可以使用Array.prototype.slice.call(fakeArray)将数组转化为真正的Array对象。


## 数组方法
方法|描述
----|---
concat()|连接两个或更多的数组，并返回结果。
copyWithin()|从数组的指定位置拷贝元素到数组的另一个指定位置中。
every()	|检测数值元素的每个元素是否都符合条件。
fill()	|使用一个固定值来填充数组。
filter()|	检测数值元素，并返回符合条件所有元素的数组。
find()|	返回符合传入测试（函数）条件的数组元素。
findIndex()|	返回符合传入测试（函数）条件的数组元素索引。
forEach()|	数组每个元素都执行一次回调函数。
indexOf()|	搜索数组中的元素，并返回它所在的位置。
join()|	把数组的所有元素放入一个字符串。
lastIndexOf()|	返回一个指定的字符串值最后出现的位置，在一个字符串中的指定位置从后向前搜索。
map()|	通过指定函数处理数组的每个元素，并返回处理后的数组。
pop()|	删除数组的最后一个元素并返回删除的元素。
push()|	向数组的末尾添加一个或更多元素，并返回新的长度。
reduce()|	将数组元素计算为一个值（从左到右）。
reduceRight()|	将数组元素计算为一个值（从右到左）。
reverse()|	反转数组的元素顺序。
shift()|	删除并返回数组的第一个元素。
slice()|	选取数组的的一部分，并返回一个新数组。
some()|	检测数组元素中是否有元素符合指定条件。
sort()|	对数组的元素进行排序。
splice()|	从数组中添加或删除元素。
toString()|	把数组转换为字符串，并返回结果。
unshift()|	向数组的开头添加一个或更多元素，并返回新的长度。
valueOf()|	返回数组对象的原始值。

## ES6数组方法

方法 | 描述
---|---
Array.of()|创建一个包含所有参数的数组。解决new Array()传入数字更改length的问题
Array.from()|将伪数组转换为数组
find()|如上
findIndex()|如上
fill()|如上
copyWithin()|如上


# JavaScript的值类型和引用类型

**我们向函数传递对象a的时候，实际上是将引用a的一个复本复制给x**  

JavaScript有两种类型的数据，值类型和引用类型，一般的数字，字符串，布尔值都是值类型，存放在**栈**中，而对象，函数，数组等是引用类型，存放在**堆**中，对引用类型的复制其实是引用复制，相当于复制着地址，对象并没有真正的复制。
```
var a=5;var b=a;a=null;    //那么b是5
var a={},var b=a;b.name="mbj";
console.log(a.name);   //mbj，
//因为a，b指向同一个对象
a=null;console.log(typeof b);  //object，a=null，
//只是a不再指向该对象，但是这个对象还  
//是在堆中确确实实的存在，b依然指向它。
```

# 作用域
## 谈一谈JavaScript作用域链
* 当执行一段JavaScript代码（全局代码或函数）时，JavaScript引擎会创建为其创建一个作用域又称为执行上下文（Execution Context），在页面加载后会首先创建一个全局的作用域，然后每执行一个函数，会建立一个对应的作用域，从而形成了一条作用域链。每个作用域都有一条对应的作用域链，链头是全局作用域，链尾是当前函数作用域。

* 作用域链的作用是用于解析标识符，当函数被创建时（不是执行），会将this、arguments、命名参数和该函数中的所有局部变量添加到该当前作用域中，当JavaScript需要查找变量X的时候（这个过程称为变量解析），它首先会从作用域链中的链尾也就是当前作用域进行查找是否有X属性，如果没有找到就顺着作用域链继续查找，直到查找到链头，也就是全局作用域链，仍未找到该变量的话，就认为这段代码的作用域链上不存在x变量，并抛出一个引用错误（ReferenceError）的异常。

## js 中什么类型是引用传递,什么类型是值传递?
简单点说, 对象是引用传递, 基础类型是值传递, 

引用传递和值传递是一个非常简单的问题, 也是理解 Javascript 中的内存方面问题的一个基础. 如果不了解引用可能很难去看很多问题
  