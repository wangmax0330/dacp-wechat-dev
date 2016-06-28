<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>评论</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <link href="${rc.contextPath}/res/common/css/mui.min.css" rel="stylesheet"/>
    <link href="${rc.contextPath}/res/common/css/common.css" rel="stylesheet" />
    <link href="${rc.contextPath}/res/css/comment.css" rel="stylesheet" />
</head>
<body>
<div class="content">
    <div class="comment-wrap">
        <div class="mar-b10">水电及隐蔽阶段完工评价</div>
        <div class="worker-list md-box">
            <div class="">
                <div class="head-img">
                    <img src="${rc.contextPath}/res/images/project_manage/head_img.png" alt=""/>
                </div>
            </div>
            <div class="post-stars md-f1">
                <div class="s-post">
                    <span>工长</span>
                    <span>张小三</span>
                </div>
                <div class="stars">
                    <img src="${rc.contextPath}/res/images/comment/star_gray.png"/>
                    <img src="${rc.contextPath}/res/images/comment/star_gray.png"/>
                    <img src="${rc.contextPath}/res/images/comment/star_gray.png"/>
                    <img src="${rc.contextPath}/res/images/comment/star_gray.png"/>
                    <img src="${rc.contextPath}/res/images/comment/star_gray.png"/>
                </div>
            </div>
        </div>
        <div class="worker-list md-box">
            <div class="">
                <div class="head-img">
                    <img src="${rc.contextPath}/res/images/project_manage/head_img.png" alt=""/>
                </div>
            </div>
            <div class="post-stars md-f1">
                <div class="s-post">
                    <span>工长</span>
                    <span>张小三</span>
                </div>
                <div class="stars">
                    <img src="${rc.contextPath}/res/images/comment/star_gray.png"/>
                    <img src="${rc.contextPath}/res/images/comment/star_gray.png"/>
                    <img src="${rc.contextPath}/res/images/comment/star_gray.png"/>
                    <img src="${rc.contextPath}/res/images/comment/star_gray.png"/>
                    <img src="${rc.contextPath}/res/images/comment/star_gray.png"/>
                </div>
            </div>
        </div>
        <div class="worker-list md-box">
            <div class="">
                <div class="head-img">
                    <img src="${rc.contextPath}/res/images/project_manage/head_img.png" alt=""/>
                </div>
            </div>
            <div class="post-stars md-f1">
                <div class="s-post">
                    <span>工长</span>
                    <span>张小三</span>
                </div>
                <div class="stars">
                    <img src="${rc.contextPath}/res/images/comment/star_gray.png"/>
                    <img src="${rc.contextPath}/res/images/comment/star_gray.png"/>
                    <img src="${rc.contextPath}/res/images/comment/star_gray.png"/>
                    <img src="${rc.contextPath}/res/images/comment/star_gray.png"/>
                    <img src="${rc.contextPath}/res/images/comment/star_gray.png"/>
                </div>
            </div>
        </div>
    </div>
    <div class="">
        <textarea name="" id="" cols="30" rows="5" placeholder="请输入您的评价，这对我们很重要"></textarea>
    </div>
    <div class="btn bg-main">提交</div>
    <p class="color-main">您的评价对我们和工人很重要，请谨慎给出评价，谢谢！</p>
</div>
<script src="${rc.contextPath}/res/common/js/mui.min.js"></script>
<script> mui.init();</script>
<script src="${rc.contextPath}/res/common/js/jquery.min-1.8.3.js"></script>
<script>
    $(function() {
        //定义悬浮每行各个星星图片
        var stars = [
            ['star_smile.png', 'star_gray.png', 'star_gray.png', 'star_gray.png', 'star_gray.png'],
            ['star_smile.png', 'star_smile.png', 'star_gray.png', 'star_gray.png', 'star_gray.png'],
            ['star_smile.png', 'star_smile.png', 'star_smile.png', 'star_gray.png', 'star_gray.png'],
            ['star_smile.png', 'star_smile.png', 'star_smile.png', 'star_smile.png', 'star_gray.png'],
            ['star_smile.png', 'star_smile.png', 'star_smile.png', 'star_smile.png', 'star_smile.png']
        ];
        $(".worker-list .stars").find("img").hover(function() { //星星悬浮触发
            var obj = $(this);//当前对象
            var star_area = obj.parent(".stars"); //当前父级.stars
            var index = star_area.find("img").index(obj);//当前星星索引
            console.log(index);
            for (var i = 0; i < 5; i++) {
                star_area.find("img").eq(i).attr("src", "${rc.contextPath}/res/images/comment/" + stars[index][i]);//切换每个星星
            }
        }, function() { //鼠标离开星星
            var obj = $(this);//当前对象
            var star_area = obj.parent(".stars");//当前父级.stars
            var index = star_area.attr("data-default-index");//点击后的索引
            if (index >= 0) { //若该行点击后的索引大于等于0，说明该行星星已被点击
                for (var i = 0; i < 5; i++) {
                    star_area.find("img").eq(i).attr("src", "${rc.contextPath}/res/images/comment/" + stars[index][i]);//更新该行星星
                }
            } else {
                var obj = $(this);
                var star_area = obj.parent(".stars");
                for (var i = 0; i < 5; i++) {
                    star_area.find("img").eq(i).attr("src", "${rc.contextPath}/res/images/comment/star_gray.png");//更新该行星星都变初始状态
                }
            }
        })
        $(".worker-list .stars").find("img").click(function() { //当点击每颗星星
            var obj = $(this);//当前对象
            var star_area = obj.parent(".stars"); //当前父级.stars
            var index = obj.parent(".stars").find("img").index($(this));//当前星星索引
            star_area.attr("data-default-index", index);//记录点击后的索引，用来鼠标移出星星后，获取之前点击后的星星索引
        })
    })
</script>
</body>
</html>

