$(function(){
	//设置左侧主题内容高度
	resetHeight();
	$(window).resize(function(){
		resetHeight()
	});
	//新增
	$('.cv_add').click(function(){
		$(this).next().removeClass('hide');
	});
	
	$('.cv_cont').find('.cv_btn').click(function(){
		var cont=$(this).parents('.cv_cont'),
			add=cont.siblings('.cv_add'),
			otherAdd=cont.parents('.cv_box').find('.cv_addBtn');
		if(add.length){
			if($(this).hasClass('blue')){
				if(otherAdd.hasClass('hide')){
					add.addClass('hide');
					otherAdd.removeClass('hide');
				}
				cont.addClass('hide');
			}else if($(this).hasClass('gray')){
				return;
			}else{
				add.removeClass('hide');
				otherAdd.addClass('hide');
				cont.addClass('hide');
			}
			
		}
	});
	$('.cv_addBtn').bind('click',function(){
		$(this).parents('.cv_box').find('.cv_cont').removeClass('hide');;
	});
	//右侧导航事件
	$('.cv_nav a').click(function(){
		var index=$(this).attr('data-index'),
			wrap=$('.cv_wrap'),
			scrollto=wrap.children('.cv_box').eq(index),
			top=scrollto.offset().top-wrap.offset().top+wrap.scrollTop();
		$(this).addClass('active').parent().siblings().children().removeClass('active');
		wrap.animate({scrollTop:top});
	});
});

function resetHeight(){
	var contHeight=$(window).height()-96-15;
	$('.cv_wrap').height(contHeight);
}
