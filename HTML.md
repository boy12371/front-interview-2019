[TOC]

# XHTML和HTML有什么区别
>* HTML是一种基本的WEB网页设计语言，XHTML是一个基于XML的置标语言
>最主要的不同：
>* XHTML 元素必须被正确地嵌套。
>* XHTML 元素必须被关闭。
>* 标签名必须用小写字母。
>XHTML 文档必须拥有根元素。

# DOCTYPE

## HTML5 为什么只需要写 !DOCTYPE HTML？
>* HTML5 不基于 SGML，因此不需要对DTD进行引用，但是需要doctype来规范浏览器的行为（让浏览器按照它们应该的方式来运行）；而HTML4.01基于SGML,所以需要对DTD进行引用，才能告知浏览器文档所使用的文档类型。

## Doctype作用？标准模式与兼容模式各有什么区别?
>* !DOCTYPE声明位于位于HTML文档中的第一行，处于html 标签之前。告知浏览器的解析器用什么文档标准解析这个文档。DOCTYPE不存在或格式不正确会导致文档以兼容模式呈现。
>* 标准模式的排版 和JS运作模式都是以该浏览器支持的最高标准运行。在兼容模式中，页面以宽松的向后兼容的方式显示,模拟老式浏览器的行为以防止站点无法工作。

# HTML5
## html5有哪些新特性、移除了那些元素？
> *HTML5 现在已经不是 SGML 的子集，主要是关于图像，位置，存储，多任务等功能的增加。
### 增加的元素
>* 绘画 canvas
>* 用于媒介回放的 video 和 audio 元素
>* 本地离线存储 
>* localStorage长期存储数据，浏览器关闭后数据不丢失；
>* sessionStorage的数据在浏览器关闭后自动删除
>* 语意化更好的内容元素，比如 article、footer、header、nav、section
>* 表单控件，calendar、date、time、email、url、search
>* 新的技术webworker, websockt, Geolocation
### 移除的元素
>* 纯表现的元素：basefont，big，center，font, s，strike，tt，u；
>* 对可用性产生负面影响的元素：frame，frameset，noframes；

## 如何处理HTML5新标签的浏览器兼容问题？
>* IE8/IE7/IE6支持通过document.createElement方法产生的标签，
>* 可以利用这一特性让这些浏览器支持HTML5新标签，
>* 浏览器支持新标签后，还需要添加标签默认的样式：


## 请描述一下 cookies，sessionStorage 和 localStorage 的区别？
>* cookie在浏览器和服务器间来回传递。 
>* sessionStorage和localStorage不会
>* sessionStorage和localStorage的存储空间更大；
>* sessionStorage和localStorage有更多丰富易用的接口；
>* sessionStorage和localStorage各自独立的存储空间


