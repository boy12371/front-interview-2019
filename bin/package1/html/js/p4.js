/**
 * Created by HeroZhou on 2017/2/24.
 */
$(document).ready(function() {
    p4loaduser();

    $("#mannageuser").click(function(){
        p4loaduser();
        $(".mannageuser").show();
        $(".mannagemessage").hide();


    });
    $("#mannagemessage").click(function(){
        p4loadmessage();
        $(".mannageuser").hide();
        $(".mannagemessage").show();
    });

    window.p4loadmessage= function p4loadmessage() {
        var messagelist = app.loadmessage();

        messagelist = eval("(" + messagelist + ")");

        for (var i = 0; i < messagelist.messagesay.length; i++) {
            var messagehead = messagelist.messagesay[i].messagesay;
            var messageheadclass = ".p4messagehead" + i;
            var messagesay = messagelist.messagesay[i].messagesay;

            var messagesayclass = ".p4messagesay" + i;
            var messagehuifuheadclass = ".p4messagehuifuhead" + i;
            var messagehuifusayclass = ".p4messagehuifusay" + i;
            $(messageheadclass).html(messagehead);
            $(messagesayclass).html(messagesay);
            $(messagehuifuheadclass).html(messagehead);
            $(messagehuifusayclass).html(messagesay);
        }
    }
        window.p4loaduser= function p4loaduser()
        {
            var userlist=app.loaduser();

            userlist=eval ("(" + userlist + ")");

            for(var i=0;i<userlist.username.length;i++)
            {
                var username= userlist.username[i].username;
                var usernameclass=".p4username"+i;
                var uservary= userlist.uservary[i].uservary;
                var uservaryclass=".uservary"+i;
                $(usernameclass).html(username);
                $(uservaryclass).html(uservary);
            }
        }

    $(".delectmessage").click(function(){
       $(this).parent().parent().parent().parent().hide();
     var messagehead=  $(this).parent().parent().parent().children(".media-body").children("h4").html();
        app.delectmessage(messagehead);
    });
    $(".delectuser").click(function(){
        $(this).parent().parent().hide();
        var username=  $(this).parent().parent().children().children(".media").children(".media-body").children("h4").html();
        app.delectuser(username);
    });

});