<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <title>预约成功</title>
    <link href="${rc.contextPath}/res/common/css/mui.min.css" rel="stylesheet"/>
    <link href="${rc.contextPath}/res/common/css/common.css" rel="stylesheet"/>
    <link href="${rc.contextPath}/res/css/order.css" rel="stylesheet"/>
</head>
<body>
<div class="content">
    <h4 class="text-c">预约成功</h4><br/>
    <p>恭喜您，您的预约申请已成功提交，我们的客服人员会在 <span class="color-jh font-900">2</span> 个小时内与您联系，请保持您的通信畅通。</p>
    <p>您也可以直接拨打
        <span class="color-main font-900">400-1234-5678</span>
        <a href="tel:13764567708" class="dial"></a>
        与我们的客服人员直接取得联系。
    </p>
    <p>您的预约号为：<span class="color-jh font-900">46384</span></p>
</div>
<div class="btn bg-main over-btn">完成</div>
<script src="${rc.contextPath}/res/common/js/mui.min.js"></script>
<script> mui.init();</script>
<script>
    document.querySelector('.over-btn').onclick = function(){
    	window.location.href='${rc.contextPath}/d/page/user_center';
    }
</script>
</body>
</html>