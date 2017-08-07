//p2commonuser






$(document).ready(function() {

    var commitbookname=null;
    var p2bookbookname=null;
    var p2bookbookprice=null;


    $("#changejavafx2").click(function() {

        app.javasalershow();

    });
    $("#changejavafx1").click(function() {

        app.javafxshow();

    });
    window.checkbox= function checkbox()
    {
        var allprice=0;

        var bookname = $("#cartcheck1").parent().children("p").html();
        var bookprice = $("#cartcheck1").parent().parent().next().children("span").children("span").html();
        var bookname2 = $("#cartcheck2").parent().children("p").html();
        var bookprice2 = $("#cartcheck2").parent().parent().next().children("span").children("span").html();
        var bookname3 = $("#cartcheck3").parent().children("p").html();
        var bookprice3 = $("#cartcheck3").parent().parent().next().children("span").children("span").html();
        if (document.getElementById("cartcheckall").checked) {
            document.getElementById("cartcheck1").checked = true;
            document.getElementById("cartcheck2").checked = true;
            document.getElementById("cartcheck3").checked = true;
            allprice=parseFloat(bookprice)+parseFloat(bookprice2)+parseFloat(bookprice3);
        }
        else
        {
            document.getElementById("cartcheck1").checked = false;
            document.getElementById("cartcheck2").checked = false;
            document.getElementById("cartcheck3").checked = false;
            allprice=0;
        }
        allprice= allprice.toFixed(2);
        $(".cartbookallprice").html(allprice );

    }
   window.checkbox1= function checkbox1()
    {
        var allprice=0;


        var bookprice = $("#cartcheck1").parent().parent().next().children("span").children("span").html();

        var bookprice2 = $("#cartcheck2").parent().parent().next().children("span").children("span").html();

        var bookprice3 = $("#cartcheck3").parent().parent().next().children("span").children("span").html();


            if(document.getElementById("cartcheck1").checked==true)
            {
                allprice+=parseFloat(bookprice);
            }


            if( document.getElementById("cartcheck2").checked==true)
            {
                allprice+=parseFloat(bookprice2);
            }

            if( document.getElementById("cartcheck3").checked==true)
            {
                allprice+=parseFloat(bookprice3);
            }



        allprice= allprice.toFixed(2);
        $(".cartbookallprice").html(allprice );

    }
    window.p2ordercheckbox=function p2ordercheckbox()
    {

        if (document.getElementById("ordercheckall").checked) {
            document.getElementById("ordercheck1").checked = true;
            document.getElementById("ordercheck2").checked = true;
            document.getElementById("ordercheck3").checked = true;
            document.getElementById("ordercheck4").checked = true;
        }
        else
        {
            document.getElementById("ordercheck1").checked = false;
            document.getElementById("ordercheck2").checked = false;
            document.getElementById("ordercheck3").checked = false;
            document.getElementById("ordercheck4").checked = false;
        }
    }
    var imgindex=1;
    $(".left").click(function() {
        var lastimgclass="#img"+imgindex;
        $(lastimgclass).removeClass("imgactive");
        $(lastimgclass).addClass("imgnotactive");
        imgindex-=1;
        if(imgindex<1)
            imgindex=6;
        var img=' <img src="img/book'+imgindex+'.jpg" alt=""/>';
        $(".bookshowimg").html(img);
        var imgclass="#img"+imgindex;


        $(imgclass).removeClass("imgnotactive");
        $(imgclass).addClass("imgactive");

    });
    $(".right").click(function() {

        var lastimgclass="#img"+imgindex;
        $(lastimgclass).removeClass("imgactive");
        $(lastimgclass).addClass("imgnotactive");
        imgindex+=1;
        if(imgindex>6)
            imgindex=1;
        var img=' <img src="img/book'+imgindex+'.jpg" alt=""/>';
        $(".bookshowimg").html(img);
        var imgclass="#img"+imgindex;

        $(imgclass).removeClass("imgnotactive");
        $(imgclass).addClass("imgactive");

    });
    $(".addcart").click(function() {
        obj = $(this).parent().parent();
        var bookname=obj.children("h3").html();
        var bookprice=obj.children("p").children("span").html();


      app.addcart(bookname,bookprice);
    });
    $(".buy").click(function() {

        obj = $(this).parent().parent();
        var bookname=obj.children("h3").html();
        var bookprice=obj.children("p").children("span").html();


        app.addorder(bookname,bookprice);

    });

    $(".bookaddcart").click(function() {
        obj = $(this).parent();
        var bookname=obj.children("h2").html();
        var bookprice=obj.children("h3").children("i").html();


        app.addcart(bookname,bookprice);
    });
    $(".bookbuy").click(function() {
        obj = $(this).parent();
        var bookname=obj.children("h2").html();
        var bookprice=obj.children("h3").children("i").html();


        app.addorder(bookname,bookprice);
    });


    lookbook();
    function lookbook(){

        $(".searchresult").show();

        var bookresult=app.lookbook();
        bookresult=eval ("(" + bookresult + ")");


        for(var i=0;i<bookresult.bookname.length;i++)
        {
            var bookname= bookresult.bookname[i].bookname;
            var bookprice= bookresult.bookprice[i].bookprice;
            var booknameclass=".bookname"+i;
            var bookpriceclass=".bookprice"+i;
            $(booknameclass).html(bookname);
            $(bookpriceclass).html(bookprice);
        }
        for(var i=bookresult.bookname.length;i<=17;i++)
        {var booknameclass=".bookname"+i;
            $(booknameclass).parent().parent().hide();
        }

    }

  //  $(".searchresult").hide();
    window.search=function search()
    {
        var bookname=document.getElementById("searchbookname").value;


        var bookresult=app.commonsearch(bookname);

        bookresult=eval ("(" + bookresult + ")");
           document.getElementById("searchresultnumber").innerHTML=bookresult.bookname.length;
        $(".searchresult").show();


         for(var i=0;i<bookresult.bookname.length;i++)
        {

           var bookname= bookresult.bookname[i].bookname;
            var booknameclass=".bookname"+i;
            var bookprice= bookresult.bookprice[i].bookprice;
            var bookpriceclass=".bookprice"+i;

            $(booknameclass).html(bookname);
            $(bookpriceclass).html(bookprice);

      }
        for(var i=bookresult.bookname.length;i<=17;i++)
        {var booknameclass=".bookname"+i;
            $(booknameclass).parent().parent().hide();
        }
    }


    window.balance=function balance() {

        var jsonObj2 = {
            book: [


            ]
        };

        var c1 = "false", c2 = "false", c3 = "false", c4 = "false", c5 = "false";
        if (document.getElementById("cartcheckall").checked) {
            document.getElementById("cartcheck1").checked=true;
            c1 = "true", c2 = "true", c3 = "true";
            var bookname = $("#cartcheck1").parent().children("p").html();
            var bookprice = $("#cartcheck1").parent().parent().next().children("span").children("span").html();
            var bookname2 = $("#cartcheck2").parent().children("p").html();
            var bookprice2 = $("#cartcheck2").parent().parent().next().children("span").children("span").html();
            var bookname3 = $("#cartcheck3").parent().children("p").html();
            var bookprice3 = $("#cartcheck3").parent().parent().next().children("span").children("span").html();
            var book = {name: bookname,price:bookprice};
            var book2 = {name: bookname2,price:bookprice2};
            var book3 = {name: bookname3,price:bookprice3};
            jsonObj2.book.push(book);
            jsonObj2.book.push(book2);
            jsonObj2.book.push(book3);

        }
        else {

            if (document.getElementById("cartcheck1").checked) {
                c1 = "true";
                var bookname = $("#cartcheck1").parent().children("p").html();
                var bookprice = $("#cartcheck1").parent().parent().next().children("span").children("span").html();


                var book = {name: bookname,price:bookprice};
                jsonObj2.book.push(book);

            }
            if (document.getElementById("cartcheck2").checked) {
                c2 = "true";
                var bookname = $("#cartcheck2").parent().children("p").html();
                var bookprice = $("#cartcheck2").parent().parent().next().children("span").children("span").html();
                var book = {name: bookname,price:bookprice};

                jsonObj2.book.push(book);
            }
            if (document.getElementById("cartcheck3").checked) {
                c3 = "true";
                var bookname = $("#cartcheck3").parent().children("p").html();
                var bookprice = $("#cartcheck3").parent().parent().next().children("span").children("span").html();
                var book = {name: bookname,price:bookprice};

                jsonObj2.book.push(book);
            }

        }



        var persons = jsonObj2.book;
        for (var i = 0; i < persons.length; i++) {
            var cur_person = persons[i];
            //alert(cur_person.name);
            app.addorder(cur_person.name,cur_person.price);
        }


    }
  window.p2loadcart=function p2loadcart()
  {
     var cartlist=app.loadcart();
      cartlist=eval ("(" + cartlist + ")");
        var allprice=0;
      for(var i=0;i<3;i++)
      {
          var bookname= cartlist.bookname[i].bookname;
          var booknameclass=".cartbookname"+i;
          var bookprice= cartlist.bookprice[i].bookprice;
          var bookpriceclass=".cartbookprice"+i;
          allprice+=parseFloat(bookprice)
          $(booknameclass).html(bookname);
          $(bookpriceclass).html(bookprice);


      }
      allprice= allprice.toFixed(2);

      $(".cartbookallprice").html(allprice );

  }
    window.p2loadorder= function p2loadorder()
    {
        var orderlist=app.loadorder();

        orderlist=eval ("(" + orderlist + ")");
     //   {"bookname":[{"bookname":"Java程序设计第7版"},{"bookname":"Java程序设计第7版"},{"bookname":"123"},{"bookname":"123"}],"bookprice":[{"bookprice":null},{"bookprice":null},{"bookprice":null},{"bookprice":null}]}
        for(var i=0;i<orderlist.bookname.length;i++)
        {
            var bookname= orderlist.bookname[i].bookname;
            var booknameclass=".orderbookname"+i;
            var bookprice= orderlist.bookprice[i].bookprice;
            var bookpriceclass=".orderbookprice"+i;

            $(booknameclass).html(bookname);
            $(bookpriceclass).html(bookprice);


        }


    }


    window.putcommit= function putcommit()
    {

       var commit=  document.getElementById("publishcommit").value;

        if(app.putcommit(commit,commitbookname))
        {
            document.getElementById("register1").innerHTML="发表成功";
            document.getElementById("register2").innerHTML="发表成功";
            myshow();
        }
        else
        {
            document.getElementById("register1").innerHTML="发表失败";
            document.getElementById("register2").innerHTML="发表失败";
            myshow();
        }



    }
    window.loadbook= function loadbook()
    {


           var obj = $(".bookaddcart").parent();
             obj.children("h2").html(p2bookbookname);
             obj.children("h3").children("i").html(p2bookbookprice);
       var commmitlist=app.loadcommit(p2bookbookname);
       // var commmitlist={"commit":[{"commit":"123"},{"commit":"123"}]}
        commmitlist=eval ("(" + commmitlist + ")");
        for(var i=0;i<commmitlist.commit.length;i++)
        {

            var commmitsay= commmitlist.commit[i].commit;
            var commitclass=".commit"+i;

            $(commitclass).html(commmitsay);



        }


        }








        $('.dropdown-toggle').dropdown();




//p2book




    $(".bookdetail ").click(function(){

        $(".bookdetail ").addClass("active");

        $(".profile ").removeClass("active");
        $(".commit ").removeClass("active");
        $(".nav-cont1").show();
        $(".nav-cont2").hide();
        $(".nav-cont3").hide();
    });
    $(".profile ").click(function(){


        $(".bookdetail ").removeClass("active");
        $(".commit ").removeClass("active");
        $(".profile ").addClass("active");
        $(".nav-cont1").hide();
        $(".nav-cont2").show();
        $(".nav-cont3").hide();
    });
    $(".commit ").click(function(){
        $(".bookdetail ").removeClass("active");
        $(".profile ").removeClass("active");
        $(".commit ").addClass("active");
        $(".nav-cont1").hide();
        $(".nav-cont2").hide();
        $(".nav-cont3").show();
    });






//p2cart




//p2order




//p2index




    $(".top2index").click(function(){
       lookbook();
        $(".p2commonuser").show();
        $(".p2book").hide();
        $(".p2order").hide();
        $(".p2cart").hide();
        $(".p2commit").hide();

        $(".p1").hide();
    });
    $(".top2cart").click(function(){
        p2loadcart();
        $(".p2commonuser").hide();
        $(".p2book").hide();
        $(".p2order").hide();
        $(".p2cart").show();
        $(".p2commit").hide();

        $(".p1").hide();

    });
    $(".top2order").click(function(){
       p2loadorder();
        $(".p2commonuser").hide();
        $(".p2book").hide();
        $(".p2order").show();
        $(".p2cart").hide();
        $(".p2commit").hide();

        $(".p1").hide();

    });

    $(".top2book").click(function(){
        p2bookbookname= $(this).parent().children(".book1").children("h3").html();
         p2bookbookprice= $(this).parent().children(".book1").children("p").children("span").html();
        loadbook();
        $(".p2commonuser").hide();
        $(".p2book").show();
        $(".p2order").hide();
        $(".p2cart").hide();
        $(".p2commit").hide();

        $(".p1").hide();

    });
    $(".top2commit").click(function(){
        commitbookname=$(this).parent().children(".media").children(".media-body").children(".media-heading").html();

        $(".p2commonuser").hide();
        $(".p2book").hide();
        $(".p2order").hide();
        $(".p2cart").hide();
        $(".p2commit").show();

        $(".p1").hide();

    });

    $(".tologin").click(function(){

        $(".p2").hide();
        $(".p3").hide();
        $(".p4").hide();
        $(".p1").show();

    });

});

/*
 document.getElementById("searchresultnumber").innerHTML=bookresult.bookname[i].bookname;

 document.getElementById("booklist").innerHTML
 +=' <div class="col-sm-3 col-md-2"> <div class="thumbnail"> <a class="top2book"> <img src="img/book1.jpg" alt="..."></a> <div class="caption"> <h3 >' +
 bookresult.bookname[i].bookname +
 '</h3> <p >￥<sapn >' +
 bookresult.bookprice[i].bookprice +
 '<sapn ></p> <p ><a  class="btn btn-primary addcart" role="button" >加入购物车</a> <a  class="btn btn-default buy" role="button" >购买</a></p> </div> </div> </div>';


 document.getElementById("searchresultnumber").innerHTML=bookresult.bookname.length;
 var bookname= bookresult.bookname[i].bookname;
 var bookprice=bookresult.bookprice[i].bookprice;
 booklist.child("h3").html(bookname);
 booklist.child("p").child("span").html(bookprice);
 booklist=booklist.parent().parent().next().child().child(".book1");
 }
 */