<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no">
    <title>预约</title>
    <link href="${rc.contextPath}/res/common/css/mui.min.css" rel="stylesheet"/>
    <link href="${rc.contextPath}/res/common/css/common.css" rel="stylesheet"/>
    <link href="${rc.contextPath}/res/css/order.css" rel="stylesheet"/>
</head>
<body>
<div class="content">
    <h4 class="text-c">预约验房</h4>
    <p>&nbsp;请输入您的房屋信息</p>
    <div class="order-inf">
        <div class="inf-list md-box">
            <select id="city" class="mar-r10" name="">
                <option value="成都市">成都市</option>
            </select>
            <select name="" id="district" class="md-f1">
                <option value="锦江区">锦江区</option>
                <option value="武侯区">武侯区</option>
                <option value="成华区">成华区</option>
                <option value="金牛区">金牛区</option>
                <option value="青羊区">青羊区</option>
                <option value="温江区">温江区</option>
                <option value="新都区">新都区</option>
                <option value="青白江区">青白江区</option>
                <option value="龙泉驿区">龙泉驿区</option>
            </select>
        </div>
        <div class="inf-list md-box">
            <select name="" id="bedRoom" class="mar-r10">
                <option value="3房">3房</option>
                <option value="2房">2房</option>
                <option value="1房">1房</option>
            </select>
            <select name="" id="livingRoom" class="mar-r10">
                <option value="1厅">1厅</option>
                <option value="2厅">2厅</option>
                <option value="0厅">0厅</option>
            </select>
            <select name="" id="kitchen" class="md-f1">
                <option value="1厨">1厨</option>
                <option value="2厨">2厨</option>
                <option value="0厨">0厨</option>
            </select>
        </div>
        <div class="inf-list md-box">
            <select name="" id="toilet" class="mar-r10">
                <option value="2卫">2卫</option>
                <option value="1卫">1卫</option>
                <option value="0卫">0卫</option>
            </select>
            <select name="" id="balcony" class="mar-r10">
                <option value="2阳台">2阳台</option>
                <option value="1阳台">1阳台</option>
                <option value="0阳台">0阳台</option>
            </select>
            <div class="md-f1">
                <input class="order-input" id="coveredArea" type="text" placeholder="建筑面积"/> <span>㎡</span>
            </div>
        </div>
        <div class="inf-list">
            <input  type="text" id="housesName" class="order-input" placeholder="您的楼盘名称"/>
        </div>
        <div class="inf-list">
            <input type="number" id="contactNumber" class="order-input" placeholder="您的手机号"/>
        </div>
    </div>
    <div class="btn bg-main order-btn">提交申请</div>
    <p>1、验房的工长是专业的，并且是免费的。</p>
    <p>2、您的房屋信息和联系方式是保密的。</p>
    <p>3、验房完成，分享验房报告是有奖励的。</p>
</div>
<script src="${rc.contextPath}/res/common/js/mui.min.js"></script>
<script> mui.init();</script>
<script src="${rc.contextPath}/res/common/js/jquery.min-1.8.3.js"></script>
<script>
    $(document).on('click', '.order-btn', function(){
        var city = $('#city').val(),
                district = $('#district').val(),
                bedRoom = $('#bedRoom').val(),
                livingRoom = $('#livingRoom').val(),
                kitchen = $('#kitchen').val(),
                toilet = $('#toilet').val(),
                balcony = $('#balcony').val(),
                coveredArea = $('#coveredArea').val(),
                housesName = $('#housesName').val(),
                contactNumber = $('#contactNumber').val();
        if (!/^[1][0-9]{10}$/.test(contactNumber)) {
            mui.alert("请输入正确的十一位手机号码！");
            return;
        }
        var order_inf = {
            'city':city,
            'district':district,
           	'bedRoom':bedRoom,
            'livingRoom':livingRoom,
            'kitchen':kitchen,
            'toilet':toilet,
            'balcony':balcony,
            'coveredArea':coveredArea,
            'housesName':housesName,
            'contactNumber':contactNumber
        };
//		console.log(order_inf);
        $.ajax({
            url: "http://www.octlr.com/wechat/addHouse?",
            dataType: "json",   //返回格式为json
            data: order_inf,    //参数值
            type: "post",   //请求方式
            success: function(data) {
				console.log(data);
                if(data.result==1){
                    alert('成功!');
                    setTimeout("window.location.href='${rc.contextPath}/d/page/order_success';",2000);
//                    window.location.href='${rc.contextPath}/d/page/order_success';
                }
                if(data.result==0){
                    console.log(data);
//					mui.alert();
                }
            },
            error: function() {
                mui.alert("服务器很忙");//请求出错处理
            }
        });
    });
</script>
</body>
</html>