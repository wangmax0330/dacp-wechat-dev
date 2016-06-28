(function (){
    var window_width = $(window).width(); //获取浏览器显示区域的宽度
    var img_width = (window_width-50)/3-10; //获取图片的宽度
    var $img_list =  $('.img-wrap .img-list');
    $img_list.css('height',img_width);
    $('.img-wrap .add-img-wrap').css('height',img_width);
//    点击小图 弹出大图
    var $big_img = $("#big_img");
    $(".img-list img").on('click', function(){
        var $img_list = $(this).parent().parent('.img-wrap').find('.img-list');
        var img_list_length = $img_list.length;
//            console.log(img_list_length);
        var index_num = $img_list.index($(this).parent());
        var src = $(this).attr("src");
        var slider_str = '';
        for(var i=0; i<img_list_length; i++){
            slider_str += '<div class="mui-slider-item"><img src='+$img_list.eq(i).find('img').attr("src")+' /></div>'
        }
        $big_img.find('.mui-slider-group').append(slider_str);
        $big_img.fadeIn(200);
        var gallery = mui('.mui-slider');//获得slider插件对象
        gallery.slider({}).gotoItem(index_num,0);//跳转到对应的图片
    });
    $big_img.on('click', function(){
        $big_img.fadeOut(200);
        //$big_img.find('.mui-slider-group').empty();
    });
    //点击删除图片
    $(document).on('click', '.img-wrap .img-list .close-img', function (){
        $(this).parent().remove();
        return false;
    })
}());
