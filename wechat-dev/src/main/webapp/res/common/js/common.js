(function (){
    var window_width = $(window).width(); //��ȡ�������ʾ����Ŀ��
    var img_width = (window_width-50)/3-10; //��ȡͼƬ�Ŀ��
    var $img_list =  $('.img-wrap .img-list');
    $img_list.css('height',img_width);
    $('.img-wrap .add-img-wrap').css('height',img_width);
//    ���Сͼ ������ͼ
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
        var gallery = mui('.mui-slider');//���slider�������
        gallery.slider({}).gotoItem(index_num,0);//��ת����Ӧ��ͼƬ
    });
    $big_img.on('click', function(){
        $big_img.fadeOut(200);
        //$big_img.find('.mui-slider-group').empty();
    });
    //���ɾ��ͼƬ
    $(document).on('click', '.img-wrap .img-list .close-img', function (){
        $(this).parent().remove();
        return false;
    })
}());
