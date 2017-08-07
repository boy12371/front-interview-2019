/**
 * Created by HeroZhou on 2017/2/24.
 */
$(document).ready(function() {
    p3loadorder();
    var messagebookname=null;
    $("#lookorder").click(function(){
        p3loadorder();
        $(".lookorder").show();
        $(".lookleave").hide();
        $(".lookmessage").hide();
        $(".pmessage").hide();
    });
    $("#lookleave").click(function(){
        p3loadleave();
        $(".lookorder").hide();
        $(".lookleave").show();
        $(".lookmessage").hide();
        $(".pmessage").hide();
    });
    $("#lookmessage").click(function(){
        p3loadmessage();
        $(".lookorder").hide();
        $(".lookleave").hide();
        $(".lookmessage").show();
        $(".pmessage").hide();
    });
    $("#pmessage").click(function(){
        $(".lookorder").hide();
        $(".lookleave").hide();
        $(".lookmessage").hide();
        $(".pmessage").show();
    });

    window.p3loadorder= function p3loadorder()
    {
        var orderlist=app.loadorder();

        orderlist=eval ("(" + orderlist + ")");

        for(var i=0;i<orderlist.bookname.length;i++)
        {
            var bookname= orderlist.bookname[i].bookname;
            var booknameclass=".p3orderbookname"+i;
            var bookprice= orderlist.bookprice[i].bookprice;
            var bookpriceclass=".p3orderbookprice"+i;

            $(booknameclass).html(bookname);
            $(bookpriceclass).html(bookprice);


        }


    }
    window.p3loadleave= function p3loadleave()
    {
        var leavelist=app.loadleave();

        leavelist=eval ("(" + leavelist + ")");

        for(var i=0;i<leavelist.bookname.length;i++)
        {
            var bookname= leavelist.bookname[i].bookname;
            var booknameclass=".p3leavebookname"+i;
            var bookprice= leavelist.bookprice[i].bookprice;
            var bookleave= leavelist.bookleave[i].bookleave;
            var booksale= leavelist.booksale[i].booksale;
            var bookpriceclass=".p3leavebookprice"+i;
            var bookleaveclass=".p3leavebookleave"+i;
            var booksaleclass=".p3leavebooksale"+i;

            $(bookleaveclass).parent().removeClass("danger");
            $(bookleaveclass).parent().removeClass("success");
            if(parseInt(bookleave)<=100)
            {
                bookleave+="(库存不足，请尽快补货)";
                $(bookleaveclass).parent().addClass("danger");
            }
            if(parseInt(bookleave)>=1000)
            {
                bookleave+="(库存充足)";
                $(bookleaveclass).parent().addClass("success");
            }
            if(parseInt(booksale)>=1000)
                booksale+="(销量冠军)";

            $(booknameclass).html(bookname);
            $(bookpriceclass).html(bookprice);
            $(bookleaveclass).html(bookleave);
            $(booksaleclass).html(booksale);

        }


    }
    window.p3loadmessage= function p3loadmessage()
    {
        var messagelist=app.loadmessage();

        messagelist=eval ("(" + messagelist + ")");

        for(var i=0;i<messagelist.messagesay.length;i++)
        {
            var messagehead= messagelist.messagesay[i].messagesay;
            var messageheadclass=".p3messagehead"+i;
            var messagesay= messagelist.messagesay[i].messagesay;

            var messagesayclass=".p3messagesay"+i;
            var messagehuifuheadclass=".p3messagehuifuhead"+i;
            var messagehuifusayclass=".p3messagehuifusay"+i;
            $(messageheadclass).html(messagehead);
            $(messagesayclass).html(messagesay);
            $(messagehuifuheadclass).html(messagehead);
            $(messagehuifusayclass).html(messagesay);
        }


    }


    window.p3putmessage= function p3putmessage()
    {

        var message=  document.getElementById("publishmessage").value;

        if(app.putmessage(message))
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
    window.p3ordercheckbox=function p3ordercheckbox()
    {

        if (document.getElementById("p3ordercheckall").checked) {
            document.getElementById("p3ordercheck1").checked = true;
            document.getElementById("p3ordercheck2").checked = true;
            document.getElementById("p3ordercheck3").checked = true;
            document.getElementById("p3ordercheck4").checked = true;
        }
        else
        {
            document.getElementById("p3ordercheck1").checked = false;
            document.getElementById("p3ordercheck2").checked = false;
            document.getElementById("p3ordercheck3").checked = false;
            document.getElementById("p3ordercheck4").checked = false;
        }
    }
});